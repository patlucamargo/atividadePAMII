package android.patricia.modularpamiipatriciapreferences

import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.patricia.modularpamiipatriciapreferences.databinding.ActivityMainBinding
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private var cor = ""
    private lateinit var preferences: SharedPreferences

    companion object{
        const val NOME_ARQUIVO = "arquivo_prefs.xml"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(binding.root)

        binding.cor1.setOnClickListener{
            cor = "#673AB7"
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        }

        binding.cor2.setOnClickListener{
            cor = "#3F51B5"
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        }

        binding.cor3.setOnClickListener{
            cor = "#2196F3"
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        }

        binding.cor4.setOnClickListener{
            cor = "#00BCD4"
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        }

        binding.cor5.setOnClickListener{
            cor = "#009688"
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
        }

        binding.trocarCor.setOnClickListener {
            binding.layoutPrincipal.setBackgroundColor(Color.parseColor(cor))
            val preferences = getSharedPreferences(NOME_ARQUIVO, MODE_PRIVATE)
            val editor = preferences.edit()
            editor.putString("cor", cor)
            editor.putString("nome", "Patricia")
            editor.putString("sobrenome", "Camargo")
            editor.putString("email", "plcamargo@gmail.com")
            editor.apply()
        }

    }
    private fun salvarCor(cor:String) {

    }

}