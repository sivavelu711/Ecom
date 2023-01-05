package com.te.ecommerce.serviceimplementation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.te.ecommerce.dto.BillingAddressDto;
import com.te.ecommerce.entity.BillingAddress;
import com.te.ecommerce.exception.BillingAddressException;
import com.te.ecommerce.repository.BillingAddressRepository;
import com.te.ecommerce.service.BillingAddressService;

@Service
public class BillingAddressServiceImplementation implements BillingAddressService {
	@Autowired
	private BillingAddressRepository billingAddressRepository;
	@Autowired
	private BillingAddress billingAddress;
	
//	@Autowired
//	private CustomerRepository customerRepository;
	
	public boolean billingAddressCreation(BillingAddressDto billingAddressDto) {
		
		BeanUtils.copyProperties(billingAddressDto, billingAddress);
		billingAddress.setId(billingAddressDto.getId());
		billingAddress.setAddress(billingAddressDto.getAddress());
		billingAddress.setCity(billingAddressDto.getCity());
		billingAddress.setState(billingAddressDto.getState());
		billingAddress.setZipcode(billingAddressDto.getZipcode());
		billingAddress.setCountry(billingAddressDto.getCountry());
		//billingAddress.setId(billingAddressDto.getCustomerId());
//		Customer customer = customerRepository.findById(id).orElse(null);
//		billingAddress.setCustomer(customer);
		BillingAddress save = billingAddressRepository.save(billingAddress);
		if (save != null) {
			return true;
		} 
			throw new BillingAddressException("Address not created");
	}

	@Override
	public BillingAddress billingAddressFetching(BillingAddressDto billingAddressDto) {
		BeanUtils.copyProperties(billingAddressDto, billingAddress);
		BillingAddress address = billingAddressRepository.findById(billingAddress.getId()).orElseThrow(()-> new BillingAddressException("Address not fetched"));
//		if (billingAddressDto.getCustomerId().equals(address.getCustomerId())) {
//			return address;
//		}
		return address;
	
		
	}

	@Override
	public BillingAddress billingAddressUpdating(BillingAddressDto billingAddressDto) {
		BeanUtils.copyProperties(billingAddressDto, billingAddress);
		BillingAddress updateDetail = billingAddressRepository.findById(billingAddress.getId()).orElseThrow(()->new BillingAddressException("Address not Updated"));
			billingAddress.setId(billingAddressDto.getId());
			billingAddress.setAddress(billingAddressDto.getAddress());
			billingAddress.setCity(billingAddressDto.getCity());
			billingAddress.setState(billingAddressDto.getState());
			billingAddress.setZipcode(billingAddressDto.getZipcode());
			billingAddress.setCountry(billingAddressDto.getCountry());
			billingAddressRepository.save(billingAddress);
			 return updateDetail;
	}

	@Override
	public String billingAddressDeleting(BillingAddressDto billingAddressDto) {
		BeanUtils.copyProperties(billingAddressDto, billingAddress);
		BillingAddress deleteDetail = billingAddressRepository.findById(billingAddress.getId()).orElseThrow(()-> new BillingAddressException("Address not fetched"));
		//if (billingAddressDto.getCustomerId().equals(deleteDetail.getCustomerId())) {
		//	if (deleteDetail != null) {
				billingAddressRepository.delete(deleteDetail);
				return null;
			//}
		
		//}		
			//throw new BillingAddressException("Address not deleted");
	}



}
