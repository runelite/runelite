import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public class class22 extends class204 {
   @ObfuscatedName("w")
   int[] field578;
   @ObfuscatedName("f")
   int[] field579;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -400894535
   )
   int field580;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1093511165
   )
   int field581;
   @ObfuscatedName("e")
   static class193 field582 = new class193(128);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1123258195
   )
   int field583;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1338065599
   )
   int field584;
   @ObfuscatedName("s")
   String[] field585;

   @ObfuscatedName("k")
   public static String method581(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(0 == var3) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = class113.method2461(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && 33 != var5) {
            if(Character.isSpaceChar(var5)) {
               if(2 != var3) {
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

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "2049792634"
   )
   static final void method582(boolean var0) {
      client.field339 = var0;
      int var1;
      int var2;
      int var3;
      int var4;
      int var5;
      int var6;
      int var7;
      if(!client.field339) {
         var1 = client.field323.method2587();
         var2 = client.field323.method2557();
         var3 = client.field323.method2700();
         class14.field213 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class14.field213[var4][var5] = client.field323.method2528();
            }
         }

         class45.field1016 = new int[var3];
         class9.field163 = new int[var3];
         class185.field3001 = new int[var3];
         class42.field980 = new byte[var3][];
         class37.field813 = new byte[var3][];
         boolean var13 = false;
         if((48 == var1 / 8 || 49 == var1 / 8) && var2 / 8 == 48) {
            var13 = true;
         }

         if(var1 / 8 == 48 && var2 / 8 == 148) {
            var13 = true;
         }

         var3 = 0;

         for(var5 = (var1 - 6) / 8; var5 <= (var1 + 6) / 8; ++var5) {
            for(var6 = (var2 - 6) / 8; var6 <= (6 + var2) / 8; ++var6) {
               var7 = (var5 << 8) + var6;
               if(!var13 || var6 != 49 && 149 != var6 && 147 != var6 && 50 != var5 && (var5 != 49 || 47 != var6)) {
                  class45.field1016[var3] = var7;
                  class9.field163[var3] = class32.field743.method3255("m" + var5 + "_" + var6);
                  class185.field3001[var3] = class32.field743.method3255("l" + var5 + "_" + var6);
                  ++var3;
               }
            }
         }

         class102.method2312(var1, var2);
      } else {
         var1 = client.field323.method2700();
         var2 = client.field323.method2561();
         var3 = client.field323.method2700();
         client.field323.method2755();

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field323.method2756(1);
                  if(1 == var7) {
                     client.field498[var4][var5][var6] = client.field323.method2756(26);
                  } else {
                     client.field498[var4][var5][var6] = -1;
                  }
               }
            }
         }

         client.field323.method2754();
         class14.field213 = new int[var3][4];

         for(var4 = 0; var4 < var3; ++var4) {
            for(var5 = 0; var5 < 4; ++var5) {
               class14.field213[var4][var5] = client.field323.method2528();
            }
         }

         class45.field1016 = new int[var3];
         class9.field163 = new int[var3];
         class185.field3001 = new int[var3];
         class42.field980 = new byte[var3][];
         class37.field813 = new byte[var3][];
         var3 = 0;

         for(var4 = 0; var4 < 4; ++var4) {
            for(var5 = 0; var5 < 13; ++var5) {
               for(var6 = 0; var6 < 13; ++var6) {
                  var7 = client.field498[var4][var5][var6];
                  if(var7 != -1) {
                     int var8 = var7 >> 14 & 1023;
                     int var9 = var7 >> 3 & 2047;
                     int var10 = var9 / 8 + (var8 / 8 << 8);

                     int var11;
                     for(var11 = 0; var11 < var3; ++var11) {
                        if(var10 == class45.field1016[var11]) {
                           var10 = -1;
                           break;
                        }
                     }

                     if(-1 != var10) {
                        class45.field1016[var3] = var10;
                        var11 = var10 >> 8 & 255;
                        int var12 = var10 & 255;
                        class9.field163[var3] = class32.field743.method3255("m" + var11 + "_" + var12);
                        class185.field3001[var3] = class32.field743.method3255("l" + var11 + "_" + var12);
                        ++var3;
                     }
                  }
               }
            }
         }

         class102.method2312(var1, var2);
      }

   }

   @ObfuscatedName("y")
   static class224 method584(byte[] var0) {
      if(null == var0) {
         return null;
      } else {
         class224 var1 = new class224(var0, class76.field1357, class84.field1437, class5.field86, class76.field1355, class215.field3152, class76.field1352);
         class30.method670();
         return var1;
      }
   }

   @ObfuscatedName("e")
   public static void method585(boolean var0) {
      if(null != class171.field2728) {
         try {
            class119 var1 = new class119(4);
            var1.method2565(var0?2:3);
            var1.method2510(0);
            class171.field2728.method2983(var1.field1980, 0, 4);
         } catch (IOException var4) {
            try {
               class171.field2728.method2982();
            } catch (Exception var3) {
               ;
            }

            ++class171.field2732;
            class171.field2728 = null;
         }

      }
   }
}
