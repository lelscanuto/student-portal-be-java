package com.school.portal.common.utils;

import java.util.Collection;
import java.util.Objects;
import java.util.function.Supplier;
import org.apache.commons.lang3.StringUtils;

/** Utility class for assertion operations. */
public final class AssertUtil {

  private AssertUtil() {}

  /**
   * Creates a ThrowableFunction that checks if two objects are equal.
   *
   * @param expected The expected value.
   * @param actual The actual value.
   * @param <T> The type of objects to compare.
   * @return The ThrowableFunction instance.
   */
  public static <T> ThrowableFunction eq(T expected, T actual) {
    return new ThrowableFunction(areEqual(expected, actual));
  }

  /**
   * Creates a ThrowableFunction that checks if two objects are not equal.
   *
   * @param expected The expected value.
   * @param actual The actual value.
   * @param <T> The type of objects to compare.
   * @return The ThrowableFunction instance.
   */
  public static <T> ThrowableFunction notEq(T expected, T actual) {
    return eq(expected, actual).negate();
  }

  /**
   * Creates a ThrowableFunction that checks if a condition is true.
   *
   * @param condition The condition to check.
   * @return The ThrowableFunction instance.
   */
  public static ThrowableFunction isTrue(boolean condition) {
    return new ThrowableFunction(condition);
  }

  /**
   * Creates a ThrowableFunction that checks if a condition is false.
   *
   * @param condition The condition to check.
   * @return The ThrowableFunction instance.
   */
  public static ThrowableFunction isFalse(boolean condition) {
    return isTrue(condition).negate();
  }

  /**
   * Creates a ThrowableFunction that checks if a string is not blank.
   *
   * @param val The string value.
   * @return The ThrowableFunction instance.
   */
  public static ThrowableFunction notBlank(String val) {
    return new ThrowableFunction(StringUtils.isNoneBlank(val));
  }

  /**
   * Creates a ThrowableFunction that checks if an object is not null.
   *
   * @param val The object.
   * @return The ThrowableFunction instance.
   */
  public static ThrowableFunction notNull(Object val) {
    return new ThrowableFunction(Objects.nonNull(val));
  }

  /**
   * Creates a ThrowableFunction that checks if a collection is not empty.
   *
   * @param collection The collection.
   * @return The ThrowableFunction instance.
   */
  public static ThrowableFunction notEmpty(Collection<?> collection) {
    return new ThrowableFunction(Objects.nonNull(collection) && !collection.isEmpty());
  }

  /**
   * Combines multiple ThrowableFunction instances using logical OR.
   *
   * @param throwableFunctions The ThrowableFunction instances to combine.
   * @return The combined ThrowableFunction instance.
   */
  public static ThrowableFunction or(ThrowableFunction... throwableFunctions) {
    boolean condition = false;

    for (ThrowableFunction throwableFunction : throwableFunctions) {
      if (throwableFunction.getCondition()) {
        condition = true;
        break;
      }
    }

    return new ThrowableFunction(condition);
  }

  /**
   * Combines multiple ThrowableFunction instances using logical AND.
   *
   * @param throwableFunctions The ThrowableFunction instances to combine.
   * @return The combined ThrowableFunction instance.
   */
  public static ThrowableFunction and(ThrowableFunction... throwableFunctions) {
    boolean condition = true;

    for (ThrowableFunction throwableFunction : throwableFunctions) {
      if (!throwableFunction.getCondition()) {
        condition = false;
        break;
      }
    }

    return new ThrowableFunction(condition);
  }

  private static <T> boolean areEqual(T expected, T actual) {
    if (expected == null) {
      return actual == null;
    } else if (expected instanceof Number ex && actual instanceof Number ac) {
      return ex.doubleValue() == ac.doubleValue();
    } else {
      return expected.equals(actual);
    }
  }

  /**
   * Encapsulates a boolean condition and provides a method to throw an exception if the condition
   * is false.
   */
  public static class ThrowableFunction {
    private boolean condition;

    private ThrowableFunction(boolean condition) {
      this.condition = condition;
    }

    /**
     * Throws an exception if the condition is false.
     *
     * @param exceptionSupplier The supplier for the exception to be thrown.
     */
    public void elseThrow(Supplier<? extends RuntimeException> exceptionSupplier) {
      if (!condition) {
        throw exceptionSupplier.get();
      }
    }

    private ThrowableFunction negate() {
      this.condition = !condition;
      return this;
    }

    private boolean getCondition() {
      return condition;
    }
  }
}
