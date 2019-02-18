const sample1 = [1, 5, 12, 14, 10, 3];

console.log(bitonicSearch(sample1, 10)); // index: 4
console.log(bitonicSearch(sample1, 1)); // index: 0

// Main implementation point
function bitonicSearch(arr, target) {
  const n = arr.length;
  let bitonicPointIndex = findBitonicPoint(arr, 0, n);

  return searchBitonic(arr, n, target, bitonicPointIndex);
}

function searchBitonic(arr, n, target, pivotIndex) {
  // if the number to be searched is bigger than
  // our pivot number, then there is no such element
  if (target > arr[pivotIndex]) {
    return -1;
  }
  // if the number to be found is equal
  // to the pivot value of the array, then return it
  else if (target == arr[pivotIndex]) {
    return arr[pivotIndex];
  }
  let leftPartResult = ascendingBinarySearch(arr, 0, pivotIndex - 1, target);
  if (leftPartResult != -1) {
    return leftPartResult;
  }

  return descendingBinarySearch(arr, pivotIndex + 1, n - 1, target);
}

// perform binary search where array is in descending order
function descendingBinarySearch(arr, low, high, target) {
  while (low <= high) {
    const mid = Math.floor(low + (high - low) / 2);

    if (arr[mid] == target) {
      return mid;
    } else if (arr[mid] < target) {
      high = mid - 1;
    } else {
      low = mid + 1;
    }
  }

  return -1;
}

// perform binary search where array is in ascending order
function ascendingBinarySearch(arr, low, high, target) {
  while (low <= high) {
    const mid = Math.floor(low + (high - low) / 2);

    if (arr[mid] == target) {
      return mid;
    } else if (arr[mid] > target) {
      high = mid - 1;
    } else {
      low = mid + 1;
    }
  }

  return -1;
}

// find the largest element in the array
// that's where the increasing stops
function findBitonicPoint(arr, low, high) {
  let mid = Math.floor(low + high / 2);

  // found the largest number in bitonic array
  // this will become the searching point
  if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
    return mid;
  }
  // if the mid point is smaller than the left
  // and larger than the right, that means that we
  // have to go to the left part of the array
  else if (arr[mid] < arr[mid - 1] && arr[mid] > arr[mid + 1]) {
    findBitonicPoint(arr, low, mid);
  }
  // if the mid point is larger than the left value
  // and smaller than the right value, then we have
  // to make the right step
  else if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
    findBitonicPoint(arr, mid, high);
  }
  return mid + 1;
}
