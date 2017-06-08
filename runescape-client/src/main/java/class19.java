import java.awt.Image;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
final class class19 implements Comparator {
   @ObfuscatedName("au")
   static Image field330;

   public int compare(Object var1, Object var2) {
      return this.method164((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;B)I",
      garbageValue = "0"
   )
   int method164(class14 var1, class14 var2) {
      return var1.field287 < var2.field287?-1:(var1.field287 == var2.field287?0:1);
   }

   @ObfuscatedName("fx")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-718051777"
   )
   static final void method165() {
      int var0 = class96.field1499;
      int[] var1 = class96.field1501;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.cachedPlayers[var1[var2]];
         if(var3 != null) {
            class73.method1089(var3, 1);
         }
      }

   }
}
