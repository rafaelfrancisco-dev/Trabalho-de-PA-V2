/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicaJogo;

import java.io.Serializable;
import static java.lang.System.exit;

/**
 *
 * @author Rafael
 */
public class EsperaMovimento extends Estado implements Serializable {

    public EsperaMovimento(Jogo j) {
        super(j);
    }

    @Override
    public Estado Upgrade(int escolha) {
        return this;
    }

    @Override
    public Estado Compra(int escolhacompra) {
        return this;
    }

    @Override
    public Estado Movimento(int opcao, int conta) {
        int x,y;
        x=J.jogador.getNave().getX();
        y=J.jogador.getNave().getY();
        
        if(opcao==1)
        {
            if(y+1<7 && J.mapa[y+1][x].getCheck()==true && !" ".equals(J.mapa[y+1][x].getTexto()))
            {
                J.jogador.getNave().setY(y+1);
                J.jogador.setMoney(J.jogador.getMoney()-1);
            }else{
                opcao=0;
            }
        }
        if(opcao==2)
        {
            if(y-1>-1 && J.mapa[y-1][x].getCheck()==true && !" ".equals(J.mapa[y-1][x].getTexto()))
            {
                J.jogador.getNave().setY(y-1);
                J.jogador.setMoney(J.jogador.getMoney()-1);
            }else{
                opcao=0;
            }
        }
        if(opcao==3)
        {
            if(x+1<9 && J.mapa[y][x+1].getCheck()==true && !" ".equals(J.mapa[y][x+1].getTexto()))
            {
                J.jogador.getNave().setX(x+1);
                J.jogador.setMoney(J.jogador.getMoney()-1);
            }else{
                opcao=0;
            }
        }
        if(opcao==4)
        {
            if(x-1>-1 && J.mapa[y][x-1].getCheck()==true &&!" ".equals(J.mapa[y][x-1].getTexto()))
            {
                J.jogador.getNave().setX(x-1);
                J.jogador.setMoney(J.jogador.getMoney()-1);
            }else{
                opcao=0;
            }
        }
        if(opcao==5)
        {
            if(y+1<7 && x+1<9 && J.mapa[y+1][x+1].getCheck()==true && !" ".equals(J.mapa[y+1][x+1].getTexto()))
            {
                J.jogador.getNave().setY(y+1);
                J.jogador.getNave().setX(x+1);
                J.jogador.setMoney(J.jogador.getMoney()-1);
            }else{
                opcao=0;
            }
        }
        if(opcao==6)
        {
            if(y+1<7 && x-1>-1 && J.mapa[y+1][x-1].getCheck()==true && !" ".equals(J.mapa[y+1][x-1].getTexto()))
            {
                J.jogador.getNave().setY(y+1);
                J.jogador.getNave().setX(x-1);
                J.jogador.setMoney(J.jogador.getMoney()-1);
            }else{
                opcao=0;
            }
        }
        if(opcao==7)
        {
            if(y-1>-1 && x+1<9 && J.mapa[y-1][x+1].getCheck()==true && !" ".equals(J.mapa[y-1][x+1].getTexto()))
            {
                J.jogador.getNave().setY(y-1);
                J.jogador.getNave().setX(x+1);
                J.jogador.setMoney(J.jogador.getMoney()-1);
            }else{
                opcao=0;
            }
        }
        if(opcao==8)
        {
            if(y-1>-1 && x-1>-1 && J.mapa[y-1][x-1].getCheck()==true && !" ".equals(J.mapa[y-1][x-1].getTexto()))
            {
                J.jogador.getNave().setY(y-1);
                J.jogador.getNave().setX(x-1);
                J.jogador.setMoney(J.jogador.getMoney()-1);
            }else{
                opcao=0;
            }
        }
        
        if(opcao==9)
        {
                J.jogador.getNave().setX(J.XTrans.get(conta));
                J.jogador.getNave().setY(J.YTrans.get(conta));
            }else{
                opcao=0;
            }
        return new EsperaMovimento(this.J);
    }

    @Override
    public Estado Vende(int escolhavenda) {
        return this;
    }

    @Override
    public Estado fimEstado() {
        return new EsperaVenda(this.J);
    }

    @Override
    public Estado Recomeca() {
        return this;
    }

    @Override
    public void fimJogo() {
        exit(0);
    }

    @Override
    public int ganha() {
        return -1;
    }
    
}
