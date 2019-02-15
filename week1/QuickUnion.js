module.exports = class QuickUnionUF {
  constructor(N) {
    this.ids = new Array(N);
    for (let i = 0; i < N; i++) {
      this.ids[i] = i;
    }
  }
  
  // chase parent pointers until we reach the root
  // (depth of i array accesses)
  root(i) {
    while(i != this.ids[i]) {
      i = this.ids[i];
    }
    return i;
  }

  connected(p, q) {
    return this.root(p) == this.root(q);
  }

  union(p, q) {
    let i = this.root(p);
    let j = this.root(q);
    
    this.ids[i] = j;
  }
};
