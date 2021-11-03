package com.example.basehiltdi.ui.presentation.utils.extensions


import com.example.basehiltdi.ui.presentation.data.models.Model
import com.google.gson.Gson


fun <M> List<Any>?.asNewArrayModel(clazz: Class<Array<M>>): List<M> {
    return this?.let {
        val gson = Gson()
        val json = gson.toJson(this)
        gson.fromJson(json, clazz).toList()
    } ?: emptyList()
}

fun <M : Model> Model?.asNewModel(clazz: Class<M>): M {
    return if (this != null) {
        serializeToMap().toDataClass(clazz)
    } else {
        clazz.newInstance()
    }
}

private fun Model.serializeToMap(): Map<String, Any> {
    return convertMap()
}

fun <M : Model> Map<String, Any>.toDataClass(clazz: Class<M>): M {
    return convert(clazz)
}

fun <M : Model> List<Map<String, Any>>.toListDataClass(clazz: Class<M>): List<M> {
    val list = mutableListOf<M>()
    map { list.add(it.toDataClass(clazz)) }
    return list
}

private fun <M, NM : Model> M.convert(clazz: Class<NM>): NM {
    val gson = Gson()
    val json = gson.toJson(this)
    return gson.fromJson(json, clazz)
}

private inline fun <M, reified NM> M.convertMap(): NM {
    val gson = Gson()
    val json = gson.toJson(this)
    return gson.fromJson(json, NM::class.java)
}
