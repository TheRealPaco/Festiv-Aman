package com.s5.festivaman.Socket;

import java.io.IOException;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ClientThread extends Thread {

    private Socket socket;
    private static final int PORT = 9090;
    private static final String ADDRESS = "192.168.137.1";

    private Semaphore semaphore;
    private boolean isDataRetrieved = false;

    private List<String> message;
    private List<String> response;

    public ClientThread(List<String> message) {
        semaphore = new Semaphore(0);
        this.message = message;
    }

    public List<String> getMessage() throws InterruptedException {
        semaphore.acquire();
        isDataRetrieved = true;
        return response;
    }

    public void run() {
        try {

            socket = new Socket(ADDRESS, PORT);
            new Sender(socket, message).send();
            response = new Receiver(socket).listen();

            semaphore.release();

            while(true) {

                Thread.sleep(1000);
                if (isDataRetrieved)
                    break;
            }
        } catch (IOException e) {
            DatabaseQueries.setIsDatabaseMocked(true);
            e.printStackTrace();
        } catch (InterruptedException e) {
            DatabaseQueries.setIsDatabaseMocked(true);
            e.printStackTrace();
        }

    }
}
