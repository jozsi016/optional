package com.nagy.java;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalMethods {
    public final String USER_STATUS = "UNKNOWN";

    public Optional<Cart> fetchCart() {
        Optional<Cart> emptyCart = Optional.empty();
        return emptyCart;
    }

    public Cart returnCartOptionalIfPresent() {
        Optional<Cart> emptyCart = Optional.empty();
        Cart myCart;
        if(emptyCart.isPresent()){
             myCart = emptyCart.get();
        }else {
             myCart = new Cart();
        }
        return myCart;
    }
    public String findUserStatus(long id){
        Optional<String> status = Optional.empty();
        return status.orElse(USER_STATUS);
    }

    public String computeStatus(){
        return "method call computeStatus";
    }

    public String findUserSatusComputed(long id){
        Optional<String> status = Optional.empty();
        status = Optional.of("Messi");
        return status.orElseGet(this::computeStatus);
    }

    public String findUserStatusExceptionThrown(long id) throws IllegalStateException{
        Optional<String> status =Optional.empty() ; // prone to return an empty Optional
        return status.orElseThrow(IllegalStateException::new);
    }

    public String optionalMapTransfer () {
        Optional<String> lowername = Optional.of("Messi");
        Optional<String> upperName = lowername.map(String::toUpperCase);
        return upperName.get();
    }

    public String optionalStreamMap(){
        List<Product> products = Arrays.asList(new Product(12,"labda"),
                new Product(22,"szek"),new Product(17,"faszom"));

        String name = products.stream()
                .filter(p -> p.getPrice() < 15)
                .findFirst()
                .map(Product::getName)
                .map(String::toUpperCase)
                .orElse("NOT FOUND");
        return name;
    }

    public boolean validatePasswordLength(String userid){
        Optional<String> password = Optional.ofNullable("securepassword");
        return password.filter((p)->p.length()> 5).isPresent();
    }
}
