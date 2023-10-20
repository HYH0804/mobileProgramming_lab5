package com.example.lab5;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

// Fragment 클래스를 상속한 ListFragment 생성
public class ListFragment extends Fragment {

    // MainActivity.java에서 사용할 인터페이스, 콜백에 사용할 것임
    public static interface ImageSelectionCallback {
        public void onImageSelected(int position);
    }

    // 콜백 인스턴스 담을 변수 생성
    public ImageSelectionCallback callback;

    // Fragment 클래스의 onAttach 메소드 오버라이딩 : 콜백 인스턴스에 context를 지정하여 액티비티 참조(이곳의 context는 얘를 호출하는 녀석, 즉 MainActivity가 될 것임)
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (context instanceof ImageSelectionCallback) {
            callback = (ImageSelectionCallback) context;
        }
    }

    // Fragment 클래스의 onCreateView 메소드 오버라이딩 : 해당 뷰 내부요소 구성은 여기서 지정 (MainActivity의 onCreate()와 유사)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 레이아웃을 화면 일부에 표시해주는 LayoutInflater를 포함하여 뷰그룹 지정
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_list, container, false);

        
        // 3개의 버튼 클릭 시의 동작 : 콜백 함수를 통해 onImageSelected(num) 전달
        // 버튼 지정 시에 뷰그룹 내에서 찾아야 함, 따라서 rootView.findViewById(...) 로 지정
        // 버튼 기능 구현 : callback이 존재한다면(즉 not null), callback에게 어떠한 함수를 요청한다.
        // Hint : callback 의 타입은 ImageSelectionCallback 이다. 해당 인터페이스의 선언문으로 가보자.
        // Hint 2 : 이 파일 상단에 있다.
        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback != null) {
                    callback.onImageSelected(0);
                }
            }
        });

        Button button2 = rootView.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback != null) {
                    callback.onImageSelected(1);
                }
            }
        });

        Button button3 = rootView.findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback != null) {
                    callback.onImageSelected(2);
                }
            }
        });

        return rootView;
    }

}
