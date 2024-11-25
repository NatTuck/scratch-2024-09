

// Number -> Number
function add1(xx) {
  return xx + 1;
}

function add2(xx) {
  return xx + 2;
}

// (A -> A), A -> A
function doTwice(op, xx) {
  return op(op(xx));
}

// (A -> A) -> (A -> A)
function twice(op) {
  function inner(xx) {
    return op(op(xx));
  }
  return inner;
}
