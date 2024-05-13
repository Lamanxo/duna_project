package com.duna.dunaback.dtos.material;

import com.duna.dunaback.entities_mini.MaterialFractions;
import com.duna.dunaback.enums.*;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class AdvertMaterialDtoIn {

    @NotBlank
    private AdvertType advertType = AdvertType.NON_MATERIAL;
    @NotBlank
    private TransactionTypeMaterial transactionType;
    @NotBlank
    private ShiftType shiftType;
    @NotBlank
    private String title;
    @NotBlank
    private DeliveryType deliveryType;
    @NotBlank
    private Double addressLat;
    @NotBlank
    private Double addressLon;
    @NotBlank
    private String materialType;
    @NotNull
    private List<MaterialFractions> fractions;
    @NotBlank
    private DumpTransport dumpTransport;
    @NotBlank
    private MeasureIn measureIn;
    @NotBlank
    private Double amount;
    @NotBlank
    private PaymentType paymentType;
    @NotBlank
    private Double price;
    @NotBlank
    private AdvertStatus advertStatus;
}
