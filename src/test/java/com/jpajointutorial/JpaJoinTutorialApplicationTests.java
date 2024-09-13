package com.jpajointutorial;

import com.jpajointutorial.member.dto.MemberTeamDTO;
import com.jpajointutorial.member.dto.MemberTeamDTO2;
import com.jpajointutorial.member.entity.Member;
import com.jpajointutorial.member.projection.MemberRecordProjection;
import com.jpajointutorial.member.repository.MemberQueryDslRepository;
import com.jpajointutorial.member.repository.MemberRepository;
import com.jpajointutorial.team.entity.Team;
import com.jpajointutorial.team.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@ActiveProfiles({"test", "postgres"})
@Transactional
@Slf4j
class JpaJoinTutorialApplicationTests {

    @Autowired
    public MemberRepository memberRepository;

    @Autowired
    public TeamRepository teamRepository;

    @Autowired
    public MemberQueryDslRepository memberQueryDslRepository;

    @Test
    void member_findall(){

        List<Member> findAll = memberRepository.findAll();
        log.info("findAll.size() : {}",findAll.size());
        findAll.forEach(m -> {
            log.info("m.getMemberId() : {}",m.getMemberId());
            log.info("m.getTeam().getTeamName() : {}", m.getTeam().getTeamName());

        });

        List<Member> findAllFetch = memberRepository.findAllFetch();
        log.info("findAllFetch.size() : {}",findAllFetch.size());
        findAllFetch.forEach(m -> {
            log.info("m.getMemberId() : {}",m.getMemberId());
            log.info("m.getTeam().getTeamName() : {}", m.getTeam().getTeamName());

        });

        List<Member> findAllEntityGraph = memberRepository.findAllEntityGraph();
        log.info("findAllEntityGraph.size() : {}",findAllEntityGraph.size());
        findAllEntityGraph.forEach(m -> {
            log.info("m.getMemberId() : {}",m.getMemberId());
            log.info("m.getTeam().getTeamName() : {}", m.getTeam().getTeamName());

        });


        List<MemberTeamDTO> findAllDTO = memberRepository.findAllDTO();
        log.info("findAllDTO.size() : {}",findAllDTO.size());
        findAllDTO.forEach(m -> {
            log.info("m.getMemberId() : {}",m.getMemberId());
            log.info("m.getMemberName() : {}",m.getMemberName());
            log.info("m.getTeam().getTeamId() : {}",m.getTeam().getTeamId());
            log.info("m.getTeam().getTeamName() : {}",m.getTeam().getTeamName());
        });

        List<MemberTeamDTO2> findAllDTO2 = memberRepository.findAllDTO2();
        log.info("findAllDTO2.size() : {}",findAllDTO2.size());
        findAllDTO2.forEach(m -> {
            log.info("m.getMemberId() : {}",m.getMemberId());
            log.info("m.getMemberName() : {}",m.getMemberName());
            log.info("m.getTeam().getTeamId() : {}",m.getTeamId());
            log.info("m.getTeam().getTeamName() : {}",m.getTeamName());
        });

        List<MemberRecordProjection> memberRecordProjection = memberRepository.findAllRecord();
        log.info("findAllDTO2.size() : {}",memberRecordProjection.size());
        memberRecordProjection.forEach(m -> {
            log.info("m.getMemberId() : {}",m.memberId());
            log.info("m.getMemberName() : {}",m.name());
            log.info("m.getTeam().getTeamId() : {}",m.teamTeamId());
            log.info("m.getTeam().getTeamName() : {}",m.teamTeamName());
        });

    }

    @Test
    void team_finall(){
        List<Team> findAll = teamRepository.findAll();
        log.info("findAll.size() : {}",findAll.size());
        findAll.forEach(t -> {
            log.info("t.getTeamName() : {}", t.getTeamName());
            t.getMembers().forEach(m -> {
                log.info("m.getMemberId() : {}",m.getMemberId());
            });
        });

        List<Team> findAllFetch = teamRepository.findAllFetch();
        log.info("findAllFetch.size() : {}",findAllFetch.size());
        findAllFetch.forEach(t -> {
            log.info("t.getTeamName() : {}", t.getTeamName());
            t.getMembers().forEach(m -> {
                log.info("m.getMemberId() : {}",m.getMemberId());
            });
        });

        List<Team> findAllEntityGraph = teamRepository.findAllEntityGraph();
        log.info("findAllEntityGraph.size() : {}",findAllEntityGraph.size());
        findAllEntityGraph.forEach(t -> {
            log.info("t.getTeamName() : {}", t.getTeamName());
            t.getMembers().forEach(m -> {
                log.info("m.getMemberId() : {}",m.getMemberId());
            });
        });
    }

    @Test
    void queryDslMemberList(){
        List<Member> list = memberQueryDslRepository.list();
        log.info("list.size() : {}",list.size());
        list.forEach(m -> {
            log.info("m.getMemberId() : {}",m.getMemberId());
            log.info("m.getMemberName() : {}",m.getName());
            log.info("m.getTeam().getTeamName() : {}",m.getTeam().getTeamName());

        });


    }

}
