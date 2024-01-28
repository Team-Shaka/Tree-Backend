package org.example.tree.domain.invitation.converter;

import org.example.tree.domain.invitation.dto.InvitationResponseDTO;
import org.example.tree.domain.invitation.entity.Invitation;
import org.example.tree.domain.member.entity.Member;
import org.example.tree.domain.tree.entity.Tree;
import org.springframework.stereotype.Component;

@Component
public class InvitationConverter {
    public Invitation toInvitation (Member sender, Tree tree, String phone) {
        return Invitation.builder()
                .sender(sender)
                .tree(tree)
                .phone(phone)
                .build();
    }

    public InvitationResponseDTO.sendInvitation toInviteUser (Invitation savedInvitation, Boolean isNewUser) {
        return InvitationResponseDTO.sendInvitation.builder()
                .availableInvitation(savedInvitation.getSender().getInvitationCount())
                .isNewUser(isNewUser)
                .build();
    }
}