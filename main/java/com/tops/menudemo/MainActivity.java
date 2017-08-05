package com.tops.menudemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);

        registerForContextMenu(button);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add("Item 1");
        menu.add("Item 2");
        menu.add("Item 3");
        SubMenu subItem1 = menu.addSubMenu("Sub Item");
        subItem1.add("Sub Item 1");
        subItem1.add("Sub Item 2");
        subItem1.add("Sub Item 3");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Toast.makeText(this, "You select " + item.getTitle(), Toast.LENGTH_SHORT).show();
        return super.onContextItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add("Item 1");
        menu.add("Item 2");
        menu.add("Item 3");
        SubMenu subItem1 = menu.addSubMenu("Sub Item");
        subItem1.add("Sub Item 1");
        subItem1.add("Sub Item 2");
        subItem1.add("Sub Item 3");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Toast.makeText(this, "You select " + item.getTitle(), Toast.LENGTH_SHORT).show();
//        if (item.getTitle().equals("Item 1")) {
//            Toast.makeText(this, "You select Item 1", Toast.LENGTH_SHORT).show();
//        }
        return super.onOptionsItemSelected(item);
    }
}
