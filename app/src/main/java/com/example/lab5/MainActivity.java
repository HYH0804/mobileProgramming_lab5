package com.example.lab5;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

// MainActivity는 ListFragment.ImageSelectionCallback 인터페이스를 implement한다.
public class MainActivity extends AppCompatActivity implements ListFragment.ImageSelectionCallback {
    // 리스트 Fragment 담는 변수
    ListFragment listFragment;
    
    // 이미지 Fragment 담는 변수
    ViewerFragment viewerFragment;
    
    // MainActivity에서 image들을 받아다가 여기서 인자로 넘길 때 사용
    int[] images = {R.drawable.dream01, R.drawable.dream02, R.drawable.dream03};

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // FragmentManager 변수를 통해 Fragment 관리
        FragmentManager manager = getSupportFragmentManager();;
        // id를 집어넣어서 변수에 인스턴스를 추가합시다
        listFragment = (ListFragment) manager.findFragmentById(R.id.listFragment);
        viewerFragment = (ViewerFragment) manager.findFragmentById(R.id.viewerFragment);
    }

    // ListFragment.ImageSelectionCallback 인터페이스 implement에 의해 선언된 오버라이드 메소드
    // Hint : ListFragment.java 파일에서 버튼 동작을 작성했다면, 여기서 그 구체적인 행동을 지정하는 것
    // Hint 2 : 어느 이미지를 고를지를 ListFragment에서 position 인자로 넘겼으니, 그걸 설정하는 Fragment는 누굴까? 그녀석의 메소드를 불러올 필요가 있을 것이다.
    @Override
    public void onImageSelected(int position) {
        viewerFragment.setImage(images[position]);
    }
}
