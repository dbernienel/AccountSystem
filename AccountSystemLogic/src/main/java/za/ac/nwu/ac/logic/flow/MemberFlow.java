package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.persistence.Member;

import java.util.List;

public interface MemberFlow {
    List<Member> findAllMembers();

    Member findMemberDtoById(Long id);

    Member create(Member memberDto);
}
