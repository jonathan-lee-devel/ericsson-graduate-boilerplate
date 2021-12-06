package com.ericsson.emailservice.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class MailDto(
    @field:JsonProperty("address_to") val addressTo: String,
    val subject: String,
    val text: String
)
