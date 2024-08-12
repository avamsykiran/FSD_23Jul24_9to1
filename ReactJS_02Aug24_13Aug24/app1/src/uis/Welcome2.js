import {Component} from 'react';

class Welcome2 extends Component {
    constructor(){
        super();
        this.state = {
            userName: "SomeBody"
        }
    }

    render(){

        let {userName} = this.state;

        return (
            <section className='container'>
                <h3>Welcome {userName} </h3>
                <form>
                    <div>
                        <label for="unm">Yoour Name Please</label>
                        <input type='text' id='unm' value={userName} 
                            onChange={ e => this.setState({userName:e.target.value}) } />
                    </div>
                </form>
            </section>
        );
    }
}

export default Welcome2;