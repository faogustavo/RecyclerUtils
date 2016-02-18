# RecyclerView Utils

A simple way to implement various types of basic list items.

## INSTALL
Add this dependecy from jCenter:

``` groovy
compile 'com.gustavofao:RecyclerUtils:1.1'
```

## USAGE
All usage are by java code. All you need is a RecyclerView.

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent">
    <android.support.v7.widget.RecyclerView
        android:id="@+id/recyclerview"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
</RelativeLayout>
```

```java
recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
recyclerView.setLayoutManager(new LinearLayoutManager(this));
recyclerView.setHasFixedSize(true);
```

### ADAPTER
For use these simple items, the lib already contains a basic adapter to handle with the items.
All you need is an empty list of objects and the context.

```java
List<Object> data = new ArrayList<>();
RecyclerAdapter adapter = new RecyclerAdapter(this, data);
//Add all items to data here
recyclerView.setAdapter(adapter);
```

### ITEMS
The lib contains three different types of items, a divider and a group container using cards.

#### CHECK ITEM
The check item can be used by three different ways.

![](/screenshots/check.png)

```java
CheckItemModel checkModel = new CheckItemModel("Allow notifications");
data.add(checkModel);

CheckItemModel checkModelWithSubtitle = new CheckItemModel("Receive messages", "Hangouts message");
data.add(checkModelWithSubtitle);

CheckItemModel checkModelComplete = new CheckItemModel("Downloads", "Always downlaod videos", R.drawable.ic_download);
data.add(checkModelComplete);
```

#### SWITCH ITEM
The switch item can also be used by three different ways.

![](/screenshots/switch.png)

```java
SwitchItemModel switchModel = new SwitchItemModel("Wifi");
data.add(switchModel);

SwitchItemModel switchModelSub = new SwitchItemModel("Receive messages", "Hangouts message");
data.add(switchModelSub);

SwitchItemModel switchModelComplete = new SwitchItemModel("Downloads", "Always downlaod videos", R.drawable.ic_download);
data.add(switchModelComplete);
```

#### TWO ITEMS
The two items is the same of the examples above but has no secundary action.

![](/screenshots/two_item.png)

```java
TwoItemModel model2 = new TwoItemModel("Profile Photo", "Change your Google+ profile photo");
data.add(model2);

TwoItemModel model = new TwoItemModel("This is a title", "And this is a subtitle", R.drawable.ic_download);
data.add(model);
```

#### DIVIDERS
Divider is a horizontal bar.The default color is
```java
Color.argb(36, 127, 127, 127)
```

To use it implement this code:
```java
DividerModel divDefault = new DividerModel();
data.add(divDefault);

//To change color pass it as param on create
DividerModel divRed = new DividerModel(Color.argb(64, 255, 0, 0));
data.add(divRed);
```

#### Groups
Groups are separated by cards. Each card is a group. The CardModel only have a title and the items.
The items can be any one listed above.

Example of group:
```java
GroupModel groupModel = new GroupModel("GroupSample");

groupModel.addItem(new TwoItemModel("This is a title", "And this is a subtitle", R.drawable.ic_download));
groupModel.addItem(new SwitchItemModel("Receive messages", "Hangouts message"));
groupModel.addItem(new CheckItemModel("Allow notifications", (CharSequence) "http://design.ubuntu.com/wp-content/uploads/ubuntu-logo32.png"));

data.add(groupModel);
```

#### FORMS
You can also create forms on a recyclerview. For this you have to create a **FormModel** and add the **InputFieldModel** to it.

The **FormModel** has two constructors:
1. *public FormModel(String title, String submitText)*
2. *public FormModel(String title, String submitText, List<InputFieldModel> data)*

The **InputFieldModel** has four:
1. *public InputFieldModel(String hint, String name, InputType inputType)*
2. *public InputFieldModel(String hint, String name, InputType inputType, int maxSize)*
3. *public InputFieldModel(String hint, String name, String defaultValue, InputType inputType)*
4. *public InputFieldModel(String hint, String name, String defaultValue, int maxSize, InputType inputType)*

There is 5 different types of fields:
* TEXT
* NUMBER
* EMAIL
* PASSWORD
* PHONE

![](/screenshots/form.png)

Example:
```java
FormModel formModel = new FormModel("Form Sample", "Submit");

formModel.addData(new InputFieldModel("Name", "name", InputFieldModel.InputType.TEXT));
formModel.addData(new InputFieldModel("Email", "email", InputFieldModel.InputType.EMAIL));
formModel.addData(new InputFieldModel("Age", "age", InputFieldModel.InputType.NUMBER));
formModel.addData(new InputFieldModel("Phone", "phone", InputFieldModel.InputType.PHONE));
formModel.addData(new InputFieldModel("Password", "password", InputFieldModel.InputType.PASSWORD));
formModel.addData(new InputFieldModel("Confirm password", "repeatPassword", InputFieldModel.InputType.PASSWORD));

data.add(formModel);
```

To add you have to call *setOnSubmitClickListener* on your FormModel adding your listener.

Example:
```java
formModel.setOnSubmitClickListener(new OnSubmitClick() {
    @Override
    public void onSubmit(HashMap<String, String> data) {
        Toast.makeText(MainActivity.this, new JSONObject(data).toString(), Toast.LENGTH_SHORT).show();
    }
});
```

### IMAGE FROM URL
To download images from URL, the lib uses [Picasso Lib from Square](http://square.github.io/picasso/).
The only difference is that you need to pass the url as CharSequence.

Success:

![](/screenshots/success.png)

Error:

![](/screenshots/failure.png)

Example:
```java
CharSequence url = "http://design.ubuntu.com/wp-content/uploads/ubuntu-logo32.png";
groupModel.addItem(new CheckItemModel("Receive news from canonical/ubuntu", url));
```

### CLICK ACTION
When you use a switch or checkbox item, the default on click item is to select/unselect, but you can add a custom onClickListener.
It works for TwoItemModel too. To use this, you have to implement this code:
```java
SwitchItemModel switchModel = new SwitchItemModel("Wifi");
switchModel.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        //Open wifi Settings
    }
});
```

### SHARED PREFERENCES
When you are using a switch/checkbox item, you can bind a sharedpreferences to save the value.
You just need to call *withSharedPreferences(SharedPrefereces, String)* passing your instance of shared preferences and the key to save the value.

Example:
```java
CheckItemModel checkModelPreferences = new CheckItemModel("Downloads", "Always downlaod videos", R.drawable.ic_download);
checkModelPreferences.withSharedPreferences(preferences, KEY_CHECK_BOX_PREFERENCES);
data.add(checkModelPreferences);

SwitchItemModel switchModelPreferences = new SwitchItemModel("Downloads", "Always downlaod videos", R.drawable.ic_download);
switchModelPreferences.withSharedPreferences(preferences, KEY_CHECK_SWITCH_PREFERENCES);
data.add(switchModelPreferences);
```


### VALUE CHANGE LISTENER
You can also add a listener to value change to switch or checkbox.
```java
switchModel.setOnValueChange(new OnValueChange<Boolean>() {
    @Override
    public void onValueChanged(Boolean newValue) {
        //Code here
    }
});
```

### CUSTOMIZATION
To change the colors, you can change the value from these colors on your Colors.xml.
```xml
<!-- DEFAULT THEME COLORS, USED FOR SWITCH/CHECK, INPUT FOCUS -->
<color name="colorPrimary">#3F51B5</color>
<color name="colorPrimaryDark">#303F9F</color>
<color name="colorAccent">#FF5722</color>

<!-- DIVIDER DEFAULT COLOR -->
<color name="divider_default">#7F7F7F7F</color>

<!-- COLOR FOR TEXTVIEWS -->
<color name="colorTextList">#000</color>

<!-- COLOR FOR GROUP TITLE -->
<color name="colorGroupTitle">#3F51B5</color>

<!-- FORM COLORS -->
<color name="colorFormTitle">#303F9F</color>
<color name="colorFormButton">#FF5722</color>
<color name="colorFormButtonText">#fff</color>
<color name="colorFormInputTextColor">#777</color>
```

To change the sizes, change these values on your dimens.xml
```xml
<dimen name="defaultGroupTitleSize">18sp</dimen>
<dimen name="defaultFormTitleSize">18sp</dimen>
<dimen name="defaultTitleSize">16sp</dimen>
<dimen name="defaultSubtitleSize">14sp</dimen>
<dimen name="defaultBadgeSize">12sp</dimen>
<dimen name="defaultImageSize">36dp</dimen>
```

## TO-DO
* Add input items
* G-Mail like items (Letter icons)
* Secondary action with image
* Title items
* Item with time

## License
    Copyright 2015 Gustavo Fão. All rights reserved.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
