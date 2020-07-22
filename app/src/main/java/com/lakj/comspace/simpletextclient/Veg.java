package com.lakj.comspace.simpletextclient;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static com.lakj.comspace.simpletextclient.R.id.veg_fried_rice_order;

public class Veg extends Activity {

    static int Veg_Noodles;
    static int Veg_Manchurian;
    static int Veg_Fried_Rice;
    static int Veg_Pulao;
    static int Paneer_Pualo;
    static int Veg_Biryani;
    static int Paneer_Chilly;
    static int total_veg;
    static String order_veg;

    @Override
    public void onBackPressed() {
        // do nothing.
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veg);
        total_cal();
        orders_list_init();
    }


    public void Veg_Noodles_inc(View view){
        Veg_Noodles = inc(Veg_Noodles);
        TextView tv = (TextView) findViewById(R.id.veg_noodles_order);
        tv.setText("" + Veg_Noodles);
        total_cal();
    }
    public void Veg_Noodles_dec(View view) {
        if (Veg_Noodles>= 0) {
            Veg_Noodles = dec(Veg_Noodles);
            TextView tv = (TextView) findViewById(R.id.veg_noodles_order);
            if(Veg_Noodles>0) tv.setText("" + Veg_Noodles);
            else tv.setText("__");

            total_cal();
        }
    }


    public void Veg_Manchurian_inc(View view){
        Veg_Manchurian = inc(Veg_Manchurian);
        TextView tv = (TextView) findViewById(R.id.veg_manchurian_order);
        tv.setText("" + Veg_Manchurian);
        total_cal();
    }
    public void Veg_Manchurian_dec(View view) {
        if (Veg_Manchurian>= 0) {
            Veg_Manchurian= dec(Veg_Manchurian);
            TextView tv = (TextView) findViewById(R.id.veg_manchurian_order);
            if(Veg_Manchurian>0) tv.setText("" + Veg_Manchurian);
            else tv.setText("__");

            total_cal();
        }
    }

    public void Veg_Fried_Rice_inc(View view){
        Veg_Fried_Rice=inc(Veg_Fried_Rice);
        TextView tv = (TextView) findViewById(veg_fried_rice_order);
        tv.setText("" + Veg_Fried_Rice);
        total_cal();
    }
    public void Veg_Fried_Rice_dec(View view) {
        if (Veg_Fried_Rice>= 0) {
            Veg_Fried_Rice= dec(Veg_Fried_Rice);
            TextView tv = (TextView) findViewById(veg_fried_rice_order);
            if(Veg_Fried_Rice>0) tv.setText("" + Veg_Fried_Rice);
            else tv.setText("__");

            total_cal();
        }
    }

    public void Veg_Pulao_inc(View view){
        Veg_Pulao = inc(Veg_Pulao);
        TextView tv = (TextView) findViewById(R.id.veg_pulao_order);
        tv.setText("" + Veg_Pulao);
        total_cal();
    }
    public void Veg_Pulao_dec(View view) {
        if (Veg_Pulao >= 0) {
            Veg_Pulao = dec(Veg_Pulao);
            TextView tv = (TextView) findViewById(R.id.veg_pulao_order);
            if(Veg_Pulao>0) tv.setText("" + Veg_Pulao);
            else tv.setText("__");

            total_cal();
        }
    }

    public void Paneer_Pualo_inc(View view){
        Paneer_Pualo=inc(Paneer_Pualo);
        TextView tv = (TextView) findViewById(R.id.paneer_pualo_order);
        tv.setText("" + Paneer_Pualo);

        total_cal();
    }
    public void Paneer_Pualo_dec(View view) {
        if (Paneer_Pualo>= 0) {
            Paneer_Pualo= dec(Paneer_Pualo);
            TextView tv = (TextView) findViewById(R.id.paneer_pulao_order);
            if(Paneer_Pualo>0) tv.setText("" + Paneer_Pualo);
            else tv.setText("__");

            total_cal();
        }
    }

    public void Veg_Biryani_inc(View view){
        Veg_Biryani=inc(Veg_Biryani);
        TextView tv = (TextView) findViewById(R.id.veg_biryani_order);
        tv.setText("" + Veg_Biryani);
        total_cal();
    }
    public void Veg_Biryani_dec(View view) {
        if (Veg_Biryani>= 0) {
            Veg_Biryani= dec(Veg_Biryani);
            TextView tv = (TextView) findViewById(R.id.veg_biryani_order);
            if(Veg_Biryani>0) tv.setText("" + Veg_Biryani);
            else tv.setText("__");

            total_cal();
            }
    }

    public void Paneer_Chilly_inc(View view) {
        Paneer_Chilly = inc(Paneer_Chilly);
        TextView tv = (TextView) findViewById(R.id.paneer_chilly_order);
        tv.setText("" + Paneer_Chilly);
        total_cal();
    }

    public void Paneer_Chilly_dec(View view) {
        if (Paneer_Chilly >= 0) {
            Paneer_Chilly = dec(Paneer_Chilly);
            TextView tv = (TextView) findViewById(R.id.paneer_chilly_order);
            if (Paneer_Chilly > 0) tv.setText("" + Paneer_Chilly);
            else tv.setText("__");

            total_cal();
        }
    }




    public void total_cal(){
        total_veg = Veg_Noodles*(50)+Veg_Manchurian*(50)+Veg_Fried_Rice*(50)+Veg_Pulao*(70)+Paneer_Pualo*(80)+Veg_Biryani*(50)+Paneer_Chilly*(80);
        finalize_order.all_total=Drinks.Drinks_total+Breakfast_Snacks.Breakfast_Snacks_total + Veg.total_veg + N_Veg.n_veg_total;

        if (finalize_order.all_total > 0) {
        TextView tv = (TextView) findViewById(R.id.veg_total_id);
        tv.setText(""+"₹"+ (finalize_order.all_total));
    }
    else{
            TextView tv = (TextView) findViewById(R.id.veg_total_id);
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
            if (Veg_Noodles > 0) {
                TextView tv = (TextView) findViewById(R.id.veg_noodles_order);
                tv.setText("" + Veg_Noodles);
            }
            if (Veg_Manchurian > 0) {
                TextView tv = (TextView) findViewById(R.id.veg_manchurian_order);
                tv.setText("" + Veg_Manchurian);
            }

            if (Veg_Fried_Rice > 0) {
                TextView tv = (TextView) findViewById(veg_fried_rice_order);
                tv.setText("" + Veg_Fried_Rice);
            }
            if (Veg_Pulao > 0) {
                TextView tv = (TextView) findViewById(R.id.veg_pulao_order);
                tv.setText("" + Veg_Pulao);
            }
            if (Paneer_Pualo > 0) {
                TextView tv = (TextView) findViewById(R.id.paneer_pualo_order);
                tv.setText("" + Paneer_Pualo);
            }
            if (Veg_Biryani > 0) {
                TextView tv = (TextView) findViewById(R.id.veg_biryani_order);
                tv.setText("" + Veg_Biryani);
            }
            if (Paneer_Chilly > 0) {
                TextView tv = (TextView) findViewById(R.id.paneer_chilly_order);
                tv.setText("" + Paneer_Chilly);
            }
        }
    public void fin_ord(View view)
    {
        final Object o= this;
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

                                Intent nextact = new Intent((Veg) o, thankyou.class);
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
