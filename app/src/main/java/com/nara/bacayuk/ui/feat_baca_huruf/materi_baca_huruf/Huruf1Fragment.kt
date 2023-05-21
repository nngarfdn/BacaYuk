package com.nara.bacayuk.ui.feat_baca_huruf.materi_baca_huruf

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nara.bacayuk.data.model.Abjad
import com.nara.bacayuk.databinding.FragmentHuruf1Binding

private const val ARG_PARAM1 = "param1"

class Huruf1Fragment : Fragment() {
    private var _binding: FragmentHuruf1Binding? = null
    val binding get() = _binding!!
    private var param1: String? = null
    private lateinit var listener: (CharSequence) -> Unit
    private var abjad: Abjad? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHuruf1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        abjad = MateriBacaHurufActivity.dataAbjad
        when (param1) {
            "0" -> {
                binding.materi.apply {
                    txtAbjad.text = abjad?.abjadNonKapital
                    txtDesc.text = "Ini huruf kecil"

                }

            }
            "1" -> {
                binding.materi.apply {
                    txtDesc.text = "Ini huruf kapital/huruf besar"
                    txtAbjad.text = abjad?.abjadKapital
                }
            }
            "2" -> {

                binding.materi.apply {
                    txtDesc.text = "Ini perbedaan huruf besar dan huruf kecil"
                    txtAbjad.text =
                        "${abjad?.abjadNonKapital} ${abjad?.abjadKapital}"
                }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, listener: (CharSequence) -> Unit) =
            Huruf1Fragment().apply {
                this.listener = listener
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                }
            }
    }
}