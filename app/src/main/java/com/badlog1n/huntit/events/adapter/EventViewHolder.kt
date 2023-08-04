package com.badlog1n.huntit.events.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.badlog1n.huntit.databinding.ItemEventBinding
import com.badlog1n.huntit.domain.models.Match

class EventViewHolder(
    private val parent: ViewGroup,
    private val eventClick: (Match) -> Unit,
    private val binding: ItemEventBinding =
        ItemEventBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ),
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(match: Match) {
        with(binding) {
            val homeTeam = match.teams.home
            val awayTeam = match.teams.away
            val scores = match.scores
            tvTeam1.text = homeTeam.name
            tvTeam2.text = awayTeam.name
            tvScore1.text = scores.home_score
            tvScore2.text = scores.away_score
            root.setOnClickListener {
                eventClick(match)
            }
        }
    }
}
