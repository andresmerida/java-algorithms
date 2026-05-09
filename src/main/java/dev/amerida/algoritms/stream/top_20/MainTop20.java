package dev.amerida.algoritms.stream.top_20;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class MainTop20 {
    static void main() {
        IO.println(removeDuplicatesAndSortDescending(Arrays.asList(5,3,1,3,2,5,4)));
        IO.println(findOddSquares(Arrays.asList(1,2,3,4,5,6,7,8,9,10)));
        IO.println(getSecondAndThirdElements(Arrays.asList(1,2,3,4,5,6,7,8,9,10)));
        IO.println(findSecondLargestNumber(Arrays.asList(20,10,10,45,30,45,5,20)));
        IO.println(findSecondLargestNumberWithoutSorting(Arrays.asList(20,10,10,45,30,45,5,20)));
        IO.println(divideIntoEvenAndOdds(Arrays.asList(1,2,3,4,5,6,7,8,9,10)));
        IO.println(findLongestString(Arrays.asList("java","springboot","API")));
        List<Employee> employees = Arrays.asList(
                new Employee("John", "IT", 50000),
                new Employee("Alice", "HR", 40000),
                new Employee("Bob", "IT", 60000),
                new Employee("Eve", "HR", 30000),
                new Employee("David", "IT", 70000),
                new Employee("Charlie", "IT", 80000),
                new Employee("Frank", "HR", 30000),
                new Employee("Grace", "IT", 90000),
                new Employee("Henry", "HR", 100000),
                new Employee("Ivy", "IT", 110000)
        );
        IO.println(findFirstEmployeeWithSalaryGreaterThan50000(employees));
        IO.println(findTopTwoEmployeesWithHighestSalary(employees));
        IO.println(sortEmployeesBySalaryAndName(employees));
        IO.println(findFrequencyOfNumbers(Arrays.asList(3,2,3,4,4,1,2,1,1,1,5,6,5)));
        IO.println(countEmployeesByDepartment(employees));

        List<Transaction> transactions = Arrays.asList(
                new Transaction("Food", 100),
                new Transaction("Food", 200),
                new Transaction("Shopping", 250),
                new Transaction("Shopping", 100),
                new Transaction("Utilities", 400),
                new Transaction("Utilities", 300),
                new Transaction("Entertainment", 500),
                new Transaction("Entertainment", 200),
                new Transaction("Travel", 700),
                new Transaction("Travel", 300)
        );

        IO.println(findTotalTransactionsAmountPerCategory(transactions));
        IO.println(findAverageSalaryPerDepartment(employees));
        IO.println(findHighestPaidEmployeePerDepartment(employees));
        IO.println(convertEmployeesListToString(employees));
        IO.println(findIntersection(Arrays.asList(1,2,3,4), Arrays.asList(3,4,5,6)));
        IO.println(flattenList(Arrays.asList(
                Arrays.asList(1,2,3,4),
                Arrays.asList(3,4,5,6),
                Arrays.asList(7,8,1,2),
                Arrays.asList(9,10,5,6),
                Arrays.asList(11,12,7,8))));
        printEmployeeNames(employees);
        IO.println(computeTotalCombinedSalary(employees));
    }

    private static List<Integer> removeDuplicatesAndSortDescending(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    /**
     * From the list of integers, find all the odd numbers and return their squares.
     */
    static List<Integer> findOddSquares(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> number * number)
                .toList();
    }

    /**
     * We have a list of integers. Get the second and the third elements from the list.
     */
    static List<Integer> getSecondAndThirdElements(List<Integer> numbers) {
        return numbers.stream()
                .skip(1)
                .limit(2)
                .toList();
    }

    /**
     * We have a list of integers. Find the second-largest number in the list.
     */
    static int findSecondLargestNumber(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(0);
    }

    static int findSecondLargestNumberWithoutSorting(List<Integer> numbers) {
        int max = 0;
        int secondMax = 0;
        for (int number : numbers) {
            if (number > max) {
                secondMax = max;
                max = number;
            } else if (number > secondMax && number != max) {
                secondMax = number;
            }
        }
        return secondMax;
    }

    /**
     * You have a list of integers. Divide numbers into two groups: even and odds.
     */
    static Map<Boolean, List<Integer>> divideIntoEvenAndOdds(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.partitioningBy(number -> number % 2 == 0));
    }

    /**
     * We have a list of strings. Find the longest string in the list.
     */
    static String findLongestString(List<String> strings) {
        return strings.stream()
                .max(Comparator.comparing(String::length))
                .orElse("");
    }

    /**
     * From a list of employees, find the first employee whose salary is greater than 50.000.
     */
    static Employee findFirstEmployeeWithSalaryGreaterThan50000(List<Employee> employees) {
        return employees.stream()
                .filter(employee -> employee.salary > 50000)
                .findFirst()
                .orElse(null);
    }

    record Employee(String name, String department, double salary) { }

    /**
     * From a list of employees, find the top two employees with the highest salary.
     */
    static List<Employee> findTopTwoEmployeesWithHighestSalary(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::salary).reversed())
                .limit(2)
                .toList();
    }

    /**
     * From a list of employees, sort the employees by their salary, then by name
     */
    static List<Employee> sortEmployeesBySalaryAndName(List<Employee> employees) {
        return employees.stream()
                .sorted(Comparator.comparing(Employee::salary).reversed().thenComparing(Employee::name))
                .toList();
    }

    /**
     * From a list of integers, find the frequency of each number.
     */
    static Map<Integer, Long> findFrequencyOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                .collect(Collectors.groupingBy(number -> number, Collectors.counting()));
    }

    /**
     * Given a list of employees, count how many employees are in each department.
     */
    static Map<String, Long> countEmployeesByDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.counting()));
    }

    /**
     * Given a list of transactions, find the total transactions amount per category.
     */
    static Map<String, Double> findTotalTransactionsAmountPerCategory(List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.groupingBy(Transaction::category, Collectors.summingDouble(Transaction::amount)));
    }
    record Transaction(String category, double amount) { }

    /**
     * Given a list of employees, find the average salary of all employees in each department.
     */
    static Map<String, Double> findAverageSalaryPerDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::department, Collectors.averagingDouble(Employee::salary)));
    }

    /**
     * Given a list of employees, find the highest paid employee in each department.
     */
    static Map<String, Optional<Employee>> findHighestPaidEmployeePerDepartment(List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::department,
                        Collectors.maxBy(Comparator.comparingDouble(Employee::salary))));
    }

    /**
     * Given a list of employees, convert the list into a comma-separated string of employee names.
     */
    static String convertEmployeesListToString(List<Employee> employees) {
        return employees.stream()
                .map(Employee::name)
                .collect(Collectors.joining(", "));
    }

    /**
     * Given two lists, find the intersection of the elements in both lists.
     */
    static List<Integer> findIntersection(List<Integer> list1, List<Integer> list2) {
        Set<Integer> set = new HashSet<>(list2);
        return list1.stream()
                .filter(set::contains)
                .toList();
    }

    /**
     * You have a list of lists. Convert it into a single list with all the elements. Remove duplicates if any.
     */
    static List<Integer> flattenList(List<List<Integer>> lists) {
        return lists.stream()
                .flatMap(List::stream)
                .distinct()
                .toList();
    }

    /**
     * Given a list of employees, print all employees' names. Their order does not matter, but the operation should be fast.
     */
    static void printEmployeeNames(List<Employee> employees) {
        employees.parallelStream()
                .forEach(employee -> System.out.println(employee.name()));
    }

    /**
     * From a list of employees, compute the total combined salary of all employees. Operation should be fast.
     */
    static double computeTotalCombinedSalary(List<Employee> employees) {
        return employees.parallelStream()
                .mapToDouble(Employee::salary)
                .sum();
    }
}
