import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public class class172 extends class204 {
   @ObfuscatedName("dh")
   @ObfuscatedGetter(
      intValue = 241426479
   )
   @Export("baseX")
   static int field2734;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2007373375
   )
   public int field2735;
   @ObfuscatedName("x")
   public byte field2737;
   @ObfuscatedName("n")
   static class78 field2738;
   @ObfuscatedName("f")
   public class168 field2741;
   @ObfuscatedName("cm")
   static class143 field2742;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)Lclass39;",
      garbageValue = "422821408"
   )
   @Export("getNpcDefinition")
   public static class39 method3424(int var0) {
      class39 var1 = (class39)class39.field895.method3797((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class39.field893.method3286(9, var0);
         var1 = new class39();
         var1.field899 = var0;
         if(null != var2) {
            var1.method808(new class119(var2));
         }

         var1.method817();
         class39.field895.method3788(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)Lclass173;",
      garbageValue = "539233104"
   )
   public static class173 method3425(int var0, int var1) {
      class173 var2 = class153.method3177(var0);
      return var1 == -1?var2:(var2 != null && var2.field2767 != null && var1 < var2.field2767.length?var2.field2767[var1]:null);
   }
}
