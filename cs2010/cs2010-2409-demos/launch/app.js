

function sheepX(tick) {
  return (750 - 5 * tick) % 800;
}


function onDraw(tick, {drawImage}) {
  drawImage('ram-1.png', sheepX(tick), 150, 100, 100);
}
