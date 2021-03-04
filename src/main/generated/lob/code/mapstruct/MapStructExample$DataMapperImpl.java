package lob.code.mapstruct;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import lob.code.mapstruct.MapStructExample.DataMapper;
import lob.code.mapstruct.SampleDto.SampleDtoBuilder;
import lob.code.mapstruct.SampleEntity.SampleEntityBuilder;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-04T08:23:04+0900",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.2 (Oracle Corporation)"
)
public class MapStructExample$DataMapperImpl implements DataMapper {

    @Override
    public SampleDto toDto(SampleEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SampleDtoBuilder sampleDto = SampleDto.builder();

        List<String> list = entity.getSampleInfo();
        if ( list != null ) {
            sampleDto.infos( new ArrayList<String>( list ) );
        }
        sampleDto.name( entity.getName() );
        sampleDto.email( entity.getEmail() );
        sampleDto.age( entity.getAge() );

        return sampleDto.build();
    }

    @Override
    public SampleEntity toEntity(SampleDto dto) {
        if ( dto == null ) {
            return null;
        }

        SampleEntityBuilder sampleEntity = SampleEntity.builder();

        List<String> list = dto.getInfos();
        if ( list != null ) {
            sampleEntity.sampleInfo( new ArrayList<String>( list ) );
        }
        sampleEntity.name( dto.getName() );
        sampleEntity.email( dto.getEmail() );
        sampleEntity.age( dto.getAge() );

        return sampleEntity.build();
    }
}
