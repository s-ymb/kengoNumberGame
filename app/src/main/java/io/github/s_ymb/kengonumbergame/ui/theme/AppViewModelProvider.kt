package io.github.s_ymb.kengonumbergame.ui.theme

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import io.github.s_ymb.kengonumbergame.KengoNumberGameApplication
import io.github.s_ymb.kengonumbergame.ui.home.NumbergameViewModel
import io.github.s_ymb.kengonumbergame.ui.satisfiedGrid.SatisfiedGridDetailViewModel
import io.github.s_ymb.kengonumbergame.ui.satisfiedGrid.SatisfiedGridTblViewModel
import io.github.s_ymb.kengonumbergame.ui.savedGrid.SavedGridDetailViewModel
import io.github.s_ymb.kengonumbergame.ui.savedGrid.SavedTblViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        // Initializer for NumbergemeScreen
        initializer {
            NumbergameViewModel(
                  this.createSavedStateHandle(),
                KengoNumberGameApplication().container            )
        }


        // Initializer for SatisfiedGridEntryViewModel
 //       initializer {
 //           SatisfiedGridEntryViewModel(
 //               KengoNumberGameApplication().container.satisfiedGridTblRepository
 //           )
 //       }

        // Initializer for SatisfiedGridDetailsViewModel
        initializer {
            SatisfiedGridDetailViewModel(
                this.createSavedStateHandle(),
                KengoNumberGameApplication().container.satisfiedGridTblRepository
            )
        }

        // Initializer for SatisfiedGridTblViewModel
        initializer {
            SatisfiedGridTblViewModel(
                KengoNumberGameApplication().container.satisfiedGridTblRepository)
        }

        // Initializer for SavedGridDetailsViewModel
        initializer {
            SavedGridDetailViewModel(
                this.createSavedStateHandle(),
                KengoNumberGameApplication().container
            )
        }

        // Initializer for SavedGridTblViewModel
        initializer {
            SavedTblViewModel(
                KengoNumberGameApplication().container.savedTblRepository)
        }
    }
}

/**
 * Extension function to queries for  object and returns an instance of
 * .
 */
fun CreationExtras.KengoNumberGameApplication(): KengoNumberGameApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KengoNumberGameApplication)
