import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("d")
final class class3 implements Comparator {
   @ObfuscatedName("r")
   static String field33;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = 1758713651
   )
   @Export("baseY")
   static int baseY;
   @ObfuscatedName("gl")
   static Widget field38;
   @ObfuscatedName("bt")
   static class184 field39;

   public int compare(Object var1, Object var2) {
      return this.method38((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "557724343"
   )
   int method38(class2 var1, class2 var2) {
      return var1.field25.totalQuantity < var2.field25.totalQuantity?-1:(var2.field25.totalQuantity == var1.field25.totalQuantity?0:1);
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZS)I",
      garbageValue = "5467"
   )
   static int method48(World var0, World var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.playerCount;
         int var5 = var1.playerCount;
         if(!var3) {
            if(var4 == -1) {
               var4 = 2001;
            }

            if(var5 == -1) {
               var5 = 2001;
            }
         }

         return var4 - var5;
      } else {
         return var2 == 2?var0.location - var1.location:(var2 == 3?(var0.activity.equals("-")?(var1.activity.equals("-")?0:(var3?-1:1)):(var1.activity.equals("-")?(var3?1:-1):var0.activity.compareTo(var1.activity))):(var2 == 4?(var0.method638()?(var1.method638()?0:1):(var1.method638()?-1:0)):(var2 == 5?(var0.method629()?(var1.method629()?0:1):(var1.method629()?-1:0)):(var2 == 6?(var0.method632()?(var1.method632()?0:1):(var1.method632()?-1:0)):(var2 == 7?(var0.method673()?(var1.method673()?0:1):(var1.method673()?-1:0)):var0.id - var1.id)))));
      }
   }
}
