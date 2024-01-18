package aa.bb.demosharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn1,btn2;
    EditText txtNom;
    TextView txtAff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=findViewById(R.id.btnEnr);
        btn2=findViewById(R.id.btnAff);
        txtNom=findViewById(R.id.txtNom);
        txtAff= findViewById(R.id.txtAff);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences P = getPreferences(Context.MODE_PRIVATE);
                //P.edit().putString("Nom",txtNom.getText().toString()).commit();
                SharedPreferences.Editor E =P.edit();
                E.putString("Nom",txtNom.getText().toString());
                //je peux ajouter plusieurs clé/valeur
                E.commit();


                Toast.makeText(getApplicationContext(), "ok", Toast.LENGTH_SHORT).show();

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences P = getPreferences(Context.MODE_PRIVATE);
                String nom=P.getString("Nom","");
                txtAff.setText(nom);

            }
        });

    }
}