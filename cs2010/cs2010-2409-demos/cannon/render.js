
let state = onInit();

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
  
  let ctx = canvas.getContext('2d');

  function drawImage(name, ang, xx, yy, dw, dh) {
    let img = images[name];
    let hx = dw / 2;
    let hy = dh / 2;
    let ix = xx - hx;
    let iy = hh - (yy - hy);
    ctx.save();
    ctx.translate(ix, iy);
    ctx.rotate(ang);
    ctx.drawImage(img, 0, 0, dw, dh);
    ctx.restore();
  }

  function drawCircle(xx, yy, radius, color) {
    ctx.save();
    ctx.fillStyle = color;
    ctx.beginPath();
    ctx.ellipse(xx, hh - yy, radius, radius, 0, 2*Math.PI, 0);
    ctx.fill();
    ctx.restore();
  }

  function doTick() {
    ctx.clearRect(0, 0, 800, 600);

    onDraw(state, {drawImage, drawCircle});
    state = onTick(state);
  }

  setInterval(doTick, 50);

  function onReset() {
    state = onInit();
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

  function doMove(ev) {
    let rect = ev.target.getBoundingClientRect();
    let xx = ev.clientX - rect.left;
    let yy = ev.clientY - rect.top;
    state = onMove(state, xx, yy);
  }

  canvas.addEventListener('mousemove', doMove);
}

window.addEventListener('load', renderMain);
