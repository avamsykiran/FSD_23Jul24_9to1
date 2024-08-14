import {  CONTACTS_ERR, CONTACTS_REFRESH, CONTACTS_WAIT, EDIT_CONTACT, UNEDIT_CONTACT } from "./contactsActions";

const initalState = () => ({
    contacts: null,
    wait:null,
    errMsg:null
});

const contactsReducer = (state = initalState(),action) => {

    let {contacts,errMsg,wait} = state;
    
    switch(action.type){

        case CONTACTS_WAIT:
            wait=true;
            errMsg=null;
            break;
        
        case CONTACTS_ERR:
            errMsg = action.errMsg;
            wait=false;
            break;

        case CONTACTS_REFRESH:
            contacts = action.contacts;
            wait=false;
            errMsg=null;
            break;
            
        case EDIT_CONTACT: 
            contacts = contacts.map(c => c.id!==action.id?c:{...c,isEditable:true})
            break;
        
        case UNEDIT_CONTACT: 
            contacts = contacts.map(c => c.id!==action.id?c:{...c,isEditable:undefined})
            break;
    }

    return {contacts,errMsg,wait};
};

export default contactsReducer;