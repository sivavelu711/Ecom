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
	
	@Override
	public boolean billingAddressCreation(BillingAddressDto billingAddressDto) {
		
		BeanUtils.copyProperties(billingAddressDto, billingAddress);
		billingAddress.setId(billingAddressDto.getId());
		billingAddress.setAddress(billingAddressDto.getAddress());
		billingAddress.setCity(billingAddressDto.getCity());
		billingAddress.setState(billingAddressDto.getState());
		billingAddress.setZipcode(billingAddressDto.getZipcode());
		billingAddress.setCountry(billingAddressDto.getCountry());
		BillingAddress save = billingAddressRepository.save(billingAddress);
		if (save != null) {
			return true;
		} 
			throw new BillingAddressException("Address not created");
	}

	@Override
	public BillingAddress billingAddressFetching(BillingAddressDto billingAddressDto) {
		BeanUtils.copyProperties(billingAddressDto, billingAddress);
		BillingAddress getDetail = billingAddressRepository.findById(billingAddress.getId()).orElse(null);
		if (getDetail != null) {
			return getDetail;
		} 
			throw new BillingAddressException("Address not fetched");
	}

	@Override
	public BillingAddress billingAddressUpdating(BillingAddressDto billingAddressDto) {
		BeanUtils.copyProperties(billingAddressDto, billingAddress);
		BillingAddress updateDetail = billingAddressRepository.findById(billingAddress.getId()).orElse(null);
		if (updateDetail != null) {
			billingAddress.setId(billingAddressDto.getId());
			billingAddress.setAddress(billingAddressDto.getAddress());
			billingAddress.setCity(billingAddressDto.getCity());
			billingAddress.setState(billingAddressDto.getState());
			billingAddress.setZipcode(billingAddressDto.getZipcode());
			billingAddress.setCountry(billingAddressDto.getCountry());
			billingAddressRepository.save(billingAddress);
			return billingAddress;
		}
			throw new BillingAddressException("Address not Updated");
		
	}

	@Override
	public String billingAddressDeleting(BillingAddressDto billingAddressDto) {
		BeanUtils.copyProperties(billingAddressDto, billingAddress);
		BillingAddress deleteDetail = billingAddressRepository.findById(billingAddress.getId()).orElse(null);
		if (deleteDetail != null) {
			billingAddressRepository.delete(deleteDetail);
			return null;
		}
			throw new BillingAddressException("Address not deleted");
	}



}
