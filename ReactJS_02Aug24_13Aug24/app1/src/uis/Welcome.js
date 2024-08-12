import {Component} from 'react';

class Welcome extends Component {
    constructor(){
        super();
        this.state = {
            userName: "SomeBody"
        }
    }

    changeUserName = event => {
        let unm = prompt("Your Name Please..!?",this.state.userName);
        if(unm){
            //this.state.userName = unm; is not possible as the state is immutable
            this.setState({userName:unm});
        }
    }

    render(){
        return (
            <section className='container'>
                <h3>Welcome {this.state.userName} </h3>
                <button type='button' onClick={this.changeUserName}> Not My Name? </button>
            </section>
        );
    }
}

export default Welcome;