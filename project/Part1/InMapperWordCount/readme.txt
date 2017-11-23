[cloudera@quickstart ~]$ hadoop fs -cat /user/cloudera/input1
WordCount example reads text files and counts how often words occur. The input is text files and the output is text files, each line of which contains a word and the count of how often it occured, separated by a tab.

Each mapper takes a line as input and breaks it into words. It then emits a key/value pair of the word and 1. Each reducer sums the counts for each word and emits a single key/value with the word and sum. 

[cloudera@quickstart ~]$ hadoop jar inmapperwordcount.jar org.bigdata.InMapperWordCount /user/cloudera/input1 /user/cloudera/out0
========inmapperwordcount========
17/11/15 09:15:10 INFO client.RMProxy: Connecting to ResourceManager at /0.0.0.0:8032
17/11/15 09:15:11 WARN mapreduce.JobResourceUploader: Hadoop command-line option parsing not performed. Implement the Tool interface and execute your application with ToolRunner to remedy this.
17/11/15 09:15:11 INFO input.FileInputFormat: Total input paths to process : 1
17/11/15 09:15:11 INFO mapreduce.JobSubmitter: number of splits:1
17/11/15 09:15:12 INFO mapreduce.JobSubmitter: Submitting tokens for job: job_1510697007852_0011
17/11/15 09:15:12 INFO impl.YarnClientImpl: Submitted application application_1510697007852_0011
17/11/15 09:15:12 INFO mapreduce.Job: The url to track the job: http://quickstart.cloudera:8088/proxy/application_1510697007852_0011/
17/11/15 09:15:12 INFO mapreduce.Job: Running job: job_1510697007852_0011
17/11/15 09:15:26 INFO mapreduce.Job: Job job_1510697007852_0011 running in uber mode : false
17/11/15 09:15:26 INFO mapreduce.Job:  map 0% reduce 0%
17/11/15 09:15:36 INFO mapreduce.Job:  map 100% reduce 0%
17/11/15 09:15:48 INFO mapreduce.Job:  map 100% reduce 100%
17/11/15 09:15:48 INFO mapreduce.Job: Job job_1510697007852_0011 completed successfully
17/11/15 09:15:49 INFO mapreduce.Job: Counters: 49
	File System Counters
		FILE: Number of bytes read=577
		FILE: Number of bytes written=251669
		FILE: Number of read operations=0
		FILE: Number of large read operations=0
		FILE: Number of write operations=0
		HDFS: Number of bytes read=541
		HDFS: Number of bytes written=375
		HDFS: Number of read operations=6
		HDFS: Number of large read operations=0
		HDFS: Number of write operations=2
	Job Counters 
		Launched map tasks=1
		Launched reduce tasks=1
		Data-local map tasks=1
		Total time spent by all maps in occupied slots (ms)=7393
		Total time spent by all reduces in occupied slots (ms)=7948
		Total time spent by all map tasks (ms)=7393
		Total time spent by all reduce tasks (ms)=7948
		Total vcore-milliseconds taken by all map tasks=7393
		Total vcore-milliseconds taken by all reduce tasks=7948
		Total megabyte-milliseconds taken by all map tasks=7570432
		Total megabyte-milliseconds taken by all reduce tasks=8138752
	Map-Reduce Framework
		Map input records=3
		Map output records=49
		Map output bytes=473
		Map output materialized bytes=577
		Input split bytes=117
		Combine input records=0
		Combine output records=0
		Reduce input groups=49
		Reduce shuffle bytes=577
		Reduce input records=49
		Reduce output records=49
		Spilled Records=98
		Shuffled Maps =1
		Failed Shuffles=0
		Merged Map outputs=1
		GC time elapsed (ms)=91
		CPU time spent (ms)=2890
		Physical memory (bytes) snapshot=433885184
		Virtual memory (bytes) snapshot=3119063040
		Total committed heap usage (bytes)=348127232
	Shuffle Errors
		BAD_ID=0
		CONNECTION=0
		IO_ERROR=0
		WRONG_LENGTH=0
		WRONG_MAP=0
		WRONG_REDUCE=0
	File Input Format Counters 
		Bytes Read=424
	File Output Format Counters 
		Bytes Written=375
[cloudera@quickstart ~]$ hadoop fs -cat /user/cloudera/out0/*
1.	1
Each	2
It	1
The	1
WordCount	1
a	5
and	7
as	1
breaks	1
by	1
contains	1
count	1
counts	2
each	2
emits	2
example	1
files	2
files,	1
for	1
how	2
input	2
into	1
is	2
it	2
key/value	2
line	2
mapper	1
occur.	1
occured,	1
of	3
often	2
output	1
pair	1
reads	1
reducer	1
separated	1
single	1
sum.	1
sums	1
tab.	1
takes	1
text	3
the	5
then	1
which	1
with	1
word	4
words	1
words.	1
[cloudera@quickstart ~]$ 
