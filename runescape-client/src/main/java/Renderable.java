import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("nv")
   @ObfuscatedGetter(
      intValue = 1154585581
   )
   static int field1544;
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -416491117
   )
   @Export("modelHeight")
   public int modelHeight = 1000;

   @ObfuscatedName("ca")
   void vmethod1823(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(null != var10) {
         this.modelHeight = var10.modelHeight;
         var10.vmethod1823(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)LModel;",
      garbageValue = "2062912069"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-270558043"
   )
   public static void method1825(int var0) {
      class138.field1933 = 1;
      ChatLineBuffer.field967 = null;
      GroundObject.field1298 = -1;
      class207.field3097 = -1;
      class138.field1921 = 0;
      class138.field1927 = false;
      class138.field1926 = var0;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1959266328"
   )
   @Export("calculateHeight")
   public static int calculateHeight(int var0, int var1) {
      int var2 = var0 >>> 31;
      return (var0 + var2) / var1 - var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)[LModIcon;",
      garbageValue = "-1521435463"
   )
   public static ModIcon[] method1831(class182 var0, String var1, String var2) {
      int var3 = var0.method3197(var1);
      int var4 = var0.method3198(var3, var2);
      return class13.method148(var0, var3, var4);
   }
}
