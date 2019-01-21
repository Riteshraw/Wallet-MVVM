package com.rr.project.walletmvvm.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rr.project.walletmvvm.LoginActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by admin on 18-Jun-18.
 */

public class Utils {
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Network connectivity check,
     *
     * @param context context of the calling activity
     * @return boolean, depending
     */
    public static boolean isConnectedToInternet(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netinfo = cm.getActiveNetworkInfo();

        if (netinfo != null && netinfo.isConnectedOrConnecting()) {
            NetworkInfo wifi = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            NetworkInfo mobile = cm.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if ((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting()))
                return true;
            else
                return false;
        } else
            return false;
    }

    /**
     * Shows a alert dialog with settings and retry options.
     * Settings redirects the user to connectivity options in settings
     *
     * @param context context of the calling activity
     */
    public static void showConnectivityError(final Context context) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context/*, R.style.MaterialAlertDialog*/);
        alertDialogBuilder.setTitle("Network Connectivity Error");
        alertDialogBuilder
                .setMessage("This app requires an internet connection. Make sure you are connected to a wifi network or have switched on your network data.")
                .setCancelable(false)
                .setPositiveButton("Setting", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent callGPSSettingIntent = new Intent(Settings.ACTION_SETTINGS);
                        context.startActivity(callGPSSettingIntent);
                    }
                })
                .setNegativeButton("Retry", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        if (!isConnectedToInternet(context))
                            showConnectivityError(context);
                        else {
                            context.startActivity(new Intent(context, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                        }
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    public static void handleResponse(Context context, int responseCode, JSONObject result) {

        try {
            JSONObject jsonResponse = new JSONObject(result.optString(Constants.RESPONSE));

            if (responseCode == Constants.EXCEPTION_CODE || (responseCode >= 400 && responseCode < 500)) {
//                if (Constants.SHOW_DETAILED_ERROR)
                if (!jsonResponse.optString(Constants.MODELSTATE).isEmpty())
                    Utils.showToast(context, jsonResponse.optString(Constants.MODELSTATE));
                else
                    Utils.showToast(context, jsonResponse.optString(Constants.MESSAGE));

            } else if ((responseCode >= 500 && responseCode < 600)) {
                Utils.showToast(context, jsonResponse.optString(Constants.MESSAGE));
            } else
                Utils.showToast(context, "server: " + result);


        } catch (JSONException e) {
            Utils.showToast(context, "server: " + result);
            e.printStackTrace();
        }
    }

    @SuppressLint("MissingPermission")
    public static String getDeviceId(Context context) {
        TelephonyManager mngr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String myAndroidDeviceId = "";
        if (mngr.getDeviceId() != null && !mngr.getDeviceId().equals("000000000000000")) {
            myAndroidDeviceId = mngr.getDeviceId();
        } else {
            myAndroidDeviceId = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        }
        return myAndroidDeviceId;
    }

    public static String getText(EditText c) {
        if (c.getText() != null)
            return c.getText().toString().trim();
        else
            return "";
    }

    public static String getText(TextView c) {
        if (c.getText() != null)
            return c.getText().toString().trim();
        else
            return "";
    }

    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public static ProgressDialog showProgressDialog(Context context) {
        ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        return progressDialog;
    }

    public static String dateToDateString(Date date) {
        return sdf.format(date);
    }

    public static Date dateStringToDate(String prevDate) {
        Date date = null;
        try {
            date = sdf.parse(prevDate);
        } catch (ParseException e) {
            Log.e("Error", "" + e);
        }
        return date;
    }

    public static boolean compareDates(Date date1, Date date2) {
        return dateToDateString(date1).equals(dateToDateString(date2));
    }

    public static void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) view.getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 2);
    }

    public static void hideKeyboard(Context context) {
        ((Activity) context).getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public static String getStringDateFromMilisec(Date time) {
        return new SimpleDateFormat("dd/MM/yyyy").format(time);
    }

    public static boolean isSameDate(String savedDate, String itemDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        boolean result = false;

        try {
            Date date1 = sdf.parse(savedDate);
            Date date2 = sdf.parse(itemDate);

            result = date1.equals(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return result;
    }

    public static Date miliSecToFormattedDate2(long time) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = sdf.parse(miliSecToDateString(time));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public static String miliSecToDateString(long time) {
        return sdf.format(new Date(time));
    }

    public static String convertTimeInMillisToDateString(long timeInMillis, String DATE_TIME_FORMAT) {
        Date d = new Date(timeInMillis /** 1000*/);
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_TIME_FORMAT);
        return sdf.format(d);
    }

    public static String getDay(String date) {
        String input_date = date;
        String finalDay = "";
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date dt1 = null;

            dt1 = format1.parse(input_date);

            DateFormat format2 = new SimpleDateFormat("EEEE");
            finalDay = format2.format(dt1);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return finalDay;
    }

    /*public static int getLocalityIndex(List<Locality> localityList, int localityID) {
        int id = 0;
        for (int i = 0; i < localityList.size(); i++) {
            if (localityList.get(i).getLocalityId() == localityID) {
                id = i+1;
                break;
            }
        }

        return id;
    }*/
}
