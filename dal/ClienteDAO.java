package br.com.clinicaxuliapoo.dal;

import java.util.List;

public interface ClienteDAO {
    void addCliente(Cliente cliente);
    Cliente getClienteByCpf(String cpf);
    List<Cliente> getAllClientes();
    void updateCliente(Cliente cliente);
    void deleteCliente(String cpf);
}