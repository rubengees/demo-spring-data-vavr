package com.example.demospringdatavavr

import io.vavr.collection.Seq
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TodoRepository: JpaRepository<Todo, Long> {

    @Query("FROM Todo")
    fun findAllJava(): List<Todo>

    @Query("SELECT name FROM Todo")
    fun findAllNamesJava(): List<String>

    @Query("FROM Todo")
    fun findAllVavr(): Seq<Todo>

    @Query("SELECT name FROM Todo")
    fun findAllNamesVavr(): Seq<String>
}
