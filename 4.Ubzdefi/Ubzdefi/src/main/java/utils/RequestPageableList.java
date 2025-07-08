package utils;

import org.springframework.data.domain.Pageable;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RequestPageableList<T> {
	private Pageable pageable;
}