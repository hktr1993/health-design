package code.challenge.healthdesign

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import code.challenge.healthdesign.databinding.FragmentStepOneBinding
import code.challenge.healthdesign.databinding.FragmentStepThreeBinding
import code.challenge.healthdesign.databinding.FragmentStepTwoBinding

class StepThreeFragment : Fragment() {

    private var _binding: FragmentStepThreeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStepThreeBinding.inflate(inflater, container, false)
        val view = binding.root

        val preferences = activity?.getPreferences(Context.MODE_PRIVATE)

        binding.button2.setOnClickListener {
            if (binding.femaleButton.isChecked){
                preferences?.edit()?.putString("gender", "female")?.apply()
            }

            if (binding.maleButton.isChecked){
                preferences?.edit()?.putString("gender", "male")?.apply()
            }

            childFragmentManager.beginTransaction()
                .replace(R.id.fragmentLayout, DashboardFragment())
                .commit()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}