package android.patricia.modularpamiipatriciapreferences

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.patricia.modularpamiipatriciapreferences.databinding.ActivityMainBinding
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var cor = ""
    private lateinit var preferences: SharedPreferences

    companion object {
        const val NOME_ARQUIVO = "arquivo_prefs.xml"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(binding.root)

        binding.cor1.setOnClickListener {
            cor = "#673AB7"
            salvarCor(cor)
        }

        binding.cor2.setOnClickListener {
            cor = "#3F51B5"
            salvarCor(cor)
        }

        binding.cor3.setOnClickListener {
            cor = "#2196F3"
            salvarCor(cor)
        }

        binding.cor4.setOnClickListener {
            cor = "#00BCD4"
            salvarCor(cor)
        }

        binding.cor5.setOnClickListener {
            cor = "#009688"
            salvarCor(cor)
        }

    }

    override fun onResume() {
        super.onResume()

        var preferencias = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE)
        var cor = preferencias.getString("cor", "")

        if (cor!!.isNotBlank()) {
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        }
    }
    
    private fun salvarCor(cor: String) {
        binding.trocarCor.setOnClickListener {
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
            val preferences = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putString("cor", cor)
            editor.putString("nome", "Patricia")
            editor.putString("sobrenome", "Camargo")
            editor.putString("email", "plcamargo@gmail.com")
            editor.apply()

            snackbar(binding.root)

        }
    }

    private fun snackbar(view:View) {
        var snackbar =
            Snackbar.make(view, "Cor de fundo salva com sucesso!", Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("ok") {
        }

        snackbar.setActionTextColor(Color.BLUE)
        snackbar.setBackgroundTint(Color.LTGRAY)
        snackbar.setTextColor(Color.GREEN)
        snackbar.show()

    }

}