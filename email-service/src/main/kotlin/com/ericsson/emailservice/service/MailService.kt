package com.ericsson.emailservice.service

import com.ericsson.emailservice.dto.MailDto
import reactor.core.publisher.Mono

interface MailService {

    fun sendMail(mailDto: MailDto): Mono<MailSendStatus>

    enum class MailSendStatus {
        FAILURE,
        SENT
    }

}