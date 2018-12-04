package com.s5.festivaman;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.s5.festivaman.Socket.DatabaseQueries;
import com.s5.festivaman.activities.DrawerActivity;
import com.s5.festivaman.user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FriendsActivity extends DrawerActivity {

    private Map<Integer,TextView> map;

    @Override
    protected void startActivity() {
        setContentView(R.layout.activity_friends);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        map=new HashMap<Integer,TextView>();
        createFriendPage();

    }



    protected int createFriendPage () {

        LinearLayout linearLayout_factor = findViewById(R.id.friend_layout);

        List<String> friendsName = new DatabaseQueries().getFriendsList(User.getUserName());

        for( int i = 0; i < friendsName.size(); i++ )
        {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout_factor.addView(linearLayout);

            TextView textView = new TextView(this);
            textView.setText(friendsName.get(i));
            textView.setTextSize(24);
            textView.setGravity(Gravity.CENTER);
            textView.setHeight(97);
            textView.setWidth(570);

            linearLayout.addView(textView);

            Button button = new Button(this);
            button.setBackgroundResource(R.drawable.ic_delete_forever_black_24dp);
            button.setHeight(20);
            button.setId(i);
            button.setGravity(Gravity.LEFT);
            linearLayout.addView(button);
            map.put(i, textView);
            button.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    buttonRemoveFriend(v);

                }
            });

        }

        return friendsName.size();
    }

    private TextView friendNameToRemove = null;
    private View clickRemoved = null;

    public void buttonRemoveFriend (View view){
        clickRemoved  = view;
        friendNameToRemove = (map.get(view.getId()));
        new AlertDialog.Builder(this)
                .setTitle("Suppression")
                .setMessage("Voulez-vous supprimer " + friendNameToRemove.getText().toString())
                .setPositiveButton("Oui", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (removeFriend(friendNameToRemove.getText().toString()))
                        {
                            friendNameToRemove.setVisibility(clickRemoved.GONE);
                            clickRemoved.setVisibility(clickRemoved.GONE);
                        }
                    }
                }).setNegativeButton("Non", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
        }).show();


    }

    protected boolean removeFriend(String friend){

        if (new DatabaseQueries().removeFriends(User.getUserName(),friend)) {
            return true;
        }
        return false;
    }
    public void changePage (View view){
        Intent intent = new Intent(this, add_friend.class);
        startActivity(intent);

    }
}
