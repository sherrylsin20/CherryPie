package sherryl.sindarto.projectakhir.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import sherryl.sindarto.projectakhir.R;

public class HomeScreen extends AppCompatActivity {

    private ViewFlipper VF;
    int[] images = {R.drawable.food_1, R.drawable.food_2, R.drawable.food_3};
    ImageButton buttonBaegopa;
    long back_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        VF = (ViewFlipper) findViewById(R.id.VF);

        for(int i = 0; i < images.length; i++){
            ImageView image = new ImageView(this);
            image.setImageResource(images[i]);
            VF.addView(image);
        }

        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        VF.setInAnimation(in);
        VF.setOutAnimation(out);
        VF.setFlipInterval(3000);
        VF.setAutoStart(true);

        buttonBaegopa = (ImageButton) findViewById(R.id.buttonBaegopa);
        buttonBaegopa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openBaegopaActivity();
            }
        });
    }

    private void openBaegopaActivity() {
        Intent intent = new Intent(this, BaegopaActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
            finish();
            moveTaskToBack(true);
        }
        else
            Toast.makeText(getBaseContext(), "Press once again to exit!", Toast.LENGTH_SHORT).show();
        back_pressed = System.currentTimeMillis();
    }
}
