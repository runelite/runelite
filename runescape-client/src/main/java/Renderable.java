import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cz")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = -1416509973
   )
   @Export("modelHeight")
   public int modelHeight = 1000;
   @ObfuscatedName("nk")
   @ObfuscatedGetter(
      intValue = 169709473
   )
   static int field1535;
   @ObfuscatedName("pg")
   static class230 field1536;

   @ObfuscatedName("cu")
   void vmethod1908(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(null != var10) {
         this.modelHeight = var10.modelHeight;
         var10.vmethod1908(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "1672156994"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIIIIB)I",
      garbageValue = "0"
   )
   public static int method1918(int var0, int var1, int var2, int var3, int var4, int var5) {
      if((var5 & 1) == 1) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return var2 == 0?var1:(var2 == 1?7 - var0 - (var3 - 1):(var2 == 2?7 - var1 - (var4 - 1):var0));
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-804647988"
   )
   static void method1919(int var0, int var1) {
      long var2 = (long)(var1 + (var0 << 16));
      class181 var4 = (class181)class185.field2753.method2405(var2);
      if(var4 != null) {
         class185.field2752.method2370(var4);
      }
   }
}
