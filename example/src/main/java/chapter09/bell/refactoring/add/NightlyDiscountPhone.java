package chapter09.bell.refactoring.add;

import java.time.Duration;

public class NightlyDiscountPhone extends Phone {
  private static final int LATE_NIGHT_HOUR = 22;

  private Money nightlyAmount;
  private Money regularAmount;
  private Duration seconds;

  public NightlyDiscountPhone(
      final Money nightlyAmount, final Money regularAmount, final Duration seconds, final double taxRate) {
    super(taxRate);
    this.nightlyAmount = nightlyAmount;
    this.regularAmount = regularAmount;
    this.seconds = seconds;
  }

  @Override
  protected Money calculateCallFee(Call call) {
    if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
      return nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    } else {
      return regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
  }
}
