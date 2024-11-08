

// A Car is an object with two fields:
//  - tankGallons: Number
//  - milesPerGallon: Number

let camry = { tankGallons: 18, milesPerGallon: 34 };
let altima = { tankGallons: 20, milesPerGallon: 23 };
let fusion = { tankGallons: 14, milesPerGallon: 22 };
let ranger = { tankGallons: 22, milesPerGallon: 25 };

let cars = [camry, altima, ranger, fusion];

// List of Cars -> Car
// What car can go the furthest on a tank?
function longestRange(xs) {
  let best = null;
  for (let xx of xs) {
    // Do we unpack the car or call a helper function.
  }
  return best;
}



// List of Car -> Number
// In liters
function totalTankSizeInLiters(xs) {
  let total = 0;

  for (let xx of xs) {
    let size = tankSizeInLiters(xx);
    total += size;
  }

  return total;
}

// Car -> Number
function tankSizeInLiters(car) {
  // What do we do with a Car? Unpack it
  let { tankGallons, milesPerGallon } = car;

  /// What do we do with a Car? Access its fields.
  // car.tankGallons, car.milesPerGallon
  const litersPerGallon = 3.79;
  
  let liters = tankGallons * litersPerGallon;
  return liters;
}

// List of Cars -> Number
// In gallons
function totalTankSize(xs) {
  let total = 0;
  for (let xx of xs) {
    let { tankGallons, milesPerGallon} = xx;

    total += tankGallons;
  }
  return total;
}

// Car -> Number
// Calculate distance car can go with a full tank in miles.
function carRange(car) {
  let { tankGallons, milesPerGallon } = car;
  return tankGallons * milesPerGallon;
}



//xx, yy, zz, ww

function lengthOfString(st) {
  // return value should be number
  return st.length;
}

function btnClicked2(ev) {
  let input2 = document.getElementById('input-2');
  let output2 = document.getElementById('output-2');

  let xx = input2.value;

  let yy = lengthOfString(xx);

  output2.innerText = yy;
}

document.getElementById('btn-2').addEventListener('click', btnClicked2);


// Integer -> Boolean
function isEven(nn) {
  let result = (nn % 2) == 0; // a boolean
  return result;
}

// Return the maximum of two numbers
// Number, Number -> Number
function max_v1(aa, bb) {
  let bigger = bb; // some number
  if (aa > bb) {
    bigger = aa;
  }
  return bigger;
}

function max_v2(aa, bb) {
  if (aa > bb) {
    return aa;
  }
  else {
    return bb;
  }
}

// Number, Number, Number -> Number
function max1(aa, bb, cc) {
  if (aa > bb && aa > cc) {
    return aa;
  }
  if (bb > cc) {
    return bb;
  }
  return cc;
}

function max(aa, bb, cc) {
  return max_v2(cc, max_v2(aa, bb));
}

function btnClicked1(ev) {
  let in1a = document.getElementById('input-1a');
  let in1b = document.getElementById('input-1b');
  let in1c = document.getElementById('input-1c');
  let output1 = document.getElementById('output-1');

  let aa = parseInt(in1a.value);
  let bb = parseInt(in1b.value);
  let cc = parseInt(in1c.value);

  let zz = max(aa, bb, cc);

  output1.innerText = zz;
}

// let btn = document.getElementById('btn-1');
// btn.addEventListener('click', btnClicked1);

document.getElementById('btn-1').addEventListener('click', btnClicked1);



// nums is a List of Integers
let nums = [1, 2, 3, 4, 5];

// nums2 is List of Numbers
let nums2 = [1, 3.5, 4, 5.7, 9];

// List of Numbers -> Maybe Number
function largest(xs) {
  let result = null; // a number
  for (let xx of xs) {
    if (result === null || xx > result) {
      result = xx;
    }
  }
  return result;
}



