package wk4;

import java.util.ArrayList;

public class ToDoList {

    private String[] knownTasks;
    private ArrayList<String> unlimitedTasks;
    //enum: enumerable: drop-down list of possibility
    private enum WhichTaskChosen {KNOWN, UNLIMITED}
    /** This variable tracks the task added to the knownTasks array so we can preform CRUD operations **/
    private int index = -1;

    private WhichTaskChosen whichTaskTypeChosen; // either point to know or unlimited

    public ToDoList() {
        whichTaskTypeChosen = WhichTaskChosen.UNLIMITED;
        unlimitedTasks = new ArrayList<>();
    }
    public ToDoList(int numberOfTasks){
        whichTaskTypeChosen = WhichTaskChosen.KNOWN;
        knownTasks = new String[numberOfTasks];
    }
    public void addTask(String task1){
        handleTasksAdded(task1);
    }
    public void addTask(String task1, String task2){
        handleTasksAdded(task1, task2);
    }
    public void addTask(String task1, String task2, String task3){
        handleTasksAdded(task1, task2, task3);
    }

    /**
     * This is Java Documentation. This is used to document what the method does
     * Why? Because programmers have a bad memory
     * ________________________________
     * This method determines whichTaskChosen and adds the tasks to the appripriate collection
     * (either array or arraylist)
     * @param tasks
     */
    private void handleTasksAdded(String... tasks){
        if(whichTaskTypeChosen == WhichTaskChosen.KNOWN)
            handleTasksAddedToKnownTaskList(tasks);
        else
            handleTasksAddedToUnKnownTaskList(tasks);
    }

    private void handleTasksAddedToKnownTaskList(String... tasks){

        //inside the method of unlimited => data type == array of that. in this case tasks = String[]

        for(String task : tasks){
            if(index == knownTasks.length - 1){
                System.out.println("Oh no! You have no remaining indexes");
                break;
            }
            knownTasks[++index] = task;
        }


    }
    private void handleTasksAddedToUnKnownTaskList(String... tasks){

        for(String task : tasks){
            if(!unlimitedTasks.contains(task))
                unlimitedTasks.add(task);
        }

    }
    public int getNumberOfTasks(){
        return switch (whichTaskTypeChosen){
            case KNOWN -> index + 1;
            case UNLIMITED -> unlimitedTasks.size();
            default -> 0;
        };
    }

    /**
     * This retrieves a task at a given HUMAN index. Starting at 1
     * @param taskNumber a task number starting at 1
     * @return
     */
    public String viewTask(int taskNumber){

        if(taskNumber < 1 || taskNumber > getNumberOfTasks() ){
            System.out.println("Invalid task number given");
            return "Error!";
        }

        taskNumber--;

        return switch (whichTaskTypeChosen){
            case KNOWN -> {
                //run statements here
                yield knownTasks[taskNumber];
            }
            case UNLIMITED -> unlimitedTasks.get(taskNumber);
            default -> "N/A";
        };
    }
}
