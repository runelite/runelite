import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("c")
final class class19 implements Comparator {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lu;Lu;I)I",
      garbageValue = "-626904644"
   )
   int method134(class14 var1, class14 var2) {
      return var1.field278 < var2.field278?-1:(var2.field278 == var1.field278?0:1);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method134((class14)var1, (class14)var2);
   }

   @ObfuscatedName("fw")
   @ObfuscatedSignature(
      signature = "(Ljj;IIII)V",
      garbageValue = "558716108"
   )
   static void method137(Sequence var0, int var1, int var2, int var3) {
      if(Client.field1124 < 50 && Client.field1123 != 0) {
         if(var0.field3596 != null && var1 < var0.field3596.length) {
            int var4 = var0.field3596[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field1089[Client.field1124] = var5;
               Client.field917[Client.field1124] = var6;
               Client.field1105[Client.field1124] = 0;
               Client.audioEffects[Client.field1124] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field1128[Client.field1124] = var7 + (var9 << 8) + (var8 << 16);
               ++Client.field1124;
            }
         }
      }
   }
}
