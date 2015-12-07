package com.kisdy.bee.util;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.telephony.PhoneNumberUtils;

import java.util.List;

/**
 * Created by sdt13411 on 2015/12/4.
 */
public class SmsUtil {

    /**
     * 发送短息
     * @param reciverPhoneNo
     * @param smsContent
     */
    public static void sendSms(String reciverPhoneNo,String smsContent,PendingIntent sentIndent,PendingIntent deliveryIntent){
        android.telephony.SmsManager smsManager=android.telephony.SmsManager.getDefault();
        List<String> divideContents=smsManager.divideMessage(smsContent);
        for(String str:divideContents){
            smsManager.sendTextMessage(reciverPhoneNo,null,str,sentIndent,deliveryIntent);
        }
    }

    public void doSendSMSTo(Context context,String phoneNumber,String message){
        if(PhoneNumberUtils.isGlobalPhoneNumber(phoneNumber)){
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + phoneNumber));
            intent.putExtra("sms_body", message);
            context.startActivity(intent);
        }
    }

}


