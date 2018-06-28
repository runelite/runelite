import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("ChatLineBuffer")
public class ChatLineBuffer {
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "[Lbn;"
   )
   @Export("lines")
   MessageNode[] lines;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1420819617
   )
   @Export("length")
   int length;

   ChatLineBuffer() {
      this.lines = new MessageNode[100];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;I)Lbn;",
      garbageValue = "-458883414"
   )
   @Export("addMessage")
   MessageNode addMessage(int var1, String var2, String var3, String var4) {
      MessageNode var5 = this.lines[99];

      for(int var6 = this.length; var6 > 0; --var6) {
         if(var6 != 100) {
            this.lines[var6] = this.lines[var6 - 1];
         }
      }

      if(var5 == null) {
         var5 = new MessageNode(var1, var2, var4, var3);
      } else {
         var5.unlink();
         var5.unlinkDual();
         var5.setMessage(var1, var2, var4, var3);
      }

      this.lines[0] = var5;
      if(this.length < 100) {
         ++this.length;
      }

      return var5;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)Lbn;",
      garbageValue = "-44"
   )
   @Export("getMessage")
   MessageNode getMessage(int var1) {
      return var1 >= 0 && var1 < this.length?this.lines[var1]:null;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1556967243"
   )
   @Export("size")
   int size() {
      return this.length;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Liv;IIB)Llc;",
      garbageValue = "-114"
   )
   @Export("getSpriteAsSpritePixels")
   public static SpritePixels getSpriteAsSpritePixels(IndexDataBase var0, int var1, int var2) {
      if(!class306.method5702(var0, var1, var2)) {
         return null;
      } else {
         SpritePixels var4 = new SpritePixels();
         var4.maxWidth = class319.indexedSpriteWidth;
         var4.maxHeight = class275.indexedSpriteHeight;
         var4.offsetX = class319.indexedSpriteOffsetXs[0];
         var4.offsetY = class319.indexedSpriteOffsetYs[0];
         var4.width = class192.indexSpriteWidths[0];
         var4.height = class319.indexedSpriteHeights[0];
         int var5 = var4.height * var4.width;
         byte[] var6 = class294.spritePixels[0];
         var4.pixels = new int[var5];

         for(int var7 = 0; var7 < var5; ++var7) {
            var4.pixels[var7] = class319.indexedSpritePalette[var6[var7] & 255];
         }

         class319.indexedSpriteOffsetXs = null;
         class319.indexedSpriteOffsetYs = null;
         class192.indexSpriteWidths = null;
         class319.indexedSpriteHeights = null;
         class319.indexedSpritePalette = null;
         class294.spritePixels = null;
         return var4;
      }
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static final void method2018() {
      if(Client.field688 > 0) {
         Varcs.method1959();
      } else {
         Client.field840.method5256();
         Resampler.setGameState(40);
         VertexNormal.field1697 = Client.field739.getSocket();
         Client.field739.method2024();
      }
   }
}
