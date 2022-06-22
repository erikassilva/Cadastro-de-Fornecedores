package controle.web;

import dominio.EntidadeDominio;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Servlet", value = "/Servlet")
public class Controle extends HttpServlet {

    private Map<String, IViewHelper> vhs = new HashMap<String, IViewHelper>();
    private Map<String, ICommand> cmds = new HashMap<String, ICommand>();

    public Controle() {

        vhs.put("/CadastroFornecedores/SalvarFornecedor", new FornecedorVH());

        cmds.put("Salvar", new SalvarCommand());
        cmds.put("Alterar", new AlterarCommand());
        cmds.put("Consultar", new ConsultarCommand());
        cmds.put("Excluir", new ExcluirCommand());

    }

    private void processRequest(HttpServletRequest request,
                                HttpServletResponse response) throws IOException {

        String uri = request.getRequestURI();
        String operacao = request.getParameter("operacao");

        IViewHelper vh = vhs.get(uri);

        EntidadeDominio entidade = vh.getEntidade(request);

        ICommand cmd = cmds.get(operacao);

        Object msg = cmd.executar(entidade);

        vh.setEntidade(response, request, msg);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
