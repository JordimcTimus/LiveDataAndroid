package com.jordimundam.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map

class ContadorViewModel {
    private val _espectadores = MutableLiveData(0)
    val espectadores: LiveData<Int>
        get() = _espectadores

    val complet: LiveData<Boolean>
        get() = _espectadores.map { it >= 10 }

    val estado: LiveData<String>
        get() = _espectadores.map { if (it >= 10) "Aforament complet!" else "Disponible" }

    fun sumar() {
        val actual = _espectadores.value ?: 0
        if (actual < 10) {
            _espectadores.value = actual + 1
        }
    }

    fun restar() {
        val actual = _espectadores.value ?: 0
        if (actual > 0) {
            _espectadores.value = actual - 1
        }
    }

    fun reiniciar() {
        _espectadores.value = 0
    }
}