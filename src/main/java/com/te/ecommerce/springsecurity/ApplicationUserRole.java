package com.te.ecommerce.springsecurity;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.google.common.collect.Sets;

public enum ApplicationUserRole {
	CUSTOMER(Sets.newHashSet()),
	MANAGER(Sets.newHashSet(ApplicationUserPermission.PRODUCT_CREATE
			,ApplicationUserPermission.PRODUCT_READ
			, ApplicationUserPermission.PRODUCT_WRITE
			,ApplicationUserPermission.PRODUCT_DELETE
			,ApplicationUserPermission.CUSTOMER_READ));

	private final Set<ApplicationUserPermission> permissions;

	private ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
		this.permissions = permissions;
	}

	public Set<ApplicationUserPermission> getPermissions() {
		return permissions;
	}
	public Set<SimpleGrantedAuthority> getGrantedAuthorities(){
		Set<SimpleGrantedAuthority> permissions=getPermissions().stream().map(permission->new SimpleGrantedAuthority(permission.getPermission()))
		.collect(Collectors.toSet());
		permissions.add(new SimpleGrantedAuthority("Role_"+this.name()));
		return permissions;
	}

}
