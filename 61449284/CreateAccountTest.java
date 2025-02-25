import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.test.util.ReflectionTestUtils;
import static org.mockito.ArgumentMatchers.anyLong;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Thread.class)
public class CreateAccountTest {
    
    @InjectMocks
    @Spy
    private CreateAccount createAccount;
    
    private static final int accountWaitTime = 1;
    
    private AccountRequest request;
    private static final String accountId = "AccountId";
    
    public CreateAccountTest() {
        ReflectionTestUtils.setField(createAccount, "accountSyncWaitTimeMs", accountWaitTime);
    }
    
    @Test(expected = Exception.class)
    public void createAccount_waiSync_Exception() {
        PowerMockito.mockStatic(Thread.class);
        PowerMockito.doThrow(new InterruptedException())
                   .when(Thread.class);
        Thread.sleep(anyLong());

        createAccount.createMyAccount(request, accountId);
    }
}

class CreateAccount {
    // Production class implementation
    public AccountResponse createMyAccount(AccountRequest request, String accountId) {
        // implementation
        return null;
    }
    
    private void waitForSync(String accountId) {
        try {
            if (accountSyncWaitTimeMs > 0) {
                Thread.sleep(accountSyncWaitTimeMs);
            }
        } catch (Exception e) {
            Logger.warn("Failed to apply wait account sync");
        }
    }
} 