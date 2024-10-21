

/*
function ramX(tick) {
  return 800 - (tick * 4 % 800);
}
*/

function moveRam(xx) {
  xx = xx - 4;
  if (xx < 0) {
    xx = xx + 800;
  }
  return xx;
}

function ramFrame(tick) {
  let fno = Math.floor(tick / 3) % 4 + 1;
  return "ram-" + fno + ".png";
}

function ramIsHit(state) {
  let dx = Math.abs(state.ball.px - state.ramX);
  let dy = Math.abs(state.ball.py - 75);
  return dx < 60 && dy < 60;
}

function newBall() {
  return { px: 150, py: 80, vx: 5, vy: 0 };
}

function tickBall(ball) {
  return { px: ball.px + ball.vx, py: ball.py + ball.vy,
           vx: ball.vx, vy: ball.vy - 1 }; 
}

function onInit() {
  return { tick: 0, ball: null, ramX: 800 };
}

function onDraw(state, {drawImage, drawCircle}) {
  console.log(state.ball);
  drawImage(ramFrame(state.tick), 0, state.ramX, 150, 100, 100);
  drawImage('cannon.png', 0, 75, 150, 200, 100);
  if (state.ball != null) {
    drawCircle(state.ball.px, state.ball.py, 10, "black"); 
  }
}

function onTick(state) {
  let tick = state.tick + 1;
  if (state.ball == null) {
    return { tick: tick, ramX: moveRam(state.ramX), 
	     ball: null };
  }
  else {
    if (ramIsHit(state)) {
      return { tick: tick, ramX: state.ramX + 80, ball: null };
    }
    else {
      return { tick: tick, ramX: moveRam(state.ramX), 
	       ball: tickBall(state.ball) };
    }
  }
}

function onMove(state, xx, yy) {
  return state;
}

function onClick(state, _xx, _yy) {
  return { tick: state.tick, ball: newBall(), 
	   ramX: state.ramX };
}

