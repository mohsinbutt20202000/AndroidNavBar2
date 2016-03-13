package mohsin.com.androidnavbar2;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class Business1 extends AppCompatActivity {
 ActionBar actionBar;
    ImageView imageView;
    TextView texView;
    MainActivity custome;
    int posi;
    int array[]= {R.drawable.businesscloc,R.drawable.instituteclock,R.drawable.birthdayclock,R.drawable.prayercloc,R.drawable.familycloc,R.drawable.sportscloc,R.drawable.othercloc};
    String title[] = {"Business Event", "Institute Event", "Birthday Event","Prayer Time","Family Time","Sports Time","Others"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business1);

        imageView= (ImageView)findViewById(R.id.imgView);
        texView = (TextView)findViewById(R.id.mainView);

        Intent intent= getIntent();
        Bundle b= intent.getExtras();

        posi=  b.getInt("position");
        Log.v("function", String.valueOf(posi));
        texView.setText(title[posi]);
        imageView.setImageResource(array[posi]);


    }



}
