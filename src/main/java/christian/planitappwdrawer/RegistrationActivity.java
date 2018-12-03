package christian.planitappwdrawer;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.view.View;
import android.content.Intent;


public class RegistrationActivity extends AppCompatActivity {

    private static final String TAG = "RegistrationActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_activity);
        Log.d(TAG, "onCreate: Started.");

        Button btn = (Button)findViewById(R.id.btnNavLog);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
            }
        });


    }

}