package controle.web;

import dominio.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FornecedorVH implements IViewHelper {


    @Override
    public EntidadeDominio getEntidade(HttpServletRequest request) {

        //Dados Pais

        String paisDescricao = request.getParameter("txtDescricaoPais");

        Pais pais = new Pais();
        pais.setDescricao(paisDescricao);

        //Dados Estado(UF)

        String estadoDescricao = request.getParameter("txtEstadoDescricao");
        String estadoSigla = request.getParameter("txtEstadoSigla");

        Uf estado = new Uf("","",pais);
        estado.setDescricao(estadoDescricao);
        estado.setSigla(estadoSigla);

        //Dados Cidade

        String cidadeDescricao = request.getParameter("txtCidadeDescricao");

        Cidade cidade = new Cidade("",estado);
        cidade.setDescricao(cidadeDescricao);

        //Dados do Tipo de Endereco

        String tipoNome = request.getParameter("txtTipoNome");
        String tipoDescricao = request.getParameter("txtTipoDescricao");

        TipoEndereco tipoEndereco = new TipoEndereco();
        tipoEndereco.setNome(tipoNome);
        tipoEndereco.setDescricao(tipoDescricao);

        //Dados do Tipo de Logradouro

        String logTipoNome = request.getParameter("txtTipoDeLogradouroNome");
        String logTipoDescricao = request.getParameter("txtTipoDeLograrouroDescricao");

        TipoLogradouro tipoLogradouro = new TipoLogradouro();
        tipoLogradouro.setNome(logTipoNome);
        tipoLogradouro.setDescricao(logTipoDescricao);

        // Dados de Endereco.

        String endCEP = request.getParameter("txtEndCEP").replace(".", "").replace("/", "").replace("-", "");
        String endNumero = request.getParameter("txtEndNumero");
        String endBairro = request.getParameter("txtEndBairro");
        String endComplemento = request.getParameter("txtEndComplemento");

        Endereco endereco = new Endereco("","","","",cidade,tipoLogradouro,tipoEndereco);
        endereco.setBairro(endBairro);
        endereco.setNumero(endNumero);
        endereco.setCep(endCEP);
        endereco.setComplemento(endComplemento);

        //Dados de Fornecedor

        String emailFornecedor = request.getParameter("txtEmailFornecedor");
        String cnpjFornecedor = request.getParameter("txtCnpjFornecedor");
        String incrEstFornecedor = request.getParameter("txtInscricaoEstadualFornecedor");
        String incrMunFornecedor = request.getParameter("txtInscricaoMunicipalFornecedor");
        String rzSocialFornecedor = request.getParameter("txtRazaoSocialFornecedor");
        String nmFantasiaFornecedor = request.getParameter("txtNomeFantasiaFornecedor");
        String statusFornecedor = request.getParameter("txtStatusFornecedor");
        String tipForFornecedor = request.getParameter("txttipoFornecimentoFornecedor");


        Fornecedor fornecedor = new Fornecedor("","","","","","","","",endereco);
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

    @Override
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

