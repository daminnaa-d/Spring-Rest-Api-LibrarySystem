//package com.example.librarysystem;
//
//import com.example.librarysystem.config.SpringConfig;
//import com.example.librarysystem.entity.Book;
//import com.example.librarysystem.entity.Collection;
//import com.example.librarysystem.entity.Member;
//import com.example.librarysystem.entity.Request;
//import com.example.librarysystem.repository.MemberRepository;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) throws ParseException {
////        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
////        MemberRepository memberRepository = context.getBean("memberRepository", MemberRepository.class);
////
////        Member member = new Member();
////
////        member.setFirst_name("Damina");
////        member.setLast_name("Temirtay");
////        member.setPhone_number("87771112233");
////        member.setEmail("damina@gmail.com");
////
////        List<Request> requests = new ArrayList<>();
////        Request request = new Request();
////        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
////        Date issue_date = format.parse("21/03/2021");
////        Date return_date = format.parse("21/04/2021");
////        request.setIssue_date(issue_date);
////        request.setReturn_date(return_date);
////        request.setMember(member);
////
////
////        List<Book> books = new ArrayList<>();
////        Book book = new Book();
////        book.setAvailability(false);
////        book.setBook_author("Louisa M. Alcott");
////        book.setBook_name("Little Women");
////        book.setDescription("story follows the lives of four March sisters");
////
////        Collection collection = new Collection();
////        collection.setCollection_name("coming of age novel");
////        book.setCollection(collection);
////        book.setRequest(request);
////        books.add(book);
////
////        collection.setBooks(books);
////
////        request.setBooks(books);
////        requests.add(request);
////
////        member.setRequests(requests);
////
////        memberRepository.save(member);
////
////        System.out.println("The list of Members: " + memberRepository.findAll());
//    }
//}
