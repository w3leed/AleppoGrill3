package waleeed.my.aleppogrill;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import waleeed.my.aleppogrill.Recycle_menuItem.Data;
import waleeed.my.aleppogrill.Recycle_menuItem.MenuAdapter;

public class MainActivity extends AppCompatActivity  {

    TextView textCartItemCount;
    Button button;
    int mCartItemCount = 0;
    RecyclerView recycleview;
    MenuAdapter adapter;
    LinearLayoutManager linear;
    ArrayList<Data> data;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    // mTextMessage.setText(R.string.title_home);
                   // increaseCartCounter();
                    Intent intent = new Intent(MainActivity.this, Sign_in.class);
                    startActivity(intent);
                    return true;

            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Toolbar toolbarTop = findViewById(R.id.toolbar_top);
        TextView mTitle = toolbarTop.findViewById(R.id.toolbar_title);
        // recycle
        recycleview = findViewById(R.id.recycle);
        linear = new LinearLayoutManager(this);
        addRecycleData();
        adapter = new MenuAdapter(data);
        recycleview.setAdapter(adapter);
        recycleview.setLayoutManager(linear);
        adapter.setOnItemclick(new MenuAdapter.OnItemclick() {
            @Override
            public void onitemclick(Data data, int position) {

                // put your code counter here
                //put your move data here
                increaseCartCounter();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        final MenuItem menuItem = menu.findItem(R.id.action_cart);
        View actionView = MenuItemCompat.getActionView(menuItem);
        textCartItemCount = (TextView) actionView.findViewById(R.id.cart_badge);

        setupBadge();

        actionView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuItem);
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_cart: {
                // Do something
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupBadge() {

        if (textCartItemCount != null) {
            if (mCartItemCount == 0) {
                if (textCartItemCount.getVisibility() != View.GONE) {
                    textCartItemCount.setVisibility(View.GONE);
                }
            } else {
                textCartItemCount.setText(String.valueOf(Math.min(mCartItemCount, 99)));
                if (textCartItemCount.getVisibility() != View.VISIBLE) {
                    textCartItemCount.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    public void increaseCartCounter() {
        mCartItemCount++;
        if (textCartItemCount != null) {
            if (mCartItemCount == 0) {
                if (textCartItemCount.getVisibility() != View.GONE) {
                    textCartItemCount.setVisibility(View.GONE);
                }
            } else {
                textCartItemCount.setText(String.valueOf(Math.min(mCartItemCount, 99)));
                if (textCartItemCount.getVisibility() != View.VISIBLE) {
                    textCartItemCount.setVisibility(View.VISIBLE);
                }
            }
        }
    }


    public void addRecycleData() {
        data = new ArrayList<>();
            data.add(new Data(R.drawable.aa, "Mac", "the mac is delcious" , "99Le"));
          data.add(new Data(R.drawable.bb, "shawrma", "shawrma is the best food " , "69Le"));
        data.add(new Data(R.drawable.appg, "shawrma", "shawrma is the best food " , "69Le"));
        data.add(new Data(R.drawable.aa, "sorba", "shawrma is the best food and  is delcious " , "69Le"));
        data.add(new Data(R.drawable.bb, "shawrma", "shawrma is the best food " , "69Le"));
        data.add(new Data(R.drawable.bb, "shawrma", "shawrma is the best food " , "69Le"));
        data.add(new Data(R.drawable.appg, "shawrma", "shawrma is the best food " , "69Le"));
        data.add(new Data(R.drawable.aa, "sorba", "shawrma is the best food and  is delcious " , "69Le"));
        data.add(new Data(R.drawable.bb, "shawrma", "shawrma is the best food " , "69Le"));
    }

}

