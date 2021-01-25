/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import static Conexao.Conexao.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yuri Sanford
 */
public class CadastroProdutos {
      
    public static boolean verificarExisteCod(String cod) {
        Connection con;
        boolean existe = false;
        try {
            con = Conexao.Conexao.getConnection();
            PreparedStatement stm = con.prepareStatement("SELECT `nome_produto` from `produtos` where codigo_produto = ?");
            stm.setString(1, cod);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                existe = true;
            }
        } catch(SQLException | ClassNotFoundException e) {
            existe = false;
        }
        return existe;
    }
    
    public static boolean verificarExisteCodC(String comanda, String cod) {
        Connection con;
        boolean existe = false;
        try {
            con = Conexao.Conexao.getConnection();
            String sql = "SELECT `quantidade_inicial` from `"+comanda+"` where codigo_produto = ?";
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, cod);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                if(rs.getInt("quantidade_inicial") > 0) {
                   existe = true;    
                   break;
                } else {
                    existe = false;
                }
            }
        } catch(SQLException | ClassNotFoundException e) {
            existe = false;
        }
        return existe;
    }
    
        public static boolean verificarExisteNome(String nome) {
            Connection con;
            boolean existe = false;
            try {
                con = Conexao.Conexao.getConnection();
                PreparedStatement stm = con.prepareStatement("SELECT `codigo_produto` from `produtos` where nome_produto = ?");
                stm.setString(1, nome);
                ResultSet rs = stm.executeQuery();
                while(rs.next()) {
                    existe = true;
                }
            } catch(SQLException | ClassNotFoundException e) {
                existe = false;
            }
            return existe;
        }
    
	public static void criarProduto(String nome_produto, double valor_produto, String codigo_produto, int quantidade_inicial) {
		Connection con;
		try {
                    con = Conexao.Conexao.getConnection();
                    String sql = "INSERT INTO `produtos` (nome_produto, preco_produto, codigo_produto, quantidade_inicial) VALUES (?, ?, ?, ?)";
                    PreparedStatement stm = con.prepareStatement(sql);
                    stm.setString(1, nome_produto);
                    stm.setString(3, codigo_produto);
                    stm.setDouble(2, valor_produto);
                    stm.setInt(4, quantidade_inicial);
                    stm.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} 	
	}    
        
            
	public static void removerProduto(String codigo_produto) {
		Connection con;
		try {
                    con = Conexao.Conexao.getConnection();
                    String sql = "DELETE FROM `produtos` WHERE `codigo_produto` = ?";
                    PreparedStatement stm = con.prepareStatement(sql);
                    stm.setString(1, codigo_produto);
                    stm.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} 	
	}   
    
        public static String retornarNome(String codigo_produto) {
            Connection con;
            String nome = "";
            try {
                con = Conexao.Conexao.getConnection();
                PreparedStatement stm = con.prepareStatement("SELECT `nome_produto` from `produtos` where codigo_produto = ?");
                stm.setString(1, codigo_produto);
                ResultSet rs = stm.executeQuery();
                while(rs.next()) {
                    nome = rs.getString("nome_produto");
                }
            } catch(SQLException | ClassNotFoundException e) {
                nome = null;
            }
            return nome;
        }        
        
        public static Double retornarValor(String codigo_produto) {
            Connection con;
            double valor = 0;
            try {
                con = Conexao.Conexao.getConnection();
                PreparedStatement stm = con.prepareStatement("SELECT `preco_produto` from `produtos` where codigo_produto = ?");
                stm.setString(1, codigo_produto);
                ResultSet rs = stm.executeQuery();
                while(rs.next()) {
                    valor = rs.getDouble("preco_produto");
                }
            } catch(SQLException | ClassNotFoundException e) {
                valor = 0.0;
            }
            return valor;
        }
        
        public static Integer retornarQuantidade(String codigo_produto) {
            Connection con;
            int valor = 0;
            try {
                con = Conexao.Conexao.getConnection();
                PreparedStatement stm = con.prepareStatement("SELECT `quantidade_inicial` from `produtos` where codigo_produto = ?");
                stm.setString(1, codigo_produto);
                ResultSet rs = stm.executeQuery();
                while(rs.next()) {
                    valor = rs.getInt("quantidade_inicial");
                }
            } catch(SQLException | ClassNotFoundException e) {
                valor = 0;
            }
            return valor;
        }
        
        public static Integer retornarQuantidadeC(String comanda,String codigo_produto) {
            Connection con;
            int valor = 0;
            try {
                con = Conexao.Conexao.getConnection();
                String sql = "SELECT `quantidade_inicial` from `"+comanda+"` where codigo_produto = ?";
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1, codigo_produto);
                ResultSet rs = stm.executeQuery();
                while(rs.next()) {
                    valor = rs.getInt("quantidade_inicial");
                }
            } catch(SQLException | ClassNotFoundException e) {
                valor = 0;
            }
            return valor;
        }
        
        
        public static void atualizarNomeProduto(String codigo, String nome_produto) {
            Connection con;
            try {
                    con = Conexao.Conexao.getConnection();
                    String sql = "UPDATE `produtos` SET `nome_produto` = ? WHERE `codigo_produto` = ?";
                    PreparedStatement stm = con.prepareStatement(sql);
                    stm.setString(2, codigo);
                    stm.setString(1, nome_produto);
                    stm.executeUpdate();
            } catch (ClassNotFoundException | SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }            
        }
             
        public static void atualizarValorProduto(String codigo, double preco_produto) {
            Connection con;
            try {
                    con = Conexao.Conexao.getConnection();
                    String sql = "UPDATE `produtos` SET `preco_produto` = ? WHERE `codigo_produto` = ?";
                    PreparedStatement stm = con.prepareStatement(sql);
                    stm.setString(2, codigo);
                    stm.setDouble(1, preco_produto);
                    stm.executeUpdate();
            } catch (ClassNotFoundException | SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }            
        }
        
        public static void atualizarQuantidadeProduto(String codigo, int quantidade_produto) {
            Connection con;
            try {
                    con = Conexao.Conexao.getConnection();
                    String sql = "UPDATE `produtos` SET `quantidade_inicial` = ? WHERE `codigo_produto` = ?";
                    PreparedStatement stm = con.prepareStatement(sql);
                    stm.setString(2, codigo);
                    stm.setInt(1, quantidade_produto);
                    stm.executeUpdate();
            } catch (ClassNotFoundException | SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }            
        }
        
        public static void atualizarQuantidadeProdutoC(String comanda, String codigo, int quantidade_produto) {
            Connection con;
            try {
                    con = Conexao.Conexao.getConnection();
                    String sql = "UPDATE `"+comanda+"` SET `quantidade_inicial` = ? WHERE `codigo_produto` = ?";
                    PreparedStatement stm = con.prepareStatement(sql);
                    stm.setString(2, codigo);
                    stm.setInt(1, quantidade_produto);
                    stm.executeUpdate();
            } catch (ClassNotFoundException | SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }            
        }
        
        public List<Produto> read(String codigo_comanda) {
            Connection con;
            List<Produto> produtos = new ArrayList<>();
            
            try {
                con = Conexao.Conexao.getConnection();
                String sql = "SELECT * from `"+codigo_comanda+"`";
                PreparedStatement stm = con.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while(rs.next()) {
                    Produto p = new Produto();
                    p.setCodigo(rs.getString("codigo_produto"));
                    p.setNome(rs.getString("nome_produto"));
                    p.setQuantidade(rs.getInt("quantidade_inicial"));
                    p.setValor(rs.getDouble("total"));
                    produtos.add(p);
                }
            } catch(SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return produtos;
        }
        
        public List<Produto> readEstoque() {
            Connection con;
            List<Produto> produtos = new ArrayList<>();
            
            try {
                con = Conexao.Conexao.getConnection();
                String sql = "SELECT * from `produtos`";
                PreparedStatement stm = con.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while(rs.next()) {
                    Produto p = new Produto();
                    p.setCodigo(rs.getString("codigo_produto"));
                    p.setNome(rs.getString("nome_produto"));
                    p.setQuantidade(rs.getInt("quantidade_inicial"));
                    p.setValor(rs.getDouble("preco_produto"));
                    produtos.add(p);
                }
            } catch(SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return produtos;
        }
        
        public List<Relatorio> readRelatorio() {
            Connection con;
            List<Relatorio> rl = new ArrayList<>();
            
            try {
                con = Conexao.Conexao.getConnection();
                String sql = "SELECT * from `relatorios`";
                PreparedStatement stm = con.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while(rs.next()) {
                    Relatorio r = new Relatorio();
                    r.setData(rs.getString("data_venda"));
                    r.setValor(rs.getDouble("valor_conta"));
                    rl.add(r);
                }
            } catch(SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return rl;
        }

        public List<String> retornarProdutosC(String cod) {
            Connection con;
            List<String> l = new ArrayList<>();
            try {
                con = Conexao.Conexao.getConnection();

                String sql = "SELECT `nome_produto` from `" + cod + "`";  

                PreparedStatement stm = con.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while(rs.next()) {
                    l.add(rs.getString("nome_produto"));
                }
                

            } catch(SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return l;
        }        
        
        public double retornarTotalComanda (String cod) {
            Connection con;
            double v = 0;
            try {
                con = Conexao.Conexao.getConnection();

                String sql = "SELECT `total` from `" + cod + "`";  

                PreparedStatement stm = con.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while(rs.next()) {
                    v += rs.getDouble("total");
                }
                

            } catch(SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return v;
        }        
        
        public List<Comanda> readComanda() {
            Connection con;
            List<Comanda> rl = new ArrayList<>();
            List<String> l = retonarComandasAbertas();
            try {
                con = Conexao.Conexao.getConnection();
                for(String str : l) {
                    String sql = "SELECT * from `" + str + "`";  

                    PreparedStatement stm = con.prepareStatement(sql);
                    ResultSet rs = stm.executeQuery();
                    while(rs.next()) {
                        Comanda c = new Comanda();
                        c.setCodigo(str);
                        c.setProdutos(retornarProdutosC(str));
                        c.setValor(retornarTotalComanda(str));
                        c.setHorario(rs.getString("horario"));
                        rl.add(c);
                        break;

                    }
                }

            } catch(SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return rl;
        }        
        
        public static double retornarTotalVendas() {
            double valor_total = 0;
            Connection con;
            try {
                con = Conexao.Conexao.getConnection();
                PreparedStatement stm = con.prepareStatement("SELECT `valor_conta` from `relatorios`");
                ResultSet rs = stm.executeQuery();
                while(rs.next()) {
                    valor_total += rs.getDouble("valor_conta");
                }
            } catch(SQLException | ClassNotFoundException e) {
                valor_total = 0.0;
            }            
            return valor_total;
        }
        
        public static String retornarMesMaiorVenda() {
            Connection con;
            String data = "";
                HashMap<String,Double> valores = new HashMap<>();
            try {


                con = Conexao.Conexao.getConnection();
                PreparedStatement stm = con.prepareStatement("SELECT * from `relatorios`");
                ResultSet rs = stm.executeQuery();
                while(rs.next()) {
                    valores.put(rs.getString("data_venda"), rs.getDouble("valor_conta"));
                }
            } catch(SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }  
            List<Entry<String,Double>> list = new LinkedList<Entry<String,Double>>(valores.entrySet());
            Collections.sort(list, new Comparator<Entry<String, Double>>() {
                @Override
                public int compare(Entry<String, Double> o1, Entry<String, Double> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                    
                }
            });
            int c = 0;
            for(Entry<String,Double> i : list) {
                c+=1;
                if(c == list.size()) {
                    data = i.getKey();
                    break;
                }
                       
            }
            
            return data;
        }

        public static double retornarTotalVendaHoje() {
            Connection con;
            double total = 0;
            Date data = new Date();
            SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy");
            String df = f.format(data);
            try {
                con = Conexao.Conexao.getConnection();
                PreparedStatement stm = con.prepareStatement("SELECT * from `relatorios`");
                ResultSet rs = stm.executeQuery();
                while(rs.next()) {
                    if(rs.getString("data_venda").contains(df)) {
                        total += rs.getDouble("valor_conta");
                    }
                        
                }
            } catch(SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }  
            return total;
        }
        
        public static double retornarMediaVendas() {
            double valor_total = 0;
            int contador = 0;
            Connection con;
            try {
                con = Conexao.Conexao.getConnection();
                PreparedStatement stm = con.prepareStatement("SELECT `valor_conta` from `relatorios`");
                ResultSet rs = stm.executeQuery();
                while(rs.next()) {
                    contador += 1;
                    valor_total += rs.getDouble("valor_conta");
                }
            } catch(SQLException | ClassNotFoundException e) {
                valor_total = 0.0;
            }            
            return (valor_total / contador);
        }        
        
        public static boolean verificarSeComandaExiste(String codigo_comanda) {
            Connection con;
            boolean existe = false;
            try {
                con = Conexao.Conexao.getConnection();
                PreparedStatement stm = con.prepareStatement("SELECT * FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = ?");
                stm.setString(1, codigo_comanda);
                ResultSet rs = stm.executeQuery();
                while(rs.next()) {
                    existe = true;
                }
            } catch(SQLException | ClassNotFoundException e) {
                existe = false;
                e.printStackTrace();
            }
            return existe;
        }
        
         public static boolean verificarSeComandaContemAlgo(String codigo_comanda) {
            Connection con;
            int contador = 0;
            boolean existe = false;
            try {
                con = Conexao.Conexao.getConnection();
                String sql = "SELECT `quantidade_inicial` FROM `"+codigo_comanda+"`";
                PreparedStatement stm = con.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();
                while(rs.next()) {
                    if(rs.getInt("quantidade_inicial") > 0){
                        existe = true;  
                        break;
                    }  else {
                        existe = false;                        
                    }
                }
            } catch(SQLException | ClassNotFoundException e) {
                existe = false;
                e.printStackTrace();
            }
            return existe;
        }
        
        public static void createTableComanda(String codigo_comanda) throws ClassNotFoundException, SQLException {
            if(getConnection() != null) {
                    com.mysql.jdbc.PreparedStatement stm = null;
                    String cmd = "CREATE TABLE IF NOT EXISTS `"+codigo_comanda+"`(`codigo_produto` VARCHAR(64), `nome_produto` VARCHAR(64), `quantidade_inicial` INT, `total` DOUBLE, `horario` VARCHAR(64))";
                    stm = (com.mysql.jdbc.PreparedStatement) getConnection().prepareStatement(cmd);
                    stm.executeUpdate();
            }
        }
        
	public static void addProdutoComanda(String comanda, String codigo_produto, int quantidade_inicial, String data) {
		Connection con;
		try {
                    con = Conexao.Conexao.getConnection();
                    if(verificarExisteCodC(comanda,codigo_produto)) {
                        atualizarQuantidadeProdutoC(comanda, codigo_produto, quantidade_inicial+retornarQuantidadeC(comanda, codigo_produto));
                    } else {
                        System.out.println("N TEM");
                        String sql = "INSERT INTO `"+ comanda +"` (codigo_produto,nome_produto,quantidade_inicial,total,horario) VALUES (?, ?, ?, ?, ?)";
                        PreparedStatement stm = con.prepareStatement(sql);
                        stm.setString(1, codigo_produto);
                        stm.setString(2, retornarNome(codigo_produto));
                        stm.setDouble(3, quantidade_inicial);
                        stm.setDouble(4, retornarValor(codigo_produto));
                        stm.setString(5, data);
                        stm.executeUpdate();                   
                    }
                    
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} 	
	} 
        

	public static void removerProdutoComanda(String comanda, String codigo_produto, int quantidade) {
		Connection con;
		try {
			con = Conexao.Conexao.getConnection();
			String sql = "UPDATE `"+comanda+"` SET `quantidade_inicial`= ? WHERE `codigo_produto` = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			int quantidade_atual = retornarQuantidadeC(comanda, codigo_produto);
			if( quantidade_atual >= quantidade ) {
                            if((quantidade_atual - quantidade) == 0) {
                                removerProdutoC(comanda,codigo_produto);
                            } else {                          
				stm.setInt(1, quantidade_atual - quantidade);
				stm.setString(2, codigo_produto);
				stm.executeUpdate(); 
                            }
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}        
        	public static void removerProdutoE(String codigo_produto, int quantidade) {
		Connection con;
		try {
			con = Conexao.Conexao.getConnection();
			String sql = "UPDATE `produtos` SET `quantidade_inicial`= ? WHERE `codigo_produto` = ?";
			PreparedStatement stm = con.prepareStatement(sql);
			int quantidade_atual = retornarQuantidade(codigo_produto);

                            if((quantidade_atual - quantidade) <= 0) {
                                removerProduto(codigo_produto);
                            } else {                          
				stm.setInt(1, quantidade_atual - quantidade);
				stm.setString(2, codigo_produto);
				stm.executeUpdate(); 
                            }

                    } catch (ClassNotFoundException | SQLException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                    }
                }      
        public static void removerProdutoC(String comanda,String codigo_produto) {
		Connection con;
		try {
                    con = Conexao.Conexao.getConnection();
                    String sql = "DELETE FROM `"+comanda+"` WHERE `codigo_produto` = ?";
                    PreparedStatement stm = con.prepareStatement(sql);
                    stm.setString(1, codigo_produto);
                    stm.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} 	
	}
        
        public static void removeC(String comanda) {
		Connection con;
		try {
                    con = Conexao.Conexao.getConnection();
                    String sql = "DROP TABLE "+comanda+"";
                    PreparedStatement stm = con.prepareStatement(sql);
                    stm.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} 	
	}        
 
        public static void adicionarRelatorio(String data, double valor) {
		Connection con;
		try {
                    con = Conexao.Conexao.getConnection();
                    String sql = "INSERT INTO `relatorios` (data_venda, valor_conta) VALUES (?,?)";
                    PreparedStatement stm = con.prepareStatement(sql);
                    stm.setString(1, data);
                    stm.setDouble(2, valor);
                    stm.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		} 	
	}      
        
        public static List<String> retonarComandasAbertas() {
            List<String> comandas = new ArrayList<>();
            String[] valores = {"columns_priv","column_stats","db","event","func","general_log","global_priv","gtid_slave_pos","help_category","help_keyword","help_relation","help_topic","index_stats","innodb_index_stats","innodb_table_stats","plugin","proc","procs_priv","proxies_priv","roles_mapping","servers","slow_log","tables_priv","table_stats","time_zone","time_zone_leap_second","time_zone_name","time_zone_transition","time_zone_transition_type","transaction_registry","cond_instances","events_waits_current","events_waits_history","events_waits_history_long","events_waits_summary_by_host_by_event_name","events_waits_summary_by_instance","events_waits_summary_by_thread_by_event_name","events_waits_summary_by_user_by_event_name","events_waits_summary_by_account_by_event_name","events_waits_summary_global_by_event_name","file_instances","file_summary_by_event_name","file_summary_by_instance","host_cache","mutex_instances","objects_summary_global_by_type","performance_timers","rwlock_instances","setup_actors","setup_consumers","setup_instruments","setup_objects","setup_timers","table_io_waits_summary_by_index_usage","table_io_waits_summary_by_table","table_lock_waits_summary_by_table","threads","events_stages_current","events_stages_history","events_stages_history_long","events_stages_summary_by_thread_by_event_name","events_stages_summary_by_account_by_event_name","events_stages_summary_by_user_by_event_name","events_stages_summary_by_host_by_event_name","events_stages_summary_global_by_event_name","events_statements_current","events_statements_history","events_statements_history_long","events_statements_summary_by_thread_by_event_name","events_statements_summary_by_account_by_event_name","events_statements_summary_by_user_by_event_name","events_statements_summary_by_host_by_event_name","events_statements_summary_global_by_event_name","events_statements_summary_by_digest","users","accounts","hosts","socket_instances","socket_summary_by_instance","socket_summary_by_event_name","session_connect_attrs","session_account_connect_attrs","pma__bookmark","pma__central_columns","pma__column_info","pma__designer_settings","pma__export_templates","pma__favorite","pma__history","pma__navigationhiding","pma__pdf_pages","pma__recent","pma__relation","pma__savedsearches","pma__table_coords","pma__table_info","pma__table_uiprefs","pma__tracking","pma__userconfig","pma__usergroups","pma__users"};
            List<String> v = new ArrayList<>();
            for(String s : valores) {
                v.add(s);
            }
            Connection con;
        try {
            con = Conexao.Conexao.getConnection();
            String sql="SELECT `TABLE_NAME` FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE='BASE TABLE'";
            PreparedStatement stm = con.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()) {
                if(!(rs.getString("TABLE_NAME").equalsIgnoreCase("login"))) {
                    if(!(rs.getString("TABLE_NAME").equalsIgnoreCase("produtos"))) {
                        if(!(rs.getString("TABLE_NAME").equalsIgnoreCase("relatorios"))) {
                            if(!(rs.getString("TABLE_NAME").equalsIgnoreCase("gerente"))) {
                                if(!v.contains(rs.getString("TABLE_NAME"))) {
                                    comandas.add(rs.getString("TABLE_NAME"));
                                }                             
                            }

                        }
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastroProdutos.class.getName()).log(Level.SEVERE, null, ex);
        }
            return comandas;
        }
        
}
