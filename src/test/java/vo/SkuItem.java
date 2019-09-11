package vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SkuItem {


    @ApiModelProperty(value = "SKU Code", required = true, example = "1904586874")
    private String skuCode;

    @ApiModelProperty(value = "数量", required = true, example = "3")
    int num;

    @ApiModelProperty(hidden = true)
    BigDecimal singlePrice;
}