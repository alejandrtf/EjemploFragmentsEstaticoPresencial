package com.example.aleja.ejemplofragmentsestaticospresencial;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link TeamDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeamDetailFragment extends Fragment {


    public TeamDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TeamDetailFragment.
     */

    public static TeamDetailFragment newInstance() {
        TeamDetailFragment fragment = new TeamDetailFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team_detail, container, false);
    }

    /**
     * Método que se usará desde la activity para mostrar los datos del equipo que * se haya elegido * * @param equipo el equipo elegido
     */
    public void showTeam(Equipo equipo) {
        ImageView ivEscudo = (ImageView) getView().findViewById(R.id.ivEscudoDetailFragment);
        TextView tvEquipo = (TextView) getView().findViewById(R.id.tvNombreEquipoDetailFragment);
        TextView tvPuntos = (TextView) getView().findViewById(R.id.tvPuntosEquipoDetailFragment);
        ivEscudo.setImageDrawable(equipo.getImagenEscudo());
        tvEquipo.setText(equipo.getNombreEquipo());
        tvPuntos.setText(String.valueOf(equipo.getPuntos()));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


}
