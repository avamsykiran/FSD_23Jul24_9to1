
import {Fragment} from 'react';
import MenuBar from './uis/MenuBar';
import ContactsList from './uis/ContactsList';

const App =() => (
  <Fragment>
    <MenuBar appTitle="AddressBook 1.0" />
    <ContactsList />
  </Fragment>
);

export default App;
