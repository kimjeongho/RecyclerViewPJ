package com.example.kimjh.recyclerviewpj;

import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kimjh on 2016-01-19.
 */
public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView titleView;
    ImageView iconView;
    MyData data;
    public OnItemClickListener itemClickListener;   //OnItemClickListener사용

    public void setOnItemClickListener(OnItemClickListener listener){
        itemClickListener = listener;
    }   //item이 눌렸을때 알고 싶은 객체들이 자신을 등록할 수 있는 함수를 만들어 준다.

    public MyViewHolder(View itemView) {
        super(itemView);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(v,getAdapterPosition());
                }
            }
        });
        //item이 눌렸을 때 알기를 원하는 객체가 있는지 확인하여 if (itemClickListener != null)
        //객체가 있으면 알려준다.itemClickListener.onItemClick(v(=>View),getAdapterPosition()(=> position));
        iconView = (ImageView)itemView.findViewById(R.id.imageView);
        titleView = (TextView)itemView.findViewById(R.id.text_title);
    }

    public void setData(MyData data){
        this.data = data;
        iconView.setImageDrawable(data.icon);
        titleView.setText(data.title);
        titleView.setTextSize(data.fontSize);
    }//데이터 설정 함수에서는 데이터 객체로부터 값을 읽어 내부에 있는 View에 설정해 주는 일을 한다.
    //나중에 데이터 객체가 사용될 수 있기 때문에 일반적으로 데이터 객체를 내부에 보관한다.
}
