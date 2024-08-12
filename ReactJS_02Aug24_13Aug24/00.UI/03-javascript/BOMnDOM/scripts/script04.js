const calculateEMI = event =>  {
 
    let loanAMT = document.querySelector("#loanAmt");
    let roI = document.querySelector("#roi");
    let termEMI = document.querySelector("#emis");
 
    let loanAmount = Number(loanAMT.value);
    let rateOfInterest = Number(roI.value);
    let noOfEMI = Number(termEMI.value);
 
    let emiAmt = (loanAmount*rateOfInterest*noOfEMI)/100 ;
 
    document.querySelector("#emi").innerHTML = "Simple Interest: " + emiAmt;
 
}
