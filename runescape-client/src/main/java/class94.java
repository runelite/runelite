import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ci")
final class class94 implements Comparator {
   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "[Lkd;"
   )
   @Export("mapfunctions")
   static SpritePixels[] mapfunctions;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   class94(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lv;Lv;S)I",
      garbageValue = "-10146"
   )
   int method1779(class14 var1, class14 var2) {
      if(var2.field298 == var1.field298) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(Client.world == var1.field298) {
               return -1;
            }

            if(var2.field298 == Client.world) {
               return 1;
            }
         }

         return var1.field298 < var2.field298?-1:1;
      }
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method1779((class14)var1, (class14)var2);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IS)Liz;",
      garbageValue = "5953"
   )
   public static FloorUnderlayDefinition method1790(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.underlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = FloorUnderlayDefinition.underlay_ref.getConfigData(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         FloorUnderlayDefinition.underlays.put(var1, (long)var0);
         return var1;
      }
   }
}
