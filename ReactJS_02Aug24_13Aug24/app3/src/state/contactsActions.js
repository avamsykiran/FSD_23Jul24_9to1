
//declare action types

export const ADD_CONTACT = "Add Contact";
export const UPD_CONTACT = "Update Contact";
export const DEL_CONTACT = "Delete Contact";
export const EDIT_CONTACT = "Edit Contact";
export const UNEDIT_CONTACT = "UnEdit Contact";

//declare action creators

export const createAddContactAction = contact => ({type:ADD_CONTACT, contact});
export const createUpdateContactAction = contact => ({type:UPD_CONTACT, contact});
export const createDeleteContactAction = id => ({type:DEL_CONTACT, id});
export const createEditContactAction = id => ({type:EDIT_CONTACT, id});
export const createUnEditContactAction = id => ({type:UNEDIT_CONTACT, id});
