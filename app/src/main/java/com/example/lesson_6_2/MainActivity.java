package com.example.lesson_6_2;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button btnLogin;
    private TextView sign;
    private TextView welcome;
    private TextView register;
    private TextView or_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        btnLogin = findViewById(R.id.btnLogin);
        sign = findViewById(R.id.sign);
        welcome = findViewById(R.id.welcome);
        register = findViewById(R.id.register);
        or_register = findViewById(R.id.or_register);



        btnLogin.setBackgroundColor(Color.parseColor("#727272"));


        emailEditText.addTextChangedListener(textWatcher);
        passwordEditText.addTextChangedListener(textWatcher);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (email.equals("admin") && password.equals("admin")) {
                    Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();
                    passwordEditText.setVisibility(View.GONE);
                    emailEditText.setVisibility(View.GONE);
                    btnLogin.setVisibility(View.GONE);
                    sign.setVisibility(View.GONE);
                    welcome.setVisibility(View.GONE);
                    register.setVisibility(View.GONE);
                    or_register.setVisibility(View.GONE);
                } else {
                    Toast.makeText(MainActivity.this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            if (emailEditText.getText().length() > 0 || passwordEditText.getText().length() > 0) {
                btnLogin.setBackgroundColor(Color.parseColor("#FFA500"));
            } else {
                btnLogin.setBackgroundColor(Color.parseColor("#727272"));
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }
    };
}

