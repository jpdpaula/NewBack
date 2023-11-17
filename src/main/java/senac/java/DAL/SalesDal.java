package senac.java.DAL;

import senac.java.Services.Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SalesDal {

    public Connection conectar(){
        Connection conexao = null;

        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://localhost:1433;databaseName=pi";
            String usuario = "116128412023.1";
            String senha = "senac@12841";

            conexao = DriverManager.getConnection(url, usuario, senha);

            if(conexao != null){
                return conexao;
            }
        }catch(ClassNotFoundException | SQLException e){
            System.out.println("O Erro foi: " + e);

        }finally{
            try {
                if (conexao != null && !conexao.isClosed()){
                    conexao.close();
                }
            }catch(SQLException e){
                System.out.println("O erro no finaly foi: " + e);
            }
        }
        return conexao;
    }

    //Inserir - Create
    public int inserirVendas(String image, String titulo, String subtitulo) throws SQLException{
        String sql = "INSERT INTO Sales (image, titulo, subtitulo) VALUES(?, ?, ?)";
        int linhasAfetadas = 0;
        Connection conexao = conectar();

        try(PreparedStatement statement = conectar().prepareStatement(sql)){
            statement.setString(1, image);
            statement.setString(2, titulo);
            statement.setString(3, subtitulo);

            linhasAfetadas = statement.executeUpdate();

            System.out.println("Foram modificadas " + linhasAfetadas + " no banco de dados");

            conexao.close();
            return linhasAfetadas;
        }catch(SQLException e){
            System.out.println("O Erro na Inserção de dados foi: " + e);
            conexao.close();
        }
        conexao.close();
        return linhasAfetadas;
    }

    public ResultSet listarVendas() throws SQLException{
        String sql = "SELECT * FROM Sales";
        ResultSet result = null;

        try(PreparedStatement statement = conectar().prepareStatement(sql)){
            result = statement.executeQuery();

            System.out.println("Listagem das vendas: ");

            while (result.next()){
                int id = result.getInt("id");
                String image = result.getString("image");
                String titulo = result.getString("titulo");
                String subtitulo = result.getString("subtitulo");

                System.out.println("id: " + id);
                System.out.println("image: " + image);
                System.out.println("titulo: " + titulo);
                System.out.println("subtitulo: " + subtitulo);
            }
            return result;

        }catch (SQLException e){
            System.out.println("O Erro na Listagem de dados foi: " + e);
        }
        return result;

    }

    public int atualizarVendas(String image, String titulo,String subtitulo, int id) throws SQLException{
        String sql = "UPDATE Sales SET image = ?, titulo = ?, subtitulo = ?< WHERE id = ?";
        int linhasAfetadas = 0;

        try(PreparedStatement statement = conectar().prepareStatement(sql)){
            statement.setString(1, image);
            statement.setString(2, titulo);
            statement.setString(3, subtitulo);
            statement.setInt(4, id);

            linhasAfetadas = statement.executeUpdate();

            System.out.println("Foram modificadas " + linhasAfetadas + " no banco de dados");

            return linhasAfetadas;

        }catch(SQLException e){
            System.out.println("O Erro na Atualização de dados foi: " + e);
        }
        return linhasAfetadas;
    }

    public int excluirVendas(int id) throws SQLException{
        String sql = "DELETE FROM Sales WHERE id = ?";
        int linhasAfetadas = 0;

        try(PreparedStatement statement = conectar().prepareStatement(sql)){
            statement.setInt(1, id);

            linhasAfetadas = statement.executeUpdate();

            System.out.println("Foram modificadas " + linhasAfetadas + " no banco de dados");

            return linhasAfetadas;
        }catch(SQLException e){
            System.out.println("O Erro na inserção de dados foi: " + e);
        }
        return linhasAfetadas;
    }
}