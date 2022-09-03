package com.rootdevs.myapplication.models

class CallLog() {

    private var number:String = ""
    private var date:String = ""
    private var startTime:String = ""
    private var endTime:String = ""

    private var isIncoming:Boolean = true

    public fun CallLog(){

    }

    fun setNumber(number:String){
        this.number = number
    }

    fun setDate(date:String){
        this.date = date
    }

    fun setStartTime(startTime:String){
        this.startTime = startTime
    }

    fun setEndTime(endTime:String){
        this.endTime = endTime
    }

    fun setIsIncoming(isIncoming:Boolean){
        this.isIncoming = isIncoming
    }


}