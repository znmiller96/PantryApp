package com.znmiller96.pantryapi.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class IdGenerator implements IdentifierGenerator {

    Logger logger = LoggerFactory.getLogger(IdGenerator.class);
    final String idLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    final int idLength = 8;

    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        StringBuilder id = new StringBuilder();
        Random random = new Random();

        // TODO check generated key does not exist
        // Problem with this solution is the connection will not work sometimes
        // java.sql.SQLTransientConnectionException: HikariPool-1 - Connection is not available, request timed out after 30005ms.
//        try {
//            Connection connection = sharedSessionContractImplementor.getJdbcConnectionAccess().obtainConnection();
//            Statement statement = connection.createStatement();
//
//            while (id.length() < idLength) {
//                int index = random.nextInt(idLetters.length());
//                id.append(idLetters.charAt(index));
//
//                if (id.length() == idLength) {
//                    ResultSet result = statement.executeQuery("select count(id) from category where id=\'" + id + "\'");
//                    if (result.next()) {
//                        if (result.getInt(1) > 0) {
//                            id = new StringBuilder();
//                            logger.info("duplicate id generated");
//                        }
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        while (id.length() < idLength) {
            int index = random.nextInt(idLetters.length());
            id.append(idLetters.charAt(index));
        }
        
        return id.toString();
    }
}
