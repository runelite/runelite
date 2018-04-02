import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bs")
@Implements("WidgetNode")
public class WidgetNode extends Node {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1342265387
   )
   @Export("id")
   int id;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -30726049
   )
   @Export("owner")
   int owner;
   @ObfuscatedName("o")
   boolean field775;

   WidgetNode() {
      this.field775 = false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Ljx;",
      garbageValue = "408927282"
   )
   @Export("getUnderlayDefinition")
   public static FloorUnderlayDefinition getUnderlayDefinition(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.underlays.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class55.underlay_ref.getConfigData(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2), var0);
         }

         var1.post();
         FloorUnderlayDefinition.underlays.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljm;Ljm;S)V",
      garbageValue = "18623"
   )
   public static void method1098(IndexDataBase var0, IndexDataBase var1) {
      Spotanim.SpotAnimationDefinition_indexCache = var0;
      Frames.SpotAnimationDefinition_modelIndexCache = var1;
   }
}
