package com.rhix.myapplicationjson;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class CustomAdapter implements ListAdapter {
    ArrayList<SubjectData> arrayList;
    Context context;

    public CustomAdapter(Context context, ArrayList<SubjectData> arrayList) {
        this.arrayList=arrayList;
        this.context=context;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return true;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final SubjectData subjectData=arrayList.get(position);
        if(convertView==null){
            LayoutInflater layoutInflater = LayoutInflater.from(context);
            convertView=layoutInflater.inflate(R.layout.list_view_layout, null);
            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    //i.setData(Uri.parse(subjectData.Number));
                    //context.startActivity(i);
                    Toast.makeText(context,subjectData.Number,Toast.LENGTH_LONG).show();
                }
            });
            TextView number=convertView.findViewById(R.id.number);
            TextView tittle=convertView.findViewById(R.id.title);
            ImageView imag=convertView.findViewById(R.id.list_image);
            number.setText(subjectData.Number);
            tittle.setText(subjectData.SubjectName);
            Picasso.get()
                    .load(subjectData.Image)
                    .error(R.drawable.ic_launcher_background)
                    .into(imag);

           /* https://square.github.io/picasso/ */

        }
        return convertView;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {
        return arrayList.size();
    }


    @Override
    public boolean isEmpty() {
        return false;
    }
}
