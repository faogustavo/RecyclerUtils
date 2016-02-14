package com.gustavofao.recyclerutilsproject;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.gustavofao.recyclerutils.Model.CheckItemModel;
import com.gustavofao.recyclerutils.Model.DividerModel;
import com.gustavofao.recyclerutils.Model.SwitchItemModel;
import com.gustavofao.recyclerutils.Model.TwoItemModel;
import com.gustavofao.recyclerutils.RecyclerView.Adapter.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_CHECK_BOX_PREFERENCES = "CHECK_BOX_PREFERENCES";
    private static final String KEY_CHECK_SWITCH_PREFERENCES = "CHECK_SWITCH_PREFERENCES";

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences preferences = this.getSharedPreferences(this.getClass().getName(),
                Context.MODE_PRIVATE);

        List<Object> data = new ArrayList<>();

        //Check Model simple
        CheckItemModel checkModel = new CheckItemModel("Allow notifications");
        data.add(checkModel);

        //Check Model simple with subtitle
        CheckItemModel checkModelWithSubtitle = new CheckItemModel("Receive messages", "Hangouts message");
        data.add(checkModelWithSubtitle);

        //Check Model using shard preferences, image and subtitle
        CheckItemModel checkModelPreferences = new CheckItemModel("Downloads", "Always downlaod videos", R.drawable.ic_download);
        checkModelPreferences.withSharedPreferences(preferences, KEY_CHECK_BOX_PREFERENCES);
        data.add(checkModelPreferences);

        //Divider
        DividerModel divDefault = new DividerModel();
        data.add(divDefault);

        //Switch Model Simple
        SwitchItemModel switchModel = new SwitchItemModel("Wifi");
        switchModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Click wifi", Toast.LENGTH_SHORT).show();
            }
        });
        data.add(switchModel);

        //Switch Model Simple with subtitle
        SwitchItemModel switchModelSub = new SwitchItemModel("Receive messages", "Hangouts message");
        data.add(switchModelSub);

        //Switch Model using shared preferences, subtitle and icon
        SwitchItemModel switchModelPreferences = new SwitchItemModel("Downloads", "Always downlaod videos", R.drawable.ic_download);
        switchModelPreferences.withSharedPreferences(preferences, KEY_CHECK_SWITCH_PREFERENCES);
        data.add(switchModelPreferences);

        //Divider
        DividerModel divRed = new DividerModel(Color.argb(64, 255, 0, 0));
        data.add(divRed);

        //TwoItemModel
        TwoItemModel model = new TwoItemModel("This is a title", "And this is a subtitle", R.drawable.ic_account);
        data.add(model);

        TwoItemModel model2 = new TwoItemModel("Profile Photo", "Change your Google+ profile photo");
        data.add(model2);

        RecyclerAdapter adapter = new RecyclerAdapter(this, data);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }
}
