package code.challenge.healthdesign

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import code.challenge.healthdesign.databinding.FragmentStepOneBinding

class StepOneFragment : Fragment() {

    private var _binding: FragmentStepOneBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStepOneBinding.inflate(inflater, container, false)
        val view = binding.root

        val fragmentLayout = requireActivity().findViewById<FrameLayout>(R.id.fragmentLayout)

        binding.button2.setOnClickListener {
            childFragmentManager.beginTransaction()
                .replace(fragmentLayout.id, StepTwoFragment())
                .commit()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}