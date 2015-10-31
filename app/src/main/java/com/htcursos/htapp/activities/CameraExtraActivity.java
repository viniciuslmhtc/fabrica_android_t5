package com.htcursos.htapp.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.htcursos.htapp.R;
import com.htcursos.htapp.models.User;
import com.htcursos.htapp.utils.Constants;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by viniciuslm on 31/10/15.
 */
public class CameraExtraActivity extends AppCompatActivity {

    @Bind(R.id.user_image)
    ImageView userImage;
    @Bind(R.id.user_email)
    EditText userEmail;
    @Bind(R.id.user_name)
    EditText userName;

    private static final int CAMERA_REQUEST = 123;

    private User user;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_extra);
        ButterKnife.bind(this);
        user = new User();
    }

    @OnClick(R.id.user_image)
    public void changeImage(){
        Intent cameraAction = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraAction, CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_REQUEST && resultCode == RESULT_OK){
            bitmap = (Bitmap) data.getExtras().get("data");
            userImage.setImageBitmap(bitmap);
        }else{
            Toast.makeText(CameraExtraActivity.this, "Imagem não carregada", Toast.LENGTH_SHORT).show();
        }
    }

    @OnClick(R.id.btn_ok)
    public void registerUser(){
        user.setName(userName.getText().toString());
        user.setEmail(userEmail.getText().toString());
        startActivity(new Intent(CameraExtraActivity.this, UserInfoActivity.class)
                .putExtra(Constants.EXTRA_FOR_USER_INFO, user)
                .putExtra(Constants.EXTRA_FOR_USER_INFO_IMAGE, bitmap));
    }

}
