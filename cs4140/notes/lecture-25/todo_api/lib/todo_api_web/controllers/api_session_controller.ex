defmodule TodoApiWeb.ApiSessionController do
  use TodoApiWeb, :controller

  alias TodoApi.Users
  alias TodoApiWeb.UserAuth

  def create(conn, %{"user" => user_params}) do
    %{"email" => email, "password" => password} = user_params

    if user = Users.get_user_by_email_and_password(email, password) do
      token_data = %{user_id: user.id}
      token = Phoenix.Token.sign(TodoApiWeb.Endpoint, "user session", token_data)
      conn
      |> put_resp_content_type("application/json")
      |> send_resp(201, Jason.encode!(%{token: token}))
    else
      conn
      |> put_resp_content_type("application/json")
      |> send_resp(403, Jason.encode!(%{msg: "Bad auth request"}))
    end
  end
end
