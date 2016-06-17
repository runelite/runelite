import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
final class class21 implements Comparator {
   @ObfuscatedName("d")
   static boolean field581;
   @ObfuscatedName("bi")
   static class168 field583;
   @ObfuscatedName("b")
   public static class167 field584;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass214;Lclass214;I)I",
      garbageValue = "62058763"
   )
   int method556(class214 var1, class214 var2) {
      if(var1.field3147 == var2.field3147) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(var1.field3147 == client.field286) {
               return -1;
            }

            if(var2.field3147 == client.field286) {
               return 1;
            }
         }

         return var1.field3147 < var2.field3147?-1:1;
      }
   }

   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "(Lclass16;I)V",
      garbageValue = "107179814"
   )
   static final void method558(class16 var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.field224 == 0) {
         var1 = class150.field2230.method1951(var0.field232, var0.field225, var0.field223);
      }

      if(var0.field224 == 1) {
         var1 = class150.field2230.method1952(var0.field232, var0.field225, var0.field223);
      }

      if(var0.field224 == 2) {
         var1 = class150.field2230.method1953(var0.field232, var0.field225, var0.field223);
      }

      if(var0.field224 == 3) {
         var1 = class150.field2230.method1954(var0.field232, var0.field225, var0.field223);
      }

      if(var1 != 0) {
         int var5 = class150.field2230.method1955(var0.field232, var0.field225, var0.field223, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field227 = var2;
      var0.field228 = var3;
      var0.field240 = var4;
   }

   class21(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   public int compare(Object var1, Object var2) {
      return this.method556((class214)var1, (class214)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }
}
