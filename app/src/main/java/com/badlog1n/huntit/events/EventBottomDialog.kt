package com.badlog1n.huntit.events

import android.content.Context
import coil.load
import com.badlog1n.huntit.databinding.BottomDialogEventBinding
import com.badlog1n.huntit.domain.models.Match
import com.google.android.material.bottomsheet.BottomSheetDialog

class EventBottomDialog(
    context: Context,
    match: Match,
) : BottomSheetDialog(context) {
    private val binding = BottomDialogEventBinding.inflate(layoutInflater)

    init {
        with(binding) {
            setContentView(root)
            val homeTeam = match.teams.home
            val awayTeam = match.teams.away
            val time = match.time
            tvDate.text = time.date
            tvTime.text = time.time
            tvDuration.text = time.minute.toString()
            tvLeftClubCode.text = homeTeam.short_code
            tvRightClubCode.text = awayTeam.short_code
            tvLeftClubForm.text = homeTeam.form
            tvRightClubForm.text = awayTeam.form
            ivLeftClubImage.load(homeTeam.img)
            ivRightClubImage.load(awayTeam.img)
        }
    }
}