package cdictv.disantao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import cdictv.disantao.R;

public class ZHSZActivity extends AppCompatActivity {
    private TextView Default;
    private EditText et;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhsz);

        init();

    }

    private void init() {
        Default = (TextView) findViewById(R.id.Default);
        et = (EditText) findViewById(R.id.et);
        et.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.length()==1&&s.toString().equals("0")){
                    et.setText("");
                }
            }
        });
    }

    public void sz(View view) {
        String trim = et.getText().toString().trim();


    }
}
