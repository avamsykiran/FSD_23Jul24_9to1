import { Component } from 'react';

class Loan extends Component {
    constructor() {
        super();
        this.state = {
            loanAmount: 0,
            roi: 0,
            timePeriod: 0,
            simpleInterest: 0,
            payableAmount: 0
        }
    }

    compute = event => {
        let { loanAmount, roi, timePeriod } = this.state;
        let si = (loanAmount * roi * timePeriod) / 100;
        let pa = loanAmount + si;

        this.setState({ simpleInterest: si, payableAmount: pa });
    }

    render() {

        let { loanAmount, roi, timePeriod, simpleInterest, payableAmount } = this.state;

        return (
            <section className='container'>
                <h3>Loan Compute </h3>
                <form>
                    <div>
                        <label for="tb1">Loan Amount</label>
                        <input type='number' id='tb1' value={loanAmount}
                            onChange={e => this.setState({ loanAmount: Number(e.target.value) })} />
                    </div>
                    <div>
                        <label for="tb2">Rate Of Interest</label>
                        <input type='decimal' id='tb2' value={roi}
                            onChange={e => this.setState({ roi: Number(e.target.value) })} />
                    </div>
                    <div>
                        <label for="tb3">Time Period</label>
                        <input type='number' id='tb3' value={timePeriod}
                            onChange={e => this.setState({ timePeriod: Number(e.target.value) })} />
                    </div>
                    <div>
                        <button type='button' onClick={this.compute}> Compute </button>
                    </div>
                </form>

                <div>
                    <p>Simple Interest to be paid is <strong>{simpleInterest}</strong></p>
                    <p>Total Amount to be paid is <strong>{payableAmount}</strong></p>
                </div>
            </section>
        );
    }
}

export default Loan;