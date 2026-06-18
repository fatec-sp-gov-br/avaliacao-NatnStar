package Jogo;

public class Batalha_de_Herois {

	static class Personagem {

        private String nome;
        private int vida;
        private int ataque;
        private int defesa;
        private boolean pocaoUtilizada;

        public Personagem(String nome, int vida, int ataque, int defesa) {
        	
            this.nome = nome;
            this.vida = vida;
            this.ataque = ataque;
            this.defesa = defesa;
            this.pocaoUtilizada = false;
        }

        public void atacar(Personagem inimigo) {
        	
            int dano = this.ataque - inimigo.defesa;

            if (dano < 1) {
                dano = 1;
            }

            System.out.println(this.nome + " ataca " + inimigo.getNome());
            inimigo.receberDano(dano);
            System.out.println(inimigo.getNome() + " possui " + inimigo.getVida() + " de vida\n");
        }

        public void receberDano(int dano) {
        	
            this.vida -= dano;

            if (this.vida < 0) {
                this.vida = 0;
            }
        }

        public void usarPocao(Pocao pocao) {
        	
            if (!pocaoUtilizada && estaVivo()) {
                System.out.println(this.nome + " usa " + pocao.getNome());
                this.vida += pocao.getCura();
                pocaoUtilizada = true;
                System.out.println(this.nome + " possui " + this.vida + " de vida\n");
            }
        }

        public boolean estaVivo() {
        	
            return this.vida > 0;
        }

        public String getNome() {
        	
            return nome;
        }

        public int getVida() {
        	
            return vida;
        }
    }

    static class Pocao {

        private String nome;
        private int cura;

        public Pocao(String nome, int cura) {
        	
            this.nome = nome;
            this.cura = cura;
        }

        public String getNome() {
        	
            return nome;
        }

        public int getCura() {
        	
            return cura;
        }
    }

    public static void main(String[] args) {

        Personagem artemis = new Personagem("Artemis", 30, 8, 3);
        Personagem goblin = new Personagem("Goblin", 20, 6, 2);

        Pocao pocaoPequena = new Pocao("Poção Pequena", 10);

        System.out.println("=== BATALHA INICIADA ===\n");

        while (artemis.estaVivo() && goblin.estaVivo()) {

            artemis.atacar(goblin);

            if (!goblin.estaVivo()) break;

            if (goblin.getVida() <= 10) {
            	
                goblin.usarPocao(pocaoPequena);
            } else {
            	
                goblin.atacar(artemis);
            }

            if (!artemis.estaVivo()) break;

            if (artemis.getVida() <= 10) {
            	
                artemis.usarPocao(pocaoPequena);
            }
        }

        System.out.println("=== FIM DA BATALHA ===\n");

        if (artemis.estaVivo()) {
        	
            System.out.println("Vencedor: " + artemis.getNome());
        } else {
        	
            System.out.println("Vencedor: " + goblin.getNome());
        }
    }


}
