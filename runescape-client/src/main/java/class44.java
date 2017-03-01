import java.util.Comparator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
final class class44 implements Comparator {
   @ObfuscatedName("ev")
   static SpritePixels[] field902;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass184;IIIBZI)V",
      garbageValue = "1186760429"
   )
   static void method884(class184 var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)(var2 + (var1 << 16));
      class181 var8 = (class181)class185.field2749.method2437(var6);
      if(null == var8) {
         var8 = (class181)class185.field2766.method2437(var6);
         if(null == var8) {
            var8 = (class181)class185.field2754.method2437(var6);
            if(var8 != null) {
               if(var5) {
                  var8.method2513();
                  class185.field2749.method2438(var8, var6);
                  --class185.field2755;
                  ++class185.field2750;
               }

            } else {
               if(!var5) {
                  var8 = (class181)class185.field2759.method2437(var6);
                  if(null != var8) {
                     return;
                  }
               }

               var8 = new class181();
               var8.field2704 = var0;
               var8.field2702 = var3;
               var8.field2707 = var4;
               if(var5) {
                  class185.field2749.method2438(var8, var6);
                  ++class185.field2750;
               } else {
                  class185.field2756.method2391(var8);
                  class185.field2754.method2438(var8, var6);
                  ++class185.field2755;
               }

            }
         }
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method889((class2)var1, (class2)var2);
   }

   class44(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass2;Lclass2;I)I",
      garbageValue = "2042496943"
   )
   int method889(class2 var1, class2 var2) {
      if(var2.field16 == var1.field16) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(Client.world == var1.field16) {
               return -1;
            }

            if(Client.world == var2.field16) {
               return 1;
            }
         }

         return var1.field16 < var2.field16?-1:1;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIZI)Ljava/lang/String;",
      garbageValue = "-1552839426"
   )
   static String method891(int var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         if(var2 && var0 >= 0) {
            int var3 = 2;

            for(int var4 = var0 / var1; var4 != 0; ++var3) {
               var4 /= var1;
            }

            char[] var5 = new char[var3];
            var5[0] = 43;

            for(int var6 = var3 - 1; var6 > 0; --var6) {
               int var7 = var0;
               var0 /= var1;
               int var8 = var7 - var0 * var1;
               if(var8 >= 10) {
                  var5[var6] = (char)(87 + var8);
               } else {
                  var5[var6] = (char)(48 + var8);
               }
            }

            return new String(var5);
         } else {
            return Integer.toString(var0, var1);
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass182;IIIZI)V",
      garbageValue = "569151673"
   )
   public static void method892(class182 var0, int var1, int var2, int var3, boolean var4) {
      class138.field1921 = 1;
      class138.field1924 = var0;
      class168.field2193 = var1;
      class138.field1922 = var2;
      class101.field1661 = var3;
      class138.field1923 = var4;
      class178.field2678 = 10000;
   }
}
