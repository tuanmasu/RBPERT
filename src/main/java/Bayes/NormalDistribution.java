package Bayes;

public class NormalDistribution {
     public static double pdf(double x) {
        return Math.exp(-x*x / 2) / Math.sqrt(2 * Math.PI);
    }

    // return pdf(x, mu, signma) = Gaussian pdf with mean mu and stddev sigma
    public static double pdf(double x, double mu, double sigma) {
        return pdf((x - mu) / sigma) / sigma;
    }

    // return cdf(z) = standard Gaussian cdf using Taylor approximation
    public static double cdf(double z) {
        if (z < -8.0) return 0.0;
        if (z >  8.0) return 1.0;
        double sum = 0.0, term = z;
        for (int i = 3; Math.abs(term) > 1e-9; i += 2) {
            sum  = sum + term;
            term = term * z * z / i;
        }
        return 0.5 + sum * pdf(z);
    }

    // return cdf(z, mu, sigma) = Gaussian cdf with mean mu and stddev sigma
    public static double cdf(double z, double mu, double sigma) {
        System.out.println(sigma);
        return cdf((z - mu) / sigma);
    } 

    // Compute z such that cdf(z) = y via bisection search
    public static double inverseCDF(double y) {
        return inverseCDF(y, 0.00000001, -8, 8);
    } 

    // bisection search
    private static double inverseCDF(double y, double delta, double lo, double hi) {
        double mid = lo + (hi - lo) / 2;
        if (hi - lo < delta) return mid;
        if (cdf(mid) > y) return inverseCDF(y, delta, lo, mid);
        else              return inverseCDF(y, delta, mid, hi);
    }

}
