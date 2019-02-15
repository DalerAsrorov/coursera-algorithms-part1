module.exports = class QuickFindUF {
  constructor(N) {
    this.ids = new Array(N);
    for (let i = 0; i < N; i++) {
      this.ids[i] = i;
    }
  }

  connected(p, q) {
    return this.ids[p] === this.ids[q];
  }

  union(p, q) {
    if (p < 0 || q > this.ids.length - 1) {
      console.log('Out of bounds range index specified.');
      return;
    }

    let pId = this.ids[p];
    let qId = this.ids[q];

    for (let i = 0; i < this.ids.length; i++) {
      if (this.ids[i] == pId) {
        this.ids[i] = qId;
      }
    }
  }
};
