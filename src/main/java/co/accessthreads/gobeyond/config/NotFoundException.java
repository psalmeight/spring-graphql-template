package co.accessthreads.gobeyond.config;

class NotFoundException extends RuntimeException {

    NotFoundException(String message) {
        super(message);
    }

    NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}