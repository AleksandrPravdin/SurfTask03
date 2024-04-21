package surf.project.surftask03

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import surf.project.surftask03.databinding.InputFirstNameBinding
import surf.project.surftask03.databinding.InputLastNameBinding
class InputLastName : AppCompatActivity() {
    var name=""
    private lateinit var binding: InputLastNameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = InputLastNameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ilnBackButton.setOnClickListener(View.OnClickListener {
            finish()
        })
        binding.ilnNextButton.setOnClickListener(View.OnClickListener {
            intent.extras?.let { screenData ->
                 name = screenData.getString(FIRST_NAME_KEY) ?: name
            }
            val intent = Intent(binding.ilnNextButton.context, InputAge::class.java)
            val screenData = bundleOf(
                FIRST_NAME_KEY to name,
                LAST_NAME_KEY to binding.ilnEditText.text.toString(),
            )
            intent.putExtras(screenData)
            startActivity(intent)
        })
    }
}