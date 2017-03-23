import java.util.Comparator;
import java.util.Date;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
final class class44 implements Comparator {
   // $FF: synthetic field
   final boolean val$preferOwnWorld;
   @ObfuscatedName("kh")
   @ObfuscatedGetter(
      intValue = 1145880725
   )
   static int field912;
   @ObfuscatedName("db")
   static int[] field915;

   public int compare(Object var1, Object var2) {
      return this.method839((class2)var1, (class2)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   class44(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "1690366699"
   )
   int method839(class2 var1, class2 var2) {
      if(var2.field22 == var1.field22) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(Client.world == var1.field22) {
               return -1;
            }

            if(Client.world == var2.field22) {
               return 1;
            }
         }

         return var1.field22 < var2.field22?-1:1;
      }
   }

   @ObfuscatedName("f")
   public static String method840(long var0) {
      class162.field2165.setTime(new Date(var0));
      int var2 = class162.field2165.get(7);
      int var3 = class162.field2165.get(5);
      int var4 = class162.field2165.get(2);
      int var5 = class162.field2165.get(1);
      int var6 = class162.field2165.get(11);
      int var7 = class162.field2165.get(12);
      int var8 = class162.field2165.get(13);
      return class162.field2164[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class162.field2168[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }
}
