package com.pms.app.dtos;

import java.time.LocalDateTime;

public class CreatingBookingDto {

    public String receiver_name;
    public String receiverAddress;
    public Integer receiver_pin;
    public String receiver_phone_number;
    public Integer parcel_weight_grams;
    public String parcel_content_desc;

    public String parcel_delivery_type;

    public String parcel_packing_preference;

    public LocalDateTime parcel_pickup_time;

    public LocalDateTime parcel_drop_time;

    public Integer serviceCost;

    public CreatingBookingDto(){}

    public CreatingBookingDto(String receiver_name, String receiverAddress, Integer receiver_pin, String receiver_phone_number, Integer parcel_weight_grams, String parcel_content_desc, String parcel_delivery_type, String parcel_packing_preference, LocalDateTime parcel_pickup_time, LocalDateTime parcel_drop_time, Integer serviceCost) {
        super();
        this.receiver_name = receiver_name;
        this.receiverAddress = receiverAddress;
        this.receiver_pin = receiver_pin;
        this.receiver_phone_number = receiver_phone_number;
        this.parcel_weight_grams = parcel_weight_grams;
        this.parcel_content_desc = parcel_content_desc;
        this.parcel_delivery_type = parcel_delivery_type;
        this.parcel_packing_preference = parcel_packing_preference;
        this.parcel_pickup_time = parcel_pickup_time;
        this.parcel_drop_time = parcel_drop_time;
        this.serviceCost = serviceCost;
    }

    public String getReceiver_name() {
        return receiver_name;
    }

    public void setReceiver_name(String receiver_name) {
        this.receiver_name = receiver_name;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
    }

    public Integer getReceiver_pin() {
        return receiver_pin;
    }

    public void setReceiver_pin(Integer receiver_pin) {
        this.receiver_pin = receiver_pin;
    }

    public String getReceiver_phone_number() {
        return receiver_phone_number;
    }

    public void setReceiver_phone_number(String receiver_phone_number) {
        this.receiver_phone_number = receiver_phone_number;
    }

    public Integer getParcel_weight_grams() {
        return parcel_weight_grams;
    }

    public void setParcel_weight_grams(Integer parcel_weight_grams) {
        this.parcel_weight_grams = parcel_weight_grams;
    }

    public String getParcel_content_desc() {
        return parcel_content_desc;
    }

    public void setParcel_content_desc(String parcel_content_desc) {
        this.parcel_content_desc = parcel_content_desc;
    }

    public String getParcel_delivery_type() {
        return parcel_delivery_type;
    }

    public void setParcel_delivery_type(String parcel_delivery_type) {
        this.parcel_delivery_type = parcel_delivery_type;
    }

    public String getParcel_packing_preference() {
        return parcel_packing_preference;
    }

    public void setParcel_packing_preference(String parcel_packing_preference) {
        this.parcel_packing_preference = parcel_packing_preference;
    }

    public LocalDateTime getParcel_pickup_time() {
        return parcel_pickup_time;
    }

    public void setParcel_pickup_time(LocalDateTime parcel_pickup_time) {
        this.parcel_pickup_time = parcel_pickup_time;
    }

    public LocalDateTime getParcel_drop_time() {
        return parcel_drop_time;
    }

    public void setParcel_drop_time(LocalDateTime parcel_drop_time) {
        this.parcel_drop_time = parcel_drop_time;
    }

    public Integer getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Integer serviceCost) {
        this.serviceCost = serviceCost;
    }

    @Override
    public String toString() {
        return "CreatingBookingDto{" +
                "receiver_name='" + receiver_name + '\'' +
                ", receiverAddress='" + receiverAddress + '\'' +
                ", receiver_pin=" + receiver_pin +
                ", receiver_phone_number='" + receiver_phone_number + '\'' +
                ", parcel_weight_grams=" + parcel_weight_grams +
                ", parcel_content_desc='" + parcel_content_desc + '\'' +
                ", parcel_delivery_type='" + parcel_delivery_type + '\'' +
                ", parcel_packing_preference='" + parcel_packing_preference + '\'' +
                ", parcel_pickup_time=" + parcel_pickup_time +
                ", parcel_drop_time=" + parcel_drop_time +
                ", serviceCost=" + serviceCost +
                '}';
    }
}
