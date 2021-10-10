package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.logic.flow.MemberFlow;
import za.ac.nwu.ac.repo.persistence.MemberRespository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class MemberFlowImpl implements MemberFlow {
    MemberRespository memberRespository;

    @Autowired
    public MemberFlowImpl(MemberRespository memberRespository) {
        this.memberRespository = memberRespository;
    }

    @Override
    public List<Member> findAllMembers() {
        return memberRespository.findAll();
    }

    @Override
    public Member findMemberDtoById(final Long id) {
        Optional<Member> memberById = memberRespository.findById(id);
        RuntimeException runtimeException = new RuntimeException("Member not found for id " + id);
        return memberById.orElseThrow(() -> runtimeException);
    }

    @Override
    public Member create(Member memberDto) {
        return memberRespository.saveAndFlush(new Member(memberDto.getId(), memberDto.getName(), memberDto.getSurName()));
    }
}
