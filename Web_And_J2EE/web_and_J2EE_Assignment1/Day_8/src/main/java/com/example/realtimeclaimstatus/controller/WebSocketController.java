package com.example.realtimeclaimstatus.controller;

import com.example.realtimeclaimstatus.model.Claim;
import com.example.realtimeclaimstatus.service.ClaimService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import reactor.core.publisher.Mono;

@Controller
public class WebSocketController {

    private final ClaimService claimService;
    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketController(ClaimService claimService, SimpMessagingTemplate messagingTemplate) {
        this.claimService = claimService;
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/claimStatus")
    @SendTo("/topic/claimStatus")
    public Mono<Claim> sendClaimStatusUpdate(Claim claim) {
        return claimService.updateClaimStatus(claim.getId(), HtmlUtils.htmlEscape(claim.getStatus()))
                .doOnNext(updatedClaim -> messagingTemplate.convertAndSend("/topic/claimStatus", updatedClaim));
    }
}
