import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.time.LocalDateTime;
import java.util.*;

class IOConsoleWriterTest {
    @Test
    void isDisplayAllClientsInfoPrintData() {
        // Given
        Writer writer = mock(Writer.class);
        IOConsoleWriter io = new IOConsoleWriterImpl(writer);
        
        List<AccountEntity> accounts = Arrays.asList(
            new AccountEntity(2L, LocalDateTime.of(2017,5,25,12,59), "JSmith", "zzwvp0d9")
        );
        ClientEntity client = new ClientEntity(1L, "client@example.com", "John Smith", accounts);
        List<ClientEntity> clients = Arrays.asList(client);

        // When
        io.displayAllClientsInfo(clients);

        // Then
        verify(writer).write("John Smith");
        verify(writer).write("JSmith");
    }
} 