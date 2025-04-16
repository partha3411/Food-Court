
package com.example.parthajavafinalproject.Sabbir;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class SupplyRequest {


    private final StringProperty requestId;
    private final StringProperty product;
    private final IntegerProperty quantity;
    private final StringProperty status;


    public SupplyRequest(String requestId, String product, int quantity, String status) {
        this.requestId = new SimpleStringProperty(requestId);
        this.product = new SimpleStringProperty(product);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.status = new SimpleStringProperty(status);
    }


    public String getRequestId() {
        return requestId.get();
    }

    public void setRequestId(String requestId) {
        this.requestId.set(requestId);
    }

    public StringProperty requestIdProperty() {
        return requestId;
    }

    public String getProduct() {
        return product.get();
    }

    public void setProduct(String product) {
        this.product.set(product);
    }

    public StringProperty productProperty() {
        return product;
    }

    public int getQuantity() {
        return quantity.get();
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public IntegerProperty quantityProperty() {
        return quantity;
    }

    public String getStatus() {
        return status.get();
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public StringProperty statusProperty() {
        return status;
    }


    @Override
    public String toString() {
        return "SupplyRequest{" +
                "requestId='" + requestId.get() + '\'' +
                ", product='" + product.get() + '\'' +
                ", quantity=" + quantity.get() +
                ", status='" + status.get() + '\'' +
                '}';
    }
}
