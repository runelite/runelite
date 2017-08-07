import java.io.File;
import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cv")
final class class96 implements Comparator {
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   class96(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ls;Ls;I)I",
      garbageValue = "691020310"
   )
   int method1797(class14 var1, class14 var2) {
      if(var2.field293 == var1.field293) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(Client.world == var1.field293) {
               return -1;
            }

            if(var2.field293 == Client.world) {
               return 1;
            }
         }

         return var1.field293 < var2.field293?-1:1;
      }
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   public int compare(Object var1, Object var2) {
      return this.method1797((class14)var1, (class14)var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;I)V",
      garbageValue = "-973920339"
   )
   static void method1807(File var0) {
      class158.field2238 = var0;
      if(!class158.field2238.exists()) {
         throw new RuntimeException("");
      } else {
         class158.field2242 = true;
      }
   }
}
