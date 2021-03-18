package code.challenge.healthdesign

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import code.challenge.healthdesign.databinding.FragmentDashboardBinding
import code.challenge.healthdesign.databinding.FragmentOnboardOneBinding
import code.challenge.healthdesign.databinding.FragmentOnboardingBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.gridItems.layoutManager = GridLayoutManager(activity, 3)

        val items = arrayListOf<Array<Int>>()
        items.add(arrayOf(R.drawable.home_1, R.string.home))
        items.add(arrayOf(R.drawable.weight_scale, R.string.weight))
        items.add(arrayOf(R.drawable.list_1, R.string.training_plan))
        items.add(arrayOf(R.drawable.chart_bars, R.string.training_stats))
        items.add(arrayOf(R.drawable.cutlery_1, R.string.meal_plan))
        items.add(arrayOf(R.drawable.calendar_grid_1, R.string.schedule))
        items.add(arrayOf(R.drawable.athletics, R.string.running))
        items.add(arrayOf(R.drawable.stretching, R.string.exercises))
        items.add(arrayOf(R.drawable.bulb_1, R.string.tips))
        items.add(arrayOf(R.drawable.gear, R.string.settings))
        items.add(arrayOf(R.drawable.alert_que, R.string.support))

        binding.gridItems.adapter = DashAdapter(items)
        return view
    }

    class DashAdapter(private var items: ArrayList<Array<Int>>) : RecyclerView.Adapter<DashAdapter.ViewHolder>() {

        override fun getItemCount(): Int {
            return items.size
        }
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_dashboard, parent, false))
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            val item = items[position]

            holder.icon.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context, item[0]))
            holder.label.text = holder.itemView.context.resources.getString(item[1])
        }

        class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
            var icon: ImageView =itemView!!.findViewById(R.id.img)
            var label: TextView = itemView!!.findViewById(R.id.itemLabel)
        }
    }
}