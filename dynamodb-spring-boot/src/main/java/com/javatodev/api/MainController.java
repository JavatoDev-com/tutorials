package com.javatodev.api;

import com.javatodev.api.model.*;
import com.javatodev.api.repository.AuthorRepository;
import com.javatodev.api.repository.BookRepository;
import com.javatodev.api.repository.LendRepository;
import com.javatodev.api.repository.MemberRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/rest")
@RequiredArgsConstructor
public class MainController {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final MemberRepository memberRepository;
    private final LendRepository lendRepository;

    @GetMapping
    public ResponseEntity create() {

        Author author = new Author();
        author.setFirstName("Random");
        author.setLastName("Upu");
        Author save = authorRepository.save(author);

        Book book = new Book();
        book.setAuthorId(save.getId());
        book.setName("Arthur");
        book.setIsbn("2892828282822");

        Book bookSaved = bookRepository.save(book);

        Member member = new Member();
        member.setStatus(MemberStatus.ACTIVE);
        member.setFirstName("Srimath");
        member.setLastName("Anagarika");

        Member member1 = memberRepository.save(member);


        Lend lend = new Lend();
        lend.setDueOn(Instant.now().toString());
        lend.setStartOn(Instant.now().toString());
        lend.setStatus(LendStatus.BURROWED);
        lend.setBookId(bookSaved.getId());
        lend.setMemberId(member1.getId());
        lendRepository.save(lend);

        return ResponseEntity.ok().build();
    }
}
