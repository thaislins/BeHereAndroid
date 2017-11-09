package br.ufrn.imd.behere.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import br.ufrn.imd.behere.R;

public class StudentResultActivity extends CustomActivity {

    public static final String PASSWORD_RESULT = "password_result";
    private ImageView imgResult;
    private TextView txtResult;
    private Button btnResult;
    private boolean resultSuccess;
    private String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_result);
        setup(savedInstanceState);
    }

    public void setup(Bundle savedInstanceState) {
        Intent intent = getIntent();
        result = intent.getStringExtra(PASSWORD_RESULT);

        imgResult = (ImageView) findViewById(R.id.imgResult);
        txtResult = (TextView) findViewById(R.id.txt_result);
        btnResult = (Button) findViewById(R.id.btn_result);
        checkResult();
    }

    public void checkResult() {
        if (result.equals("password")) {
            resultSuccess = true;
            imgResult.setImageResource(R.drawable.positive_result);
            txtResult.setText(R.string.result_success);
            btnResult.setText(R.string.result_ok);
        } else {
            resultSuccess = false;
            imgResult.setImageResource(R.drawable.negative_result);
            txtResult.setText(R.string.result_failed);
            btnResult.setText(R.string.result_try_again);
        }
    }

    public void performResultAction(View v) {
        Intent intent;
        if (resultSuccess == true) {
            intent = new Intent(this, StudentChooseActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        } else {
            intent = new Intent(this, StudentPasswordActivity.class);
        }
        startActivity(intent);
        finish();
    }
}
