package com.example.kimjh.recyclerviewpj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    RecyclerView.LayoutManager layoutManager;


    int[] IDS = {
            R.drawable.gallery_photo_1,
            R.drawable.gallery_photo_2,
            R.drawable.gallery_photo_3,
            R.drawable.gallery_photo_4,
            R.drawable.gallery_photo_5,
            R.drawable.gallery_photo_6,
            R.drawable.gallery_photo_7,
            R.drawable.gallery_photo_8
    };          //??

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);//??
        recyclerView.setLayoutManager(layoutManager);   //childview의 배치를 어떨게 할지 결졍하는 LayoutManager객체를 생성하여
                                                            // setLayoutManager메소드를 이용하여 설정한다.
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL_LIST));

        myAdapter = new MyAdapter();
        myAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                MyData data = myAdapter.getItem(position);
                Toast.makeText(MainActivity.this, "data : " + data.title, Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(myAdapter); //recyclerview에 RecyclerView.Adapter를 상속하여 만든 Adapter의 객체를 setAdapter로 설정해준다.
        initData();
    }

    private void initData() {//Data생성
        Random r = new Random();
        for(int i=0 ; i<100; i++){
            MyData data = new MyData();
            data.icon = getResources().getDrawable(IDS[i%IDS.length]);
            data.title = "item"+i;
            data.fontSize = 20 + r.nextInt(1);      //??
            myAdapter.add(data);
        }
    }
}
