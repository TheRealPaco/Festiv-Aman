package com.s5.festivaman;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Gravity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.LinearLayout;
        import android.widget.Space;
        import android.widget.TextView;

        import com.s5.festivaman.activities.DrawerActivity;

        import java.util.ArrayList;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

public class add_friend extends DrawerActivity {

    private Map<Integer,TextView> map;
    private List<String> list;

    @Override
    protected void startActivity() {
        setContentView(R.layout.activity_add_friend);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        map=new HashMap<Integer,TextView>();
    }

    public void getText(View view) {
        String research= ((EditText)findViewById(R.id.textView_search)).getText().toString();
        if (!research.isEmpty()) {
            list=getUserList(research);
            if (list != null && !list.isEmpty() ) {
                displayList();
            }
        }
    }

    protected List<String> getUserList(String name) {

        //TODO search in the database the firend's name
        int n=10;
        //TODO chercher dans la database le nombre d'amis (n)
        List<String> friendsName=new ArrayList<>();

        for(int i=0; i<n; i++)
        {

            friendsName.add("Maëlle Fromont");
            friendsName.add("Jean-Phillipe Baillargeons");
            friendsName.add("Marc-Antoine Caron");
        }
        return friendsName;
    }

    protected void displayList() {

        LinearLayout linearLayout_factor = findViewById(R.id.layout_add_friend);

        for( int i = 0; i < list.size(); i++ )
        {
            LinearLayout linearLayout = new LinearLayout(this);
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            linearLayout_factor.addView(linearLayout);

            TextView textView = new TextView(this);
            textView.setText(list.get(i));
            textView.setTextSize(24);
            textView.setGravity(Gravity.CENTER);
            textView.setHeight(97);

            linearLayout.addView(textView);


            Button button = new Button(this);
            button.setBackgroundResource(R.drawable.ic_person_add_black_24dp);
            button.setHeight(10);
            button.setWidth(10);
            button.setId(i);
            button.setGravity(Gravity.RIGHT);
            linearLayout.addView(button);
            map.put(i, textView);
            button.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    add_friend();

                }
            });

        }

    }


    protected boolean add_friend(){
        //TODO ajouter l'ami dans la database
        return true;


    }

    public void buttonAddFriend (View view) {

        TextView textView = (map.get(view.getId()));
        if (add_friend()) {
            //TODO pop-up qui dit "votre ami est ajouté"
        }
    }
}



