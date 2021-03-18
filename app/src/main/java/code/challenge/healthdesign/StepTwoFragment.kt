package code.challenge.healthdesign

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import code.challenge.healthdesign.databinding.FragmentStepOneBinding
import code.challenge.healthdesign.databinding.FragmentStepTwoBinding

class StepTwoFragment : Fragment() {

    private var _binding: FragmentStepTwoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStepTwoBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.checkBox.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                binding.checkBox2.isChecked = false
                binding.checkBox3.isChecked = false
            }
        }

        binding.checkBox2.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                binding.checkBox2.isChecked = false
                binding.checkBox.isChecked = false
            }
        }

        binding.checkBox3.setOnCheckedChangeListener { compoundButton, b ->
            if (b){
                binding.checkBox2.isChecked = false
                binding.checkBox.isChecked = false
            }
        }

        val preferences = activity?.getPreferences(Context.MODE_PRIVATE)

        binding.button2.setOnClickListener {
            if (binding.checkBox.isChecked){
                preferences?.edit()?.putString("level", "beginner")?.apply()
            }
            if (binding.checkBox2.isChecked){
                preferences?.edit()?.putString("level", "intermediate")?.apply()
            }
            if (binding.checkBox3.isChecked){
                preferences?.edit()?.putString("level", "advanced")?.apply()
            }
            childFragmentManager.beginTransaction()
                .replace(R.id.fragmentLayout, StepThreeFragment())
                .commit()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}