package flumine.sgm.auxilium.exceptions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppError {
    private int statusCode;
    private String message;

    public Map<String, AppError> toJSON()
    {
        Map<String, AppError> error = new HashMap<>();
        error.put("error", this);
        return error;
    }
}
