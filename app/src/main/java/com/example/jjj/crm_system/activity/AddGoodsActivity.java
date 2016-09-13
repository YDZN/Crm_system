package com.example.jjj.crm_system.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.jjj.crm_system.R;
import com.example.jjj.crm_system.service.po.Goods;
import com.example.jjj.crm_system.ui.Base.BaseActivity;
import com.example.jjj.crm_system.utils.ActivityUtil;

public class AddGoodsActivity extends BaseActivity {
    private ImageView iv_back;
    private ImageView iv_good;
    private Button bt_uploadpic,bt_ok;
    private EditText et_name,et_price,et_details;
    private String goodName,goodDetails;
    private Float goodPrice;


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
        return R.layout.activity_add_goods;
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

        //点击按钮上传商品图片
        bt_uploadpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        //点击确定按钮上传商品信息
        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goodName = et_name.getText().toString();
                goodPrice = Float.valueOf(et_price.getText().toString());
                goodDetails = et_details.getText().toString();

                if(goodName==null||goodName.equals("")){
                    Toast.makeText(getBaseContext(),"商品名不能为空！",Toast.LENGTH_LONG).show();
                    return;
                }
                if(et_price.getText().toString()==null||goodPrice.equals("")){
                    Toast.makeText(getBaseContext(),"请输入价格！",Toast.LENGTH_LONG).show();
                    return;
                }
                if (goodDetails==null||goodDetails.equals("")){
                    Toast.makeText(getBaseContext(),"请添加描述！",Toast.LENGTH_LONG).show();
                    return;
                }

                Goods newGood = new Goods();
                newGood.setGoodsname(goodName);
                newGood.setGoodsmoney(goodPrice);
                newGood.setGoodsdetail(goodDetails);


            }
        });

    }

    /**
     * 请求数据，设置UI
     */
    @Override
    protected void initData() {
        iv_back = (ImageView)findViewById(R.id.iv_back_addgoods);
        iv_good = (ImageView)findViewById(R.id.iv_pic_addgoods);
        bt_uploadpic = (Button)findViewById(R.id.bt_uploadpic_addgoods);
        bt_ok = (Button)findViewById(R.id.bt_ok_addgoods);
        et_name = (EditText)findViewById(R.id.et_name_addgoods);
        et_price = (EditText)findViewById(R.id.et_price_addgoods);
        et_details = (EditText)findViewById(R.id.et_details_addgoods);

    }
}