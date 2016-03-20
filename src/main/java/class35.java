import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("am")
@Implements("MessageNode")
public class class35 extends class203 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -686426605
   )
   int field788;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1795494341
   )
   int field789 = class25.method631();
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 214591365
   )
   @Export("type")
   int field790;
   @ObfuscatedName("s")
   String field791;
   @ObfuscatedName("y")
   @Export("sender")
   String field792;
   @ObfuscatedName("e")
   @Export("value")
   String field793;

   @ObfuscatedName("s")
   public static void method735(int var0, class166 var1, int var2, int var3, int var4, boolean var5) {
      class182.field2947 = 1;
      class182.field2946 = var1;
      class182.field2945 = var2;
      class182.field2948 = var3;
      class134.field2077 = var4;
      class182.field2949 = var5;
      class45.field1043 = var0;
   }

   class35(int var1, String var2, String var3, String var4) {
      this.field788 = client.field303;
      this.field790 = var1;
      this.field791 = var2;
      this.field792 = var3;
      this.field793 = var4;
   }

   @ObfuscatedName("a")
   void method737(int var1, String var2, String var3, String var4) {
      int var5 = (class11.field166 += 987845255) * 1130287927 - 1;
      this.field789 = var5;
      this.field788 = client.field303;
      this.field790 = var1;
      this.field791 = var2;
      this.field792 = var3;
      this.field793 = var4;
   }

   @ObfuscatedName("a")
   public static String method738(byte[] var0) {
      int var2 = var0.length;
      StringBuilder var3 = new StringBuilder();

      for(int var4 = 0; var4 < 0 + var2; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class160.field2627[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class160.field2627[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class160.field2627[(var6 & 15) << 2 | var7 >>> 6]).append(class160.field2627[var7 & 63]);
            } else {
               var3.append(class160.field2627[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class160.field2627[(var5 & 3) << 4]).append("==");
         }
      }

      String var1 = var3.toString();
      return var1;
   }

   @ObfuscatedName("ak")
   @ObfuscatedSignature(
      signature = "(Lclass37;I)V",
      garbageValue = "1841436941"
   )
   static final void method740(class37 var0) {
      if(0 != var0.field864) {
         if(var0.field837 != -1) {
            Object var1 = null;
            if(var0.field837 < '耀') {
               var1 = client.field358[var0.field837];
            } else if(var0.field837 >= '耀') {
               var1 = client.field415[var0.field837 - '耀'];
            }

            if(var1 != null) {
               int var2 = var0.field870 - ((class37)var1).field870;
               int var3 = var0.field813 - ((class37)var1).field813;
               if(var2 != 0 || 0 != var3) {
                  var0.field862 = (int)(Math.atan2((double)var2, (double)var3) * 325.949D) & 2047;
               }
            } else if(var0.field818) {
               var0.field837 = -1;
               var0.field818 = false;
            }
         }

         if(-1 != var0.field839 && (var0.field865 == 0 || var0.field848 > 0)) {
            var0.field862 = var0.field839;
            var0.field839 = -1;
         }

         int var4 = var0.field862 - var0.field814 & 2047;
         if(0 == var4 && var0.field818) {
            var0.field837 = -1;
            var0.field818 = false;
         }

         if(0 != var4) {
            ++var0.field843;
            boolean var5;
            if(var4 > 1024) {
               var0.field814 -= var0.field864;
               var5 = true;
               if(var4 < var0.field864 || var4 > 2048 - var0.field864) {
                  var0.field814 = var0.field862;
                  var5 = false;
               }

               if(var0.field817 == var0.field840 && (var0.field843 > 25 || var5)) {
                  if(var0.field830 != -1) {
                     var0.field840 = var0.field830;
                  } else {
                     var0.field840 = var0.field820;
                  }
               }
            } else {
               var0.field814 += var0.field864;
               var5 = true;
               if(var4 < var0.field864 || var4 > 2048 - var0.field864) {
                  var0.field814 = var0.field862;
                  var5 = false;
               }

               if(var0.field817 == var0.field840 && (var0.field843 > 25 || var5)) {
                  if(var0.field819 * -1 != -1) {
                     var0.field840 = var0.field819 * -1;
                  } else {
                     var0.field840 = var0.field820;
                  }
               }
            }

            var0.field814 &= 2047;
         } else {
            var0.field843 = 0;
         }

      }
   }
}
