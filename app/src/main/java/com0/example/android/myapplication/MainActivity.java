package com0.example.android.myapplication;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Placeholder;
import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout screen;
    private ViewPager viewFrame;
    private ImageView bedroom21;
    private ImageView bedroom22;
    private ImageView bedroom23;
    private ImageView kitche21;
    private ImageView animationPlace;
    private ClickScreen clickScreen;
    private HorizontalScrollView bottom_nav_bar;
    private ImageView settingIcon;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room2);
        initialize();

        viewFrame.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                Log.d("position i", String.valueOf(i));
                Fragment fragment = clickScreen.getItem(i);
                String s = String.valueOf(fragment.getClass());
                Log.d("page Selected", "works " + s);
                switch(s){
                    case "class com0.example.android.myapplication.KitchenFragment":
                        Log.d("kFragment","fragment works");
                        KitchenFragment kitchenFragment = new KitchenFragment();
                        ImageView kim = screen.findViewWithTag(kitchenFragment.getIconImage());
                        if(kim!=null){
                            kim.setImageResource((Integer) animationPlace.getTag());
                            kim.setTag((Integer) animationPlace.getTag());
                            kim.setContentDescription(animationPlace.getContentDescription());
                        }
                        else{
                            Log.d("imageView","it is null");
                        }
                        animationPlace.setImageResource(kitchenFragment.getIconImage());
                        animationPlace.setTag(kitchenFragment.getIconImage());
                        animationPlace.setContentDescription(String.valueOf(i));
                                            break;
                    case "class com0.example.android.myapplication.LivingRoomFragment":
                        Log.d("lFragment","frgment works");
                        LivingRoomFragment livingRoomFragment = new LivingRoomFragment();
                        ImageView lim = screen.findViewWithTag(livingRoomFragment.getIconImage());
                        if(lim!=null){
                            lim.setImageResource((Integer) animationPlace.getTag());
                            lim.setTag((Integer) animationPlace.getTag());
                            lim.setContentDescription(animationPlace.getContentDescription());
                        }
                        else{
                            Log.d("imageView","it is null");
                        }
                        animationPlace.setImageResource(livingRoomFragment.getIconImage());
                        animationPlace.setTag(livingRoomFragment.getIconImage());
                        animationPlace.setContentDescription(String.valueOf(i));
                                            break;
                    case "class com0.example.android.myapplication.BedroomFragment":
                        Log.d("bFragment","frgment works");
                        BedroomFragment bedroomFragment = new BedroomFragment();
                        ImageView bim = screen.findViewWithTag(bedroomFragment.getIconImage());
                        if(bim!=null){
                            bim.setImageResource((Integer) animationPlace.getTag());
                            bim.setTag((Integer) animationPlace.getTag());
                            bim.setContentDescription(animationPlace.getContentDescription());
                        }
                        else{
                            Log.d("imageView","it is null");
                        }
                        animationPlace.setImageResource(bedroomFragment.getIconImage());
                        animationPlace.setTag(bedroomFragment.getIconImage());
                        animationPlace.setContentDescription(String.valueOf(i));
                                            break;
                    default: animationPlace.setImageResource(R.drawable.ic_sofa_1);
                                            break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    public void initialize(){
        screen = findViewById(R.id.screen);
        viewFrame = findViewById(R.id.viewFrame);
        bedroom21 = findViewById(R.id.bedroom21);
        bedroom22 = findViewById(R.id.bedroom22);
        bedroom23 = findViewById(R.id.bedroom23);
        kitche21 = findViewById(R.id.kitchen21);
        settingIcon = findViewById(R.id.setting_icon);
        animationPlace = findViewById(R.id.animationPlace);
        bottom_nav_bar = findViewById(R.id.bottom_nav_bar);
        clickScreen = new ClickScreen(getSupportFragmentManager(), 5);
        viewFrame.setAdapter(clickScreen);

        //Setting Tag on Images to get their ID's
        kitche21.setTag(R.drawable.ic_spoon_and_fork_mini);
        bedroom21.setTag(R.drawable.ic_bed_mini);
        bedroom22.setTag(R.drawable.ic_bed_mini);
        bedroom23.setTag(R.drawable.ic_bed_mini);
        animationPlace.setTag(R.drawable.ic_sofa_mini);
    }

    public void swapview(View v){

        TransitionManager.beginDelayedTransition(screen);
        ImageView imageView = (ImageView) v;

        int positionClicked = Integer.valueOf(String.valueOf(v.getContentDescription()));
        int positionAnimation = Integer.valueOf(String.valueOf(animationPlace.getContentDescription()));

        //Getting the id of drawable resource file
        Integer ClickedImageId = (Integer) imageView.getTag();
        Integer AnimationImageId = (Integer) animationPlace.getTag();

        //Setting swapped image resource and tag
        animationPlace.setImageResource(ClickedImageId);
        animationPlace.setTag(ClickedImageId);
        animationPlace.setContentDescription(v.getContentDescription());

        Log.d("Animation image ID", String.valueOf(AnimationImageId));
        imageView.setImageResource(AnimationImageId);
        imageView.setTag(AnimationImageId);
        v.setContentDescription(String.valueOf(positionAnimation));

        viewFrame.setCurrentItem(positionClicked);
    }

    public void changeActivity(View v){
        Log.d("changeActivity", "this ");
        Intent intent = new Intent(this, Setting.class);
        try{
            startActivity(intent);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
