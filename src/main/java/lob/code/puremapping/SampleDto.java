package lob.code.puremapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
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

	public SampleEntity toEntity() {
		return SampleEntity.builder()
				.name("lob")
				.email("...@test")
				.age(20L)
				.value("value")
				.sampleInfo(new ArrayList<>(Collections.singleton("aaa")))
				.build();
	}

	public static SampleDto toDto(SampleEntity entity) {
		return SampleDto.builder()
				.name(entity.getName())
				.email(entity.getEmail())
				.infos(entity.getSampleInfo())
				.age(entity.getAge())
				.build();
	}
}
