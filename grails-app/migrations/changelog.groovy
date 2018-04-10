databaseChangeLog = {

	changeSet(author: "coop2 (generated)", id: "1448596046419-1") {
		createTable(tableName: "bet") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "cost_in_cents", type: "BIGINT")

			column(name: "description", type: "VARCHAR(255)")

			column(name: "horse_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "number_of_bets", type: "INT") {
				constraints(nullable: "false")
			}

			column(name: "payout_in_cents", type: "BIGINT")

			column(name: "race_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "race_complete_and_payout_set", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "ticket_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "coop2 (generated)", id: "1448596046419-2") {
		createTable(tableName: "event") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "bet_price_in_cents", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "DATETIME") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "payout_rate", type: "FLOAT") {
				constraints(nullable: "false")
			}

			column(name: "uuid", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "coop2 (generated)", id: "1448596046419-3") {
		createTable(tableName: "horse") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "jockey_name", type: "VARCHAR(255)")

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "number", type: "INT") {
				constraints(nullable: "false")
			}

			column(name: "placement", type: "INT")

			column(name: "race_id", type: "BIGINT") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "coop2 (generated)", id: "1448596046419-4") {
		createTable(tableName: "race") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "date_finished", type: "DATETIME")

			column(name: "event_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "finished", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "name", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "coop2 (generated)", id: "1448596046419-5") {
		createTable(tableName: "ticket") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "active", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "cashed_in", type: "BIT") {
				constraints(nullable: "false")
			}

			column(name: "date_activated", type: "DATETIME")

			column(name: "date_cashed_in", type: "DATETIME")

			column(name: "event_id", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "payout_in_cents", type: "BIGINT")

			column(name: "price_in_cents", type: "BIGINT")

			column(name: "uuid", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "coop2 (generated)", id: "1448596046419-6") {
		createTable(tableName: "user") {
			column(autoIncrement: "true", name: "id", type: "BIGINT") {
				constraints(nullable: "false", primaryKey: "true")
			}

			column(name: "version", type: "BIGINT") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "VARCHAR(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "coop2 (generated)", id: "1448596046419-13") {
		createIndex(indexName: "name", tableName: "event", unique: "true") {
			column(name: "name")
		}
	}

	changeSet(author: "coop2 (generated)", id: "1448596046419-14") {
		createIndex(indexName: "race_id", tableName: "horse", unique: "true") {
			column(name: "race_id")

			column(name: "number")
		}
	}

	changeSet(author: "coop2 (generated)", id: "1448596046419-15") {
		createIndex(indexName: "uuid", tableName: "ticket", unique: "true") {
			column(name: "uuid")
		}
	}

	changeSet(author: "coop2 (generated)", id: "1448596046419-16") {
		createIndex(indexName: "username", tableName: "user", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "coop2 (generated)", id: "1448596046419-7") {
		addForeignKeyConstraint(baseColumnNames: "horse_id", baseTableName: "bet", baseTableSchemaName: "racenight_dev", constraintName: "FK17C911D3E6FB3", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "horse", referencedTableSchemaName: "racenight_dev", referencesUniqueColumn: "false")
	}

	changeSet(author: "coop2 (generated)", id: "1448596046419-8") {
		addForeignKeyConstraint(baseColumnNames: "race_id", baseTableName: "bet", baseTableSchemaName: "racenight_dev", constraintName: "FK17C91BF6805E1", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "race", referencedTableSchemaName: "racenight_dev", referencesUniqueColumn: "false")
	}

	changeSet(author: "coop2 (generated)", id: "1448596046419-9") {
		addForeignKeyConstraint(baseColumnNames: "ticket_id", baseTableName: "bet", baseTableSchemaName: "racenight_dev", constraintName: "FK17C91FB818241", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "ticket", referencedTableSchemaName: "racenight_dev", referencesUniqueColumn: "false")
	}

	changeSet(author: "coop2 (generated)", id: "1448596046419-10") {
		addForeignKeyConstraint(baseColumnNames: "race_id", baseTableName: "horse", baseTableSchemaName: "racenight_dev", constraintName: "FK5EDBBDDBF6805E1", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "race", referencedTableSchemaName: "racenight_dev", referencesUniqueColumn: "false")
	}

	changeSet(author: "coop2 (generated)", id: "1448596046419-11") {
		addForeignKeyConstraint(baseColumnNames: "event_id", baseTableName: "race", baseTableSchemaName: "racenight_dev", constraintName: "FK354AD141509A93", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "event", referencedTableSchemaName: "racenight_dev", referencesUniqueColumn: "false")
	}

	changeSet(author: "coop2 (generated)", id: "1448596046419-12") {
		addForeignKeyConstraint(baseColumnNames: "event_id", baseTableName: "ticket", baseTableSchemaName: "racenight_dev", constraintName: "FKCBE86B0C41509A93", deferrable: "false", initiallyDeferred: "false", onDelete: "NO ACTION", onUpdate: "NO ACTION", referencedColumnNames: "id", referencedTableName: "event", referencedTableSchemaName: "racenight_dev", referencesUniqueColumn: "false")
	}
}
