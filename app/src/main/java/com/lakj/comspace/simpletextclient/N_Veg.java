package com.lakj.comspace.simpletextclient;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class N_Veg extends Activity {

    static int chicken_biryani;
    static int chicken_chilly;
    static int chicken_noodles;
    static int chicken_fried_rice;
    static int chicken_lollipop;
    static int n_veg_total;

    @Override
    public void onBackPressed() {
        // do nothing.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n__veg);
        total_cal();
        orders_list_init();
    }




    public void chicken_biryani_inc(View view){
        chicken_biryani=inc(chicken_biryani);
        TextView tv = (TextView) findViewById(R.id.chicken_biryani_order);
        tv.setText("" + chicken_biryani);
        total_cal();
    }
    public void chicken_biryani_dec(View view) {
        if (chicken_biryani>= 0) {

            chicken_biryani= dec(chicken_biryani);
            TextView tv = (TextView) findViewById(R.id.chicken_biryani_order);
            if(chicken_biryani>0) tv.setText("" + chicken_biryani);
            else tv.setText("__");
            total_cal();
        }
    }

    public void chicken_chilly_inc(View view) {
        chicken_chilly = inc(chicken_chilly);
        TextView tv = (TextView) findViewById(R.id.chicken_chilly_order);
        tv.setText("" + chicken_chilly);

        total_cal();
    }

    public void chicken_chilly_dec(View view) {
        if (chicken_chilly >= 0) {
            chicken_chilly = dec(chicken_chilly);
            TextView tv = (TextView) findViewById(R.id.chicken_chilly_order);
            if (chicken_chilly > 0) tv.setText("" + chicken_chilly);
            else tv.setText("__");

            total_cal();
        }
    }

    public void chicken_noodles_inc(View view){
        chicken_noodles=inc(chicken_noodles);
        TextView tv = (TextView) findViewById(R.id.chicken_noodles_order);
        tv.setText("" + chicken_noodles);
        total_cal();
    }
    public void chicken_noodles_dec(View view) {
        if (chicken_noodles>= 0) {
            chicken_noodles= dec(chicken_noodles);
            TextView tv = (TextView) findViewById(R.id.chicken_noodles_order);
            if(chicken_noodles>0) tv.setText("" + chicken_noodles);
            else tv.setText("__");
            total_cal();
        }
    }
    public void chicken_fried_rice_inc(View view){
        chicken_fried_rice=inc(chicken_fried_rice);
        TextView tv = (TextView) findViewById(R.id.chicken_fried_rice_order);
        tv.setText("" + chicken_fried_rice);
        total_cal();
    }
    public void chicken_fried_rice_dec(View view) {
        if (chicken_fried_rice>= 0) {
            chicken_fried_rice= dec(chicken_fried_rice);
            TextView tv = (TextView) findViewById(R.id.chicken_fried_rice_order);
            if(chicken_fried_rice>0) tv.setText("" + chicken_fried_rice);
            else tv.setText("__");
            total_cal();
        }
    }
    public void chicken_lollipop_inc(View view){
        chicken_lollipop=inc(chicken_lollipop);
        TextView tv = (TextView) findViewById(R.id.chicken_lollipop_order);
        tv.setText("" + chicken_lollipop);
        total_cal();
    }
    public void chicken_lollipop_dec(View view) {
        if (chicken_lollipop>= 0) {
            chicken_lollipop= dec(chicken_fried_rice);
            TextView tv = (TextView) findViewById(R.id.chicken_lollipop_order);
            if(chicken_lollipop>0) tv.setText("" + chicken_lollipop);
            else tv.setText("__");
            total_cal();
        }
    }




    public void total_cal() {
        n_veg_total = chicken_biryani * (80)+ chicken_chilly *(80) + chicken_noodles * (60) + chicken_fried_rice * (60) + chicken_lollipop * (100);
        finalize_order.all_total = Drinks.Drinks_total+Breakfast_Snacks.Breakfast_Snacks_total + Veg.total_veg + N_Veg.n_veg_total;
        if (finalize_order.all_total > 0) {
            TextView tv = (TextView) findViewById(R.id.n_veg_tot_id);
            tv.setText("" + "₹" + (finalize_order.all_total));
        }

        else{
            TextView tv = (TextView) findViewById(R.id.n_veg_tot_id);
            tv.setText("");

        }
    }





    public void main_menu(View view){
        Intent goto_main_menu= new Intent(this, Order_Type.class);
        startActivity(goto_main_menu);
        overridePendingTransition(R.anim.fadin, R.anim.fadout);
    }

    public int dec(int x) {
    if (x > 0) {
        x--;
        return x;
    }
    else return 0;
}


public int inc(int x)
{
   x++;
    return (x);
}

    public void orders_list_init() {

        if (chicken_biryani > 0) {
            TextView tv = (TextView) findViewById(R.id.chicken_biryani_order);
            tv.setText("" + chicken_biryani);
        }
        if (chicken_chilly > 0) {
            TextView tv = (TextView) findViewById(R.id.chicken_chilly_order);
            tv.setText("" + chicken_chilly);
        }
        if (chicken_noodles > 0) {
            TextView tv = (TextView) findViewById(R.id.chicken_noodles_order);
            tv.setText("" + chicken_noodles);
        }
        if (chicken_fried_rice > 0) {
            TextView tv = (TextView) findViewById(R.id.chicken_fried_rice_order);
            tv.setText("" + chicken_fried_rice);
        }
        if (chicken_lollipop > 0) {
            TextView tv = (TextView) findViewById(R.id.chicken_lollipop_order);
            tv.setText("" + chicken_lollipop);
        }
    }

    public void fin_ord(View view)
    {
        final Object o=this;
        if(finalize_order.all_total>0) {
            Intent fin = new Intent(this, finalize_order.class);
            startActivity(fin);
            overridePendingTransition(R.anim.fadin, R.anim.fadout);
        }
        else{
            if(finalize_order.next_ord_flag==1)
            {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you sure you don't want to place another order?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                Intent nextact = new Intent((N_Veg) o, thankyou.class);
                                startActivity(nextact);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();

            }

            else{
                Toast.makeText(getApplicationContext(),
                        "Please select your order", Toast.LENGTH_SHORT).show();
            }
        }
    }
}


