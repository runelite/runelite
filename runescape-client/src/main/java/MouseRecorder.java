import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bf")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "Lig;"
   )
   static Widget field797;
   @ObfuscatedName("t")
   @Export("isRunning")
   boolean isRunning;
   @ObfuscatedName("q")
   @Export("lock")
   Object lock;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -2071533289
   )
   @Export("index")
   int index;
   @ObfuscatedName("a")
   @Export("xs")
   int[] xs;
   @ObfuscatedName("l")
   @Export("ys")
   int[] ys;

   MouseRecorder() {
      this.isRunning = true;
      this.lock = new Object();
      this.index = 0;
      this.xs = new int[500];
      this.ys = new int[500];
   }

   public void run() {
      for(; this.isRunning; class93.method1982(50L)) {
         Object var1 = this.lock;
         synchronized(this.lock) {
            if(this.index < 500) {
               this.xs[this.index] = MouseInput.mouseLastX;
               this.ys[this.index] = MouseInput.mouseLastY;
               ++this.index;
            }
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1978816203"
   )
   static final int method1159(int var0, int var1) {
      int var2 = var1 * 57 + var0;
      var2 ^= var2 << 13;
      int var3 = var2 * (var2 * var2 * 15731 + 789221) + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("jq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1769106309"
   )
   static final void method1163() {
      for(int var0 = 0; var0 < class93.playerIndexesCount; ++var0) {
         Player var1 = Client.cachedPlayers[class93.playerIndices[var0]];
         var1.method1203();
      }

      WorldMapType3.method227();
      if(KeyFocusListener.clanMemberManager != null) {
         KeyFocusListener.clanMemberManager.method5453();
      }

   }
}
