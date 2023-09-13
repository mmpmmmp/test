package com.warrior.gm;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * @author admin
 */
@Slf4j
@MapperScan("com.warrior.gm.mapper")
@SpringBootApplication
public class WarriorGmServerApplication {

    public static void main(String[] args) throws IOException {
        String pid = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];
        try (FileWriter writer = new FileWriter("server.pid")) {
            writer.write(pid);
            writer.flush();
        }
        System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(WarriorGmServerApplication.class, args);
        log.info("启动成功");
    }

}
