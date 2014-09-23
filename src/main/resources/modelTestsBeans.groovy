package com.efimchick.jkblog.config

import archive.model.Article
import archive.model.Person
import archive.model.Right
import archive.model.Role
import archive.model.Tag

import java.time.LocalDateTime

beans {

    parentTag (Tag){
        id = 3
        name = "parent"
    }

    simpleTag (Tag){
        id = 1
        name = "tag"
        parent = parentTag
    }

    javaTag (Tag){
        id = 2
        name = "java"
    }




    canEdit (Right){
        id = 1
        name = "canEdit"
        description = "desc"
    }

    canSomething (Right){
        id = 2
        name = "canSomething"
        description = "desc"
    }

    admin (Role) {
        id = 1
        name = "admin"
        rights = [canEdit, canSomething]
    }

    user (Role) {
        id = 1
        name = "user"
        rights = [canSomething]
    }


    jerome (Person) {
        id = 1
        name = "Jerome"
        email = "thejerome@mail.ru"
        password = "password"
        role = admin
    }

    kate( Person){
        id = 1
        name = "Kate"
        email = "kate-bistro@mail.ru"
        password = "password"
        role = user
    }

    kateArticle (Article){
        id=1
        author = kate
        title = "kate art"
        content = "Content"
        created = LocalDateTime.now()
        tags = [simpleTag]
    }

    jeromeArticle (Article){
        id=2
        author = jerome
        title = "jerome art"
        content = "Content"
        created = LocalDateTime.now().minusDays(2)
        updated = LocalDateTime.now()
        tags = [simpleTag, javaTag]
    }
}