ReactJS
--------------------------------------------------------------------

    Single Page Application

        is a web application that has only one html page and a lots of JavaScript.

        Server                                  Client
            spa-bundle
            (index.html + *.js)
                <-------------REQ-----------------
                ------------(spa-bundle) Resp----->
                                                        index.html along with the .js is loaded.

                                                        any processing / event handling/ links
                                                        all of that is done by the JS on the client itself.

                                                        the JS on the cleitn will generate the needed html
                                                        content dyna,ically and will replace it wiht
                                                        the content of the index.html page.

            rest-api    <---------(.xml/.json)------>   for data operations.

    Developing SPA, we ahve 
        Angular, AngularJS, ReactJS, VueJS, NextJS ...etc., as Frameworks.

    Javascript is a scripting language and is never compiled into any byte code. JavaScript
    is executed by either a browser or NodeJS.

    Browser is used to execute javascript alongside some html UI.
    NodeJs is used to execute javascript without any UI.

    NodeJS
    ------------

        is an alternate runtime for Javascript. It executes any script written in
        JavaScript as long as it has nothing to do with any UI.

        http://nodejs.org

        node --version

        node script.js

    Lab Setup
    ------------------

        NodeJS
        Chrome
        VSCode

    Why NodeJS for spa ?
    ----------------------
        An application development involves a varity of operations like
            
            Composimg the code              IDE                             VSCode
            Managing Dependencies           Build Tool                      npm
            Building and Packing            Build Tool                      npm
            Testing                         Testing Framework               jasmine
            Devployment                     Development Http Server         react - dev - server
            Execution                       Browser                         chrome

            tools like npm or jasmine or dev-server are to executed on the developer machine
            and they do not have any UI, thus we need NodeJS to run these tools.

    Node Project
    --------------------

        to create a project on node
            1. create a folder with proj name
                md app-name
            
            2. we have to initiate the build tool, this creates a package.json fiel in the app folder
                cd app-name
                npm init -y
            
            3. the package.json offer project meta-date, scripts and dependencies sections
                the meta-data section contain project name, versionb, keywords, author ...etc.,
                the dependencies section will list he thrid part livraries (packages) and their version
                the scripts section offers macro script for starting the project, build the project ..etc.,

        to iunstall a thrid party library (package) into our app
            
            npm i package-name@version

            for example, npm i bootstrap

        to remove a package from our project
            
            npm uninstall package-name

        to install a package globally to be used across all the projects on this computer

            npm i -g package-name
        
    React Features
    -------------------------

        1. React offers HTML extendability. (meaning, we can create our own html elements and attributes).
        2. React supports JSX for html content management. (DOM Manipulation).
        3. The amount of code to produce a result in react is pretty less in comparision to its competitors.

    JSX - JavaScript eXtended
    ---------------------------

        It is html embeded into javascript.

        1. JSX is case sensitive and it is expected that all html elements are lower case.
        2. 'class' is a keyword in JS, thus 'class' attribute can not be used in JSX , instead 'className' must be used.
        3. {} is used to interpolate any javascript expression inside the html. And this expression msut evalaute to
            a number or a string or a boolean or an html element or an array of html elements.     

        JS
            let unm = "Vamsy Kiran";
            let para = document.createElement("p");
            para.innwerHTML = "Hello " + unm ;

        JSX 
            let unm = "Vamsy Kiran";
            let para = <p> Hello  {unm} </p>

        JS
            let friends = ["Vamsy","Murthy","Suresh","Ramesh"];
            let olObj = document.createElement("ol");

            friends.forEach(
                frd => {
                    let liObj = document.createElement("li");
                    liObj.innerHTML = frd;
                    olObj.append(liObj);
                }
            );
        
        JSX
            let friends = ["Vamsy","Murthy","Suresh","Ramesh"];
            let olObj = (
                    <ol>
                        { friends.map( frd => <li> {frd} </li> ) }
                    </ol>
                );

    Creating a React App
    ---------------------------

        npx create-react-app app-name

        (or)

        npm i -g create-react-app
        create-react-app app-name

    React Component
    ----------------------------

        Html elements created in ReactJS are called React Components. These Component names
        must be inital capatilized.

        App Structure:
            index.html
                |-body
                    |- div#root
                        |-<App />
                            |- <Component1 />
                            |       |- <Component3 />
                            |- <Component2 />

        Function Components

            is any javascript function that returns html-dom.

                const TitleBar = () => <h3> My Address Book Application </h3> ;

                <TitleBar />

            'props' short for properties is sued to receive data from
            a parent component into a child component via 'attributes'.

        Class Componnets

            is any javascript class that extends React.Component .

            Any class component inherits the following from React.Component 
                1. state
                2. setState()
                3. render()
                4. componentDidMount()
                5. componentDidUpdate()
                6. And a few more life cycle methods.

            state       is an immutable object that holds all the data
                        related to the component.

                        state is continuously monitored for changes
                        and as and when the state changes, 'render()' method
                        is invoked.

                        As state is immutable, we can not modify it
                        but it can be replaced using 'setState()' method.

            render()    should be overriden to return the html-content to be displayed for
                        this component. 

            class Dashboard extends React.Component {
                constructor(){
                    super();
                    this.state = {
                        userName:"Vamsy Kiran"
                    };
                }

                render(){
                    return (
                        <section>
                            <p> Welcome {this.state.userName}! We are happy to have you here. </p>
                        </section>
                    );
                }
            }

            <Dashboard />

        Class Component Life Cycle

            constructor()                   //initialize the 'state'
                ↓
                render()                    //returns the html content to be dispalyed for the component
                    ↓
                    componentDidMount()     //used to process any thing immidiate=ly after the first render
                            ↓
                            /********************************************************/
                        |----→ the component remains idle until any event occurs,
                        |       when a setState() is called
                        |   /********************************************************/
                        |          ↓
                        |          render()   
                        |              ↓
                        |              componentDidUpdate()   //used to process any thing immidiate=ly after each render except the frist
                        |                       ↓
                        -------------------------

    React Hooks
    ----------------------------

        A hook is a special function that is sued to impart a feature to a function component.

        useState            imparts state management in a function component.

                            let [getter,setter] = useState(initlaValue);

                            let [count,setCount] = useState(0);

                            // count gives value and setCount is used to change the value.
                            // each time setCount is called the function component is re-rendered.

        useEffect           imparts life cycle management in a function component.

                            useEffect(callBack,[])

                                This callBack is executed only once after the first render.
                                equivalent to componentDidMount

                            useEffect(callBack,[field1])

                                This callBack is executed after each render except the first time and
                                when the field1 get changed. equivalent to componentDidUpdate

    Integrating ReactJS App with Bootstrap
    -----------------------------------------------

        npm i bootstrap

        node_modules/bootstrap/dist
                                |-css / bootstrap.min.css
                                |-js / bootstrap.bundle.js

        import the above two files into index.js

    Application Level State Management Using Redux
    -------------------------------------------------

        The state of the entire Application is stored and maintained at one location.

        Redux           is one such application level state management tool.

                        npm i redux

                        store           is an immutable object that holds all the state of our APP.
                                        typically one APP has only one Store

                                        const myStore = createStore(myReducer);

                        reducer         is a pure javascript function that accepts the existing state and an action
                                        and return the modified state.

                                        const myReducer = (state, action) => {

                                            //write code to modify the state based on the action.

                                            return modifiedState;
                                        };

                        action          is a javascript object that has an action type and a payload.
                                        the action type informs the reducer what operation needs to done
                                        and the payload is the data carried by the action to complete operation

                                        For Example, to add an employee, action type can be 'ADD' and the emp obj is the payload
                                                    to del an employee, action type can be 'DEL' and the emp id will be the payload.

                        dispatch        is an built-in method created by redux that carries actions from componenets to the reducer.

        React-Redux     is a tool used to integrate redux with react.

                        npm i react-redux

                        Provider        is a component used to wrap the store onto our react top level component.

                                        <Provider store={myStore}>
                                            <App />
                                        </Provider>

                        useSelector    is a hook, use to extract a particular  part of the state.

                                        let emps = useState( state => state.emps );
                                        
                                        let depts = useState( state => state.depts );

                        useDispatch     is a hook, that returns 'dispatch' method related to our reducer and store.

                                        const dispatch = useDispatch();


            store   → ------------------------------|-------------------------------|
             ↑                                      |                               |
             |                                      | useSelector                   | useSelector
             |                                  Component1                      Component2
             |                                      |                               |
             | modified state                       | dispatch(action)              |
             |                                      |                               | dispatch(action)
             |                                      ↓                               ↓
             reducer    ←---------------------------←-------------------------------←