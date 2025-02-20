import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.yummynoodlebar.core.services.OrderService;
import com.yummynoodlebar.events.orders.CreateOrderEvent;
import static org.mockito.Mockito.verify;
import static org.mockito.Matchers.argThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CheckoutIntegrationTest {
    @Mock
    OrderService orderService;
    
    private static final String CUSTOMER_NAME = "John Doe";
    private static final String ADDRESS1 = "123 Main St";
    private static final String POST_CODE = "12345";

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verifyOrderCreation() {
        // ... test setup code
        
        verify(orderService).createOrder(
            argThat(hasProperty("details", allOf(
                hasProperty("dateTimeOfSubmission", notNullValue()),
                hasProperty("name", equalTo(CUSTOMER_NAME)),
                hasProperty("address1", equalTo(ADDRESS1)),
                hasProperty("postcode", equalTo(POST_CODE))
            )))
        );
    }
} 