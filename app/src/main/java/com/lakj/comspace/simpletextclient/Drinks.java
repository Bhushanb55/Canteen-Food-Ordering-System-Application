package com.lakj.comspace.simpletextclient;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Drinks extends Activity{

    static int Tea;
    static int Cofee;
    static int Cold_Drinks;
    static int Drinks_total;

    @Override
    public void onBackPressed() {
        // do nothing.
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        total_cal();
        orders_list_init();
    }
    public void Tea_inc(View view) {
        Tea = inc(Tea);
        TextView tv = (TextView) findViewById(R.id.tea_order);
        tv.setText("" + Tea);
        total_cal();
    }
    public void Tea_dec(View view) {
        if (Tea >= 0) {
            Tea = dec(Tea);
            TextView tv = (TextView) findViewById(R.id.tea_order);
            if (Tea > 0) tv.setText("" + Tea);
            else tv.setText("__");
            total_cal();
        }
    }

    public void Cofee_inc(View view) {
        Cofee = inc(Cofee);
        TextView tv = (TextView) findViewById(R.id.cofee_order);
        tv.setText("" + Cofee);
        total_cal();
    }

    public void Cofee_dec(View view) {
        if (Cofee >= 0) {
            Cofee = dec(Cofee);
            TextView tv = (TextView) findViewById(R.id.cofee_order);
            if (Cofee > 0) tv.setText("" + Cofee);
            else tv.setText("__");
            total_cal();
        }
    }

    public void Cold_Drinks_inc(View view) {
        Cold_Drinks = inc(Cold_Drinks);
        TextView tv = (TextView) findViewById(R.id.cold_drinks_order);
        tv.setText("" + Cold_Drinks);
        total_cal();
    }

    public void Cold_Drinks_dec(View view) {
        if (Cold_Drinks >= 0) {
            Cold_Drinks = dec(Cold_Drinks);
            TextView tv = (TextView) findViewById(R.id.cold_drinks_order);
            if (Cold_Drinks > 0) tv.setText("" + Cold_Drinks);
            else tv.setText("__");
            total_cal();
        }
    }


    public void total_cal() {
        Drinks_total =  Tea* (5) + Cofee * (7) + Cold_Drinks * (15);
        finalize_order.all_total =Drinks.Drinks_total + Breakfast_Snacks.Breakfast_Snacks_total + Veg.total_veg + N_Veg.n_veg_total;

        if (finalize_order.all_total > 0) {
            TextView tv = (TextView) findViewById(R.id.Drinks_tot_id);
            tv.setText("" + "₹" + (finalize_order.all_total));
        } else {
            TextView tv = (TextView) findViewById(R.id.Drinks_tot_id);
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

        if ( Tea > 0) {
            TextView tv = (TextView) findViewById(R.id.tea_order);
            tv.setText("" + Tea);
        }
        if (Cofee > 0) {
            TextView tv = (TextView) findViewById(R.id.coffe_order);
            tv.setText("" + Cofee);
        }
        if (Cold_Drinks > 0) {
            TextView tv = (TextView) findViewById(R.id.cold_drinks_order);
            tv.setText("" + Cold_Drinks);
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


