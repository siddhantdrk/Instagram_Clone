package com.app.instagramclone.adapter

import android.content.Context
import android.view.*
import android.widget.PopupWindow
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.app.instagramclone.R
import com.app.instagramclone.ui.ReportBottomSheetFragment
import kotlinx.android.synthetic.main.more_pop_up_dialogue_layout.view.*
import kotlinx.android.synthetic.main.post_rv_item.view.*


class HomePostRvAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.post_rv_item, parent, false)
        return HomeTopRvAdapter.ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.postProfileCiv.setOnClickListener {
            Toast.makeText(holder.itemView.context, "more", Toast.LENGTH_SHORT).show()
            val morePopUp = showAlertFilter(holder.itemView.context)
            morePopUp.isOutsideTouchable = true
            if (!morePopUp.isShowing) {
                morePopUp.showAsDropDown(holder.itemView.moreIv, 0, 48, Gravity.END)
                dimBehind(morePopUp)
            }
            morePopUp.contentView.hideTv.setOnClickListener {
                morePopUp.let {
                    if (it.isShowing) {
                        it.dismiss()
                    }
                }
            }

            morePopUp.contentView.reportTv.setOnClickListener {
                ReportBottomSheetFragment().show(
                    (holder.itemView.context as AppCompatActivity?)!!.supportFragmentManager,
                    ReportBottomSheetFragment.TAG
                )
            }
        }
    }

    override fun getItemCount(): Int {
        return 10
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems() {
            val moreIv = itemView.moreIv
        }
    }

    private fun showAlertFilter(context: Context): PopupWindow {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view = inflater.inflate(R.layout.more_pop_up_dialogue_layout, null)
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