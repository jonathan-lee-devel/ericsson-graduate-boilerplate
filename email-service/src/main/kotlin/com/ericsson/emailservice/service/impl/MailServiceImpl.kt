package com.ericsson.emailservice.service.impl

import com.ericsson.emailservice.dto.MailDto
import com.ericsson.emailservice.service.MailService
import org.slf4j.LoggerFactory
import org.springframework.mail.MailException
import org.springframework.mail.MailSender
import org.springframework.mail.SimpleMailMessage
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class MailServiceImpl(private val mailSender: MailSender) : MailService {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    override fun sendMail(mailDto: MailDto): Mono<MailService.MailSendStatus> {
        val simpleMailMessage = SimpleMailMessage()
        simpleMailMessage.setTo(mailDto.addressTo)
        simpleMailMessage.setSubject(mailDto.subject)
        simpleMailMessage.setText(mailDto.text)

        var mailSendStatus = MailService.MailSendStatus.FAILURE

        try {
            this.mailSender.send(simpleMailMessage)
            mailSendStatus = MailService.MailSendStatus.SENT
            logger.info("E-mail sent with status: $mailSendStatus")
        } catch (ex: MailException) {
            logger.error(ex.message)
        }

        return Mono.just(mailSendStatus)
    }

}
