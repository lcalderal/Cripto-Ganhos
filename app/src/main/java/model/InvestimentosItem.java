package model;

import java.util.ArrayList;

public class InvestimentosItem {
    private final String moeda;
    private final String valComprado;
    private final String qtdMoeda;
    private final String valAtual;
    private final String percentual;
    private final String saldo;

    public InvestimentosItem(String[] resultado) {
        this.moeda = resultado[0];
        this.qtdMoeda = resultado[1];
        this.valComprado = resultado[2];
        this.valAtual = "";
        this.percentual = "";
        this.saldo = "";
    }

    public static ArrayList<InvestimentosItem> createInvestimentosList(String[] investimentosDB, int numInvest) {
        ArrayList<InvestimentosItem> invest = new ArrayList();

        // --------- PEGAR DO BANCO A QUANTIDADE DE ITENS QUE É PRA MOSTRAR NA TELA -----------
        for (int i = 0; i <= numInvest; i++){
            invest.add(new InvestimentosItem(investimentosDB[i].split(";")));
        }

        return invest;
    }

    public String getMoeda() { return moeda; }

    public String getQtdMoeda() {
        return qtdMoeda;
    }

    public String getValComprado() {
        return valComprado;
    }

    public String getValAtual() { return valAtual; }

    public String getPercentual() { return percentual; }

    public String getSaldo() { return saldo; }
}
