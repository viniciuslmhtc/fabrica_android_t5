package com.htcursos.htapp.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.htcursos.htapp.R;
import com.htcursos.htapp.models.User;
import com.htcursos.htapp.utils.Constants;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by viniciuslm on 31/10/15.
 */
public class UserInfoActivity extends AppCompatActivity {

    @Bind(R.id.user_image)
    ImageView userImage;
    @Bind(R.id.user_email)
    TextView userEmail;
    @Bind(R.id.user_name)
    TextView userName;
    @Bind(R.id.btn_back)
    TextView btnBack;

    private User user;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        ButterKnife.bind(this);
        if (getIntent().getExtras().containsKey(Constants.EXTRA_FOR_USER_INFO)
                && getIntent().getExtras().containsKey(Constants.EXTRA_FOR_USER_INFO_IMAGE)) {
            user = (User) getIntent().getExtras().getSerializable(Constants.EXTRA_FOR_USER_INFO);
            bitmap = getIntent().getExtras().getParcelable(Constants.EXTRA_FOR_USER_INFO_IMAGE);
        }
        if (user != null) {
            if (bitmap != null) {
                userImage.setImageBitmap(bitmap);
            }
            userEmail.setText(user.getEmail());
            userName.setText(user.getName());
        }
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
