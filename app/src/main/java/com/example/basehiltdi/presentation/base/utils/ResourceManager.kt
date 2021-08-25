package com.example.basehiltdi.presentation.base.utils

import android.app.KeyguardManager
import android.content.Context
import android.content.res.Resources
import android.widget.Toast
import androidx.annotation.DimenRes
import androidx.annotation.StringRes
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.*
import javax.inject.Inject

class ResourceManager @Inject constructor(
    @ApplicationContext val context: Context
    ) {

    val resources: Resources = context.resources

    fun getLanguage(): String = if (Locale.getDefault().language.equals("en", ignoreCase = true)) {
        "en"
    } else {
        "es"
    }

    fun getString(@StringRes resourceId: Int, params: Any? = null) = resources.getString(
        resourceId,
        params
    )

    fun getDrawable(resource: Int) = context.getResourceDrawable(resource)

    fun getDimensionPixelSize(@DimenRes res: Int) = resources.getDimensionPixelSize(res)

    fun getDimensionPixelOffset(@DimenRes res: Int) = resources.getDimensionPixelOffset(res)

    fun getKeyguardManager() = context.getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager?

    fun generateToast(string: String) {
        Toast.makeText(context, string, Toast.LENGTH_LONG).show()
    }
}
