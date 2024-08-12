import {useState} from 'react';

const ContactForm = ({c,save,cancel}) => {

    let [id, setId] = useState(c?c.id:0);
    let [fullName,setFullName] = useState(c?c.fullName:"");
    let [mobile,setMobile] = useState(c?c.mobile:"");
    let [mailId,setMailId] = useState(c?c.mailId:"");
    let [dob,setDob] = useState(c?c.dob:"");

    let isEditable = c ? true : undefined;

    const formSubmitted = event => {
        event.preventDefault();
        save({id,fullName,mobile,mailId,dob});
        if(!isEditable) {
            clearAll(); // to clear the form for another new record.
        }
    };

    const clearAll =() => {
        setId(0);
        setFullName("");
        setMobile("");
        setMailId("");
        setDob("");
    }

    const formReset = event => {
        isEditable ? cancel(id) : clearAll();
    };

    return (
        <form className='row border-bottom border-primary p-2 text-center' onSubmit={formSubmitted}>
            <div className='col-1 text-end'>
                {id}
            </div>
            <div className='col text-start'>
                <input type="text" placeholder="Full Name" className="form-control" 
                value={fullName} onChange={e => setFullName(e.target.value)}/>
            </div>
            <div className='col-2'>
                <input type="text" placeholder="Mobile Number" className="form-control" 
                value={mobile} onChange={e => setMobile(e.target.value)}/>
            </div>
            <div className='col-2'>
                <input type="text" placeholder="Mail Id" className="form-control" 
                value={mailId} onChange={e => setMailId(e.target.value)}/>
            </div>
            <div className='col-2'>
                <input type="date" placeholder="Date Of Birth" className="form-control" 
                value={dob} onChange={e => setDob(e.target.value)}/>
            </div>
            <div className='col-2'>
                <button className="btn btn-sm btn-primary me-1" >SAVE</button>
                <button type="button" className="btn btn-sm btn-danger" onClick={formReset}>CANCEL</button>
            </div>
        </form>
    );
};

export default ContactForm;