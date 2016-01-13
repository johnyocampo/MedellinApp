package com.ocampojohny.medellinapp;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a {@link ItemListActivity}
 * in two-pane mode (on tablets) or a {@link ItemDetailActivity}
 * on handsets.
 */
public class ItemDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */
    Button boton1,boton2,boton3;
    public static final String ARG_ITEM_ID = "item_id";

    /**
     * The dummy content this fragment is presenting.
     */
    private Content.DummyItem mItem;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(ARG_ITEM_ID)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            mItem = Content.ITEM_MAP.get(getArguments().getString(ARG_ITEM_ID));



            Activity activity = this.getActivity();
           // CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.item_detail, container, false);

        boton1=(Button) rootView.findViewById(R.id.boton_maps1);
        boton2=(Button) rootView.findViewById(R.id.boton_maps2);
        boton3=(Button) rootView.findViewById(R.id.boton_maps3);

        if(mItem.id.equals("1")){
            boton1.setVisibility(View.VISIBLE);
            boton2.setVisibility(View.VISIBLE);
            boton3.setVisibility(View.VISIBLE);}
        else{
            boton1.setVisibility(View.INVISIBLE);
            boton2.setVisibility(View.INVISIBLE);
            boton3.setVisibility(View.INVISIBLE);
        }



        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), puerta_norte_Activity.class);
                startActivity(intent);
            }


        });


        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Eltesoro.class);
                startActivity(intent);

            }




        });

        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Jumbo_la_65.class);
                startActivity(intent);

            }




        });


        // Show the dummy content as text in a TextView.
        if (mItem != null) {
            ((TextView) rootView.findViewById(R.id.textView_superior1)).setText(mItem.textoEncima1);
            ((TextView) rootView.findViewById(R.id.textView_inferior1)).setText(mItem.textoDebajo1);
            ((ImageView) rootView.findViewById(R.id.imageView_imagen1)).setImageResource(mItem.idImagen1);








            ((TextView) rootView.findViewById(R.id.textView_superior2)).setText(mItem.textoEncima2);
            ((TextView) rootView.findViewById(R.id.textView_inferior2)).setText(mItem.textoDebajo2);
            ((ImageView) rootView.findViewById(R.id.imageView_imagen2)).setImageResource(mItem.idImagen2);

            ((TextView) rootView.findViewById(R.id.textView_superior3)).setText(mItem.textoEncima3);
            ((TextView) rootView.findViewById(R.id.textView_inferior3)).setText(mItem.textoDebajo3);
            ((ImageView) rootView.findViewById(R.id.imageView_imagen3)).setImageResource(mItem.idImagen3);


        }

        return rootView;
    }
}
