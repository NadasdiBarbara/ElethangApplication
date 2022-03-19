package com.example.elethangapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.elethangapplication.cat.CatFragment;
import com.example.elethangapplication.csapatunk.CsapatunkFragment;
import com.example.elethangapplication.dog.DogFragment;
import com.example.elethangapplication.esemenyek.EsemenyekFragment;
import com.example.elethangapplication.feltetel.FeltetelFragment;
import com.example.elethangapplication.hogyansegits.HogyanSegithetszFragment;
import com.example.elethangapplication.kedvencek.KedvencekFragment;
import com.example.elethangapplication.orokbefogadhato.OrokbefogadhatoFragment;
import com.example.elethangapplication.programok.ProgramokFragment;
import com.example.elethangapplication.rolunk.RolunkFragment;
import com.example.elethangapplication.virtualis.VirtualisFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TextView textViewHome;
    private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        init();

        //hambiicon
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this,drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);

        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


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
        textViewHome = findViewById(R.id.textViewHome);
        fragmentContainer = findViewById(R.id.fragment_container);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.cat:
                //replaceFragment(new CatFragment());
                fragmentContainer.setVisibility(View.VISIBLE);
                textViewHome.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CatFragment()).commit();
                break;
            case R.id.dog:
                //replaceFragment(new DogFragment());
                fragmentContainer.setVisibility(View.VISIBLE);
                textViewHome.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new DogFragment()).commit();
                break;
            case R.id.segitseg:
                //replaceFragment(new HogyanSegithetszFragment());
                fragmentContainer.setVisibility(View.VISIBLE);
                textViewHome.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HogyanSegithetszFragment()).commit();
                break;
            case R.id.orokbefogadhatoak:
                //replaceFragment(new OrokbefogadhatoFragment());
                fragmentContainer.setVisibility(View.VISIBLE);
                textViewHome.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new OrokbefogadhatoFragment()).commit();
                break;
            case R.id.virtualis:
                //replaceFragment(new VirtualisFragment());
                fragmentContainer.setVisibility(View.VISIBLE);
                textViewHome.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new VirtualisFragment()).commit();
                break;
            case R.id.esemenyek:
                //replaceFragment(new EsemenyekFragment());
                fragmentContainer.setVisibility(View.VISIBLE);
                textViewHome.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new EsemenyekFragment()).commit();
                break;
            case R.id.programok:
                //replaceFragment(new ProgramokFragment());
                fragmentContainer.setVisibility(View.VISIBLE);
                textViewHome.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ProgramokFragment()).commit();
                break;
            case R.id.rolunk:
                //replaceFragment(new RolunkFragment());
                fragmentContainer.setVisibility(View.VISIBLE);
                textViewHome.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new RolunkFragment()).commit();
                break;
            case R.id.csapatunk:
                //replaceFragment(new CsapatunkFragment());
                fragmentContainer.setVisibility(View.VISIBLE);
                textViewHome.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new CsapatunkFragment()).commit();
                break;
            case R.id.feltetel:
                //replaceFragment(new FeltetelFragment());
                fragmentContainer.setVisibility(View.VISIBLE);
                textViewHome.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FeltetelFragment()).commit();
                break;
            case R.id.kedvencek:
                fragmentContainer.setVisibility(View.VISIBLE);
                textViewHome.setVisibility(View.GONE);
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new KedvencekFragment()).commit();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    /*
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
    */
     


}