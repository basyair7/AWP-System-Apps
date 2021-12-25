package com.ahulproject.awpsystemapps.SensorMonitor

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ahulproject.awpsystemapps.MainActivity
import com.ahulproject.awpsystemapps.R
import com.google.firebase.database.*

class SensorlistActivity : AppCompatActivity() {

    private val address : String = "https://awp-system-apps-default-rtdb.asia-southeast1.firebasedatabase.app/"
    private val rootDB : String = "DataSensor"

    private lateinit var databaseReference: DatabaseReference;
    private lateinit var dataRecyclerView: RecyclerView;
    private lateinit var dataArrayList: ArrayList<ListSensor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensorlist)


        dataRecyclerView = findViewById(R.id.sensorList);
        dataRecyclerView.layoutManager = LinearLayoutManager(this)
        dataRecyclerView.setHasFixedSize(true)

        dataArrayList = arrayListOf<ListSensor>()
        getDataSensor()

    }

    override fun onBackPressed() {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
        finish()
    }

    private fun getDataSensor() {
        databaseReference = FirebaseDatabase.getInstance(address).getReference(rootDB)

        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()){
                    for (dataSnapshot in snapshot.children){
                        val data = dataSnapshot.getValue(ListSensor::class.java)

                        dataArrayList.add(data!!)
                    }

                    //dataRecyclerView.adapter = MyAdapter(dataArrayList)

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}