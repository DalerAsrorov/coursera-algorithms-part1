# Union-Find

## Dynamic Connectivity

- **Union Command** - connect two objects.
- **Find/connected query** - is there a path connecting the two objects.

Two nodes doesn't have to be connected directly. If you can get from one node to another by traversing through the connected components of the graph, from start to finish, then two nodes are connected.

```java
union(x, y) // connects two nodes
connected(x, y) // checks if there is a path from x to y in a connected graph
```

### Modeling connections

- "is connected to" relation has properties
  - Reflexive: p is connected to q.
  - Symmetric: if p is connected to q, then q is connected to p.
  - Transitive: if p is connected to q and q is connected to r, then p is connected to r.
- **Connected components**
  - Maxmal set of objects that are mutually connected
  - Example: 0 => 1, 3, 2 => 5 => 6 => 2
    creates set of objects `{0, 1}, {3}, {2, 5, 6}`.
- in the above, we have 3 connected components.
- components can be merged with `union` operation and decrease number of sets.

## Quick Find

- Eager approach implementation
  - [Eager approach practice](./eager-approach.js)
- [Primitive QuickFind implementation](./QuickFind.js)

## Quick Union
- [Primitive QuickUnion implementation](./QuickUnion.js)

## Weighted Quick Union
- [Implementation]('./WeightedUnionFind.js)
- Modify quick-union to avoid tall trees
- Keep track of the size of each tree (number of objects)
- Balance by linking root of smaller tree to root of larger tree.
  - Reasonable alternatives: union by height or "rank"
- Running Time
  - **Find:** takes time proportional to depth of *p* and *q*
  - **Union:** takes constant time, given roots
 Proposition
  - Depth of any node *x* is at most lg *N*.
## Path compression
- [Implementation]('./CompressedWeightedQuickUnionUF.js)
- Just after computing the root of *p*, set the id of each examined node to point to that root.
```js
  // chase parent pointers until we reach the root
  // (depth of i array accesses)
  root(i) {
    while(i != this.ids[i]) {
      // New line: one-pass variant for compression algorithm
      this.ids[i] = this.ids[this.ids[i]];
      i = this.ids[i];
    }
    return i;
  }
```
## Applications
### Percolation
- A model for many physical systems
  - N-by-N grid of sites
  - Each site is open with probability *p* (or blocked with probability 1 - p)
  - System **percolates** iff top and bottom are connected by open sites. 
- When *N* is large, theory guarantees a sharp threshold *p**
  - When p > p*: almost certainly percolates.
  - When p < p*: almost certainly does not percolate.
  Q: What is the value of *p**?
- **Monte Carlo simulation**
  - Initialize *N*-by-*N* whole grid to be blocked.
  - Declare random sites open until top connected to bottom.
  - Vacancy percentage estimates *p**.
