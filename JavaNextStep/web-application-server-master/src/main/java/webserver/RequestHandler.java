package webserver;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.User;
import util.HttpRequestUtils;

public class RequestHandler extends Thread {
    Logger log = LogManager.getLogger(this.getClass().getSimpleName());

    private Socket connection;

    public RequestHandler(Socket connectionSocket) {
        this.connection = connectionSocket;
    }

    public void run() {
        log.debug("New Client Connect! Connected IP : {}, Port : {}", connection.getInetAddress(),
                connection.getPort());

        try (InputStream in = connection.getInputStream();
                OutputStream out = connection.getOutputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
            // TODO 사용자 요청에 대한 처리는 이 곳에 구현하면 된다.
            String line = br.readLine();
            if (line == null) {
                return;
            }
            System.out.println(line);

            String[] tokens = line.split(" ");
            String method = tokens[0];
            String request = tokens[1];
            String version = tokens[2];

            if (method.equals("GET")) {
                String path = request;
                String data;

                if (request.contains("?")) {
                    int index = request.indexOf('?');
                    path = request.substring(0, index);
                    data = request.substring(index + 1);

                    Map<String, String> parameters = HttpRequestUtils.parseQueryString(data);
                    User user = new User(
                            parameters.get("userId"),
                            parameters.get("password"),
                            parameters.get("name"),
                            parameters.get("email"));
                }

                byte[] body = Files.readAllBytes(new File("./webapp" + path).toPath());

                DataOutputStream dos = new DataOutputStream(out);
                response200Header(dos, body.length);
                responseBody(dos, body);
            } else if (method.equals("POST")) {
                String path = request;
                Map<String, String> fields = new HashMap<>();

                line = br.readLine();
                while (!"".equals(line)) {
                    String[] requestTokens = line.split(" ");
                    String field = requestTokens[0].substring(0, requestTokens[0].length() - 1);
                    String fileldValue = requestTokens[1];

                    fields.put(field, fileldValue);
                    line = br.readLine();
                }

                line = br.readLine();
                Map<String, String> parameters = HttpRequestUtils.parseQueryString(line);
                    User user = new User(
                            parameters.get("userId"),
                            parameters.get("password"),
                            parameters.get("name"),
                            parameters.get("email"));
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void response200Header(DataOutputStream dos, int lengthOfBodyContent) {
        try {
            dos.writeBytes("HTTP/1.1 200 OK \r\n");
            dos.writeBytes("Content-Type: text/html;charset=utf-8\r\n");
            dos.writeBytes("Content-Length: " + lengthOfBodyContent + "\r\n");
            dos.writeBytes("\r\n");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void responseBody(DataOutputStream dos, byte[] body) {
        try {
            dos.write(body, 0, body.length);
            dos.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
