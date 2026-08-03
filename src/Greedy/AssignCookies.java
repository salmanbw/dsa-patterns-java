package Greedy;

import java.util.Arrays;

/*
Assign Cookies

Problem Statement: Consider a scenario where a teacher wants to distribute cookies to students, with each student receiving at most one cookie. Given two arrays,
student and cookie, the ith value in the student array describes the minimum size of cookie that the ith student can be assigned.
The jth value in the cookie array represents the size of the jth cookie. If cookie[j] >= student[i], the jth cookie can be assigned to the ith student.
 Maximize the number of students assigned with cookies and output the maximum number.

Input : Student = [1, 2] , Cookie = [1, 2, 3]
Output : 2
Explanation : Cookie 1 satisfies student 1 and cookie 2 satisfies student 2. Therefore, 2 students are content.
 */
public class AssignCookies {
    public static void main(String[] args) {
        int[] student = {1,2,3};
        int[] cookies = {1,3};
        System.out.println(maxStudent(cookies,student));

    }
    public static int maxStudent(int[] cookies, int[] student){

        Arrays.sort(cookies);
        Arrays.sort(student);
        int count =0;

        for(int i=0, j=0;i<student.length && j<cookies.length;){

            if(student[i] <= cookies[j]) {
                count++;
                i++;
                j++;
            }else{
                j++;
            }
        }
        return count;


    }
}
