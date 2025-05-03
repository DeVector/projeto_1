/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.DeVector.controllers;

import br.com.DeVector.repositories.IClienteDAO;
import br.com.DeVector.model.Cliente;


import java.util.Set;
import java.util.Collection;
import java.util.HashSet;
/**
 *
 * @author DeVector
 */
public class ClienteSetDAO implements IClienteDAO{
    private final Set<Cliente> set;

    public ClienteSetDAO() {
        this.set = new HashSet<>();
    }

    @Override
    public Boolean cadastrarCliente(Cliente client) {
        return this.set.add(client);
    }

    @Override
    public void excluir(Long cpf) {
        Cliente clienteToExclude = null;
        for (Cliente client: this.set){
            if (client.getCpf().equals(cpf)){
                clienteToExclude = client;
                break;
            }
        }

        if (clienteToExclude != null){
            this.set.remove(clienteToExclude);
        }
    }

    @Override
    public void alterar(Cliente client) {
        if (this.set.contains(client)){
            for (Cliente clientToAlter: this.set){
                if (clientToAlter.equals(client)) {
                    clientToAlter.setNome(client.getNome());
                    clientToAlter.setCpf(client.getCpf());
                    clientToAlter.setTel(client.getTel());
                    clientToAlter.setEnd(client.getEnd());
                    clientToAlter.setCidade(client.getCidade());
                    clientToAlter.setEstado(client.getEstado());
                    break;
                }
            }
        }
    }

    @Override
    public Cliente consultar(Long cpf) {
        for (Cliente clienteToFind : this.set){
            if (clienteToFind.getCpf().equals(cpf)){
                return clienteToFind;
            }
        }
        return null;
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.set;
    }

}
