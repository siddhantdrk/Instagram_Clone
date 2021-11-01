package com.app.instagramclone.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.PopupWindow
import androidx.fragment.app.Fragment
import com.app.instagramclone.R
import com.app.instagramclone.adapter.ProfileVpAdapter
import com.app.instagramclone.ui.EditProfileActivity
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_profile.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfileFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfileFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_profile, container, false)
        v.profileVp.adapter = ProfileVpAdapter(this)
        TabLayoutMediator(v.profilePageTbl, v.profileVp) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = resources.getText(R.string.Home)
                }
                1 -> {
                    tab.text = resources.getText(R.string.video)
                }
                2 -> {
                    tab.text = resources.getText(R.string.pics)
                }
            }
        }.attach()

        v.editIv.setOnClickListener {
            startActivity(Intent(context, EditProfileActivity::class.java))
        }

        v.settingsIv.setOnClickListener {
            val settingsPopUp = showAlertFilter(this.requireContext())
            settingsPopUp.isOutsideTouchable = true
            if (!settingsPopUp.isShowing) {
                settingsPopUp.showAsDropDown(v.settingsIv, 0, 48, Gravity.END)
                dimBehind(settingsPopUp)
            }
        }


        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfileFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun showAlertFilter(context: Context): PopupWindow {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.settings_pop_up, null)
        return PopupWindow(view, 640, ViewGroup.LayoutParams.WRAP_CONTENT)
    }


    private fun dimBehind(popupWindow: PopupWindow) {
        val container = popupWindow.contentView.rootView
        val context = popupWindow.contentView.context
        val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val p = container.layoutParams as WindowManager.LayoutParams
        p.flags = p.flags or WindowManager.LayoutParams.FLAG_DIM_BEHIND
        p.dimAmount = 0.9f
        wm.updateViewLayout(container, p)
    }
}