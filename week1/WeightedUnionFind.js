module.exports = class WeightedQuickUnionUF {
  constructor(N) {
    this.ids = new Array(N);
    this.sz = new Array(N);
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
      
    if (i == j) return;

    if (this.sz[i] < this.sz[j]) {
      this.ids[i] = j;
      this.sz[j] += this.sz[i];
    } else {
      this.ids[j] = i;
      this.sz[i] += this.sz[j];
    }
  }
};
