package org.example;

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
        try(ServerSocket serverSocket = new ServerSocket(port)){
            logger.info("[Server] Started on port [ {}]",port);

            Socket clinetSocket;
            logger.info("[Server] Waiting for client connections");
            while((clinetSocket =serverSocket.accept()) != null){
                logger.info("[Server] Client connected");

                //사용자 요청을 메인 thread가 처리하도록 한다
                try(InputStream in = clinetSocket.getInputStream();OutputStream out = clinetSocket.getOutputStream()){
                    BufferedReader br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
                    DataOutputStream dos = new DataOutputStream(out);
                    String line;
                    while((line = br.readLine()) != null){
                        System.out.println(line);
                    }
                }
            }
        }

    }
}
