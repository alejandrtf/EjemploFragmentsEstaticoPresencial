package com.example.aleja.ejemplofragmentsestaticospresencial;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import android.app.Fragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TeamFragmentList.OnListFragmentSelectionListener {
    static ArrayList<Equipo> teamArrayList = new ArrayList<Equipo>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // cargamos los valores en el arrayList
        rellenarArrayList();

    }


    private void rellenarArrayList() {
        //recupero el array de los escudos de los recursos
        TypedArray arrayTypedEscudos =
                getResources().obtainTypedArray(R.array.escudo_equipo);

        //recupero el array de los nombres de equipos
        String[] arrayNombreEquipos =
                getResources().getStringArray(R.array.nombre_equipo);

        //recupero el array de los puntos de equipos
        int[] arrayPuntosEquipos =
                getResources().getIntArray(R.array.puntos_equipo);

        //relleno el arraylist
        for (int i = 0; i < arrayNombreEquipos.length; i++) {
            teamArrayList.add(new Equipo(arrayNombreEquipos[i],
                    arrayTypedEscudos.getDrawable(i),
                    arrayPuntosEquipos[i]));
        }

    }

    @Override
    public void onListFragmentSelection(int pos) {
        //intentamos obtener el segundo fragment, el de detalle
        TeamDetailFragment teamDetailFragment = (TeamDetailFragment) getFragmentManager().findFragmentById(R.id.fragmentDetail);
        if (teamDetailFragment != null) {
            //hay dos paneles
            // muestro el equipo en el detailFragment
            teamDetailFragment.showTeam(teamArrayList.get(pos));
        } else {
            //hay un solo panel
            // debo lanzar la activity DetailTeamActivity
            Intent i = new Intent(this, DetailTeamActivity.class);
            i.putExtra(DetailTeamActivity.EXTRA_POS_EQUIPO, pos);
            startActivity(i);
        }
    }
}
