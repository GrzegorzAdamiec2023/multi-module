package pl.edu.agh.kis.pz1;

public class Displayer extends Thread{
    Writer[] pis;
    Reader[] czyt;
    int[] gaps;
    String[] rowValues;

    public Displayer(Writer[] pisarze, Reader[] czytelnicy){
        this.pis = pisarze;
        this.czyt = czytelnicy;
        this.gaps = new int[pisarze.length + czytelnicy.length + 3];
        this.rowValues = new String[pisarze.length + czytelnicy.length + 3];
    }

    private String MakeTop(){
        StringBuilder top = new StringBuilder();
        top.append("| Queue | Work | Rest |");
        this.gaps[0] = 8;
        this.gaps[1] = 7;
        this.gaps[2] = 7;

        for (int i = 0; i < this.pis.length; i++){
            top.append(" " + "Wr").append(this.pis[i].ID).append(" |");
            this.gaps[i + 3] = 5 + Integer.toString(this.pis[i].ID).length();
        }

        for (int i = 0; i < this.czyt.length; i++){
            top.append(" " + "Re").append(this.czyt[i].ID).append(" |");
            this.gaps[i + 3 + this.pis.length] = 5 + Integer.toString(this.czyt[i].ID).length();
        }

        // Wystarczy raz stworzyć nagłówek
        return top.toString();
    }

    private String GetState(ReaderWriter i){
        if (i.queue){
            return "Q";
        }else if(i.work){
            return "W";
        }else{
            return "R";
        }
    }


    private String MakeRow(){
        int wCount = 0;
        int rCount = 0;
        int qCount = 0;
        StringBuilder row = new StringBuilder();
        row.append("|");

        for (int i = 0; i < this.pis.length; i++){
            String cha = GetState(this.pis[i]);
            if (cha.equals("W")){
                wCount++;
            }else if(cha.equals("R")){
                rCount++;
            }else {
                qCount++;
            }
            this.rowValues[i + 3] = cha;
        }

        for (int i = 0; i < this.czyt.length; i++){
            String cha = GetState(this.czyt[i]);
            if (cha.equals("W")){
                wCount++;
            }else if(cha.equals("R")){
                rCount++;
            }else {
                qCount++;
            }
            this.rowValues[i + 3 + this.pis.length] = cha;
        }

        this.rowValues[0] = Integer.toString(qCount);
        this.rowValues[1] = Integer.toString(wCount);
        this.rowValues[2] = Integer.toString(rCount);

        for(int i=0; i< this.rowValues.length; i++){
            StringBuilder toPut = new StringBuilder();
            toPut.append(this.rowValues[i]);

            for(int j=0; j<this.gaps[i] - 1 - this.rowValues[i].length(); j++){
                toPut.append(" ");
            }
            toPut.append("|");
            row.append(toPut);
        }
        return row.toString();
    }

    @Override
    public void run() {
        String naglowek = this.MakeTop();

        System.out.println(naglowek);

        for(;;){
            System.out.println(MakeRow());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
