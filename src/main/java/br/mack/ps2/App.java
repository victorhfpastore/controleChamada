package br.mack.ps2;
import javax.print.attribute.DateTimeSyntax;
import java.math.BigInteger;
import java.sql.*;
import java.util.Scanner;

public class App 
{
    public static void main(String[] args) {

        Connection conn = null;
        Scanner input = new Scanner (System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            String db = "aula_ps2";
            String url = "jdbc:mysql://localhost:3308/" + db;
            String user = "root";
            String psw = "";
            BigInteger tia;
            String entrada;
            String saida;

            conn = DriverManager.getConnection(url,user,psw);

            System.out.println("Controle de frequência");
            System.out.println("Digite o TIA do aluno: ");
            tia = input.nextBigInteger();

            System.out.println("Digite a data e hora de entrada do aluno: ");
            entrada = input.nextLine();

            System.out.println("Digite a data e hora de sáida do aluno: ");
            saida = input.nextLine();

            String inserir = "INSERT INTO frequencia (tia, entrada, saida) VALUES (" + tia + ", " + entrada + ", " + saida + ")";
            PreparedStatement pstm =  conn.prepareStatement(inserir);
            ResultSet rs = pstm.executeQuery();

            String sql = "Select * FROM frequencia";
            PreparedStatement pstm2 =  conn.prepareStatement(sql);
            ResultSet rs2 = pstm2.executeQuery();

        } catch (IllegalAccessException e){
            e.printStackTrace();
        } catch (InstantiationException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } catch (SQLException e){
            System.out.println("SQL Exception");
            e.printStackTrace();
        }



    }
}
