package com.groundzero.legoproject.themes.ui


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.groundzero.legoproject.databinding.FragmentThemesBinding
import com.groundzero.legoproject.di.helper.Injectable
import com.groundzero.legoproject.di.helper.ViewModelFactory
import com.groundzero.legoproject.di.helper.injectViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ThemesFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: ThemesViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentThemesBinding.inflate(inflater, container, false)
        viewModel = injectViewModel(viewModelFactory)
        viewModel.themes.observe(this, Observer { t -> println(t.data) })
        return binding.root
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}
