package com.jpajointutorial.member.repository;

import com.jpajointutorial.member.dto.MemberTeamDTO;
import com.jpajointutorial.member.dto.MemberTeamDTO2;
import com.jpajointutorial.member.entity.Member;
import com.jpajointutorial.member.projection.MemberRecordProjection;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    <T> List<T> findAllBy(Class<T> clazz);
    <T> T findByMemberId(Long id, Class<T> projection);

    //fetch join
    @Query("SELECT m FROM Member m JOIN FETCH m.team")
    List<Member> findAllFetch();

    //entityGraph
    @EntityGraph(attributePaths = {"team"})
    @Query("SELECT m FROM Member m")
    List<Member> findAllEntityGraph();

    @Query("SELECT new com.jpajointutorial.member.dto.MemberTeamDTO(m.memberId, m.name, t) FROM Member m JOIN m.team t")
    List<MemberTeamDTO> findAllDTO();

    @Query("SELECT new com.jpajointutorial.member.dto.MemberTeamDTO2(m.memberId, m.name, t.teamId, t.teamName) FROM Member m JOIN m.team t")
    List<MemberTeamDTO2> findAllDTO2();

    @Query("SELECT new com.jpajointutorial.member.projection.MemberRecordProjection(m.memberId, m.name, t.teamId, t.teamName) FROM Member m JOIN m.team t")
    List<MemberRecordProjection> findAllRecord();


}
