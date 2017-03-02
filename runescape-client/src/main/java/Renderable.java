import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("dm")
   @ObfuscatedGetter(
      intValue = 2144215107
   )
   static int field1528;
   @ObfuscatedName("cl")
   @ObfuscatedGetter(
      intValue = -1517495915
   )
   @Export("modelHeight")
   public int modelHeight = 1000;
   @ObfuscatedName("di")
   @ObfuscatedGetter(
      intValue = 2082772023
   )
   static int field1530;
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = 1207808013
   )
   static int field1531;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SB)V",
      garbageValue = "0"
   )
   public static void method1939(String[] var0, short[] var1) {
      class15.method189(var0, var1, 0, var0.length - 1);
   }

   @ObfuscatedName("cl")
   void vmethod1940(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(var10 != null) {
         this.modelHeight = var10.modelHeight;
         var10.vmethod1940(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-8"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }
}
