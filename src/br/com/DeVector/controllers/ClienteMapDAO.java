/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.DeVector.controllers;

import br.com.DeVector.model.Cliente;
import br.com.DeVector.repositories.IClienteDAO;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author DeVector
 */
public class ClienteMapDAO implements IClienteDAO {
    private final Map<Long, Cliente> map;

    public ClienteMapDAO() {
        map = new TreeMap<>();
    }


    @Override
    public Boolean cadastrarCliente(Cliente client) {
        if (map.containsKey(client.getCpf())){
            return false;
        }
        map.put(client.getCpf(), client);
        return true;
    }

    @Override
    public void excluir(Long cpf) {
        Cliente client = map.get(cpf);
        map.remove(client.getCpf(), client);
    }

    @Override
    public void alterar(Cliente client) {
        Cliente clienteAlter = map.get(client.getCpf());

        clienteAlter.setNome(client.getNome());
        clienteAlter.setCpf(client.getCpf());
        clienteAlter.setTel(client.getTel());
        clienteAlter.setEnd(client.getEnd());
        clienteAlter.setCidade(client.getCidade());
        clienteAlter.setEstado(client.getEstado());
    }

    @Override
    public Cliente consultar(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Cliente> buscarTodos() {
        return this.map.values();
    }
}
