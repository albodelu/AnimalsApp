package com.alorma.animals.domain.model

sealed class FormField {
    data class IdValue(val id: String, val name: String): FormField()
    data class Selector(val id: String, val values: List<FormField.IdValue>): FormField()
}