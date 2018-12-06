package com.s5.festivaman.Socket;

import com.s5.festivaman.user.User;

import java.util.ArrayList;
import java.util.List;

public class DatabaseQueries {
    private static List<String> returnList = new ArrayList<>();
    static {
        returnList.add("Louise");
        returnList.add("Paco");
        returnList.add("Coco");
        returnList.add("JP");
        returnList.add("Ricardo");
        returnList.add("Julien");
        returnList.add("Marc-Antoine");
        returnList.add("Maëlle");
        returnList.add("Léo");
        returnList.add("Pierre");
    }

    // Used to mock DB when database not available
    private static boolean isDatabaseMocked = true;

    public static void mockDatabase() {
        DatabaseQueries.isDatabaseMocked = false;
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
            returnList.remove(friend);
            return true;
        }
        query.add("removeFriend");
        query.add(user);
        query.add(friend);

        return booleanQuery();
    }

    public boolean addFriends(String user, String friend) {
        if (isDatabaseMocked) {
            returnList.add(friend);
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
        query.add(User.getUserName());
        query.add(field);
        query.add(data);

        return booleanQuery();
    }

    public List<String> getFriendsList(String user) {
        if (isDatabaseMocked) {

            return returnList;
        }
        query.add("friendList");
        query.add(user);

        return listQuery();
    }

    public List<String> getMeetingList() {
        if (isDatabaseMocked) {
            List<String> returnList = new ArrayList<String>();
            returnList.add("Les vieilles Charrues");
            returnList.add("HellFest");
            returnList.add("Festival d'été de Québec");
            return returnList;
        }
        query.add("MeetingPoints");
        return listQuery();
    }

    public List<String> getFriendPosition(String user) {
        if (isDatabaseMocked) {
            List<String> tempList = new ArrayList<String>();
            tempList.add("Paco;46.814984;-71.208142");
            tempList.add("Louise;48.389845;-4.484317");
            tempList.add("Chapeau;45.3781;-71.9281");
            return tempList;
        }
        query.add("friendPos");
        query.add(user);

        return listQuery();
    }


    public List<String> getEventsPosition() {
        if (isDatabaseMocked) {
            List<String> tempList = new ArrayList<String>();
            tempList.add("Les vieilles Charrues;48.270482;-3.551300");
            tempList.add("HellFest;47.097252;-1.271214");
            tempList.add("Festival d'été de Québec;46.802410;-71.216937");
            return tempList;
        }
        query.add("eventsPos");

        return listQuery();
    }

}
