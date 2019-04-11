package cdictv.disantao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import cdictv.disantao.R;
import cdictv.disantao.util.Sputil;

public class ZHSZActivity extends AppCompatActivity {
    private ImageButton back;
    private TextView Default;
    private EditText et;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhsz);

        init();

    }

    private void init() {
        back = (ImageButton) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
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

        String yz = Sputil.getString("yz","50");
        Default.setText("我的1-4号车账户余额告警阈值为"+yz+"元");

    }

    public void sz(View view) {
        String trim = et.getText().toString().trim();
        if(!trim.isEmpty()){
            Sputil.putString("yz",trim);
            Default.setText("我的1-4号车账户余额告警阈值为"+trim+"元");
            et.setText("");
            Toast.makeText(this, "设置成功！！！", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "不能为空！！！", Toast.LENGTH_SHORT).show();
        }

    }
}
