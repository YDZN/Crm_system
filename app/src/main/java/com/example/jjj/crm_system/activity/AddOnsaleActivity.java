package com.example.jjj.crm_system.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jjj.crm_system.R;
import com.example.jjj.crm_system.service.po.Activity;
import com.example.jjj.crm_system.ui.Base.BaseActivity;
import com.example.jjj.crm_system.utils.ActivityUtil;

public class AddOnsaleActivity extends BaseActivity {
    private ImageView iv_back;
    private TextView et_name;
    private ImageView iv_pic;
    private Button bt_uploadpic;
    private TextView et_intro;
    private TextView et_start,et_end;
    private Button bt_ok;

    private String name,starttime,endtime,detail;




    /**
     * 加载UI前的预初始化
     */
    @Override
    protected void init() {

    }

    /**
     * 加载布局
     *
     * @return 布局id
     */
    @Override
    protected int getRootView() {
        return R.layout.activity_add_onsale;
    }

    /**
     * 设置监听器
     */
    @Override
    protected void setListener() {
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtil.finishActivty();
            }
        });

        //上传活动图片
        bt_uploadpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //上传新活动
        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = et_name.getText().toString();
                starttime = et_start.getText().toString();
                endtime = et_end.getText().toString();
                detail = et_intro.getText().toString();

                if(starttime==null||name.equals("")){
                    Toast.makeText(getBaseContext(),"请输入开始时间！",Toast.LENGTH_LONG).show();
                    return;
                }
                if(name==null||name.equals("")){
                    Toast.makeText(getBaseContext(),"请输入活动名称！",Toast.LENGTH_LONG).show();
                    return;
                }
                if(endtime==null||name.equals("")){
                    Toast.makeText(getBaseContext(),"请输入截止时间！",Toast.LENGTH_LONG).show();
                    return;
                }
                if(detail==null||name.equals("")){
                    Toast.makeText(getBaseContext(),"请添加活动描述！！",Toast.LENGTH_LONG).show();
                    return;
                }

                Activity newActivity = new Activity();
                newActivity.setActivitycuttime(endtime);
                newActivity.setActivitydetail(detail);
                newActivity.setActivityname(name);
                newActivity.setActivitystarttime(starttime);

            }
        });

    }

    /**
     * 请求数据，设置UI
     */
    @Override
    protected void initData() {
        iv_back = (ImageView)findViewById(R.id.iv_back_addonsale);
        et_name = (EditText)findViewById(R.id.et_onsaledetail_addonsale);
        et_intro = (EditText)findViewById(R.id.et_onsaledetail_addonsale);
        et_start = (EditText)findViewById(R.id.et_starttime_addonsale);
        et_end = (EditText)findViewById(R.id.et_endtime_addonsale);
        bt_uploadpic = (Button)findViewById(R.id.bt_uploadpic_addonsale);
        bt_ok = (Button)findViewById(R.id.bt_ok_addonsale);


    }
}