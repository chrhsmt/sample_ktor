package com.chrhsmt.example.ktor.services

import com.chrhsmt.example.ktor.model.Cities
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object DatabaseFactory {

    fun init() {
        Database.connect("jdbc:h2:mem:test;DB_CLOSE_DELAY=-1", driver = "org.h2.Driver")
        transaction {

            // Todo: Logger
            addLogger(StdOutSqlLogger)
            // Todo: 特定フォルダ以下を自動読み込みにしたい
            SchemaUtils.create(Cities)
            // Todo: seedsファイル化したい
            Cities.insert {
                it[name] = "Tokyo"
            }
        }
    }

    suspend fun <T> dbQuery(block: () -> T): T {
        return withContext(Dispatchers.IO) {
            transaction {
                return@transaction block()
            }
        }
    }
}