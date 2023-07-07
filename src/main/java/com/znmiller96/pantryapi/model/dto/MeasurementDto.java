package com.znmiller96.pantryapi.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.znmiller96.pantryapi.util.MeasurementUnit;

@JsonDeserialize(builder = MeasurementDto.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MeasurementDto {

    private final float value;

    private final MeasurementUnit unit;

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

    @JsonPOJOBuilder(buildMethodName = "build", withPrefix = "with")
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
