import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1939069461
   )
   @Export("x")
   int x;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2115226919
   )
   @Export("y")
   int y;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1656860739
   )
   @Export("z")
   int z;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -75310879
   )
   @Export("magnitude")
   int magnitude;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      intValue = -1866556791
   )
   static int field1435;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)LNPCComposition;",
      garbageValue = "-162579607"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.field3013.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field3002.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.method3706(new Buffer(var2));
         }

         var1.method3730();
         NPCComposition.field3013.put(var1, (long)var0);
         return var1;
      }
   }

   VertexNormal(VertexNormal var1) {
      this.x = var1.x;
      this.y = var1.y;
      this.z = var1.z;
      this.magnitude = var1.magnitude;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;II)Lclass142;",
      garbageValue = "-801286789"
   )
   static class142 method1691(class182 var0, int var1) {
      byte[] var2 = var0.method3311(var1);
      return null == var2?null:new class142(var2);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-37"
   )
   static final void method1692() {
      if(class1.field15 != null) {
         class1.field15.method2115();
         class1.field15 = null;
      }

      class149.method2797();
      Friend.region.method1895();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].method2300();
      }

      System.gc();
      GroundObject.method1595(2);
      Client.field445 = -1;
      Client.field552 = false;
      World.method669();
      class187.setGameState(10);
   }

   VertexNormal() {
   }
}
