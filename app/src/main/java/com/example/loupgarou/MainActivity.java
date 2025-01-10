package com.example.loupgarou;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class MainActivity extends AppCompatActivity {

    private Button drawButton;
    private EditText numPlayersEditText;
    private CheckBox werewolfCheckBox;
    private CheckBox sorcierCheckBox;
    private CheckBox cCheckBox;
    private CheckBox hunterCheckBox;
    private CheckBox sCheckBox;
    private CheckBox laCheckBox;
    private CheckBox lbCheckBox;
    private CheckBox lkCheckBox;
    private CheckBox jfCheckBox;
    private CheckBox vCheckBox;
    private CheckBox voCheckBox;
    private CheckBox coCheckBox;
    private CheckBox enCheckBox;
    private CheckBox inCheckBox;
    private CheckBox lpCheckBox;
    private CheckBox rCheckBox;
    private CheckBox soCheckBox;
    private CheckBox lblCheckBox;
    private CheckBox clCheckBox;
    private CheckBox pfCheckBox;
    private CheckBox aCheckBox;
    private CheckBox anCheckBox;
    private CheckBox iCheckBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawButton = findViewById(R.id.draw_button);
        numPlayersEditText = findViewById(R.id.num_players_edit_text);
        werewolfCheckBox = findViewById(R.id.werewolf_checkbox);
        sorcierCheckBox = findViewById(R.id.sorcier_checkbox);
        hunterCheckBox = findViewById(R.id.hunter_checkbox);
        cCheckBox = findViewById(R.id.cupid_checkbox);
        sCheckBox = findViewById(R.id.salva_checkbox);
        laCheckBox = findViewById(R.id.la_checkbox);
        lbCheckBox = findViewById(R.id.lb_checkbox);
        lkCheckBox = findViewById(R.id.lk_checkbox);
        jfCheckBox = findViewById(R.id.jf_checkbox);
        vCheckBox = findViewById(R.id.voyant_checkbox);
        voCheckBox = findViewById(R.id.v_checkbox);
        coCheckBox = findViewById(R.id.cor_checkbox);
        enCheckBox = findViewById(R.id.en_checkbox);
        inCheckBox = findViewById(R.id.in_checkbox);
        lpCheckBox = findViewById(R.id.lp_checkbox);
        lblCheckBox = findViewById(R.id.lbl_checkbox);
        rCheckBox = findViewById(R.id.r_checkbox);
        soCheckBox = findViewById(R.id.s_checkbox);
        clCheckBox = findViewById(R.id.ch_checkbox);
        pfCheckBox = findViewById(R.id.pf_checkbox);
        aCheckBox = findViewById(R.id.a_checkbox);
        anCheckBox = findViewById(R.id.an_checkbox);
        iCheckBox = findViewById(R.id.i_checkbox);
        drawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numPlayers = Integer.parseInt(numPlayersEditText.getText().toString());
                boolean includeWerewolf = werewolfCheckBox.isChecked();
                boolean includeSorcier = sorcierCheckBox.isChecked();
                boolean includeh = hunterCheckBox.isChecked();
                boolean includes = sCheckBox.isChecked();
                boolean includela = laCheckBox.isChecked();
                boolean includelb = lbCheckBox.isChecked();
                boolean includelk = lkCheckBox.isChecked();
                boolean includec = cCheckBox.isChecked();
                boolean includejf = jfCheckBox.isChecked();
                boolean includev = vCheckBox.isChecked();
                boolean includevo = voCheckBox.isChecked();
                boolean includeco = coCheckBox.isChecked();
                boolean includeen = enCheckBox.isChecked();
                boolean includein = inCheckBox.isChecked();
                boolean includelp = lpCheckBox.isChecked();
                boolean includelbl = lblCheckBox.isChecked();
                boolean includepf = pfCheckBox.isChecked();
                boolean includeso = soCheckBox.isChecked();
                boolean includecl = clCheckBox.isChecked();
                boolean includer = rCheckBox.isChecked();
                boolean includea = aCheckBox.isChecked();
                boolean includean = anCheckBox.isChecked();
                boolean includei = iCheckBox.isChecked();






                // Generate random roles for each player
                List<String> roles = new ArrayList<>();
                if (includeWerewolf) {
                    roles.add("Loup garou");
                }
                if (includeSorcier) {
                    roles.add("sorcière");
                }
                if (includes) {
                    roles.add("Salvateur");
                }
                if (includeh) {
                    roles.add("Chasseur");
                }
                if (includela) {
                    roles.add("Loup alpha");
                }
                if (includelb) {
                    roles.add("Loup blue");
                }
                if (includelk) {
                    roles.add("Loup Kamikaze");
                }
                if (includec) {
                    roles.add("Cupidon");
                }
                if (includejf) {
                    roles.add("joueur de flûte");
                }
                if (includev) {
                    roles.add("voyante");
                }
                if (includevo) {
                    roles.add("voleur");
                }
                if (includeco) {
                    roles.add("corbeau");
                }
                if (includein) {
                    roles.add("L'infecteur");
                }
                if (includeen) {
                    roles.add("L'enfant sauvage");
                }
                if (includelp) {
                    roles.add("Lapin blanc");
                }
                if (includelbl) {
                    roles.add("Loup blanc");
                }
                if (includer) {
                    roles.add("Renard");
                }
                if (includepf) {
                    roles.add("petite fille");
                }
                if (includeso) {
                    roles.add("Souers");
                    roles.add("Souers");
                }
                if (includecl) {
                    roles.add("Chien loup");
                }
                if (includea) {
                    roles.add("L'ange");
                }
                if (includean) {
                    roles.add("L'ancien");
                }
                if (includei) {
                    roles.add("L'idiot de village");
                }
                for (int i = roles.size(); i < numPlayers; i++) {
                    roles.add("simple villageois");
                }

                // Shuffle the roles and start the RoleCardActivity to display them
                Collections.shuffle(roles);
                Intent intent = new Intent(MainActivity.this, RoleCardActivity.class);
                intent.putStringArrayListExtra("roles", (ArrayList<String>) roles);
                startActivity(intent);
            }
        });
    }
}