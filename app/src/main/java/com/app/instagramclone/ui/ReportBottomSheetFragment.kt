package com.app.instagramclone.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.instagramclone.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ReportBottomSheetFragment : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.report_bottom_sheet, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (view.parent as View).setBackgroundColor(Color.TRANSPARENT)
    }

    companion object {
        const val TAG = "ReportBottomSheet"
    }
}