package learning.practice_loginsystemdbms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private Button Login;
    private TextView Info;
    private int count = 5;
    private TextView userRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText) findViewById(R.id.etName);
        Password = (EditText) findViewById(R.id.etUserPassword);
        Login = (Button) findViewById(R.id.mButton);
        Info = (TextView) findViewById(R.id.tvInfo);
        userRegister = (TextView) findViewById(R.id.tvRegister);

        userRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(), Password.getText().toString());
            }
        });

    }

    private void validate(String userName, String userPassword)
    {
        if((userName.equals("Admin")) && (userPassword.equals("1234")))
        {
            Toast.makeText(getApplicationContext(), "Logged in successfully!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }

        else
        {
            count--;

            Info.setText("Number of attempts: "+count);

            Toast.makeText(getApplicationContext(), "Please Try Again!", Toast.LENGTH_SHORT).show();

            if(count==0)
                Login.setEnabled(false);
        }
    }
}
