package com.example.ball

import android.R.attr.x
import android.R.attr.y
import android.content.Context
import android.content.pm.ActivityInfo
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.OrientationEventListener
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), SensorEventListener {
    private lateinit var sensorManager: SensorManager
    private var mLight : Sensor? = null
    var mOrientationListener : OrientationEventListener? = null

   // lateinit var myView: MyView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       // myView = MyView(this, null)
       // setContentView(myView)
        setContentView(R.layout.activity_main)

        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mLight = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)

        myView.setOnTouchListener{ v, e ->
            myView.setXY( e.x, e.y )
            myView.performClick()
            true
        }


        mOrientationListener = object : OrientationEventListener(this, SensorManager.SENSOR_DELAY_NORMAL)
        {
            override fun onOrientationChanged(orientation: Int)
            {
                setContentView(R.layout.activity_main)


            }
            }
        }
     //   mOrientationListener.enable()



    override fun onSensorChanged(p0: SensorEvent) {
            textView.text = p0.values[0].toString() + "," + p0.values[1] + "," + p0.values[2]


    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
        TODO("Not yet implemented")
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }

    override fun onResume() {
        super.onResume()
        mLight?.also { light ->
            sensorManager.registerListener(this, light, SensorManager.SENSOR_DELAY_NORMAL)
        }
    }

    private class MyView(context: Context?) : View(context)
}