package com.example.admin.works.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.works.R;
import com.example.admin.works.Signup;
import com.example.admin.works.fragment.recyclerview_activity;
import com.example.admin.works.fragment.singleItem_recycler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 5/19/2017.
 */

public class recyclerview_viewpager extends AppCompatActivity {



    ViewPager content;
    Toolbar toolbar;
    TabLayout tab;


    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.recyclerview_viewpager_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);


        content = (ViewPager) findViewById(R.id.content);
        setupViewPager(content);

        tab = (TabLayout) findViewById(R.id.tabs);
        tab.setupWithViewPager(content);

    }

    private void setupViewPager(ViewPager content){
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new singleItem_recycler(), "ONE");
        adapter.addFragment(new Signup(), "TWO");
        adapter.addFragment(new Signin(), "THREE");
        adapter.addFragment(new recyclerview_activity(), "FOUR");
        content.setAdapter(adapter);

    }
    public class ViewPagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentList = new ArrayList<>();
        private List<String> titleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            fragmentList.add(fragment);
            titleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titleList.get(position);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

   @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id){
            case R.id.search:
                Toast.makeText(this, "SEARCH",Toast.LENGTH_LONG).show();
                break;

            case R.id.settings:
                Toast.makeText(this, "startActivity(signup.this, abc.class);",Toast.LENGTH_LONG ).show();
                break;

            case R.id.item:
                Toast.makeText(this, "startActivity(signup.this, abc.class);",Toast.LENGTH_LONG ).show();
                break;

            case R.id.exit:
                Toast.makeText(this, "startActivity(signup.this, abc.class);",Toast.LENGTH_LONG ).show();
                break;
        }


        return super.onOptionsItemSelected(item);
    }


}
