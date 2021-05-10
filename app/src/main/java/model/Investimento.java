package model;

import java.util.ArrayList;

public class Investimento {

    private final String moeda;
    private final String valComprado;
    private final String qtdMoeda;

    public Investimento(String[] resultado) {
        this.moeda = resultado[0];
        this.valComprado = resultado[1];
        this.qtdMoeda = resultado[2];
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

    public String getValCompradoDB() {
        return valComprado;
    }

    public String getQtdMoedaDB() {
        return qtdMoeda;
    }
}
