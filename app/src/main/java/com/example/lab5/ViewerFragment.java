package com.example.lab5;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

// 이미지를 표시해주는 Fragment
public class ViewerFragment extends Fragment {
    ImageView imageView;

    // 뷰가 생성될 때의 동작(MainActivity의 onCreate()와 유사)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_viewer, container, false);
        imageView = rootView.findViewById(R.id.imageView);

        return rootView;
    }

    // 이미지 세팅해주는 알맹이 함수
    public void setImage(int resId) {
        imageView.setImageResource(resId);
    }

}
