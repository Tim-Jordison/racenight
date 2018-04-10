//todo the old datasource stuff
//dataSource {
//    pooled = true
//    jmxExport = true
//    driverClassName = "org.h2.Driver"
//    username = "sa"
//    password = ""
//}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory' // Hibernate 3
//    cache.region.factory_class = 'org.hibernate.cache.ehcache.EhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
}

dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    dialect = org.hibernate.dialect.MySQL5InnoDBDialect
    username = "dbadmin"
    password = "siabj40lom9"


    properties {
        maxActive = 100
        maxIdle = 10
        minIdle = 5
        initialSize = 5
        minEvictableIdleTimeMillis = 120000
        timeBetweenEvictionRunsMillis = 120000
        maxWait = 30000
        validationQuery = "select 1 as dbcp_connection_test"
        testOnBorrow = true
        testWhileIdle = true
    }
}

// environment specific settings
environments {
    development {
        dataSource {
            // todo m2 in memory top
//            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
//            url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"

            // todo dev aws
//            url = "jdbc:mysql://racenight-dev.c8oyuhjfgkeg.us-west-2.rds.amazonaws.com:3306/racenight_dev"
            url = "jdbc:mysql://racenight-prod.c8oyuhjfgkeg.us-west-2.rds.amazonaws.com:3306/racenight_prod"
            dbCreate = "update"
        }
    }
    test {
        dataSource {
            dbCreate = "update"
            url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
        }
    }
    production {
        dataSource {
            dbCreate = "update"
            url = "jdbc:mysql://racenight-prod.c8oyuhjfgkeg.us-west-2.rds.amazonaws.com:3306/racenight_prod"

            //todo old below
//            url = "jdbc:h2:prodDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"

        }
    }
}
