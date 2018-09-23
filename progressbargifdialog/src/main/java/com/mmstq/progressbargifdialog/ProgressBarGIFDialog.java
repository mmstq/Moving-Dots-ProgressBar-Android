package com.mmstq.progressbargifdialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.content.res.AppCompatResources;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import pl.droidsonroids.gif.GifImageView;

public class ProgressBarGIFDialog {
    private String titleLoading,titleDone;
    private Activity activity;
    private int titleColor;
    private boolean cancelable;

    public ProgressBarGIFDialog(Builder builder) {
        this.titleLoading = builder.titleLoading;
        this.activity = builder.activity;
        this.titleColor = builder.titleColor;
        this.cancelable = builder.cancelable;
    }

    public static class Builder {
        private String titleLoading,doneTitle;
        private Activity activity;
        private Dialog dialog;
        private GifImageView gifImageView;
        private int titleColor,loadingGifID,doneGifID;
        private TextView tvTitle;

        public Builder setDoneGifID(int doneGifID) {
            this.doneGifID = doneGifID;
            return this;
        }

        public Builder setLoadingGifID(int loadingGifID) {
            this.loadingGifID = loadingGifID;
            return this;
        }

        private boolean cancelable = true;

        public Builder(Activity activity) {
            this.activity = activity;
        }

        public Builder setLoadingTitle(String titleLoading) {
            this.titleLoading = titleLoading;
            return this;
        }

        public Builder setTitleColor(int titleColor) {
            this.titleColor = titleColor;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }
        public Builder setDoneTitle(String doneTitle){
            this.doneTitle = doneTitle;
            return this;
        }

        public void clear(){
            if (doneGifID != 0) {
                gifImageView.setImageResource(doneGifID);
            } else {
                gifImageView.setImageResource(R.drawable.done);
            }
            if(doneTitle != null){
                if(!doneTitle.equals("")){
                    tvTitle.setText(doneTitle);
                }
            }else{
                tvTitle.setText("Done");
            }

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    dialog.dismiss();
                }
            },2700);
        }

        @SuppressLint("RestrictedApi")
        public ProgressBarGIFDialog build() {

            dialog = new Dialog(activity);
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setCancelable(cancelable);
            dialog.setContentView(R.layout.loading_dialog);

            tvTitle = dialog.findViewById(R.id.title);
            gifImageView = dialog.findViewById(R.id.gifImageView);

            if (loadingGifID != 0) {
                gifImageView.setImageResource(loadingGifID);
            } else {
                gifImageView.setImageResource(R.drawable.loading);
            }


            if (titleLoading != null) {

                if (!titleLoading.equals("")) {

                    tvTitle.setVisibility(View.VISIBLE);
                    tvTitle.setText(titleLoading);
                    if (titleColor != 0) {
                        tvTitle.setTextColor(AppCompatResources.getColorStateList(activity, titleColor));
                    }
                } else {

                    tvTitle.setVisibility(View.GONE);
                }
            } else {
                tvTitle.setVisibility(View.GONE);
            }

            dialog.show();

            return new ProgressBarGIFDialog(this);

        }

    }

}
