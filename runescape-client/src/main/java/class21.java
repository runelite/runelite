import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class21 {
   @ObfuscatedName("ns")
   @ObfuscatedGetter(
      intValue = 1355432419
   )
   @Export("clanChatCount")
   static int clanChatCount;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lfu;",
      garbageValue = "-623423979"
   )
   public static Timer method151() {
      try {
         return new NanoTimer();
      } catch (Throwable var1) {
         return new MilliTimer();
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1127008318"
   )
   public static void method149() {
      Area.skeletonsIndex.reset();
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2135545011"
   )
   protected static final void method150() {
      class114.timer.vmethod3058();

      int var0;
      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field711[var0] = 0L;
      }

      for(var0 = 0; var0 < 32; ++var0) {
         GameEngine.field731[var0] = 0L;
      }

      class56.field697 = 0;
   }
}
