package com.example.quizztrialinstamedz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.example.quizztrialinstamedz.databinding.FragmentFragAboveFortyBinding


class FragAboveForty : Fragment() {
    lateinit var currenQuestion:QnsAboveForty
    lateinit var binding: FragmentFragAboveFortyBinding
    lateinit var answers:ArrayList<String>
    lateinit var selectedAnswer:String
    private var questionIndex = 0
    var score=0;
    val maxNUmberOfQuestion =6
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    var questions = arrayListOf<QnsAboveForty>(
        QnsAboveForty(
            "Do you have sudden flashes of light? ",
            arrayListOf("Yes", "Rarely", "Not at all")
        ),
        QnsAboveForty(
            "Do you experience sudden loss of vision in one eye? ",
            arrayListOf("Yes", "Rarely", "Not at all")
        ),
        QnsAboveForty(
            "Do you spot halos around light? ",
            arrayListOf("Yes", "Rarely", "Not at all")
        ),
        QnsAboveForty("Are you on a regular diet?", arrayListOf("Yes", "Rarely", "Not at all")),
        QnsAboveForty(
            "Do you have double visions?",
            arrayListOf("Yes", "Rarely", "Not at all")
        ),
        QnsAboveForty("Do you have watery eyes often?", arrayListOf("Yes", "Rarely", "Not at all"))

    )

    private fun checkAns(answer:String){
        if(answer.equals(currenQuestion.theAns[0])){
            score+=2
        }
        else if( answer.equals(currenQuestion.theAns[1])){
            score+=1
        }
        else
            score+=0

        questionIndex++

        if(questionIndex<maxNUmberOfQuestion){
            setQuestion()
            binding.invalidateAll()
        }
        else{
            getScore()
        }

    }
    private fun getScore(){
        if(score>=3){
            Toast.makeText(activity,"Won", Toast.LENGTH_SHORT).show()
        }
        else{
            if(score>=3){
                Toast.makeText(activity,"Lost", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setQuestion(){
        currenQuestion =questions[questionIndex]
        answers = ArrayList(currenQuestion.theAns)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_frag_above_forty,
            container,
            false
        )
       setQuestion()
        binding.aboveForty=this
        return binding.root
    }
    override fun onActivityCreated(savedInstanceState: Bundle?){
        super.onActivityCreated(savedInstanceState)
        binding.option1.setOnClickListener {
            checkAns(binding.option1.text.toString())
        }
        binding.option2.setOnClickListener {
            checkAns(binding.option2.text.toString())
        }
        binding.option3.setOnClickListener {
            checkAns(binding.option3.text.toString())
        }
    }

}