package com.mahrus.bantuaku.mahrusdraw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.LinearLayout;


import com.mahrus.bantuaku.mahrusdraw._sliders.FragmentSlider;
import com.mahrus.bantuaku.mahrusdraw._sliders.SliderIndicator;
import com.mahrus.bantuaku.mahrusdraw._sliders.SliderPagerAdapter;
import com.mahrus.bantuaku.mahrusdraw._sliders.SliderView;

import java.util.ArrayList;
import java.util.List;




/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    private RelativeLayout mahasiswa;
    private RelativeLayout makanan;

    private SliderPagerAdapter mAdapter;
    private SliderIndicator mIndicator;

    private SliderView sliderView;
    private LinearLayout mLinearLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        sliderView = (SliderView) rootView.findViewById(R.id.sliderView);
        mLinearLayout = (LinearLayout) rootView.findViewById(R.id.pagesContainer);
        setupSlider();

        mahasiswa = (RelativeLayout) rootView.findViewById(R.id.mhs);
        mahasiswa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Klick Me", Toast.LENGTH_SHORT).show();

                Intent goPindah = new Intent(getActivity(), DaftarMahasiswa.class);
                startActivity(goPindah);
            }
        });

        makanan = (RelativeLayout) rootView.findViewById(R.id.mkn);
        makanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Klick Me", Toast.LENGTH_SHORT).show();

                Intent goPindah = new Intent(getActivity(), NasiGoreng.class);
                startActivity(goPindah);
            }
        });

        return  rootView;


    }

    private void setupSlider() {
        sliderView.setDurationScroll(800);
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-1.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-2.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-3.jpg"));
        fragments.add(FragmentSlider.newInstance("http://www.menucool.com/slider/prod/image-slider-4.jpg"));

        mAdapter = new SliderPagerAdapter(getFragmentManager(), fragments);
        sliderView.setAdapter(mAdapter);
        mIndicator = new SliderIndicator(getActivity(), mLinearLayout, sliderView, R.drawable.indicator_circle);
        mIndicator.setPageCount(fragments.size());
        mIndicator.show();
    }



}
