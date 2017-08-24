package com.example.android.courtcounter.viewmodel

import android.arch.lifecycle.ViewModel
import android.view.View
import com.example.android.courtcounter.model.Score

/**
 * Created by mangob on 2017. 8. 24..
 */
class ScoreViewModel : ViewModel() {

    var score = Score()

    fun getScore(at: Char) = if(at == 'A') score.scoreTeamA else score.scoreTeamB

    fun addPoint(point: Int, at: Char) {
        when(at) {
            'A' -> score.scoreTeamA += point
            'B' -> score.scoreTeamB += point
        }
    }

    fun resetScore() {
        score.scoreTeamA = 0
        score.scoreTeamB = 0
    }

}

