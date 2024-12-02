
const name = "lectureUser";
const game = "lectureGame1";

require('core-js/actual');
let { Socket } = require('phoenix-channels');

let socket = new Socket("wss://words.homework.quest/socket", { debug: true });
socket.connect();

let channel = socket.channel("game:" + game, {name});
channel.join()
  .receive("ok", (msg) => console.log("Connected to game:", msg.game))
  .receive("error", function (msg) { console.log("Error:", msg) });

const alphabet = new Set("abcdefghijklmnopqrstuvwxyz".split(''));

function onView(view) {
  let guesses = new Set(view.guesses);
  let moves = Array.from(alphabet.difference(guesses));

  console.log(view);
  console.log("Legal moves:", moves);

  if (moves.length > 0) {
    let ch = moves[0];
    console.log("guess", ch);
    channel.push("guess", {ch});
  }
  else {
    console.log("Game done");
    process.exit();
  }
}

channel.on("view", onView);
