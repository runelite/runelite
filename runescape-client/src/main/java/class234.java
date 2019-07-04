import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("if")
public class class234 {
   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(Lbr;III)V",
      garbageValue = "-701527010"
   )
   static void method4534(Player var0, int var1, int var2) {
      if (var0.sequence == var1 && var1 != -1) {
         int var3 = WorldMapAreaData.getSequenceDefinition(var1).field783;
         if (var3 == 1) {
            var0.sequenceFrame = 0;
            var0.sequenceFrameCycle = 0;
            var0.sequenceDelay = var2;
            var0.field13 = 0;
         }

         if (var3 == 2) {
            var0.field13 = 0;
         }
      } else if (var1 == -1 || var0.sequence == -1 || WorldMapAreaData.getSequenceDefinition(var1).field779 >= WorldMapAreaData.getSequenceDefinition(var0.sequence).field779) {
         var0.sequence = var1;
         var0.sequenceFrame = 0;
         var0.sequenceFrameCycle = 0;
         var0.sequenceDelay = var2;
         var0.field13 = 0;
         var0.field25 = var0.pathLength;
      }

   }

   @ObfuscatedName("kt")
   @ObfuscatedSignature(
      signature = "(Lgr;IS)V",
      garbageValue = "-30972"
   )
   static void method4535(Buffer var0, int var1) {
      class50.method902(var0.array, var1);
      if (class168.randomDat != null) {
         try {
            class168.randomDat.seek(0L);
            class168.randomDat.write(var0.array, var1, 24);
         } catch (Exception var3) {
         }
      }

   }
}
