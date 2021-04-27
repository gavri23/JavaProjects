public class SingleNom {
        private int power;
        private double Coefficient;

        public SingleNom(double Coefficient, int power) {
            this.power = power;
            this.Coefficient = Coefficient;
        }

        public int getPower() {
            return this.power;
        }

        public double getCoefficient() {
            return this.Coefficient;
        }

        @Override
        public String toString() {
            String str = "";
            if (this.Coefficient < 0) {
                str = str + this.Coefficient + "x";
            } else if (this.Coefficient > 0) {
                str = str + '+' + this.Coefficient + "x";
            }
            if (this.power > 1) {
                str = str + "^" + this.power;
            }
            return str;
        }
    }

