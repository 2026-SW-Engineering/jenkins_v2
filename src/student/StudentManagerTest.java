package student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentManagerTest {
	
    private static StudentManager manager;
    
    @BeforeAll
    static void beforeAll() {
        manager = new StudentManager();
        manager.addStudent("Alice");
    }
    

	@Test
	@Order(1)
	void testAddStudent() {
		assertTrue(manager.hasStudent("Alice"));
	}

	@Test
	@Order(2)
	void testRemoveStudent() {
		manager.removeStudent("Alice");
		assertFalse(manager.hasStudent("Alice"));
	}

    @Test
    @Order(3)
    void testDuplicateAddStudentThrowsException() {
        manager.addStudent("Alice");
        assertThrows(IllegalArgumentException.class, () -> {
            manager.addStudent("Alice");
        });
    }
    
    @Test
    @Order(4)
    void testRemoveNonExistingStudentThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            manager.removeStudent("Bob");
        });
    }
    

}
