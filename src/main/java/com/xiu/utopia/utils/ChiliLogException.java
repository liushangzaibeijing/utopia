package com.xiu.utopia.utils;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * The standard Exception class used throughout our application.
 * <p>
 * <code>ChiliLogException</code> supports loading of exception messages using <code>StringsProperties</code>. We make
 * an assumption that the supplied <code>errorCode</code> is the same as the string id that is used to load the string.
 * </p>
 *
 * @author vibul
 *
 */
public class ChiliLogException extends Exception {

    private static final long serialVersionUID = 1L;
    private String errorCode = null;

    /**
     * Error code associated with this exception
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * Basic constructor
     */
    public ChiliLogException() {
        super();
    }

    /**
     * Constructor with error code
     *
     * @param errorCode
     *            Error code to use to load message
     * @param args
     *            Error message place holder substitutes
     */
    public ChiliLogException(String errorCode, Object... args) {
        super(getErrorMessage(errorCode, args));
        this.errorCode = errorCode;
    }

    /**
     * Wrapper constructor
     *
     * @param ex
     *            Exception that triggered this exception and is to be wrapped
     * @param errorCode
     *            Error code to use to load message
     * @param args
     *            Error message place holder substitutes
     */
    public ChiliLogException(Throwable ex, String errorCode, Object... args) {
        super(getErrorMessage(errorCode, args), ex);
        this.errorCode = errorCode;
    }

    /**
     * Gets the message using the error code as the string id.
     *
     * @param errorCode
     *            Error code to use to load message
     * @param args
     *            Error message place holder substitutes
     *
     * @return Message for this exception
     */
    private static String getErrorMessage(String errorCode, Object[] args) {
//        String s = StringsProperties.getInstance().getString(errorCode, errorCode);
//        return String.format(s, args);
        return errorCode;
    }

    /**
     * @return The stack trace as a string
     */
    public String getStackTraceAsString() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(baos, true, "UTF-8");
            this.printStackTrace(ps);
            return baos.toString("UTF-8");
        } catch (Exception ex) {
            return this.toString();
        }
    }
}
