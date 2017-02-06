package com.booboomx.rxjavaretrofitdemo.retrofit;

import android.content.Context;
import android.content.DialogInterface;

import cn.pedant.SweetAlert.SweetAlertDialog;
import rx.Subscriber;

/**
 * Created by booboomx on 17/2/6.
 */

/**
 * 自定义Subscribe
 * @param <T>
 */
public abstract class RxSubscribe<T> extends Subscriber<T> {
    private Context mContext;
    private SweetAlertDialog mDialog;
    private String msg;

    public boolean showDialog(){
        return true;
    }

    public RxSubscribe(Context context,String msg){
        this.mContext=context;
        this.msg=msg;
    }

    public RxSubscribe (Context context){
        this(context,"请稍后...");
    }

    public abstract  void _onNext(T t);
    public abstract  void  _onError(String  msg);


    @Override
    public void onStart() {
        super.onStart();
        if(showDialog()){
            mDialog=new SweetAlertDialog(mContext,SweetAlertDialog.PROGRESS_TYPE)
                    .setTitleText(msg);
            mDialog.setCancelable(true);
            mDialog.setCanceledOnTouchOutside(true);
            mDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
                    if(!isUnsubscribed()){
                        unsubscribe();
                    }
                }
            });
            mDialog.show();
        }
    }



    @Override
    public void onNext(T t) {
        _onNext(t);

    }
    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if(false){// TODO 替换网络的代码
            _onError("网络你不可用");
        }else if(e instanceof  ServerException){
            _onError(e.getMessage());

        }else{
            _onError("请求失败，请稍后再试...");
        }

        if(showDialog()){
            mDialog.dismiss();
        }


    }

    @Override
    public void onCompleted() {
        if(mDialog.isShowing()){
            mDialog.dismiss();
        }

    }
}
