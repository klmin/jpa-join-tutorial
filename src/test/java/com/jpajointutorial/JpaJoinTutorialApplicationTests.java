package com.jpajoin.jpajointutorial;

import com.jpajointutorial.member.repository.MemberRepository;
import com.jpajointutorial.team.repository.TeamRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@ActiveProfiles({"test", "postgres"})
@Transactional
@Slf4j
class JpaJoinTutorialApplicationTests {

    @Autowired
    public MemberRepository memberRepository;

    @Autowired
    public TeamRepository teamRepository;

    @Test
    void init(){
    
    }

}
