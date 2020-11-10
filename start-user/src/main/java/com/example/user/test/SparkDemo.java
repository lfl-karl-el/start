package com.example.user.test;

import org.apache.hadoop.conf.Configuration;
import org.apache.spark.SparkConf;
import org.apache.spark.sql.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import scala.collection.JavaConverters;
import scala.collection.Seq;
import scala.collection.mutable.ArraySeq;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SparkDemo {
    public static final String SPARK_NAME = "1";
    public static final String APP_NAME = "sparkHome";
    public static final String MASTER = "local";

    @Test
    public void test(){
        SparkConf sparkConf = new SparkConf().setAppName(APP_NAME).setMaster(MASTER);
        SparkSession spark = SparkSession.builder().config(sparkConf).enableHiveSupport().getOrCreate();
        Configuration configuration = new Configuration();
        configuration.addResource("hadoop/core-site.xml");
        configuration.addResource("hadoop/hdfs-site.xml");
        configuration.addResource("hadoop/hive-site.xml");
        spark.sparkContext().hadoopConfiguration().addResource(configuration);

        spark.sql("use test");
        Dataset<Row> empSet = spark.sql("select * from emp e");
        Dataset<Row> deptSet = spark.sql("select * from dept d");
        Dataset<Row> resule = empSet.join(deptSet, empSet.col("dept_id").equalTo(deptSet.col("dept_id")), "leftouter").where("d.dept_id is null");

        for(Row row : resule.collectAsList()){
            System.out.println(row);
        }
    }
}
