[cloudera@quickstart ~]$ hadoop jar stripealgorithm.jar org.bigdata.StripeAlgorithm /user/cloudera/allpairinput /user/cloudera/outp3_1
=======Stripe Word Count Algorithm================
17/11/15 12:57:16 INFO client.RMProxy: Connecting to ResourceManager at /0.0.0.0:8032
17/11/15 12:57:16 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
17/11/15 12:57:17 INFO input.FileInputFormat: Total input paths to process : 1
17/11/15 12:57:17 INFO mapreduce.JobSubmitter: number of splits:1
17/11/15 12:57:17 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1510697007852_0033
17/11/15 12:57:17 INFO impl.YarnClientImpl: Submitted application application_1510697007852_0033
17/11/15 12:57:17 INFO mapreduce.Job: The url to track the job: http://quickstart.cloudera:8088/proxy/application_1510697007852_0033/
17/11/15 12:57:17 INFO mapreduce.Job: Running job: job_1510697007852_0033
17/11/15 12:57:24 INFO mapreduce.Job: Job job_1510697007852_0033 running in uber mode : false
17/11/15 12:57:24 INFO mapreduce.Job:  map 0% reduce 0%
17/11/15 12:57:30 INFO mapreduce.Job:  map 100% reduce 0%
17/11/15 12:57:38 INFO mapreduce.Job:  map 100% reduce 100%
17/11/15 12:57:38 INFO mapreduce.Job: Job job_1510697007852_0033 completed successfully
17/11/15 12:57:38 INFO mapreduce.Job: Counters: 49
	File System Counters
		FILE: Number of bytes read=766
		FILE: Number of bytes written=252033
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=224
		HDFS: Number of bytes written=695
		HDFS: Number of read operations=6
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
	Job Counters 
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=3574
		Total time spent by all reduces in occupied slots (ms)=3845
		Total time spent by all map tasks (ms)=3574
		Total time spent by all reduce tasks (ms)=3845
		Total vcore-milliseconds taken by all map tasks=3574
		Total vcore-milliseconds taken by all reduce tasks=3845
		Total megabyte-milliseconds taken by all map tasks=3659776
		Total megabyte-milliseconds taken by all reduce tasks=3937280
	Map-Reduce Framework
		Map input records=3
		Map output records=20
		Map output bytes=720
		Map output materialized bytes=766
		Input split bytes=134
		Combine input records=0
		Combine output records=0
		Reduce input groups=6
		Reduce shuffle bytes=766
		Reduce input records=20
		Reduce output records=6
		Spilled Records=40
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=52
		CPU time spent (ms)=1470
		Physical memory (bytes) snapshot=443396096
		Virtual memory (bytes) snapshot=3134660608
		Total committed heap usage (bytes)=349175808
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
