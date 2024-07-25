Java 17
------------------------------------------------------------------------------------------------------------------

  OOPs
    Class & Objects
    Encapsulation
    Polymorphisim
    Inheretence
    Abstraction

        1. a class can be made abstract my marking it 'abstract'.
        2. such class can not be allocated an object.
        3. an abstract class can have an abstract method but not a must.


        School Automation System
            Models / Domain Objects
                abstract class Person              id,fullName,contctNumber,weight,height,bloodGroup
                |
                |-    Student         clazz,section
                |-    Teacher         salary,subject
                |-    Staff           salary,designtion
                |-    Parents         

        1. a method that is not implemented is to be marked as 'abstract'
        2. only abstract classes and interfaces can host abstract methods
        3. sub class derived from abstract classes or interfaces must ovveride all the abstract methods failing which, the 
                sub class also must be marked 'abstract'

            'abstract method' is a common behaviour but has multiple implementations.

        abstract classes vs interfaces

            1. abstract classes do not support multiple inheretence but an interface does.
            2. interfaces can not host fields but an abnstract class does.

            ** from java 8 onwards, interfaces can host non-abstract methods like default-methods and static-methods.

            Classes are ment to model Entities
            Imterfaces are ment to represent Roles

            abstract class Animal
                            |
                            |- class MaleAnimal         <=========== Father, Sibling
                            |- class FemaleAnimal       <=========== Mother, Sibling
                            |- class TransgenderAnimal  <=========== Sibling

            abstract class Bird
                            |
                            |- class MaleBird           <=========== Father, Sibling
                            |- class FemaleBird         <=========== Mother, Sibling
                            |- class TransgenderBird    <=========== Sibling

            interface Father
            interface Mother
            interface Sibling

  JDK 5 to JDK 17 Features
  -----------------------------------------------

    1. Enhanced For Loop (JDK 5)
    2. Generics (JDK 5)
    3. Functional Interfaces, Lambda Expression (JDK 8)
    4. Streams API (JDK 8)
    5. Concurrency (JDK 8)
    6. NIO (JDK 8)
    7. Date Time API (JDK 8)
    8. RegEx (JDK 8)
    9. Open JDK (JDK 11)
    10. New String Methods lines(), strip(), isBlank() (JDK 11)
    11. New Files Methods (JDK 11)
    12. Collection::toArray (JDK 11)
    13. Predicate::not (JDK 11)
    14. var keyword (JDK 11)
    15. HttpClient (JDK 11)
    16. Text Blocks (JDK 17)
    17. Improved Switch Statement (JDK 17)
    18. 'record' Type (JDK 17)
    19. 'sealed' and 'non-sealed' classes
    20. 'instanceof' with patttern matching
  
  InBuilt Packages
  ---------------------------------------------

    java.lang

        Object              hashcode(),toString(),equals(Object)
        Class               forName(), AnyClass.class is an object of java.lang.Class

        System              in,out,err, gc(), runtime(), exit(int), identityHashCode(), ....etc.,
        Math                

        String        
                            String s = null;
                            String s1 = "";
                            String s2 = " ";
        StringBuffer
        StringBuilder

        Byte
        Short
        Integer
        Float
        Double
        Character
        Void
        Number

        Exception Handling
        -------------------------------------------  

              Throwable (i)
                  |- Exception
                  |   |- CHECKED_EXCEPTIONS         compiler will check if the exception is handled, if not a compiler errors is raised.
                  |   |
                  |   |- RuntimeException
                  |       |-UN_CHECKED_EXCEPTIONS   compiler will not check if the exception is handled
                  |
                  |- Error

              UN_CHECKED_EXCEPTIONS must be avoided but not handled.

                  public void raiseSalary(Employee emp,double percent){
                    if(emp!=null){ //avoiding NullPointerException rather than to wait for it and handle
                      emp.setSalary(emp.getSalary() + (emp.getSalary()*percent));
                    }
                  }

              CHECKED_EXCEPTIONS  can not be avoided and must be handled using..

                try-with-multiple-catch

                  try{

                  }catch(ExceptionType1 exp){

                  }catch(ExceptionType2 exp){

                  }catch(ExceptionType3 exp){

                  }finally {

                  }

                try-with-multiCatch

                  try{

                  }catch(ExceptionType1 | ExceptionType2 | ExceptionType3 exp){

                  }finally {

                  }

                try-with-resources

                  try( /*ClosableResources are declared here... */ ){

                  }catch(ExceptionType1 | ExceptionType2 | ExceptionType3 exp){

                  }

            'throw'   is used to raise an exception

            'throws'  is used to transfer the exception from a method to its caller method.
              
        Runnable
            |- Thread
    
    java.time

      Temporal
        |-  LocalDate         .now(),.of(year,Month,day)
        |-  LocalTime         .now(),.of(hour,min,sec)
        |-  LocalDateTime     .now(),.of(year,Month,daym,hour,min,sec)
        |-  ZonedDateTime     .now(zoneId)
      
        common instance methods
            equals,isBefore,isAfter
            plusDays,plusHours,plusYears ...etc.,
            minusDays,minusHours,minusMonths ...etc.,
            getYear,getHours,getDay ....etc.,
            toString,format(DateTimeFormatter),parse(String)

      DateTimeFormatter       .ofPattern("date and time pattern")


      Duration    .between(startTime,endTime)
      Period      .between(startDate,endDate)

            toHours,toYears,toMonths,toMillSecs ...etc.,

    java.util
    java.util.regex
    java.util.function
    java.util.stream

    java.io
    java.nio
    