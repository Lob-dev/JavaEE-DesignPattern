package lob.code.modelmapper;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SampleEntity {

	private Long id;
	private String name;
	private String email;
	private Long age;
	private List<String> sampleInfo;
	private String value;
}
