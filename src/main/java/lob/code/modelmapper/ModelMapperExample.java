package lob.code.modelmapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

import java.util.ArrayList;
import java.util.Collections;

public class ModelMapperExample {

	ModelMapper modelMapper = new ModelMapper();

	public void dtoToEntity() {
		SampleDto dto = SampleDto.builder()
				.name("dto")
				.email("...@hello")
				.age(20L)
				.infos(new ArrayList<>(Collections.singleton("aaa")))
				.build();

		SampleEntity entity = modelMapper.map(dto, SampleEntity.class);
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


		PropertyMap<SampleEntity, SampleDto> sampleMap = new PropertyMap<>() {
			@Override
			protected void configure() {
				map().setInfos(source.getSampleInfo());
			}
		};

		// 이름이 다른 필드 매핑을 위해 PropertyMap 선언 후 추가
		modelMapper.addMappings(sampleMap);

//		modelMapper.createTypeMap(SampleEntity.class, SampleDto.class)
//				.addMapping(SampleEntity::getSampleInfo, SampleDto::setInfos);

		SampleDto dto = modelMapper.map(entity, SampleDto.class);
		System.out.println(dto);
	}

	public static void main(String[] args) {
		ModelMapperExample example = new ModelMapperExample();
		example.dtoToEntity();
		example.EntityToDto();
	}
}
