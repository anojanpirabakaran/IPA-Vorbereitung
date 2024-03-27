package abschluss.ano.ipa.ipavorbereitung.config.error;

public class BadRequestException {
    public static class BadRequestExceptions extends RuntimeException {

        public BadRequestExceptions(String message) {
            super(message);
        }

        public BadRequestExceptions(String message, Throwable cause) {
            super(message, cause);
        }

        public BadRequestExceptions(Throwable cause) {
            super(cause);
        }

        protected BadRequestExceptions(String message, Throwable cause, boolean enableSuppression,
                                       boolean writableStackTrace) {
            super(message, cause, enableSuppression, writableStackTrace);
        }
    }
}
