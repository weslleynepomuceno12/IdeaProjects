package br.com.desafiocompasso.endpoint.controler;

import br.com.desafiocompasso.core.util.Assert;
import br.com.desafiocompasso.core.model.DesafioCompasso;
import br.com.desafiocompasso.core.repository.DesafioCompassoRepository;
import br.com.desafiocompasso.core.util.MessageEnum;
import br.com.desafiocompasso.exception.DesafioCompassoException;
import br.com.desafiocompasso.exception.DesafioCompassoExceptionNotFound;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * [Desafio Compasso] - Controller com os endpoints da aplicação.
 * @author Weslley Medeiros
 * @since 02/07/2021
 */
@RestController
@AllArgsConstructor
public class DesafioCompasoController {

    DesafioCompassoRepository desafioCompassoRepository;

    /**
     * [Desafio Compasso] - Método responsável por salvar o produto enviado via Json.
     * @author Weslley Medeiros
     * @since 02/07/2021
     * @param produto
     * @return  ResponseEntity<DesafioCompasso>
     */
    @PostMapping("/products")
    public ResponseEntity<DesafioCompasso> saveProduto(@RequestBody DesafioCompasso produto) {
        try{
            if (Assert.isNotNull(produto) && Assert.isNotNullAndEmpty(produto.getName())
            && Assert.isNotNullAndEmpty(produto.getDescription()) && Assert.isNotNullAndEmpty(produto.getPrice())) {
                return new ResponseEntity<>(desafioCompassoRepository.save(produto), HttpStatus.CREATED);
            } else
                throw new Exception();
        }catch (Exception exception)
        {
            throw new DesafioCompassoException(MessageEnum.MESSAGE_400.getDescricao());
        }
    }

    /**
     * [Desafio Compasso] - Método responsável por alterar os dados do produto enviado via Json, a consulta é realizada via ID.
     * @author Weslley Medeiros
     * @since 02/07/2021
     * @param id
     * @param produto
     * @return ResponseEntity<DesafioCompasso>
     */
    @PutMapping("/products/{id}")
    public ResponseEntity<DesafioCompasso> upDateProduto(@PathVariable(value = "id") Long id, @Valid @RequestBody DesafioCompasso produto) {
        try{
            DesafioCompasso desafioCompassoProduto = desafioCompassoRepository.findById(id).get();

            desafioCompassoProduto.setDescription(produto.getDescription());
            desafioCompassoProduto.setName(produto.getName());
            desafioCompassoProduto.setPrice(produto.getPrice());

            if (Assert.isNotNullAndEmpty(desafioCompassoProduto.getPrice())) {
                return new ResponseEntity<>(desafioCompassoRepository.save(desafioCompassoProduto), HttpStatus.OK);
            } else
                throw new Exception();

        }catch (NoSuchElementException noSuchElementException)
        {
            throw new DesafioCompassoExceptionNotFound(MessageEnum.MESSAGE_404.getDescricao().replace("{0}", id.toString()));
        }
        catch (Exception exception)
        {
            throw new DesafioCompassoException(MessageEnum.MESSAGE_400.getDescricao());
        }
    }

    /**
     * [Desafio Compasso] - Método responsável por listar todos os produtos cadastrados utilizando o filtro id.
     * @author Weslley Medeiros
     * @since 02/07/2021
     * @param id
     * @return DesafioCompasso
     */
     @GetMapping("/products/{id}")
    public DesafioCompasso getProdutoById(@PathVariable Long id){

         try{
             DesafioCompasso desafioCompassoProduto = desafioCompassoRepository.findById(id).get();

             return desafioCompassoProduto;

         }catch (NoSuchElementException noSuchElementException)
         {
             throw new DesafioCompassoExceptionNotFound(MessageEnum.MESSAGE_404.getDescricao().replace("{0}", id.toString()));
         }
         catch (Exception exception)
         {
             throw new DesafioCompassoException(MessageEnum.MESSAGE_400.getDescricao());
         }

     }

    /**
     * [Desafio Compasso] - Método responsável por listar todos os produtos cadastrados.
     * @author Weslley Medeiros
     * @since 02/07/2021
     * @return List<DesafioCompasso>
     */
    @GetMapping("/products")
    public List<DesafioCompasso> getAllProdutos(){
        return desafioCompassoRepository.findAll();
    }

    /**
     * [Desafio Compasso] - Método responsável por consultar o produto utilizando os filtros name, description e price.
     * @author Weslley Medeiros
     * @since 02/07/2021
     * @param q
     * @param min_price
     * @param max_price
     * @return List<DesafioCompasso>
     */
    @GetMapping("/products/search")
    public List<DesafioCompasso> getProdutoSearch(@Nullable @RequestParam("q") String q, @Nullable @RequestParam("min_price") Double min_price, @Nullable @RequestParam("max_price") Double max_price){

        try{
            if(Assert.isNullAndEmpty(q) && Assert.isNotNullAndEmpty(min_price) && Assert.isNotNullAndEmpty(max_price))
            {
                if(min_price > max_price)
                {
                    throw new Exception();
                }else {
                    return desafioCompassoRepository.searchProdutoBeetwen(min_price, max_price);
                }
            }else {
                if(Assert.isNotNullAndEmpty(min_price) && Assert.isNotNullAndEmpty(max_price))
                {
                    if (min_price > max_price) {
                        throw new Exception();
                    }else
                    {
                        return desafioCompassoRepository.searchProduto(q, min_price, max_price);
                    }
                }else {
                    return desafioCompassoRepository.searchProduto(q, min_price, max_price);
                }
            }
        }
        catch (Exception exception)
        {
            throw new DesafioCompassoException(MessageEnum.MESSAGE_400.getDescricao());
        }
    }

    /**
     * [Desafio Compasso] - Método responsável por excluir o produto pelo número do id.
     * @author Weslley Medeiros
     * @since 02/07/2021
     * @param id
     * @return void
     */
     @DeleteMapping("/products/{id}")
    public void deleteProduto(@PathVariable Long id){

         try{
             desafioCompassoRepository.findById(id).get();
             desafioCompassoRepository.deleteById(id);
         }catch (NoSuchElementException noSuchElementException)
         {
             throw new DesafioCompassoExceptionNotFound(MessageEnum.MESSAGE_404.getDescricao().replace("{0}", id.toString()));
         }
         catch (Exception exception)
         {
             throw new DesafioCompassoException(MessageEnum.MESSAGE_400.getDescricao());
         }
     }

}