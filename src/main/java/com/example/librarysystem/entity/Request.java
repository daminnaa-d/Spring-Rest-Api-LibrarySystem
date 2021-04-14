package com.example.librarysystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long request_id;
    Date issue_date = new Date();
    Date return_date = new Date();


    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "member_id", insertable = true, updatable = true)
    @JsonIgnore
    private Member member;

    @OneToMany(mappedBy = "request", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Book> books;

    public Request() { }

    public Request(Long request_id, Date issue_date, Date return_date, Member member, List<Book> books) {
        this.request_id = request_id;
        this.issue_date = issue_date;
        this.return_date = return_date;
        this.member = member;
        this.books = books;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Long getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Long request_id) {
        this.request_id = request_id;
    }

    public Date getIssue_date() {
        return issue_date;
    }

    public void setIssue_date(Date issue_date) {
        this.issue_date = issue_date;
    }

    public Date getReturn_date() {
        return return_date;
    }

    public void setReturn_date(Date return_date) {
        this.return_date = return_date;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Request{" +
                "request_id=" + request_id +
                ", issue_date=" + issue_date +
                ", return_date=" + return_date +
                ", books=" + books +
                '}';
    }
}

