package com.jordimundam.livedata

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.jordimundam.livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ContadorViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.espectadores.observe(this) { valor ->
            binding.Contador.text = valor.toString()
        }
        viewModel.estado.observe(this) { texto ->
            binding.Estado.text = texto
        }

        viewModel.complet.observe(this) { complet ->
            val color = if (complet) R.color.rojo else R.color.verde
            binding.Contador.setTextColor(ContextCompat.getColor(this, color))
        }

        binding.btnSumar.setOnClickListener { viewModel.sumar() }
        binding.btnRestar.setOnClickListener { viewModel.restar() }
        binding.btnReiniciar.setOnClickListener { viewModel.reiniciar() }
    }
}