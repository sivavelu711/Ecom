package com.te.ecommerce.serviceimplementation;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.te.ecommerce.dto.ShippingAddressDto;
import com.te.ecommerce.entity.ShippingAddress;
import com.te.ecommerce.exception.ShippingAddressException;
import com.te.ecommerce.repository.ShippingAddressRepository;
import com.te.ecommerce.service.ShippingAddressService;

@Service
public class ShippingAddressServiceImplementation implements ShippingAddressService {
	@Autowired
	private ShippingAddressRepository shippingAddressRepository;
	@Autowired
	private ShippingAddress shippingAddress;

	@Override
	public boolean shippingAddressCreation(ShippingAddressDto shippingAddressDto) {
		BeanUtils.copyProperties(shippingAddressDto, shippingAddress);
		shippingAddress.setId(shippingAddressDto.getId());
		shippingAddress.setAddress(shippingAddressDto.getAddress());
		shippingAddress.setCity(shippingAddressDto.getCity());
		shippingAddress.setState(shippingAddressDto.getState());
		shippingAddress.setZipcode(shippingAddressDto.getZipcode());
		shippingAddress.setCountry(shippingAddressDto.getCountry());
		ShippingAddress save = shippingAddressRepository.save(shippingAddress);
		if (save != null) {
			return true;
		}
			throw new ShippingAddressException("Address not created");
	}

	@Override
	public ShippingAddress shippingAddressFetching(ShippingAddressDto shippingAddressDto) {
		BeanUtils.copyProperties(shippingAddressDto, shippingAddress);
		ShippingAddress getDetail = shippingAddressRepository.findById(shippingAddress.getId()).orElse(null);
		if (getDetail != null) {
			return getDetail;
		}
			throw new ShippingAddressException("Address not fetched");
	}

	@Override
	public ShippingAddress shippingAddressUpdating(ShippingAddressDto shippingAddressDto) {
		BeanUtils.copyProperties(shippingAddressDto, shippingAddress);
		ShippingAddress updateDetail = shippingAddressRepository.findById(shippingAddress.getId()).orElse(null);
		if (updateDetail != null) {
			shippingAddress.setId(shippingAddressDto.getId());
			shippingAddress.setAddress(shippingAddressDto.getAddress());
			shippingAddress.setCity(shippingAddressDto.getCity());
			shippingAddress.setState(shippingAddressDto.getState());
			shippingAddress.setZipcode(shippingAddressDto.getZipcode());
			shippingAddress.setCountry(shippingAddressDto.getCountry());
			shippingAddressRepository.save(shippingAddress);
			return shippingAddress;
		}
			throw new ShippingAddressException("Address not Updated");
	}

	@Override
	public String shippingAddressDeleting(ShippingAddressDto shippingAddressDto) {
		BeanUtils.copyProperties(shippingAddressDto, shippingAddress);
		ShippingAddress deleteDetail = shippingAddressRepository.findById(shippingAddress.getId()).orElse(null);
		if (deleteDetail != null) {
			shippingAddressRepository.delete(shippingAddress);
			return null;
		}
			throw new ShippingAddressException("Address not Updated");
	}
	

}
