package com.example.android.quakereport;


import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DateFormat;
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
        magnitudeTextView.setText(String.valueOf(currentEarthquake.getMagnitude()));




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
}
