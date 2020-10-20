package com.example.dattingfirebase.ui.chat.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.dattingfirebase.ChattingActivity;
import com.example.dattingfirebase.R;
import com.example.dattingfirebase.ui.chat.Model.UserChat;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserChatAdapter extends RecyclerView.Adapter<UserChatAdapter.Viewholder> {
    ArrayList<UserChat> userChats;
    Context context;

    public UserChatAdapter(ArrayList<UserChat> userChats, Context context) {
        this.userChats = userChats;
        this.context = context;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycker_framechat_user_chat, parent, false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Viewholder holder, int position) {
        //Glide fix lag load image
        Glide.with(context)
                .load(userChats.get(position).getImgUserChat())
                .centerCrop()
                .into(holder.civ_image);
        Glide.with(context)
                .load(userChats.get(position).getImgChamXanh())
                .centerCrop()
                .into(holder.cim_chamXanh);

        holder.tv_name.setText(userChats.get(position).getNameUserChat());
        holder.tv_text.setText(userChats.get(position).getTextUserChat());
        holder.tv_time.setText(userChats.get(position).getTimeUserChat());
        holder.tv_number.setText(userChats.get(position).getNumberUserChat());


        final int img = userChats.get(position).getImgUserChat();
        final String nameUser = userChats.get(position).getNameUserChat();


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ChattingActivity.class);
                holder.itemView.setBackgroundColor(Color.parseColor("#80EDEAEA"));
                intent.putExtra("img_ava", img);
                intent.putExtra("nameUser", nameUser);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return userChats.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        CircleImageView civ_image, cim_chamXanh;
        TextView tv_name, tv_text, tv_time, tv_number;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            civ_image = itemView.findViewById(R.id.civ_image);
            cim_chamXanh = itemView.findViewById(R.id.cim_chamXanh);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_text = itemView.findViewById(R.id.tv_text);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_number = itemView.findViewById(R.id.tv_number);
        }
    }
}
