let array = [1, 24, 4, 5, 7, 8];


let mergeWithSmallerAux = (arr = [], n) => {
    let auxArray = new Array(n);
    let copyArray = arr.slice(0);

    for (let i = 0; i < n; i++) {
        auxArray[i] = copyArray[i];
    }

    let i = 0;
    let j = n;
    let k = 0;

    while(k < copyArray.length) {
        if (i >= n) {
            copyArray[k] = copyArray[j++];
        } else if (j >= copyArray.length)  {
            copyArray[k] = auxArray[i++];
        } else if (auxArray[i] <= copyArray[j]) {
            copyArray[k] = auxArray[i++];
        } else {
            copyArray[k] = copyArray[j++];
        }
        k++;
    }

    return copyArray;
}

console.log(merge(array, 2));
