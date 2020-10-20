package com.example.dattingfirebase.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.dattingfirebase.R;
import com.example.dattingfirebase.ui.home.Adapter.CompassAdapter;
import com.example.dattingfirebase.ui.home.Adapter.CustomItemDecorator;
import com.example.dattingfirebase.ui.home.Model.UserCompass;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView gv_listUserCompass;
    ArrayList<UserCompass> userCompasses;
    CompassAdapter userCompassAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_compass, container, false);
        init(root);
        return root;
    }

   private void init(View root) {
       gv_listUserCompass = root.findViewById(R.id.gv_listUserCompass);
       userCompasses = new ArrayList<>();

       addUserCompass();

       StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
       manager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
       gv_listUserCompass.addItemDecoration(new CustomItemDecorator(getResources().getDimensionPixelSize(R.dimen._16sdp), getResources().getDimensionPixelSize(R.dimen._90sdp)));
       gv_listUserCompass.setLayoutManager(manager);
       gv_listUserCompass.setHasFixedSize(true);
       userCompassAdapter = new CompassAdapter(userCompasses, getContext());
       gv_listUserCompass.setAdapter(userCompassAdapter);
   }
    private void addUserCompass() {
        userCompasses.add(new UserCompass(R.drawable.avt, R.drawable.cham_xanh,"1"));
        userCompasses.add(new UserCompass(R.drawable.avt2,R.drawable.cham_xanh, "2"));
        userCompasses.add(new UserCompass(R.drawable.avt2, R.drawable.cham_xanh,"3"));
        userCompasses.add(new UserCompass(R.drawable.avt, R.drawable.cham_xanh,"4"));
        userCompasses.add(new UserCompass(R.drawable.avt2, R.drawable.cham_xanh,"5"));
        userCompasses.add(new UserCompass(R.drawable.avt2, R.drawable.cham_xanh,"6"));
        userCompasses.add(new UserCompass(R.drawable.avt2, R.drawable.cham_xanh,"7"));
        userCompasses.add(new UserCompass(R.drawable.avt, R.drawable.cham_xanh,"8"));
        userCompasses.add(new UserCompass(R.drawable.avt2,R.drawable.cham_xanh, "9"));
        userCompasses.add(new UserCompass(R.drawable.avt2, R.drawable.cham_xanh,"10"));
        userCompasses.add(new UserCompass(R.drawable.avt2,R.drawable.cham_xanh,"11"));
        userCompasses.add(new UserCompass(R.drawable.avt, R.drawable.cham_xanh,"12"));
    }
}
