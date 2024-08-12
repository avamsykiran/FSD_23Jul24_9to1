import { useState } from 'react';
import ContactsHeader from './ContactsHeader';
import ContactRow from './ContactRow';
import ContactForm from './ContactForm';

const ContactsList = () => {

    let [contacts, setContacts] = useState([
        { id: 1, fullName: "Vamsy Kiran", mobile: "9052224753", mailId: "vamsy@gmail.com", dob: "1985-06-11" },
        { id: 2, fullName: "KGN Murthy", mobile: "9052224751", mailId: "murthy@gmail.com", dob: "1975-06-11" },
        { id: 3, fullName: "Suresh P", mobile: "9052224752", mailId: "suresh@gmail.com", dob: "1977-06-11" },
        { id: 4, fullName: "Ramesh P", mobile: "9052224754", mailId: "ramesh@gmail.com", dob: "1973-06-11" },
        { id: 5, fullName: "Krishna M", mobile: "9052224755", mailId: "kirshan@gmail.com", dob: "1984-06-11" }
    ]);

    let [nextId,setNextId] = useState(6);

    const addContact = contact => {
        contact.id = nextId;
        setNextId(nextId+1);
        setContacts([...contacts,contact]);
    };

    const deleteById = id => {
        setContacts(contacts.filter(c => c.id!==id));
    };

    const edit = id => {
        setContacts(contacts.map( c => c.id===id? {...c,isEditable:true} : c));
    };

    const unEdit = id => {
        setContacts(contacts.map( c => c.id===id? {...c,isEditable:undefined} : c));
    };

    const updateContact = contact => {
        setContacts(contacts.map( c => c.id===contact.id? {...contact,isEditable:undefined} : c));
    }

    return (
        <section className="container-fluid p-2">
            <section className="col-11 mx-auto border border-primary p-4">
                <h4>Contacts List </h4>

                <ContactsHeader />

                <ContactForm save={addContact} />

                {
                    contacts && contacts.length > 0 && (
                        contacts.map(c => c.isEditable? 
                            <ContactForm c={c} key={c.id} save={updateContact} cancel={unEdit} /> :     
                            <ContactRow c={c} key={c.id} del={deleteById} edit={edit} />
                        )
                    )
                }
                
            </section>
        </section>
    );
};

export default ContactsList;