defmodule Server do
  use GenServer

  def start_link() do
    GenServer.start_link(__MODULE__, %{}, name: :server)
  end

  @impl true
  def init(state) do
    {:ok, state}
  end

  @impl true
  def handle_call(:hi, from, state) do
    IO.inspect({:hi, from})
    {:reply, :ok, state}
  end
end
