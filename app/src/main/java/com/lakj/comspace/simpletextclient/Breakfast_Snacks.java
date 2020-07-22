package com.lakj.comspace.simpletextclient;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class Breakfast_Snacks extends Activity{

    static int Samosa ;
    static int Kachori;
    static int Bread_pakoda;
    static int Poha;
    static int Upma;
    static int Aaloo_Bonda;
    static int Onion_pakoda;
    static int Sabudana_Wada;
    static int Breakfast_Snacks_total;

    @Override
    public void onBackPressed() {
        // do nothing.
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breakfast_snacks);
        total_cal();
        orders_list_init();
    }
    public void Samosa_inc(View view) {
        Samosa = inc(Samosa);
        TextView tv = (TextView) findViewById(R.id.samosa_order);
        tv.setText("" + Samosa);
        total_cal();
    }
    public void Samosa_dec(View view) {
        if (Samosa >= 0) {
            Samosa = dec(Samosa);
            TextView tv = (TextView) findViewById(R.id.samosa_order);
            if (Samosa > 0) tv.setText("" + Samosa);
            else tv.setText("__");
            total_cal();
        }
    }

    public void Kachori_inc(View view) {
        Kachori = inc(Kachori);
        TextView tv = (TextView) findViewById(R.id.kachori_order);
        tv.setText("" + Kachori);
        total_cal();
    }

    public void Kachori_dec(View view) {
        if (Kachori >= 0) {
            Kachori = dec(Kachori);
            TextView tv = (TextView) findViewById(R.id.kachori_order);
            if (Kachori > 0) tv.setText("" + Kachori);
            else tv.setText("__");
            total_cal();
        }
    }

    public void Bread_pakoda_inc(View view) {
        Bread_pakoda = inc(Bread_pakoda);
        TextView tv = (TextView) findViewById(R.id.bread_pakoda_order);
        tv.setText("" + Bread_pakoda);
        total_cal();
    }

    public void Bread_pakoda_dec(View view) {
        if (Bread_pakoda >= 0) {
            Bread_pakoda = dec(Bread_pakoda);
            TextView tv = (TextView) findViewById(R.id.bread_pakoda_order);
            if (Bread_pakoda > 0) tv.setText("" + Bread_pakoda);
            else tv.setText("__");
            total_cal();
        }
    }
    public void Poha_inc(View view) {
        Poha = inc(Poha);
        TextView tv = (TextView) findViewById(R.id.poha_order);
        tv.setText("" + Poha);
        total_cal();
    }

    public void Poha_dec(View view) {
        if (Poha >= 0) {
            Poha = dec(Poha);
            TextView tv = (TextView) findViewById(R.id.poha_order);
            if (Poha > 0) tv.setText("" + Poha);
            else tv.setText("__");
            total_cal();

        }
    }
    public void Upma_inc(View view) {
        Upma = inc(Upma);
        TextView tv = (TextView) findViewById(R.id.upma_order);
        tv.setText("" + Upma);
        total_cal();
    }

    public void Upma_dec(View view) {
        if (Upma >= 0) {
            Upma = dec(Upma);
            TextView tv = (TextView) findViewById(R.id.upma_order);
            if (Upma > 0) tv.setText("" + Upma);
            else tv.setText("__");
            total_cal();

        }
    }
    public void Aaloo_Bonda_inc(View view) {
        Aaloo_Bonda = inc(Aaloo_Bonda);
        TextView tv = (TextView) findViewById(R.id.aaloo_Bonda_order);
        tv.setText("" + Aaloo_Bonda);
        total_cal();
    }

    public void Aaloo_Bonda_dec(View view) {
        if (Aaloo_Bonda >= 0) {
            Aaloo_Bonda = dec(Aaloo_Bonda);
            TextView tv = (TextView) findViewById(R.id.aaloo_Bonda_order);
            if (Aaloo_Bonda > 0) tv.setText("" + Aaloo_Bonda);
            else tv.setText("__");

            total_cal();
        }
    }
    public void Onion_pakoda_inc(View view) {
        Onion_pakoda = inc(Onion_pakoda);
        TextView tv = (TextView) findViewById(R.id.onion_pakoda_order);
        tv.setText("" + Onion_pakoda);

        total_cal();
    }

    public void Onion_pakoda_dec(View view) {
        if (Onion_pakoda >= 0) {
            Onion_pakoda = dec(Onion_pakoda);
            TextView tv = (TextView) findViewById(R.id.onion_pakoda_order);
            if (Onion_pakoda > 0) tv.setText("" + Onion_pakoda);
            else tv.setText("__");

            total_cal();
        }
    }
    public void Sabudana_Wada_inc(View view) {
        Sabudana_Wada = inc(Sabudana_Wada);
        TextView tv = (TextView) findViewById(R.id.sabudana_Wada_order);
        tv.setText("" + Sabudana_Wada);

        total_cal();
    }

    public void Sabudana_Wada_dec(View view) {
        if (Sabudana_Wada >= 0) {
            Sabudana_Wada = dec(Sabudana_Wada);
            TextView tv = (TextView) findViewById(R.id.sabudana_Wada_order);
            if (Sabudana_Wada > 0) tv.setText("" + Sabudana_Wada);
            else tv.setText("__");

            total_cal();
        }
    }
    public void total_cal() {
        Breakfast_Snacks_total = Samosa * (20) + Kachori * (20) + Bread_pakoda * (20) + Poha * (20) + Upma * (20) + Aaloo_Bonda * (20) + Onion_pakoda * (20) + Sabudana_Wada * (30);
        finalize_order.all_total =Drinks.Drinks_total+Breakfast_Snacks.Breakfast_Snacks_total + Veg.total_veg + N_Veg.n_veg_total;

        if (finalize_order.all_total > 0) {
            TextView tv = (TextView) findViewById(R.id.Breakfast_Sancks_tot_id);
            tv.setText("" + "₹" + (finalize_order.all_total));
        } else {
            TextView tv = (TextView) findViewById(R.id.Breakfast_Sancks_tot_id);
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

        if ( Samosa > 0) {
            TextView tv = (TextView) findViewById(R.id.samosa_order);
            tv.setText("" + Samosa);
        }
        if (Kachori > 0) {
            TextView tv = (TextView) findViewById(R.id.kachori_order);
            tv.setText("" + Kachori);
        }
        if (Bread_pakoda > 0) {
            TextView tv = (TextView) findViewById(R.id.bread_pakoda_order);
            tv.setText("" + Bread_pakoda);
        }
        if (Poha > 0) {
            TextView tv = (TextView) findViewById(R.id.poha_order);
            tv.setText("" + Poha);
        }

        if (Upma > 0) {
            TextView tv = (TextView) findViewById(R.id.upma_order);
            tv.setText("" + Upma);
        }
        if (Aaloo_Bonda > 0) {
            TextView tv = (TextView) findViewById(R.id.aaloo_Bonda_order);
            tv.setText("" + Aaloo_Bonda);
        }
        if (Onion_pakoda > 0) {
            TextView tv = (TextView) findViewById(R.id.onion_pakoda_order);
            tv.setText("" + Onion_pakoda);
        }
        if ( Sabudana_Wada > 0) {
            TextView tv = (TextView) findViewById(R.id.sabudana_wada_order);
            tv.setText("" + Sabudana_Wada);
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

