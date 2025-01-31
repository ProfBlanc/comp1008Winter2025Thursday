package wk4;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {

    @Test
    void testDefaultConstructor(){

        ToDoList list = new ToDoList();
        assertNotNull(list);
        assertEquals(0, list.getNumberOfTasks());
    }

    @Test
    void testOneArgConstructor(){
        ToDoList list = new ToDoList(10);
        assertEquals(0, list.getNumberOfTasks());
    }
    @Test
    void testAddTaskWithOneValue(){
        ToDoList list = new ToDoList();
        String task = "One Task";
        list.addTask(task);
        assertEquals(1, list.getNumberOfTasks());
        assertEquals(task, list.viewTask(1));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Fun Task", "Cool Task", "Boring Task", "Needed Task"})
    void testAddTaskWithMultipleValues(String task){
        ToDoList list = new ToDoList();
        list.addTask(task);
        assertEquals(1, list.getNumberOfTasks());
        assertEquals(task, list.viewTask(1));

    }
    @Test
    void testAddingMoreTasksThanAllowed(){
        ToDoList list = new ToDoList(3);
        list.addTask("One Task", "Two", "Three");
        list.addTask("Four", "Five");
        assertEquals(3, list.getNumberOfTasks());
        assertEquals("Three", list.viewTask(3));
    }
    @ParameterizedTest
    @CsvSource({"One,Two,Three", "Four,Five,Six","Seven,Eight,Nine"})
    void testAddingMoreTasksThanAllowed2(String task1, String task2, String task3){
        ToDoList list = new ToDoList();
        list.addTask(task1, task2, task3);
        assertEquals(3, list.getNumberOfTasks());
        assertEquals(task1, list.viewTask(1));
        assertEquals(task2, list.viewTask(2));
        assertEquals(task3, list.viewTask(3));
    }
}