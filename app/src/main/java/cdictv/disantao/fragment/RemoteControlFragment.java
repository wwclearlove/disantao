package cdictv.disantao.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import cdictv.disantao.R;


public class RemoteControlFragment extends Fragment {
    Boolean flag1 = false;
    Boolean flag2 = false;
    Boolean flag3 = false;
    Boolean flag4 = false;
    public RemoteControlFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.remote_control_layout, container, false);






        LinearLayout bian1 = inflate.findViewById(R.id.bian1);
        LinearLayout bian2 = inflate.findViewById(R.id.bian2);
        LinearLayout bian3 = inflate.findViewById(R.id.bian3);
        LinearLayout bian4 = inflate.findViewById(R.id.bian4);

        LinearLayout[] linearLayouts = new LinearLayout[]{bian1, bian2, bian3, bian4};

        final TextView left1 = inflate.findViewById(R.id.left1);
        final TextView right1 = inflate.findViewById(R.id.right1);

        final TextView left2 = inflate.findViewById(R.id.left2);
        final TextView right2 = inflate.findViewById(R.id.right2);

        final TextView left3 = inflate.findViewById(R.id.left3);
        final TextView right3 = inflate.findViewById(R.id.right3);

        final TextView left4 = inflate.findViewById(R.id.left4);
        final TextView right4 = inflate.findViewById(R.id.right4);


        left1.setBackgroundColor(Color.parseColor("#00FF33"));
        right1.setBackgroundColor(Color.parseColor("#FFFFFF"));
        left2.setBackgroundColor(Color.parseColor("#00FF33"));
        right2.setBackgroundColor(Color.parseColor("#FFFFFF"));
        left3.setBackgroundColor(Color.parseColor("#00FF33"));
        right3.setBackgroundColor(Color.parseColor("#FFFFFF"));
        left4.setBackgroundColor(Color.parseColor("#00FF33"));
        right4.setBackgroundColor(Color.parseColor("#FFFFFF"));


        bian1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag1) {
                    left1.setBackgroundColor(Color.parseColor("#00FF33"));
                    right1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    flag1=false;
                } else {
                    left1.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    right1.setBackgroundColor(Color.parseColor("#00FF33"));
                    flag1=true;
                }
            }
        });
        bian2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag2) {
                    left2.setBackgroundColor(Color.parseColor("#00FF33"));
                    right2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    flag2=false;
                } else {
                    left2.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    right2.setBackgroundColor(Color.parseColor("#00FF33"));
                    flag2=true;
                }
            }
        });
        bian3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag3) {
                    left3.setBackgroundColor(Color.parseColor("#00FF33"));
                    right3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    flag3=false;
                } else {
                    left3.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    right3.setBackgroundColor(Color.parseColor("#00FF33"));
                    flag3=true;
                }
            }
        });
        bian4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag4) {
                    left4.setBackgroundColor(Color.parseColor("#00FF33"));
                    right4.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    flag4=false;
                } else {
                    left4.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    right4.setBackgroundColor(Color.parseColor("#00FF33"));
                    flag4=true;
                }
            }
        });


        return inflate;

    }
}
