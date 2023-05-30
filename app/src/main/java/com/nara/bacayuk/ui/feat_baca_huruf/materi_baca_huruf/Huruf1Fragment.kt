package com.nara.bacayuk.ui.feat_baca_huruf.materi_baca_huruf

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.nara.bacayuk.R
import com.nara.bacayuk.data.model.Abjad
import com.nara.bacayuk.data.model.ReportHuruf
import com.nara.bacayuk.data.model.Response
import com.nara.bacayuk.data.model.User
import com.nara.bacayuk.databinding.FragmentHuruf1Binding
import org.koin.androidx.viewmodel.ext.android.viewModel

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class Huruf1Fragment : Fragment() {
    private var _binding: FragmentHuruf1Binding? = null
    val binding get() = _binding!!
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var listener: (CharSequence) -> Unit
    private var abjad: Abjad? = null
    private val materiBacaHurufViewModel: MateriBacaHurufViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
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
        val user: User? = materiBacaHurufViewModel.getUserDataStore()
        user?.uuid?.let { materiBacaHurufViewModel.getUser(it) }

        abjad = MateriBacaHurufActivity.dataAbjad
        when (param1) {
            "0" -> {
                binding.materi.apply {
                    txtAbjad.text = abjad?.abjadNonKapital
                    txtDesc.text = getString(R.string.ini_huruf_kecil)
                    abjad?.reportHuruf?.materiHurufNonKapital = true
                    val reportHuruf = abjad?.reportHuruf
                    materiBacaHurufViewModel.updateReportHuruf(
                        user?.uuid ?: "-",
                        MateriBacaHurufActivity.student?.uuid ?: "-",
                        reportHuruf ?: ReportHuruf()
                    )
                }
            }
            "1" -> {
                binding.materi.apply {
                    txtDesc.text = getString(R.string.ini_huruf_kapital)
                    txtAbjad.text = abjad?.abjadKapital
                    abjad?.reportHuruf?.materiHurufKapital = true
                    val reportHuruf = abjad?.reportHuruf
                    materiBacaHurufViewModel.updateReportHuruf(
                        user?.uuid ?: "-",
                        MateriBacaHurufActivity.student?.uuid ?: "-",
                        reportHuruf ?: ReportHuruf()
                    )
                }
            }
            "2" -> {
                binding.materi.apply {
                    txtDesc.text = getString(R.string.ini_perbedaan_huruf)
                    "${abjad?.abjadNonKapital} ${abjad?.abjadKapital}".also { txtAbjad.text = it }
                    abjad?.reportHuruf?.materiPerbedaanHuruf = true
                    val reportHuruf = abjad?.reportHuruf
                    materiBacaHurufViewModel.updateReportHuruf(
                        user?.uuid ?: "-",
                        MateriBacaHurufActivity.student?.uuid ?: "-",
                        reportHuruf ?: ReportHuruf()
                    )
                }
            }
        }

        when (param2) {
            "0" -> {
                binding.materi.apply {
                    txtAbjad.text = "A a"
                    txtDesc.text = getString(R.string.ini_huruf_vokal)
                }
            }
            "1" -> {
                binding.materi.apply {
                    txtAbjad.text = "I i"
                    txtDesc.text = getString(R.string.ini_huruf_vokal)
                }
            }
            "2" -> {
                binding.materi.apply {
                    txtAbjad.text = "U u"
                    txtDesc.text = getString(R.string.ini_huruf_vokal)
                }
            }
            "3" -> {
                binding.materi.apply {
                    txtAbjad.text = "E e"
                    txtDesc.text = getString(R.string.ini_huruf_vokal)
                }
            }
            "4" -> {
                binding.materi.apply {
                    txtAbjad.text = "O o"
                    txtDesc.text = getString(R.string.ini_huruf_vokal)
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


        @JvmStatic
        fun newInstanceKata(param1: String, listener: (CharSequence) -> Unit) =
            Huruf1Fragment().apply {
                this.listener = listener
                arguments = Bundle().apply {
                    putString(ARG_PARAM2, param1)
                }
            }
    }
}