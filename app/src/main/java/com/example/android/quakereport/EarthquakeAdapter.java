package com.example.android.quakereport;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake>{


    public EarthquakeAdapter(@NonNull Context context, ArrayList<Earthquake> earthquakes) {
        super(context,0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);

        TextView magnitudeTextView = listItemView.findViewById(R.id.mag_text_view);
        DecimalFormat decimalFormat = new DecimalFormat("0.#");
        magnitudeTextView.setText(String.valueOf(decimalFormat.format(currentEarthquake.getMagnitude())));

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeTextView.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        TextView tsunamiTextView = listItemView.findViewById(R.id.tsunami_text_view);
        GradientDrawable tsunamiRectangle = (GradientDrawable) tsunamiTextView.getBackground();


        if (currentEarthquake.getTsunami() == 0) {
            tsunamiTextView.setText("No Tsunami");
            tsunamiRectangle.setColor(Color.parseColor("#BDBDBD"));
            //tsunamiTextView.setBackgroundColor(Color.parseColor("#BDBDBD"));
            Log.i("EarthquakeAdapter", "Color: Grey");
        } else if (currentEarthquake.getTsunami() == 1) {
            tsunamiTextView.setText("Tsunami");
            //tsunamiTextView.setBackgroundColor(Color.parseColor("#E53935"));
            //tsunamiTextView.setBackground(R.drawable.tsunami_rectangle);
            tsunamiRectangle.setColor(Color.parseColor("#4DB6AC"));
            Log.i("EarthquakeAdapter", "Color: Green");
        }






        //Location/offset TextView
        TextView locationTextView = listItemView.findViewById(R.id.location_text_view);
        TextView locationOffsetTextView = listItemView.findViewById(R.id.location_offset_text_view);

        if (currentEarthquake.getLocation().contains("of")){
            String[] locationSplit = currentEarthquake.getLocation().split("of ");

            locationTextView.setText(locationSplit[1]);
            locationOffsetTextView.setText(locationSplit[0] + "of");
        }


        //Formatting dates
        Date date = new Date(currentEarthquake.getTime());

        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        DateFormat dateFormat = new SimpleDateFormat("dd. MMM yyyy");

        String timeFormatted = timeFormat.format(date);
        String dateFormatted = dateFormat.format(date);

        TextView timeTextView = listItemView.findViewById(R.id.time_text_view);
        timeTextView.setText(String.valueOf(timeFormatted));

        TextView dateTextView = listItemView.findViewById(R.id.date_text_view);
        dateTextView.setText(String.valueOf(dateFormatted));

        return listItemView;
    }

    /**
     * Return the color for the magnitude circle based on the intensity of the earthquake.
     *
     * @param magnitude of the earthquake
     */
    private int getMagnitudeColor(double magnitude) {
        int magnitudeColorResourceId;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor) {
            case 0:
            case 1:
                magnitudeColorResourceId = R.color.magnitude1;
                break;
            case 2:
                magnitudeColorResourceId = R.color.magnitude2;
                break;
            case 3:
                magnitudeColorResourceId = R.color.magnitude3;
                break;
            case 4:
                magnitudeColorResourceId = R.color.magnitude4;
                break;
            case 5:
                magnitudeColorResourceId = R.color.magnitude5;
                break;
            case 6:
                magnitudeColorResourceId = R.color.magnitude6;
                break;
            case 7:
                magnitudeColorResourceId = R.color.magnitude7;
                break;
            case 8:
                magnitudeColorResourceId = R.color.magnitude8;
                break;
            case 9:
                magnitudeColorResourceId = R.color.magnitude9;
                break;
            default:
                magnitudeColorResourceId = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColorResourceId);
    }
}
