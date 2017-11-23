[cloudera@quickstart ~]$ hadoop jar stripeimalgorithm.jar org.bigdata.InMapperStripeWordCount /user/cloudera/allpairinput /user/cloudera/outp3_2
17/11/15 13:00:44 INFO client.RMProxy: Connecting to ResourceManager at /0.0.0.0:8032
17/11/15 13:00:45 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
17/11/15 13:00:45 INFO input.FileInputFormat: Total input paths to process : 1
17/11/15 13:00:45 INFO mapreduce.JobSubmitter: number of splits:1
17/11/15 13:00:45 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1510697007852_0034
17/11/15 13:00:45 INFO impl.YarnClientImpl: Submitted application application_1510697007852_0034
17/11/15 13:00:45 INFO mapreduce.Job: The url to track the job: http://quickstart.cloudera:8088/proxy/application_1510697007852_0034/
17/11/15 13:00:45 INFO mapreduce.Job: Running job: job_1510697007852_0034
17/11/15 13:00:53 INFO mapreduce.Job: Job job_1510697007852_0034 running in uber mode : false
17/11/15 13:00:53 INFO mapreduce.Job:  map 0% reduce 0%
17/11/15 13:00:59 INFO mapreduce.Job:  map 100% reduce 0%
17/11/15 13:01:12 INFO mapreduce.Job:  map 100% reduce 25%
17/11/15 13:01:16 INFO mapreduce.Job:  map 100% reduce 50%
17/11/15 13:01:17 INFO mapreduce.Job:  map 100% reduce 100%
17/11/15 13:01:18 INFO mapreduce.Job: Job job_1510697007852_0034 completed successfully
17/11/15 13:01:18 INFO mapreduce.Job: Counters: 50
	File System Counters
		FILE: Number of bytes read=350
		FILE: Number of bytes written=627007
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=224
		HDFS: Number of bytes written=695
		HDFS: Number of read operations=15
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=8
	Job Counters 
		Killed reduce tasks=1
		Launched map tasks=1
		Launched reduce tasks=4
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=3496
		Total time spent by all reduces in occupied slots (ms)=50466
		Total time spent by all map tasks (ms)=3496
		Total time spent by all reduce tasks (ms)=50466
		Total vcore-milliseconds taken by all map tasks=3496
		Total vcore-milliseconds taken by all reduce tasks=50466
		Total megabyte-milliseconds taken by all map tasks=3579904
		Total megabyte-milliseconds taken by all reduce tasks=51677184
	Map-Reduce Framework
		Map input records=3
		Map output records=6
		Map output bytes=314
		Map output materialized bytes=350
		Input split bytes=134
		Combine input records=0
		Combine output records=0
		Reduce input groups=6
		Reduce shuffle bytes=350
		Reduce input records=6
		Reduce output records=6
		Spilled Records=12
		Shuffled Maps =4
		Failed Shuffles=0
		Merged Map outputs=4
		GC time elapsed (ms)=311
		CPU time spent (ms)=5270
		Physical memory (bytes) snapshot=967348224
		Virtual memory (bytes) snapshot=7845507072
		Total committed heap usage (bytes)=768081920
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
		Bytes Written=695
