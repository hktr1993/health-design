package code.challenge.healthdesign

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import code.challenge.healthdesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val  preferences = getPreferences(Context.MODE_PRIVATE)

        if (preferences.contains("gender")){
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentLayout, DashboardFragment())
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentLayout, OnboardingFragment())
                .commit()
        }

        binding.progressButton.setOnClickListener {
            when(binding.progressButton.text){
                resources.getString(R.string.start) -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentLayout, StepOneFragment())
                        .addToBackStack(null)
                        .commit()
                    binding.progressButton.text = resources.getString(R.string.get_started)
                }
                resources.getString(R.string.get_started) -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentLayout, StepTwoFragment())
                        .addToBackStack(null)
                        .commit()
                    binding.progressButton.text = resources.getString(R.string.next)
                }
                resources.getString(R.string.next) -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentLayout, StepThreeFragment())
                        .addToBackStack(null)
                        .commit()
                    binding.progressButton.text = resources.getString(R.string.start_two)
                }
                resources.getString(R.string.start_two) -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentLayout, DashboardFragment())
                        .commit()
                    binding.progressButton.visibility = View.GONE
                }
            }
        }
    }
}