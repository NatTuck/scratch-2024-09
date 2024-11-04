defmodule GrabboidTest do
  use ExUnit.Case
  doctest Grabboid

  test "greets the world" do
    assert Grabboid.hello() == :world
  end
end
