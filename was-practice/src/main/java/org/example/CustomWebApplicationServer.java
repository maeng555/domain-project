package org.example;

import org.example.calculator.HttpRequest;
import org.example.calculator.HttpResponse;
import org.example.calculator.domain.Calculator;
import org.example.calculator.domain.PositiveNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class CustomWebApplicationServer {
    private final int port;
    private final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[Server] Started on port [ {}]", port);

            Socket clinetSocket;
            logger.info("[Server] Waiting for client connections");
            while ((clinetSocket = serverSocket.accept()) != null) {
                logger.info("[Server] Client connected");

                //사용자 요청을 메인 thread가 처리하도록 한다
                try (InputStream in = clinetSocket.getInputStream(); OutputStream out = clinetSocket.getOutputStream()) {
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream dos = new DataOutputStream(out);
                    HttpRequest httpRequest = new HttpRequest(br);
                    if (httpRequest.isGetRequest() && httpRequest.matchPath("/calculate")) {
                        QueryStrings queryStrings = httpRequest.getQueryStrings();
                        int operand1 = Integer.parseInt( queryStrings.getValue("operand1"));
                        String operator = queryStrings.getValue("operator");
                        int operand2 = Integer.parseInt(queryStrings.getValue("operand2"));
                        int result = Calculator.calculate(new PositiveNumber(operand1), operator, new PositiveNumber(operand2));
                        byte[] body = String.valueOf(result).getBytes();

                        HttpResponse httpResponse = new HttpResponse(dos);
                        httpResponse.response200Header("application/json", body.length);
                        httpResponse.responseBody(body);
                    }
                }
            }
        }

    }
}
