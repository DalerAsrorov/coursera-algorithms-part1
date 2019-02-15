// indexes represent nodes and they are connected
// if they have the same IDs
let ids = [0, 1, 1, 8, 8, 0, 0, 1, 8, 8];

const createConnections = givenIds =>
  new Set(
    Object.values(
      givenIds.reduce((accum, id, index) => {
        if (accum[id]) {
          accum[id] = `${accum[id]}->${index}`;
        } else {
          accum[id] = `${index}`;
        }
        return accum;
      }, {})
    )
  );

//Set { '0->5->6', '1->2->7', '3->4->8->9' }
console.log(createConnections(ids));
