import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kp")
@Implements("Parameters")
public class Parameters {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public static final Parameters field3783;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public static final Parameters field3778;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public static final Parameters field3774;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public static final Parameters field3777;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public static final Parameters field3788;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public static final Parameters field3779;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public static final Parameters field3780;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public static final Parameters field3781;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public static final Parameters field3782;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public static final Parameters field3776;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public static final Parameters field3784;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public static final Parameters field3775;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public static final Parameters field3786;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public static final Parameters field3785;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public static final Parameters field3787;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public static final Parameters field3789;
   @ObfuscatedName("r")
   @Export("key")
   public final String key;

   static {
      field3783 = new Parameters("11", "11");
      field3778 = new Parameters("3", "3");
      field3774 = new Parameters("13", "13");
      field3777 = new Parameters("16", "16");
      field3788 = new Parameters("9", "9");
      field3779 = new Parameters("8", "8");
      field3780 = new Parameters("15", "15");
      field3781 = new Parameters("6", "6");
      field3782 = new Parameters("2", "2");
      field3776 = new Parameters("7", "7");
      field3784 = new Parameters("14", "14");
      field3775 = new Parameters("5", "5");
      field3786 = new Parameters("4", "4");
      field3785 = new Parameters("10", "10");
      field3787 = new Parameters("12", "12");
      field3789 = new Parameters("1", "1");
   }

   Parameters(String var1, String var2) {
      this.key = var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lib;III)Z",
      garbageValue = "-1051329266"
   )
   public static boolean method5029(IndexDataBase var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         CacheFile.decodeSprite(var3);
         return true;
      }
   }
}
