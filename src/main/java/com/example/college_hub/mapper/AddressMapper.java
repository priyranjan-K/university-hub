package com.example.college_hub.mapper;

import com.example.college_hub.api.model.AddressDto;
import com.example.college_hub.model.Address;
import com.example.college_hub.model.AddressType;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressDto toDto(Address entity) {
        if (entity == null) return null;
        AddressDto dto = new AddressDto();
        dto.setAddressId(entity.getAddressId());
        dto.setHouseNumber(entity.getHouseNumber());
        dto.setAddressLine1(entity.getAddressLine1());
        dto.setAddressLine2(entity.getAddressLine2());
        dto.setStreet(entity.getStreet());
        dto.setCity(entity.getCity());
        dto.setState(entity.getState());
        dto.setZipCode(entity.getZipCode());
        dto.setCountry(entity.getCountry());
        if (entity.getAddressType() != null) {
            dto.setAddressType(AddressDto.AddressTypeEnum.fromValue(entity.getAddressType().name()));
        }
        return dto;
    }

    public Address toEntity(AddressDto dto) {
        if (dto == null) return null;

        Address address = new Address();
        address.setAddressId(dto.getAddressId());
        address.setHouseNumber(dto.getHouseNumber());
        address.setAddressLine1(dto.getAddressLine1());
        address.setAddressLine2(dto.getAddressLine2());
        address.setStreet(dto.getStreet());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setZipCode(dto.getZipCode());
        address.setCountry(dto.getCountry());
        if (dto.getAddressType() != null) {
            address.setAddressType(AddressType.valueOf(dto.getAddressType().getValue()));
        }
        
        return address;
    }
}
