# Spring Boot data Vavr bug reproduction project

This project reproduces a bug in Spring Boot data when using `@QUery` which return
non entity results (e.g. just a `String`) wrapped in a Vavr collection type.

One example of such an interface method is:

```kt
@Query("SELECT name FROM Todo")
fun findAllNamesVavr(): Seq<String>
```

This crashes with the stack trace:

```
java.lang.ClassCastException: class java.lang.String cannot be cast to class io.vavr.collection.Seq (java.lang.String is in module java.base of loader 'bootstrap'; io.vavr.collection.Seq is in unnamed module of loader 'app')
	at com.sun.proxy.$Proxy84.findAllNamesVavr(Unknown Source)
	at com.example.demospringdatavavr.TodoRepositoryTest.finding names vavr seq(TodoRepositoryTest.kt:45)
```

Reproduced starting with Spring Boot 2.1.0.RELEASE.
