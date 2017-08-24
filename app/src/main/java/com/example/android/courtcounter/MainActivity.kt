/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.courtcounter

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import com.example.android.courtcounter.viewmodel.ScoreViewModel
import kotlinx.android.synthetic.main.activity_main.*

/**
 * This activity keeps track of the basketball score for 2 teams.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ScoreViewModel::class.java)
        displayForTeamA(viewModel.getScore('A'))
        displayForTeamB(viewModel.getScore('B'))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    /**
     * Increase the score for Team A by 1 point.
     */
    fun addOneForTeamA(v: View) {
        viewModel.addPoint(1, 'A')
        displayForTeamA(viewModel.getScore('A'))
    }

    /**
     * Increase the score for Team A by 2 points.
     */
    fun addTwoForTeamA(v: View) {
        viewModel.addPoint(2, 'A')
        displayForTeamA(viewModel.getScore('A'))
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    fun addThreeForTeamA(v: View) {
        viewModel.addPoint(3, 'A')
        displayForTeamA(viewModel.getScore('A'))
    }

    /**
     * Increase the score for Team B by 1 point.
     */
    fun addOneForTeamB(v: View) {
        viewModel.addPoint(1, 'B')
        displayForTeamB(viewModel.getScore('B'))
    }

    /**
     * Increase the score for Team B by 2 points.
     */
    fun addTwoForTeamB(v: View) {
        viewModel.addPoint(2, 'B')
        displayForTeamB(viewModel.getScore('B'))
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    fun addThreeForTeamB(v: View) {
        viewModel.addPoint(3, 'B')
        displayForTeamB(viewModel.getScore('B'))
    }

    /**
     * Resets the score for both teams back to 0.
     */
    fun resetScore(v: View) {
        viewModel.resetScore()
        displayForTeamA(viewModel.getScore('A'))
        displayForTeamB(viewModel.getScore('B'))
    }

    /**
     * Displays the given score for Team A.
     */
    fun displayForTeamA(score: Int) {
        text_team_a_score.text = score.toString()
    }

    /**
     * Displays the given score for Team B.
     */
    fun displayForTeamB(score: Int) {
        text_team_b_score.text = score.toString()
    }
}
