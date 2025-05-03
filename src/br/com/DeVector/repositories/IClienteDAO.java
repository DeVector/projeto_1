/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.DeVector.repositories;

import br.com.DeVector.model.Cliente;
import java.util.Collection;

/**
 *
 * @author DeVector
 */
public interface IClienteDAO {
    
    public Boolean cadastrarCliente(Cliente client);

    public void excluir(Long cpf);

    public void alterar(Cliente client);

    public Cliente consultar(Long cpf);

    public Collection<Cliente> buscarTodos();

}
