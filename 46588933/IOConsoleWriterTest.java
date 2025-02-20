import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.*;

class IOConsoleWriterTest {
    @Test
    void isDisplayAllClientsInfoPrintData() {
        // Given
        List<ClientEntity> clients = new ArrayList<>();
        List<AccountEntity> accounts = Arrays.asList(
            new AccountEntity(2L, LocalDateTime.of(2017,5,25,12,59), "JSmith", "zzwvp0d9")
        );
        ClientEntity client = new ClientEntity(1L, "client@example.com", "John Smith", accounts);
        clients.add(client);

        // When
        IOConsoleWriter io = new IOConsoleWriterImpl();
        io.displayAllClientsInfo(clients);

        // Then
        // Output verification would typically require system out capture
    }
} 