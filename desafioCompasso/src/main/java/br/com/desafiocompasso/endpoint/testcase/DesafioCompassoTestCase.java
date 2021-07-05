package br.com.desafiocompasso.endpoint.testcase;

import br.com.desafiocompasso.core.model.DesafioCompasso;
import br.com.desafiocompasso.core.repository.DesafioCompassoRepository;
import br.com.desafiocompasso.endpoint.controler.DesafioCompasoController;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebAppConfiguration
@Sql(scripts = "/sql/insert_produto_test_case.sql")
public class DesafioCompassoTestCase extends TestCase {

    @Autowired
    private DesafioCompasoController desafioCompasoController;

    @Autowired
    private DesafioCompassoRepository desafioCompassoRepository;

    @Test
    public void saveProdutoTest(){
        DesafioCompasso produto = new DesafioCompasso();

        produto.setDescription("SAVE TESTE NUNIT");
        produto.setName("TEST NUNIT");
        produto.setPrice(10.00);

        desafioCompasoController.saveProduto(produto);

    }

    @Test
    public void upDateProduto(){

        DesafioCompasso produto = new DesafioCompasso();

        produto.setDescription("ALTER SAVE TESTE NUNIT");
        produto.setName("ALTER TEST NUNIT");
        produto.setPrice(99.00);

        desafioCompasoController.upDateProduto(999L, produto);

    }

    @Test
    public void getAllProdutosTest(){
        desafioCompasoController.getAllProdutos();
    }

    @Test
    public void getProdutoByIdTest(){
        DesafioCompasso produto = desafioCompasoController.getProdutoById(999L);
        assertEquals("NAME NUNIT", produto.getName());
        assertEquals("DESCRIPTION NUNIT", produto.getDescription());
        assertEquals("99.99", produto.getPrice().toString());
    }

    @Test
    public void getProdutoSearchNameOrDescriptionTest(){
        desafioCompassoRepository.searchProduto("UNIT", null, null);
    }

    @Test
    public void getProdutoSearchPriceMin(){
        desafioCompassoRepository.searchProduto(null, 1.0, null);
    }

    @Test
    public void getProdutoSearchPriceMax(){
        desafioCompassoRepository.searchProduto(null, null, 2.0);
    }

    @Test
    @After
    public void deleteProdutoTest(){
        Optional<DesafioCompasso> produto = desafioCompassoRepository.findById(999L);
        if(produto.isPresent()) {
            desafioCompasoController.deleteProduto(999L);
            produto = desafioCompassoRepository.findById(999L);
            assertFalse(produto.isPresent());
        }
    }

}
