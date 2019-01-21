package com.rr.project.walletmvvm.utils;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

//import fr.ganfra.materialspinner.MaterialSpinner;

/**
 * Created by admin on 19-Jun-18.
 */

public class Validation {

    private static boolean isValidMobile(String mobile) {
        String pattern = "[789][0-9]{9}";
        return mobile.matches(pattern);
    }

    private static boolean isValidName(String name) {
        String pattern = "[a-zA-Z 0-9._-]*";
        return name.matches(pattern);
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private static void requestFocus(View view, Activity activity) {
        if (view.requestFocus()) {
            view.requestFocus();
            activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    public static boolean validateMobileNo(EditText input_mobile, TextInputLayout input_layout_mobile, Activity activity) {
        String mobile_no = Utils.getText(input_mobile);

        if (mobile_no.isEmpty() || !isValidMobile(mobile_no)) {
            input_layout_mobile.setError("Enter valid mobile no");
            requestFocus(input_layout_mobile, activity);
            return false;
        } else
            input_layout_mobile.setErrorEnabled(false);

        return true;
    }

    public static boolean validateCheckBox(CheckBox checkbox_tc, Context context) {
        if (!checkbox_tc.isChecked()) {
            Utils.showToast(context, "Please check terms and conditions");
            return false;
        }
        return true;
    }

    public static boolean validateOTP(EditText input_otp, TextInputLayout input_layout_otp, Activity activity) {
        String otp = Utils.getText(input_otp);

        if (otp.isEmpty() || otp.length() < 4) {
            input_layout_otp.setError("Enter valid OTP");
            requestFocus(input_layout_otp, activity);
            return false;
        } else
            input_layout_otp.setErrorEnabled(false);

        return true;
    }

    public static boolean validatePassword(EditText input_password, TextInputLayout input_layout_password, Activity activity) {
        String password = Utils.getText(input_password);

        if (password.isEmpty() || password.length() < 6) {
            input_layout_password.setError("Enter valid password");
            requestFocus(input_layout_password, activity);
            return false;
        } else
            input_layout_password.setErrorEnabled(false);

        return true;
    }

    public static boolean validateName(EditText edit_name, TextInputLayout input_layout_password, Activity activity, String msg) {

        if (Utils.getText(edit_name).isEmpty()) {
            input_layout_password.setError(msg);
            requestFocus(input_layout_password, activity);
            return false;
        } else if (Utils.getText(edit_name).length() < 3) {
            input_layout_password.setError("Name should have atleast 3 characters");
            requestFocus(input_layout_password, activity);
            return false;
        } else if (!(isValidName(Utils.getText(edit_name)))) {
            input_layout_password.setError("No digits/special character allowed");
            requestFocus(input_layout_password, activity);
            return false;
        } else
            input_layout_password.setErrorEnabled(false);

        return true;
    }

    public static boolean validatePincode(EditText edit_pincode, TextInputLayout input_layout_password, Activity activity) {
        if (Utils.getText(edit_pincode).isEmpty()) {
            input_layout_password.setError("Please enter pincode");
            requestFocus(edit_pincode, activity);
            return false;
        } else if (Utils.getText(edit_pincode).length() != 6) {
            input_layout_password.setError("Please enter a valid pin code");
            requestFocus(edit_pincode, activity);
            return false;
        } else
            input_layout_password.setErrorEnabled(false);

        return true;
    }

    public static boolean validateAddress(EditText edit_txt, TextInputLayout input_layout_password, Activity activity, String msg) {
        if (Utils.getText(edit_txt).isEmpty()) {
            input_layout_password.setError("Field is necessary");
            requestFocus(input_layout_password, activity);
            return false;
        } else
            input_layout_password.setErrorEnabled(false);

        return true;
    }

    public static boolean validateAddress(TextView edit_txt, TextInputLayout input_layout_password, Activity activity, String msg) {
        if (Utils.getText(edit_txt).isEmpty()) {
            input_layout_password.setError("Field is necessary");
            requestFocus(input_layout_password, activity);
            return false;
        } else
            input_layout_password.setErrorEnabled(false);

        return true;
    }

/*    public static boolean validateSpinner(int selectedId, MaterialSpinner spinner, Activity activity, String msg) {
        if (selectedId == 0) {
            spinner.setEnabled(true);
            spinner.setError(msg);
            Utils.showToast(activity, msg);
            return false;
        } else
            spinner.setEnabled(false);
//         else {
//            Utils.showToast(activity,msg);
//        }
        return true;
    }*/

    public static boolean validateEmail(EditText inputEmail, TextInputLayout input_layout_password, Activity activity) {
        String email = inputEmail.getText().toString().trim();

        if (Utils.getText(inputEmail).isEmpty()) {
            input_layout_password.setError("Please enter email");
            requestFocus(input_layout_password, activity);
            return false;
        } else if (!isValidEmail(email)) {
            input_layout_password.setError("Enter valid email");
            requestFocus(input_layout_password, activity);
            return false;
        } else
            input_layout_password.setErrorEnabled(false);

        return true;
    }
}
