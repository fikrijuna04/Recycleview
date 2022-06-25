package com.fukrujuna.recycleview

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.fukrujuna.recycleview.adapter.Adaptermadrid
import com.fukrujuna.recycleview.databinding.ActivityMainBinding
import com.fukrujuna.recycleview.model.pemain

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listpemain = ArrayList<pemain>()
        listpemain.add(pemain("thibaut courtuis",R.drawable.courtois,"penjaga gawang","2.00 m","belgiaa"," 10 juni 1990"))
        listpemain.add(pemain("Karim Benzema",R.drawable.benzema,"penyerang","1.80 m","perancis","18 desember 1989"))
        listpemain.add(pemain("Marcelo",R.drawable.marcello,"bek","1.70 m","brazil","26 okto 1999"))
        listpemain.add(pemain("Ramos sergi",R.drawable.ramos,"bek","2.00 m","spain","23 january 1992"))
        listpemain.add(pemain("zidane zidane",R.drawable.zidan,"pelatih","1.50 m","prancis","17 juni  1980"))
        binding.List.adapter = Adaptermadrid(this,listpemain,object : Adaptermadrid.onClickListener{
            override fun detailData(item: pemain?) {
                Dialog(this@MainActivity).apply {
                    requestWindowFeature(Window.FEATURE_NO_TITLE)
                    setCancelable(true)
                    setContentView(R.layout.detail_data_pemain)

                    val image = this.findViewById<ImageView>(R.id.image_pemain)
                    val nama = this.findViewById<TextView>(R.id.txtNamaPemain)
                    val posisi = this.findViewById<TextView>(R.id.txtposisi)
                    val tinggi = this.findViewById<TextView>(R.id.txttinggi)
                    val tempatlahir= this.findViewById<TextView>(R.id.txtTempatlahir)
                    val tgllahir = this.findViewById<TextView>(R.id.txtTanggallahir)

                    val btn = this.findViewById<Button>(R.id.btnclose)

                    image.setImageResource(item?.foto ?:0)
                    nama.text = "${item?.nama}"
                    posisi.text = "${item?.posisi}"
                    tinggi.text = "${item?.tinggi}"
                    tempatlahir.text = "${item?.tempatlahir}"
                    tgllahir.text = "${item?.tgllahir}"

                    btn.setOnClickListener {
                        this.dismiss()
                    }

                }.show()





            }

        })

    }

}