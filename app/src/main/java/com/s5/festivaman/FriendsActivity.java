package com.s5.festivaman;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.s5.festivaman.activities.DrawerActivity;

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

    protected boolean removeFriend(){

        //TODO call the backend
        return true;
    }

    protected int createFriendPage () {

        LinearLayout linearLayout_factor = findViewById(R.id.friend_layout);

        int n=10;
        //TODO chercher dans la database le nombre d'amis (n)
        List<String> friendsName=new ArrayList<>();


        friendsName.add("Paco Picard");
        friendsName.add("Louise Piecuch");

        for(int i=0; i<n; i++)
        {

             friendsName.add("Paco Picard");
             friendsName.add("Ricardo joan Nevado Paiva");
             friendsName.add("Louise Piecuch");


            //TODO chercher le nom de l'amis pour le mettre dans le textView

            //TODO supprimer l'ami de la database lors de l'appui sur ce bouton
        }



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

        return n;
    }

    public void buttonRemoveFriend (View view){

        TextView textView = (map.get(view.getId()));
        if (removeFriend())
        {
           textView.setVisibility(view.GONE);
           view.setVisibility(view.GONE);
        }

    }
    public void changePage (View view){
        Intent intent = new Intent(this, add_friend.class);
        startActivity(intent);

    }
}
