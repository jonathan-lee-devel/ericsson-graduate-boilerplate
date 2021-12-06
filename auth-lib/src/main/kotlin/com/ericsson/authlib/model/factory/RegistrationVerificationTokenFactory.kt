package com.ericsson.authlib.model.factory

import com.ericsson.authlib.model.RegistrationVerificationToken
import java.time.ZonedDateTime
import java.util.*

class RegistrationVerificationTokenFactory private constructor() {

    companion object {

        private const val DEFAULT_TOKEN_ID = "-1"
        private const val DEFAULT_EXPIRY_TIME_MINUTES = 15L

        fun generateDefaultRegistrationVerificationToken(): RegistrationVerificationToken =
            RegistrationVerificationToken(
                id = DEFAULT_TOKEN_ID,
                tokenValue = UUID.randomUUID().toString(),
                expiryDateTime = ZonedDateTime.now().plusMinutes(DEFAULT_EXPIRY_TIME_MINUTES)
            )

    }

}
