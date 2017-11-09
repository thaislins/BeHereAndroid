package br.ufrn.imd.behere.activities;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import br.ufrn.imd.behere.R;

public class StudentChooseActivity extends CustomActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        // Adds back arrow to layout
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    public void chooseQRCode(View v) {
        Intent camera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(camera);
    }

    public void choosePassword(View v) {
        Intent intent = new Intent(StudentChooseActivity.this, StudentPasswordActivity.class);
        startActivity(intent);
    }

}
