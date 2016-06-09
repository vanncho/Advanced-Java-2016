package lab.Repository;

import lab.StaticData.ExceptionMessages;
import lab.IO.OutputWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.function.Predicate;

public class RepositoryFilters {
    public static void printFilteredStudents(HashMap<String, List<Integer>> courseData, String filterType, int numberOfStudents){
        Predicate<Double> predicate = createPredicate(filterType);
        filterAndTake(predicate, courseData, numberOfStudents);
    }

    private static void filterAndTake(Predicate<Double> filter, HashMap<String, List<Integer>> courseData, int numberOfStudents){
        if (filter == null){
            OutputWriter.displayException(ExceptionMessages.INVALID_FILTER);
            return;
        }

        int studentsCount = 0;
        for (String student : courseData.keySet()) {
            if (studentsCount == numberOfStudents){
                break;
            }
            List<Integer> studentMarks = courseData.get(student);

            Double averageMark = studentMarks
                    .stream()
                    .mapToInt(Integer::valueOf)
                    .average()
                    .getAsDouble();

            Double percentageOfFulfilment = averageMark / 100;
            Double mark = percentageOfFulfilment * 4 + 2;

            if (filter.test(mark)){
                OutputWriter.printStudent(student, studentMarks);
                studentsCount++;
            }
        }
    }

    private static Predicate<Double> createPredicate(String filterType){
        switch (filterType){
            case "excellent":
                return mark -> mark >= 5.0;

            case "average":
                return mark -> mark >= 3.50 && mark < 5.0;

            case "poor":
                return mark -> mark < 3.5;

            default:
                return null;
        }
    }
}