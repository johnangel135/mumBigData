[cloudera@quickstart ~]$ hadoop jar hybrid.jar org.bigdata.hybrid.Demo /user/cloudera/allpairinput /user/cloudera/outp4_1
========Hybrid Algorithm========
17/11/15 13:08:08 INFO client.RMProxy: Connecting to ResourceManager at /0.0.0.0:8032
17/11/15 13:08:09 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
17/11/15 13:08:09 INFO input.FileInputFormat: Total input paths to process : 1
17/11/15 13:08:09 INFO mapreduce.JobSubmitter: number of splits:1
17/11/15 13:08:10 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1510697007852_0035
17/11/15 13:08:10 INFO impl.YarnClientImpl: Submitted application application_1510697007852_0035
17/11/15 13:08:10 INFO mapreduce.Job: The url to track the job: http://quickstart.cloudera:8088/proxy/application_1510697007852_0035/
17/11/15 13:08:10 INFO mapreduce.Job: Running job: job_1510697007852_0035
17/11/15 13:08:18 INFO mapreduce.Job: Job job_1510697007852_0035 running in uber mode : false
17/11/15 13:08:18 INFO mapreduce.Job:  map 0% reduce 0%
17/11/15 13:08:23 INFO mapreduce.Job:  map 100% reduce 0%
17/11/15 13:08:36 INFO mapreduce.Job:  map 100% reduce 25%
17/11/15 13:08:39 INFO mapreduce.Job:  map 100% reduce 50%
17/11/15 13:08:40 INFO mapreduce.Job:  map 100% reduce 100%
17/11/15 13:08:42 INFO mapreduce.Job: Job job_1510697007852_0035 completed successfully
17/11/15 13:08:42 INFO mapreduce.Job: Counters: 50
	File System Counters
		FILE: Number of bytes read=1176
		FILE: Number of bytes written=629433
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
		Total time spent by all maps in occupied slots (ms)=3750
		Total time spent by all reduces in occupied slots (ms)=48750
		Total time spent by all map tasks (ms)=3750
		Total time spent by all reduce tasks (ms)=48750
		Total vcore-milliseconds taken by all map tasks=3750
		Total vcore-milliseconds taken by all reduce tasks=48750
		Total megabyte-milliseconds taken by all map tasks=3840000
		Total megabyte-milliseconds taken by all reduce tasks=49920000
	Map-Reduce Framework
		Map input records=3
		Map output records=64
		Map output bytes=1024
		Map output materialized bytes=1176
		Input split bytes=134
		Combine input records=0
		Combine output records=0
		Reduce input groups=26
		Reduce shuffle bytes=1176
		Reduce input records=64
		Reduce output records=6
		Spilled Records=128
		Shuffled Maps =4
		Failed Shuffles=0
		Merged Map outputs=4
		GC time elapsed (ms)=426
		CPU time spent (ms)=4990
		Physical memory (bytes) snapshot=899567616
		Virtual memory (bytes) snapshot=7855779840
		Total committed heap usage (bytes)=661127168
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
