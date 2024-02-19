package org.example.tree.domain.profile.repository;

import org.example.tree.domain.member.entity.Member;
import org.example.tree.domain.profile.entity.Profile;
import org.example.tree.domain.tree.entity.Tree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    Optional<Profile> findByMemberAndTree(Member member, Tree tree);

    Optional<Object> findByMember_Id(String memberId);

    List<Profile> findAllByMember_Id(String memberId);
}
