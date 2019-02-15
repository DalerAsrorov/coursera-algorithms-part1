1. Initial values:
* Each element is a node. None of the nodes are connected initially.
```
 0  1  2  3  4  5  6  7  8  9
[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
```
2. `union(4, 3)`
* Creates an edge between 3 and 4. 3 is a root of 4.
```
 0  1  2  3  4  5  6  7  8  9
[0, 1, 2, 3, 3, 5, 6, 7, 8, 9]
```
3. `union(3, 8)`
* Creates an edge between 3 and 8. 8 becomes a root of 3. Since 4 and 3 are connected and 3 was a root of 4,
then 8 becomes a root of 4 and 3 as well.
```
 0  1  2  3  4  5  6  7  8  9
[0, 1, 2, 8, 3, 5, 6, 7, 8, 9]
```
4. `union(6, 5)`
* Creates an edge between 5 and 6. 5 becomes the root of 6.
```
 0  1  2  3  4  5  6  7  8  9
[0, 1, 2, 8, 3, 5, 5, 7, 8, 9]
```
5. `union(9, 4)`
* After previous steps, we created a graph 8 => 3 => 4.
* The union of 9 and 4 changes the graph to 8 => 3 => 4                                              => 9
* 9 becomes a child of 8. Since both 4 and 9 are children of 8, they are connected.
```
 0  1  2  3  4  5  6  7  8  9
[0, 1, 2, 8, 3, 5, 5, 7, 8, 8]
```
6. `union(2, 1)`
* Created a graph with 1 and 2 vertices connected.
```
 0  1  2  3  4  5  6  7  8  9
[0, 1, 1, 8, 3, 5, 5, 7, 8, 8]
```
7. `connected(8, 9) == true` since both *8* and *9* share same root, *8*
8. `connected(5, 4) == false` since 5's root is *5* and 4's root is *8*.
9. `union(5, 0)`
* Connected the vertex 5 to vertex 0. Vertex 5 had 6 as a child, hence 0 is a root of 6 as well.
```
 0  1  2  3  4  5  6  7  8  9
[0, 1, 1, 8, 3, 0, 5, 7, 8, 8]
```
10. `union(7, 2)`
* The root of *2* is *1*, hence *7* vertex is connected to *1*. Since *2* and *7* share the same root (*1*),
they become connected.
```
 0  1  2  3  4  5  6  7  8  9
[0, 1, 1, 8, 3, 0, 5, 1, 8, 8]
```
11. `union(6, 1)`
* Since 0 is the root of 6, 1 becomes the root of 0 and 6 and 1 are connected.
```
 0  1  2  3  4  5  6  7  8  9
[1, 1, 1, 8, 3, 0, 5, 1, 8, 8]
```
12. `union(7, 3)`
* The root is 1. The root of 3 is 8. If we want to connect them, we have to attach the vertex of the root of 
7, which is 1, to the root of vertex 3, which is 8.
```
 0  1  2  3  4  5  6  7  8  9
[1, 8, 1, 8, 3, 0, 5, 1, 8, 8]
```

In the end, we will have a single graph of connected components. All components in this example are connected.
