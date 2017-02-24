import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gg")
public class class187 extends CacheableNode {
   @ObfuscatedName("q")
   static class182 field2777;
   @ObfuscatedName("h")
   public static NodeCache field2779 = new NodeCache(64);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 2104511563
   )
   public int field2780 = 0;
   @ObfuscatedName("pb")
   static class116 field2781;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1227522659
   )
   public static int field2782;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(LBuffer;S)V",
      garbageValue = "-9679"
   )
   void method3441(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method3443(var1, var2);
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "9"
   )
   void method3443(Buffer var1, int var2) {
      if(var2 == 5) {
         this.field2780 = var1.readUnsignedShort();
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)LObjectComposition;",
      garbageValue = "1975716269"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.field2895.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.field2893.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.field2900 = var0;
         if(null != var2) {
            var1.method3640(new Buffer(var2));
         }

         var1.method3654();
         if(var1.isSolid) {
            var1.field2943 = 0;
            var1.field2911 = false;
         }

         ObjectComposition.field2895.put(var1, (long)var0);
         return var1;
      }
   }
}
