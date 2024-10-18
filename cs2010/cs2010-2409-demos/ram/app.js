
function isEven(xx) {
  return Math.floor(xx) % 2 == 0;
}

function ramX(tick) {
  var distMoved = 6 * tick;
  if (ramForwards(tick)) {
    return 850 - (distMoved % 900);
  }
  else {
    return distMoved % 900;
  }
}

function ramForwards(tick) {
  var distMoved = 6 * tick;
  var screensMoved = Math.floor(distMoved / 900);
  return isEven(screensMoved);
}

function ramFrame(tick) {
  var fno = Math.floor(tick / 6) % 4 + 1;
  return 'ram-' + fno + '.png';
}

function onDraw(state, {drawImage}) {
  drawImage(ramFrame(state.tick), ramX(state.tick), 150 + state.py, 100, 100);
}

function onTick(state) {
  var tick = state.tick + 1;
  var py = state.py + state.vy;
  var vy = state.vy - 0.25;
  if (py < 0) {
    vy = 0;
    py = 0;
  }
  return { tick: tick, py: py, vy: vy };
}

function onClick(state, _xx, _yy) {
  return { tick: state.tick, py: state.py, vy: state.vy + 10 };
}
