package sg.edu.rp.c346.id20010021.teamtrackersimplified;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Match> MatchList;
    int requestCode = 9;
    CustomAdapter matchstuff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setTitle("show match");

        lv = (ListView) this.findViewById(R.id.lv);


        DBHelper dbh = new DBHelper(this);
        MatchList = dbh.getAllMatch();
        dbh.close();

        //adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, songList);
        matchstuff = new CustomAdapter(this, R.layout.row, MatchList);
        lv.setAdapter(matchstuff);


    }
}
