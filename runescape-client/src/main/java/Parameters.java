import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jr")
@Implements("Parameters")
public class Parameters {
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static final Parameters field3729;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static final Parameters field3717;
   @ObfuscatedName("m")
   @Export("osNameLC")
   public static String osNameLC;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static final Parameters field3730;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static final Parameters field3715;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static final Parameters field3722;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static final Parameters field3725;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static final Parameters field3716;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static final Parameters field3721;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   public static final Parameters field3714;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   public static final Parameters field3726;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static final Parameters field3718;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static final Parameters field3724;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static final Parameters field3728;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static final Parameters field3723;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static final Parameters field3720;
   @ObfuscatedName("c")
   @Export("key")
   public final String key;

   static {
      field3729 = new Parameters("8", "8");
      field3715 = new Parameters("1", "1");
      field3716 = new Parameters("11", "11");
      field3717 = new Parameters("3", "3");
      field3718 = new Parameters("2", "2");
      field3721 = new Parameters("4", "4");
      field3730 = new Parameters("10", "10");
      field3720 = new Parameters("14", "14");
      field3722 = new Parameters("5", "5");
      field3723 = new Parameters("9", "9");
      field3724 = new Parameters("6", "6");
      field3725 = new Parameters("12", "12");
      field3726 = new Parameters("15", "15");
      field3714 = new Parameters("7", "7");
      field3728 = new Parameters("13", "13");
   }

   Parameters(String var1, String var2) {
      this.key = var2;
   }
}
