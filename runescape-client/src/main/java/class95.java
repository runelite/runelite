import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cm")
final class class95 implements Comparator {
   @ObfuscatedName("az")
   static class231 field1489;
   @ObfuscatedName("ew")
   @ObfuscatedGetter(
      intValue = -1085983839
   )
   static int field1491;
   @ObfuscatedName("j")
   public static int[] field1493;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass14;Lclass14;I)I",
      garbageValue = "1503853847"
   )
   int method1743(class14 var1, class14 var2) {
      if(var1.field292 == var2.field292) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(Client.world == var1.field292) {
               return -1;
            }

            if(Client.world == var2.field292) {
               return 1;
            }
         }

         return var1.field292 < var2.field292?-1:1;
      }
   }

   class95(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method1743((class14)var1, (class14)var2);
   }
}
