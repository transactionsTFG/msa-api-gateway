package business.travel;


import java.time.LocalDate;

import javax.ws.rs.QueryParam;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "TravelInfo", description = "Parámetros de búsqueda de viajes")
public class TravelInfo {
     @Parameter(description = "País de origen (ISO-3166 alfa-2 o nombre)", example = "ES")
    @QueryParam("countryOrigin")
    private String countryOrigin;

    @Parameter(description = "País de destino (ISO-3166 alfa-2 o nombre)", example = "US")
    @QueryParam("countryDestination")
    private String countryDestination;

    @Parameter(description = "Ciudad de origen", example = "Madrid")
    @QueryParam("cityOrigin")
    private String cityOrigin;

    @Parameter(description = "Ciudad de destino", example = "New York")
    @QueryParam("cityDestination")
    private String cityDestination;

    @Parameter(
        description = "Fecha de salida (formato ISO: yyyy-MM-dd)",
        example = "2025-10-01",
        schema = @Schema(type = "string", format = "date")
    )
    @QueryParam("dateOrigin")
    private LocalDate dateOrigin;

    @Parameter(description = "Nombre del hotel", example = "Gran Vía Palace")
    @QueryParam("hotelName")
    private String hotelName;
}
