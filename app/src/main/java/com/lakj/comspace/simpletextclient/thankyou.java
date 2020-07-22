package com.lakj.comspace.simpletextclient;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class thankyou extends Activity {




    @Override
    public void onBackPressed() {
    // do nothing.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);

    }


    public void main_menu(View view)
    {
        finalize_order.next_ord_flag=1;
        finalize_order.old_ord_string=finalize_order.order_string+finalize_order.old_ord_string;
        finalize_order.old_all_total=finalize_order.all_total;

        N_Veg.chicken_biryani=0;
        N_Veg.chicken_chilly=0;
        N_Veg.chicken_noodles=0;
        N_Veg.chicken_fried_rice=0;
        N_Veg.chicken_lollipop=0;
        N_Veg.n_veg_total=0;

        Drinks.Tea=0;
        Drinks.Cofee=0;
        Drinks.Cold_Drinks=0;
        Drinks.Drinks_total=0;

        Veg.Veg_Noodles=0;
        Veg.Veg_Manchurian=0;
        Veg.Veg_Fried_Rice=0;
        Veg.Veg_Pulao=0;
        Veg.Paneer_Pualo=0;
        Veg.Veg_Biryani=0;
        Veg.Paneer_Chilly=0;
        Veg.total_veg=0;
        Veg.total_veg=0;

        Breakfast_Snacks.Samosa=0 ;
        Breakfast_Snacks.Kachori=0;
        Breakfast_Snacks.Bread_pakoda=0;
        Breakfast_Snacks.Poha=0;
        Breakfast_Snacks.Upma=0;
        Breakfast_Snacks.Aaloo_Bonda=0;
        Breakfast_Snacks.Onion_pakoda=0;
        Breakfast_Snacks.Sabudana_Wada=0;
        Breakfast_Snacks.Breakfast_Snacks_total=0;


        Intent menu= new Intent(this,Order_Type.class);
        startActivity(menu);

    }



}
