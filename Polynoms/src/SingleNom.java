public class SingleNom {
    private double coefficient;
    private int power;
    public SingleNom(){}
    public SingleNom(int pow, double coef) {
        coefficient = coef;
        power = pow;
    }
    public int getPower() {  return power;}
    public void setPower(Integer power) {
        this.power = power;
    }
    public double getCoefficient() { return coefficient;}
    public void setCoefficient(Double coefficient) {this.coefficient = coefficient;}
    @Override
    public String toString() {
        String str = "";
        if (this.coefficient < 0) {
            str = str + this.coefficient + "X";
        } else if (this.coefficient > 0) {
            str = str + " + " + this.coefficient + "X";
        }
        if (this.power > 1) {
            str = str + "^" + this.power + " ";
        }
        return str;
    }
}
