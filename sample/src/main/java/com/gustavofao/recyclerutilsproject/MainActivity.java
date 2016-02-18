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

import com.gustavofao.recyclerutils.Interfaces.OnSubmitClick;
import com.gustavofao.recyclerutils.Interfaces.OnValueChange;
import com.gustavofao.recyclerutils.Model.BadgeItemModel;
import com.gustavofao.recyclerutils.Model.CheckItemModel;
import com.gustavofao.recyclerutils.Model.DividerModel;
import com.gustavofao.recyclerutils.Model.FormModel;
import com.gustavofao.recyclerutils.Model.GroupModel;
import com.gustavofao.recyclerutils.Model.InputFieldModel;
import com.gustavofao.recyclerutils.Model.SwitchItemModel;
import com.gustavofao.recyclerutils.Model.TwoItemModel;
import com.gustavofao.recyclerutils.RecyclerView.Adapter.RecyclerAdapter;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
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
        switchModel.setOnValueChange(new OnValueChange<Boolean>() {
            @Override
            public void onValueChanged(Boolean newValue) {
                //Code here
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
        TwoItemModel model = new TwoItemModel("This is a title", "And this is a subtitle", R.drawable.ic_download);
        data.add(model);

        TwoItemModel model2 = new TwoItemModel("Profile Photo", "Change your Google+ profile photo");
        data.add(model2);

        //Group
        GroupModel groupModel = new GroupModel("GroupSample");
        CharSequence url = "http://design.ubuntu.com/wp-content/uploads/ubuntu-logo32.png";

        groupModel.addItem(new TwoItemModel("This is a title", "And this is a subtitle", R.drawable.ic_download));
        groupModel.addItem(new SwitchItemModel("Receive messages", "Hangouts message"));
        groupModel.addItem(new CheckItemModel("Allow notifications", url));

        //Badge
        groupModel.addItem(new BadgeItemModel("Messages", R.drawable.ic_email).setBadge("99+"));
        groupModel.addItem(new BadgeItemModel("Messages", "Messages received on <b>Hangouts</b>. Lorem ipsum dolor sit amet.", R.drawable.ic_email).setBadge("99+"));

        data.add(groupModel);

        //Input
        FormModel formModel = new FormModel("Form Sample", "Submit");

        formModel.addData(new InputFieldModel("Name", "name", InputFieldModel.InputType.TEXT));
        formModel.addData(new InputFieldModel("Email", "email", InputFieldModel.InputType.EMAIL));
        formModel.addData(new InputFieldModel("Age", "age", InputFieldModel.InputType.NUMBER));
        formModel.addData(new InputFieldModel("Phone", "phone", InputFieldModel.InputType.PHONE));
        formModel.addData(new InputFieldModel("Password", "password", InputFieldModel.InputType.PASSWORD));
        formModel.addData(new InputFieldModel("Confirm password", "repeatPassword", InputFieldModel.InputType.PASSWORD));

        formModel.setOnSubmitClickListener(new OnSubmitClick() {
            @Override
            public void onSubmit(HashMap<String, String> data) {
                Toast.makeText(MainActivity.this, new JSONObject(data).toString(), Toast.LENGTH_SHORT).show();
            }
        });

        data.add(formModel);

        RecyclerAdapter adapter = new RecyclerAdapter(this, data);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
    }
}
