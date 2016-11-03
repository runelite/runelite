import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cj")
public class class93 {
   @ObfuscatedName("pt")
   @ObfuscatedGetter(
      intValue = -1961447323
   )
   static int field1619;
   @ObfuscatedName("h")
   @Export("worldServersDownload")
   static class18 worldServersDownload;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 1317698607
   )
   static int field1625;
   @ObfuscatedName("l")
   static boolean field1626;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)Lclass156;",
      garbageValue = "1"
   )
   public static class156 method2155(int var0) {
      class156[] var1 = class50.method1041();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class156 var3 = var1[var2];
         if(var0 == var3.field2318) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)LSpritePixels;",
      garbageValue = "2110631961"
   )
   static SpritePixels method2156() {
      SpritePixels var0 = new SpritePixels();
      var0.field1460 = class79.field1436;
      var0.field1464 = class79.field1437;
      var0.field1455 = class134.field2117[0];
      var0.field1459 = class79.field1438[0];
      var0.width = class79.field1439[0];
      var0.height = ChatLineBuffer.field693[0];
      int var1 = var0.height * var0.width;
      byte[] var2 = class110.field1936[0];
      var0.image = new int[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var0.image[var3] = class26.field634[var2[var3] & 255];
      }

      NPC.method745();
      return var0;
   }
}
