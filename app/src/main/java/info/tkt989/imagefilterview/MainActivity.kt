package info.tkt989.imagefilterview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saturation.setOnChangeListener {
            image.saturation = it * 2
        }
        contrast.setOnChangeListener {
            image.contrast = it * 2
        }
        brightness.setOnChangeListener {
            image.brightness = it * 2
        }
        warmth.setOnChangeListener {
            image.warmth = it * 5
        }
    }
}

fun SeekBar.setOnChangeListener(listener: ((Float) -> Unit)) {
    this.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
            listener(this@setOnChangeListener.progress / this@setOnChangeListener.max.toFloat())
        }

        override fun onStartTrackingTouch(p0: SeekBar?) {
        }

        override fun onStopTrackingTouch(p0: SeekBar?) {
        }
    })
}