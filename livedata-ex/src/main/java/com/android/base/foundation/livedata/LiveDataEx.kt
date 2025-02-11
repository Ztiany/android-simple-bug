package com.android.base.foundation.livedata

import androidx.lifecycle.MutableLiveData

fun <T> MutableLiveData<T>.initWith(t: T): MutableLiveData<T> {
    this.postValue(t)
    return this
}

fun <T> MutableLiveData<T>.touchOff() {
    this.postValue(this.value)
}

fun <T> MutableLiveData<List<T>>.append(item: T) {
    val value = this.value
    if (value == null) {
        this.postValue(listOf(item))
    } else {
        val mutableList = value.toMutableList()
        mutableList.add(item)
        this.postValue(mutableList)
    }
}

fun <T> MutableLiveData<List<T>>.append(list: List<T>) {
    val value = this.value
    if (value == null) {
        this.postValue(list)
    } else {
        val mutableList = value.toMutableList()
        mutableList.addAll(list)
        this.postValue(mutableList)
    }
}