package com.example.webviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView web01;
    private String url = "https://guafindel.tistory.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // xml의 WebView와 Activity의 아이디를 서로 연결
        web01 = (WebView)findViewById(R.id.web01);

        // 자바스크립트가 사용가능하게 설정
        web01.getSettings().setJavaScriptEnabled(true);
        // String값으로 설정해둔 url 로드
        web01.loadUrl(url);
        // 크롬 가능하게 설정
        web01.setWebChromeClient(new WebChromeClient());
        // 기본 웹 설정
        web01.setWebViewClient(new WebViewClientClass());


    }

    /**
     * 특정 행동으로 key값이 발생될 때(여기서는 뒤로가기) 이벤트를 발생시키는 메소드
     * 여기서는 뒤로가기를 눌렀을 때 키값이 뒤로가기인지 체크하고 또한 켜진 웹에서 뒤로가기가
     * 가능 할 때 웹에서 뒤로가기를 해준다는 설정
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if ((keyCode == KeyEvent.KEYCODE_BACK) && web01.canGoBack()) {
            web01.goBack();
            return true;
        }


        return super.onKeyDown(keyCode, event);
    }

    /**
     * 이너클래스 생성
     */
    private class WebViewClientClass extends WebViewClient {

        /**
         * 현재 페이지의 url을 읽어올 수 있는 메소드
         * 새 창을 읽어올수도 특정 페이지에서 기능을 넣을 수도 있다.
         * @param view
         * @param url
         * @return
         */
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url ) {
            view.loadUrl(url);
            return true;
        }
    }
}
