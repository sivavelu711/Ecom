package com.te.ecommerce.service;

import com.te.ecommerce.dto.ShippingAddressDto;
import com.te.ecommerce.entity.ShippingAddress;

public interface ShippingAddressService {

	boolean shippingAddressCreation(ShippingAddressDto shippingAddressDto);

	ShippingAddress shippingAddressFetching(ShippingAddressDto shippingAddressDto);

	ShippingAddress shippingAddressUpdating(ShippingAddressDto shippingAddressDto);

	String shippingAddressDeleting(ShippingAddressDto shippingAddressDto);

}
