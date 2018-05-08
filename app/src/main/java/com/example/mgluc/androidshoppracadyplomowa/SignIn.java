package com.example.mgluc.androidshoppracadyplomowa;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mgluc.androidshoppracadyplomowa.Model.Users;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignIn extends AppCompatActivity {

    EditText idPhone, idPassword;
    Button btnSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        idPassword = (MaterialEditText) findViewById(R.id.idPassword); //przechwytywanie wpisanych wartosci przez uzytkownika
        idPhone = (MaterialEditText) findViewById(R.id.idPhone);
        btnSignIn = (Button) findViewById(R.id.btnSignIn);


        //inicjacja Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("Users"); //referencje gdzie szukac w danych


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog pleasewait = new ProgressDialog(SignIn.this);
                pleasewait.setMessage("Proszę czekać...");
                pleasewait.show();

                // Attach a listener to read the data at our posts reference
                table_user.addValueEventListener(new ValueEventListener() { //Classes implementing/ this interface ValueEventListener can be used to receive events about data changes at a location. Attach the listener to a location user
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //get user information
                        if (dataSnapshot.child(idPhone.getText().toString()).exists()){
                            pleasewait.dismiss();
                        Users user = dataSnapshot.child(idPhone.getText().toString()).getValue(Users.class); //jakich szukac danych do snapshota w referencji (w modelu zdefiniowane)
                        //.child w jakiej pod wartosci w jsonie szukac, tutaj telefon)
                        if (user.getPassword().equals(idPassword.getText().toString())) {
                            Toast.makeText(SignIn.this, "Zalogowano pomyślnie!", Toast.LENGTH_SHORT).show();
                        } else {

                            Toast.makeText(SignIn.this, "Błędne hasło", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                            pleasewait.dismiss();
                            Toast.makeText(SignIn.this, "Użytkownik nie istnieje", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });
    }
}
