package id.co.anis.crudrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created By Anis
 * created on 3/29/2020 - 5:06 PM on crudrestapi
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourcesNotFoundException extends Exception {
    private static final long serialVersionUID = 1L;

    public ResourcesNotFoundException(String message) {
        super(message);
    }
}
