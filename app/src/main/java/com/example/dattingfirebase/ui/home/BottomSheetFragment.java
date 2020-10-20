package com.example.dattingfirebase.ui.home;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.dattingfirebase.R;
import com.example.dattingfirebase.ui.home.Adapter.DialogAdapter;
import com.example.dattingfirebase.ui.home.Model.UserDialog;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;
import com.yuyakaido.android.cardstackview.SwipeableMethod;

import java.util.ArrayList;

public class BottomSheetFragment extends BottomSheetDialogFragment {
    CardStackView cardStackView;
    BottomSheetBehavior bottomSheetBehavior;

    public static BottomSheetFragment newInstance() {
        BottomSheetFragment fragment = new BottomSheetFragment();
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(), R.layout.fragment_bottom_sheet, null);
        cardStackView = view.findViewById(R.id.card_stack_view_dialog);
        //set cardStackView

        CardStackLayoutManager  manager = new CardStackLayoutManager(getContext());
        cardStackView.setLayoutManager(manager);
        cardStackView.setHasFixedSize(true);
        DialogAdapter dialogAdapter = new DialogAdapter(addList(), getContext());
        cardStackView.setAdapter(dialogAdapter);
        // set view
        dialog.setContentView(view);
        // set color
        ((View) view.getParent()).setBackgroundColor(getResources().getColor(android.R.color.transparent));
        bottomSheetBehavior = BottomSheetBehavior.from((View) view.getParent());
        bottomSheetBehavior.setPeekHeight(0);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if(newState==BottomSheetBehavior.STATE_COLLAPSED){
                    dismiss();
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
        manager.setCanScrollHorizontal(false);
        manager.setSwipeableMethod(SwipeableMethod.Manual);
        return dialog;
    }
    private ArrayList<UserDialog> addList() {
        ArrayList<UserDialog> items = new ArrayList<>();
        items.add(new UserDialog(R.drawable.avt, "Nam Anh ocs chos", "24", "Jember"));
        return items;
    }

}