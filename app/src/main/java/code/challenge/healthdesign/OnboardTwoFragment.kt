package code.challenge.healthdesign

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import code.challenge.healthdesign.databinding.FragmentOnboardThreeBinding
import code.challenge.healthdesign.databinding.FragmentOnboardTwoBinding

class OnboardTwoFragment : Fragment() {

    private var _binding: FragmentOnboardTwoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOnboardTwoBinding.inflate(layoutInflater, container, false)
        val view = binding.root

        binding.button.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(R.id.fragmentLayout, StepOneFragment())
                .commit()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}