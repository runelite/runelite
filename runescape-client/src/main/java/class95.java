import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cd")
final class class95 implements Comparator {
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   class95(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lt;Lt;B)I",
      garbageValue = "15"
   )
   int method1710(class14 var1, class14 var2) {
      if(var2.field278 == var1.field278) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(Client.world == var1.field278) {
               return -1;
            }

            if(var2.field278 == Client.world) {
               return 1;
            }
         }

         return var1.field278 < var2.field278?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method1710((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
