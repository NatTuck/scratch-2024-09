

let state0 = { tick: 0, py: 0, vy: 0 };
let state = state0;


function loadImages() {
  let ys = {};
  for (var img of document.getElementsByClassName('img')) {
    let name = img.src.split('/').splice(-1)[0];
    ys[name] = img;
  }
  return ys;
}

function renderMain() {
  let canvas = document.getElementById('canv');
  let ww = canvas.width = 800;
  let hh = canvas.height = 600;

  let images = loadImages();
  console.log(images);
  
  let ctx = canvas.getContext('2d');

  function drawImage(name, xx, yy, dw, dh) {
    let img = images[name];
    let hx = dw / 2;
    let hy = dh / 2;
    ctx.drawImage(img, xx - hx, hh - (yy - hy), dw, dh);
  }

  function doTick() {
    ctx.clearRect(0, 0, 800, 600);

    onDraw(state, {drawImage});
    state = onTick(state);
  }

  setInterval(doTick, 15);

  function onReset() {
    state = state0;
  }

  let btn = document.getElementById('resetBtn');
  btn.addEventListener('click', onReset);

  function doClick(ev) {
    let rect = ev.target.getBoundingClientRect();
    let xx = ev.clientX - rect.left;
    let yy = ev.clientY - rect.top;
    state = onClick(state, xx, yy);
  }
  canvas.addEventListener('click', doClick);
}

window.addEventListener('load', renderMain);
