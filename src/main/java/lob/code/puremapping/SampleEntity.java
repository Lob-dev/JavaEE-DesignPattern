package lob.code.puremapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SampleEntity {

	private Long id;
	private String name;
	private String email;
	private Long age;
	private List<String> sampleInfo;
	private String value;
}
