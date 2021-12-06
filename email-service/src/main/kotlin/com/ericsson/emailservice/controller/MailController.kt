package com.ericsson.emailservice.controller

import com.ericsson.emailservice.dto.MailDto
import com.ericsson.emailservice.dto.MailResponseDto
import com.ericsson.emailservice.service.MailService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping(MailController.MAIL_CONTROLLER_BASE_URI)
class MailController(private val mailService: MailService) {

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun postMail(@RequestBody mailDto: MailDto): Mono<ResponseEntity<MailResponseDto>> {
        return this.mailService
            .sendMail(mailDto)
            .map {
                val responseDto = MailResponseDto(it)
                when (it) {
                    MailService.MailSendStatus.SENT -> ResponseEntity.ok(responseDto)
                    else -> ResponseEntity.internalServerError().body(responseDto)
                }
            }
    }

    companion object {
        const val MAIL_CONTROLLER_BASE_URI = "/mail"
    }

}