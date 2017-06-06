import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
final class class3 implements class0 {
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = -1361801341
   )
   public static int field27;
   @ObfuscatedName("n")
   static ModIcon field28;

   @ObfuscatedName("jj")
   @ObfuscatedSignature(
      signature = "([BII)V",
      garbageValue = "-584110724"
   )
   static void method2(byte[] var0, int var1) {
      if(Client.field966 == null) {
         Client.field966 = new byte[24];
      }

      class183.method3454(var0, var1, Client.field966, 0, 24);
   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIII)V",
      garbageValue = "1081389178"
   )
   @Export("addMenuEntry")
   public static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      class203.method3666(var0, var1, var2, var3, var4, var5, false);
   }
}
