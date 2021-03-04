package lob.code.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.Collections;

public class MapStructExample {

	private DataMapper dataMapper = DataMapper.INSTANCE;

	public void dtoToEntity() {
		SampleDto dto = SampleDto.builder()
				.name("dto")
				.email("...@hello")
				.age(20L)
				.infos(new ArrayList<String>(Collections.singleton("aaa")))
				.build();

		SampleEntity entity = dataMapper.toEntity(dto);
		System.out.println(entity);
	}

	public void EntityToDto() {
		SampleEntity entity = SampleEntity.builder()
			.id(1L)
			.name("lob")
			.email("...@test")
			.age(20L)
			.value("value")
			.sampleInfo(new ArrayList<String>(Collections.singleton("aaa")))
			.build();

		SampleDto dto = dataMapper.toDto(entity);
		System.out.println(dto);
	}


	public static void main(String[] args) {
		MapStructExample example = new MapStructExample();
		example.dtoToEntity();
		example.EntityToDto();
	}

	@Mapper
	public interface DataMapper {
		DataMapper INSTANCE = Mappers.getMapper(DataMapper.class);

		@Mapping(source = "entity.sampleInfo", target = "infos")
		SampleDto toDto(SampleEntity entity);

		@Mapping(source = "dto.infos", target = "sampleInfo")
		SampleEntity toEntity(SampleDto dto);
	}

}
