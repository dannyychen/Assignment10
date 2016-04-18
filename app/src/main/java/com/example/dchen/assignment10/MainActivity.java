package com.example.dchen.assignment10;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button login;
    private TextView create;
    private TextView username, password;
    private TextView passwordCheck;
    private Firebase myFirebaseRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_main);
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

        myFirebaseRef = new Firebase("https://account1.firebaseio.com/");
        login = (Button) this.findViewById(R.id.login);
        login.setOnClickListener(this);
        create = (TextView)findViewById(R.id.create);
        create.setOnClickListener(this);
        username = (EditText)findViewById(R.id.us);
        password = (EditText)findViewById(R.id.pass);
        passwordCheck = (TextView)findViewById(R.id.passcheck);

        /*login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                launchComposeView();
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void launchComposeView() {
        // first parameter is the context, second is the class of the activity to launch
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i); // brings up the second activity
    }

    // ActivityTwo.java
    public void onSubmit(View v) {
        // closes the activity and returns to first screen
        this.finish();
    }

    public void onClick(View v){
        if(v == login) {
            myFirebaseRef.authWithPassword(username.getText().toString(), password.getText().toString(), new Firebase.AuthResultHandler() {
                @Override
                public void onAuthenticated(AuthData authData) {
                    launchComposeView();
                }

                @Override
            public void onAuthenticationError(FirebaseError firebaseError){
                    passwordCheck.setText("Your username or password is incorrect");
                }
            });
        }
        if(v == create){
            Intent intent = new Intent(getApplicationContext(), Main3Activity.class);
            startActivity(intent);
        }
    }

}
