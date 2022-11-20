import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JUnit5Examples {
    @BeforeAll
    public static void beforeAll() {
        System.out.println("Before all tests");
    }
    @AfterAll
    public static void afterAll() {
        System.out.println("After all tests");
    }
    @BeforeEach
    public void setUp() {
        System.out.println("Before each test");
    }
    @AfterEach
    public void tearDown() {
        System.out.println("After each test");
    }

    @Test
    void firstTest() {
        System.out.println("First test");
        assertTrue (3 > 2);
    }


    @Test
        void secondTest() {
            System.out.println("Second test");
            assertFalse (3 > 2);
        }


}
