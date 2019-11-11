package com.example.demospringdatavavr

import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Todo(@Id val id: Long?, val name: String, val done: Boolean)
