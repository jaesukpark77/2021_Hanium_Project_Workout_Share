package org.techtown.personal_page;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;


import com.google.android.material.tabs.TabLayout;

import org.techtown.personal_page.R;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;


    org.techtown.personal_page.Custom custom;
    org.techtown.personal_page.Ai ai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ViewPager vp = findViewById(R.id.viewpager);
        VPAdapter adapter = new VPAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowTitleEnabled(false);

        custom = new org.techtown.personal_page.Custom();
        ai = new org.techtown.personal_page.Ai();

        getSupportFragmentManager().beginTransaction().replace(R.id.container, custom).commit();

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(vp);

        tabs.addTab(tabs.newTab().setText("커스텀 운동"));
        tabs.addTab(tabs.newTab().setText("추천 운동"));
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                Log.d("MainActivity", "선택된 탭 : " + position);

                Fragment selected = null;
                if (position == 0) {
                    selected = custom;
                } else if (position == 1) {
                    selected = ai;
                }
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, selected).commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

}

