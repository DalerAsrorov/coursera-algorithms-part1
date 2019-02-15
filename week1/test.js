const QuickFind = require('./QuickFind');

const N = 10;
let qf = new QuickFind(N);

qf.union(0, 2);
qf.union(2, 5);
console.log(qf.connected(0, 7)); // false
qf.union(5, 7);
console.log(qf.connected(0, 7)); // true
