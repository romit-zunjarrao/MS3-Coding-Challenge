# MS3-Coding-Challenge
CSV file reader and writer 


## folder structure
-Java folder conatins 3 classes 
-CSVReader is the class with main method which does the main job of reading and writting csv and log file
-DatabaseEntry class is used to do database connectivity, creating databases and table. if database already exist, it is not recreated and table will be dropped every time the program is run.
-User is plain old java object that is used for storing cvs file record in object.
-Entry Level Coding challenge Page 2 is placed in the main folder CS3 in order to get access to file with respect to the project directory means it can be detected on any computer by just cloning the repository
- Entry Level Coding Challenge Pag -bad.csv is an output file that contains incomplete records, its just an output, you can delete it and 
run the program and you will get the same result i.e same file is generated. if you dont the delete the file then file will be over written, which ensures that every run has fresh set of data
- Entry Level Coding Challenge Pag -bad.log contain number of records, successful insertion in the database and failed records count.


## project
-project is a maven project
- all the dependies required are present in pom.xml file, so you dont have to bother with depencies like MySql jdbc driver and Apache CSV.
- Apache CSV is a library that is used for reading and writting into the cvs file.
-you can clone the repository and run it after the build is completed, the project was created in an intelij IDE. so you can import and existing project and run it.
