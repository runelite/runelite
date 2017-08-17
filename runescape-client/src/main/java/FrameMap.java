import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("dm")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("indexScripts")
   static IndexData indexScripts;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1394968655
   )
   @Export("id")
   int id;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 373213147
   )
   @Export("count")
   int count;
   @ObfuscatedName("f")
   @Export("types")
   int[] types;
   @ObfuscatedName("p")
   @Export("list")
   int[][] list;

   FrameMap(int var1, byte[] var2) {
      this.id = var1;
      Buffer var3 = new Buffer(var2);
      this.count = var3.readUnsignedByte();
      this.types = new int[this.count];
      this.list = new int[this.count][];

      int var4;
      for(var4 = 0; var4 < this.count; ++var4) {
         this.types[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         this.list[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         for(int var5 = 0; var5 < this.list[var4].length; ++var5) {
            this.list[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("fn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-538449664"
   )
   static void method2700() {
      if(class46.renderOverview != null) {
         class46.renderOverview.method5229(class35.plane, (XGrandExchangeOffer.localPlayer.x >> 7) + class47.baseX, (XGrandExchangeOffer.localPlayer.y >> 7) + class44.baseY, false);
         class46.renderOverview.method5249();
      }

   }
}
