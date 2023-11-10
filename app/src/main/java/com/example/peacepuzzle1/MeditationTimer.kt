package com.example.peacepuzzle1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.peacepuzzle1.databinding.ActivityExerciseTimerBinding
import com.example.peacepuzzle1.databinding.ActivityMeditationTimerBinding
import java.util.Date
import java.util.Timer
import java.util.TimerTask

class MeditationTimer : AppCompatActivity() {

    lateinit var binding: ActivityMeditationTimerBinding
    lateinit var dataHelper: DataHelper

    private val timer = Timer()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meditation_timer)
        binding = ActivityMeditationTimerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        dataHelper = DataHelper(applicationContext)

        binding.startButton.setOnClickListener{startStopAction()}
        binding.resetButton.setOnClickListener { resetAction() }

        if(dataHelper.timerCounting())
        {
            startTimer()
        }
        else
        {
            stopTimer()
            if(dataHelper.starTime() != null && dataHelper.stopTime() != null)
            {
                val time = Date().time - calcRestartTime().time
                binding.timeTextView.text= timeStringFromLong(time)
            }
        }
        timer.scheduleAtFixedRate(TimeTask(),0,500)
    }

    private inner class TimeTask: TimerTask()
    {
        override fun run()
        {
            if(dataHelper.timerCounting())
            {
                val time = Date().time - dataHelper.starTime()!!.time
                binding.timeTextView.text = timeStringFromLong(time)
            }
        }
    }

    private fun resetAction()
    {
        dataHelper.setStopTime(null)
        dataHelper.setStartTime(null)
        stopTimer()
        binding.timeTextView.text = timeStringFromLong(0)
    }

    private fun stopTimer()
    {
        dataHelper.setTimerCounting(false)
        binding.startButton.text = getString(R.string.start)
    }

    private fun startTimer()
    {
        dataHelper.setTimerCounting(true)
        binding.startButton.text = getString(R.string.stop)
    }

    private fun startStopAction()
    {
        if(dataHelper.timerCounting()){
            dataHelper.setStopTime(Date())
            stopTimer()
        }
        else
        {
            if(dataHelper.stopTime() !=null)
            {
                dataHelper.setStartTime(calcRestartTime())
                dataHelper.setStopTime(null)
            }
            else
            {
                dataHelper.setStartTime(Date())
            }
            startTimer()
        }
    }

    private fun calcRestartTime(): Date
    {
        val diff = dataHelper.starTime()!!.time - dataHelper.stopTime()!!.time
        return Date(System.currentTimeMillis() + diff)
    }
    private fun timeStringFromLong(ms: Long): String
    {
        val seconds = (ms/1000) % 60
        val minutes = ((ms/1000*60)%60)
        val hours = (ms/(1000*60*60)%24)
        return makeTimeString(hours, minutes, seconds)
    }
    private fun makeTimeString(hours: Long, minutes: Long, seconds: Long): String {
        return String.format("%02d:%02d:%02d",hours, minutes, seconds)
    }

}