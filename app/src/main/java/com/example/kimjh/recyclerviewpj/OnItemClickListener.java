package com.example.kimjh.recyclerviewpj;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by kimjh on 2016-01-19.
 */
public interface OnItemClickListener {
    public void onItemClick(View view, int position);
}// item이 눌리면 외부에 알려주려고 할 때, 어떨게 알려줄 것 인가를 interface로 정의해 놓을수가 있다.
    // onItemClicked item 이 눌렸을 때 어떻게 알려줄 것인지 메소드(메소드 안의 parameter(매개변수))를 정의한다.

