package webserver;

import lombok.extern.slf4j.Slf4j;
import util.HttpRequestUtils;
import util.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class HttpRequest {

    private InputStream in;
    private String method;
    private String path;
    private Map<String, String> params;
    private Map<String, String> headers;

    public HttpRequest(InputStream in) {
        this.in = in;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(this.in, StandardCharsets.UTF_8))) {
            String line = br.readLine();
            String[] tokens = line.split(" ");
            log.debug("request line : {}", line);
            if (line == null) {
                return;
            }

            method = tokens[0];
            path = tokens[1];

            headers = new HashMap<>();
            if(method.equals("GET")) {
                parseGetRequest(br);
            } else if(method.equals("POST")) {
                parsePostRequest(br);
            }
        } catch(IOException e) {
            log.error(e.getMessage());
        }
    }

    private void parseGetRequest(BufferedReader br) throws IOException {
        int index = path.indexOf("?");
        String query = path.substring(index + 1);
        path = path.substring(0, index);
        params = HttpRequestUtils.parseQueryString(query);

        String line;
        while((line = br.readLine()) != null) {
            log.debug("header line : {}", line);
            HttpRequestUtils.Pair pair = HttpRequestUtils.parseHeader(line);
            headers.put(pair.getKey(), pair.getValue());
        }
    }

    private void parsePostRequest(BufferedReader br) throws IOException {
        StringBuilder requestBuilder = new StringBuilder();
        String line;
        int contentLength = 0;

        while ((line = br.readLine()) != null) {
            log.debug("header line : {}", line);
            requestBuilder.append(line).append("\n");

            if (line.contains("Content-Length")) {
                contentLength = getContentLength(line);
            }

            HttpRequestUtils.Pair pair = HttpRequestUtils.parseHeader(line);
            headers.put(pair.getKey(), pair.getValue());
        }

        String body = IOUtils.readData(br, contentLength);
        requestBuilder.append(body);

        String request = requestBuilder.toString();

        params = HttpRequestUtils.parseQueryString(body);
    }



    public String getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public String getParameter(String key) {
        return params.get(key);
    }

    public String getHeader(String key) {
        return headers.get(key);
    }

    private int getContentLength(String line) {
        String[] headerTokens = line.split(":");
        return Integer.parseInt(headerTokens[1].trim());
    }

}
