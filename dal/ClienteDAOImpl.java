package br.com.clinicaxuliapoo.dal;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void addCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente getClienteByCpf(String cpf) {
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> getAllClientes() {
        return new ArrayList<>(clientes);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        Cliente existingCliente = getClienteByCpf(cliente.getCpf());
        if (existingCliente != null) {
            existingCliente.setNome(cliente.getNome());
            existingCliente.setEmail(cliente.getEmail());
            existingCliente.setSenha(cliente.getSenha());
            existingCliente.setTelefone(cliente.getTelefone());
            existingCliente.setEndereco(cliente.getEndereco());
            existingCliente.setData_nasc(cliente.getData_nasc());
        }
    }

    @Override
    public void deleteCliente(String cpf) {
        Cliente cliente = getClienteByCpf(cpf);
        if (cliente != null) {
            clientes.remove(cliente);
        }
    }
}