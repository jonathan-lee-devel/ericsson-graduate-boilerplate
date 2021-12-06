package com.ericsson.emailservice.dto

import com.ericsson.emailservice.service.MailService
import com.fasterxml.jackson.annotation.JsonProperty

data class MailResponseDto(
    @field:JsonProperty("mail_send_status") val mailSendStatus: MailService.MailSendStatus
)
