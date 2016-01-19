package com.example.kimjh.recyclerviewpj;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimjh on 2016-01-20.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>implements OnItemClickListener {
    List<MyData> items = new ArrayList<MyData>();

    public void add(MyData data){
        items.add(data);
        notifyDataSetChanged();
    }//Adapter내에 데이터가 변경되면 AdapterView를 다시 그려야 하기 때문에 다시 그리기를 위한 notifyDataSetChanged()함수를 호출한다.

    OnItemClickListener OnItemClickListener;
    public void setOnItemClickListener(OnItemClickListener listener){
        OnItemClickListener = listener;
    }

    @Override
    public void onItemClick(View view, int position) {
        if(OnItemClickListener != null){
            OnItemClickListener.onItemClick(view, position);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.view_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);       //??
        holder.setOnItemClickListener(this);                //??
        return holder;
    }   //ChildView를 관리할 ViewHolder를 생성하여 넘겨준다.

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.setData(items.get(position));    //??
    }   //ViewHolder에 데이터를 설정해준다.

    @Override
    public int getItemCount() {
        return items.size();
    }   // RecyclerView를 통해 보여줄 Item개수.

    public MyData getItem (int position){           //??
        if(position < 0 || position >= items.size())return null;
        return items.get(position);
    }


}
