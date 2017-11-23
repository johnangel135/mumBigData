[cloudera@quickstart ~]$ hadoop jar pairimalgorithm.jar org.bigdata.inmapperpair.Demo /user/cloudera/allpairinput /user/cloudera/outp2_2
========Pair In Mapper Algorithm========
17/11/15 12:53:06 INFO client.RMProxy: Connecting to ResourceManager at /0.0.0.0:8032
17/11/15 12:53:07 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
17/11/15 12:53:07 INFO input.FileInputFormat: Total input paths to process : 1
17/11/15 12:53:07 INFO mapreduce.JobSubmitter: number of splits:1
17/11/15 12:53:07 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1510697007852_0032
17/11/15 12:53:08 INFO impl.YarnClientImpl: Submitted application application_1510697007852_0032
17/11/15 12:53:08 INFO mapreduce.Job: The url to track the job: http://quickstart.cloudera:8088/proxy/application_1510697007852_0032/
17/11/15 12:53:08 INFO mapreduce.Job: Running job: job_1510697007852_0032
17/11/15 12:53:15 INFO mapreduce.Job: Job job_1510697007852_0032 running in uber mode : false
17/11/15 12:53:15 INFO mapreduce.Job:  map 0% reduce 0%
17/11/15 12:53:21 INFO mapreduce.Job:  map 100% reduce 0%
17/11/15 12:53:33 INFO mapreduce.Job:  map 100% reduce 25%
17/11/15 12:53:36 INFO mapreduce.Job:  map 100% reduce 50%
17/11/15 12:53:38 INFO mapreduce.Job:  map 100% reduce 100%
17/11/15 12:53:39 INFO mapreduce.Job: Job job_1510697007852_0032 completed successfully
17/11/15 12:53:40 INFO mapreduce.Job: Counters: 50
	File System Counters
		FILE: Number of bytes read=908
		FILE: Number of bytes written=629003
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=224
		HDFS: Number of bytes written=697
		HDFS: Number of read operations=15
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=8
	Job Counters 
		Killed reduce tasks=1
		Launched map tasks=1
		Launched reduce tasks=4
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=3535
		Total time spent by all reduces in occupied slots (ms)=44252
		Total time spent by all map tasks (ms)=3535
		Total time spent by all reduce tasks (ms)=44252
		Total vcore-milliseconds taken by all map tasks=3535
		Total vcore-milliseconds taken by all reduce tasks=44252
		Total megabyte-milliseconds taken by all map tasks=3619840
		Total megabyte-milliseconds taken by all reduce tasks=45314048
	Map-Reduce Framework
		Map input records=3
		Map output records=52
		Map output bytes=780
		Map output materialized bytes=908
		Input split bytes=134
		Combine input records=0
		Combine output records=0
		Reduce input groups=32
		Reduce shuffle bytes=908
		Reduce input records=52
		Reduce output records=26
		Spilled Records=104
		Shuffled Maps =4
		Failed Shuffles=0
		Merged Map outputs=4
		GC time elapsed (ms)=244
		CPU time spent (ms)=5100
		Physical memory (bytes) snapshot=993955840
		Virtual memory (bytes) snapshot=7837675520
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
		Bytes Written=697
