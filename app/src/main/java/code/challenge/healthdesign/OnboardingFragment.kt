package code.challenge.healthdesign

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import code.challenge.healthdesign.databinding.FragmentOnboardingBinding

class OnboardingFragment : Fragment() {

    private var _binding: FragmentOnboardingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.onboarding.adapter = OnBoardSlideAdapter(activity as FragmentActivity)

        return view
    }

    inner class OnBoardSlideAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> {
                    OnboardOneFragment()
                }
                1 -> {
                    OnboardTwoFragment()
                }
                2 -> {
                    OnboardThreeFragment()
                }
                else -> OnboardOneFragment()
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}