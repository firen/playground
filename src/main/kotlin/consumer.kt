import org.apache.activemq.ActiveMQConnectionFactory
import javax.jms.Session

/**
 * Created by firen on 09/02/17.
 */

fun main(args: Array<String>) {
    val connFactory: ActiveMQConnectionFactory = ActiveMQConnectionFactory()
    val conn = connFactory.createConnection()
    conn.start();
    val sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
    val dest = sess.createQueue("SampleQueue");
    val con = sess.createConsumer(dest);
    val msg = sess.createTextMessage("q");
    val receive = con.receive(1000);
    println(receive)
    conn.close();
}