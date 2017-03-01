import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cq")
public class class88 {
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      longValue = 5238487205594084075L
   )
   static long field1542;
   @ObfuscatedName("pv")
   static class230 field1545;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1055408241
   )
   public static int field1547;

   @ObfuscatedName("dg")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1003017572"
   )
   static final void method1968(int var0) {
      if(Projectile.method874(var0)) {
         Widget[] var1 = class231.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2328 = 0;
               var3.field2329 = 0;
            }
         }

      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-39"
   )
   static final int method1969(int var0, int var1) {
      int var2 = var1 * 57 + var0;
      var2 ^= var2 << 13;
      int var3 = 1376312589 + (var2 * var2 * 15731 + 789221) * var2 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-717504046"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      CombatInfo1.addChatMessage(var0, var1, var2, (String)null);
   }
}
