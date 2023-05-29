package com.znmiller96.pantryapi.model.dto;

import com.znmiller96.pantryapi.util.MeasurementUnit;

public class MeasurementDto {

    private float value;

    private MeasurementUnit unit;

    private MeasurementDto(Builder builder) {
        this.value = builder.value;
        this.unit = builder.unit;
    }

    public float getValue() {
        return value;
    }

    public MeasurementUnit getUnit() {
        return unit;
    }

    public static class Builder {

        private float value;
        private MeasurementUnit unit;

        public Builder withValue(float value) {
            this.value = value;
            return this;
        }

        public Builder withUnit(MeasurementUnit unit) {
            this.unit = unit;
            return this;
        }

        public MeasurementDto build() {
            return new MeasurementDto(this);
        }

    }
}
