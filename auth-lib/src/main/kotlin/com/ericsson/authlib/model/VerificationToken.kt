package com.ericsson.authlib.model

import org.springframework.data.annotation.Id
import java.time.ZonedDateTime

abstract class VerificationToken(
    @field:Id protected open val id: String,
    protected open val tokenValue: String,
    protected open val expiryDateTime: ZonedDateTime
)
