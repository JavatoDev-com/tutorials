package com.javatodev.api;

import com.javatodev.api.model.Author;
import com.javatodev.api.model.Book;
import com.javatodev.api.model.Lend;
import com.javatodev.api.model.Member;
import com.javatodev.api.repository.AuthorRepository;
import com.javatodev.api.repository.LendRepository;
import com.javatodev.api.repository.MemberRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1")
@RequiredArgsConstructor
public class APIController {

    private final AuthorRepository authorRepository;
    private final LendRepository lendRepository;
    private final MemberRepository memberRepository;

    @PostMapping
    public ResponseEntity<Void> create() {
        Author author = new Author();
        author.setFirstName("Sir Arthur");
        author.setLastName("Conan Doile");

        List<Book> books = new ArrayList<>();
        books.add(Book.builder().name("Sherlock Holmes I").author(author).isbn("1919191919").build());
        books.add(Book.builder().name("Sherlock Holmes II").author(author).isbn("1919191920").build());
        books.add(Book.builder().name("Sherlock Holmes III").author(author).isbn("1919191921").build());
        books.add(Book.builder().name("Sherlock Holmes IV").author(author).isbn("1919191922").build());
        books.add(Book.builder().name("Sherlock Holmes V").author(author).isbn("1919191923").build());

        author.setBooks(books);

        authorRepository.save(author);


        Member member = new Member();
        member.setFirstName("Sonu");
        member.setLastName("Nigam");
        memberRepository.save(member);

        Lend lend = new Lend();
        lend.setBook(books.get(0));
        lend.setDueOn(Instant.now().plus(30, ChronoUnit.DAYS));
        lend.setStartOn(Instant.now());
        lend.setStatus("ACTIVE");
        lend.setMember(member);
        lendRepository.save(lend);

        return ResponseEntity.ok().build();

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Author> readAuthro(@PathVariable Long id) {
        return ResponseEntity.ok(authorRepository.findById(id).get());
    }

}
