package com.example.casper.burcuygulamasi

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {


    lateinit var tumBurcBilgileri:ArrayList<Burc>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     // window.statusBarColor=resources.getColor(R.color.statusbarColor)

        veriKaynagiHazirla()

        var myBaseAdapter=BurclarBaseAdapter(this, tumBurcBilgileri)
         listview_adapter.adapter=myBaseAdapter
     //   var myadapter=ArrayAdapter<String>(this,R.layout.tek_satir_layout,R.id.tvBurcAdi,burclar)

       // var myadapter=BurclarArrayAdapter(this,R.layout.tek_satir_layout,R.id.tvBurcAdi,burclar,burcTarihleri,burcResimleri)
        //listview_adapter.adapter=myadapter

        listview_adapter.setOnItemClickListener { parent, view, position, id ->


            var intent= Intent(this@MainActivity,DetayActivity::class.java)
            intent.putExtra("tiklanilanOgePosition", position)
            intent.putExtra("tumBurcBilgileri", tumBurcBilgileri)
            startActivity(intent)
        }


    }

    private fun veriKaynagiHazirla() {

        tumBurcBilgileri= ArrayList<Burc>(12)

        var burclar = resources.getStringArray(R.array.burclar)
        var burcTarihleri = resources.getStringArray(R.array.burcTarih)
        var burcResimleri = arrayOf(R.drawable.koc1, R.drawable.boga2, R.drawable.ikizler3, R.drawable.yengec4, R.drawable.aslan5, R.drawable.basak6,
                R.drawable.terazi7, R.drawable.akrep8, R.drawable.yay9, R.drawable.oglak10, R.drawable.kova11, R.drawable.balik12)
        var burcBuyukResimleri = arrayOf(R.drawable.koc_buyuk1, R.drawable.boga_buyuk2, R.drawable.ikizler_buyuk3,
                R.drawable.yengec_buyuk4, R.drawable.aslan_buyuk5, R.drawable.basak_buyuk6,
                R.drawable.terazi_buyuk7, R.drawable.akrep_buyuk8, R.drawable.yay_buyuk9, R.drawable.oglak_buyuk10, R.drawable.kova_buyuk11, R.drawable.balik_buyuk12)

        var burcGenelOzellikler=resources.getStringArray(R.array.burcGenelOzellikler)

        for (i in 0..11){
            var arraylisteAtanacakBurc=Burc(burclar[i], burcTarihleri[i], burcResimleri[i],burcBuyukResimleri[i], burcGenelOzellikler[i])
            tumBurcBilgileri.add(arraylisteAtanacakBurc)
        }

    }


}
