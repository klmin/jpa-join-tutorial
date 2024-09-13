package com.jpajointutorial.member.projection;

public record MemberRecordProjection(
        Long memberId,
        String name,
        Long teamTeamId,
        String teamTeamName
) {

}

