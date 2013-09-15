tomcat_dir="/home/bancai/tomcat/webapps"
src_dir=`pwd`

BANCAI_WAR=$tomcat_dir/bancai.war
BANCAI_DIR=$tomcat_dir/bancai
PIC_DIR=$BANCAI_DIR/picture

if [ -x $BANCAI_WAR ]
then
	rm $BANCAI_WAR
fi

if [ -d $BANCAI_DIR ]
then
	umount $BANCAI_DIR

	rm -rf $BANCAI_DIR
fi

mv $src_dir/bancai.war $tomcat_dir 

/etc/init.d/tomcat start

sleep 30

if [ !-d $PIC_DIR ]
then 
	mkdir $PIC_DIR
fi

mount -a

