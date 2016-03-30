import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dq")
public class class111 {
   @ObfuscatedName("x")
   static final String[] field1963 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("t")
   static Calendar field1965;
   @ObfuscatedName("w")
   static final String[][] field1966 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
   @ObfuscatedName("u")
   public static String[] field1967;

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field1965 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([BZI)Ljava/lang/Object;",
      garbageValue = "0"
   )
   public static Object method2434(byte[] var0) {
      if(null == var0) {
         return null;
      } else {
         if(var0.length > 136 && !class125.field2046) {
            try {
               class118 var1 = new class118();
               var1.vmethod2795(var0);
               return var1;
            } catch (Throwable var2) {
               class125.field2046 = true;
            }
         }

         return var0;
      }
   }

   @ObfuscatedName("z")
   static final int method2435(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class41.method887(var3, var5);
      int var8 = class41.method887(1 + var3, var5);
      int var9 = class41.method887(var3, 1 + var5);
      int var10 = class41.method887(var3 + 1, var5 + 1);
      int var11 = class87.method2074(var7, var8, var4, var2);
      int var12 = class87.method2074(var9, var10, var4, var2);
      return class87.method2074(var11, var12, var6, var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass122;IB)V",
      garbageValue = "82"
   )
   static void method2436(class122 var0, int var1) {
      boolean var2 = var0.method2777(1) == 1;
      if(var2) {
         class32.field748[++class32.field758 - 1] = var1;
      }

      int var3 = var0.method2777(2);
      class2 var4 = client.field415[var1];
      if(0 == var3) {
         if(var2) {
            var4.field61 = false;
         } else if(client.field416 == var1) {
            throw new RuntimeException();
         } else {
            class32.field764[var1] = (class2.field37 + var4.field873[0] >> 6) + (var4.field62 << 28) + (var4.field872[0] + class41.field990 >> 6 << 14);
            if(var4.field876 != -1) {
               class32.field761[var1] = var4.field876;
            } else {
               class32.field761[var1] = var4.field847;
            }

            class32.field755[var1] = var4.field851;
            client.field415[var1] = null;
            if(var0.method2777(1) != 0) {
               class14.method166(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.method2777(3);
            var6 = var4.field872[0];
            var7 = var4.field873[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(1 == var5) {
               --var7;
            } else if(2 == var5) {
               ++var6;
               --var7;
            } else if(3 == var5) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(7 == var5) {
               ++var6;
               ++var7;
            }

            if(var1 == client.field416 && (var4.field849 < 1536 || var4.field819 < 1536 || var4.field849 >= 11776 || var4.field819 >= 11776)) {
               var4.method17(var6, var7);
               var4.field61 = false;
            } else if(var2) {
               var4.field61 = true;
               var4.field58 = var6;
               var4.field63 = var7;
            } else {
               var4.field61 = false;
               var4.method16(var6, var7, class32.field754[var1]);
            }

         } else if(2 == var3) {
            var5 = var0.method2777(4);
            var6 = var4.field872[0];
            var7 = var4.field873[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(1 == var5) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(4 == var5) {
               var6 += 2;
               var7 -= 2;
            } else if(5 == var5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(7 == var5) {
               var6 -= 2;
            } else if(8 == var5) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(10 == var5) {
               var6 += 2;
               ++var7;
            } else if(11 == var5) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(14 == var5) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(client.field416 != var1 || var4.field849 >= 1536 && var4.field819 >= 1536 && var4.field849 < 11776 && var4.field819 < 11776) {
               if(var2) {
                  var4.field61 = true;
                  var4.field58 = var6;
                  var4.field63 = var7;
               } else {
                  var4.field61 = false;
                  var4.method16(var6, var7, class32.field754[var1]);
               }
            } else {
               var4.method17(var6, var7);
               var4.field61 = false;
            }

         } else {
            var5 = var0.method2777(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.method2777(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.field872[0];
               var11 = var9 + var4.field873[0];
               if(client.field416 != var1 || var4.field849 >= 1536 && var4.field819 >= 1536 && var4.field849 < 11776 && var4.field819 < 11776) {
                  if(var2) {
                     var4.field61 = true;
                     var4.field58 = var10;
                     var4.field63 = var11;
                  } else {
                     var4.field61 = false;
                     var4.method16(var10, var11, class32.field754[var1]);
                  }
               } else {
                  var4.method17(var10, var11);
                  var4.field61 = false;
               }

               var4.field62 = (byte)(var4.field62 + var7 & 3);
               if(client.field416 == var1) {
                  class82.field1437 = var4.field62;
               }

            } else {
               var6 = var0.method2777(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var4.field872[0] + class41.field990 + var8 & 16383) - class41.field990;
               var11 = (var9 + class2.field37 + var4.field873[0] & 16383) - class2.field37;
               if(var1 == client.field416 && (var4.field849 < 1536 || var4.field819 < 1536 || var4.field849 >= 11776 || var4.field819 >= 11776)) {
                  var4.method17(var10, var11);
                  var4.field61 = false;
               } else if(var2) {
                  var4.field61 = true;
                  var4.field58 = var10;
                  var4.field63 = var11;
               } else {
                  var4.field61 = false;
                  var4.method16(var10, var11, class32.field754[var1]);
               }

               var4.field62 = (byte)(var4.field62 + var7 & 3);
               if(var1 == client.field416) {
                  class82.field1437 = var4.field62;
               }

            }
         }
      }
   }
}
