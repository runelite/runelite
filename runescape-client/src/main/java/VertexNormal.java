import java.awt.Canvas;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("VertexNormal")
public class VertexNormal {
   @ObfuscatedName("qp")
   @ObfuscatedGetter(
      intValue = -391979363
   )
   protected static int field1689;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -942186429
   )
   int field1691;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1603272297
   )
   int field1692;
   @ObfuscatedName("qu")
   @Export("canvas")
   public static Canvas canvas;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 711425647
   )
   int field1697;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 581650019
   )
   int field1698;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(CIB)Ljava/lang/String;",
      garbageValue = "1"
   )
   public static String method2266(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }

   VertexNormal(VertexNormal var1) {
      this.field1698 = var1.field1698;
      this.field1691 = var1.field1691;
      this.field1697 = var1.field1697;
      this.field1692 = var1.field1692;
   }

   VertexNormal() {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lclass170;Ljava/lang/String;Ljava/lang/String;I)LModIcon;",
      garbageValue = "2022271927"
   )
   public static ModIcon method2267(class170 var0, String var1, String var2) {
      int var3 = var0.method3327(var1);
      int var4 = var0.method3325(var3, var2);
      ModIcon var5;
      if(!XClanMember.method604(var0, var3, var4)) {
         var5 = null;
      } else {
         var5 = class18.method182();
      }

      return var5;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "360835186"
   )
   public static boolean method2268(int var0, int var1) {
      return (var0 >> var1 + 1 & 1) != 0;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-104"
   )
   public static void method2269(boolean var0) {
      if(var0 != ItemComposition.isMembersWorld) {
         ItemComposition.field1172.reset();
         ItemComposition.itemModelCache.reset();
         ItemComposition.itemSpriteCache.reset();
         ItemComposition.isMembersWorld = var0;
      }

   }
}
