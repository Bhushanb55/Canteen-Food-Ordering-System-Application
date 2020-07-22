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


public class finalize_order extends Activity {
    finalize_order a=this;
    public static  Socket client;
    public static PrintWriter printwriter;
    public static BufferedReader bb;
    public static String messsage;
    public static String m1;
    static int old_all_total;
    static int all_total;

    String personal_preferances;
    Object oo;
    String fin_order_string="";
    public String S;
    static int next_ord_flag;
    static String order_string;
    static String old_ord_string="";

    @Override
    public void onBackPressed() {
        // do nothing.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalize_order);
        show_Order();
        tot_v();
        oo=this;
    }


    public void show_Order() {
        if (Drinks.Tea > 0) {
            fin_order_string = fin_order_string + "Tea-" + String.valueOf(Drinks.Tea) + ",";
        }
        if (Drinks.Cofee > 0) {
            fin_order_string = fin_order_string + "Coffe-" + String.valueOf(Drinks.Cofee) + ",";
        }
        if (Drinks.Cold_Drinks > 0) {
            fin_order_string = fin_order_string + "Cold Drinks-" + String.valueOf(Drinks.Cold_Drinks) + ",";
        }

        if (N_Veg.chicken_biryani > 0) {
            fin_order_string = fin_order_string + "Chicken Biryani-" + String.valueOf(N_Veg.chicken_biryani) + ",";
        }
        if (N_Veg.chicken_chilly > 0) {
            fin_order_string = fin_order_string + "Chicken Chilly-" + String.valueOf(N_Veg.chicken_chilly) + ",";
        }
        if (N_Veg.chicken_noodles > 0) {
            fin_order_string = fin_order_string + "chicken noodles-" + String.valueOf(N_Veg.chicken_noodles) + ",";
        }
        if (N_Veg.chicken_fried_rice > 0) {
            fin_order_string = fin_order_string + "chicken fried rice-" + String.valueOf(N_Veg.chicken_fried_rice) + ",";
        }

        if (N_Veg.chicken_lollipop > 0) {
            fin_order_string = fin_order_string + "chicken lollipop-" + String.valueOf(N_Veg.chicken_lollipop) + ",";
        }

        if (N_Veg.chicken_biryani> 0) {
            fin_order_string = fin_order_string + "chicken biryani-" + String.valueOf(N_Veg.chicken_biryani) + ",";
        }


        if (Veg.Veg_Noodles > 0) {
            fin_order_string = fin_order_string + "Veg Noodles-" + String.valueOf(Veg.Veg_Noodles) + ",";
        }
        if (Veg.Veg_Manchurian > 0) {
            fin_order_string = fin_order_string + "Veg Manchurian-" + String.valueOf(Veg.Veg_Manchurian) + ",";
        }
        if (Veg.Veg_Fried_Rice > 0) {
            fin_order_string = fin_order_string + "Veg Fried Rice-" + String.valueOf(Veg.Veg_Fried_Rice) + ",";
        }

        if (Veg.Veg_Pulao > 0) {
            fin_order_string = fin_order_string + "Veg Pulao-" + String.valueOf(Veg.Veg_Pulao) + ",";
        }
        if (Veg.Paneer_Pualo> 0) {
            fin_order_string = fin_order_string + "Paneer Pualo-" + String.valueOf(Veg.Paneer_Pualo) + ",";
        }
        if (Veg.Veg_Biryani> 0) {
            fin_order_string = fin_order_string + "Veg Biryani-" + String.valueOf(Veg.Veg_Biryani) + ",";
        }
        if (Veg.Paneer_Chilly> 0) {
            fin_order_string = fin_order_string + "Paneer Chilly-" + String.valueOf(Veg.Paneer_Chilly) + ",";
        }


        if (Breakfast_Snacks.Samosa > 0) {
            fin_order_string = fin_order_string + "Samosa-" + String.valueOf(Breakfast_Snacks.Samosa) + ",";
        }
        if (Breakfast_Snacks.Kachori > 0) {
            fin_order_string = fin_order_string + "Kachori-" + String.valueOf(Breakfast_Snacks.Kachori) + ",";
        }
        if (Breakfast_Snacks.Bread_pakoda > 0) {
            fin_order_string = fin_order_string + "Bread pakoda-" + String.valueOf(Breakfast_Snacks.Bread_pakoda) + ",";
        }
        if (Breakfast_Snacks.Poha > 0) {
            fin_order_string = fin_order_string + "Poha-" + String.valueOf(Breakfast_Snacks.Poha) + ",";
        }
        if (Breakfast_Snacks.Upma > 0) {
            fin_order_string = fin_order_string + "Upma-" + String.valueOf(Breakfast_Snacks.Upma) + ",";
        }
        if (Breakfast_Snacks.Aaloo_Bonda > 0) {
            fin_order_string = fin_order_string + "Aaloo Bonda-" + String.valueOf(Breakfast_Snacks.Aaloo_Bonda) + ",";
        }
        if (Breakfast_Snacks.Onion_pakoda > 0) {
            fin_order_string = fin_order_string + "Onion pakoda-" + String.valueOf(Breakfast_Snacks.Onion_pakoda) + ",";
        }
        if (Breakfast_Snacks.Sabudana_Wada > 0) {
            fin_order_string = fin_order_string + "Sabudana Wada-" + String.valueOf(Breakfast_Snacks.Sabudana_Wada) + ",";
        }


        String temp_order_view=fin_order_string+old_ord_string;
        TextView tv = (TextView) findViewById(R.id.order_final);
        tv.setText("" + temp_order_view);
    }

    public void main_menu(View view) {
        Intent goto_main_menu = new Intent(this, Order_Type.class);
        startActivity(goto_main_menu);
        overridePendingTransition(R.anim.fadin, R.anim.fadout);
    }

    public void tot_v(){
        all_total=all_total+old_all_total;
        TextView tv = (TextView) findViewById(R.id.tot_p);
        tv.setText("total price:" + "₹" +(finalize_order.all_total));
    }



    public class SendMessage extends AsyncTask<Void, Void, Void> {
        BufferedReader bb;
        Socket client;
        PrintWriter printwriter;


        @Override
        protected Void doInBackground(Void... params) {
            try {
                client = new Socket("192.168.1.105", 4444); // connect to the server
                printwriter = new PrintWriter(client.getOutputStream(), true);
                bb=new BufferedReader(new InputStreamReader(client.getInputStream()));
                printwriter.println(finalize_order.messsage); // write the message to output stream
                printwriter.flush();
                m1=bb.readLine();
                //System.out.println("dd:"+m1);
                //m1="hello";
                bb.close();
                client.close(); // closing the connection
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    public void send_ord(View v){
        order_string=fin_order_string;

    EditText Ed= (EditText) findViewById(R.id.personalp);

    personal_preferances=Ed.getText().toString();

    final Object o = this;
    AlertDialog.Builder builder = new AlertDialog.Builder(this);
    builder.setMessage("Are you sure you want to confirm this order?")
            .setCancelable(false)
            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                      messsage = "Order:" + SlimpleTextClientActivity.tablex + "|" + fin_order_string + "|" + Integer.toString(all_total)+"|"+personal_preferances;
                        ; // get the text message on the text field
                   // messsage = "Order:" + SlimpleTextClientActivity.tablex + "|" + fin_order_string + "|" + Integer.toString(all_total);
                        SendMessage sendMessageTask = new SendMessage();
                        sendMessageTask.execute();
                        Intent nextact = new Intent((finalize_order) o, thankyou.class);
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
}