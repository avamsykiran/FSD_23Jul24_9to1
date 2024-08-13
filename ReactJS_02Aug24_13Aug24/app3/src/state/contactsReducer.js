import { ADD_CONTACT, DEL_CONTACT, EDIT_CONTACT, UNEDIT_CONTACT, UPD_CONTACT } from "./contactsActions";

const initalState = () => ({
    contacts: [
        { id: 1, fullName: "Vamsy Kiran", mobile: "9052224753", mailId: "vamsy@gmail.com", dob: "1985-06-11" },
        { id: 2, fullName: "KGN Murthy", mobile: "9052224751", mailId: "murthy@gmail.com", dob: "1975-06-11" },
        { id: 3, fullName: "Suresh P", mobile: "9052224752", mailId: "suresh@gmail.com", dob: "1977-06-11" },
        { id: 4, fullName: "Ramesh P", mobile: "9052224754", mailId: "ramesh@gmail.com", dob: "1973-06-11" },
        { id: 5, fullName: "Krishna M", mobile: "9052224755", mailId: "kirshan@gmail.com", dob: "1984-06-11" }
    ],
    nextId:6
});

const contactsReducer = (state = initalState(),action) => {

    let {contacts,nextId} = state;
    
    switch(action.type){

        case ADD_CONTACT: 
            action.contact.id=nextId;
            nextId = nextId+1;
            contacts = [...contacts,action.contact];
            break;

        case UPD_CONTACT: 
            contacts = contacts.map(c => c.id===action.contact.id?{...action.contact,isEditable:undefined}:c)
            break;

        case DEL_CONTACT: 
            contacts = contacts.filter(c => c.id!=action.id);
            break;

        case EDIT_CONTACT: 
            contacts = contacts.map(c => c.id!=action.id?c:{...c,isEditable:true})
            break;
        
        case UNEDIT_CONTACT: 
            contacts = contacts.map(c => c.id!=action.id?c:{...c,isEditable:undefined})
            break;
    }

    return {contacts,nextId};
};

export default contactsReducer;