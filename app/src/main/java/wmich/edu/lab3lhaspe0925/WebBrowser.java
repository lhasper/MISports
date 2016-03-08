package wmich.edu.lab3lhaspe0925;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
//import android.view.Menu;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebBrowser extends AppCompatActivity {
    String strPistons = "http://www.nba.com/pistons/?hp=1&ls=iref:pistons:gameexp:returnbutton";
    String strLions = "http://www.detroitlions.com/";
    String strRedwings = "http://redwings.nhl.com/";
    String strTigers = "http://detroit.tigers.mlb.com/index.jsp?c_id=det";
    String[]arrStrWebChoices={"http://www.nba.com/pistons/?hp=1&ls=iref:pistons:gameexp:returnbutton",
            "http://www.detroitlions.com/","http://redwings.nhl.com/","http://detroit.tigers.mlb.com/index.jsp?c_id=det"};
    int[]arrIntWebChoice={0,1,2,3};
    String strDataFromMain="https://www.google.com/?gws_rd=ssl";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_browser);
        Button btnWebBack = (Button) findViewById(R.id.btnWebBack);
        final WebView wvSportsTeams = (WebView) findViewById(R.id.webViewTeams);
        wvSportsTeams.getSettings().setJavaScriptEnabled(true);
        //wvSportsTeams.getSettings().setPluginsEnabled(true);
        //Intent getTheIntent = getIntent();
        //Uri webSiteToLoad = getTheIntent.getData();
        // WebView webToDisplay = (WebView) findViewById(R.id.webViewTeams);
        strDataFromMain = getIntent().getStringExtra("passToWebActivity");
        // Uri.parse(strDataFromMain);
        webLoadActions(strDataFromMain,arrStrWebChoices,wvSportsTeams);


 /*       final AppCompatActivity appWebBrowser = this;
        wvSportsTeams.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                // Activities and WebViews measure progress with different
                // scales.
                // The progress meter will automatically disappear when we reach 100%
                appWebBrowser.setProgress(progress * 1000);

            }
        });*/


      /*  wvSportsTeams.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(appWebBrowser, description, Toast.LENGTH_SHORT).show();
            }
        });*/

        //wvSportsTeams.getSettings().setJavaScriptEnabled(true);


        //wvSportsTeams.getSettings().setpl(true);


       /* wvSportsTeams.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                // Activities and WebViews measure progress with different scales.
                // The progress meter will automatically disappear when we reach 100%
                wvSportsTeams.setProgress(progress * 1000);
            }
        });*/
     /*   webview.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                Toast.makeText(, description, Toast.LENGTH_SHORT)
                        .show();
            }

        });*/


        btnWebBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(WebBrowser.this, MainActivity.class));
                wvSportsTeams.onPause();
                wvSportsTeams.clearHistory();
                wvSportsTeams.destroy();

            }
        });
    }


        public void webLoadActions(String strDataFromMain, String[]arrStrWebChoices,WebView wvSportsTeams ){
        int i=0;

        wvSportsTeams.clearHistory();
           // wvSportsTeams.canGoBack();

        for (i=0; i<arrStrWebChoices.length;i++){
            if (strDataFromMain.equals(arrStrWebChoices[0])){
                wvSportsTeams.loadUrl(strDataFromMain);
            }if (strDataFromMain.equals(arrStrWebChoices[1])){
                wvSportsTeams.loadUrl(strDataFromMain);
            }if (strDataFromMain.equals(arrStrWebChoices[2])) {
                wvSportsTeams.loadUrl(strDataFromMain);
            }if (strDataFromMain.equals(arrStrWebChoices[3])) {
                wvSportsTeams.loadUrl(strDataFromMain);
            }

        }}



       /* if (strDataFromMain.equals(strPistons)) {
            //webToDisplay.destroy();

            wvSportsTeams.clearHistory();
            wvSportsTeams.loadUrl(strDataFromMain);
        } else if (strDataFromMain.equals(strLions)) {
            //webToDisplay.destroy();
            wvSportsTeams.clearHistory();
            wvSportsTeams.loadUrl(strDataFromMain);
        } else if (strDataFromMain.equals(strRedwings)) {
            //webToDisplay.destroy();
            wvSportsTeams.clearHistory();
            wvSportsTeams.loadUrl(strDataFromMain);
        } else if (strDataFromMain.equals(strTigers)) {
            //webToDisplay.destroy();
            wvSportsTeams.clearHistory();
            wvSportsTeams.loadUrl(strDataFromMain);
        } else {
            String strWebDefault = "https://www.google.com/";
            wvSportsTeams.clearHistory();
            wvSportsTeams.loadUrl(strWebDefault);
        }*/


    public boolean onKeyDown(int keycode, KeyEvent event) {
        if (keycode == KeyEvent.KEYCODE_BACK) {
            startActivity(new Intent(WebBrowser.this, MainActivity.class));

            //WebBrowser.this.onDestroy();

        }

        return super.onKeyDown(keycode, event);
    }

}


