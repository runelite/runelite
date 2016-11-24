import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aa")
final class class44 implements Comparator {
   // $FF: synthetic field
   final boolean val$preferOwnWorld;
   @ObfuscatedName("pj")
   static class116 field895;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "-1822278506"
   )
   int method827(class2 var1, class2 var2) {
      if(var2.field24 == var1.field24) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(Client.world == var1.field24) {
               return -1;
            }

            if(Client.world == var2.field24) {
               return 1;
            }
         }

         return var1.field24 < var2.field24?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method827((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   class44(boolean var1) {
      this.val$preferOwnWorld = var1;
   }
}
