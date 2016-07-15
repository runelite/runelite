import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
@Implements("Friend")
public class class17 {
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -1727635537
   )
   @Export("rank")
   int field248;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -287026243
   )
   @Export("world")
   int field249;
   @ObfuscatedName("r")
   boolean field251;
   @ObfuscatedName("a")
   boolean field252;
   @ObfuscatedName("e")
   @Export("name")
   String field253;
   @ObfuscatedName("bu")
   static class171 field254;
   @ObfuscatedName("l")
   @Export("previousName")
   String field257;
   @ObfuscatedName("nt")
   @ObfuscatedGetter(
      intValue = 1996409417
   )
   static int field258;
   @ObfuscatedName("x")
   public static class122 field259;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass170;I)V",
      garbageValue = "-681374539"
   )
   public static void method165(class170 var0) {
      class54.field1169 = var0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([BIIIIIIILclass89;[Lclass111;B)V",
      garbageValue = "74"
   )
   static final void method166(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, class89 var8, class111[] var9) {
      class122 var10 = new class122(var0);
      int var11 = -1;

      while(true) {
         int var12 = var10.method2672();
         if(var12 == 0) {
            return;
         }

         var11 += var12;
         int var13 = 0;

         while(true) {
            int var14 = var10.method2672();
            if(var14 == 0) {
               break;
            }

            var13 += var14 - 1;
            int var15 = var13 & 63;
            int var16 = var13 >> 6 & 63;
            int var17 = var13 >> 12;
            int var18 = var10.method2610();
            int var19 = var18 >> 2;
            int var20 = var18 & 3;
            if(var4 == var17 && var16 >= var5 && var16 < var5 + 8 && var15 >= var6 && var15 < var6 + 8) {
               class42 var21 = class146.method3102(var11);
               int var24 = var16 & 7;
               int var25 = var15 & 7;
               int var27 = var21.field959;
               int var28 = var21.field1000;
               int var29;
               if((var20 & 1) == 1) {
                  var29 = var27;
                  var27 = var28;
                  var28 = var29;
               }

               int var26 = var7 & 3;
               int var23;
               if(var26 == 0) {
                  var23 = var24;
               } else if(var26 == 1) {
                  var23 = var25;
               } else if(var26 == 2) {
                  var23 = 7 - var24 - (var27 - 1);
               } else {
                  var23 = 7 - var25 - (var28 - 1);
               }

               var29 = var23 + var2;
               int var30 = var3 + class161.method3260(var16 & 7, var15 & 7, var7, var21.field959, var21.field1000, var20);
               if(var29 > 0 && var30 > 0 && var29 < 103 && var30 < 103) {
                  int var31 = var1;
                  if((class5.field89[1][var29][var30] & 2) == 2) {
                     var31 = var1 - 1;
                  }

                  class111 var32 = null;
                  if(var31 >= 0) {
                     var32 = var9[var31];
                  }

                  class167.method3323(var1, var29, var30, var11, var7 + var20 & 3, var19, var8, var32);
               }
            }
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass215;I)Ljava/lang/String;",
      garbageValue = "-1227997993"
   )
   public static String method167(CharSequence var0, class215 var1) {
      if(null == var0) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            char var12 = var0.charAt(var2);
            boolean var4 = var12 == 160 || var12 == 32 || var12 == 95 || var12 == 45;
            if(!var4) {
               break;
            }
         }

         while(var3 > var2 && class18.method176(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var14 = var3 - var2;
         if(var14 >= 1 && var14 <= class157.method3247(var1)) {
            StringBuilder var5 = new StringBuilder(var14);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               boolean var8;
               if(Character.isISOControl(var7)) {
                  var8 = false;
               } else if(client.method513(var7)) {
                  var8 = true;
               } else {
                  char[] var9 = class167.field2692;
                  int var10 = 0;

                  label94:
                  while(true) {
                     char var11;
                     if(var10 >= var9.length) {
                        var9 = class167.field2695;

                        for(var10 = 0; var10 < var9.length; ++var10) {
                           var11 = var9[var10];
                           if(var7 == var11) {
                              var8 = true;
                              break label94;
                           }
                        }

                        var8 = false;
                        break;
                     }

                     var11 = var9[var10];
                     if(var11 == var7) {
                        var8 = true;
                        break;
                     }

                     ++var10;
                  }
               }

               if(var8) {
                  char var13 = class160.method3259(var7);
                  if(var13 != 0) {
                     var5.append(var13);
                  }
               }
            }

            if(var5.length() == 0) {
               return null;
            } else {
               return var5.toString();
            }
         } else {
            return null;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass27;Lclass27;IZI)I",
      garbageValue = "-1575347669"
   )
   static int method168(class27 var0, class27 var1, int var2, boolean var3) {
      if(var2 == 1) {
         int var4 = var0.field677;
         int var5 = var1.field677;
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
         return var2 == 2?var0.field683 - var1.field683:(var2 == 3?(var0.field682.equals("-")?(var1.field682.equals("-")?0:(var3?-1:1)):(var1.field682.equals("-")?(var3?1:-1):var0.field682.compareTo(var1.field682))):(var2 == 4?(var0.method607()?(var1.method607()?0:1):(var1.method607()?-1:0)):(var2 == 5?(var0.method605()?(var1.method605()?0:1):(var1.method605()?-1:0)):(var2 == 6?(var0.method606()?(var1.method606()?0:1):(var1.method606()?-1:0)):(var2 == 7?(var0.method604()?(var1.method604()?0:1):(var1.method604()?-1:0)):var0.field674 - var1.field674)))));
      }
   }
}
