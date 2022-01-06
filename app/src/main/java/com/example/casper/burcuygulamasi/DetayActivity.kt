package com.example.casper.burcuygulamasi

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.graphics.Palette
import kotlinx.android.synthetic.main.activity_detay.*
import java.util.*

class DetayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detay)

        var position=intent.extras.get("tiklanilanOgePosition")as Int
        var tumburcbilgileri=intent.extras.get("tumBurcBilgileri") as ArrayList<Burc>


        tvBurcOzellikleri.setText(tumburcbilgileri.get(position).burcGenelOzellikleri)
        header.setImageResource(tumburcbilgileri.get(position).burcBuyukResim)


        setSupportActionBar(anim_toolbar)
        getSupportActionBar()!!.setDisplayHomeAsUpEnabled(true)
        collapsing_toolbar.title=tumburcbilgileri.get(position).burcAdi

        var bitmap=BitmapFactory.decodeResource(resources,tumburcbilgileri.get(position).burcBuyukResim)
        Palette.from(bitmap).generate(object :Palette.PaletteAsyncListener{
            override fun onGenerated(p0: Palette?) {
                var color =p0?.getDarkVibrantColor(R.attr.colorAccent)
                collapsing_toolbar.setContentScrimColor(color!!)
                window.statusBarColor=color

            }

        })


    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }
}
