package com.example.madlevel2task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val quizQuestions = QUIZ_QUESTIONS.toMutableList()
    private val questionAdapter = QuestionAdapter(quizQuestions)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        rvQuestions.adapter = questionAdapter
        rvQuestions.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvQuestions.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        ItemTouchHelper(TouchHandler()).attachToRecyclerView(rvQuestions)
    }

    // Possible swipe directions
    inner class TouchHandler: ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT.or(ItemTouchHelper.RIGHT)){

        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
            return false
        }

        // Checks the direction that is swiped towards with the ItemTouchHelper and returns it as an boolean, to check the answer
        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            checkAnswer(quizQuestions[viewHolder.adapterPosition], direction == ItemTouchHelper.RIGHT)
        }
    }

    private fun checkAnswer(questions: Question, b: Boolean) {

        // A XNOR gate, because it returns false by the false == false check which should be true
        if(b.xor(questions.correctAnswer).not()) {
            Snackbar.make(rvQuestions, getString(R.string.correct), Snackbar.LENGTH_SHORT).show()
        } else {
            Snackbar.make(rvQuestions, getString(R.string.incorrect), Snackbar.LENGTH_SHORT).show()
            // Returns all questions if you answered incorrectly
            questionAdapter.notifyDataSetChanged()
        }
    }

}