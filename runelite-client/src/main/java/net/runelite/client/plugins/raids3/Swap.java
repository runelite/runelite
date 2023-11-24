package net.runelite.client.plugins.raids3;

import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.Objects; // Import statement added for Objects.equals()

final class Swap {
  private final Predicate<String> optionPredicate;
  private final Predicate<String> targetPredicate;
  private final String swappedOption;
  private final Supplier<Boolean> enabled;
  private final boolean strict;

  public Swap(Predicate<String> optionPredicate, Predicate<String> targetPredicate, String swappedOption, Supplier<Boolean> enabled, boolean strict) {
    this.optionPredicate = optionPredicate;
    this.targetPredicate = targetPredicate;
    this.swappedOption = swappedOption;
    this.enabled = enabled;
    this.strict = strict;
  }

  public Predicate<String> getOptionPredicate() {
    return this.optionPredicate;
  }

  public Predicate<String> getTargetPredicate() {
    return this.targetPredicate;
  }

  public String getSwappedOption() {
    return this.swappedOption;
  }

  public Supplier<Boolean> getEnabled() {
    return this.enabled;
  }

  public boolean isStrict() {
    return this.strict;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    } else if (!(o instanceof Swap)) {
      return false;
    } else {
      Swap other = (Swap)o;
      if (this.isStrict() != other.isStrict()) {
        return false;
      } else {
        return Objects.equals(this.optionPredicate, other.optionPredicate) &&
            Objects.equals(this.targetPredicate, other.targetPredicate) &&
            Objects.equals(this.swappedOption, other.swappedOption) &&
            Objects.equals(this.enabled, other.enabled);
      }
    }
  }

  @Override
  public int hashCode() {
    final int PRIME = 59; // Corrected PRIME declaration
    int result = 1;
    result = result * PRIME + (this.isStrict() ? 79 : 97);
    result = result * PRIME + (optionPredicate == null ? 43 : optionPredicate.hashCode());
    result = result * PRIME + (targetPredicate == null ? 43 : targetPredicate.hashCode());
    result = result * PRIME + (swappedOption == null ? 43 : swappedOption.hashCode());
    result = result * PRIME + (enabled == null ? 43 : enabled.hashCode());
    return result;
  }

  @Override
  public String toString() {
    return "Swap(optionPredicate=" + this.getOptionPredicate() + ", targetPredicate=" + this.getTargetPredicate() + ", swappedOption=" + this.getSwappedOption() + ", enabled=" + this.getEnabled() + ", strict=" + this.isStrict() + ")";
  }
}
