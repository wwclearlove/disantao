package cdictv.disantao.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cdictv.disantao.R;

public class CarWeizahngActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText weizhang_edittext;
    private Button weizhang_query;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_weizahng);
        initView();
    }

    private void initView() {
        weizhang_edittext = (EditText) findViewById(R.id.weizhang_edittext);
        weizhang_query = (Button) findViewById(R.id.weizhang_query);

        weizhang_query.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.weizhang_query:

                break;
        }
    }

    private void submit() {
        // validate
        String edittext = weizhang_edittext.getText().toString().trim();
        if (TextUtils.isEmpty(edittext)) {
            Toast.makeText(this, "车牌号不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something
    }
}
