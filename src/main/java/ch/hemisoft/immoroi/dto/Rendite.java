package ch.hemisoft.immoroi.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NonNull;

@Data
public class Rendite {
	@NonNull @NotNull
	Double value; 
}
