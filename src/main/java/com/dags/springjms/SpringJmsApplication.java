package com.dags.springjms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJmsApplication {

    public static void main(String[] args) throws Exception {

        ////////////////      embedded ActiveMQServer  ////////////////////////////////////
//        ActiveMQServer server = ActiveMQServers.newActiveMQServer(new ConfigurationImpl()
//                .setPersistenceEnabled(false)
//                .setJournalDirectory("target/data/journal")
//                .setSecurityEnabled(false)
//                .addAcceptorConfiguration("invm", "vm://0"));
//        server.start();
        //////////////////////////////////////////////////////////////////////////////////

        SpringApplication.run(SpringJmsApplication.class, args);
    }

}
