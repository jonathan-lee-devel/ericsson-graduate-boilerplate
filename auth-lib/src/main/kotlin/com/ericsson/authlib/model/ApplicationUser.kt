package com.ericsson.authlib.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.DBRef
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.security.core.GrantedAuthority

@Document(collection = "application_users")
data class ApplicationUser(
    @field:Id val id: String,
    @field:Indexed(unique = true) val email: String,
    val firstName: String,
    val lastName: String,
    val passwordHash: String,
    val isEnabled: Boolean,
    val isAccountNonExpired: Boolean,
    val isCredentialsNonExpired: Boolean,
    val isAccountNonLocked: Boolean,
    val grantedAuthorities: Collection<GrantedAuthority>,
    @field:DBRef val registrationVerificationToken: RegistrationVerificationToken,
    @field:DBRef val passwordResetVerificationToken: PasswordResetVerificationToken
)
