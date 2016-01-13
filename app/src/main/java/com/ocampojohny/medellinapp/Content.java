package com.ocampojohny.medellinapp;

import android.widget.Button;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class Content {

    /**
     * An array of sample (dummy) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();



    static {
        // Add some sample items.

        addItem(new DummyItem("1",R.string.itemcine, R.drawable.cine_puertanorte,R.drawable.cinemark_tesoro,
                R.drawable.rayalfilms,R.string.Tcine_puertanorte,R.string.Tcinemark,R.string.TroyalFilms,
                R.string.Dcine_puertanorte,R.string.Dcinemark,R.string.DroyalFilms));

        addItem(new DummyItem("2",R.string.itemteatro, R.drawable.aguila_descalza,R.drawable.pablo,
                R.drawable.teatrico,R.string.Taguila_descalza,R.string.Tpablo_tobon,R.string.Tteatrico,
                R.string.Daguila_descalza,R.string.Dpablo_tobon,R.string.Dteatrico));

        addItem(new DummyItem("3",R.string.itemrestaurantes, R.drawable.bistr,R.drawable.cafe_colombo_credenza,
                R.drawable.the_girl_station,R.string.TBistro,R.string.Tcafe_colombo,R.string.TThe_Grill_Station,
                R.string.DBistro,R.string.Dcafe_colombo,R.string.DThe_Grill_Station));

        addItem(new DummyItem("4",R.string.itemrumba, R.drawable.babylon,R.drawable.palmahia,
                R.drawable.pub_rock,R.string.TDisco_babylon,R.string.Tpalmahía,R.string.Tpub_rock,
                R.string.DDisco_babylon,R.string.Dpalmahía,R.string.Dpub_rock));

        addItem(new DummyItem("5",R.string.itemSitios, R.drawable.basilica,R.drawable.casabarrientos,
                R.drawable.pantalla_de_agua,R.string.Tbasilica,R.string.Tcasa_barrientos,R.string.Tpantalla_de_agua,
                R.string.Dbasilica,R.string.Dcasa_barrientos,R.string.Dpantalla_de_agua));






    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }





    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public String id;
        public int nombre;
        public int idImagen1, idImagen2,idImagen3;
        public int textoEncima1;
        public int textoEncima2;
        public int textoEncima3;
        public int textoDebajo1,textoDebajo2,textoDebajo3;
        float lat, longitud;




        public DummyItem(String id, int nombre, int idImagen1,int idImagen2,int idImagen3, int textoEncima1,
                         int textoEncima2, int textoEncima3, int textoDebajo1, int textoDebajo2,
                         int textoDebajo3) {
            this.id = id;
            this.nombre = nombre;
            this.idImagen1 = idImagen1;
            this.idImagen2 = idImagen2;
            this.idImagen3 = idImagen3;
            this.textoEncima1 = textoEncima1;
            this.textoEncima2 = textoEncima2;
            this.textoEncima3 = textoEncima3;
            this.textoDebajo1 = textoDebajo1;
            this.textoDebajo2 = textoDebajo2;
            this.textoDebajo3 = textoDebajo3;
        }


    }
}
