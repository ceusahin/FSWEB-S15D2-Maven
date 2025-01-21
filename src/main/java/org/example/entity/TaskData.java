package org.example.entity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks ;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String str) {
        return switch (str) {
            case "ann" -> annsTasks;
            case "bob" -> bobsTasks;
            case "carol" -> carolsTasks;
            case "all" -> getUnion(annsTasks, bobsTasks, carolsTasks, unassignedTasks);
            default -> null;
        };
    }

    //  varargs parameter

    public Set<Task> getUnion(Set<Task>... taskList) {
        Set<Task> union = new HashSet<>();
        for (Set<Task> task: taskList){
            union.addAll(task);
        }
        return union;
    }

    public Set<Task> getIntersection(Set<Task> taskList1, Set<Task> taskList2) {
        Set<Task> retainSet = new HashSet<>(taskList1);
        retainSet.retainAll(taskList2);
        return retainSet;
    }

    public Set<Task> getDifferences(Set<Task> taskList1, Set<Task> taskList2) {
        Set<Task> diff = new HashSet<>(taskList1);
        diff.removeAll(taskList2);
        return diff;
    }

}
