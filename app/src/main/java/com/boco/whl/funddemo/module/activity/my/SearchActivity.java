package com.boco.whl.funddemo.module.activity.my;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.boco.whl.funddemo.R;
import com.boco.whl.funddemo.utils.PrintfUT;
import com.boco.whl.funddemo.utils.net.NetworkUT;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Administrator
 */
public class SearchActivity extends Activity {


    @BindView(R.id.ll_no_network)
    LinearLayout llNoNetwork;
    @BindView(R.id.refresh_iv)
    ImageView refreshIv;
    @BindView(R.id.refresh_tv)
    TextView refreshTv;
    @BindView(R.id.setnet_btn)
    Button setnetBtn;
    @BindView(R.id.baidu_view)
    WebView baiduView;
    private byte[] picByte;
    ProgressDialog dialog;
    private Context context = SearchActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        showImage();
    }

    private void showImage() {
        boolean flag = NetworkUT.getInstance().isConnected(SearchActivity.this) &&
                NetworkUT.getInstance().isAvailable(SearchActivity.this);
        dialog = new ProgressDialog(SearchActivity.this);
        dialog.setMessage("加载中");
        dialog.show();
        if (flag) {
            llNoNetwork.setVisibility(View.GONE);
            baiduView.getSettings().setJavaScriptEnabled(true);
            baiduView.requestFocus();
            baiduView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
            baiduView.loadUrl("http://www.baidu.com");
            dialog.dismiss();
        } else {
            llNoNetwork.setVisibility(View.VISIBLE);
            PrintfUT.getInstance().showShortToast(context, "网络无连接");
            dialog.dismiss();
        }
    }

    @OnClick({R.id.refresh_iv, R.id.refresh_tv, R.id.setnet_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.refresh_iv:
                showImage();
                break;
            case R.id.refresh_tv:
                showImage();
                break;
            case R.id.setnet_btn:
                Intent intent = new Intent(Settings.ACTION_SETTINGS);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
