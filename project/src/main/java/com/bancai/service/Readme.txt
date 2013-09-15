service 是对逻辑业务的处理层


1.1 对单个数据库表的操作（只有一个对应操作的dao层）的封装直接放在对应
table-nameService.java中进行封装。方便查找对应表的操作函数，防止冗余。

1.2 对单个表的复杂逻辑处理，放在对应table-nameService.java中进行封装。

对应规则：
	1) 只涉及一个表，放在table-nameService.java中
	2) 根据多个表条件查询， 要取哪个表的内容，对数据库的操作对应到
		table-nameService.java表
	3）根据多个表条件设置， 要根据设置哪个表，将设数据库操作对应到
		table-nameService.java表
		

2、如果业务逻辑对应多个表的操作
	原则：module不允许直接对数据库进行操作
	
	2.1 对多个表操作调用的封装
		a) 只在一处调用，可以放在Action中分别调用table-nameService.java 中的方法。
			也可按照b)一样处理，根据实际情况确定即可。
		b) 多处调用,在service.module包中创建 module-nameService.java。
			分别调用table-nameService.java 中的方法
	
	2.2 对多个表的操作都要使用这个业务处理
		前提：对多个表的操作都要使用这个业务处理，才遵循此处理的处理，否则遵循1.2
		在service.module包中创建 module-nameService.java 对公共的业务逻辑进行处理。
		设计到数据库操作遵照：1 和 2.1中的内容
		
	