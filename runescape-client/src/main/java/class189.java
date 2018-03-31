import java.io.IOException;
import java.util.HashMap;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gb")
public class class189 {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "[[Lib;"
   )
   @Export("widgets")
   public static Widget[][] widgets;

   static {
      new HashMap();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "-20"
   )
   @Export("sendGameMessage")
   static void sendGameMessage(int var0, String var1, String var2) {
      class251.addChatMessage(var0, var1, var2, (String)null);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1611084027"
   )
   @Export("sendConInfo")
   public static void sendConInfo(boolean var0) {
      if(class264.NetCache_socket != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class264.NetCache_socket.vmethod3320(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class264.NetCache_socket.vmethod3325();
            } catch (Exception var3) {
               ;
            }

            ++class264.field3422;
            class264.NetCache_socket = null;
         }

      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[Llq;",
      garbageValue = "-1053248559"
   )
   static IndexedSprite[] method3485() {
      IndexedSprite[] var0 = new IndexedSprite[WorldComparator.indexedSpriteCount];

      for(int var1 = 0; var1 < WorldComparator.indexedSpriteCount; ++var1) {
         IndexedSprite var2 = var0[var1] = new IndexedSprite();
         var2.originalWidth = class332.indexedSpriteWidth;
         var2.originalHeight = class81.indexedSpriteHeight;
         var2.offsetX = GameCanvas.indexedSpriteOffsetXs[var1];
         var2.offsetY = class332.indexedSpriteOffsetYs[var1];
         var2.width = class25.indexSpriteWidths[var1];
         var2.height = class332.indexedSpriteHeights[var1];
         var2.palette = class332.indexedSpritePalette;
         var2.pixels = class332.spritePixels[var1];
      }

      FileSystem.method4544();
      return var0;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-455950827"
   )
   static final int method3482(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }
}
