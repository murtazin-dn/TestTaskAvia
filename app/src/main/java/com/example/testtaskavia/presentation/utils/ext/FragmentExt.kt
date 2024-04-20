package com.example.testtaskavia.presentation.utils.ext

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.fragment.findNavController

fun <T> Fragment.registerResultObserver(key: String, action: (T) -> Unit) {
    val navController = findNavController();
    // After a configuration change or process death, the currentBackStackEntry
    // points to the dialog destination, so you must use getBackStackEntry()
    // with the specific ID of your destination to ensure we always
    // get the right NavBackStackEntry
    val navBackStackEntry = navController.currentBackStackEntry

    // Create our observer and add it to the NavBackStackEntry's lifecycle
    val observer = LifecycleEventObserver { _, event ->
        if (event == Lifecycle.Event.ON_RESUME){
            navBackStackEntry?.savedStateHandle?.get<T>(key)?.let{
                action.invoke(it)
                navBackStackEntry.savedStateHandle?.remove<T>(key)
            }
        }
    }
    navBackStackEntry?.lifecycle?.addObserver(observer)

    // As addObserver() does not automatically remove the observer, we
    // call removeObserver() manually when the view lifecycle is destroyed
    viewLifecycleOwner.lifecycle.addObserver(LifecycleEventObserver { _, event ->
        if (event == Lifecycle.Event.ON_DESTROY) {
            navBackStackEntry?.lifecycle?.removeObserver(observer)
        }
    })
}
fun <T> Fragment.getNavigationResult(key: String) =
    findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<T>(key)

fun <T> Fragment.setNavigationResult(result: T, key: String) {
    findNavController().previousBackStackEntry?.savedStateHandle?.set(key, result)
}