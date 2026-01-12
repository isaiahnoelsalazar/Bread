> [!NOTE]
> This Android dependency is deprecated and will not be updated anymore.
# How to use Bread
- Import a library available below
# How to import Bread
- Add JitPack in settings.gradle
```
repositories {
    /* other existing code */
    maven { url 'https://jitpack.io' }
}
```
- Add dependency in build.gradle
```
implementation 'com.github.saiaaaaaaa:Bread:(version)'
```
# 1. listpack
### a. SimpleList
- Create RecyclerView in activity layout
```
<androidx.recyclerview.widget.RecyclerView
    android:id="@+id/rv"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:overScrollMode="never"
    app:layout_constraintTop_toTopOf="parent" />
```
- Create reference to RecyclerView and desired data in activity class
```
List<String> data = new ArrayList<>();
/* data.add("Sample text"); */
RecyclerView rv = findViewById(R.id.rv);
```
- Initialize SimpleList using context, RecyclerView reference, and data reference
```
SimpleList simpleList = new SimpleList(context, rv, data); // simple list
```
#### *Other initialization methods*
- SimpleList with item click
```
public class MyClass extends AppCompatAcitivty implements SimpleListAdapter.OnItemClickListener {
    /* other existing code */
    SimpleList simpleList = new SimpleList(context, rv, data, this);
}
```
- SimpleList with item long click
```
public class MyClass extends AppCompatAcitivty implements SimpleListAdapter.OnItemLongClickListener {
    /* other existing code */
    SimpleList simpleList = new SimpleList(context, rv, data, this);
}
```
- SimpleList with item click and item long click
```
public class MyClass extends AppCompatAcitivty implements SimpleListAdapter.OnItemClickListener, SimpleListAdapter.OnItemLongClickListener {
    /* other existing code */
    SimpleList simpleList = new SimpleList(context, rv, data, this, this);
}
```
> Keyword 'this' refers to implementation SimpleListAdapter.OnItemClickListener and/or SimpleListAdapter.OnItemLongClickListener
#### Methods
- Add data to SimpleList
```
simpleList.addItem("Sample text");
```
- Remove data from SimpleList
```
simpleList.removeItem(0); // index of item
```
- Get List<String> data from SimpleList
```
simpleList.getData(); // returns List<String>
```
- Set simple list item padding
```
simpleList.setItemPadding(16); // will set 16dp padding to left, top, right, bottom
// or
simpleList.setItemPadding(16, 22, 24, 8); // will set multiple padding values to left, top, right, bottom
```

# OLD
### listpack.SimpleList v1.0
- Create RecyclerView in activity layout
```
<androidx.recyclerview.widget.RecyclerView
    android:id="@+id/rv"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:overScrollMode="never"
    app:layout_constraintTop_toTopOf="parent" />
```
- Create reference to RecyclerView and desired data in activity class
```
List<String> data = new ArrayList<>();
/* data.add("Sample text"); */
RecyclerView rv = findViewById(R.id.rv);
```
- Create SimpleList using context, RecyclerView reference, and data reference
```
SimpleList.create(context, data, rv);
```
- Adding and refreshing data in SimpleList is the same as 'create' method (will reset padding and need to set padding again)
```
SimpleList.create(context, data, rv);
```
- (optional) Set simple list item padding
```
SimpleList.setItemPadding(16); // will set 16dp padding to left, top, right, bottom
// or
SimpleList.setItemPadding(16, 22, 24, 8); // will set multiple padding values to left, top, right, bottom
```
