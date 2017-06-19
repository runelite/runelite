import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hm")
public class class210 extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 1269059725
   )
   public final int field2607;
   @ObfuscatedName("e")
   public final int[] field2608;
   @ObfuscatedName("t")
   public final int[] field2609;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -750116039
   )
   public final int field2611;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "788461021"
   )
   public boolean method3811(int var1, int var2) {
      if(var2 >= 0 && var2 < this.field2609.length) {
         int var3 = this.field2609[var2];
         if(var1 >= var3 && var1 <= var3 + this.field2608[var2]) {
            return true;
         }
      }

      return false;
   }

   class210(int var1, int var2, int[] var3, int[] var4, int var5) {
      this.field2607 = var1;
      this.field2611 = var2;
      this.field2608 = var3;
      this.field2609 = var4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1845669632"
   )
   public static String method3816(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            char var6;
            if(var5 != 181 && var5 != 131) {
               var6 = Character.toTitleCase(var5);
            } else {
               var6 = var5;
            }

            var5 = var6;
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }
}
