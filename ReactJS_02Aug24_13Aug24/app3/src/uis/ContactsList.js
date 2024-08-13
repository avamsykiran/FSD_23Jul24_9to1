import { useSelector } from 'react-redux';
import ContactsHeader from './ContactsHeader';
import ContactRow from './ContactRow';
import ContactForm from './ContactForm';

const ContactsList = () => {

    let contacts = useSelector(state => state.contacts);

    return (
        <section className="container-fluid p-2">
            <section className="col-11 mx-auto border border-primary p-4">
                <h4>Contacts List </h4>

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