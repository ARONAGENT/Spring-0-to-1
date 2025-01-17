package com.springjourney.Week4Practice.Controllers;

import com.springjourney.Week4Practice.Entities.PostEntity;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/audit")
public class AuditController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @GetMapping("/id/{postId}")
    List<PostEntity> getPostRevisions(@PathVariable int postId){
        AuditReader auditReader= AuditReaderFactory.get(entityManagerFactory.createEntityManager());
        List<Number> revisions=auditReader.getRevisions(PostEntity.class,postId);
        return revisions
                .stream()
                .map(revisionNumber ->auditReader.find(PostEntity.class,postId,revisionNumber))
                .collect(Collectors.toList());
    }
}
