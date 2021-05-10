package model;

import java.util.ArrayList;

public class InvestimentosItem {
    private final String moeda;
    private final String percentual;
    private final String valAtual;
    private final String valComprado;
    private final String qtdMoeda;
    private final String saldo;

    public InvestimentosItem(String[] resultado) {
        this.moeda = resultado[0];
        this.percentual = resultado[1];
        this.valAtual = resultado[2];
        this.valComprado = resultado[3];
        this.qtdMoeda = resultado[4];
        this.saldo = resultado[5];
    }

    public static ArrayList<InvestimentosItem> createInvestimentosList(String[] investimentosDB, int numInvest) {
        ArrayList<InvestimentosItem> invest = new ArrayList();

        // --------- PEGAR DO BANCO A QUANTIDADE DE ITENS QUE É PRA MOSTRAR NA TELA -----------
        for (int i = 0; i <= numInvest; i++){
            invest.add(new InvestimentosItem(investimentosDB[i].split(";")));
        }

        return invest;
    }

    public String getMoeda() {
        return moeda;
    }

    public String getPercentual() {
        return percentual;
    }

    public String getValAtual() {
        return valAtual;
    }

    public String getValComprado() {
        return valComprado;
    }

    public String getQtdMoeda() {
        return qtdMoeda;
    }

    public String getSaldo() {
        return saldo;
    }
}
