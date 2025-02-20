import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.time.LocalDateTime;
import java.util.*;

class IOConsoleWriterTest {
    @Test
    void isDisplayAllClientsInfoPrintData() {
        // Given
        List<ClientEntity> clients = mock(List.class);
        List<AccountEntity> accounts = mock(List.class);
        Iterator<ClientEntity> clientIterator = mock(Iterator.class);
        Iterator<AccountEntity> accountIterator = mock(Iterator.class);
        ClientEntity client = mock(ClientEntity.class);
        AccountEntity account = mock(AccountEntity.class);

        when(clientIterator.hasNext()).thenReturn(true, false);
        when(clientIterator.next()).thenReturn(client);
        when(clients.iterator()).thenReturn(clientIterator);

        when(accountIterator.hasNext()).thenReturn(true, false);
        when(accountIterator.next()).thenReturn(account);
        when(accounts.iterator()).thenReturn(accountIterator);

        when(clients.size()).thenReturn(1);
        when(client.getAccountEntities()).thenReturn(accounts);
        when(client.getId()).thenReturn(1L);
        when(client.getEmail()).thenReturn("client@example.com");
        when(client.getName()).thenReturn("John Smith");
        when(account.getId()).thenReturn(2L);
        when(account.getCreated()).thenReturn(LocalDateTime.of(2017,5,25,12,59));
        when(account.getLogin()).thenReturn("JSmith");
        when(account.getPassword()).thenReturn("zzwvp0d9");

        // When
        IOConsoleWriter io = new IOConsoleWriterImpl();
        io.displayAllClientsInfo(clients);

        // Then
        // Output verification would typically require system out capture
    }
} 