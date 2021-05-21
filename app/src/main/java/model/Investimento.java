package model;

import java.util.ArrayList;

public class Investimento {

    private final String moeda;
    private final String qtdMoeda;
    private final String valComprado;

    public Investimento(String[] resultado) {
        this.moeda = resultado[0];
        this.qtdMoeda = resultado[1];
        this.valComprado = resultado[2];
    }

    public static ArrayList<Investimento> createInvestimentoList(String[] investimentosDB, int numInvest) {
        ArrayList<Investimento> invest = new ArrayList();

        // --------- PEGAR DO BANCO A QUANTIDADE DE ITENS QUE É PRA MOSTRAR NA TELA -----------
        for (int i = 0; i <= numInvest; i++){
            invest.add(new Investimento(investimentosDB[i].split(";")));
        }

        return invest;
    }

    public String getMoedaDB() {
        return moeda;
    }

    public String getQtdMoedaDB() {
        return qtdMoeda;
    }

    public String getValCompradoDB() {
        return valComprado;
    }
}
