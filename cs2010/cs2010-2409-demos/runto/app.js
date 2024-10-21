


function distance(x0, y0, x1, y1) {
  let dx = x1 - x0;
  let dy = y1 - y0;
  return Math.sqrt(dx*dx + dy*dy);
}

// assertNear(10, distance(0, 0, 0, 10));
// assertNear(23.77, distance(3, 4, 25, 13));

function ramFrame(tick) {
  let fno = Math.floor(tick / 3) % 4 + 1;
  return "ram-" + fno + ".png";
}

function onInit() {
  var ram = { xx: 700, yy: 150 };
  return { tick: 0, ram: ram, gx: 0, gy: 0 }
}

function onDraw(state, {drawImage, drawCircle}) {
  drawImage(ramFrame(state.tick), 0, state.ram.xx, state.ram.yy, 100, 100);
}

function onTick(state) {
  let tick = state.tick + 1;
  return { tick: tick, ram: state.ram,
           gx: state.gx, gy: state.gy };
}

function onMove(state, xx, yy) {
  return state;
}

function onClick(state, xx, yy) {
  return { tick: state.tick, ram: state.ram,
           gx: xx, gy: yy };
}

