package com.example.aleja.ejemplofragmentsestaticospresencial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class DetailTeamActivity extends AppCompatActivity {
    public static final String EXTRA_POS_EQUIPO = "pos_equipo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_team);

        //obtengo la pos del equipo a mostrar
        int pos = getIntent().getIntExtra(EXTRA_POS_EQUIPO, 0);
        //obtengo el fragment del layout
        TeamDetailFragment teamDetailFragment = (TeamDetailFragment) getFragmentManager().findFragmentById(R.id.fragmentDetail);
        //muestro el equipo
        teamDetailFragment.showTeam(MainActivity.teamArrayList.get(pos));
    }


}
