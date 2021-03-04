package lob.code.mapstruct;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@ToString
public class SampleDto {

	private final String name;
	private final String email;
	private final List<String> infos;
	private final Long age;

}
