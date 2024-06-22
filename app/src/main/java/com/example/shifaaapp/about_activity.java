package com.example.shifaaapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class about_activity extends AppCompatActivity {

    TextView textView ;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        textView = findViewById(R.id.textView555);

        String s1 = ("شفاء هو موقع ويب وتطبيق يساعد العمالء المرضي علي الحجز والتواصل مع العيادة الطبية عن طريق  الدخول علي الموقع او التطبيق و البحث عن القسم المطلوب حيث يوجد جيع االقسام الطبية ومن ثم اختيار الطبيب حيث يوجد العديد من االطباء لكل قسم كما يوجد نبذة عن خبرات كل دكتور و يوجد كما يوجد صفحات لالبالغ عن مشكلة او للشكوى في حالة حدوث مشكلة ويمكن للمريض التواصل مع الدكتور شخصيا بعد الكشف  في حالة حدوث اعراض او التأكد من من شي ويوجد ايضا صفحة لشراء الأدوية وصفحة للاسعافات الأولية ويوجد ايضا صفحة تحتوي علي ارقام مسعفين للتواصل في حالات الطوارئ و العديد من المقاالت الطبية التي قد تساعد المريض علي  التعامل مع بعض المراض المنتشرة وزيادة الوعي الصحى كما يوجد صفحة لألدوية السريعة لعالج بعض  االمراض واالصابات الخفيفة مثل الصداع والكدمات وغيرها .");
        String s2 = "\n\n تحت اشراف الدكتورة: شيماء هجرس\n\n" +
                "اعضاء المشروع :\n" +
                "- محمد رمضان عبدالمجيد ابو العنين الضبع\n" +
                "- محمد علي محمد مسعود\n" +
                "- محمود عبدالله شعبان سعده\n" +
                "- محمد محمود جاد محمود بدير\n" +
                "- محمد عبد المنعم المتولي صديق";

        textView.setText(s1 + s2);
    }
}