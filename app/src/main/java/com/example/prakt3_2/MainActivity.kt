package com.example.prakt3_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var xo:Boolean=true
    var x:Int = 0
    var o:Int = 0
    var no:Int = 0

    val btns:Array<TextView> = arrayOf(t1,t2,t3,t4,t5,t6,t7,t8,t9)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        t1.setOnClickListener{Xoxo(t1)}
        t2.setOnClickListener{Xoxo(t2)}
        t3.setOnClickListener{Xoxo(t3)}
        t4.setOnClickListener{Xoxo(t4)}
        t5.setOnClickListener{Xoxo(t5)}
        t6.setOnClickListener{Xoxo(t6)}


        t7.setOnClickListener{Xoxo(t7)}
        t8.setOnClickListener{Xoxo(t8)}
        t9.setOnClickListener{Xoxo(t9)}

        restart.setOnClickListener{
            for(i in 0..8){
                btns[i].text=null
            }
        }
        reset.setOnClickListener{
            for(i in 0..8){
                btns[i].text=null
            }
            Xwin.text= null
            Owin.text=null
            NOwin.text=null
            x=0;o=0;no=0
        }
        Winner()
    }
    fun Xoxo(t: TextView){
        if(t.text==null) {
            if (xo) {
                t.text = "X"
            } else {
                t.text = "O"
            }
            xo=!xo
        }
    }
    fun AllNotNull():Boolean{
        var notnull:Int=0
        for(i in 0..8){
            if(btns[i].text!=null){
                notnull++
            }
        }
        if(notnull==9){
            return true
        }
        return false

    }
    fun Winner(){
        if(((t1.text=="X")&&(t2.text=="X")&&(t3.text=="X"))||((t4.text=="X")&&(t5.text=="X")&&(t6.text=="X"))||((t7.text=="X")&&(t8.text=="X")&&(t9.text=="X"))||((t1.text=="X")&&(t5.text=="X")&&(t9.text=="X"))||((t3.text=="X")&&(t5.text=="X")&&(t7.text=="X"))){
            x++
        }else{
            if(((t1.text=="O")&&(t2.text=="O")&&(t3.text=="O"))||((t4.text=="O")&&(t5.text=="O")&&(t6.text=="O"))||((t7.text=="O")&&(t8.text=="O")&&(t9.text=="O"))||((t1.text=="O")&&(t5.text=="O")&&(t9.text=="O"))||((t3.text=="O")&&(t5.text=="O")&&(t7.text=="O"))){
                o++
            }else if(AllNotNull()){
                no++
            }
        }
        Xwin.text=x.toString()
        Owin.text=o.toString()
        NOwin.text=no.toString()
    }


}