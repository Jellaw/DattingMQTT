package com.example.dattingfirebase.ui.dashboard.Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.example.dattingfirebase.R;
import com.example.dattingfirebase.ui.dashboard.Model.ItemModel;
import com.google.android.material.appbar.AppBarLayout;
import com.yuyakaido.android.cardstackview.Direction;
import com.yuyakaido.android.cardstackview.Duration;
import com.yuyakaido.android.cardstackview.SwipeAnimationSetting;

import java.util.List;

public class CardStackAdapter extends RecyclerView.Adapter<CardStackAdapter.ViewHolder> {

    private List<ItemModel> items;
    private Context context;
    private ClickReaction clickReaction;
    private int k=0;

    public CardStackAdapter(List<ItemModel> items, Context context, ClickReaction clickReaction) {
        this.items = items;
        this.context = context;
        this.clickReaction = clickReaction;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.setData(items.get(position));
        holder.imgX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SwipeAnimationSetting setting = new SwipeAnimationSetting.Builder()
                        .setDirection(Direction.Left)
                        .setDuration(Duration.Normal.duration)
                        .setInterpolator(new AccelerateInterpolator())
                        .build();
                clickReaction.setOnClick(setting);
                clickReaction.setOnImageClick(k);
            }
        });
        holder.imgTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SwipeAnimationSetting setting = new SwipeAnimationSetting.Builder()
                        .setDirection(Direction.Right)
                        .setDuration(Duration.Normal.duration)
                        .setInterpolator(new AccelerateInterpolator())
                        .build();
                clickReaction.setOnClick(setting);
                clickReaction.setOnImageClick(k);
            }
        });
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                k++;
                if(k%2==1) {
                    holder.name.setVisibility(View.INVISIBLE);
                    holder.city_sex.setVisibility(View.INVISIBLE);
                    CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) holder.appBarLayout.getLayoutParams();
                    AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) params.getBehavior();
                    behavior.setDragCallback(new AppBarLayout.Behavior.DragCallback() {
                        @Override
                        public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                            return true;
                        }
                    });
                }
                if(k%2==0){
                    holder.name.setVisibility(View.VISIBLE);
                    holder.city_sex.setVisibility(View.VISIBLE);
                    //=============set image in cardview when click=============================================
                    CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) holder.appBarLayout.getLayoutParams();
                    AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) params.getBehavior();
                    behavior.setDragCallback(new AppBarLayout.Behavior.DragCallback() {
                        @Override
                        public boolean canDrag(@NonNull AppBarLayout appBarLayout) {
                            return false;
                        }
                    });
                    //==============================================================================================
                }
                clickReaction.setOnImageClick(k);
                holder.name2.setText(holder.name.getText());
                holder.age2.setText(holder.age.getText());
                holder.address2.setText(holder.address.getText());
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image, imgX, imgT, imgTT, img1,img2,imgsex1,imgsex2;
        TextView name, age, address,name2,age2,address2;
        LinearLayout city_sex;
        AppBarLayout appBarLayout;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.item_image);
            name = itemView.findViewById(R.id.item_name);
            age = itemView.findViewById(R.id.item_age);
            address = itemView.findViewById(R.id.item_city);
            imgX = itemView.findViewById(R.id.cancelBtn);
            imgT = itemView.findViewById(R.id.likeBtn);
            imgTT = itemView.findViewById(R.id.loveBtn);
            city_sex=itemView.findViewById(R.id.city_and_sex);
            appBarLayout=itemView.findViewById(R.id.app_bar_layout);
            name2=itemView.findViewById(R.id.item_name2);
            age2=itemView.findViewById(R.id.item_age2);
            address2=itemView.findViewById(R.id.item_city2);
            img1 = itemView.findViewById(R.id.img1);
            img2 = itemView.findViewById(R.id.img2);
            imgsex1=itemView.findViewById(R.id.img_sex1);
            imgsex2=itemView.findViewById(R.id.img_sex2);

        }

        void setData(ItemModel data) {
            Glide.with(context)
                    .load(data.getImage())
                    .centerCrop()
                    .into(image);
            //load anh original resolution vao bitmap=========================
            Glide.with(context.getApplicationContext())
                    .load(data.getImage())
                    .asBitmap()
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            int w = resource.getWidth();
                            int h = resource.getHeight();
                            img1.setImageBitmap(resource);
                        }
                    });
            Glide.with(context.getApplicationContext())
                    .load(data.getImage())
                    .asBitmap()
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            int w = resource.getWidth();
                            int h = resource.getHeight();
                            img2.setImageBitmap(resource);
                        }
                    });
            //===================================================================
            Glide.with(context)
                    .load(R.drawable.cancer)
                    .override(100,100)
                    .skipMemoryCache(true)
                    .into(imgX);
            Glide.with(context)
                    .load(R.drawable.imgpsh_fullsize_anim)
                    .override(100,100)
                    .skipMemoryCache(true)
                    .into(imgT);
            Glide.with(context)
                    .load(R.drawable.imgpsh_fullsize)
                    .override(100,100)
                    .skipMemoryCache(true)
                    .into(imgTT);
            Glide.with(context)
                    .load(R.drawable.female)
                    .centerCrop()
                    .into(imgsex1);
            Glide.with(context)
                    .load(R.drawable.female)
                    .centerCrop()
                    .into(imgsex2);

            name.setText(data.getName());
            age.setText(data.getAge());
            address.setText(data.getAddress());
        }
    }

    public List<ItemModel> getItems() {
        return items;
    }

    public void setItems(List<ItemModel> items) {
        this.items = items;
    }
}
