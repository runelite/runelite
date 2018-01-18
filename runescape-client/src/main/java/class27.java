import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public enum class27 implements Enumerated {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Law;"
   )
   field383(1, (byte)0),
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Law;"
   )
   field382(0, (byte)1),
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Law;"
   )
   field385(3, (byte)2),
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Law;"
   )
   field381(2, (byte)3);

   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 342064723
   )
   final int field387;
   @ObfuscatedName("d")
   final byte field386;

   class27(int var3, byte var4) {
      this.field387 = var3;
      this.field386 = var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2130441585"
   )
   public int rsOrdinal() {
      return this.field386;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)[Law;",
      garbageValue = "-13"
   )
   static class27[] method202() {
      return new class27[]{field381, field385, field383, field382};
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "512195040"
   )
   static final int method201(int var0, int var1) {
      int var2 = var0 + var1 * 57;
      var2 ^= var2 << 13;
      int var3 = (var2 * var2 * 15731 + 789221) * var2 + 1376312589 & Integer.MAX_VALUE;
      return var3 >> 19 & 255;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lcw;I)V",
      garbageValue = "-857329317"
   )
   public static final void method209(TaskDataProvider var0) {
      class160.soundTaskDataProvider = var0;
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(Lbf;IIS)V",
      garbageValue = "18613"
   )
   static void method207(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = class45.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1159 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1185 = 0;
         }

         if(var3 == 2) {
            var0.field1185 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class45.getAnimation(var1).forcedPriority >= class45.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1159 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1185 = 0;
         var0.field1208 = var0.queueSize;
      }

   }
}
