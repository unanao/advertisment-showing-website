cp config/gitlab.yml.example config/gitlab.yml

# Make sure GitLab can write to the log/ and tmp/ directories
chown -R git log/
chown -R git tmp/
chmod -R u+rwX  log/
chmod -R u+rwX  tmp/

# Create directory for satellites
mkdir /home/git/gitlab-satellites

# Create directories for sockets/pids and make sure GitLab can write to them
mkdir tmp/pids/
mkdir tmp/sockets/
chmod -R u+rwX  tmp/pids/
chmod -R u+rwX  tmp/sockets/

# Create public/uploads directory otherwise backup will fail
mkdir public/uploads
chmod -R u+rwX  public/uploads

# Copy the example Puma config
cp config/puma.rb.example config/puma.rb

# Configure Git global settings for git user, useful when editing via web
# Edit user.email according to what is set in gitlab.yml
git config --global user.name "GitLab"
git config --global user.email "gitlab@localhost"


###########################################################
cp config/database.yml.mysql config/database.yml


echo " 1. change localhost to the fully-qualified domain name of your
 host serving GitLab where necessary, vim config/gitlab.yml"

echo "2 Enable cluster mode if you expect to have a high load instance
      Ex. change amount of workers to 3 for 2GB RAM server
vim config/puma.rb"

echo "3 : Make sure to update username/password in config/database.yml."
