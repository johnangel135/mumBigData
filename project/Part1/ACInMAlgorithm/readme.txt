[cloudera@quickstart ~]$ hadoop jar acimalgorithm.jar org.myorg.acima.Demo /user/cloudera/input2 /user/cloudera/out2
========Average Computation In Mapper Algorithm========
17/11/15 09:09:57 INFO client.RMProxy: Connecting to ResourceManager at /0.0.0.0:8032
17/11/15 09:09:57 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
17/11/15 09:09:58 INFO input.FileInputFormat: Total input paths to process : 1
17/11/15 09:09:58 INFO mapreduce.JobSubmitter: number of splits:1
17/11/15 09:09:58 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1510697007852_0010
17/11/15 09:09:59 INFO impl.YarnClientImpl: Submitted application application_1510697007852_0010
17/11/15 09:09:59 INFO mapreduce.Job: The url to track the job: http://quickstart.cloudera:8088/proxy/application_1510697007852_0010/
17/11/15 09:09:59 INFO mapreduce.Job: Running job: job_1510697007852_0010
17/11/15 09:10:12 INFO mapreduce.Job: Job job_1510697007852_0010 running in uber mode : false
17/11/15 09:10:12 INFO mapreduce.Job:  map 0% reduce 0%
17/11/15 09:10:21 INFO mapreduce.Job:  map 100% reduce 0%
17/11/15 09:10:33 INFO mapreduce.Job:  map 100% reduce 100%
17/11/15 09:10:34 INFO mapreduce.Job: Job job_1510697007852_0010 completed successfully
17/11/15 09:10:35 INFO mapreduce.Job: Counters: 49
	File System Counters
		FILE: Number of bytes read=6462
		FILE: Number of bytes written=263371
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=173032
		HDFS: Number of bytes written=5227
		HDFS: Number of read operations=6
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
	Job Counters 
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=6241
		Total time spent by all reduces in occupied slots (ms)=8448
		Total time spent by all map tasks (ms)=6241
		Total time spent by all reduce tasks (ms)=8448
		Total vcore-milliseconds taken by all map tasks=6241
		Total vcore-milliseconds taken by all reduce tasks=8448
		Total megabyte-milliseconds taken by all map tasks=6390784
		Total megabyte-milliseconds taken by all reduce tasks=8650752
	Map-Reduce Framework
		Map input records=1547
		Map output records=169
		Map output bytes=6118
		Map output materialized bytes=6462
		Input split bytes=128
		Combine input records=0
		Combine output records=0
		Reduce input groups=169
		Reduce shuffle bytes=6462
		Reduce input records=169
		Reduce output records=169
		Spilled Records=338
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=92
		CPU time spent (ms)=2800
		Physical memory (bytes) snapshot=448671744
		Virtual memory (bytes) snapshot=3134509056
		Total committed heap usage (bytes)=324009984
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=172904
	File Output Format Counters 
		Bytes Written=5227
[cloudera@quickstart ~]$ hadoop fs -cat /user/cloudera/out2/*
0x503e4fce.virnxx2.adsl-dhcp.tele.dk	1078.0
1-320.cnc.bc.ca	10936.0
1-729.cnc.bc.ca	6459.0
10.0.0.153	1582.0
12.22.207.235	7368.0
128.227.88.79	10419.0
142.27.64.35	6271.0
145.253.208.9	1078.0
1513.cps.virtua.com.br	309.0
194.151.73.43	7939.0
195.11.231.210	6032.0
195.230.181.122	2300.0
195.246.13.119	4534.0
2-110.cnc.bc.ca	10936.0
2-238.cnc.bc.ca	3169.0
200-55-104-193.dsl.prima.net.ar	1078.0
200.160.249.68.bmf.com.br	2877.0
200.222.33.33	2300.0
203.147.138.233	1509.0
206-15-133-153.dialup.ziplink.net	0.0
206-15-133-154.dialup.ziplink.net	0.0
206-15-133-181.dialup.ziplink.net	0.0
207.195.59.160	5253.0
208-186-146-13.nrp3.brv.mn.frontiernet.net	1078.0
208-38-57-205.ip.cal.radiant.net	3998.0
208.247.148.12	3049.0
212.21.228.26	2869.0
212.92.37.62	7368.0
213.181.81.4	7649.0
216-160-111-121.tukw.qwest.net	1575.0
216.139.185.45	6051.0
219.95.17.51	3169.0
3_343_lt_someone	5517.0
4.37.97.186	2446.0
61.165.64.6	3049.0
61.9.4.61	284.0
64-249-27-114.client.dsl.net	7368.0
64-93-34-186.client.dsl.net	2869.0
64.242.88.10	4114.0
64.246.94.141	0.0
64.246.94.152	0.0
65-37-13-251.nrp2.roc.ny.frontiernet.net	8632.0
66-194-6-70.gen.twtelecom.net	3169.0
66-194-6-71.gen.twtelecom.net	3169.0
66-194-6-79.gen.twtelecom.net	3169.0
66.213.206.2	3169.0
67.131.107.5	2877.0
68-174-110-154.nyc.rr.com	1078.0
80.58.14.235.proxycache.rima-tde.net	3049.0
80.58.33.42.proxycache.rima-tde.net	4534.0
80.58.35.111.proxycache.rima-tde.net	4114.0
92-moc-6.acn.waw.pl	5691.0
a213-84-36-192.adsl.xs4all.nl	3169.0
acbf6930.ipt.aol.com	7649.0
adsl-157-26-153.msy.bellsouth.net	2877.0
adsl-64-173-42-65.dsl.snfc21.pacbell.net	2300.0
alille-251-1-2-197.w82-124.abo.wanadoo.fr	2869.0
archserve.id.ucsb.edu	1078.0
barrie-ppp108371.sympatico.ca	3049.0
bh02i525f01.au.ibm.com	2300.0
c-24-11-14-147.client.comcast.net	1078.0
c-24-20-163-223.client.comcast.net	5253.0
c-411472d5.04-138-73746f22.cust.bredbandsbolaget.se	2869.0
cacher2-ext.wise.edt.ericsson.se	2869.0
calcite.rhyolite.com	18971.0
cpe-203-51-137-224.vic.bigpond.net.au	6893.0
cr020r01-3.sac.overture.com	58169.0
crawl24-public.alexa.com	4449.0
d207-6-50-215.bchsia.telus.net	3095.0
d207-6-9-183.bchsia.telus.net	3376.0
d97082.upc-d.chello.nl	7368.0
dialup-5-81.tulane.edu	4175.0
dsl-80-43-113-44.access.uk.tiscali.com	2878.0
fw.aub.dk	2877.0
fw.kcm.org	2877.0
fw1.millardref.com	7939.0
grandpa.mmlc.northwestern.edu	1078.0
h24-68-45-227.gv.shawcable.net	7074.0
h24-70-56-49.ca.shawcable.net	4901.0
h24-70-69-74.ca.shawcable.net	5517.0
h24-71-236-129.ca.shawcable.net	1134.0
h24-71-249-14.ca.shawcable.net	13973.0
home.yeungs.net	2300.0
ic8234.upco.es	3629.0
ip-200-56-225-61-mty.marcatel.net.mx	2869.0
ip68-228-43-49.tc.ph.cox.net	4062.0
ipcorp-c8b07af1.terraempresas.com.br	7368.0
jacksonproject.cnc.bc.ca	6271.0
korell2.cc.gatech.edu	2869.0
l07v-1-17.d1.club-internet.fr	3169.0
ladybug.cns.vt.edu	5691.0
lhr003a.dhl.com	1526.0
lj1000.inktomisearch.com	7529.0
lj1007.inktomisearch.com	68.0
lj1008.inktomisearch.com	209.0
lj1016.inktomisearch.com	209.0
lj1018.inktomisearch.com	209.0
lj1024.inktomisearch.com	68.0
lj1025.inktomisearch.com	209.0
lj1027.inktomisearch.com	209.0
lj1028.inktomisearch.com	209.0
lj1031.inktomisearch.com	209.0
lj1036.inktomisearch.com	209.0
lj1048.inktomisearch.com	68.0
lj1052.inktomisearch.com	68.0
lj1053.inktomisearch.com	209.0
lj1061.inktomisearch.com	209.0
lj1073.inktomisearch.com	209.0
lj1088.inktomisearch.com	209.0
lj1089.inktomisearch.com	209.0
lj1090.inktomisearch.com	3860.0
lj1105.inktomisearch.com	209.0
lj1115.inktomisearch.com	4156.0
lj1117.inktomisearch.com	209.0
lj1120.inktomisearch.com	5234.0
lj1123.inktomisearch.com	8667.0
lj1125.inktomisearch.com	209.0
lj1145.inktomisearch.com	4612.0
lj1153.inktomisearch.com	209.0
lj1156.inktomisearch.com	4619.0
lj1159.inktomisearch.com	209.0
lj1162.inktomisearch.com	3884.0
lj1164.inktomisearch.com	209.0
lj1168.inktomisearch.com	209.0
lj1212.inktomisearch.com	3169.0
lj1216.inktomisearch.com	209.0
lj1220.inktomisearch.com	209.0
lj1223.inktomisearch.com	209.0
lj1231.inktomisearch.com	209.0
lordgun.org	2869.0
mail.geovariances.fr	8632.0
market-mail.panduit.com	4564.0
mcl02.cnc.bc.ca	7939.0
mmscrm07-2.sac.overture.com	68.0
mth-fgw.ballarat.edu.au	5543.0
nb-bolz.cremona.polimi.it	2300.0
ns.mou.cz	2300.0
ns.wtbts.org	1572.0
ns3.vonroll.ch	4646.0
ogw.netinfo.bg	5543.0
osdlab.eic.nctu.edu.tw	269.0
p213.54.168.132.tisdip.tiscali.de	5253.0
p5083cd5d.dip0.t-ipconnect.de	7368.0
pc-030-040.eco.rug.nl	7368.0
pc3-registry-stockholm.telia.net	5402.0
pd95f99f2.dip.t-dialin.net	2869.0
pd9e50809.dip.t-dialin.net	2869.0
pd9e761cf.dip.t-dialin.net	2300.0
pd9eb1396.dip.t-dialin.net	2300.0
pntn02m05-129.bctel.ca	3095.0
pool-68-160-195-60.ny325.east.verizon.net	2877.0
ppp2.p33.is.com.ua	2300.0
proxy0.haifa.ac.il	4004.0
prxint-sxb2.e-i.net	4022.0
prxint-sxb3.e-i.net	130.0
px7wh.vc.shawcable.net	7649.0
rouble.cc.strath.ac.uk	2869.0
spica.ukc.ac.uk	1078.0
spot.nnacorp.com	6697.0
trrc02m01-40.bctel.ca	3049.0
ts04-ip92.hevanet.com	5543.0
ts05-ip44.hevanet.com	5402.0
user-0c8hdkf.cable.mindspring.com	4583.0
vlp181.vlp.fi	2869.0
watchguard.cgmatane.qc.ca	4114.0
wc03.mtnk.rnc.net.cable.rogers.com	10936.0
wc09.mtnk.rnc.net.cable.rogers.com	7939.0
wwwcache.lanl.gov	2869.0
yongsan-cache.korea.army.mil	3049.0
[cloudera@quickstart ~]$ 
