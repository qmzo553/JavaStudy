package webserver;

import lombok.extern.slf4j.Slf4j;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;

@Slf4j
public class HttpResponse {

    private DataOutputStream dos;
    private OutputStream out;

    public HttpResponse(OutputStream out) {
        this.out = out;
        this.dos = new DataOutputStream(out);
    }

    public void addHeader(String name, String value) {

    }

    public void forward(String url) throws IOException {
        byte[] body = Files.readAllBytes(new File("./webapp" + url).toPath());
        if (url.endsWith(".css")) {
            response200CssHeader(body.length);

        } else {
            response200Header(body.length);
        }

        responseBody(body);
    }

    public void sendRedirect(String url) throws IOException {
        response302Header(url);
        responseResource(url);
    }

    private void response200Header(int lengthOfBodyContent) {
        try {
            dos.writeBytes("HTTP/1.1 200 OK \r\n");
            dos.writeBytes("Content-Type: text/html;charset=utf-8\r\n");
            dos.writeBytes("Content-Length: " + lengthOfBodyContent + "\r\n");
            dos.writeBytes("\r\n");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void response200CssHeader(int lengthOfBodyContent) {
        try {
            dos.writeBytes("HTTP/1.1 200 OK \r\n");
            dos.writeBytes("Content-Type: text/css \r\n");
            dos.writeBytes("Content-Length: " + lengthOfBodyContent + "\r\n");
            dos.writeBytes("\r\n");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void response302Header(String url) {
        try {
            dos.writeBytes("HTTP/1.1 302 Redirect \r\n");
            dos.writeBytes("Location: " + url + "\r\n");
            dos.writeBytes("\r\n");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void responseResource(String url) {
        try {
            byte[] body = Files.readAllBytes(new File("./webapp" + url).toPath());
            response200Header(body.length);
            responseBody(body);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void responseBody(byte[] body) {
        try {
            dos.write(body, 0, body.length);
            dos.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
