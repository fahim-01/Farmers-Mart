package com.example.materialdemo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity  implements View.OnClickListener {

    private EditText signUpEmailEditText,signUpPasswordEditText,signUpVillageEditText,signUpPhoneEditText,
            signUpNameEditText;
    private Button CreateAccount;
    private FirebaseAuth mAuth;
    DatabaseReference databaseReference;

    FirebaseDatabase database;
    DatabaseReference ref;

    private static final String TAG = "SignUP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        database = FirebaseDatabase.getInstance();
        ref = database.getReference();
//        databaseReference = FirebaseDatabase.getInstance().getReference("farmer");



        Log.d("REF", "HEllo Here " + ref.toString());

        signUpEmailEditText =findViewById(R.id.signInEmailEditTextId);
        signUpPasswordEditText=findViewById(R.id.signInPasswordEditTextId);
        CreateAccount=findViewById(R.id.CreateAccountId);

        signUpVillageEditText=findViewById(R.id.signUpVillageEditTextId);
        signUpNameEditText= findViewById(R.id.signUpNameEditTextId);
        signUpPhoneEditText=findViewById(R.id.signUpPhoneEditTextId);

        mAuth = FirebaseAuth.getInstance();

        CreateAccount.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.CreateAccountId:
            {

                Log.d("SIGNUP", "USER Sign UP");
               userRegister();
                 //saveData();
                break;

            }

        }

    }

    private void saveData () {

        String name =signUpNameEditText.getText().toString().trim();
        String village =signUpVillageEditText.getText().toString().trim();
        String phoneNo =signUpPhoneEditText.getText().toString().trim();

//        String key = databaseReference.push().getKey();
//        Log.d("SignUp", "key: " + key);
//        Farmer farmer = new Farmer(name,village,phone_no);
//
//        databaseReference.child(key).setValue("Hello World");

        Farmer farmer = new Farmer(name, village, phoneNo);
        DatabaseReference farmerRef = ref.child("farmer");
        Log.d(TAG, "farmer Ref: " + farmerRef.toString());

        String key = farmerRef.push().getKey();
        farmerRef.child(key).setValue(farmer, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                System.out.println("Ref: " + databaseReference.toString());
                System.out.println("Error: " + databaseError);
                if (databaseError != null) {
                    System.out.println("Data could not be saved " + databaseError.getMessage());
                } else {

                    System.out.println("Data saved successfully.");
                    Intent intent = new Intent(SignUp.this,MainActivity.class);
                    startActivity(intent);
                }
            }


        });

    }


    private void userRegister() {


        String email = signUpEmailEditText.getText().toString().trim();
        String password = signUpPasswordEditText.getText().toString().trim();

        if(email.isEmpty())
        {
            signUpEmailEditText.setError("Enter an email address");
            signUpEmailEditText.requestFocus();
            return;
        }

        if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            signUpEmailEditText.setError("Enter a valid email address");
            signUpEmailEditText.requestFocus();
            return;
        }

        //checking the validity of the password
        if(password.isEmpty())
        {
            signUpPasswordEditText.setError("Enter a password");
            signUpPasswordEditText.requestFocus();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Log.d("SignUP", "User Sign Up successfull");
                            saveData();



                        } else {
                            Log.d("SignUP", "User Sign Up Unsuccessfull");
                        }
                    }
                });






    }
}