package lob.code.puremapping;

import lob.code.mapstruct.MapStructExample;

import java.util.ArrayList;
import java.util.Collections;

public class PureMapping {

	public void dtoToEntity() {
	   SampleDto dto = SampleDto.builder()
				.name("dto")
				.email("...@hello")
				.age(20L)
				.infos(new ArrayList<>(Collections.singleton("aaa")))
				.build();

		SampleEntity entity = dto.toEntity();
		System.out.println(entity);
	}

	public void EntityToDto() {
		SampleEntity entity = SampleEntity.builder()
				.id(1L)
				.name("lob")
				.email("...@test")
				.age(20L)
				.value("value")
				.sampleInfo(new ArrayList<>(Collections.singleton("aaa")))
				.build();

		SampleDto dto = SampleDto.toDto(entity);
		System.out.println(dto);
	}

	public static void main(String[] args) {
		PureMapping example = new PureMapping();
		example.dtoToEntity();
		example.EntityToDto();
	}

}
