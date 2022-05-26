package com.example.check_internet.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.check_internet.R
import com.example.check_internet.databinding.FragmentFirstBinding
import com.example.check_internet.internet_conection.CheckInternet

class FirstFragment : Fragment() {
    private lateinit var cld : CheckInternet
    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(LayoutInflater.from(context), container, false)
        checkInternet()
        return binding.root

}

    private fun checkInternet() {
        activity?.application?.let {
            cld = CheckInternet(it)
        }
        cld.observe(viewLifecycleOwner) {
            Toast.makeText(requireContext(), "$it", Toast.LENGTH_SHORT).show()
            if (it) {
                binding.internet.visibility = View.GONE
                binding.internet2.visibility = View.VISIBLE
            } else {
                binding.internet.visibility = View.VISIBLE
                binding.internet2.visibility = View.GONE
            }
        }
    }
}