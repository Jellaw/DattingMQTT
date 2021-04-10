package com.example.dattingfirebase.ui.chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dattingfirebase.R;
import com.example.dattingfirebase.ui.chat.Adapter.UserAdapter;
import com.example.dattingfirebase.ui.chat.Adapter.UserChatAdapter;
import com.example.dattingfirebase.ui.chat.Model.User;
import com.example.dattingfirebase.ui.chat.Model.UserChat;

import java.util.ArrayList;

public class ChattingFragment extends Fragment {
    private ArrayList<User> users = new ArrayList<>();
    ArrayList<UserChat> userChats = new ArrayList<>();
    RecyclerView recyclerViewUser;
    RecyclerView recyclerViewUserChat;

    private com.example.dattingfirebase.ui.chat.ChatViewModel chatViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.chat_tab_layout, container, false);

        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerViewUser = view.findViewById(R.id.rcv_user);
        recyclerViewUserChat = view.findViewById(R.id.rcv_userChat);

        addUser();
        addUserChat();
    }

    private void addUser() {
        users.add(new User(R.drawable.avt, "Su"));
        users.add(new User(R.drawable.huyen, "Huyền"));
        users.add(new User(R.drawable.susu, "SuSu"));
        users.add(new User(R.drawable.avt, "Su"));
        users.add(new User(R.drawable.susu, "Thu"));
        users.add(new User(R.drawable.huyen, "Vịt"));
        users.add(new User(R.drawable.avt, "Su"));
        initRecyclerViewUser();
    }

    private void initRecyclerViewUser() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewUser.setLayoutManager(layoutManager);
        UserAdapter adapter = new UserAdapter(users, getContext());
        recyclerViewUser.setAdapter(adapter);
    }

    private void addUserChat() {
        userChats.add(new UserChat(R.drawable.avt, R.drawable.cham_xanh, "Nam Anh", "Su khủng long","30 phút" ,"1"));
        userChats.add(new UserChat(R.drawable.huyen, R.drawable.cham_xanh, "Huyền", "Đây là đâu","10 phút" ,"2"));
        userChats.add(new UserChat(R.drawable.susu, R.drawable.cham_xanh, "Quỳnh Thu", "Susu SV","3 phút" ,"1"));
        userChats.add(new UserChat(R.drawable.huyen, R.drawable.cham_xanh, "Nguyễn Thị", "Con vịt","Thứ 4" ,"5"));
        userChats.add(new UserChat(R.drawable.avt, R.drawable.cham_xanh, "Đặng Thanh", "Hôm nay ăn gì vậy?","3 giờ" ,"1"));
        userChats.add(new UserChat(R.drawable.susu, R.drawable.cham_xanh, "Vũ Nam", "Ngày mai đi đâu?","30/2/1972" ,"4"));
        userChats.add(new UserChat(R.drawable.avt, R.drawable.cham_xanh, "Thảo", "Thần thánh","5 giờ" ,"1"));
        initRecyclerViewUserChat();
    }

    private void initRecyclerViewUserChat() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerViewUserChat.setLayoutManager(layoutManager);
        UserChatAdapter adapter = new UserChatAdapter(userChats, getContext());
        recyclerViewUserChat.setAdapter(adapter);
    }

}
