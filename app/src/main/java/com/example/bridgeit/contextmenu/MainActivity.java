package com.example.bridgeit.contextmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private ListView mListView;
    String[] data = {"Jyothish","Mahanth","Mithun","Pradi","Puni","Ravi","Sathish"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView)findViewById(R.id.list_view);
        //set the data to the adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);
        mListView.setAdapter(adapter);
        // Register the ListView  for Context menu
        registerForContextMenu(mListView);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Select the Action");
        menu.add(0,v.getId(),0,"Call");
        menu.add(0,v.getId(),0,"SMS");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        if(item.getTitle() == "Call") {
            Toast.makeText(this,"calling",Toast.LENGTH_SHORT).show();
        } else if(item.getTitle() == "SMS") {
            Toast.makeText(this,"sending SMS",Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }
}
