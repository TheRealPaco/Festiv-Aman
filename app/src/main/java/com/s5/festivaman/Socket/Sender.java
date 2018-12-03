package com.s5.festivaman.Socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Sender{

    private static final String QUIT = "QUIT\n";

    private List<String> message;

    private Socket socket;
    private OutputStreamWriter oosw = null;

    public Sender(Socket socket,List<String> message) {
        this.socket = socket;
        this.message = message;
    }

    public void send() throws IOException {
        oosw = new OutputStreamWriter(socket.getOutputStream(),
                "UTF-8");
        for (String t: message) {

            t += "\n";
            oosw.write(t, 0, t.length());
            oosw.flush();
        }
        oosw.write(QUIT, 0, QUIT.length());
        oosw.flush();
    }
}
