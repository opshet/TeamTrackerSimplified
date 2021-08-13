package sg.edu.rp.c346.id20010021.teamtrackersimplified;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ETeam1, ETeam2, ETeam1Score, ETeam2Score;
    Button btnInsert, btnShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ETeam1 = findViewById(R.id.ETeam1);
        ETeam2 = findViewById(R.id.ETeam2);
        ETeam1Score = findViewById(R.id.ETeam1Score);
        ETeam2Score = findViewById(R.id.ETeam2Score);
        btnInsert = findViewById(R.id.btnInsertSong);
        btnShowList = findViewById(R.id.btnShowList);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String team1 = ETeam1.getText().toString().trim();
                String team2 = ETeam2.getText().toString().trim();
                String team1score = ETeam1Score.getText().toString().trim();
                String team2score = ETeam2Score.getText().toString().trim();
                if (team1.length() == 0 || team2.length() == 0) {
                    Toast.makeText(MainActivity.this, "Incomplete data", Toast.LENGTH_SHORT).show();
                    return;
                }


                int ts1 = Integer.valueOf(team1score);
                int ts2 = Integer.valueOf(team2score);


                DBHelper dbh = new DBHelper(MainActivity.this);
                long result = dbh.insertMatch(team1, ts1, team2, ts2);

                if (result != -1) {
                    Toast.makeText(MainActivity.this, "Match inserted", Toast.LENGTH_LONG).show();
                    ETeam1.setText("");
                    ETeam2.setText("");
                    ETeam1Score.setText("");
                    ETeam2Score.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Insert failed", Toast.LENGTH_LONG).show();
                }


            }
        });
    }
}