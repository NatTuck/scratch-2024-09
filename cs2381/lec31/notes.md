

# Threads

Normally our program is a series of functions / methods that run in some specific order.

But each running instance of a program on a computer (a process), consists of multiple
threads of execution. Each thread is running a series of code, and the threads run
concurrently (and maybe in parallel).


## Concurrency

 - Two things happen "at the same time".
 - If they are sequenced in practice, we don't care about the order.

## Parallelism

 - Do 2 (or more) things at the same time to make the overall task go faster.

## Concurrency with a big loop

```
while (true) {
  var ev = getNextEvent();
  
  switch (ev.type) {
  case 'mouseClick':
    ...
  case 'networkPacket':
    ... 
  }

}
```


## Concurrency with threads

```
void uiThread() {
  while (true) {
    let ev = getNextUIEvent();
    ...
  }
}

void networkThread() {
  while (true) {
    let ev = getNextNetworkEvent();
    ...
  }
}

```
