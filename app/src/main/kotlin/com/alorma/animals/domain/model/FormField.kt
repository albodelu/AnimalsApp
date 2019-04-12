package com.alorma.animals.domain.model

sealed class FormField {
    data class IdValue(val id: String, val name: String): FormField()
}