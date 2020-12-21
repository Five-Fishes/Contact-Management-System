# Contact-Management-System

## JDK version
The application must be able to function as intended in JDK 8

## Dev Environment Setup
### Intellij
1. Go to `File > Project Structure` 
2. All subsequent actions are perfomed in the pop up appeared
3. go to `project` tab
    - configure `Project SDK` as 1.8
    - configure `Project Language level` as 8
    - configure `Project complier output` as `Contact-Management-System\build` directory
4. go to `modules` tab
    - select the `src` folder, mark it as `Sources` (blue in color)
    - select the `build` folder, mark it as `Excluded` (orange in color)
5. go to `libraries` tab
    - click the `+` (add icon), then select `Java`
    - in the pop up, select the `swingx-all-1.6.4.jar` file at `Contact-Management-System\dist\lib\swingx-all-1.6.4.jar`    
6. to run the application, go to `ContactManagementSoftware.java` and run the `main` method

### Others
1. just set JDK version to JDK 8 
2. remember to import `dist > lib > swingx-all-1.6.4.jar` as the external libary
