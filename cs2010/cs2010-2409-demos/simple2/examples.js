

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

function add2(nn) {
  return nn + 2;
}


function btnClicked1(ev) {
  let input1 = document.getElementById('input-1');
  let output1 = document.getElementById('output-1');

  let xx = parseInt(input1.value);

  let yy = add2(xx);

  output1.innerText = yy;
}

// let btn = document.getElementById('btn-1');
// btn.addEventListener('click', btnClicked1);

document.getElementById('btn-1').addEventListener('click', btnClicked1);
