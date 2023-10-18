package com.lenguyendangdinh.customizedlistview;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.lenguyendangdinh.customizedtestview.R;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class CountryAdapter extends BaseAdapter {
    private ArrayList<Country> dsQuocGia;// nguon du lieu
    private Context context;
    private LayoutInflater inflater;// XML <--> Java

    public CountryAdapter(ArrayList<Country> dsQuocGia, Context context) {
        this.dsQuocGia = dsQuocGia;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }
    class ControlHolder{ // tuong ung voi file item layout
        ImageView imageViewFlag;
        TextView textViewName;
        TextView textViewPopulation;
    }

    @Override
    public int getCount() {
        return dsQuocGia.size();
    }

    @Override
    public Object getItem(int i) {
        return dsQuocGia.get(i);
    }

    @Override
    public long getItemId(int i) {// chua dung den
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // get Item's View for setting data
        ControlHolder itemControlHolder; // stores refs to XML
        if (view == null){
            view= inflater.inflate(R.layout.item_layout_country,null);
            //set refs for controls

            Country nation = dsQuocGia.get(i);
            itemControlHolder = new ControlHolder();
            itemControlHolder.textViewName = view.findViewById(R.id.textView);
            itemControlHolder.textViewPopulation = view.findViewById(R.id.textView2);

            int idImage = context.getResources().getIdentifier(nation.getCountryFlag(), "mipmap", context.getPackageName());
            itemControlHolder.imageViewFlag.setImageResource(idImage);
            //
            view.setTag(itemControlHolder);
        }
        else {
            itemControlHolder = (ControlHolder)view.getTag();
        }
        // set Data for controls which hold in itemControlHolder
        // data
        Country nation1 = dsQuocGia.get(i);
        itemControlHolder.textViewName.setText(nation1.getCountryName());
        itemControlHolder.textViewPopulation.setText("Population: " + nation1);
        // image
        int resImageID = context.getResources().getIdentifier(
                nation1.getCountryFlag(),
                "mipmap",
                context.getPackageName() );
        itemControlHolder.imageViewFlag.setImageResource(resImageID);
        return view;
    }

}
