function eggDrop(n, k) {
  if (k == 1 || k == 0) {
    return k;
  }
  if (n == 1) {
    return k;
  }

  let min = Infinity;
  let i = 1,
    result = 0;

  for (i = 1; i <= k; i++) {
    res = Math.max(eggDrop(n - 1, i - 1), eggDrop(n, k - i));

    if (res < min) {
      min = res;
    }
  }

  return min + 1;
}

console.log(eggDrop(2, 10));
