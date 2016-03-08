package wmich.edu.lab3lhaspe0925;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
    final String strDefaultToastMessage="Make a choice";
    String strTeamChoice="null";
    String strNba="http://www.nba.com/pistons/?hp=1&ls=iref:pistons:gameexp:returnbutton";
    String strNfl="http://www.detroitlions.com/";
    String strNhl="http://redwings.nhl.com/";
    String strMlb="http://detroit.tigers.mlb.com/index.jsp?c_id=det";

 /*   WebView wVPistons=(WebView)findViewById(R.id.webViewTeams);
    WebView wVLions=(WebView)findViewById(R.id.webViewTeams);
    WebView wVRedwings=(WebView)findViewById(R.id.webViewTeams);
    WebView wVTigers=(WebView)findViewById(R.id.webViewTeams);*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] arrSports ={"Detroit Pistons", "Detroit Lions", "Detroit Redwings", "Detroit Tigers", "Image Gallery", "Great Calls","Full Screen Image"};
        setListAdapter(new ArrayAdapter<String>(this,R.layout.activity_main,R.id.sports, arrSports));
            }

    protected void onListItemClick(ListView L, View V, int position, long id){

        //Switch with case statements based on position in list.

        switch(position){
            //case Detroit Pistons
            case 0:{
                strTeamChoice=strNba;
                Intent intentPistons=new Intent(MainActivity.this,WebBrowser.class);
                intentPistons.putExtra("passToWebActivity",strTeamChoice);
                startActivity(intentPistons);
                //startActivity(new Intent(MainActivity.this,WebBrowser.class));//Intent.ACTION_VIEW, Uri.parse("http://www.nba.com/pistons/?hp=1&ls=iref:pistons:gameexp:returnbutton")));
                break;
            }
            //case Detroit Lions
            case 1:{
                strTeamChoice=strNfl;
                Intent intentLions=new Intent(MainActivity.this,WebBrowser.class);
                intentLions.putExtra("passToWebActivity",strTeamChoice);
                startActivity(intentLions);
                break;
            }
            //case Detroit Redwings
            case 2:{
                strTeamChoice=strNhl;
                Intent intentRedwings=new Intent(MainActivity.this,WebBrowser.class);
                intentRedwings.putExtra("passToWebActivity",strTeamChoice);
                startActivity(intentRedwings);
                break;

            }
            //case Detroit Tigers
            case 3:{
                strTeamChoice=strMlb;
                Intent intentTigers=new Intent(MainActivity.this,WebBrowser.class);
                intentTigers.putExtra("passToWebActivity",strTeamChoice);
                startActivity(intentTigers);
                break;
            }
            //case Image Gallery
            case 4:{
                startActivity(new Intent(MainActivity.this,ImageGridActivity.class));
                break;
            }
            //case Great Calls
            case 5:{
                startActivity(new Intent(MainActivity.this,SportsSoundsActivity.class));
                break;
            }
            //case Full Screen Image
            case 6:{
                startActivity(new Intent(MainActivity.this,ImgFullScreen.class));
                break;
            }
            //case default
            default:{
                Toast.makeText(MainActivity.this,strDefaultToastMessage,Toast.LENGTH_LONG).show();
                break;

            }
        }//end Switch
    }//end onListItemClick method
}//end OnCreate method

