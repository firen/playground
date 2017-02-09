/**
 * Created by firen on 09/02/17.
 */
import org.apache.activemq.ActiveMQConnectionFactory
import javax.jms.Session

fun main(args: Array<String>) {
    val connFactory = ActiveMQConnectionFactory()
    val conn = connFactory.createConnection()
    conn.start();
    val sess = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
    val dest = sess.createQueue("SampleQueue");
    val con = sess.createConsumer(dest);
    val msg = sess.createTextMessage("q");
    while(true) {
        val receive = con.receive();
        println(receive)
    }
    conn.close();
}