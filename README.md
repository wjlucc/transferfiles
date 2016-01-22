#这是一个文件传输的小工具

	用于两台电脑之间传送文件。
	用这个小项目复习一下Java中的几个要点。
---------

###目标是实现一个网络文件传输的小项目。
- 同时传送多个文件，文件夹。
- 校验功能。
- 文件选择时在控制台输入文件的完整路径。（最后要实现UI）
- IP地址也在控制台输入。（最后可以设置一个小的服务器，让用户注册，每次登陆就能确定其IP）
- 目前默认接收在D:\文件夹下。后续需要改进。
- 传输过程中要显示百分比，当前的传输速率等信息。


--------------
###涉及到的Java相关内容
- Socket相关内容
- 文件读写类
- 文件相关类
- 多线程相关知识

--------------
###版本更新

- v1.1.0 传输过程中使用UDP报文发送文件名字。
	- bug: TCP传送文件的过程中，有时候会成功，有时候会失败，不明确原因，下一步再看。
- v1.0.0 实现了简单的文件传送过程。







