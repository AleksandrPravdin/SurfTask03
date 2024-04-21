package surf.project.surftask03

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import surf.project.surftask03.databinding.ActivityMainBinding
import surf.project.surftask03.databinding.InputFirstNameBinding
class InputFirstName : AppCompatActivity() {
    private lateinit var binding: InputFirstNameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = InputFirstNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ifnBackButton.setOnClickListener(View.OnClickListener {
            finish()
        })

        binding.ifnNextButton.setOnClickListener(View.OnClickListener {
            val intent = Intent(binding.ifnNextButton.context, InputLastName::class.java)
            intent.putExtra(FIRST_NAME_KEY, binding.ifnEditText.text.toString())
            startActivity(intent)
        })
    }
}