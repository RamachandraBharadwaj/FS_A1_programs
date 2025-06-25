// You are given details of n students. 
// Each student record contains:
// 	Student ID: an integer
// 	Name: a string
// 	Marks in five fixed subjects: Math, Science, English, History, Computer (each an integer 0–100)

// Write a Java program that:
// 	1.Reads the n student records from standard input.
// 	2.For each student, computes:
// 		Total marks (sum of all five subjects)
// 		Average marks (to two decimal places)
// 	3.Determines the top 5 students by average marks (highest first).
// 	4. Prints a summary table of all students (ID, Name, Total, Average), sorted by student ID ascending.
// 	5. Prints the list of Top 5 students (ID, Name, Average).
// 	6. Identify and print any student scoring below 35 in any subject (“at risk”).

// Input Format
// -------------
// n
// id₁
// name₁
// math₁ science₁ english₁ history₁ computer₁
// id₂
// name₂
// math₂ science₂ english₂ history₂ computer₂
// ...
// idₙ
// nameₙ
// mathₙ scienceₙ englishₙ historyₙ computerₙ

// where n: number of students

// For each student i:
// 	idᵢ (integer)
// 	nameᵢ (single-line string)
// 	Five integers: marks in Math, Science, English, History, Computer

// Output Format:
// ---------------
// All students:
// ID   Name           Total  Average
// 101  Alice Smith    450    90.00
// 102  Bob Johnson    382    76.40
// ...

// Top 5 students:
// 1) 101 Alice Smith    90.00
// 2) 107 Carol Davis    88.20
// …

// At-risk students: 
// 105 (Eve Lee), 110 (Frank Wu)

// Sample Input:
// -------------
// 5
// 101
// Alice Smith
// 95 90 92 88 94
// 102
// Bob Johnson
// 60 58 62 70 65
// 103
// Carol Davis
// 85 82 80 78 84
// 104
// Dave Lee
// 30 40 35 20 25
// 105
// Eve Kim
// 50 55 60 65 70

// Sample Output:
// --------------
// All students:
// ID   Name                Total  Average
// 101  Alice Smith        459     91.80
// 102  Bob Johnson        315     63.00
// 103  Carol Davis        409     81.80
// 104  Dave Lee           150     30.00
// 105  Eve Kim            300     60.00

// Top 5 students:
// 1) 101  Alice Smith      91.80
// 2) 103  Carol Davis      81.80
// 3) 102  Bob Johnson      63.00
// 4) 105  Eve Kim          60.00
// 5) 104  Dave Lee         30.00

// At-risk students: 
// 104 (Dave Lee)

import 