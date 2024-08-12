const WelcomeFC = () => {

    let [userName, setUserName] = useState("SomeBody");

    return (
        <section className='container'>
            <h3>Welcome {userName} </h3>
            <form>
                <div>
                    <label for="unm">Yoour Name Please</label>
                    <input type='text' id='unm' value={userName}
                        onChange={e => setUserName(e.target.value)} />
                </div>
            </form>
        </section>
    );
}

export default WelcomeFC;