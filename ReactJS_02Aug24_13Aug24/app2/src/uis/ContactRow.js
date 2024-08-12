
const ContactRow = ({ c, del,edit }) => (
    <div className='row border-bottom border-primary p-2 text-center'>
        <div className='col-1 text-end'>{c.id}</div>
        <div className='col text-start'>{c.fullName}</div>
        <div className='col-2'>{c.mobile}</div>
        <div className='col-2'>{c.mailId}</div>
        <div className='col-2'>{c.dob}</div>
        <div className='col-2'>
            <button type="button" className="btn btn-sm btn-secondary me-1" onClick={e => edit(c.id)}>EDIT</button>
            <button type="button" className="btn btn-sm btn-danger" onClick={e => del(c.id)}>DELETE</button>
        </div>
    </div>
);

export default ContactRow;