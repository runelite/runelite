import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bc")
@Implements("ItemLayer")
public final class ItemLayer {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1674801075
   )
   @Export("x")
   int x;
   @ObfuscatedName("bm")
   static class184 field1202;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -913500127
   )
   @Export("hash")
   int hash;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1776698613
   )
   @Export("y")
   int y;
   @ObfuscatedName("m")
   @Export("middle")
   Renderable middle;
   @ObfuscatedName("w")
   @Export("bottom")
   Renderable bottom;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1191984871
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1500088957
   )
   @Export("height")
   int height;
   @ObfuscatedName("r")
   @Export("top")
   Renderable top;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass182;I)V",
      garbageValue = "-1035685881"
   )
   public static void method1486(class182 var0) {
      class187.field2775 = var0;
      class187.field2773 = class187.field2775.method3339(16);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IZS)Ljava/lang/String;",
      garbageValue = "-19086"
   )
   public static String method1487(int var0, boolean var1) {
      return Integer.toString(var0);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IB)Ljava/lang/String;",
      garbageValue = "1"
   )
   static final String method1488(int var0) {
      return var0 < 100000?"<col=ffff00>" + var0 + "</col>":(var0 < 10000000?"<col=ffffff>" + var0 / 1000 + "K" + "</col>":"<col=00ff80>" + var0 / 1000000 + "M" + "</col>");
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;II)Z",
      garbageValue = "1389529036"
   )
   public static boolean method1489(class182 var0, int var1) {
      byte[] var2 = var0.method3334(var1);
      if(var2 == null) {
         return false;
      } else {
         class114.method2249(var2);
         return true;
      }
   }
}
