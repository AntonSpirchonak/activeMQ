import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Producer {

    public static String URL = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static String SUBJECT = "TESTQUEUE";

    public static void main (String[] args) throws JMSException{
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        Destination destination = session.createQueue(SUBJECT);

        MessageProducer producer = session.createProducer(destination);

        /*
            Sending text message
         */
//        TextMessage message = session.createTextMessage("Hello from Producer!");
//
//        producer.send(message);
//        System.out.println("Sent message '" + message.getText() + "'");
//
//        //Sending object
//
//        Person person = new Person("Petrov", "Petr", "Pertovic", 209988);
//
//        ObjectMessage objectMessage = session.createObjectMessage(person);
//
//        producer.send(objectMessage);
//
//        System.out.println("Sent object message '" + objectMessage.toString() + "'");

        /*
            Sending list of objects
         */

        List<Long> list = new ArrayList<Long>();
        list.add(1L);
        list.add(2L);
        list.add(5L);

        ObjectMessage message = session.createObjectMessage((Serializable)list);

        producer.send(message);

        System.out.println("Sent object message '" + message.getObject().toString() + "'");

        connection.close();
    }
}
