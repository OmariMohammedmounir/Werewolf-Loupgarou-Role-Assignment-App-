package com.example.loupgarou;
import static com.example.loupgarou.R.drawable.carte2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoleCardActivity extends AppCompatActivity {

    private GridView gridView;
    private List<String> roles;
    private static List<Integer> revealedCardPositions;
    private static final List<Integer> ROLE_IMAGES = Arrays.asList(
            R.drawable.carte1,
            R.drawable.carte2,
            R.drawable.carte3,
            R.drawable.carte4,
            R.drawable.carte5,
            R.drawable.carte6,
            R.drawable.carte7,
            8,
            R.drawable.carte9,10,
            R.drawable.carte11,12,13,14,R.drawable.carte15, R.drawable.carte16,R.drawable.carte17,18,19,R.drawable.carte20
            ,R.drawable.carte31_90_90,R.drawable.carte_petite_fille,R.drawable.carte24,R.drawable.carte22 ,R.drawable.carte9,R.drawable.carte25,R.drawable.carte19, R.drawable.carte8, R.drawable.carte13      // Add more images here for each role
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_card);

        // Retrieve the shuffled roles from the intent
        Intent intent = getIntent();
        roles = intent.getStringArrayListExtra("roles");

        // Set up the GridView to display the role cards
        gridView = findViewById(R.id.grid_view);
        gridView.setAdapter(new RoleCardAdapter(roles, this));

        // Initialize the list of revealed card positions
        revealedCardPositions = new ArrayList<>();

        // Set up the click listener to reveal or delete the role when a card is tapped
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView roleTextView = view.findViewById(R.id.role_text_view);
                String role = roles.get(position);
                ImageView a = view.findViewById(R.id.card_image_view);

                if (revealedCardPositions.contains(position)) {
                    // Card has already been revealed, so delete it from the adapter
                    roles.remove(position);
                    revealedCardPositions.remove(Integer.valueOf(position));
                    gridView.setAdapter(new RoleCardAdapter(roles, RoleCardActivity.this));
                } else {
                    // Card has not been revealed yet, so reveal it
                    roleTextView.setText(role);
                    if (role.equals("Loup garou"))
                    a.setImageResource(ROLE_IMAGES.get(1));
                    if (role.equals("sorcière"))
                        a.setImageResource(ROLE_IMAGES.get(4));
                    if (role.equals("Salvateur"))
                        a.setImageResource(ROLE_IMAGES.get(3));
                    if (role.equals("Chasseur"))
                        a.setImageResource(ROLE_IMAGES.get(5));
                    if (role.equals("Loup alpha"))
                        a.setImageResource(ROLE_IMAGES.get(1));
                    if (role.equals("Loup blue"))
                        a.setImageResource(ROLE_IMAGES.get(1));
                    if (role.equals("Loup Kamikaze"))
                        a.setImageResource(ROLE_IMAGES.get(1));
                    if (role.equals("Cupidon"))
                        a.setImageResource(ROLE_IMAGES.get(6));
                    if (role.equals("joueur de flûte"))
                        a.setImageResource(ROLE_IMAGES.get(14));
                    if (role.equals("voyante"))
                        a.setImageResource(ROLE_IMAGES.get(2));
                    if (role.equals("voleur"))
                        a.setImageResource(ROLE_IMAGES.get(10));
                    if (role.equals("corbeau"))
                        a.setImageResource(ROLE_IMAGES.get(16));
                    if (role.equals("L'infecteur"))
                        a.setImageResource(ROLE_IMAGES.get(19));
                    if (role.equals("L'enfant sauvage"))
                        a.setImageResource(ROLE_IMAGES.get(15));
                    if (role.equals("simple villageois"))
                        a.setImageResource(ROLE_IMAGES.get(0));
                    if (role.equals("Lapin blanc"))
                        a.setImageResource(ROLE_IMAGES.get(20));
                    if (role.equals("Loup blanc"))
                        a.setImageResource(ROLE_IMAGES.get(24));
                    if (role.equals("Renard"))
                        a.setImageResource(ROLE_IMAGES.get(22));
                    if (role.equals("petite fille"))
                        a.setImageResource(ROLE_IMAGES.get(21));
                    if (role.equals("Souers"))
                        a.setImageResource(ROLE_IMAGES.get(23));
                    if (role.equals("Chien loup"))
                        a.setImageResource(ROLE_IMAGES.get(25));
                    if (role.equals("L'ange"))
                        a.setImageResource(ROLE_IMAGES.get(26));
                    if (role.equals("L'ancien"))
                        a.setImageResource(ROLE_IMAGES.get(27));

                    if (role.equals("L'idiot de village"))
                        a.setImageResource(ROLE_IMAGES.get(28));







                    revealedCardPositions.add(position);
                }
            }
        });
    }

    // Define a custom adapter for the GridView to display the role cards
    private static class RoleCardAdapter extends BaseAdapter {

        private final List<String> roles;
        private final Context context;

        public RoleCardAdapter(List<String> roles, Context context) {
            this.roles = roles;
            this.context = context;
        }

        @Override
        public int getCount() {
            return roles.size();
        }

        @Override
        public String getItem(int position) {
            return roles.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            TextView textView;

            if (convertView == null) {
                // Inflate a new layout for the role card
                view = LayoutInflater.from(context).inflate(R.layout.item_role_card, parent, false);
                textView = view.findViewById(R.id.role_text_view);
                view.setTag(textView);
            } else {
                view = convertView;
                textView = (TextView) view.getTag();
            }

            // Set the initial text on the card to be hidden
            textView.setText("???");

            // If the card has been revealed, update its text to show the role
            if (revealedCardPositions.contains(position)) {
                String role = getItem(position);
                textView.setText(role);
            }

            return view;
        }
    }
}


