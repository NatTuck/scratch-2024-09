
function ramFrame(tick) {
  let fno = Math.floor(tick / 3) % 4 + 1;
  return "ram-" + fno + ".png";
}

/*
  Data representation of our program.

  Our state is:
  - rams: a List of Rams.

  A Ram is an object containing:
  - tick: Age in ticks
  - xx: x position in virtual pixels
  - yy: y position in virtual pixels

  */

function newRam(xx, yy) {
  return { tick: 0, xx: xx, yy: yy };
}

function onInit() {
  return { rams: [] };
}

function onDraw(state, {drawImage, drawCircle}) {
  let { rams } = state;

  for (let ram of rams) {
    let { tick, xx, yy } = ram;
    drawImage(ramFrame(tick), 0, xx, yy, 100, 100);
  }
}

function tickRam(ram) {
  let { tick, xx } = ram;
  tick = tick + 1;
  xx = xx - 4;
  if (xx < 0) {
    xx = 800;
  }
  return { ...ram, tick, xx };
}

function tickRams(xs) {
  let ys = [];
  for (let x of xs) {
    ys.push(tickRam(x));
  }
  return ys;
}

function onTick(state) {
  let { rams } = state;
  return { ...state, rams: tickRams(rams) };
}

function onMove(state, xx, yy) {
  return state;
}

function onClick(state, xx, yy) {
  let { rams } = state;

  let bob = newRam(xx, yy);
  rams.push(bob);

  return { ...state, rams };
}

