package com.duna.dunaback.dtos.dump;

import com.duna.dunaback.enums.*;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class AdvertDumpUpdDto {
    @NotEmpty
    private Long id;
    @NotEmpty
    private Long ownerId;
    @NotEmpty
    private AdvertType advertType;
    @NotEmpty
    private TransactionTypeDump transactionType;
    @NotEmpty
    private ShiftType shiftType;
    @NotEmpty
    private String title;
    @NotEmpty
    private Double addressLat;
    @NotEmpty
    private Double addressLon;
    @NotEmpty
    private String wasteType;
    @NotEmpty
    private DangerClass dangerClass;
    @NotEmpty
    private DumpTransport dumpTransport;
    @NotEmpty
    private MeasureIn measureIn;
    @NotEmpty
    private Double amount;
    @NotEmpty
    private Double price;
    @NotEmpty
    private PaymentType paymentType;
    @NotEmpty
    private AdvertStatus advertStatus;

}
