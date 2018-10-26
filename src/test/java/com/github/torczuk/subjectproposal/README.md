1. Is v1 ok?
2. is v2 ok?

3.
Request:
Subject must have it's domain identifier / code not related to database

add new field to `code` unique for all Subjects, uncomment
```private String code = UUID.randomUUID().toString();```

4. is v4 ok?

5. Look at the `better` package

6.
Request:
method  `subjectRepository.findByName` does not hit cache, is slow, and we want to
used instead `subjectRepository.findBy`. Change implementation to

```
subjectRepository.findBy("name", subjectName);
```

