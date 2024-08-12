import { useEffect, useState } from "react";

const CounterFC = () => {
    let [itemCount,setItemCount] = useState(0);
    let [packCount,setPackCount] = useState(0);

    //componentDidMount
    useEffect(() => {
        setTimeout(() => setItemCount(1),500);
    },[]);

    //componentDidUpdate
    useEffect(() => {
        
        if(itemCount<0 && packCount===0){
            setItemCount(0);
        }else if(itemCount<0 && packCount>0){
            setItemCount(9);
            setPackCount(packCount-1);
        }else if(itemCount===10){
            setItemCount(0);
            setPackCount(packCount+1);
        }

    },[itemCount]);

    return (
        <section className='container'>
            <h3> {packCount} packs and {itemCount} items </h3>
            <button type='button' onClick={e => setItemCount(itemCount-1) }>REMOVE</button>
            <button type='button' onClick={e => setItemCount(itemCount+1) }>ADD</button>
        </section>
    );
};

export default CounterFC;