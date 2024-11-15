
// Write a function that takes a number and doubles it.


// Number -> Number
function double(xx) {
  return 2 * xx;
}

// Examples:
//  - double(2) -> 4
//  - double(6) -> 12



// A Pumpkin is an object with fields:
//  - farmer: String - Who grew this pumpkin?
//  - weight: Number - in lbs

let contestants = [
  {farmer: "Alice", weight: 10.0},
  {farmer: "Bob", weight: 12.3},
  {farmer: "Carol", weight: 11.4},
  {farmer: "Dave", weight: 7.0},
  {farmer: "Erin", weight: 18.3},
  {farmer: "Frank", weight: 14.9},
  {farmer: "Gail", weight: 7.0},
  {farmer: "Hank", weight: 10.0},
];

// Overall problem: Find the top three contestants (heaviest pumpkins) so we can
// award ribons.

// Step 1: Sort the list.
// Step 2: Take the first three items in the list.


// List of Pumpkin -> List of Pumpkin
function topThree(pumpkins) {
  let ys = [];
  for (let pumpkin of pumpkins) {
    ys.push(pumpkin);
    if (ys.length >= 3) {
      break;
    }
  }
  return ys;
}

// Example:
//  topThree(contestants) -> [erin, frank, bob]


// List of Pumpkin -> List of Pumpkin
function sortByWeight(pumpkins) {
  let ys = [];
  for (let pumpkin of pumpkins) {
    ys = insertInOrder(ys, pumpkin);
  }
  return ys;
}

// Examples:
//   sortByweight([{farmer: "Alice", weight: 10.0}, {farmer: "Bob", weight: 12.3}]) ->
//     [{farmer: "Bob", weight: 12.3}, {farmer: "Alice", weight: 10.0}]


// List of Pumpkin, Pumpkin -> List of Pumpkin
function insertInOrder(xs, pumpkin) {
  let ys = [];
  let added = false;
  for (let xx of xs) {
    if (!added && pumpkin.weight > xx.weight) {
      ys.push(pumpkin);
      added = true;
    }
    ys.push(xx);
  }
  if (!added) {
    ys.push(pumpkin);
  }
  return ys;
}

// Examples:
//  - ([], p) -> [p]
//  - ([alice], bob) -> [bob, alice]
