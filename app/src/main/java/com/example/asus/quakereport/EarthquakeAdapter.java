package com.example.asus.quakereport;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import android.graphics.drawable.GradientDrawable;


public class EarthquakeAdapter extends ArrayAdapter {
    private static final String OFF_SET_STRING= "of";

    public EarthquakeAdapter(Context context, List<Earthquake> earthquakes) {
        super(context,0,earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        String offSet;
        String primary;
        if(listItemView==null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);

        }

        Earthquake currentEarthquake = (Earthquake) getItem(position);



        TextView magnitudeView = (TextView)listItemView.findViewById(R.id.magnitude);
        String formattedMagnitude = formatMagnitude(currentEarthquake.getMagnitude());
        magnitudeView.setText(formattedMagnitude);

        //GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground().mutate();
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());
        //magnitudeCircle.setColor(magnitudeColor);
        magnitudeView.setBackgroundColor(magnitudeColor);



        String originalLocation = currentEarthquake.getLocation();

        if(originalLocation.contains(OFF_SET_STRING)){
            String[] parts = originalLocation.split(OFF_SET_STRING);
            offSet=parts[0]+OFF_SET_STRING;
            primary=parts[1];
            }else{
            offSet = getContext().getString(R.string.near_the);
            primary =originalLocation;

        }


        TextView offsetView = (TextView)listItemView.findViewById(R.id.location_offset);
        offsetView.setText(offSet);

        TextView primaryView = (TextView)listItemView.findViewById(R.id.primary_location);
        primaryView.setText(primary);

        Date dateObject = new Date(currentEarthquake.getTimeInMillisseconds());
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy");
        String date = dateFormat.format(dateObject);
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(date);

        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm");
        String time = timeFormat.format(dateObject);
        TextView timeView = (TextView)listItemView.findViewById(R.id.time);
        timeView.setText(time);



        return listItemView;

    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

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
