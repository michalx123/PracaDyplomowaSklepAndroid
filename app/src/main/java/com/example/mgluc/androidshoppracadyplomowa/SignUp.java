package com.example.mgluc.androidshoppracadyplomowa;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.mgluc.androidshoppracadyplomowa.Model.Users;
import com.example.mgluc.androidshoppracadyplomowa.Model.Users2;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

public class SignUp extends AppCompatActivity {

    Button ButtonSignUp;
    MaterialEditText idPhone,idPassword,idName;
   // RadioGroup radioSex; //test
    //RadioButton radioSexButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        idPassword = (MaterialEditText) findViewById(R.id.idPassword);
        idPhone = (MaterialEditText) findViewById(R.id.idPhone);
        idName = (MaterialEditText) findViewById(R.id.idName);
        //radioSex = (RadioGroup) findViewById(R.id.radioSex);    // test
        ButtonSignUp = (Button) findViewById(R.id.btnSignUp);

        //inicjacja Firebase
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("Users"); //referencje gdzie szukac/dodac w danych

        ButtonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog pleasewait = new ProgressDialog(SignUp.this);
                pleasewait.setMessage("Proszę czekać...");
                pleasewait.show();

                // Attach a listener to read the data at our posts reference/w celu sprawdzenia czy istnieje nr tel.
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //sprawdzenie czy uzytkownik istnieje
                        if(dataSnapshot.child(idPhone.getText().toString()).exists()){
                            pleasewait.dismiss();
                            Toast.makeText(SignUp.this,"Użytkownik o takim numerze już istnieje!",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            //tworzenie uzytkownika
                            pleasewait.dismiss();
                            //dokonczyc wybor plci
                           // int selectedId = radioSex.getCheckedRadioButtonId();
                            //radioSexButton = (RadioButton) findViewById(selectedId);
                            Users user = new Users(idName.getText().toString(),idPassword.getText().toString()); // tworzenie instacji usera z modelu //,radioSexButton.getText().toString()
                            table_user.child(idPhone.getText().toString()).setValue(user);
                            Toast.makeText(SignUp.this,"Użytkownik zarejestrowany!",Toast.LENGTH_SHORT).show();
                            finish();

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
