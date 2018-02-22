import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("Item")
public final class Item extends Renderable {
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = 2002299293
   )
   static int field1367;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   public static IndexDataBase field1362;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ldo;"
   )
   static class109 field1366;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 233042525
   )
   static int field1365;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1862304201
   )
   @Export("id")
   int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -688193375
   )
   @Export("quantity")
   int quantity;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lee;",
      garbageValue = "582025400"
   )
   protected final Model getModel() {
      return ContextMenuRow.getItemDefinition(this.id).getModel(this.quantity);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IS)Ljp;",
      garbageValue = "-5552"
   )
   @Export("getUnderlayDefinition")
   public static FloorUnderlayDefinition getUnderlayDefinition(int var0) {
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lie;Lie;I)V",
      garbageValue = "398074452"
   )
   public static void method1919(IndexDataBase var0, IndexDataBase var1) {
      Spotanim.SpotAnimationDefinition_indexCache = var0;
      Spotanim.SpotAnimationDefinition_modelIndexCache = var1;
   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "53926507"
   )
   @Export("prependIndices")
   static final String[] prependIndices(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }
}
