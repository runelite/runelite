import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
@Implements("SpriteMask")
public class SpriteMask extends DualNode {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 574541221
   )
   @Export("width")
   public final int width;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -193097093
   )
   @Export("height")
   public final int height;
   @ObfuscatedName("q")
   @Export("xWidths")
   public final int[] xWidths;
   @ObfuscatedName("w")
   @Export("xStarts")
   public final int[] xStarts;

   SpriteMask(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.width = var1;
      this.height = var2;
      this.xWidths = var3;
      this.xStarts = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "781236044"
   )
   @Export("contains")
   public boolean contains(int var1, int var2) {
      if(var2 >= 0 && var2 < this.xStarts.length) {
         int var3 = this.xStarts[var2];
         if(var1 >= var3 && var1 <= var3 + this.xWidths[var2]) {
            return true;
         }
      }

      return false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1301156444"
   )
   static void method4390() {
      for(ObjectSound var0 = (ObjectSound)ObjectSound.objectSounds.last(); var0 != null; var0 = (ObjectSound)ObjectSound.objectSounds.previous()) {
         if(var0.stream1 != null) {
            TaskHandler.pcmStreamMixer.removeSubStream(var0.stream1);
            var0.stream1 = null;
         }

         if(var0.stream2 != null) {
            TaskHandler.pcmStreamMixer.removeSubStream(var0.stream2);
            var0.stream2 = null;
         }
      }

      ObjectSound.objectSounds.clear();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "529406067"
   )
   static void method4389() {
      ItemContainer.itemContainers = new NodeHashTable(32);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-113"
   )
   static int method4391(int var0) {
      Message var1 = (Message)Messages.Messages_hashTable.get((long)var0);
      return var1 == null?-1:(var1.nextDual == Messages.Messages_queue.sentinel?-1:((Message)var1.nextDual).count);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lir;IIB)Z",
      garbageValue = "1"
   )
   public static boolean method4392(AbstractIndexCache var0, int var1, int var2) {
      byte[] var3 = var0.takeRecord(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         DevicePcmPlayerProvider.decodeSprite(var3);
         return true;
      }
   }
}
