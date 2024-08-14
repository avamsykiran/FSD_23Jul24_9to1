import { useEffect } from 'react';
import { useSelector,useDispatch } from 'react-redux';
import { createLoadContactsAction } from '../state/contactsActions'
import ContactsHeader from './ContactsHeader';
import ContactRow from './ContactRow';
import ContactForm from './ContactForm';

const ContactsList = () => {

    const dispatch = useDispatch();

    useEffect(() => {
        dispatch(createLoadContactsAction());
    },[]);

    let contacts = useSelector(state => state.contacts);
    let wait = useSelector(state => state.wait);
    let errMsg = useSelector(state => state.errMsg);

    return (
        <section className="container-fluid p-2">
            <section className="col-11 mx-auto border border-primary p-4">
                <h4>Contacts List </h4>

                { wait && <div className='alert alert-info fw-bold p-4'>Please wait while working with the server...!</div> }
                
                { errMsg && <div className='alert alert-danger fw-bold p-4'>{errMsg}</div> }

                <ContactsHeader />

                <ContactForm />

                {
                    contacts && contacts.length > 0 && (
                        contacts.map(c => c.isEditable ? <ContactForm c={c} key={c.id} /> : <ContactRow c={c} key={c.id} />)
                    )
                }

            </section>
        </section>
    );
};

export default ContactsList;