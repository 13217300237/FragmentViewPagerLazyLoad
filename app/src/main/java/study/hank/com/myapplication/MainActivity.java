package study.hank.com.myapplication;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import study.hank.com.myapplication.fragments.MyFragmentA;
import study.hank.com.myapplication.fragments.MyFragmentB;
import study.hank.com.myapplication.fragments.MyFragmentC;
import study.hank.com.myapplication.fragments.base.BaseFragment;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private TabLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        tableLayout = findViewById(R.id.tableLayout);

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        viewPager.setOffscreenPageLimit(3);
        tableLayout.setupWithViewPager(viewPager);
    }

    private BaseFragment fragmentA;
    private BaseFragment fragmentB;
    private BaseFragment fragmentC;

    private class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if (fragmentA == null) {
                        fragmentA = new MyFragmentA();
                    }
                    return fragmentA;
                case 1:
                    if (fragmentB == null) {
                        fragmentB = new MyFragmentB();
                    }
                    return fragmentB;
                case 2:
                    if (fragmentC == null) {
                        fragmentC = new MyFragmentC();
                    }
                    return fragmentC;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "A";
                case 1:
                    return "B";
                case 2:
                    return "C";
                default:
                    return "";
            }
        }
    }
}
