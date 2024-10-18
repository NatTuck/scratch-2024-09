
// return current rocket height from ground
// in logical pixels
function rocketHeight(tick) {
  let initialHeight = 120;
  let accelRate = 1.5;
  return initialHeight + tick ** accelRate;
}

function rocketDrift(tick) {
  return 400 + 2 * tick;
}

function onDraw(tick, {drawImage}) {
  drawImage('ram-1.png', rocketDrift(tick), rocketHeight(tick), 100, 100);
}
