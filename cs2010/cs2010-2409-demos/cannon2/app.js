

function ramFrame(tick) {
  let fno = Math.floor(tick / 3) % 4 + 1;
  return "ram-" + fno + ".png";
}

function ramIsHit(state) {
  let dx = Math.abs(state.ball.px - state.ram.px);
  let dy = Math.abs(state.ball.py - state.ram.py);
  return dx < 60 && dy < 60;
}

function newBall(ang) {
  let speed = 20;
  return { px: 150, py: 80, vx: speed*Math.cos(ang), vy: speed*Math.sin(ang) };
}

function newRam() {
  return { px: 800, py: 100, vx: -4, vy: 0 }; 
}

function tickBall(ball) {
  return { px: ball.px + ball.vx, py: ball.py + ball.vy,
           vx: ball.vx, vy: ball.vy - 1 }; 
}

function tickRam(ram) {
  let { px, py, vx, vy } = ram;
  vy = vy - 1;
  py = py + vy;
  px = px + vx;
  
  if (py < 100) {
    py = 100;
    vy = 0;
  }

  if (px < 0) {
    px = 800;
  }

  return { px, py, vx, vy };
}

function onInit() {
  return { tick: 0, ball: null, ram: newRam(), ang: 0 };
}

function onDraw(state, {drawImage, drawCircle}) {
  console.log(state.ball);
  drawImage(ramFrame(state.tick), 0, state.ram.px, state.ram.py, 100, 100);
  drawImage('cannon.png', -state.ang, 200, 100, 200, 100);
  if (state.ball != null) {
    drawCircle(state.ball.px, state.ball.py, 10, "black"); 
  }
}

function onTick(state) {
  let { tick, ang, ball, ram } = state;
  //let tick = state.tick;
  //let ang = state.ang;
  //let ball = state.ball;
  //let ramX = state.ramX;
  tick = tick + 1;


  if (ball != null) {
    if (ramIsHit(state)) {
      ram.vy = ram.vy + 5;
    }
    else {
      ball = tickBall(ball);
    }
  }

  ram = tickRam(ram);

  /*
  if (ball == null) {
    ramX = moveRam(ramX);
  }
  else {
    if (ramIsHit(state)) {
      ramX = ramX + 80;
    }
    else {
      ramX = moveRam(ramX);
      ball = tickBall(ball);
    }
    }
  */

  // return { ang: ang, ball: ball, ramX: ramX, tick: tick };
  return { ang, ball, ram, tick };
}

function onMove(state, xx, yy) {
  let ang = Math.atan2(600 - yy, xx);
  let { ball, ram, tick } = state;
  return { ball, ram, tick, ang };
}

function onClick(state, _xx, _yy) {
  return { tick: state.tick, ball: newBall(state.ang), 
	       ram: state.ram, ang: state.ang };
}

