
package vostore.cristaovirtual;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;


public class MainActivity extends AppCompatActivity  implements

    BottomNavigationView.OnNavigationItemSelectedListener {
        private BottomNavigationView navigationView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView = (BottomNavigationView) findViewById(R.id.navigationView);
        navigationView.setOnNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);

    }



    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {



        switch (item.getItemId()) {


            case R.id.navigation_frase: {
                getSupportActionBar().setTitle("Frases");
                Fragment frasesfragment = FraseFragment.newInstance();
                openFragment(frasesfragment);
                break;
            }
            case R.id.navigation_licao: {
                getSupportActionBar().setTitle("Frases");
                Fragment frasesfragment = FraseFragment.newInstance();
                openFragment(frasesfragment);
                break;
            }
            case R.id.navigation_livros: {
                getSupportActionBar().setTitle("Frases");
                Fragment frasesfragment = FraseFragment.newInstance();
                openFragment(frasesfragment);
                break;
            }
        }
        return true;
    }
    private void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}


