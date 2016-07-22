import java.applet.Applet;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("q")
public class class23 extends class207 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -343986001
   )
   int field590;
   @ObfuscatedName("w")
   int[] field591;
   @ObfuscatedName("e")
   int[] field592;
   @ObfuscatedName("o")
   String[] field593;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1001173985
   )
   int field595;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 744877859
   )
   int field596;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 985639829
   )
   int field597;
   @ObfuscatedName("m")
   static class196 field599 = new class196(128);
   @ObfuscatedName("hr")
   @ObfuscatedGetter(
      intValue = -355720581
   )
   @Export("menuWidth")
   static int field600;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/applet/Applet;Ljava/lang/String;B)V",
      garbageValue = "57"
   )
   public static void method578(Applet var0, String var1) {
      class141.field2197 = var0;
      class141.field2194 = var1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;Lclass215;I)Ljava/lang/String;",
      garbageValue = "-1816850826"
   )
   public static String method579(CharSequence var0, class215 var1) {
      if(var0 == null) {
         return null;
      } else {
         int var2 = 0;

         int var3;
         boolean var4;
         char var5;
         for(var3 = var0.length(); var2 < var3; ++var2) {
            var5 = var0.charAt(var2);
            var4 = var5 == 160 || var5 == 32 || var5 == 95 || var5 == 45;
            if(!var4) {
               break;
            }
         }

         while(var3 > var2) {
            var5 = var0.charAt(var3 - 1);
            var4 = var5 == 160 || var5 == 32 || var5 == 95 || var5 == 45;
            if(!var4) {
               break;
            }

            --var3;
         }

         int var14 = var3 - var2;
         if(var14 >= 1) {
            byte var6;
            if(null == var1) {
               var6 = 12;
            } else {
               switch(var1.field3192) {
               case 8:
                  var6 = 20;
                  break;
               default:
                  var6 = 12;
               }
            }

            if(var14 <= var6) {
               StringBuilder var12 = new StringBuilder(var14);

               for(int var15 = var2; var15 < var3; ++var15) {
                  char var7 = var0.charAt(var15);
                  boolean var8;
                  if(Character.isISOControl(var7)) {
                     var8 = false;
                  } else if(class24.method593(var7)) {
                     var8 = true;
                  } else {
                     char[] var9 = class167.field2714;
                     int var10 = 0;

                     label122:
                     while(true) {
                        char var11;
                        if(var10 >= var9.length) {
                           var9 = class167.field2715;

                           for(var10 = 0; var10 < var9.length; ++var10) {
                              var11 = var9[var10];
                              if(var7 == var11) {
                                 var8 = true;
                                 break label122;
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
                     char var13 = class137.method2920(var7);
                     if(var13 != 0) {
                        var12.append(var13);
                     }
                  }
               }

               if(var12.length() == 0) {
                  return null;
               }

               return var12.toString();
            }
         }

         return null;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V",
      garbageValue = "1"
   )
   @Export("addChatMessage")
   static void method580(int var0, String var1, String var2, String var3) {
      class29 var4 = (class29)class11.field156.get(Integer.valueOf(var0));
      if(var4 == null) {
         var4 = new class29();
         class11.field156.put(Integer.valueOf(var0), var4);
      }

      class37 var5 = var4.method655(var0, var1, var2, var3);
      class11.field157.method3861(var5, (long)var5.field809);
      class11.field158.method3912(var5);
      client.field462 = client.field455;
   }
}
