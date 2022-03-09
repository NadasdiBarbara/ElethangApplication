package com.example.elethangapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private BottomNavigationView bottomNavigationView;
    private TextView textViewHome;
    private FrameLayout fragmentContainer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        //hambiicon
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNav);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.exit){
                    AlertDialog.Builder builder = new  AlertDialog.Builder(MainActivity.this);
                    builder.setMessage("Biztos kiszeretne lépni?");
                    builder.setCancelable(true);

                    builder.setNegativeButton("Igen", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });

                    builder.setPositiveButton("Nem", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel();
                        }
                    });
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();
                }
                return true;
            }
        });


    }


    public  void  init(){
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        textViewHome = findViewById(R.id.textViewHome);
        fragmentContainer = findViewById(R.id.fragment_container);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener bottomNav = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.bottom_kedcencek:
                    //replaceFragment(new KedvencekFragment());
                    fragmentContainer.setVisibility(View.VISIBLE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new KedvencekFragment()).commit();
                    textViewHome.setVisibility(View.GONE);
                    break;
                case R.id.bottom_home:
                    //replaceFragment(new HomeFragment());
                    textViewHome.setVisibility(View.VISIBLE);
                    fragmentContainer.setVisibility(View.GONE);
                    break;
                case R.id.bottom_beallitasok:
                    replaceFragment(new BeallitasokFragment());
                    break;
            }
            return true;
        }
    };

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.cat:
                replaceFragment(new CatFragment());
                break;
            case R.id.dog:
                replaceFragment(new DogFragment());
                break;
            case R.id.segitseg:
                replaceFragment(new HogyanSegithetszFragment());
                break;
            case R.id.orokbefogadhatoak:
                replaceFragment(new OrokbefogadhatoFragment());
                break;
            case R.id.virtualis:
                replaceFragment(new VirtualisFragment());
                break;
            case R.id.esemenyek:
                replaceFragment(new EsemenyekFragment());
                break;
            case R.id.programok:
                replaceFragment(new ProgramokFragment());
                break;
            case R.id.rolunk:
                replaceFragment(new RolunkFragment());
                break;
            case R.id.csapatunk:
                replaceFragment(new CsapatunkFragment());
                break;
            case R.id.feltetel:
                replaceFragment(new FeltetelFragment());
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }


}