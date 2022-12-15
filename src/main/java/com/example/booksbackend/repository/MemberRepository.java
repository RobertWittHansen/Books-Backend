package com.example.booksbackend.repository;

import com.example.booksbackend.entityModel.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String> {



}
