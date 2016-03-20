import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("cr")
@Implements("Renderable")
public abstract class class84 extends class203 {
   @ObfuscatedName("cv")
   @ObfuscatedGetter(
      intValue = -564644063
   )
   @Export("modelHeight")
   public int field1448 = 1000;

   @ObfuscatedName("ac")
   void vmethod2324(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      class104 var10 = this.vmethod1919();
      if(null != var10) {
         this.field1448 = var10.field1448;
         var10.vmethod2324(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("a")
   public static long method1913(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 65 && var5 <= 90) {
            var1 += (long)(var5 + 1 - 65);
         } else if(var5 >= 97 && var5 <= 122) {
            var1 += (long)(var5 + 1 - 97);
         } else if(var5 >= 48 && var5 <= 57) {
            var1 += (long)(27 + var5 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(var1 % 37L == 0L && var1 != 0L) {
         var1 /= 37L;
      }

      return var1;
   }

   @ObfuscatedName("f")
   protected class104 vmethod1919() {
      return null;
   }
}
