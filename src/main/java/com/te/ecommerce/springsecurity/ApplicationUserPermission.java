package com.te.ecommerce.springsecurity;

public enum ApplicationUserPermission {
	PRODUCT_CREATE("product:create"),
	PRODUCT_READ("product:read"),
	PRODUCT_WRITE("product:write"),
	PRODUCT_DELETE("product:delete"),
	CUSTOMER_READ("customer:read");

	
	private final String permission;

	private ApplicationUserPermission(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}	
}
