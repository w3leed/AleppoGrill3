package waleeed.my.aleppogrill;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


public class spalsh extends Activity {
    private  static  int splash_time_out=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent in = new Intent(spalsh.this, MainActivity.class);
                startActivity(in);
                finish();

            }
        },splash_time_out);

    }


}
