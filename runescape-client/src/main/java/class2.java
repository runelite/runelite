import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
final class class2 implements class0 {
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-9"
   )
   public static void method0() {
      Overlay.overlays.reset();
   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(Ljd;IIIS)V",
      garbageValue = "11270"
   )
   static void method1(Sequence var0, int var1, int var2, int var3) {
      if(Client.field1144 < 50 && Client.field1143 != 0) {
         if(var0.field3599 != null && var1 < var0.field3599.length) {
            int var4 = var0.field3599[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field1175[Client.field1144] = var5;
               Client.field1146[Client.field1144] = var6;
               Client.field1147[Client.field1144] = 0;
               Client.audioEffects[Client.field1144] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field1148[Client.field1144] = var7 + (var9 << 8) + (var8 << 16);
               ++Client.field1144;
            }
         }
      }
   }
}
