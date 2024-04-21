package surf.project.surftask03

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import surf.project.surftask03.databinding.InputAgeBinding
import surf.project.surftask03.databinding.InputLastNameBinding

class InputAge : AppCompatActivity() {
    var name=""
    var lastName=""
    private lateinit var binding: InputAgeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = InputAgeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ianBackButton.setOnClickListener(View.OnClickListener {
            finish()
        })

        binding.ianNextButton.setOnClickListener(View.OnClickListener {
            intent.extras?.let { screenData ->
                name = screenData.getString(FIRST_NAME_KEY) ?: name
                lastName = screenData.getString(LAST_NAME_KEY) ?: lastName
            }
            val screenData = bundleOf(
                FIRST_NAME_KEY to name,
                LAST_NAME_KEY to lastName,
                AGE_KEY to binding.iaEditText.text.toString()
            )
            val intent = Intent(binding.iaEditText.context, MainActivity::class.java)
            intent.putExtras(screenData)
            startActivity(intent)
        })
    }
}