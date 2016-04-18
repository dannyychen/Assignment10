package com.example.dchen.assignment10;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import org.w3c.dom.Text;

import java.util.Map;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener{

    private Firebase myFirebaseRef;
    private Button button;
    private EditText username, password, confirm;
    private TextView passwordCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Firebase.setAndroidContext(this);
        button = (Button) this.findViewById(R.id.button);
        button.setOnClickListener(this);
        username = (EditText)findViewById(R.id.nus);
        password = (EditText)findViewById(R.id.npass);
        confirm = (EditText)findViewById(R.id.cnpass);
        passwordCheck = (TextView) findViewById(R.id.passcheck);
        myFirebaseRef = new Firebase("https://account1.firebaseio.com/");

        Button closeButton = (Button) findViewById(R.id.close);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }

    public void onClick(View v)
    {
        if(v == button){
            if (password.getText().toString().equals(confirm.getText().toString())) {
                myFirebaseRef.createUser(username.getText().toString(), password.getText().toString(), new Firebase.ValueResultHandler<Map<String, Object>>() {
                    @Override
                    public void onSuccess(Map<String, Object> result) {
                        passwordCheck.setText("Account Successfully Created!");
                        finish();
                        System.exit(0);
                    }

                    @Override
                    public void onError(FirebaseError firebaseError) {
                        passwordCheck.setText(firebaseError.getMessage());
                    }
                });
            }
            else{
                    passwordCheck.setText("Your passwords do not match");
                }
            }

    }
}
