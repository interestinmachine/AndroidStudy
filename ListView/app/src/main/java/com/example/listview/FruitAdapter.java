package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter<Fruit> {

    public int resourceId;

    public FruitAdapter(@NonNull Context context, int resource, @NonNull List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    static class ViewHolder {
        ImageView fruitImg;
        TextView fruitName;
    }

    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (null == convertView) {
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImg = view.findViewById(R.id.fruitImage);
            viewHolder.fruitName =  view.findViewById(R.id.fruitName);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        Fruit fruit = getItem(position);
        viewHolder.fruitImg.setImageResource(fruit.getImgId());
        viewHolder.fruitName.setText(fruit.getName());
        return view;
    }
}
