package sg.edu.rp.c346.id20010021.teamtrackersimplified;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {
    Context parent_context;
    int layout_id;
    ArrayList<Match> versionList;

    public CustomAdapter(Context context, int resource,
                         ArrayList<Match> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        versionList = objects;


    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tvTName1 = rowView.findViewById(R.id.tvTName1);
        TextView tvScore1 = rowView.findViewById(R.id.tvScore1);
        TextView tvTName2 = rowView.findViewById(R.id.tvTName2);
        TextView tvScore2 = rowView.findViewById(R.id.tvScore2);


        // Obtain the Android Version information based on the position
        Match currentVersion = versionList.get(position);

        // Set values to the TextView to display the corresponding information
        tvTName1.setText(currentVersion.getTeam());
        tvScore1.setText(currentVersion.getScore()+"");
        tvTName2.setText(currentVersion.getTeam2());
        tvScore2.setText(currentVersion.getScore2()+"");


//        int star=currentVersion.getStars();
//        String stars="";
//        for(int i=0; i<star; i++){
//            stars+="*";
//        }
//        tvStar.setText(stars);


        return rowView;
    }



}

