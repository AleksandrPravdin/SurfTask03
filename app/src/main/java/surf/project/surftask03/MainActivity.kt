package surf.project.surftask03

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import surf.project.surftask03.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var name=""
    var lastName=""

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.regButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(binding.regButton.context, InputFirstName::class.java)
            startActivity(intent)
        })

        intent.extras?.let { screenData ->
            name = screenData.getString(FIRST_NAME_KEY) ?: name
            lastName = screenData.getString(LAST_NAME_KEY) ?: lastName
        }
        if(name!=""&&lastName!=""){
            Toast.makeText(binding.regButton.context,"Добро пожаловать, "+name+" "+lastName,Toast.LENGTH_SHORT).show()
        }
    }
}