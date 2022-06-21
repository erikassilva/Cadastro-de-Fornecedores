package controle.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cidade;
import dominio.Cnae;
import dominio.ContaBancaria;
import dominio.Contato;
import dominio.Endereco;
import dominio.EntidadeDominio;
import dominio.Fornecedor;
import dominio.Pais;
import dominio.Telefone;
import dominio.TipoEndereco;
import dominio.TipoLogradouro;
import dominio.TipoTelefone;
import dominio.Uf;

import java.io.IOException;
import java.io.PrintWriter;

public class FornecedorVH implements IViewHelper {

    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {

        //Dados Pais

        Pais pais = new Pais();

        String paisDescricao = request.getParameter("txtDescricaoPais");

        pais.setDescricao(paisDescricao);

        //Dados Estado(UF)

        Uf estado = new Uf();

        String estadoDescricao = request.getParameter("txtEstadoDescricao");
        String estadoSigla = request.getParameter("txtEstadoSigla");

        estado.setDescricao(estadoDescricao);
        estado.setSigla(estadoSigla);

        //Dados Cidade


        Cidade cidade = new Cidade();

        String cidadeDescricao = request.getParameter("txtCidadeDescricao");

        cidade.setDescricao(cidadeDescricao);

        //Dados do Tipo de Endereco

        TipoEndereco tipoEndereco = new TipoEndereco();

        String tipoNome = request.getParameter("txtTipoNome");
        String tipoDescricao = request.getParameter("txtTipoDescricao");

        tipoEndereco.setNome(tipoNome);
        tipoEndereco.setDescricao(tipoDescricao);

        //Dados do Tipo de Logradouro

        TipoLogradouro tipoLogradouro= new TipoLogradouro();

        String logTipoNome = request.getParameter("txtTipoDeLogradouroNome");
        String logTipoDescricao = request.getParameter("txtTipoDeLograrouroDescricao");

        tipoLogradouro.setNome(logTipoNome);
        tipoLogradouro.setDescricao(logTipoDescricao);

        // Dados de Endereco.

        Endereco endereco = new Endereco();

        String endCEP = request.getParameter("txtEndCEP").replace(".", "").replace("/", "").replace("-", "");
        String endNumero = request.getParameter("txtEndNumero");
        String endBairro = request.getParameter("txtEndBairro");
        String endComplemento = request.getParameter("txtEndComplemento");

        endereco.setBairro(endBairro);
        endereco.setNumero(endNumero);
        endereco.setCep(endCEP);
        endereco.setComplemento(endComplemento);

        //Dados do tipo de Telefone

        TipoTelefone tipoTelefone = new TipoTelefone();

        String tipoDescFornecedor = request.getParameter("txtTipoTelDescFornecedor");

        tipoTelefone.setDescricao(tipoDescFornecedor);

        //Dados do Telefone

        Telefone telefone = new Telefone();

        String dddTelefone = request.getParameter("txtDDDTelefoneFornecedor");
        String numeroTelefone = request.getParameter("txtNumeroFornecedor");
        String ddiTelefone= request.getParameter("txtDDIFornecedor");

        telefone.setDdd(dddTelefone);
        telefone.setNumero(numeroTelefone);
        telefone.setDdi(ddiTelefone);

        //Dados Conta Bancaria

        ContaBancaria contaBancaria = new ContaBancaria();

        String bancoFornecedor = request.getParameter("txtBancoFornecedor");
        String agenciaFornecedor = request.getParameter("txtAgenciaFornecedor");
        String contaFornecedor = request.getParameter("txtContaFornecedor");

        contaBancaria.setBanco(bancoFornecedor);
        contaBancaria.setAgencia(agenciaFornecedor);
        contaBancaria.setConta(contaFornecedor);

        //Dados Cnae

        Cnae cnae = new Cnae();

        String cnaeDescricao = request.getParameter("txtCnaeDescricaoFornecedor");

        cnae.setNumero(cnaeDescricao);

        //Dados do Contato

        Contato contato = new Contato();

        String emailFor = request.getParameter("txtEmailContatoFornecedor");

        contato.setEmail(emailFor);

        //Dados de Fornecedor

        Fornecedor fornecedor = new Fornecedor();

        String emailFornecedor = request.getParameter("txtEmailFornecedor");
        String cnpjFornecedor = request.getParameter("txtCnpjFornecedor");
        String incrEstFornecedor = request.getParameter("txtInscricaoEstadualFornecedor");
        String incrMunFornecedor = request.getParameter("txtInscricaoMunicipalFornecedor");
        String rzSocialFornecedor = request.getParameter("txtRazaoSocialFornecedor");
        String nmFantasiaFornecedor = request.getParameter("txtNomeFantasiaFornecedor");
        String statusFornecedor = request.getParameter("txtStatusFornecedor");
        String tipForFornecedor = request.getParameter("txttipoFornecimentoFornecedor");

        fornecedor.setEmail(emailFornecedor);
        fornecedor.setCnpj(cnpjFornecedor);
        fornecedor.setInscricaoEstadual(incrEstFornecedor);
        fornecedor.setInscricaoMunicipal(incrMunFornecedor);
        fornecedor.setRzSocial(rzSocialFornecedor);
        fornecedor.setNmFantasia(nmFantasiaFornecedor);
        fornecedor.setStatus(statusFornecedor);
        fornecedor.setTipoFornecimento(tipForFornecedor);

        return fornecedor;
    }

    public void setEntidade(HttpServletResponse response, HttpServletRequest request, Object msg) {

        PrintWriter out;
        try {
            out = response.getWriter();
            if(msg != null){
                out.print(msg);
            }else{
                out.print("<h1>Fornecedor Salvo com sucesso!</h1>");
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

