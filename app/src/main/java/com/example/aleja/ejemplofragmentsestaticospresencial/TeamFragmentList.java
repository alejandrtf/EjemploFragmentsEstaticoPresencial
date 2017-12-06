package com.example.aleja.ejemplofragmentsestaticospresencial;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TeamFragmentList.OnListFragmentSelectionListener} interface
 * to handle interaction events.
 * Use the {@link TeamFragmentList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeamFragmentList extends Fragment {


    private OnListFragmentSelectionListener mListener;
    private ListView lstTeamsList;


    public TeamFragmentList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TeamFragmentList.
     */

    public static TeamFragmentList newInstance() {
        TeamFragmentList fragment = new TeamFragmentList();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_team_list, container, false);

        return (v);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        lstTeamsList = (ListView) getView().findViewById(R.id.lvListadoEquipos);
        lstTeamsList.setAdapter(new EquipoAdaptador(this.getActivity(), MainActivity.teamArrayList));
        lstTeamsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                if (mListener != null) {
                    // Inform the MainActivity that the item in position pos has been selected
                    mListener.onListFragmentSelection(pos);
                }
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentSelectionListener) {
            mListener = (OnListFragmentSelectionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentSelectionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentSelectionListener {

        void onListFragmentSelection(int pos);
    }
}
