package com.ericsson.authlib.model

import org.springframework.data.mongodb.core.mapping.Document
import java.time.ZonedDateTime

@Document(collection = "password_reset_verification_tokens")
data class PasswordResetVerificationToken(
    override val id: String,
    override val tokenValue: String,
    override val expiryDateTime: ZonedDateTime
) : VerificationToken(id, tokenValue, expiryDateTime)
