package waleeed.my.aleppogrill;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class done_order extends Activity implements  OnClickListener {
  Button button;
 FirebaseAuth firebaseAut;
    FirebaseAuth.AuthStateListener authStateListene;
    @Override
    public void onStart() {
        super.onStart();
        firebaseAut.addAuthStateListener(authStateListene);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done_order);
        button=findViewById(R.id.log_out);
        button.setOnClickListener(this);
        firebaseAut=FirebaseAuth.getInstance();

        authStateListene = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {
                    startActivity(new Intent(done_order.this, MainActivity.class));
                }
            }
        };




        }

    @Override
    public void onClick(View v) {
        firebaseAut.signOut();


    }
}
