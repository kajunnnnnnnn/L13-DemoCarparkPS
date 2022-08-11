package sg.edu.rp.c346.id20026955.democarpark;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CarparkAdapter extends ArrayAdapter<Carpark> {
    Context parent_context;
    int layout_id;
    ArrayList<Carpark> al;

    public CarparkAdapter(Context context, int resource, ArrayList<Carpark> objects) {
        super(context, resource, objects);

        parent_context = context;
        layout_id = resource;
        al = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obtain the LayoutInflater object
        LayoutInflater inflater = (LayoutInflater)
                parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // "Inflate" the View for each row
        View rowView = inflater.inflate(layout_id, parent, false);

        // Obtain the UI components and do the necessary binding
        TextView tv = rowView.findViewById(R.id.tv);
        ImageView iv = rowView.findViewById(R.id.iv);

        // Obtain the Android Version information based on the position
        Carpark currentAvailability = al.get(position);

        // Set values to the TextView to display the corresponding information
        tv.setText(currentAvailability.toString());
        if (currentAvailability.getLeft().contains("0") ){
            Picasso.get().load("https://www.pdsigns.ie/contentFiles/productImages/Large/CPSA4.jpg").into(iv);
        } else {
            Picasso.get().load("https://i.pinimg.com/200x/c7/1a/7e/c71a7eb0e0033fdad04883570578b146.jpg").into(iv);
        }

        return rowView;
    }
}
