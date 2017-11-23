[cloudera@quickstart ~]$ hadoop jar hybridimalgorithm.ja org.bigdata.hybridinmapper.Demo /user/cloudera/allpairinput /user/cloudera/outp4_2
Not a valid JAR: /home/cloudera/hybridimalgorithm.ja
[cloudera@quickstart ~]$ hadoop jar hybridimalgorithm.jar org.bigdata.hybridinmapper.Demo /user/cloudera/allpairinput /user/cloudera/outp4_2
========Hybrid In Mapper Algorithm========
17/11/15 13:11:11 INFO client.RMProxy: Connecting to ResourceManager at /0.0.0.0:8032
17/11/15 13:11:12 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
17/11/15 13:11:12 INFO input.FileInputFormat: Total input paths to process : 1
17/11/15 13:11:12 INFO mapreduce.JobSubmitter: number of splits:1
17/11/15 13:11:12 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1510697007852_0036
17/11/15 13:11:13 INFO impl.YarnClientImpl: Submitted application application_1510697007852_0036
17/11/15 13:11:13 INFO mapreduce.Job: The url to track the job: http://quickstart.cloudera:8088/proxy/application_1510697007852_0036/
17/11/15 13:11:13 INFO mapreduce.Job: Running job: job_1510697007852_0036
17/11/15 13:11:21 INFO mapreduce.Job: Job job_1510697007852_0036 running in uber mode : false
17/11/15 13:11:21 INFO mapreduce.Job:  map 0% reduce 0%
17/11/15 13:11:28 INFO mapreduce.Job:  map 100% reduce 0%
17/11/15 13:11:41 INFO mapreduce.Job:  map 100% reduce 25%
17/11/15 13:11:44 INFO mapreduce.Job:  map 100% reduce 50%
17/11/15 13:11:46 INFO mapreduce.Job:  map 100% reduce 100%
17/11/15 13:11:47 INFO mapreduce.Job: Job job_1510697007852_0036 completed successfully
17/11/15 13:11:48 INFO mapreduce.Job: Counters: 50
	File System Counters
		FILE: Number of bytes read=492
		FILE: Number of bytes written=628201
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=224
		HDFS: Number of bytes written=493
		HDFS: Number of read operations=15
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=8
	Job Counters 
		Killed reduce tasks=1
		Launched map tasks=1
		Launched reduce tasks=4
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=4103
		Total time spent by all reduces in occupied slots (ms)=48733
		Total time spent by all map tasks (ms)=4103
		Total time spent by all reduce tasks (ms)=48733
		Total vcore-milliseconds taken by all map tasks=4103
		Total vcore-milliseconds taken by all reduce tasks=48733
		Total megabyte-milliseconds taken by all map tasks=4201472
		Total megabyte-milliseconds taken by all reduce tasks=49902592
	Map-Reduce Framework
		Map input records=3
		Map output records=26
		Map output bytes=416
		Map output materialized bytes=492
		Input split bytes=134
		Combine input records=0
		Combine output records=0
		Reduce input groups=26
		Reduce shuffle bytes=492
		Reduce input records=26
		Reduce output records=6
		Spilled Records=52
		Shuffled Maps =4
		Failed Shuffles=0
		Merged Map outputs=4
		GC time elapsed (ms)=303
		CPU time spent (ms)=5320
		Physical memory (bytes) snapshot=915390464
		Virtual memory (bytes) snapshot=7853453312
		Total committed heap usage (bytes)=739770368
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=90
	File Output Format Counters 
		Bytes Written=493
