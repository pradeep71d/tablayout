package com.example.tablayoutdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
FrameLayout frameLayout;
TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout=findViewById(R.id.tab1);// finding ids and initializing
        frameLayout=findViewById(R.id.fram1);
        TabLayout.Tab firsttab=tabLayout.newTab();//creating 3 tabs
        TabLayout.Tab secondtab=tabLayout.newTab();
        TabLayout.Tab thirdtab=tabLayout.newTab();
        firsttab.setText("FirstTab");//giving text to created tabs
        secondtab.setText("SecondTab");
        thirdtab.setText("ThirdTab");
        tabLayout.addTab(firsttab);//adding all tabs to tablayout
        tabLayout.addTab(secondtab);
        tabLayout.addTab(thirdtab);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragment=null;
                switch (tab.getPosition()){
                    case 0:
                        fragment=new FirstFragment();
                        break;
                    case 1:
                        fragment=new SecondFragment();
                        break;
                    case 2:
                        fragment=new ThirdFragment();
                        break;
                }
                FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fram1,fragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                fragmentTransaction.commit();
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