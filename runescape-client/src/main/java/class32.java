import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class32 {
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = 402337165
   )
   @Export("cameraYaw")
   static int field750;
   @ObfuscatedName("k")
   static int[] field751 = new int[2048];
   @ObfuscatedName("p")
   static byte[] field752 = new byte[2048];
   @ObfuscatedName("x")
   static byte[] field753 = new byte[2048];
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1790155747
   )
   static int field755 = 0;
   @ObfuscatedName("o")
   static int[] field756 = new int[2048];
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 446625441
   )
   static int field757 = 0;
   @ObfuscatedName("m")
   static class119 field758 = new class119(new byte[5000]);
   @ObfuscatedName("c")
   static int[] field759 = new int[2048];
   @ObfuscatedName("l")
   static int[] field760 = new int[2048];
   @ObfuscatedName("t")
   static int[] field761 = new int[2048];
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1013662537
   )
   static int field762 = 0;
   @ObfuscatedName("r")
   static int[] field764 = new int[2048];
   @ObfuscatedName("d")
   static class119[] field768 = new class119[2048];
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = -1495988755
   )
   protected static int field770;

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IB)Lclass130;",
      garbageValue = "-114"
   )
   public static class130 method689(int var0) {
      class130[] var1 = class186.method3702();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         class130 var3 = var1[var2];
         if(var0 == var3.field2073) {
            return var3;
         }
      }

      return null;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass212;I)Ljava/lang/String;",
      garbageValue = "-1882097785"
   )
   public static String method690(CharSequence var0, class212 var1) {
      if(null == var0) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         boolean var4;
         char var5;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            var5 = var0.charAt(var2);
            var4 = 160 == var5 || 32 == var5 || var5 == 95 || 45 == var5;
            if(!var4) {
               break;
            }
         }

         while(var3 > var2) {
            var5 = var0.charAt(var3 - 1);
            var4 = var5 == 160 || var5 == 32 || 95 == var5 || var5 == 45;
            if(!var4) {
               break;
            }

            --var3;
         }

         int var6 = var3 - var2;
         if(var6 >= 1 && var6 <= class21.method558(var1)) {
            StringBuilder var7 = new StringBuilder(var6);

            for(int var8 = var2; var8 < var3; ++var8) {
               char var9 = var0.charAt(var8);
               boolean var10;
               if(Character.isISOControl(var9)) {
                  var10 = false;
               } else if(class33.method694(var9)) {
                  var10 = true;
               } else {
                  label126: {
                     char[] var11 = class164.field2664;

                     int var12;
                     char var13;
                     for(var12 = 0; var12 < var11.length; ++var12) {
                        var13 = var11[var12];
                        if(var13 == var9) {
                           var10 = true;
                           break label126;
                        }
                     }

                     var11 = class164.field2662;
                     var12 = 0;

                     while(true) {
                        if(var12 >= var11.length) {
                           var10 = false;
                           break;
                        }

                        var13 = var11[var12];
                        if(var13 == var9) {
                           var10 = true;
                           break;
                        }

                        ++var12;
                     }
                  }
               }

               if(var10) {
                  char var14 = class156.method3145(var9);
                  if(0 != var14) {
                     var7.append(var14);
                  }
               }
            }

            if(var7.length() == 0) {
               return null;
            } else {
               return var7.toString();
            }
         } else {
            return null;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "-54"
   )
   public static int method691(int var0) {
      class47 var1 = (class47)class47.field1065.method3743((long)var0);
      class47 var2;
      if(null != var1) {
         var2 = var1;
      } else {
         byte[] var3 = class47.field1070.method3239(14, var0);
         var1 = new class47();
         if(null != var3) {
            var1.method955(new class119(var3));
         }

         class47.field1065.method3745(var1, (long)var0);
         var2 = var1;
      }

      int var7 = var2.field1066;
      int var4 = var2.field1064;
      int var5 = var2.field1068;
      int var6 = class176.field2919[var5 - var4];
      return class176.field2920[var7] >> var4 & var6;
   }
}
