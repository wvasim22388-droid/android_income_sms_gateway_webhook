package tech.bogomolov.incomingsmsgateway;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etUser, etPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUser = findViewById(R.id.etUser);
        etPass = findViewById(R.id.etPass);
        btnLogin = findViewById(R.id.btnLogin);

        PrefManager pref = new PrefManager(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!etUser.getText().toString().isEmpty()
                        && !etPass.getText().toString().isEmpty()) {

                    pref.setLoggedIn();

                    startService(new Intent(LoginActivity.this,
                            SmsReceiverService.class));

                    finish();
                }
            }
        });
    }
}
