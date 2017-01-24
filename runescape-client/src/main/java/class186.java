import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gc")
public class class186 extends CacheableNode {
   @ObfuscatedName("c")
   static NodeCache field2769 = new NodeCache(64);
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 661240157
   )
   public int field2770 = 0;
   @ObfuscatedName("bd")
   static ModIcon field2771;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 262639995
   )
   static int field2773;
   @ObfuscatedName("s")
   public static class182 field2774;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "424836957"
   )
   void method3322(Buffer var1, int var2) {
      if(var2 == 2) {
         this.field2770 = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "46"
   )
   void method3326(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3322(var1, var2);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(IB)LKitDefinition;",
      garbageValue = "-68"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field2830.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.field2824.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(null != var2) {
            var1.method3403(new Buffer(var2));
         }

         KitDefinition.field2830.put(var1, (long)var0);
         return var1;
      }
   }
}
