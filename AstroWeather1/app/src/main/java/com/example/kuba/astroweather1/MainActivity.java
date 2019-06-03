package com.example.kuba.astroweather1;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Button;
import android.widget.Toast;

import com.example.kuba.astroweather1.Fragments.LocalizationDialog;
import com.example.kuba.astroweather1.Fragments.MoonFragment;
import com.example.kuba.astroweather1.Fragments.RefreshTimeDialog;
import com.example.kuba.astroweather1.Fragments.SunFragment;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private Localization localization;
    private AstroCalc astroCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean tabletSize = getResources().getBoolean(R.bool.isTablet);
        System.out.println(tabletSize);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        //-----------------------------------------------------------------------orientation settings
        int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE && tabletSize) {
            SunFragment sunFragment = new SunFragment();
            FragmentManager menager = getSupportFragmentManager();
            menager.beginTransaction().replace(R.id.layoutSun,sunFragment,sunFragment.getTag()).commit();


            MoonFragment moonFragment = new MoonFragment();
            menager.beginTransaction().replace(R.id.layoutMoon,moonFragment,moonFragment.getTag()).commit();
        }else if (orientation != Configuration.ORIENTATION_LANDSCAPE && tabletSize) {

            SunFragment sunFragment = new SunFragment();
            FragmentManager menager = getSupportFragmentManager();
            menager.beginTransaction().replace(R.id.layoutSun,sunFragment,sunFragment.getTag()).commit();


            MoonFragment moonFragment = new MoonFragment();
            menager.beginTransaction().replace(R.id.layoutMoon,moonFragment,moonFragment.getTag()).commit();
        }else if(orientation == Configuration.ORIENTATION_LANDSCAPE) {
            SunFragment sunFragment = new SunFragment();
            FragmentManager menager = getSupportFragmentManager();
            menager.beginTransaction().replace(R.id.layoutSun,sunFragment,sunFragment.getTag()).commit();


            MoonFragment moonFragment = new MoonFragment();
            menager.beginTransaction().replace(R.id.layoutMoon,moonFragment,moonFragment.getTag()).commit();
        } else if (orientation != Configuration.ORIENTATION_LANDSCAPE) {
            // Set up the ViewPager with the sections adapter.
            mViewPager = (ViewPager) findViewById(R.id.container);
            mViewPager.setAdapter(mSectionsPagerAdapter);

            TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

            mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));
        }

//        // Set up the ViewPager with the sections adapter.
//        mViewPager = (ViewPager) findViewById(R.id.container);
//        mViewPager.setAdapter(mSectionsPagerAdapter);
//
//        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
//
//        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.item1:
                openLocalizationDialog();
                return true;
            case R.id.item2:
                openRefreshTimeDialog();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
//    public static class PlaceholderFragment extends Fragment {
//        /**
//         * The fragment argument representing the section number for this
//         * fragment.
//         */
//        private static final String ARG_SECTION_NUMBER = "section_number";
//
//        public PlaceholderFragment() {
//        }
//
//        /**
//         * Returns a new instance of this fragment for the given section
//         * number.
//         */
//        public static PlaceholderFragment newInstance(int sectionNumber) {
//            PlaceholderFragment fragment = new PlaceholderFragment();
//            Bundle args = new Bundle();
//            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
//            return rootView;
//        }
//    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    SunFragment sunFragment = new SunFragment();
                    return sunFragment;
                case 1:
                    MoonFragment moonFragment = new MoonFragment();
                    return moonFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    public void openLocalizationDialog(){
        LocalizationDialog localizationDialog = new LocalizationDialog();
        localizationDialog.show(getSupportFragmentManager(), "localizationDialog");
    }

    public void openRefreshTimeDialog(){
        RefreshTimeDialog refreshTimeDialog = new RefreshTimeDialog();
        refreshTimeDialog.show(getSupportFragmentManager(),"refreshTimeDialog");
    }
}
