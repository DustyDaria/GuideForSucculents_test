package com.example.guideforsucculents_test;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private ListView contentListView;
    private String[] contentArray;
    private ArrayAdapter<String> adapter;
    private Toolbar toolbar;
    private int category_index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contentListView = findViewById(R.id.content_list_view);
        contentArray = getResources().getStringArray(R.array.cactus_array);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
                new ArrayList<String>(Arrays.asList(contentArray)));
        contentListView.setAdapter(adapter);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener (this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        contentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, textContentActivity.class);
                intent.putExtra("category", category_index);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // Раздуть меню; это добавляет элементы в панель действий, если она присутствует.
        getMenuInflater().inflate(R.menu.main, menu);
        toolbar.setTitle(R.string.menu_cactus);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_cactus) {
            fillArray(R.string.menu_cactus, R.array.cactus_array, 0);
        } else if (id == R.id.nav_haworthia) {
            fillArray(R.string.menu_haworthia, R.array.haworthia_array, 1);
        } else if (id == R.id.nav_echeveria) {
            fillArray(R.string.menu_echeveria, R.array.echeveria_array, 2);
        } else if (id == R.id.nav_aloe) {
            fillArray(R.string.menu_aloe, R.array.aloe_array, 3);
        } else if (id == R.id.nav_recommendation) {
            fillArray(R.string.menu_recommendation, R.array.recommendation_array, 4);
        } else if (id == R.id.nav_gallery) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void fillArray(int title, int arrayList, int index){
        toolbar.setTitle(title);
        contentArray = getResources().getStringArray(arrayList); // Получаем необходимый массив данных
        adapter.clear(); // Очищаем адаптер и заполняем его полученными данными
        adapter.addAll(contentArray); // будет работать только с Arrays.asList()
        adapter.notifyDataSetChanged(); // Необходимо "сказать" адаптеру, что данные изменились
        category_index = index; // Передаем индекс категории меню в следующую активность
    }
}