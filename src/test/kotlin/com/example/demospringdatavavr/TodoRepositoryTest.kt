package com.example.demospringdatavavr

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TodoRepositoryTest {

    @Autowired
    private lateinit var repository: TodoRepository

    @BeforeEach
    fun setUp() {
        repository.save(Todo(1, "Spring", true))
        repository.save(Todo(2, "Boot", true))
        repository.save(Todo(3, "Vavr", false))
    }

    @Test
    fun `finding entities java list`() {
        val entities = repository.findAllJava()

        assertTrue(entities.size == 3)
    }

    @Test
    fun `finding entities vavr seq`() {
        val entities = repository.findAllVavr()

        assertTrue(entities.size() == 3)
    }

    @Test
    fun `finding names java list`() {
        val names = repository.findAllNamesJava()

        assertTrue(names.size == 3)
    }

    @Test
    fun `finding names vavr seq`() {
        val names = repository.findAllNamesVavr()

        assertTrue(names.size() == 3)
    }
}
