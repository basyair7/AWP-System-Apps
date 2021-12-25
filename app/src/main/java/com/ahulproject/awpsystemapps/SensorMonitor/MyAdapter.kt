package com.ahulproject.awpsystemapps.SensorMonitor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ahulproject.awpsystemapps.R

class MyAdapter(private val dataList : ArrayList<ListSensor>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.sensor_item,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = dataList[position]

        holder.Sensor.text = currentitem.Sensor
        holder.Kelembaban.text = currentitem.Kelembaban
        holder.TanggalWaktu.text = currentitem.TanggalWaktu

    }

    override fun getItemCount(): Int {

        return dataList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val Sensor : TextView = itemView.findViewById(R.id.NumberSensor)
        val Kelembaban : TextView = itemView.findViewById(R.id.data_id)
        val TanggalWaktu : TextView = itemView.findViewById(R.id.datetime_id)

    }

}