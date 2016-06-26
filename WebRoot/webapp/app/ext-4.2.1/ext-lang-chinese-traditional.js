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
local.backup.title='備份監控';
local.emergency.title='應急接管';
local.recovery.title='恢復存儲';
local.log.title='報表日誌';
local.config.title='系統配置';
local.log.titleSystemReport='系統報表';
local.log.titleEntireReport='全網報表';
local.log.titleSystemLog='系統日誌';
local.log.titleClientLog='客戶端日誌';
local.log.titleInfoService='消息服務器';
local.log.titleEmergencyLog='應急日誌';
local.log.titleWarnLog='預警日誌';
local.config.clientConfig="客戶端設置";
local.config.accountConfig="賬號管理";
local.config.authorise="許可證授權";

//btn
local.btn.refresh="刷新";
local.btn.new0="新建";
local.btn.tip="提示";
local.btn.active="激活";
local.btn.config="配置";
local.btn.sort="排序";
local.btn.operate="操作";
local.btn.start="啟動";
local.btn.delete0="刪除";
local.btn.exchange="切換";
local.btn.import0="導入";
local.btn.export0="導出";
local.btn.inquire="查詢";
local.btn.modify="修改";
local.btn.grant="分配權限";
local.btn.searchAccount="查找賬戶";
local.btn.backupConfig="備份配置";
local.btn.mountConfig="掛載配置";
local.btn.creatVirtual="創建虛擬機";
local.btn.creatDisk='創建磁盤',
local.btn.reportInfo="詳細報表";
local.btn.save="保存";
local.btn.cancle="取消";
local.btn.next="下一步";
local.btn.previous="上一步";
local.btn.detailInfo="詳細信息";
local.btn.productRegister="註冊產品";
local.btn.productActive="激活產品";
//tree
local.search="快速檢索設備...";
local.defaultGroup="默認分組";
local.creatGroup="新建分組";
local.loading="正在加載數據，请稍候......";
//state
local.normal="正常";
local.warn="警告";
local.serious="嚴重";
local.abnormal="異常";
local.ordinary="一般";
local.starting="啟動中";
local.unstart="未啟動";
local.unconfig="未配置";
//name
local.memory="內存";
local.web="網絡";
local.info="信息";
local.hardWare="硬件";
local.disk="硬盤";
local.device="設備";
local.storage="存儲";
local.state="狀態";
local.CDRom="光驅";
local.USB="USB控制器";
local.explain="說明";
//grid
local.time="時間";
local.num="編號";
local.address="地址";
//window
local.window.tip="提示";
/*common end*/


/*backup start*/
local.backup.title2='台設備';
local.backup.titleControl="備份控制台";
local.backup.titleInfo="備份詳情";
local.backup.systemInfo="系統信息";
local.backup.version="版本號";
local.backup.tabTitleBackup="備份";
local.backup.tabTitleWarn="預警";

local.backup.clientState="客戶端狀態";
local.backup.clientStateNo="未初始化";
local.backup.engineState="引擎狀態";
local.backup.runState="運行狀態";
local.backup.runInfo="運行信息";
local.backup.diskInfoGridChoice="選擇";
local.backup.diskInfoGridInfo="磁盤信息";
local.backup.diskInfoGridBegin="起始扇區";
local.backup.diskInfoGridSize="分區大小";
local.backup.diskInfoGridFormat="分區格式";
local.backup.diskInfoGridState="運行狀態";
local.backup.diskInfoGridStateOver="鏡像完成";
local.backup.diskInfoGridStateBeing="正在鏡像";
local.backup.diskInfoGridStateFailure="鏡像失敗";

local.backup.tabDiskinfo="磁盤信息";
local.backup.tabBackupStrategy="備份策略";
local.backup.tabLog="日誌";
/*预警*/
local.backup.warnTitle="預警控制台";
local.backup.warnTitleMonitor="預警監控";

local.backup.warnNormal="當前設備狀態良好，無異常事件";
local.backup.warnDiskState="硬盤狀態";
local.backup.warnSystemState="系統狀態";
local.backup.warnProgramState="程序狀態";
local.backup.warnServiceState="服務狀態";

local.backup.monitorCpu="CPU監控";
local.backup.monitorWeb="網絡監控";
local.backup.monitorMemory="內存監控";
local.backup.monitorStorage="存儲監控";

local.backup.usageCpu="CPU使用率使";
local.backup.usageMemory="內存使用率";
local.backup.usageWeb="網絡使用率";
local.backup.usageStorage="存儲使用率";
local.backup.diskWarnConfig="硬件預警配置";
//tab
local.backup.tabMonitorDisk="硬件監控";
local.backup.tabMonitorSystem="系統監控";
local.backup.tabMonitorProgram="程序監控";
local.backup.tabMonitorService="服務監控";
local.backup.tabMonitorLog="監控日誌";
//config window
local.backup.dataSource="數據源";
local.backup.synStrategy="同步策略";
local.backup.snapStrategy="快照策略";
local.backup.choiceSource="請選擇數據源";
local.backup.dataSourceExplain="應急接管必須選中引導分區。如：Windows2008 系統100MB 分區。如果該設備系統為Linux系統，swap(交換分區)不用備份，所以swap(交換分區)是不能選擇的。每塊硬盤的容量大小不能超過2TB。";

local.backup.choiceStorage="存儲位置選擇";
local.backup.synStrategyConfig="同步策略設置";
local.backup.interval="間隔時間";
local.backup.synTime="同步時間段限制";
local.backup.configSynTimePause="設置數據同步暫停時間段";
local.backup.fromTime="從開始時間";
local.backup.to="到";
local.backup.pauseSyn="之間暫停數據同步";
local.backup.backuoSpeedLimit="備份速度限制";
local.backup.backuoSpeedLimitOpen="開啟備份速度限制";
local.backup.synStrategyExplain="如果開啟同步功能的硬盤，就可以設置每個硬盤，自動同步數據之間的時間間隔。";

local.backup.snapPeriodConfig="快照週日設置";
local.backup.snapPeriodConfigDescribe="描述：當設置快照間隔時間后（默認為兩天），系統會產生一次快照";
local.backup.snapSaveStrategy="快照保存策略";
local.backup.snapSaveStrategyMost="保存最大快照數限制";
local.backup.snapSaveStrategyLong="保存最長快招數限制";


/*backup end*/

/*emergency start*/
local.emergency.title2="個設備";
local.emergency.VM="虛擬機";
local.emergency.nodeCount="計算節點";

//grid
local.emergency.gridServerName="主機名稱";
local.emergency.gridIP="源設備IP地址";
local.emergency.gridName="源設備名稱";
local.emergency.gridNode="所在計算節點";
local.emergency.gridAbility="性能";
local.emergency.gridState="狀態";
local.emergency.gridHander="操作";
/*emergency end*/

/*recovery start*/
local.recovery.title2="個掛載點";
local.recovery.tabAll="全部";
local.recovery.free="空閒";
local.recovery.used="已使用";
local.emergency.nodeSave="存儲節點";
local.recovery.mountName="掛載名稱";
local.recovery.mountDevice="掛載設備";
local.recovery.mountDrive="掛載盤符";
local.recovery.mountState="掛載狀態";
local.recovery.mountStateNot="未掛載";
local.recovery.mountStateYes="已掛載";
local.recovery.mountStateFailure="掛載失敗";
local.recovery.diskNum="硬盤編號";
local.recovery.diskPart="硬盤分區";
local.recovery.diskSnap="快照數量";
//mountconfig 
local.recovery.targetDevice="目標設備";
/*recovery end*/

/*log start*/
local.log.title2="已運行";
local.log.title3="天，期間為您發現了";
local.log.title4="故障，并通知了您";
local.log.systemPlatform="系統平台";
local.log.failureEvent="故障事件";
//grid
local.log.gridLevel="級別";
local.log.gridEvent="事件";
local.log.gridTime="時間";
local.log.gridSource="來源";
local.log.gridRemark="備註";
//全网报表
local.log.title5="台設備中";
local.log.title6="台性能嚴重不足";
local.log.title7="台性能警告";
local.log.abilitySerious="嚴重性能不足";
local.log.abilityWarn="警告性能不足";
/*log end*/

/*config start*/
//存储节点
local.config.title2="共有";
local.config.title3="個存儲節點";
local.config.address="地址與端口";
local.config.name="存儲節點名稱";
local.config.storageFirst="存储优先 存儲優先";
local.config.storageType="存儲類型";
local.config.maxManageNum="並發數";
local.config.state="運行狀態";
//right menu
local.config.menuSetDefault="設置默認";
local.config.menuDelStorage="刪除存儲器";
local.config.menuDelMedia="刪除存儲介質";
local.config.menuSetFirstIP="設置首選";
local.config.menuMediaRedirect="介質重定向";
local.config.menuExchange="切換";
//grid
local.config.storageIP= '存儲器標識';
local.config.storageName= '存儲器名稱';
local.config.IPIn= '內網IP地址 ';
local.config.IPOut= '外網IP地址 ';
local.config.storagePort= '存儲器端口 ';
local.config.storageMaxNum= '存儲器並發數 ';
local.config.host= '宿主機平台 ';
local.config.time= '安裝時間';
local.config.mediaName= '介質名稱';
local.config.mediaSrc= '所在路徑';
local.config.freeSpace= '剩餘空間';
//config window 
local.config.windowConfigTitle="配置存儲服務器信息";
local.config.windowConfigInfo="存儲服務器信息";
local.config.windowConfigExplain="可以修改存儲器的IP地址和數據傳輸端口。注意：輸入端口應為空閒端口，例如：5678。";
local.config.windowNewVmsTitle="添加VMS";
local.config.windowNewVmsInfo="存儲介質服務器信息";
local.config.windowNewVmsMediaName="介質服務器名稱";
local.config.windowNewVmsSaveSrc="存儲路徑";
local.config.windowNewVmsExplain="VMS介質應與操作系統所在分區隔離，請不要選擇系統分區作為存儲路徑。";
//cal node
local.config.titleCla3="個計算節點";
local.config.calNodeName="計算節點名稱";
local.config.NodeAbility="節點性能";
local.config.emergencyHostNum="應急主機書";
//system config
local.config.systemConfigTitleInfo="用於系統相關的配置";
local.config.serverConfig="服務器配置";
local.config.serverName="服務器名稱";
local.config.port="端口";
local.config.serverConfigExplain="設置服務器的網絡地址和端口，它通常用於多網卡環境或者端口衝突";
local.config.systemSafety="系統安全";
local.config.systemSafetyLogin="用於配置服務器端登陸限制";
local.config.systemSafetyPassword="密碼強度限制";
local.config.log="日誌管理";
local.config.logClear="日誌自動清除";
local.config.logExplain="日誌與執行清單自動清除的配置，記錄總數超出後自動提示備份或者清除";
local.config.backup="備份系統配置備份";
local.config.backupTime="最後導出時間";
local.config.backupExplain="對管理平台自身運行環境的進行定期的備份，必要時可以及時回復管理平台運行環境";
local.config.DB="數據庫備份";
local.config.DBSrc="数据库备份文件路径 數據庫備份文件路徑";
local.config.DBExplain="數據庫備份採用mysqldump方式備份，每天在耨一個時段執行一次備份并產生一個數據庫名字加時間格式的文件，備份路徑默認使用存儲器的存儲器的路徑（如：S1[D:/StoreBackup]加上/BD），備份路徑不能為空！";
//client config
local.config.clientConfigInfo="用於客戶端相關的配置";
local.config.terminalRegister="終端註冊配置";
local.config.terminalRegisterAuto="允許自動註冊";
local.config.terminalRegisterSpace="限制空間";
local.config.terminalRegisterExplain="管理從終端註冊配置的信息";
local.config.terminalInstall="終端安裝配置";
local.config.terminalInstallIcon="顯示終端托盤圖標";
local.config.terminalInstallHover="顯示懸浮框";
local.config.terminalInstallDataDel="禁止刪除數據";
local.config.passwordUninstall="卸載密碼";
local.config.passwordUninstallUse="是否啟用終端卸載密碼";
local.config.passwordUninstallExplain="卸載後台型客戶端時，可以設定卸載密碼，只有輸入密碼才能卸載";
//account config
local.config.accountConfigInfo="管理用戶的賬號以及密碼";
local.config.userName="用戶名稱";
local.config.validationType="驗證類型";
local.config.describe="描述";
//autorize
local.config.authoriseInfo="用於授權版本可以使用多久";
local.config.productUuid="產品標識";
local.config.productType="產品類型";
local.config.versionType="版本類型";
local.config.registerTime="註冊時間";
local.config.remainDays="剩餘天數";
/*config end*/