package web.st.cn.webviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        webview = (WebView) findViewById(R.id.webview);
        //设置WebView属性，能够执行JavaScript脚本
        webview.getSettings().setJavaScriptEnabled(true);
        //加载URL内容
        //http://www2.sinorama.ca/sinorama/index.php?id=home&screen_check=yes&change_lang=English&change_office=montreal&
        //webview.loadUrl("http://www.sinorama.ca");
        //webview.loadUrl("http://www2.sinorama.ca/sinorama/index.php?id=home&screen_check=yes&change_lang=English&change_office=montreal&");
        webview.loadUrl("http://www.sinoramaworld.com");
        //设置web视图客户端
        webview.setWebViewClient(new MyWebViewClient());
    }

    //设置回退
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
            webview.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    //web视图客户端
    public class MyWebViewClient extends WebViewClient {
        public boolean shouldOverviewUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}

