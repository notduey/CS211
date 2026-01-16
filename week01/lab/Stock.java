package week01.lab;

public class Stock {
    private String symbol; // stock symbol, e.g. "YHOO"
    private int totalShares; // total shares purchased
    private double totalCost; // total cost for all shares

    // Initializes a new Stock with no shares purchased.
    // Precondition: symbol != null
    public Stock(String theSymbol) {
        theSymbol = symbol;
    }

    // Returns the total profit or loss earned on this stock,
    // based on the given price per share.
    // pre: currentPrice >= 0.0
    public double getProfit(double currentPrice) {
        return totalShares * currentPrice - totalCost;
    }

    // Records purchase of the given shares at the given price.
    // pre: shares >= 0 && pricePerShare >= 0.0
    public void purchase(int shares, double pricePerShare) {
        totalShares += shares;
        totalCost += shares * pricePerShare;
    }

    // Returns this Stock's symbol value.
    public String __getSymbol() {
        return symbol;
    }
	
    // Returns this Stock's total number of shares purchased.
    public int __getTotalShares() {
        return totalShares;
    }
	
    // Returns this Stock's total cost for all shares.
    public double __getTotalCost() {
        return totalCost;
    }

    // Resets this Stock's number of shares purchased and total cost.
    public void clear() {
        totalShares = 0;
        totalCost = 0.0;
    }
}