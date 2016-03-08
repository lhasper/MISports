package wmich.edu.lab3lhaspe0925;

import android.app.Activity;
//import android.database.DataSetObserver;
//import android.support.v7.app.AppCompatActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
//import android.widget.ListAdapter;
import android.widget.Toast;

public class ImageGridActivity extends Activity {
    Integer[] Sports = {R.drawable.andredrummond, R.drawable.barrysanders, R.drawable.cabrera, R.drawable.calvinjohnson, R.drawable.miracleonice, R.drawable.webber_01};
    ImageView imgSports;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_grid);


        GridView gridView = (GridView) findViewById(R.id.gvLayout);
        final ImageView imgSports = (ImageView) findViewById(R.id.imgImageHolder);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),"selected sport " + (position+1),Toast.LENGTH_SHORT).show();
                imgSports.setImageResource(Sports[position]);

            }
        });
    }
    public class ImageAdapter extends BaseAdapter {
        private Context imageAdapterContext;
        public ImageAdapter(Context c){
            imageAdapterContext=c;

    }


        @Override
        public int getCount() {
            return Sports.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            imgSports = new ImageView(imageAdapterContext);
            imgSports.setImageResource(Sports[position]);
            imgSports.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            imgSports.setLayoutParams(new GridView.LayoutParams(330,300));
            return imgSports;
        }
    }
       /* gridView.setAdapter(new ListAdapter(this) {
            @Override
            public boolean areAllItemsEnabled() {
                return false;
            }

            @Override
            public boolean isEnabled(int position) {
                return false;
            }

            @Override
            public void registerDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public void unregisterDataSetObserver(DataSetObserver observer) {

            }

            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }

            @Override
            public boolean hasStableIds() {
                return false;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return null;
            }

            @Override
            public int getItemViewType(int position) {
                return 0;
            }

            @Override
            public int getViewTypeCount() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }
        });*/
    }

