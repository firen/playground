import org.apache.activemq.ActiveMQConnectionFactory
import javax.jms.Session

/**
 * Created by firen on 09/02/17.
 */

fun main(args: Array<String>) {
    val connFactory: ActiveMQConnectionFactory = ActiveMQConnectionFactory()
    val conn = connFactory.createConnection()
    val sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
    val dest = sess.createQueue("test.queue");
//    val dest = sess.createQueue("SampleQueue");
    val prod = sess.createProducer(dest);
    val msg = sess.createTextMessage("Simples Assim");
    msg.setStringProperty("custom", "header")
    prod.send(msg);
    conn.close();
}