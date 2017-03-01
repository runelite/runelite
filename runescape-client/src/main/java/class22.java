import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
public class class22 extends class119 {
   @ObfuscatedName("a")
   static int[][] field230;
   @ObfuscatedName("i")
   @Export("worldServersDownload")
   static class26 worldServersDownload;
   @ObfuscatedName("f")
   public static Font field235;
   @ObfuscatedName("cc")
   static class110 field236;
   @ObfuscatedName("gd")
   static Widget field237;
   @ObfuscatedName("kf")
   @Export("chatMessages")
   static ChatMessages chatMessages;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IIILCollisionData;I)Z",
      garbageValue = "1832344439"
   )
   public boolean vmethod2386(int var1, int var2, int var3, CollisionData var4) {
      return super.field1858 == var2 && var3 == super.field1857;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1852500721"
   )
   static int method223(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = ChatLineBuffer.method993(class32.field726[--class32.field735]);
      } else {
         var3 = var2?class32.field731:class108.field1738;
      }

      ChatLineBuffer.method996(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class32.field726[--class32.field735];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = WidgetNode.localPlayer.composition.method3244();
            return 1;
         } else {
            return 2;
         }
      } else {
         class32.field735 -= 2;
         int var4 = class32.field726[class32.field735];
         int var5 = class32.field726[class32.field735 + 1];
         var3.item = var4;
         var3.stackSize = var5;
         ItemComposition var6 = ChatLineBuffer.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2255 = var6.offsetX2d;
         var3.field2256 = var6.offsetY2d;
         var3.field2260 = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2229 = 0;
         } else if(var0 == 1212 | var6.isStackable == 1) {
            var3.field2229 = 1;
         } else {
            var3.field2229 = 2;
         }

         if(var3.field2318 > 0) {
            var3.field2260 = var3.field2260 * 32 / var3.field2318;
         } else if(var3.originalWidth > 0) {
            var3.field2260 = var3.field2260 * 32 / var3.originalWidth;
         }

         return 1;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I[BLclass116;I)V",
      garbageValue = "-162654300"
   )
   static void method225(int var0, byte[] var1, class116 var2) {
      class180 var3 = new class180();
      var3.field2695 = 0;
      var3.hash = (long)var0;
      var3.field2690 = var1;
      var3.field2691 = var2;
      Deque var4 = class183.field2731;
      synchronized(class183.field2731) {
         class183.field2731.method2511(var3);
      }

      Object var9 = class183.field2727;
      synchronized(class183.field2727) {
         if(class183.field2729 == 0) {
            class114.field1793.method2067(new class183(), 5);
         }

         class183.field2729 = 600;
      }
   }
}
