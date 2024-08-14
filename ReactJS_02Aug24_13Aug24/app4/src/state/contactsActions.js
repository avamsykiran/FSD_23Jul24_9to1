
import axios from 'axios';

const api = "http://localhost:9999/contacts";

//declare action types

export const CONTACTS_WAIT = "Contact Wait";
export const CONTACTS_ERR = "Contact Error";
export const CONTACTS_REFRESH = "Contact Refresh";
export const EDIT_CONTACT = "Edit Contact";
export const UNEDIT_CONTACT = "UnEdit Contact";

//declare action creators -- here an action is an object
export const createContactsErrorAction = errMsg => ({ type: CONTACTS_ERR, errMsg });
export const createContactsRefreshAction = contacts => ({ type: CONTACTS_REFRESH, contacts });
export const createContactsWaitAction = () => ({ type: CONTACTS_WAIT });
export const createEditContactAction = id => ({ type: EDIT_CONTACT, id });
export const createUnEditContactAction = id => ({ type: UNEDIT_CONTACT, id });

//declare thunk action creators -- here action is a function

export const createLoadContactsAction = () => (dispatch => {
    dispatch(createContactsWaitAction());
    axios.get(api)
        .then(resp => dispatch(createContactsRefreshAction(resp.data)))
        .catch(resp => { console.error(resp); dispatch(createContactsErrorAction("Unable to load data! Please retry later!")); });
});

export const createAddContactAction = contact => (dispatch => {
    dispatch(createContactsWaitAction());
    axios.post(api,contact)
        .then(resp => dispatch(createLoadContactsAction()))
        .catch(resp => { console.error(resp); dispatch(createContactsErrorAction("Unable to save data! Please retry later!")); });
});

export const createUpdateContactAction = contact => (dispatch => {
    dispatch(createContactsWaitAction());
    axios.put(api+"/"+contact.id,contact)
    .then(resp => dispatch(createLoadContactsAction()))
    .catch(resp => { console.error(resp); dispatch(createContactsErrorAction("Unable to save data! Please retry later!")); });
});

export const createDeleteContactAction = id => (dispatch => {
    dispatch(createContactsWaitAction());
    axios.delete(api+"/"+id)
    .then(resp => dispatch(createLoadContactsAction()))
    .catch(resp => { console.error(resp); dispatch(createContactsErrorAction("Unable to delete data! Please retry later!")); });
});
