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
- [Primitive QuickFind implementation]('./QuickFind.js)
