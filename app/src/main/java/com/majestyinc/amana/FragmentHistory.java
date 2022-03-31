package com.majestyinc.amana;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class FragmentHistory extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_history,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabLayout = view.findViewById(R.id.tabs);
        viewPager = view.findViewById(R.id.view_pager);
        tabLayout.setupWithViewPager(viewPager);

        HistoryAdapter historyAdapter = new HistoryAdapter(getChildFragmentManager(), FragmentPagerAdapter.BEHAVIOR_SET_USER_VISIBLE_HINT);
        historyAdapter.addFragment(new FragmentCredit(), "Credit");
        historyAdapter.addFragment(new FragmentDebit(), "Debit");
        viewPager.setAdapter(historyAdapter);
    }
}
