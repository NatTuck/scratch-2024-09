
#include <stdio.h>

int
main(int argc, char* argv[])
{
  int a, b, larger;

//    input a
  puts("Whats a?");
  scanf("%d", &a);

//    input b
  puts("What's b?");
  scanf("%d", &b);

//    if (a > b)
//        larger = a
//    else
//        larger = b
  if (a > b) {
    larger = a;
  }
  else {
    larger = b;
  }


//    output larger
  printf("The larger value is: %d\n", larger);

  return 0;
}
