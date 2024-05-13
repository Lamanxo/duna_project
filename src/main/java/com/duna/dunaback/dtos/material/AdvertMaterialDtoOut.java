package com.duna.dunaback.dtos.material;

import com.duna.dunaback.entities_mini.MaterialFractions;
import com.duna.dunaback.enums.*;
import lombok.Data;

import java.util.List;

@Data
public class AdvertMaterialDtoOut {
    private Long id;
    private Long ownerId;
    private AdvertType advertType;
    private TransactionTypeMaterial transactionType;
    private ShiftType shiftType;
    private String title;
    private DeliveryType deliveryType;
    private Double addressLat;
    private Double addressLon;
    private String materialType;
    private List<MaterialFractions> fractions;
    private DumpTransport dumpTransport;
    private MeasureIn measureIn;
    private Double amount;
    private PaymentType paymentType;
    private Double price;
    private AdvertStatus advertStatus;
}
