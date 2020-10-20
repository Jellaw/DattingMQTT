package com.example.dattingfirebase.ui.home.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dattingfirebase.R;
import com.example.dattingfirebase.ui.home.BottomSheetFragment;
import com.example.dattingfirebase.ui.home.Model.UserCompass;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CompassAdapter extends RecyclerView.Adapter<CompassAdapter.ViewHolder> {
    ArrayList<UserCompass> userCompasses;
    Context context;

    public CompassAdapter(ArrayList<UserCompass> userCompasses, Context context) {
        this.userCompasses = userCompasses;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.compass_row_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
            Glide.with(context)
                    .load(userCompasses.get(position).getImg())
                    .centerCrop()
                    .into(holder.image_view);
        Glide.with(context)
                .load(userCompasses.get(position).getImgChamxanh())
                .centerCrop()
                .into(holder.cim_chamXanh);

        holder.text_view.setText(userCompasses.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "" + position, Toast.LENGTH_SHORT).show();
                BottomSheetFragment bottomSheetDialog = BottomSheetFragment.newInstance();
                bottomSheetDialog.show(((AppCompatActivity) context).getSupportFragmentManager(),"Bottom Sheet Dialog Fragment");

            }
        });

    }

    @Override
    public int getItemCount() {
        return userCompasses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView image_view, cim_chamXanh;
        TextView text_view;
        LinearLayout ll_item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_view = itemView.findViewById(R.id.image_view);
            text_view = itemView.findViewById(R.id.text_view);
            ll_item = itemView.findViewById(R.id.ll_item);
            cim_chamXanh = itemView.findViewById(R.id.cim_chamXanh);
        }

    }

}