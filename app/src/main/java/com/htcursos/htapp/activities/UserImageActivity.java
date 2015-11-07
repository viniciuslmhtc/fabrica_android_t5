package com.htcursos.htapp.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.camera.CropImageIntentBuilder;
import com.htcursos.htapp.R;
import com.htcursos.htapp.models.User;
import com.htcursos.htapp.utils.Constants;

import java.io.File;

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
    private static final int CROP_REQUEST = 456;

    private Uri imageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_image);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.user_image)
    public void changeImage() {
        File image = new File(getExternalCacheDir(), "teste");
        imageUri = Uri.fromFile(image);
        Intent cameraAction = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraAction.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        startActivityForResult(cameraAction, CAMERA_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        File cropppedImage = new File(getFilesDir(), "testCropped.jpg");
        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            Uri croppedImageUri = Uri.fromFile(cropppedImage);
            CropImageIntentBuilder crop = new CropImageIntentBuilder(200, 200, croppedImageUri);
            crop.setOutlineCircleColor(0xFF03A9F4);
            crop.setSourceImage(imageUri);
            startActivityForResult(crop.getIntent(UserImageActivity.this), CROP_REQUEST);
        }else if(requestCode == CROP_REQUEST && resultCode == RESULT_OK){
            userImage.setImageBitmap(BitmapFactory.decodeFile(cropppedImage.getAbsolutePath()));
        } else {
            Toast.makeText(UserImageActivity.this, "Imagem não carregada", Toast.LENGTH_SHORT).show();
        }
    }

}










