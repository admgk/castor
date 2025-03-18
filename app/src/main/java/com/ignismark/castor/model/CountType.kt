package com.ignismark.castor.model

sealed interface CountType {
    val name: String

    override fun toString(): String
}