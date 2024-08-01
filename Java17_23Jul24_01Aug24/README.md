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

      Random
      Scanner
      
      Collections (class)

      Collection (i)                  add,remove,contains,size,isEmpty,stream
        |
        |- List  (i)                  is a linear datastructure representation
        |                             the elements position is numbered or indexing is possible
        |                             duplicate ele are allowed
        |
        |   |- ArrayList              is a growable array
        |   |- Vector                 is a synchronized growable array
        |   |- LinkedList             is a doublly linked list implementation
        |
        |- Set                        is a non-linear datastructure representation
        |                             no duplicates allowed here
        |   
        |   |- HashSet                unknown oreder of retrival
        |   |- LinkedHashSet          insertion order of retrival
        |   |- TreeSet                sorted order of retrival

      Map (i)                         a collection of key-value pairs, key must be unique
        |                             put(k,v),set(k,v),containsKey,containsValue,keys,size,isEmpty,remove(k)
        |
        |- HashMap                    unknown oreder of retrival
        |- LinkedHashMap              insertion order of retrival
        |- TreeMap                    sorted order of retrival

      java.lang.Comparable            int compareTo(Object)

                                      Comparable interface is expected to be implemented by the model class itself,
                                      that means the object of the model will be an object of the Comparable interface

                                      obj1.compareTo(obj2)

                                          obj1>obj2, the method has to return a positive val
                                          obj1-obj2, the method has to return a zero
                                          obj1<obj2, the method has to return a negative val

      Comparator                      int compare(obj1,obj2)

    java.util.regex

      java.lang.String :: matches

      Pattern
      Matcher

    java.util.function

      Funtional Interfaces are interfaces having only one abstract method.

      Lambfds Expression is sued to implement and instantiate a funtional interface.
      A Lambda Expression is a mapping from the params to a return value or an implementation using '->' the arrow operator.

      Method Referencing will allow to pass teh reference of a method into a functional interface reference.

        FunctionalInterfaceName obj = AnyClass::methodName;

      Supplier      the abstract method of the interface is returning a value but doesn't have any args.
      Consumer      the abstract method of the interface is not returning any value but has args.
      Predicate     the abstract method of the interface is returning a boolean
    
    java.util.stream

      a stream is a flow of data.

      [ data-source ] <------stream-----> [ terminal ]

      data-source can be an array/ a list/ a set or a simple comman seperated values

      terminal can be a list/ a set/ or nothing.

      [ data-source ] 
          <------stream----->  operation 1
                                 <------stream-----> operation 2
                                                        <------stream-----> operation 3
                                                                                <------stream----->
                                                                                                [ terminal ]

      
      each operation is represented by a function

      Stream        represents a stream of data

                    Stream s1 = Stream.of(obj1,obj2,obj3....);
                    Stream s2 = Arrays.stream(array);
                    Stream s3 = list.stream();
                    Stream s4 = set.stream();

                    forEach(consumer)
                        executes the given consumer on each and every element of the stream.
                        forEach returns nothing, and hence is a terminal operation.

                    collect(collector)
                        is used to collect all the elements of a stream into a list or a set or a map.
                        collect returns a Collection, and hence is a terminal operation.

                    reduce(binaryOperator)
                        is going to reduce the entire stream into one element, and hence is a terminal operation.

                        assuming a stream has five elements, the reduce works like this..,                          
                          binaryOperator(binaryOperator(binaryOperator(binaryOperator(ele1,ele2),ele3),ele4),ele5) gives one single value

                        eg:
                          Stream s1 = Stream.of(1,2,3,4,5);
                          BinaryOperator sum = (x,y) -> x+y;
                          int s = s1.reduce(sum); //s will be 15

                    filter(predicate)
                        filter returns a new stream having only those elements of the current stream that satisfy the predicate.
                        as the filter returns a new stream, other operations can be chained and hence is called a intermidiate operation.

                        eg:
                          Stream s1 = Stream.of(1,2,3,4,5);
                          int result = s1.filter( x -> x%2==0 ).reduce( (a,b) -> a+b ); // result will be 6

                    map(transformer)
                        transformer is any function that accepts a value and converts that into another value.
                        eg. Math::sqrt  is a transformer as it convert a number inot its square root.

                        map return a new stream of all teh result of the transformer once it is invoked on each ele of teh current stream.
                        as the map returns a new stream, other operations can be chained and hence is called a intermidiate operation.

                        eg:
                          Stream s1 = Stream.of(1,2,3,4,5);
                          s1.map( x -> x*x ).forEach(System.out::println); // 1,4,9,16,25 is printed.

    java.io

      Binsry Streams

        InputStream                       OutputStream
          |                                   |
          |- FileInputStream                  |- PrintStream
          |- ByteInputStream                  |- FileOutputStream
          |- DataInputStream                  |- DataOutputStream

      
      Character / Text Streams

        Reader                            Writer
          |                                   |
          |- FileReader                       |- FileWriter
          |- InputStreamReader                |- PrintWriter
          |- BufferedReader

    java.nio

      Path
      Paths

      Files
      Directories

      Channels
        are similar to io-streams, as they carry data. The major enhancement is that a single channel
        can be used for both reading and writing unlike the streams.

      Buffers
        a channel is always connected to a buffer, where a buffer is a memory block that can allow a channel
        to pull data or allow a channel to push data. 

        Each buffer has a capacity, limit and position.

        Capacity is the maximum count of bytes/ints/chars ..etc that a buffer can hold.
            
            IntBuffer buf = IntBuffer.allocate(1024);

        Position is the cell at which the write or read happended on a buffer. Initially
        the position is 0. The position is advacned after each read or write.

        Limit is the last position that is read or written.

        A buffer has two modes read and write, using .flip() method, we can switch between
        read and write modes.

        buf.put() is used to put one int/byte/char ..etc into a buffer and buf.get() is used to read mannually.

        channel.read(buf) and channel.write(buf) are used to read and write from and into a buffer.

        buf.clear() is going clear the buffer and make it ready for a fresh writing.

      Scatter - Gather
      Selectors

Multi-Threading and Concurrency
---------------------------------------------------------------------

  A process is an active program and a program is a passive process. Each process has
  a heap, a stack, a programCounter and a few registries.
  
  A Thread is a light-weight process with a shared heap.

  Multi-Thread is to have multiple threds having common heap facilitating, inter thread communication.

  For example, a Thread A can randomly generate integers into an array and another Thread B can
  read from that array. The array (created in the heap) is shared between the threads.

  Java is my default mutli-threaded. Each and every java program is spanned inside a thread.

  java.lang.Runnable                      void run()
              |
              |- java.lang.Thread
                                          Thread()
                                          Thread(Runnable job)
                                          Thread(String name)
                                          Thread(Runnable job,String nmae)

                                          String getName();
                                          void setName(String);
                                          int getPriority();
                                          void setPriority(int);
                                          void start();
                                          void join();
                                          static void sleep(long ms);
                                          static Thread currentThrread();

      new Thread(....)
            ↓
          .start()  
            ↓
          [ READY STAGE .. ] ----- the CPU and other resources when available --------|
                ↑                                                                     |
                |                                                                     |  
                |                                                                     ↓
            [ PAUSED STAGE ]---------- .sleep(ms)-------------------------- [RUNNING STAGE ... .run() ]  
                                                                                      |
                                                                                      | once run method is done
                                                                                      ↓
                                                                               [ TERMINATION ]

    resource is any object that is being accessed in the 'run()' method.
    
    Synchronization is also called monitor and lock. It basically is to allow only one thread
    to access a piece of code while other threads are made to wait if wanting to do the same.

      synchronized block

        synchronized(obj) {
          //as and when this block starts execution
          //the obj-in-the-block is locked, meaning no thread can call
          //any method on that object until this block completes.
        }

      synchronized methods

        public synchronized returnType methodName(paramList) {
          //as and when this methods starts executing
          //no other synchronized method of 'this' object can be invoked
          //from any where of the application until the completion of this method
        }

      synchronized static methods

        public static synchronized returnType methodName(paramList) {
          //as and when this methods starts executing
          //the .class object of the current class is locked
          //meaning no other static method of this class can be invoked and
          //we can not create an object of this class until the current method completes.
        }

  Concurrency
  -----------------------------------------------------

    Concurrency is an extension to multi-threading.

    Multi-Threading is a way to achive asynchronous programming.

    Concurrecny api offered in Java is a machanisim to provide auto managed threads via ThreadPools.

    Concureency api defines three important components for asynchronosu programming,

      Tasks       the job to be done and is represented by 
                  Runnable      void run()    doesn't return any value and can not throw checked exceptions
                  Callable      T call()      can return a value and can throw an Excpetion

      Workers     is the one who does the job, that's the Thread .

      Excutors    are the ones who manage the taska dn threads in a thread pool.
                  Executor (i)
                    |- ExecutorService (i)
                    |- ScheduledExecutorService (i)

    ExecutorService

        1. To create an object of ExecutorService, 
              we have a very long list of implementation classes.
              We also have Executors (a utility class) with static mehtods to create an obj of ExecutorService.

              ExecutorService exeService = Executors.newSingleThreadExecutor();

        2. To assign jobs to the ExecutorService

            exeService.execute(aTask);                does not return anything irrespective of the job being Runnable or Callable
            exeService.submit(aTask);                 returns a obj of Future, through which we can check the task status and get result
            exeService.invokeAny(aCollectionOfTasks); returns a obj of Future related to the first completing Task
            exeService.invokeAll(aCollectionOfTasks); returns a list of objs of Futures realated to all Tasks.

        3. Shutdown the ExecutorService

            if we do not shutdown an ExecutorService, it willbe active even after
            completing all the assigned tasks, watiing for new tasks to be assgined.

            exeService.shutdown();      will stop accepts new tasks, waits all assigned tasks are complete and then shuts down
            exeService.shutdownNow();   tries to shut down immidiately, but does not guarentee that all
                                        the currently running threads are stopped. it will not
                                        accept new taksa and will not start executing tasks that are in queue. 
                                        And returns a List<Runnable> of notExecutedTasks

    Future

      is an interface that represents the result of a task.  

        Future future = exeService.submit(aTask);

        var result = future.get();                        will block the main Thread until the underlying task is complete
        var result = future.get(timeAmount,timeUnit);     will block the main Thread until the underlying task is complete 
                                                          or until the timeOut, whichever is earlier.

        future.isDone();
        future.cancel();
        future.isCanceled();
    
    ScheduledExecutorService 

      ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

      Future future  = executorService.schedule(task, timeAmount, timeUnit);   
          The given task is executed after the givne timeout.
      
      executorService.scheduleAtFixedRate(task, initialDelay, periodicDelay,timeUnit);   
          The given task is executed after the initialDelay of time and after that the task is repeatedly
          executed for every periodicDelay of time.
      


    



