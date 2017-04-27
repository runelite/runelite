import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ge")
public class class183 extends CacheableNode {
   @ObfuscatedName("d")
   public IndexData field2704;
   @ObfuscatedName("n")
   public byte field2705;
   @ObfuscatedName("b")
   static int[] field2706;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 617226309
   )
   public int field2707;

   @ObfuscatedName("el")
   @ObfuscatedSignature(
      signature = "(LWidget;II)Ljava/lang/String;",
      garbageValue = "1107031213"
   )
   static String method3290(Widget var0, int var1) {
      int var3 = class103.method1988(var0);
      boolean var2 = (var3 >> var1 + 1 & 1) != 0;
      return !var2 && var0.field2307 == null?null:(var0.actions != null && var0.actions.length > var1 && var0.actions[var1] != null && var0.actions[var1].trim().length() != 0?var0.actions[var1]:null);
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1870017968"
   )
   static void method3291(int var0, int var1) {
      if(Client.field501 != 0 && var0 != -1) {
         Script.method911(KitDefinition.indexTrack2, var0, 0, Client.field501, false);
         Client.field525 = true;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Lclass198;",
      garbageValue = "1453588842"
   )
   public static class198 method3292(int var0) {
      class198 var1 = (class198)class198.field2871.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class198.field2872.getConfigData(11, var0);
         var1 = new class198();
         if(var2 != null) {
            var1.method3585(new Buffer(var2));
         }

         var1.method3584();
         class198.field2871.put(var1, (long)var0);
         return var1;
      }
   }
}
