import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
@Implements("Parameters")
public class Parameters {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   public static final Parameters field3768;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   public static final Parameters field3763;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   public static final Parameters field3771;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   public static final Parameters field3761;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   public static final Parameters field3765;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   public static final Parameters field3758;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   public static final Parameters field3764;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   public static final Parameters field3760;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   public static final Parameters field3766;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   public static final Parameters field3767;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   public static final Parameters field3759;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   public static final Parameters field3769;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   public static final Parameters field3770;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   public static final Parameters field3762;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   public static final Parameters field3772;
   @ObfuscatedName("t")
   @Export("key")
   public final String key;

   static {
      field3768 = new Parameters("11", "11");
      field3763 = new Parameters("2", "2");
      field3771 = new Parameters("15", "15");
      field3761 = new Parameters("6", "6");
      field3765 = new Parameters("5", "5");
      field3758 = new Parameters("12", "12");
      field3764 = new Parameters("1", "1");
      field3760 = new Parameters("8", "8");
      field3766 = new Parameters("4", "4");
      field3767 = new Parameters("9", "9");
      field3759 = new Parameters("7", "7");
      field3769 = new Parameters("3", "3");
      field3770 = new Parameters("13", "13");
      field3762 = new Parameters("14", "14");
      field3772 = new Parameters("10", "10");
   }

   Parameters(String var1, String var2) {
      this.key = var2;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1574994827"
   )
   static final int method5097(int var0, int var1) {
      if(var0 == -1) {
         return 12345678;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }
}
