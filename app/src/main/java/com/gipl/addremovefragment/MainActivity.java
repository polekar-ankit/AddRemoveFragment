package com.gipl.addremovefragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    PageAdapter pageAdapter;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewpager);
        pageAdapter = new PageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pageAdapter);

        findViewById(R.id.btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewPager.setCurrentItem(pageAdapter.addNextFragment());
                Toast.makeText(MainActivity.this,"New Fragment added",Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.btn_remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (viewPager.getCurrentItem()>1) {
                    int pos = viewPager.getCurrentItem() - 1;
                    if (pos != -1) {
                        viewPager.setCurrentItem(pos);
                        pageAdapter.removeFragment();
                    }
                    else{
                        Toast.makeText(MainActivity.this,"This is a last Fragment",Toast.LENGTH_SHORT).show();
                    }
//                }
            }
        });
    }
}
