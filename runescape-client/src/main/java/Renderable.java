import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cl")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("py")
   static class1 field1549;
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -244082623
   )
   @Export("modelHeight")
   public int modelHeight = 1000;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILclass182;IIIZI)V",
      garbageValue = "817782561"
   )
   public static void method1971(int var0, class182 var1, int var2, int var3, int var4, boolean var5) {
      class138.field1921 = 1;
      class138.field1924 = var1;
      class168.field2193 = var2;
      class138.field1922 = var3;
      class101.field1661 = var4;
      class138.field1923 = var5;
      class178.field2678 = var0;
   }

   @ObfuscatedName("ca")
   void vmethod1972(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(var10 != null) {
         this.modelHeight = var10.modelHeight;
         var10.vmethod1972(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "1"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }
}
