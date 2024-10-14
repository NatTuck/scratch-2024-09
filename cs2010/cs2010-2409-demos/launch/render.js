
let tick = 0;

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

  function onTick() {
    ctx.clearRect(0, 0, 800, 600);

    onDraw(tick * (15 / 50.0), {drawImage});

    tick += 1;
  }

  setInterval(onTick, 15);

  function onReset() {
    tick = 0;
  }

  let btn = document.getElementById('resetBtn');
  btn.addEventListener('click', onReset);
}

window.addEventListener('load', renderMain);
