
import java.util.ArrayList;

    public class Polynom {

        private ArrayList<SingleNom> polynom = new ArrayList<>();

        public Polynom(double[] Coefficients, int[] powers) throws Exception {
            if (Coefficients.length != powers.length) {
                throw new Exception("Error!! the arrays are not in the same length");
            }
            for (int i = 0; i < powers.length; i++) {
                polynom.add(i, new SingleNom(Coefficients[i], powers[i]));
            }
            sort(polynom);
        }


        public Polynom(ArrayList<SingleNom> pol) {
            this.polynom = new ArrayList<>(pol);
        }

        public ArrayList<SingleNom> getPolynom()
        {
            return this.polynom;
        }

        public void sort(ArrayList<SingleNom> polynom)
        {
            for (int i = 0; i < polynom.size(); i++) { //Sort the array
                for (int j = i + 1; j < polynom.size(); j++) {
                    if (polynom.get(i).getPower() < polynom.get(j).getPower()) {
                        SingleNom temp = polynom.get(i);
                        polynom.set(i, polynom.get(j));
                        polynom.set(j, temp);
                    }
                }
            }

            for (int i = 0, j = 1; j < polynom.size(); i++, j++) { // unite same powers
                if (polynom.get(i).getPower() == polynom.get(j).getPower()) {
                    polynom.set(j, new SingleNom(polynom.get(i).getCoefficient() + polynom.get(j).getCoefficient(), polynom.get(j).getPower()));
                    polynom.remove(i);
                }
            }
        }

        public Polynom Plus(Polynom pol) {
            Polynom newPol = new Polynom(this.polynom);
            boolean found ;
            for (int i = 0; i < pol.polynom.size(); i++) {
                found = false;
                int newpower = pol.polynom.get(i).getPower();
                int j = 0;
                while (j < newPol.polynom.size() && !found) {
                    int currentpower = newPol.polynom.get(j).getPower();
                    double newCoefficient = pol.polynom.get(i).getCoefficient();
                    if (newpower == currentpower) {
                        newPol.polynom.set(j, new SingleNom(newCoefficient + newPol.polynom.get(j).getCoefficient(), newpower));
                        found = true;
                    }
                    j++;
                }
                if (!found) {
                    newPol.polynom.add(0, pol.polynom.get(i));
                }
            }
            newPol.sort(newPol.getPolynom());
            return newPol;
        }

        public Polynom Minus(Polynom pol) {
            Polynom newPol = new Polynom(this.polynom);
            boolean found;
            for (int i = 0; i < pol.polynom.size(); i++) {
                found = false;
                int newpower = pol.polynom.get(i).getPower();
                double newCoefficient = pol.polynom.get(i).getCoefficient();
                int j = 0;
                while (j <  newPol.polynom.size() && !found) {
                    int currentpower =  newPol.polynom.get(j).getPower();
                    if (newpower == currentpower) {
                        newPol.polynom.set(j, new SingleNom( newPol.polynom.get(j).getCoefficient() - newCoefficient, newpower));
                        found = true;
                    }
                    j++;
                }
                if (!found) {
                    newPol.polynom.add(0, new SingleNom(-newCoefficient, newpower));
                }
            }
            newPol.sort(newPol.getPolynom());
            return newPol;
        }

        public Polynom Cut() {
            Polynom newPol = new Polynom(this.polynom);
            for (int i = 0; i < newPol.polynom.size(); i++) {
                int Power =  newPol.polynom.get(i).getPower();
                if (Power != 0) {
                    double Coefficient =  newPol.polynom.get(i).getCoefficient();
                    newPol.polynom.set(i, new SingleNom(Power * Coefficient, Power - 1));
                } else {
                    newPol.polynom.remove(i);
                }
            }
            return newPol;
        }

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder();
            str.append(this.polynom.get(0).getCoefficient()).append("X").append("^").append(this.polynom.get(0).getPower());
            for (int i = 1; i < this.polynom.size() - 1; i++) {
                str.append(polynom.get(i).toString());
            }
            if (this.polynom.get(this.polynom.size() - 1).getPower() == 0) {
                if (this.polynom.get(this.polynom.size() - 1).getCoefficient() < 0) {
                    str.append(this.polynom.get(this.polynom.size() - 1).getCoefficient());
                } else {
                    str.append("+").append(this.polynom.get(this.polynom.size() - 1).getCoefficient());
                }
            } else {
                str.append(polynom.get(this.polynom.size() - 1).toString());
            }
            return str.toString();
        }

        public boolean equals(Object pol) {
            if (pol instanceof Polynom) {
                if (this.polynom.size() != ((Polynom) pol).polynom.size())
                    return false;
                for (int i = 0; i < this.polynom.size(); i++) {
                    if (this.polynom.get(i).getCoefficient() != ((Polynom)pol).polynom.get(i).getCoefficient() || this.polynom.get(i).getPower() != ((Polynom) pol).polynom.get(i).getPower())
                        return false;
                }
                return true;
            } else {
                System.out.println("Object type error, should be Polynom");
                return false;
            }
        }
    }

