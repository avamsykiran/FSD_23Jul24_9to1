
export const sum = (a,b) => a+b;
export const dif = (a,b) => a-b;
export const prd = (a,b) => a*b;
export const qut = (a,b) => a/b;
export const rem = (a,b) => a%b;

const doAll = (x,y) => {
    return {sum:sum(x,y),dif:dif(x,y),prod:prd(x,y),qut:qut(x,y),rem:rem(x,y)};
};

export default doAll;

