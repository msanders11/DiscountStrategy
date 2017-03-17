/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author msanders11
 */
public interface FormatReceiptStrategy {

    public abstract String getFormattedData(final Receipt receipt);
    
}
