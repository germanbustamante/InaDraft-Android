package com.germandebustamante.inadraft.presentation.common.uitext

import android.content.Context
import androidx.annotation.StringRes

sealed class UiText {
    data class DynamicString(val value: String) : UiText()
    data class StringResource(
        @StringRes val id: Int,
        val args: Array<Any>? = null
    ) : UiText()

    fun asString(context: Context): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> context.getString(id, args)
        }
    }
}