package com.s5.festivaman.Socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Receiver {

    private List<String> response;

    private Socket socket;
    private BufferedReader brinp = null;
    private InputStream inp = null;

    public Receiver(Socket socket) {
        response = new ArrayList<>();
        this.socket = socket;
    }

    public List<String> listen() throws IOException {
        inp = socket.getInputStream();
        brinp = new BufferedReader(new InputStreamReader(inp));

        String line;
        while (true) {
            try {
                line = brinp.readLine();
                if (line.equals("QUIT"))
                    break;
                response.add(line);

            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return response;
    }
}
