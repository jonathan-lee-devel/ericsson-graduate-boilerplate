package com.ericsson.authlib.model.factory

import com.ericsson.authlib.model.ApplicationUser
import org.springframework.security.core.authority.SimpleGrantedAuthority

class ApplicationUserFactory private constructor() {

    companion object {

        private const val DEFAULT_USER_ID = "-1"
        private const val DEFAULT_IS_ENABLED = false
        private const val DEFAULT_IS_ACCOUNT_NON_EXPIRED = false
        private const val DEFAULT_IS_CREDENTIALS_NON_EXPIRED = false
        private const val DEFAULT_IS_ACCOUNT_NON_LOCKED = false
        private val DEFAULT_GRANTED_AUTHORITIES = listOf(SimpleGrantedAuthority("USER"))
        private val DEFAULT_REGISTRATION_VERIFICATION_TOKEN =
            RegistrationVerificationTokenFactory.generateDefaultRegistrationVerificationToken()
        private val DEFAULT_PASSWORD_RESET_VERIFICATION_TOKEN =
            PasswordResetVerificationTokenFactory.generateExpiredPasswordResetVerificationToken()

        fun generateDefaultApplicationUser(
            email: String,
            firstName: String,
            lastName: String,
            password: String
        ) = ApplicationUser(
            id = DEFAULT_USER_ID,
            email = email,
            firstName = firstName,
            lastName = lastName,
            passwordHash = password,
            isEnabled = DEFAULT_IS_ENABLED,
            isAccountNonExpired = DEFAULT_IS_ACCOUNT_NON_EXPIRED,
            isCredentialsNonExpired = DEFAULT_IS_CREDENTIALS_NON_EXPIRED,
            isAccountNonLocked = DEFAULT_IS_ACCOUNT_NON_LOCKED,
            grantedAuthorities = DEFAULT_GRANTED_AUTHORITIES,
            registrationVerificationToken = DEFAULT_REGISTRATION_VERIFICATION_TOKEN,
            passwordResetVerificationToken = DEFAULT_PASSWORD_RESET_VERIFICATION_TOKEN
        )
    }
}
