import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aw")
public class class36 {
   @ObfuscatedName("z")
   static int[] field785 = new int[5];
   @ObfuscatedName("r")
   static int[][] field788 = new int[5][5000];
   @ObfuscatedName("f")
   static int[] field789 = new int[1000];
   @ObfuscatedName("l")
   static class14[] field792 = new class14[50];
   @ObfuscatedName("y")
   static class173 field793;
   @ObfuscatedName("k")
   static Calendar field794 = Calendar.getInstance();
   @ObfuscatedName("o")
   static final String[] field795 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("s")
   @Export("chatboxSegments")
   static String[] field796 = new String[1000];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 11000289
   )
   static int field799 = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1373277177
   )
   static int field802 = 0;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass212;I)Ljava/lang/String;",
      garbageValue = "191739212"
   )
   public static String method723(CharSequence var0, class212 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         for(var3 = var0.length(); var2 < var3 && class39.method783(var0.charAt(var2)); ++var2) {
            ;
         }

         while(var3 > var2 && class39.method783(var0.charAt(var3 - 1))) {
            --var3;
         }

         int var4 = var3 - var2;
         if(var4 >= 1 && var4 <= class185.method3674(var1)) {
            StringBuilder var5 = new StringBuilder(var4);

            for(int var6 = var2; var6 < var3; ++var6) {
               char var7 = var0.charAt(var6);
               boolean var8;
               if(Character.isISOControl(var7)) {
                  var8 = false;
               } else {
                  boolean var9 = var7 >= 48 && var7 <= 57 || var7 >= 65 && var7 <= 90 || var7 >= 97 && var7 <= 122;
                  if(var9) {
                     var8 = true;
                  } else {
                     char[] var10 = class164.field2686;
                     int var11 = 0;

                     label98:
                     while(true) {
                        char var12;
                        if(var11 >= var10.length) {
                           var10 = class164.field2687;

                           for(var11 = 0; var11 < var10.length; ++var11) {
                              var12 = var10[var11];
                              if(var12 == var7) {
                                 var8 = true;
                                 break label98;
                              }
                           }

                           var8 = false;
                           break;
                        }

                        var12 = var10[var11];
                        if(var12 == var7) {
                           var8 = true;
                           break;
                        }

                        ++var11;
                     }
                  }
               }

               if(var8) {
                  char var13 = class156.method3137(var7);
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "1148223924"
   )
   public static void method731(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var2 + var3) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(null == var6 || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method731(var0, var1, var2, var5 - 1);
         method731(var0, var1, 1 + var5, var3);
      }

   }
}
