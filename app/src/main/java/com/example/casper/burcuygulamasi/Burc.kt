package com.example.casper.burcuygulamasi

import java.io.Serializable


data class Burc(var burcAdi:String, var burcTarih:String, var burcSembol:Int, var burcBuyukResim:Int, var burcGenelOzellikleri:String): Serializable {
}