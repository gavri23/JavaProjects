import java.util.ArrayList;
public class Polynom {
    private ArrayList<SingleNom> polynoms;
    public Polynom(){}
    public Polynom(int[] pow, double[] coef) throws Exception {
        ArrayList<SingleNom> poly = new ArrayList<>();
        if (coef.length != pow.length)
            throw new Exception("Error!! the arrays are not in the same length");
        if(coef.length == 1) {//edge case - the polynom is a Single nom
            SingleNom nom = new SingleNom(pow[0], coef[0]);
            poly.add(nom);
        }
        else {
            for (int i = 0; i < coef.length - 1; i++) {
                SingleNom nom1 = new SingleNom(pow[i], coef[i]);
                if (pow[i] != pow[i + 1]) {
                    poly.add(nom1);
                    if (i + 1 == coef.length - 1) {
                        SingleNom nom2 = new SingleNom(pow[i + 1], coef[i + 1]);
                        poly.add(nom2);
                        break;
                    }
                }
                else {//Merge Single Noms with the same powers into one nome
                    while (pow[i] == pow[i + 1]) {
                        SingleNom nom2 = new SingleNom(pow[i + 1], coef[i + 1]);
                        nom1.setCoefficient(nom1.getCoefficient() + nom2.getCoefficient());
                        i++;
                        if (i == coef.length - 1)
                            break;
                    }
                    if (pow[i] != pow[i - 1] && i + 1 == coef.length) {//make sure we add the last element to the polynom
                        poly.add(nom1);
                        break;
                    }
                    poly.add(nom1);
                }
            }
        }
            polynoms = poly;
        }
        /*The plus and minus methods are just like merging to sorted lists into one sorted list*/
    public Polynom plus(Polynom pol1, Polynom pol2){
        Polynom sumPol = new Polynom();
        ArrayList<SingleNom> sum = new ArrayList<>();
        int ptr1 = 0;
        int ptr2 = 0;
        while(ptr1 < pol1.polynoms.size() && ptr2 < pol2.polynoms.size()){
          int pow1 = pol1.polynoms.get(ptr1).getPower();
          int pow2 = pol2.polynoms.get(ptr2).getPower();
          double coef;
        /*adds up the coefficients*/
        if(pow1 == pow2){
            coef = pol1.polynoms.get(ptr1).getCoefficient() + pol2.polynoms.get(ptr2).getCoefficient();
            SingleNom node = new SingleNom(pow1,coef);
            sum.add(node);
            ptr1++;ptr2++;
        }
        else if(pow1 > pow2){
            sum.add(pol1.polynoms.get(ptr1));
            ptr1++;
        }
        else{
            sum.add(pol2.polynoms.get(ptr2));
            ptr2++;
        }
    }
        if(ptr1 == pol1.polynoms.size() && ptr2 < pol2.polynoms.size())
            for(int i = ptr2; i< pol2.polynoms.size(); i++)
                sum.add(pol2.polynoms.get(i));
        if(ptr2 == pol2.polynoms.size() && ptr1 < pol1.polynoms.size())
            for(int i = ptr1; i < pol1.polynoms.size(); i++)
                sum.add(pol1.polynoms.get(i));
        removeZeros(sum);
        sumPol.polynoms = sum;
        return sumPol;
    }
    public Polynom minus(Polynom pol1, Polynom pol2){
        Polynom substractionPol = new Polynom();
        ArrayList<SingleNom> sub = new ArrayList<>();
        int ptr1 = 0;
        int ptr2 = 0;
        while(ptr1 < pol1.polynoms.size() && ptr2 < pol2.polynoms.size()){
            int pow1 = pol1.polynoms.get(ptr1).getPower();
            int pow2 = pol2.polynoms.get(ptr2).getPower();
            double coef;
            /*substract the coefficients*/
            if(pow1 == pow2){
                coef = pol1.polynoms.get(ptr1).getCoefficient() - pol2.polynoms.get(ptr2).getCoefficient();
                SingleNom node = new SingleNom(pow1,coef);
                sub.add(node);
                ptr1++;ptr2++;
            }
            else if(pow1 > pow2){
                coef = pol1.polynoms.get(ptr1).getCoefficient();
                SingleNom node = new SingleNom(pow1,coef);
                sub.add(node);
                ptr1++;
            }
            else{
                coef = pol2.polynoms.get(ptr2).getCoefficient();
                SingleNom node = new SingleNom(pow2,coef);
                sub.add(node);
                ptr2++;
            }
        }
        if(ptr1 == pol1.polynoms.size() && ptr2 < pol2.polynoms.size())
            for(int i = ptr2; i< pol2.polynoms.size(); i++){
                SingleNom nom = new SingleNom(pol2.polynoms.get(i).getPower(),(-1)*pol2.polynoms.get(i).getCoefficient());
                sub.add(nom);
            }
        if(ptr2 == pol2.polynoms.size() && ptr1 < pol1.polynoms.size())
            for(int i = ptr1; i < pol1.polynoms.size(); i++)
                sub.add(pol1.polynoms.get(i));
        removeZeros(sub);
        substractionPol.polynoms = sub;
        return substractionPol;
    }
    public void derivative(Polynom pol){
        for(int i = 0; i<pol.polynoms.size();i++){

            SingleNom nom = polynoms.get(i);
            int power = polynoms.get(i).getPower();
            double coefficient = polynoms.get(i).getCoefficient();

            if(power>0){
                nom.setCoefficient(power*coefficient);
              nom.setPower(power-1);
            }
            else{
                polynoms.remove(nom);
            }
        }
    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        if(this.polynoms.size() == 1){//edge case if the polynom length is 1
            str.append(this.polynoms.get(0).getCoefficient()).append("X").append("^").append(this.polynoms.get(0).getPower());
            return str.toString();
        }
        str.append(this.polynoms.get(0).getCoefficient()).append("X").append("^").append(this.polynoms.get(0).getPower());
        for (int i = 1; i < this.polynoms.size()-1; i++) {
            str.append(polynoms.get(i).toString());
        }
        if (this.polynoms.get(this.polynoms.size() - 1).getPower() == 0) {
            if (this.polynoms.get(this.polynoms.size() - 1).getCoefficient() < 0) {
                str.append(this.polynoms.get(this.polynoms.size() - 1).getCoefficient());
            }
            else {
                str.append("+").append(this.polynoms.get(this.polynoms.size() - 1).getCoefficient());
            }
        } else {
            str.append(polynoms.get(this.polynoms.size() - 1).toString());
        }
        return str.toString();
    }
    public void removeZeros(ArrayList<SingleNom> polynom){
        int length = polynom.size()-1;
       for(int i = length; i > 0;i--){
           if(polynom.get(i).getCoefficient() == 0)
               polynom.remove(polynom.get(i));
        }
        if(polynom.size() == 1 && polynom.get(0).getCoefficient() == 0 ) {
            polynom.remove(polynom.get(0));
            SingleNom polZero = new SingleNom(0,0);
            polynom.add(polZero);
        }
    }
    public boolean equals(Object pol) {
        if (pol instanceof Polynom) {
            if (this.polynoms.size() != ((Polynom) pol).polynoms.size())
                return false;
            for (int i = 0; i < this.polynoms.size(); i++) {
                if(this.polynoms.get(i).getCoefficient() != ((Polynom)pol).polynoms.get(i).getCoefficient())
                    return false;
                if(this.polynoms.get(i).getPower() != ((Polynom) pol).polynoms.get(i).getPower())
                    return false;
            }
            return true;
        } else {
            System.out.println("Error: The object is not a Polynom");
            return false;
        }
    }

}
