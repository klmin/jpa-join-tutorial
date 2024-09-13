package com.jpajointutorial.member.repository;

import com.jpajointutorial.member.entity.Member;
import com.jpajointutorial.member.entity.QMember;
import com.jpajointutorial.team.entity.QTeam;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberQueryDslRepository {
    private final JPAQueryFactory queryFactory;

    public List<Member> list(){
        QMember member = QMember.member;
        QTeam team = QTeam.team;
        return queryFactory
                .selectFrom(member)
                .innerJoin(member.team, team)
                .fetchJoin()
                .fetch();
    }
}
