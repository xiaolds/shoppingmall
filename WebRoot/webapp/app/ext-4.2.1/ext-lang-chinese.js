var local = {};  
local.backup = {};  
local.emergency = {};  
local.recovery= {};
local.log= {};
local.config= {};  
local.btn={};
local.window={};

/*common start*/
//title
local.backup.title='备份·预警';
local.emergency.title='应急·演练';
local.recovery.title='恢复·存储';
local.log.title='报表·日志';
local.config.title='配置';
local.log.titleSystemReport='系统报表';
local.log.titleEntireReport='全网报表';
local.log.titleSystemLog='系统日志';
local.log.titleClientLog='客户端日志';
local.log.titleInfoService='消息服务器';
local.log.titleEmergencyLog='应急日志';
local.log.titleWarnLog='预警日志';
local.config.clientConfig="客户端设置";
local.config.accountConfig="账号管理";
local.config.authorise="许可证授权";

//btn
local.btn.refresh="刷新";
local.btn.new0="新建";
local.btn.tip="提示";
local.btn.active="激活";
local.btn.config="配置";
local.btn.sort="排序";
local.btn.operate="操作";
local.btn.start="启动";
local.btn.delete0="删除";
local.btn.exchange="切换";
local.btn.import0="导入";
local.btn.export0="导出";
local.btn.inquire="查询";
local.btn.modify="修改";
local.btn.uninstall="卸载";
local.btn.grant="分配权限";
local.btn.searchAccount="查找账户";
local.btn.backupConfig="备份配置";
local.btn.mountConfig="挂载配置";
local.btn.creatVirtual="创建虚拟机";
local.btn.creatDisk='创建磁盘',
local.btn.reportInfo="详细报表";
local.btn.save="保存";
local.btn.cancle="取消";
local.btn.next="下一步";
local.btn.previous="上一步";
local.btn.detailInfo="详细信息";
local.btn.productRegister="注册产品";
local.btn.productActive="激活产品";
local.btn.viewGeneral="概览图";
local.btn.viewFile="文件浏览";
local.btn.stateWeek="一周运行状态";
local.btn.moreInfo="更多信息";
//tree
local.search="快速检索设备...";
local.defaultGroup="默认分组";
local.creatGroup="新建分组";
local.loading="正在加载数据,请稍候......";
local.loadingFailure="数据加载失败";
//state
local.normal="正常";
local.warn="警告";
local.serious="严重";
local.abnormal="异常";
local.ordinary="一般";
local.starting="启动中";
local.unstart="未启动";
local.unconfig="未配置";
local.toNow="至今";
local.usedSize="已用";
local.powerRead="只读";
local.powerReadWrite="读/写";
//name
local.memory="内存";
local.web="网络";
local.info="信息";
local.hardWare="硬件";
local.disk="硬盘";
local.device="设备";
local.storage="存储";
local.state="状态";
local.CDRom="光驱";
local.USB="USB控制器";
local.explain="说明";
local.capacity="容量";
local.produce="产生";
local.mount="挂载";
//grid
local.time="时间";
local.num="编号";
local.address="地址";
local.type="类型";
local.pcName="设备名称";
local.pcID="设备ID";
local.IP="IP地址";
local.sysType="系统类型";
//fieldset
local.basicInfo="基本信息";
local.snapInfo="快照信息";
local.useSize="占用空间";
//alert
local.deleteSuccess="删除成功";
local.deleteFailure="删除失败";
//window
local.window.tip="提示";
/*common end*/


/*backup start*/
local.backup.title2='台设备';
local.backup.titleControl="备份控制台";
local.backup.titleInfo="备份详情";
local.backup.systemInfo="系统信息";
local.backup.version="版本号";
local.backup.tabTitleBackup="备份";
local.backup.tabTitleWarn="预警";

local.backup.clientState="客户端状态";
local.backup.clientStateNo="未初始化";
local.backup.engineState="引擎状态";
local.backup.runState="运行状态";
local.backup.runInfo="运行信息";
local.backup.diskInfoGridChoice="选择";
local.backup.diskInfoGridInfo="磁盘信息";
local.backup.diskInfoGridBegin="起始分区";
local.backup.diskInfoGridSize="分区大小";
local.backup.diskInfoGridFormat="分区格式";
local.backup.diskInfoGridState="运行状态";
local.backup.diskInfoGridStateOver="镜像完成";
local.backup.diskInfoGridStateBeing="正在镜像";
local.backup.diskInfoGridStateFailure="镜像失败";
local.backup.diskInfoGridStateError="镜像出错";
local.backup.diskInfoGridStateNot="未镜像";
local.backup.diskInfoGridCheck="正在校验";
local.backup.diskInfoGridCheckError="校验出错";

local.backup.tabDiskinfo="磁盘信息";
local.backup.tabBackupStrategy="备份策略";
local.backup.tabLog="日志";
/*预警*/
local.backup.warnTitle="预警控制台";
local.backup.warnTitleMonitor="预警监控";

local.backup.warnNormal="当前设备状态良好，无异常事件";
local.backup.warnDiskState="硬盘状态";
local.backup.warnSystemState="系统状态";
local.backup.warnProgramState="程序状态";
local.backup.warnServiceState="服务状态";

local.backup.monitorCpu="CPU监控";
local.backup.monitorWeb="网络监控";
local.backup.monitorMemory="内存监控";
local.backup.monitorStorage="存储监控";

local.backup.usageCpu="CPU使用率";
local.backup.usageMemory="内存使用率";
local.backup.usageWeb="网络使用率";
local.backup.usageStorage="存储使用率";
local.backup.diskWarnConfig="硬件预警配置";
//tab
local.backup.tabMonitorDisk="硬件监控";
local.backup.tabMonitorSystem="系统监控";
local.backup.tabMonitorProgram="程序监控";
local.backup.tabMonitorService="服务监控";
local.backup.tabMonitorLog="监控日志";
//config window
local.backup.dataSource="数据源";
local.backup.synStrategy="同步策略";
local.backup.snapStrategy="快照策略";
local.backup.choiceSource="请选择数据源";
local.backup.dataSourceExplain="应急接管必须选中引导分区。如：Windows2008 系统100MB 分区.如果该设备系统为Linux系统，swap(交换分区)不用备份，所以swap(交换分区)是不能选择的。每块硬盘的容量大小不能超过2TB。";

local.backup.choiceStorage="存储位置选择";
local.backup.synStrategyConfig="同步策略设置";
local.backup.interval="间隔时间";
local.backup.synTime="同步时间段限制";
local.backup.synTimeLast="最后同步时间";
local.backup.configSynTimePause="设置数据同步暂停时间段";
local.backup.fromTime="从开始时间";
local.backup.to="到";
local.backup.pauseSyn="之间暂停数据同步";
local.backup.backuoSpeedLimit="备份速度限制";
local.backup.backuoSpeedLimitOpen="开启备份速度限制";
local.backup.synStrategyExplain="如果开启同步功能的硬盘，就可以设置每个硬盘，自动同步数据之间的时间间隔。";

local.backup.snapPeriod="快照周期";
local.backup.snapInfo="快照详细信息";
local.backup.emeryInfo="快照详细信息";
local.backup.snapPeriodCount="快照统计";
local.backup.snapPeriodConfig="快照周期设置";
local.backup.snapPeriodConfigDescribe="描述：当设置快照间隔时间后(默认为两天)，系统会产生一次快照";
local.backup.snapSaveStrategy="快照保存策略";
local.backup.snapSaveStrategyMost="保存最大快照数限制";
local.backup.snapSaveStrategyLong="保存最长快照数限制";


/*backup end*/

/*emergency start*/
local.emergency.title2="个设备";
local.emergency.VM="虚拟机";
local.emergency.nodeCount="计算节点";

//grid
local.emergency.gridServerName="主机名称";
local.emergency.gridIP="源设备IP地址";
local.emergency.gridName="源设备名称";
local.emergency.gridNode="所在计算节点";
local.emergency.gridAbility="性能";
local.emergency.gridState="状态";
local.emergency.gridHander="操作";
/*emergency end*/

/*recovery start*/
local.recovery.title2="个挂载点";
local.recovery.creatMount="创建挂载";
local.recovery.tabAll="全部";
local.recovery.free="空闲";
local.recovery.used="已使用";
local.emergency.nodeSave="存储节点";
local.recovery.mountName="挂载名称";
local.recovery.mountTime="挂载时间";
local.recovery.uninstallTime="卸载时间";
local.recovery.mountDevice="挂载设备";
local.recovery.mountDrive="挂载盘符";
local.recovery.mountState="挂载状态";
local.recovery.mountRemark="挂载备注";
local.recovery.mountType="挂载方式";
local.recovery.mountPower="挂载权限";
local.recovery.mountStateNot="未挂载";
local.recovery.mountStateYes="已挂载";
local.recovery.mountStateFailure="挂载失败";
local.recovery.mountStateSuccess="挂载成功";
local.recovery.mountStateUnSuccess="卸载挂载成功";
local.recovery.chooseDisk="请选择一个盘符";
local.recovery.chooseDevice="请选择一个设备";
local.recovery.chooseTargetDevice="选择目标设备";
local.recovery.choosedTargetDevice="已选择的目标设备";
local.recovery.matchSystem="匹配当前系统";
local.recovery.matchMountTypeList="匹配挂载方式列表";
local.recovery.mountWinExplain="挂载的目标设备必须和源设备属于同一种平台，windows平台的镜像数据只能挂载到windows目标设备上。Linux平台的镜像数据只能挂载到Linux目标设备上。";
local.recovery.tipMountConfigFailure="挂载配置插入失败";
local.recovery.tipMountConfigSuccess="挂载配置成功";
local.recovery.tipMountConfigError="挂载配置出现异常";

local.recovery.diskNum="硬盘编号";
local.recovery.diskPart="硬盘分区";
local.recovery.diskSnap="快照数量";
local.recovery.diskFileName="磁盘文件名";
local.recovery.dataAll="份数据集，共有";
local.recovery.dataAll2="份数据集";
local.recovery.dataNum="个快照集";
local.recovery.viewSnapInfo="点击数据集查看快照集信息";
local.recovery.diskSetNum="磁盘大小设置";
local.recovery.diskSetNumM="最大磁盘大小";
local.recovery.tipNumM="请输入有效的整数";
local.recovery.snapSrc="快照路径";
local.recovery.snapTime="快照时间";

//Vm
local.recovery.targetDevice="目标设备";
local.recovery.targetDeviceName="目标设备名称";
local.recovery.targetDeviceChooseFirst="请先选择挂载目标设备";
local.recovery.targetDeviceChoose="请选择挂载目标设备";
local.recovery.targetDeviceInfo="目标设备信息";
local.recovery.targetDeviceIP="目标IP地址";
local.recovery.chooseStorage="请选择存储介质";
local.recovery.VDNull="空虚拟磁盘";
local.recovery.VD="虚拟磁盘(有数据)";
local.recovery.creatNewVm="创建虚拟磁盘配置";
local.recovery.creatNewVmF="创建虚拟磁盘失败";
local.recovery.creatNewVmS="创建虚拟磁盘成功";
local.recovery.creatNewVmE="创建虚拟磁盘异常";
local.recovery.tipDiskUsed="该磁盘正在被使用，请稍后重试!";
local.recovery.tipMCE="挂载配置出现异常，请稍后重试!";
local.recovery.tipDSnap="你确定要删除临时快照吗?";
local.recovery.tipDSnapS="临时快照删除成功";
local.recovery.tipDSnapU="临时快照正在被使用,请稍后重试!";
local.recovery.tipDSnapE="删除临时快照异常，请稍后重试!";
local.recovery.dSnap="删除快照";
local.recovery.mountGrid="卷/分区挂载";
local.recovery.mountWinPart="卷/分区";
local.recovery.mountGridNoraml="普通挂载";
local.recovery.deviceList="应急设备列表";
local.recovery.chooseStr="选择字符串";
local.recovery.chooseConnStr="--选择连接字符串--";
local.recovery.MonitorStateWeek="一周内运行状态";

/*recovery end*/

/*log start*/
local.log.title2="已运行";
local.log.title3="天，期间为您发现了";
local.log.title4="故障，并通知了您";
local.log.systemPlatform="系统平台";
local.log.failureEvent="故障事件";
//grid
local.log.gridLevel="级别";
local.log.gridEvent="事件";
local.log.gridTime="时间";
local.log.gridSource="来源";
local.log.gridRemark="备注";
//全网报表
local.log.title5="台设备中";
local.log.title6="台性能严重不足";
local.log.title7="台性能警告";
local.log.abilitySerious="严重性能不足";
local.log.abilityWarn="警告性能不足";
/*log end*/

/*config start*/
//存储节点
local.config.title2="共有";
local.config.title3="个存储节点";
local.config.address="地址与端口";
local.config.name="存储节点名称";
local.config.storageFirst="存储优先";
local.config.storageType="存储类型";
local.config.maxManageNum="并发数";
local.config.state="运行状态";
//right menu
local.config.menuSetDefault="设置默认";
local.config.menuDelStorage="删除存储器";
local.config.menuDelMedia="删除存储介质";
local.config.menuSetFirstIP="设置首选";
local.config.menuMediaRedirect="介质重定向";
local.config.menuExchange="切换";
local.config.SetDefaultVMS="设置默认VMS";
//grid
local.config.storageIP= '存储器标识';
local.config.storageName= '存储器名称';
local.config.IPIn= '内网IP地址 ';
local.config.IPOut= '外网IP地址 ';
local.config.storagePort= '存储器端口 ';
local.config.storageMaxNum= '存储器并发数 ';
local.config.host= '宿主机平台 ';
local.config.time= '安装时间';
local.config.mediaName= '介质名称';
local.config.mediaSrc= '所在路径';
local.config.freeSpace= '剩余空间';
//config window 
local.config.windowConfigTitle="配置存储服务器信息";
local.config.windowConfigInfo="存储服务器信息";
local.config.windowConfigExplain="可以修改存储器的IP地址和数据传输端口。注意：输入端口应为空闲端口，例如：5678。";
local.config.windowNewVmsTitle="添加VMS";
local.config.windowNewVmsInfo="存储介质服务器信息";
local.config.windowNewVmsMediaName="介质服务器名称";
local.config.windowNewVmsSaveName="存储名称";
local.config.windowNewVmsSaveSrc="存储路径";
local.config.windowNewVmsExplain="VMS介质应与操作系统所在分区隔离，请不要选择系统分区作为存储路径。";
//cal node
local.config.titleCla3="个计算节点";
local.config.calNodeName="计算节点名称";
local.config.NodeAbility="节点性能";
local.config.emergencyHostNum="应急主机数";
//system config
local.config.systemConfigTitleInfo="用于系统相关的配置";
local.config.serverConfig="服务器配置";
local.config.serverName="服务器名称";
local.config.port="端口";
local.config.serverConfigExplain="设置服务器的网络地址和端口，它通常用于多网卡环境或者端口冲突";
local.config.systemSafety="系统安全";
local.config.systemSafetyLogin="用于配置服务器端登陆限制";
local.config.systemSafetyPassword="密码强度验证";
local.config.log="日志管理";
local.config.logClear="日志自动清除";
local.config.logExplain="日志与执行清单自动清除的配置，记录总数超出后自动提示备份或者清除";
local.config.backup="备份系统配置备份";
local.config.backupTime="最后导出时间";
local.config.backupExplain="对管理平台自身运行环境的进行定期的备份，必要时可以及时回复管理平台运行环境";
local.config.DB="数据库备份";
local.config.DBSrc="数据库备份文件路径";
local.config.DBExplain="数据库备份采用mysqldump方式备份,每天在某一个时段执行一次备份并产生一个以数据库名字加时间格式的文件,备份路径默认使用存储器的路径(如:S1[D:/StoreBackup]加上/BD),备份路径不能为空!";
//client config
local.config.clientConfigInfo="用于客户端相关的配置";
local.config.terminalRegister="终端注册配置";
local.config.terminalRegisterAuto="允许自动注册";
local.config.terminalRegisterSpace="限制空间";
local.config.terminalRegisterExplain="管理从终端注册配置的信息";
local.config.terminalInstall="终端安装配置";
local.config.terminalInstallIcon="显示终端托盘图标";
local.config.terminalInstallHover="显示悬浮框";
local.config.terminalInstallDataDel="禁止删除数据";
local.config.passwordUninstall="卸载密码";
local.config.passwordUninstallUse="是否启用终端卸载密码";
local.config.passwordUninstallExplain="卸载后台型客户端时，可以设定卸载密码，只有输入密码才能卸载";
//account config
local.config.accountConfigInfo="管理用户的账号以及密码";
local.config.userName="用户名称";
local.config.validationType="验证类型";
local.config.describe="描述";
local.config.operationAuth="操作权限";
local.config.operationCheck="查看";
local.config.stonodeAuth="存储结点权限";
local.config.calnodeAuth="计算结点权限";
//autorize
local.config.authoriseInfo="用于授权版本可以使用多久";
local.config.productUuid="产品标识";
local.config.productType="产品类型";
local.config.versionType="版本类型";
local.config.registerTime="注册时间";
local.config.remainDays="剩余天数";
/*config end*/