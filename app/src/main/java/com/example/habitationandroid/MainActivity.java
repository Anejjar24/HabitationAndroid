package com.example.habitationandroid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText nom;
    private EditText adresse;
    private EditText surface;
    private EditText nbr_pieces;
    private CheckBox piscine;
    private Button calcul;
    private float impot_de_baseValue;
    private float impot_supplementaireValue;
    private float impot_totalValue;

    private TextView impot_de_baseText;
    private TextView impot_supplementaireText;
    private TextView impot_totalText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        nom = findViewById(R.id.nom);
        adresse = findViewById(R.id.adresse);
        surface = findViewById(R.id.surface);
        nbr_pieces= findViewById(R.id.nbr_pieces);
        piscine= findViewById(R.id.piscine);
        calcul = findViewById(R.id.calcul);
        impot_de_baseText = findViewById(R.id.impotBase);
        impot_supplementaireText = findViewById(R.id.impotSupplementaire);
        impot_totalText = findViewById(R.id.impotTotal);


        calcul.setOnClickListener(new View.OnClickListener() {

                                      @Override
                                      public void onClick(View view) {
                                          if (!surface.getText().toString().isEmpty() && !nbr_pieces.getText().toString().isEmpty()) {

                                              float surfaceValue = Float.parseFloat(surface.getText().toString());
                                              int nbrPiecesValue = Integer.parseInt(nbr_pieces.getText().toString());

                                              if (piscine.isChecked()) {
                                                  impot_supplementaireValue = nbrPiecesValue * 50 + 100;
                                              } else {
                                                  impot_supplementaireValue = nbrPiecesValue* 50;
                                              }
                                              impot_de_baseValue =surfaceValue * 2;

                                              impot_totalValue = impot_de_baseValue + impot_supplementaireValue;
                                              impot_de_baseText.setText("Impôt de Base : "+Float.toString(impot_de_baseValue));
                                              impot_supplementaireText.setText("Impôt Supplémentaire : "+Float.toString(impot_supplementaireValue));
                                              impot_totalText.setText("Impôt Total : "+Float.toString(impot_totalValue));


                                          }
                                      }
                                  }
        );


    }
}