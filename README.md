# Chi-square Test
This is the stimulation and implementation of [Pearson's chi-squared test](https://en.wikipedia.org/wiki/Pearson's_chi-squared_test) in Java

## Program list


| Program                         | Description | 
|:---------------------------------|:----:|
| [CalcKaiSquarePD.java](./src/CalcKaiSquarePD.java)| Calculate theoretical value of chi-squared test |
| [FileOutput.java](./src/FileOutput.java)| Output file |
| [KaiPDF.java](./src/KaiPDF.java)| Calculate chi-squared distribution |
| [KeyboardInput.java](./src/KeyboardInput.java)| Handle input from keyboard |
| [chiSquareTestStimulation.java](./src/chiSquareTestStimulation.java)| Stimulation of Pearson's Chi-squared test|
| [Ransuu.java](./src/Ransuu.java)| Generate random number|
| [Kyuuwake.java](./src/Kyuuwake.java)| Separate data into groups|
| [Probability.java](./src/Probability.java)| Calculate upper bound and lower bound probability, two sided probability|
| [ChiSquare.java](./src/ChiSquare.java)| Calculate chi-squared value|
| [Output.java](./src/Output.java)| Output of chi-squared distribution|
| [chiSquareTest.java](./src/chiSquareTest.java)| Implementation of Chi-squared test|
| [ReadCSV.java](./src/ReadCSV.java)| Load input data|
| [CalcMeanSD.java](./src/CalcMeanSD.java)| Calculate mean and std variation|
| [CalcZscore.java](./src/CalcZscore.java)| Calculate z-score of every groups|

## Data file

| File                         | Description | 
|:---------------------------------|:----:|
| data.csv| Height data of 1000 male|

## Stimulation of Pearson's Chi-squared test
Program: chiSquareTestStimulation.java

Compile and Run Method:
command line arguments 1：　min of x 2：　max of x、3：　step、４： number of events
min of x、max of x、step: double
Number of events: int

Example)
$ javac chiSquareTestStimulation.java
$ java chiSquareTestStimulation -3.0 3.0 1.0 8  		

Stimulation result will be chiSquareTestStimulation.csv.

## Implementation of Pearson's Chi-squared test
Program: chiSquareTest.java

Compile and Run Method:
command line arguments 1：　data filename 2：　significance level
(Choose significance level from 0.995, 0.975, 0.05, 0.025, 0.01, 0.005

例)
$ javac chiSquareTest.java
$ java chiSquareTest data.csv 0.05 		

Output:
chiSquareTest.csv: Result of chiSquaredTest
KitaiDosuu.csv: Data of expected frequency
Terminal output: mean, standard deviation, variance, number of events, degree of freedom, significance level, rejection region, conclusion
