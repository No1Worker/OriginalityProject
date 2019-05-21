package com.no1worker.originalityproject.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.no1worker.common.CommonActivity;
import com.no1worker.originalityproject.R;
import com.no1worker.originalityproject.fragment.DynamicFragment;
import com.no1worker.originalityproject.fragment.FragmentAdapter;
import com.no1worker.originalityproject.fragment.PersonCenterFragment;

import java.util.ArrayList;

/**
 * 主Tab页
 * Created by yuzhiyong on 2019/5/21.
 */

public class TabMainActivity extends CommonActivity {

    private TabLayout tblMainTab;

    private ViewPager vpMainViewPager;

    private String[] titles = new String[]{"动态","我的"};

    private ArrayList<Fragment> fragments = new ArrayList<>();

    private FragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_main);
        findViews();
        initViews();
    }

    private void findViews() {
        tblMainTab = findViewById(R.id.tblMainTab);
        vpMainViewPager = findViewById(R.id.vpMainViewPager);
    }

    private void initViews() {
        fragments.add(new DynamicFragment());
        fragments.add(new PersonCenterFragment());
        for (String title :titles){
            tblMainTab.addTab(tblMainTab.newTab());
        }
        tblMainTab.setupWithViewPager(vpMainViewPager,false);
        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager(),fragments);
        vpMainViewPager.setAdapter(fragmentAdapter);
        for (int i = 0; i < titles.length; i++) {
            tblMainTab.getTabAt(i).setText(titles[i]);
        }
    }
}
