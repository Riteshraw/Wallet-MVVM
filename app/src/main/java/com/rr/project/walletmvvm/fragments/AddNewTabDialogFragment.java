package com.rr.project.walletmvvm.fragments;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;

import com.rr.project.walletmvvm.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ritesh on 15-03-2018.
 */

public class AddNewTabDialogFragment extends AppCompatDialogFragment {
    private Dialog dialog;

    @BindView(R.id.img_dialog_close)
    ImageView img_dialog_close;
    @BindView(R.id.edt_addTab)
    EditText edt_addTab;
//    private TabDbHelper tabDbHelper;

    public AddNewTabDialogFragment() {

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_dialog_add_new_tab, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

    @OnClick(R.id.img_dialog_close)
    void onClose() {
        dismiss();
    }

    @OnClick(R.id.btn_dialog_submit)
    void onSubmit() {
//        mainPresenter.addNewTab(Utils.getText(edt_addTab),this);
//        if (newTabName.equals(""))
//            Toast.makeText(getContext(), "Please enter a tab name", Toast.LENGTH_SHORT).show();
//        else {
////            ((MainActivity)getActivity()).insertTab(newTabName);
//            ((MainActivityOptimised) getActivity()).insertTab(newTabName);
//            dismiss();
//        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void dismiss() {
        super.dismiss();
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        dialog = super.onCreateDialog(savedInstanceState);

        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setStyle(STYLE_NO_TITLE, 0);
        return dialog;
    }

    /*@Override
    public void dismissDialog() {
        dismiss();
    }*/
}
