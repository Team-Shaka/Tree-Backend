package org.example.tree.domain.invitation.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InvitationRequestDTO {

    @Getter
    public static class sendInvitation {
        private String senderId;
        private Long treeId;
        private String phoneNumber;
    }

    @Getter
    public static class inviteMember {
        private String senderId;
        private Long treeId;
        private String targetUserId;
    }

    @Getter
    public static class acceptInvitation {
        private Long invitationId;
        private Boolean isAccept;
    }

    @Getter
    public static class getInvitation {
        private Long invitationId;
    }

    @Getter
    public static class rejectInvitation {
        private Long invitationId;
        private Boolean isAccept;
    }
}
