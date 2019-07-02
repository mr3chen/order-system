package com.order.system.productService.common.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.order.system.common.model.response.Response;
import com.order.system.productService.common.model.Participant;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author zh
 */
@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler", "fieldHandler"}, ignoreUnknown = true)
public class ReservationResponse implements Response {

    private static final long serialVersionUID = 841299264931794001L;

    @ApiModelProperty(value = "参与者确认资源", required = true)
    private Participant participantLink;

    public ReservationResponse(Participant participant) {
        this.participantLink = participant;
}

}
