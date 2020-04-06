package com.example.loginregdb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.loginregdb.R;
import com.example.loginregdb.Student;

import java.nio.FloatBuffer;
import java.util.ArrayList;

public class adapter extends BaseAdapter {
    Context context;
    ArrayList<Student> list;


    public adapter(Context applicationContext, ArrayList<Student> arrayList) {
        this.context=applicationContext;
        this.list=arrayList;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=LayoutInflater.from(context).inflate(R.layout.demo,parent,false);

        TextView titem,tsale,tpurchase;


        Student student=list.get(position);
        titem=convertView.findViewById(R.id.txtitem);
        tsale=convertView.findViewById(R.id.txtsale);
        tpurchase=convertView.findViewById(R.id.txtpurchase);

        titem.setText(String.valueOf(student.getItem()));
        tsale.setText(student.getSale());
        tpurchase.setText(student.getPurchase());
        return convertView;

    }

}
