const sample1 = [0, -1, 2, -3, 1];

function threeSum(arr, target = 0) {
  let result = [];

  for (let i = 0; i < arr.length; i++) {
    let j = i + 1;
    let k = arr.length - 1;

    while (j < k) {
      if (i !== j && arr[i] + arr[j] + arr[k] === target) {
        result = [...result, [arr[i], arr[j], arr[k]]];
        j++;
        k--;
      } else if (arr[i] + arr[j] + arr[k] < target) {
        j++;
      } else {
        k--;
      }
    }
  }

  return result;
}

console.log(threeSum(sample1, 0));
