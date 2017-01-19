import java.util.Comparator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
final class class44 implements Comparator {
   // $FF: synthetic field
   final boolean val$preferOwnWorld;
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      intValue = 948918801
   )
   static int field886;
   @ObfuscatedName("b")
   public static byte[][] field888;

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;B)I",
      garbageValue = "1"
   )
   int method779(class2 var1, class2 var2) {
      if(var1.field32 == var2.field32) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(var1.field32 == Client.world) {
               return -1;
            }

            if(var2.field32 == Client.world) {
               return 1;
            }
         }

         return var1.field32 < var2.field32?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method779((class2)var1, (class2)var2);
   }

   class44(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-312178525"
   )
   static final int method783(int var0, int var1, int var2) {
      if(var2 > 179) {
         var1 /= 2;
      }

      if(var2 > 192) {
         var1 /= 2;
      }

      if(var2 > 217) {
         var1 /= 2;
      }

      if(var2 > 243) {
         var1 /= 2;
      }

      int var3 = (var1 / 32 << 7) + (var0 / 4 << 10) + var2 / 2;
      return var3;
   }
}
