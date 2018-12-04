package com.s5.festivaman.Socket;

import java.util.ArrayList;
import java.util.List;

public class DatabaseQueries {

    private static boolean isDatabaseMocked = false;

    public static void mockDatabase() {
        DatabaseQueries.isDatabaseMocked = true;
    }

    ClientThread clientThread;
    private List<String> query;
    private List<String> response;


    public DatabaseQueries() {
        query = new ArrayList<>();
    }

    private boolean booleanQuery() {
        clientThread = new ClientThread(query);
        clientThread.start();

        try {
            response = clientThread.getMessage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(response != null && response.size() == 1) {
            return response.contains("true");
        }
        return false;
    }

    private List<String> listQuery() {
        clientThread = new ClientThread(query);
        clientThread.start();

        try {
            response = clientThread.getMessage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(response != null && !response.contains("false") ) {
            return response;
        } else {
            return null;
        }
    }

    public boolean isPasswordCorrect(String user, String password) {
        if (isDatabaseMocked) {
            return true;
        }
        query.add("login");
        query.add(user);
        query.add(password);

        return booleanQuery();
    }

    public boolean isUserNameAvailable(String user) {
        if (isDatabaseMocked) {
            return true;
        }
        query.add("username");
        query.add(user);

        return booleanQuery();
    }

    public boolean createNewUser(String user, String password, String email) {
        if (isDatabaseMocked) {
            return true;
        }
        query.add("newUser");
        query.add(user);
        query.add(password);
        query.add(email);

        return booleanQuery();
    }

    public boolean removeFriends(String user, String friend) {
        if (isDatabaseMocked) {
            return true;
        }
        query.add("removeFriend");
        query.add(user);
        query.add(friend);

        return booleanQuery();
    }

    public boolean addFriends(String user, String friend) {
        if (isDatabaseMocked) {
            return true;
        }
        query.add("addFriend");
        query.add(user);
        query.add(friend);

        return booleanQuery();
    }

    public boolean modifAccount(String field, String data) {
        if (isDatabaseMocked) {
            return true;
        }
        query.add("modifAccount");
        query.add(field);
        query.add(data);

        return booleanQuery();
    }

    public List<String> getFriendsList(String user) {
        if (isDatabaseMocked) {
            List<String> returnList = new ArrayList<String>();
            returnList.add("dummy friends");
            return returnList;
        }
        query.add("friendList");
        query.add(user);

        return listQuery();
    }

    public List<String> getFriendPosition(String user) {
        if (isDatabaseMocked) {
            List<String> returnList = new ArrayList<String>();
            returnList.add("Paco;45.3781;-71.9261");
            returnList.add("Louise;45.3781;-71.9271");
            returnList.add("Chapeau;45.3781;-71.9281");
            return returnList;
        }
        query.add("friendPos");
        query.add(user);

        return listQuery();
    }

}
