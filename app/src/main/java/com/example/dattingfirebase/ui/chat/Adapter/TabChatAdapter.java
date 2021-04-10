package com.example.dattingfirebase.ui.chat.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.dattingfirebase.ui.chat.ChattingFragment;
import com.example.dattingfirebase.ui.chat.FriendsOnlineFragment;

public class TabChatAdapter extends FragmentStatePagerAdapter {
    private int numPage = 2;
    public TabChatAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0 : return  new ChattingFragment();
            case 1 : return new FriendsOnlineFragment();
            default:return new ChattingFragment();
        }
    }

    @Override
    public int getCount() {
        return numPage;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0 : return  "Chat" ;
            case 1 : return  "Online" ;
            default:return "Chat" ;
        }
    }
}