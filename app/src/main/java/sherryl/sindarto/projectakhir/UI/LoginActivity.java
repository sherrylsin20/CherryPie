package sherryl.sindarto.projectakhir.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import sherryl.sindarto.projectakhir.R;

public class LoginActivity extends AppCompatActivity {
Button buttonLogin;
EditText editEmail, editPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.editEmail);
        editPassword = findViewById(R.id.editPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                String email = editEmail.getText().toString();
                String password = editPassword.getText().toString();
                if(email.equals("test@gmail.com" )){
                    if(password.equals("abcd1234")){
                        Toast.makeText(context, "Login berhasil!", Toast.LENGTH_SHORT).show();
                        openActivityHome();
                    }
                    else{
                        Toast.makeText(context, "Email atau password salah!", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(context, "Email atau password salah!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void openActivityHome() {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }
}
