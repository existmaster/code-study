import com.existmaster.study.NetworkUtil;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by existmaster on 2015. 12. 6..
 */
public class NetworkUtilTest {

    public static final String WRONG_DOMAIN_NAME = "abaaaa.d";
    public static final String NORMAL_DOMAIN_NAME = "c.pineone.net";
    public static final String EXPECTED_IP_ADDRESS = "219.248.137.8";

    private NetworkUtil networkUtil;

    @Before
    public void setUp() throws Exception {
        networkUtil = new NetworkUtil();
    }

    @Test
    public void NetworkUtil() throws UnknownHostException {
        InetAddress[] inetAddresses = networkUtil.nslookup(NORMAL_DOMAIN_NAME);
        assertEquals(EXPECTED_IP_ADDRESS, inetAddresses[0].getHostAddress());
    }

    @Test
    public void WrongParameter() {
        wrongParameterChecker(WRONG_DOMAIN_NAME);

    }

    private void wrongParameterChecker(String domain) {
        try {
            networkUtil.nslookup(domain);
            fail();
        } catch (UnknownHostException e) {
            return;
        }
    }

}
