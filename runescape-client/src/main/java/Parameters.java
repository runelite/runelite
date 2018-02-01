import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kq")
@Implements("Parameters")
public class Parameters {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   static final Parameters field3801;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   static final Parameters field3795;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   static final Parameters field3806;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   static final Parameters field3808;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   static final Parameters field3799;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   static final Parameters field3800;
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   static final Parameters field3802;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   static final Parameters field3810;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   static final Parameters field3803;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   static final Parameters field3804;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   static final Parameters field3805;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   static final Parameters field3798;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   public static final Parameters field3807;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   public static final Parameters field3796;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   static final Parameters field3809;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lkq;"
   )
   static final Parameters field3797;
   @ObfuscatedName("d")
   @Export("key")
   public final String key;

   static {
      field3801 = new Parameters("13", "13");
      field3795 = new Parameters("16", "16");
      field3806 = new Parameters("5", "5");
      field3808 = new Parameters("6", "6");
      field3799 = new Parameters("7", "7");
      field3800 = new Parameters("3", "3");
      field3802 = new Parameters("8", "8");
      field3810 = new Parameters("2", "2");
      field3803 = new Parameters("4", "4");
      field3804 = new Parameters("12", "12");
      field3805 = new Parameters("1", "1");
      field3798 = new Parameters("15", "15");
      field3807 = new Parameters("11", "11");
      field3796 = new Parameters("10", "10");
      field3809 = new Parameters("14", "14");
      field3797 = new Parameters("9", "9");
   }

   Parameters(String var1, String var2) {
      this.key = var2;
   }

   @ObfuscatedName("iy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIZB)V",
      garbageValue = "127"
   )
   static final void method5333(String var0, String var1, int var2, int var3, int var4, int var5, boolean var6) {
      if(!Client.isMenuOpen) {
         if(Client.menuOptionCount < 500) {
            Client.menuOptions[Client.menuOptionCount] = var0;
            Client.menuTargets[Client.menuOptionCount] = var1;
            Client.menuTypes[Client.menuOptionCount] = var2;
            Client.menuIdentifiers[Client.menuOptionCount] = var3;
            Client.menuActionParams0[Client.menuOptionCount] = var4;
            Client.menuActionParams1[Client.menuOptionCount] = var5;
            Client.menuBooleanArray[Client.menuOptionCount] = var6;
            ++Client.menuOptionCount;
         }

      }
   }
}
