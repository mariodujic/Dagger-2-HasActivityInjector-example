package com.groundzero.legoproject.themes.ui

import androidx.lifecycle.ViewModel
import com.groundzero.legoproject.themes.data.ThemesRepository
import javax.inject.Inject

class ThemesViewModel @Inject constructor(repository: ThemesRepository) : ViewModel() {

    val themes = repository.themes
}