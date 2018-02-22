import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kh")
@Implements("Parameters")
public class Parameters {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   public static final Parameters field3824;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   public static final Parameters field3826;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   public static final Parameters field3823;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   public static final Parameters field3829;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   public static final Parameters field3827;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   public static final Parameters field3828;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   public static final Parameters field3836;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   public static final Parameters field3830;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   public static final Parameters field3831;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   public static final Parameters field3832;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   public static final Parameters field3835;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   public static final Parameters field3834;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   public static final Parameters field3825;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   public static final Parameters field3833;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   public static final Parameters field3837;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lkh;"
   )
   public static final Parameters field3838;
   @ObfuscatedName("f")
   @Export("key")
   public final String key;

   static {
      field3824 = new Parameters("1", "1");
      field3826 = new Parameters("14", "14");
      field3823 = new Parameters("2", "2");
      field3829 = new Parameters("4", "4");
      field3827 = new Parameters("8", "8");
      field3828 = new Parameters("3", "3");
      field3836 = new Parameters("9", "9");
      field3830 = new Parameters("6", "6");
      field3831 = new Parameters("7", "7");
      field3832 = new Parameters("13", "13");
      field3835 = new Parameters("11", "11");
      field3834 = new Parameters("5", "5");
      field3825 = new Parameters("12", "12");
      field3833 = new Parameters("16", "16");
      field3837 = new Parameters("15", "15");
      field3838 = new Parameters("10", "10");
   }

   Parameters(String var1, String var2) {
      this.key = var2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIIB)I",
      garbageValue = "82"
   )
   static final int method5597(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var0 & 65280) * var3 + (var1 & 65280) * var2 & 16711680) + ((var1 & 16711935) * var2 + var3 * (var0 & 16711935) & -16711936) >> 8;
   }
}
