import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.product.repository.nbp.ExchangeRate;
import model.product.repository.nbp.NBPRepository;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class NBPRepositoryTest {

    private String jsonToParse ="[{\"table\":\"C\",\"no\":\"068/C/NBP/2019\",\"tradingDate\":\"2019-04-04\",\"effectiveDate\":\"2019-04-05\",\"rates\":[{\"currency\":\"dolar amerykański\",\"code\":\"USD\",\"bid\":3.7887,\"ask\":3.8653},{\"currency\":\"dolar australijski\",\"code\":\"AUD\",\"bid\":2.6927,\"ask\":2.7471},{\"currency\":\"dolar kanadyjski\",\"code\":\"CAD\",\"bid\":2.8363,\"ask\":2.8935},{\"currency\":\"euro\",\"code\":\"EUR\",\"bid\":4.2489,\"ask\":4.3347},{\"currency\":\"forint (Węgry)\",\"code\":\"HUF\",\"bid\":0.013273,\"ask\":0.013541},{\"currency\":\"frank szwajcarski\",\"code\":\"CHF\",\"bid\":3.7887,\"ask\":3.8653},{\"currency\":\"funt szterling\",\"code\":\"GBP\",\"bid\":4.9686,\"ask\":5.0690},{\"currency\":\"jen (Japonia)\",\"code\":\"JPY\",\"bid\":0.033961,\"ask\":0.034647},{\"currency\":\"korona czeska\",\"code\":\"CZK\",\"bid\":0.1654,\"ask\":0.1688},{\"currency\":\"korona duńska\",\"code\":\"DKK\",\"bid\":0.5692,\"ask\":0.5808},{\"currency\":\"korona norweska\",\"code\":\"NOK\",\"bid\":0.4414,\"ask\":0.4504},{\"currency\":\"korona szwedzka\",\"code\":\"SEK\",\"bid\":0.4086,\"ask\":0.4168},{\"currency\":\"SDR (MFW)\",\"code\":\"XDR\",\"bid\":5.2486,\"ask\":5.3546}]}]";

    @Test
    public void getResponse() {
        NBPRepository nbpRepository = new NBPRepository();
        String str = nbpRepository.getResponse();
        System.out.println(str);
    }

    @Test
    public void shouldParseJsonInProperWay() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
       List<ExchangeRate> exchangeRateList = mapper.readValue(
                jsonToParse,
                new TypeReference<List<ExchangeRate>>(){
                });
        System.out.println(exchangeRateList);

    }
}
