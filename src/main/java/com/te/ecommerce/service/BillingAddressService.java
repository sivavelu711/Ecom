package com.te.ecommerce.service;

import com.te.ecommerce.dto.BillingAddressDto;
import com.te.ecommerce.entity.BillingAddress;

public interface BillingAddressService {

	boolean billingAddressCreation(BillingAddressDto billingAddressDto);

	BillingAddress billingAddressFetching(BillingAddressDto billingAddressDto);

	BillingAddress billingAddressUpdating(BillingAddressDto billingAddressDto);

	String billingAddressDeleting(BillingAddressDto billingAddressDto);

}
