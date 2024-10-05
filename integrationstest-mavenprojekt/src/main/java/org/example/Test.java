package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class OrderServiceTest {

    @Mock
    PaymentService paymentService;

    @InjectMocks
    OrderService orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testPlaceOrder_Failure() {
        // Simuliere fehlgeschlagenen Zahlungsvorgang
        when(paymentService.processPayment("order2", 50.0)).thenReturn(false);

        // Überprüfen, ob die Bestellung fehlgeschlagen ist
        String result = orderService.placeOrder("order2", 50.0);
        assertEquals("Order Failed", result);
    }
}