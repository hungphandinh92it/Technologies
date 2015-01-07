/*
 * Copyright 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hungphandinh.technologies;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hungphandinh.technologies.view.SlidingTabLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * A basic sample which shows how to use {@link com.hungphandinh.technologies.view.SlidingTabLayout}
 * to display a custom {@link android.support.v4.view.ViewPager} title strip which gives continuous feedback to the user
 * when scrolling.
 */
public class SlidingTabsColorsFragment extends Fragment {

    private ArrayList<FragmentListCards> fragmentListCardses = new ArrayList<>();
    private AdapterListCard.CARD_TYPE mMode = AdapterListCard.CARD_TYPE.NORMAL;

    /**
     * This class represents a tab to be displayed by {@link android.support.v4.view.ViewPager} and it's associated
     * {@link com.hungphandinh.technologies.view.SlidingTabLayout}.
     */
    static class SamplePagerItem {
        private final CharSequence mTitle;
        private final int mIndicatorColor;
        private final int mDividerColor;
        private final String mLink;
        SamplePagerItem(CharSequence title, int indicatorColor, int dividerColor, String link) {
            mTitle = title;
            mIndicatorColor = indicatorColor;
            mDividerColor = dividerColor;
            mLink = link;
        }

        /**
         * @return A new {@link android.support.v4.app.Fragment} to be displayed by a {@link android.support.v4.view.ViewPager}
         */
        Fragment createFragment() {
            FragmentListCards fragmentListCards = new FragmentListCards();
            Bundle arrg = new Bundle();
            arrg.putInt(FragmentListCards.COLOR, mIndicatorColor);
            fragmentListCards.setArguments(arrg);
            return fragmentListCards;
//            return ContentFragment.newInstance(mTitle, mIndicatorColor, mDividerColor);
        }

        /**
         * @return the title which represents this tab. In this sample this is used directly by
         * {@link android.support.v4.view.PagerAdapter#getPageTitle(int)}
         */
        CharSequence getTitle() {
            return mTitle;
        }

        /**
         * @return the color to be used for indicator on the {@link com.hungphandinh.technologies.view.SlidingTabLayout}
         */
        int getIndicatorColor() {
//            return mIndicatorColor;
            return Color.WHITE;
        }

        /**
         * @return the color to be used for right divider on the {@link com.hungphandinh.technologies.view.SlidingTabLayout}
         */
        int getDividerColor() {
//            return mDividerColor;
            return Color.TRANSPARENT;
        }

    }

    static final String LOG_TAG = "SlidingTabsColorsFragment";

    /**
     * A custom {@link android.support.v4.view.ViewPager} title strip which looks much like Tabs present in Android v4.0 and
     * above, but is designed to give continuous feedback to the user when scrolling.
     */
    private SlidingTabLayout mSlidingTabLayout;

    /**
     * A {@link android.support.v4.view.ViewPager} which will be used in conjunction with the {@link com.hungphandinh.technologies.view.SlidingTabLayout} above.
     */
    private ViewPager mViewPager;
    /**
     * List of {@link com.hungphandinh.technologies.SlidingTabsColorsFragment.SamplePagerItem} which represent this sample's tabs.
     */
    private List<SamplePagerItem> mTabs = new ArrayList<SamplePagerItem>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // BEGIN_INCLUDE (populate_tabs)
        /**
         * Populate our tab list with tabs. Each item contains a title, indicator color and divider
         * color, which are used by {@link SlidingTabLayout}.
         */
        mTabs.add(new SamplePagerItem(
                getString(R.string.dantri), // Title
                Color.BLUE, // Indicator color
                Color.GRAY, // Divider color
                "http://dantri.com.vn/trangchu.rss"
        ));

        mTabs.add(new SamplePagerItem(
                getString(R.string.vietnamnet), // Title
                Color.RED, // Indicator color
                Color.GRAY, // Divider color
                "http://vietnamnet.vn/rss/home.rss"
        ));

        mTabs.add(new SamplePagerItem(
                getString(R.string.vnexpress), // Title
                Color.YELLOW, // Indicator color
                Color.GRAY, // Divider color
                "http://vnexpress.net/rss/tin-moi-nhat.rss"
        ));

        mTabs.add(new SamplePagerItem(
                getString(R.string.tinhte), // Title
                Color.GREEN, // Indicator color
                Color.GRAY, // Divider color
                "http://feeds.feedburner.com/tinhte"
        ));
        mTabs.add(new SamplePagerItem("ĐSPL", // Title
                Color.GREEN, // Indicator color
                Color.GRAY, // Divider color
                "http://www.doisongphapluat.com/rss/tin-tuc.rss"
        ));
        mTabs.add(new SamplePagerItem("24H", // Title
                Color.GREEN, // Indicator color
                Color.GRAY, // Divider color
                "http://www.24h.com.vn/upload/rss/thoitrang.rss"
        ));
        mTabs.add(new SamplePagerItem("Ngôi Sao", // Title
                Color.GREEN, // Indicator color
                Color.GRAY, // Divider color
                "http://ngoisao.net/rss/phong-cach.rss"
        ));
        mTabs.add(new SamplePagerItem("Tiin", // Title
                Color.GREEN, // Indicator color
                Color.GRAY, // Divider color
                "http://www.tiin.vn/rss/sao"
        ));
        // END_INCLUDE (populate_tabs)
    }

    /**
     * Inflates the {@link android.view.View} which will be displayed by this {@link android.support.v4.app.Fragment}, from the app's
     * resources.
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sample, container, false);
    }

    // BEGIN_INCLUDE (fragment_onviewcreated)
    /**
     * This is called after the {@link #onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)} has finished.
     * Here we can pick out the {@link android.view.View}s we need to configure from the content view.
     *
     * We set the {@link android.support.v4.view.ViewPager}'s adapter to be an instance of
     * {@link com.hungphandinh.technologies.SlidingTabsColorsFragment.SampleFragmentPagerAdapter}. The {@link SlidingTabLayout} is then given the
     * {@link android.support.v4.view.ViewPager} so that it can populate itself.
     *
     * @param view View created in {@link #onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)}
     */
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // BEGIN_INCLUDE (setup_viewpager)
        // Get the ViewPager and set it's PagerAdapter so that it can display items
        mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SampleFragmentPagerAdapter(getChildFragmentManager()));
        // END_INCLUDE (setup_viewpager)

        // BEGIN_INCLUDE (setup_slidingtablayout)
        // Give the SlidingTabLayout the ViewPager, this must be done AFTER the ViewPager has had
        // it's PagerAdapter set.
        mSlidingTabLayout = (SlidingTabLayout) view.findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);

        // BEGIN_INCLUDE (tab_colorizer)
        // Set a TabColorizer to customize the indicator and divider colors. Here we just retrieve
        // the tab at the position, and return it's set color
        mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {

            @Override
            public int getIndicatorColor(int position) {
                return mTabs.get(position).getIndicatorColor();
            }

            @Override
            public int getDividerColor(int position) {
                return mTabs.get(position).getDividerColor();
            }

        });
        // END_INCLUDE (tab_colorizer)
        // END_INCLUDE (setup_slidingtablayout)
    }
    // END_INCLUDE (fragment_onviewcreated)

    /**
     * The {@link android.support.v4.app.FragmentPagerAdapter} used to display pages in this sample. The individual pages
     * are instances of {@link ContentFragment} which just display three lines of text. Each page is
     * created by the relevant {@link com.hungphandinh.technologies.SlidingTabsColorsFragment.SamplePagerItem} for the requested position.
     * <p>
     * The important section of this class is the {@link #getPageTitle(int)} method which controls
     * what is displayed in the {@link SlidingTabLayout}.
     */
    class SampleFragmentPagerAdapter extends FragmentPagerAdapter {

        SampleFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        /**
         * Return the {@link android.support.v4.app.Fragment} to be displayed at {@code position}.
         * <p>
         * Here we return the value returned from {@link com.hungphandinh.technologies.SlidingTabsColorsFragment.SamplePagerItem#createFragment()}.
         */
        @Override
        public Fragment getItem(int i) {
            FragmentListCards fragmentListCards = (FragmentListCards) createFragment(i);
            fragmentListCardses.add(fragmentListCards);
            return fragmentListCards;
        }
        @Override
        public int getCount() {
            return mTabs.size();
        }

        // BEGIN_INCLUDE (pageradapter_getpagetitle)
        /**
         * Return the title of the item at {@code position}. This is important as what this method
         * returns is what is displayed in the {@link SlidingTabLayout}.
         * <p>
         * Here we return the value returned from {@link com.hungphandinh.technologies.SlidingTabsColorsFragment.SamplePagerItem#getTitle()}.
         */
        @Override
        public CharSequence getPageTitle(int position) {
            return mTabs.get(position).getTitle();
        }
        // END_INCLUDE (pageradapter_getpagetitle)

    }

    public void setViewMode(AdapterListCard.CARD_TYPE mode){
        mMode = mode;
        for (FragmentListCards fragmentListCards:fragmentListCardses){
            fragmentListCards.setCardType(mode);
        }
    }

    private Fragment createFragment(int position) {
        FragmentListCards fragmentListCards = new FragmentListCards();
        Bundle arrg = new Bundle();
        arrg.putInt(FragmentListCards.COLOR, 0xFFFFFFFF);
        arrg.putString(FragmentListCards.LINK,mTabs.get(position).mLink);
        fragmentListCards.setArguments(arrg);
        fragmentListCards.setContext(getActivity());
        fragmentListCards.setCardType(mMode);
        return fragmentListCards;
    }

}