
# Deploy Steps

 - Feature branch is merged into main on github.
 - Get the code to the server.
   - We have a server (VPS, with >= 1GB of RAM, running a Debian-family Linux distro - Debian or Ubuntu).
   - On the server, we have a user account for the application
   - Recommended: Set up SSH keys, don't use a simple password for SSH on an internet-connected server. 
   - We have dev tools installed on the server.
     - Run the install-asdf script below
     - Comment in the apt-get install lines for the first run.
   - You have a deploy key set up for your github repository.
   - Initial checkout: ```git clone [github ssh URL for repo]```
   - Update to latest code ```cd [app dir]; git pull```
 - Rebuild the app with ```mix compile```
   - This may request a ```mix deps.get```
 - If you've set up npm / yarn, update JS deps with that here.
 - Run any migrations with ```mix ecto.migrate```
 - Make sure your nginx config is installed and enabled.
   - Viewing the site with no app running should give bad gateway error.
 - Make sure your start script is set up correctly and works.
   - Running it manually should allow viewing the site.
 - Make sure your systemd user service file is installed.
 - Restart your systemd service.
 

# Generating and seeing your user ssh authentiction key

```bash
$ ssh-keygen -t ed25519
... yes, no password, etc.
party@wendigo:~$ cat ~/.ssh/id_*.pub
ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIBZb4YOVW2e/2uGv2ILzzWpwBIu1rfshCY47N9OG1CEM party@wendigo.homework.quest
```



# Appendix A: Install ASDF script

```bash
#!/bin/bash

if [ ! -d ~/.asdf ]
then
    git clone https://github.com/asdf-vm/asdf.git ~/.asdf --branch v0.14.0
fi

. "$HOME/.asdf/asdf.sh"

asdf plugin add nodejs https://github.com/asdf-vm/asdf-nodejs.git
asdf install nodejs 20.13.1
asdf global nodejs 20.13.1

#sudo apt-get -y install git
#sudo apt-get -y install build-essential autoconf m4 libncurses5-dev \
#  libwxgtk3.0-gtk3-dev libwxgtk-webview3.0-gtk3-dev libgl1-mesa-dev \
#  libglu1-mesa-dev libpng-dev libssh-dev unixodbc-dev xsltproc fop \
#  libxml2-utils libncurses-dev openjdk-11-jdk

#sudo apt-get -y install build-essential autoconf m4 libncurses5-dev \
#  libpng-dev libssh-dev unixodbc-dev xsltproc fop \
#  libxml2-utils libncurses-dev default-jdk

asdf plugin add erlang https://github.com/asdf-vm/asdf-erlang.git
asdf install erlang 26.2.5
asdf global erlang 26.2.5

asdf plugin-add elixir https://github.com/asdf-vm/asdf-elixir.git
asdf install elixir 1.16.2-otp-26
asdf global elixir 1.16.2-otp-26

echo "Add the following to ~/.bashrc:"
echo
echo . "\$HOME/.asdf/asdf.sh"
echo . "\$HOME/.asdf/completions/asdf.bash"
```


# Appendix B: Systemd Service file


```
# User Service
#  - (as root) loginctl enable-linger (for user)
#  - This goes in ~/.config/systemd/user/myapp.service
#  - systemctl --user enable myapp
#  - systemctl --user start myapp

[Unit]
Description=Party Animal

[Service]
Type=simple
Restart=on-failure
Environment=LANG=en_US.UTF-8

WorkingDirectory=/home/party/party
ExecStart=bash /home/party/start.sh

[Install]
WantedBy=default.target
```

# Appendix C: Nginx Config

This goes in /etc/nginx/sites-available

and is symbolic linked in to /etc/nginx/sites-enabled

Change the server name to the domain being used.

This config is HTTP only, you can upgrade to HTTPS using
the 'certbot' tool 

(```sudo apt install certbot python3-certbot-nginx; sudo certbot```)

```
server {
    server_name party.homework.quest;

    location / {
        proxy_pass http://localhost:4000;
    }

    location /socket {
        proxy_pass http://localhost:4000;
        proxy_http_version 1.1;
        proxy_set_header Upgrade $http_upgrade;
        proxy_set_header Connection "upgrade";	 	 
    }

    listen 80;
    listen [::]:80;
}
```

## Appendix D: Start Script

This one's set up to go the app user's home directory.

It sets up the environment correctly and then starts the app.


```
#!/bin/bash
. $HOME/.asdf/asdf.sh
cd party_animal
mix phx.server
```
