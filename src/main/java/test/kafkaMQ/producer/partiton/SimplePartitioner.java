package test.kafkaMQ.producer.partiton;

import kafka.producer.Partitioner;
import kafka.utils.VerifiableProperties;
//message的序列化类
public class SimplePartitioner implements Partitioner {
    public SimplePartitioner (VerifiableProperties props) {
		System.out.println("SimplePartitioner!");
    }

    public int partition(Object key, int a_numPartitions) {
        int partition = 0;
        String stringKey = (String) key;
        int offset = stringKey.lastIndexOf('.');
        if (offset > 0) {
            partition = Integer.parseInt(stringKey.substring(offset + 1)) % a_numPartitions;
        }

        return partition;
    }
}
