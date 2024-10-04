#include <stdio.h>

int
add1(int x)
{
  return x + 1;
}

int
main(int _ac, char* _av[])
{
  printf("%d\n", add1(5));
  return 0;
}
