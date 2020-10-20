package com.example.dattingfirebase.ui.profile;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.example.dattingfirebase.Activity.MainActivity;
import com.example.dattingfirebase.Activity.ProfileActivity.EditAccountActivity;
import com.example.dattingfirebase.Activity.ProfileActivity.MyInfomationActivity;
import com.example.dattingfirebase.R;
import com.example.dattingfirebase.Activity.ProfileActivity.SettingActivity;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;


import static android.app.Activity.RESULT_OK;

public class ProfileFragment extends Fragment implements GoogleApiClient.OnConnectionFailedListener{
    private static final int CODE_SETTING = 100;
    ImageView avatar;
    TextView name;
    TextView age;
    ImageView setting_btn;
    TextView loadInfo;
    private static final int PICK_IMAGE = 1;
    Uri imageUri;
    //login google
    private GoogleApiClient googleApiClient;
    private GoogleSignInOptions gso;
    Button logoutBtn;


    private com.example.dattingfirebase.ui.profile.ProfileViewModel profileViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        profileViewModel =
                ViewModelProviders.of(this).get(com.example.dattingfirebase.ui.profile.ProfileViewModel.class);
        View root = inflater.inflate(R.layout.fragment_profile, container, false);
        init(root);
        return root;
    }
    private  void init(View root){
        loadInfo = root.findViewById(R.id.my_info);
        avatar = root.findViewById(R.id.avatar);
        name = root.findViewById(R.id.name_profile);
        age = root.findViewById(R.id.age_profile);
        setting_btn = root.findViewById(R.id.setting_btn_profile);
        logoutBtn= root.findViewById(R.id.logoutBtn);
        Glide.with(getActivity())
                .load(R.drawable.profile2)
                .into(avatar);
        name.setText("User");
        age.setText("20");
        //=================set action====================================
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//edit name
                Intent intent = new Intent(getActivity(), EditAccountActivity.class);
                final String acc_name = (String) name.getText();
                intent.putExtra("name", acc_name);
                startActivityForResult(intent, CODE_SETTING);
            }
        });
        setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SettingActivity.class);
                getActivity().startActivity(intent);
            }
        });
        loadInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MyInfomationActivity.class);
                final String acc_name = (String) name.getText();
                final String acc_age = (String) age.getText();
                intent.putExtra("name", acc_name);
                intent.putExtra("age", acc_age);
                getActivity().startActivity(intent);
            }
        });
        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, PICK_IMAGE);
            }
        });
        //login google=====================================================================================
        gso =  new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient=new GoogleApiClient.Builder(getActivity())
                .enableAutoManage(getActivity(),this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,gso)
                .build();
        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(
                        new ResultCallback<Status>() {
                            @Override
                            public void onResult(Status status) {
                                if (status.isSuccess()){
                                    gotoMainActivity();
                                }else{
                                    Toast.makeText(getContext(),"Session not close", Toast.LENGTH_LONG).show();
                                }
                            }
                        });
            }
        });

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==CODE_SETTING) {
            if (resultCode == 999) {
                name.setText(data.getStringExtra("ten"));
            }
        }
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            Glide.with(getActivity())
                    .load(imageUri)
                    .into(avatar);
        }
    }
    //login google===========================================================================================
    @Override
    public void onStart() {
        super.onStart();
        OptionalPendingResult<GoogleSignInResult> opr= Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if(opr.isDone()){
            GoogleSignInResult result=opr.get();
            handleSignInResult(result);
        }else{
            opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                @Override
                public void onResult(@NonNull GoogleSignInResult googleSignInResult) {
                    handleSignInResult(googleSignInResult);
                }
            });
        }
    }

    private void handleSignInResult(GoogleSignInResult result){
        if(result.isSuccess()){
            GoogleSignInAccount account=result.getSignInAccount();
            name.setText(account.getDisplayName());
            try{
                Glide.with(getActivity()).load(account.getPhotoUrl()).into(avatar);
            }catch (NullPointerException e){
                Toast.makeText(getActivity(),"image not found",Toast.LENGTH_LONG).show();
            }
        }
    }
    private void gotoMainActivity(){
        Intent intent=new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
        finishActivity();
    }
    //finish fragment=======================================================
    private void finishActivity() {
        if(getActivity() != null) {
            getActivity().finish();
        }
    }
    @Override
    public void onPause() {//fix error: Already managing a GoogleApiClient with id 0
        super.onPause();
        googleApiClient.stopAutoManage(getActivity());
        googleApiClient.disconnect();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
