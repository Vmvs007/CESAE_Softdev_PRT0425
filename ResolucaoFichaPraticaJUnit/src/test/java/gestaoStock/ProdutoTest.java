package gestaoStock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    Produto manteiga;
    Produto bolachas;

    @BeforeEach
    void setUp() {
        manteiga = new Produto("Manteiga dos Acores", 10);
        bolachas= new Produto("Bolachas Agua e Sal",3.5);
    }

    @Test
    public void testPrecoComDescontoValido() {
        assertEquals(10, manteiga.precoComDesconto(0));
        assertEquals(9, manteiga.precoComDesconto(1));

        assertEquals(4.5, manteiga.precoComDesconto(5.5));

        assertEquals(1, manteiga.precoComDesconto(9));
        assertEquals(0, manteiga.precoComDesconto(10));

        // CONTROLO

        assertEquals(3.5, bolachas.precoComDesconto(0));
        assertEquals(2.5, bolachas.precoComDesconto(1));

        assertEquals(1, bolachas.precoComDesconto(2.5));
        assertEquals(0, bolachas.precoComDesconto(3.5));
    }

    @Test
    public void testPrecoComDescontoSuperiorAoPrecoProduto() {
        assertThrows(IllegalArgumentException.class, () -> manteiga.precoComDesconto(11));
        assertThrows(IllegalArgumentException.class, () -> manteiga.precoComDesconto(17));

        // CONTROLO

        assertThrows(IllegalArgumentException.class, () -> bolachas.precoComDesconto(4));
        assertThrows(IllegalArgumentException.class, () -> bolachas.precoComDesconto(6.5));

    }

    @Test
    public void testPrecoComDescontoNegativo() {
        assertThrows(IllegalArgumentException.class, () -> manteiga.precoComDesconto(-1));
        assertThrows(IllegalArgumentException.class, () -> manteiga.precoComDesconto(-50));

        // CONTROLO

        assertThrows(IllegalArgumentException.class, () -> bolachas.precoComDesconto(-1));
        assertThrows(IllegalArgumentException.class, () -> bolachas.precoComDesconto(-40));
    }

    @Test
    public void testAdquirirStock(){

        assertEquals(0,manteiga.getQuantidadeStock());

        manteiga.adquirirStock(30);

        assertEquals(30,manteiga.getQuantidadeStock());

        manteiga.adquirirStock(15);

        assertEquals(45,manteiga.getQuantidadeStock());

    }

}