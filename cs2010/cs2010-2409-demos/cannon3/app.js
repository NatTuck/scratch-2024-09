
function ramFrame(tick) {
  let fno = Math.floor(tick / 3) % 4 + 1;
  return "ram-" + fno + ".png";
}

function ramIsHit(ram, ball) {
  let dx = Math.abs(ball.px - ram.px);
  let dy = Math.abs(ball.py - ram.py);
  return dx < 60 && dy < 60;
}

function newBall(ang) {
  let speed = 20;
  return { px: 150, py: 80, vx: speed*Math.cos(ang),
           vy: speed*Math.sin(ang) };
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
  return { tick: 0, balls: [], ram: newRam(), ang: 0 };
}

function onDraw(state, {drawImage, drawCircle}) {
  drawImage(ramFrame(state.tick), 0, state.ram.px,
            state.ram.py, 100, 100);
  drawImage('cannon.png', -state.ang, 200, 100, 200, 100);

  for (let ball of state.balls) {
    drawCircle(ball.px, ball.py, 10, "black"); 
  }
}

function onTick(state) {
  let { tick, ang, balls, ram } = state;
  tick = tick + 1;

  let updatedBalls = [];
  for (let ball of balls) {
    if (ramIsHit(ram, ball)) {
      ram.vy = ram.vy + 5;
    }
    else {
      let ball1 = tickBall(ball);
      updatedBalls.push(ball1);
    }
  }

  ram = tickRam(ram);

  return { ang, ram, tick, balls: updatedBalls };
}

function onMove(state, xx, yy) {
  let ang = Math.atan2(600 - yy, xx);
  let { balls, ram, tick } = state;
  return { balls, ram, tick, ang };
}

function onClick(state, _xx, _yy) {
  let balls = state.balls;
  balls.push(newBall(state.ang));
  return { tick: state.tick, balls: balls,
	       ram: state.ram, ang: state.ang };
}

