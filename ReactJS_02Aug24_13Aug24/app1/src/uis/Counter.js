import { Component } from 'react';

class Counter extends Component {
    constructor(){
        super();
        this.state={
            itemCount:0,
            packCount:0
        }
    }

    componentDidMount(){
        setTimeout(() => this.setState({itemCount:1}),500);
    }

    componentDidUpdate(){
        let {itemCount,packCount} = this.state;

        if(itemCount<0 && packCount===0){
            this.setState({itemCount:0});
        }else if(itemCount<0 && packCount>0){
            this.setState({itemCount:9,packCount:packCount-1});
        }else if(itemCount===10){
            this.setState({itemCount:0,packCount:packCount+1});
        }
    }

    render(){
        let {itemCount,packCount} = this.state;

        return (
            <section className='container'>
                <h3> {packCount} packs and {itemCount} items </h3>
                <button type='button' onClick={e => this.setState({itemCount:itemCount-1}) }>REMOVE</button>
                <button type='button' onClick={e => this.setState({itemCount:itemCount+1}) }>ADD</button>
            </section>
        );
    }
}

export default Counter;