package com.ecsion.sliderpoc.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.ecsion.sliderpoc.ActUsers;
import com.ecsion.sliderpoc.R;

import java.util.HashMap;

public class HomeFragment extends Fragment implements View.OnClickListener {

    SliderLayout mSliderLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        mSliderLayout = root.findViewById(R.id.slider);
        init();
        CardView cvDoctor = root.findViewById(R.id.cvDoctor);
        CardView cvAutomobile = root.findViewById(R.id.cvAutomobile);
        CardView cvAirPlane = root.findViewById(R.id.cvAirPlane);
        CardView cvOperator = root.findViewById(R.id.cvOperator);
        CardView cvCareCare = root.findViewById(R.id.cvCarCare);
        CardView cvGym = root.findViewById(R.id.cvGym);

        cvDoctor.setOnClickListener(this);
        cvAutomobile.setOnClickListener(this);
        cvAirPlane.setOnClickListener(this);
        cvOperator.setOnClickListener(this);
        cvCareCare.setOnClickListener(this);
        cvGym.setOnClickListener(this);
        return root;
    }

    private void init() {
        HashMap<String, Integer> file_maps = new HashMap<String, Integer>();
        file_maps.put("Car wash", R.drawable.banner1);
        file_maps.put("Air ticket", R.drawable.banner2);
        file_maps.put("Movie ticket", R.drawable.banner3);

        for (String name : file_maps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getContext());
            // initialize a SliderLayout
            textSliderView
                    .description(name)
                    .image(file_maps.get(name))
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            //.setOnSliderClickListener(this);
            //add your extra information
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);

            // Picasso.with(getContext()).load(url_maps.get(name)).into(textSliderView);
            mSliderLayout.addSlider(textSliderView);
        }
        mSliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        mSliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSliderLayout.setCustomAnimation(new DescriptionAnimation());
        mSliderLayout.setDuration(4000);
    }


    @Override
    public void onClick(View v) {
        startActivity(new Intent(getContext(), ActUsers.class));
    }
}