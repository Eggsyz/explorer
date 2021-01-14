package top.itkezhan.blockchain.explorer;

import org.checkerframework.checker.units.qual.A;
import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExplorerApplicationTests {

    @Autowired
    StringEncryptor encryptor;

    @Test
    void contextLoads() {

    }

    /**
     * 生成加密后的数据库密码
     */
    @Test
    void generatorPassword() {
        System.out.println(encryptor.encrypt("123456"));
    }
}
