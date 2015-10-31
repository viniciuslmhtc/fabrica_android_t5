package com.htcursos.htapp.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
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
public class UserImageActivity extends AppCompatActivity {

    @Bind(R.id.user_image)
    ImageView userImage;

    private static final int CAMERA_REQUEST = 123;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_image);
        ButterKnife.bind(this);
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
            userImage.setImageBitmap((Bitmap) data.getExtras().get("data"));
        }else{
            Toast.makeText(UserImageActivity.this, "Imagem não carregada", Toast.LENGTH_SHORT).show();
        }
    }


}










