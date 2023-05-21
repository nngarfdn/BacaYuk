package com.nara.bacayuk.ui.feat_baca_huruf.quiz_baca_huruf

import android.annotation.SuppressLint
import android.content.ClipData
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.nara.bacayuk.R
import com.nara.bacayuk.data.model.Abjad
import com.nara.bacayuk.data.model.getTwoRandomAbjadKapital
import com.nara.bacayuk.data.model.getTwoRandomAbjadNonKapital
import com.nara.bacayuk.databinding.FragmentQuizBinding
import com.nara.bacayuk.ui.feat_baca_huruf.materi_baca_huruf.MateriBacaHurufActivity

private const val ARG_PARAM1 = "param1"

class QuizFragment : Fragment() {
    private var param1: String? = null
    private var _binding: FragmentQuizBinding? = null
    private val binding get() = _binding!!
    private lateinit var listener: (CharSequence) -> Unit
    private var abjad: Abjad? = null

    private lateinit var wrongAnswerNonKapital: List<String>
    private var correctAnswerNonKapital: List<String>  = listOf()
    private var wrongAndCorrectAnswerNonKapital : List<String>  = listOf()

    private lateinit var wrongAnswerKapital: List<String>
    private var correctAnswerKapital: List<String>  = listOf()
    private var wrongAndCorrectAnswerKapital : List<String>  = listOf()

    private var isKapital: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    fun mergeAndShuffle(list1: List<String>, list2: List<String>): List<String> {
        val mergedList = list1 + list2
        return mergedList.shuffled()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

//        Toast.makeText(context, "Correct answer: $correctAnswer", Toast.LENGTH_SHORT).show()

        _binding = FragmentQuizBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.quiz.apply {

            abjad = MateriBacaHurufActivity.dataAbjad
            wrongAnswerNonKapital = getTwoRandomAbjadNonKapital(abjad?.abjadNonKapital ?: "-")
            wrongAnswerKapital = getTwoRandomAbjadKapital(abjad?.abjadKapital ?: "-")
            correctAnswerNonKapital = listOf<String>(abjad?.abjadNonKapital ?: "-")
            wrongAndCorrectAnswerNonKapital = mergeAndShuffle(wrongAnswerNonKapital, correctAnswerNonKapital)

            correctAnswerKapital = listOf<String>(abjad?.abjadKapital ?: "-")
            wrongAndCorrectAnswerKapital = mergeAndShuffle(wrongAnswerKapital, correctAnswerKapital)



            txtAbjad.setOnTouchListener(ChoiceTouchListener())

            txtOpt1.setOnDragListener(ChoiceDragListener())
            txtOpt2.setOnDragListener(ChoiceDragListener())
            txtOpt3.setOnDragListener(ChoiceDragListener())
            when (param1) {
                "0" -> {
                    reset(false)
                    txtAbjad.text = abjad?.abjadNonKapital
                    isKapital = false
                }
                "1" -> {
                    isKapital = true

                    reset(true)
                    txtAbjad.text = abjad?.abjadKapital

                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, listener: (CharSequence) -> Unit) =
            QuizFragment().apply {
                this.listener = listener
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }

    private class ChoiceTouchListener : View.OnTouchListener {
        @SuppressLint("NewApi")
        override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
            return if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                /*
                 * Drag details: we only need default behavior
                 * - clip data could be set to pass data as part of drag
                 * - shadow can be tailored
                 */
                //change the text color to teal 200
                val tv = view as TextView
                tv.setTextColor(view.context.getColor(R.color.teal_600))
                //change size of text only dragged
//                tv.textSize = 200f
                val data = ClipData.newPlainText("", "")
                val shadowBuilder = View.DragShadowBuilder(view)
                //start dragging the item touched
                view.startDrag(data, shadowBuilder, view, 0)
                true
            } else {
                false
            }
        }
    }

    fun reset(isKapital: Boolean) {
        binding.quiz.apply {

            Log.d("cekdata", "correctAnswerKapital: ${wrongAndCorrectAnswerKapital[2]}")
            txtAbjad.visibility = View.VISIBLE

            txtOpt1.text = if (isKapital) wrongAndCorrectAnswerKapital[0] else wrongAndCorrectAnswerNonKapital[0]
            txtOpt2.text = if (isKapital) wrongAndCorrectAnswerKapital[1] else wrongAndCorrectAnswerNonKapital[1]
            txtOpt3.text = if (isKapital) wrongAndCorrectAnswerKapital[2] else wrongAndCorrectAnswerNonKapital[2]
            txtOpt1.setTag(null)
            txtOpt2.setTag(null)
            txtOpt3.setTag(null)
            txtOpt1.setTypeface(Typeface.DEFAULT)
            txtOpt2.setTypeface(Typeface.DEFAULT)
            txtOpt3.setTypeface(Typeface.DEFAULT)
            txtOpt1.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.neutral_300
                )
            )

            txtOpt2.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.neutral_300
                )
            )
            txtOpt3.setTextColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.neutral_300
                )
            )
            txtOpt1.setOnDragListener(ChoiceDragListener())
            txtOpt2.setOnDragListener(ChoiceDragListener())
            txtOpt3.setOnDragListener(ChoiceDragListener())
        }
    }

    inner class ChoiceDragListener : View.OnDragListener {
        override fun onDrag(v: View, event: DragEvent): Boolean {
            when (event.action) {
                DragEvent.ACTION_DRAG_STARTED -> {
                    //change the text color to teal200

                }
                DragEvent.ACTION_DRAG_ENTERED -> {

                }
                DragEvent.ACTION_DRAG_EXITED -> {

                }
                DragEvent.ACTION_DROP -> {


                    //handle the dragged view being dropped over a drop view
                    val view = event.localState as View
                    //view dragged item is being dropped on
                    val dropTarget = v as TextView
                    //resize when being dragged
                    //view being dragged and dropped
                    val dropped = view as TextView
                    //checking whether first character of dropTarget equals first character of dropped
                    if (dropTarget.text.toString()[0] == dropped.text.toString()[0]) {
                        //stop displaying the view where it was before it was dragged
                        view.setVisibility(View.INVISIBLE)
                        //update the text in the target view to reflect the data being dropped
                        //todo : change text color
                        dropTarget.text = dropped.text
                        dropTarget.setTextColor(resources.getColor(R.color.teal_600))
                        //add animation
//                        val animation = android.view.animation.AnimationUtils.loadAnimation(
//                            applicationContext,
//                            R.anim.scale
//                        )
//                        dropTarget.startAnimation(animation)

//                        dropTarget.text = dropTarget.text.toString() + dropped.text.toString()
                        //make it bold to highlight the fact that an item has been dropped
                        dropTarget.setTypeface(Typeface.DEFAULT_BOLD)
                        //if an item has already been dropped here, there will be a tag
                        val tag = dropTarget.tag
                        //if there is already an item here, set it back visible in its original place
                        if (tag != null) {
                            //the tag is the view id already dropped here
                            val existingID = tag as Int
                            //set the original view visible again

                            binding.root.findViewById<View>(existingID).setVisibility(View.VISIBLE)
//                            findViewById<View>(existingID).setVisibility(View.VISIBLE)
                        }
                        //set the tag in the target view being dropped on - to the ID of the view being dropped
                        dropTarget.tag = dropped.id
                        //remove setOnDragListener by setting OnDragListener to null, so that no further drag & dropping on this TextView can be done
                        dropTarget.setOnDragListener(null)
                        //show toast
                        Toast.makeText(context, "BENAR!", Toast.LENGTH_SHORT).show()
                        reset(isKapital)
                    } else {
                        Toast.makeText(v.context, "SALAH!", Toast.LENGTH_SHORT).show()
                        reset(isKapital)
                    //displays message if first character of dropTarget is not equal to first character of dropped
                    }



                }
                DragEvent.ACTION_DRAG_ENDED -> {}
                else -> {}
            }
            return true
        }
    }
}