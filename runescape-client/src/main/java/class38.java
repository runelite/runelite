import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Calendar;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("at")
public class class38 {
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 971073451
   )
   static int field836 = 0;
   @ObfuscatedName("c")
   static int[] field838;
   @ObfuscatedName("r")
   static int[] field839 = new int[5];
   @ObfuscatedName("a")
   static int[][] field840 = new int[5][5000];
   @ObfuscatedName("q")
   static class176 field842;
   @ObfuscatedName("j")
   static final String[] field843 = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
   @ObfuscatedName("b")
   static int[] field844 = new int[1000];
   @ObfuscatedName("u")
   @Export("chatboxSegments")
   static String[] field845 = new String[1000];
   @ObfuscatedName("g")
   static Calendar field846 = Calendar.getInstance();
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 866235655
   )
   static int field847 = 0;
   @ObfuscatedName("p")
   static class14[] field848 = new class14[50];

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lclass170;Lclass170;S)I",
      garbageValue = "192"
   )
   static int method783(class170 var0, class170 var1) {
      int var2 = 0;
      if(var0.method3341("title.jpg", "")) {
         ++var2;
      }

      if(var1.method3341("logo", "")) {
         ++var2;
      }

      if(var1.method3341("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.method3341("titlebox", "")) {
         ++var2;
      }

      if(var1.method3341("titlebutton", "")) {
         ++var2;
      }

      if(var1.method3341("runes", "")) {
         ++var2;
      }

      if(var1.method3341("title_mute", "")) {
         ++var2;
      }

      if(var1.method3360("options_radio_buttons,0")) {
         ++var2;
      }

      if(var1.method3360("options_radio_buttons,2")) {
         ++var2;
      }

      var1.method3341("sl_back", "");
      var1.method3341("sl_flags", "");
      var1.method3341("sl_arrows", "");
      var1.method3341("sl_stars", "");
      var1.method3341("sl_button", "");
      return var2;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lclass122;II)V",
      garbageValue = "1805243229"
   )
   public static void method784(class122 var0, int var1) {
      class213 var2 = new class213();
      var2.field3169 = var0.method2610();
      var2.field3176 = var0.method2614();
      var2.field3171 = new int[var2.field3169];
      var2.field3172 = new int[var2.field3169];
      var2.field3173 = new Field[var2.field3169];
      var2.field3174 = new int[var2.field3169];
      var2.field3175 = new Method[var2.field3169];
      var2.field3170 = new byte[var2.field3169][][];

      for(int var3 = 0; var3 < var2.field3169; ++var3) {
         try {
            int var4 = var0.method2610();
            String var5;
            String var6;
            int var7;
            if(var4 != 0 && var4 != 1 && var4 != 2) {
               if(var4 == 3 || var4 == 4) {
                  var5 = var0.method2617();
                  var6 = var0.method2617();
                  var7 = var0.method2610();
                  String[] var8 = new String[var7];

                  for(int var9 = 0; var9 < var7; ++var9) {
                     var8[var9] = var0.method2617();
                  }

                  String var20 = var0.method2617();
                  byte[][] var10 = new byte[var7][];
                  int var12;
                  if(var4 == 3) {
                     for(int var11 = 0; var11 < var7; ++var11) {
                        var12 = var0.method2614();
                        var10[var11] = new byte[var12];
                        var0.method2737(var10[var11], 0, var12);
                     }
                  }

                  var2.field3171[var3] = var4;
                  Class[] var21 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var21[var12] = class213.method4010(var8[var12]);
                  }

                  Class var22 = class213.method4010(var20);
                  if(class213.method4010(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = class213.method4010(var5).getDeclaredMethods();
                  Method[] var14 = var13;

                  for(int var15 = 0; var15 < var14.length; ++var15) {
                     Method var16 = var14[var15];
                     if(var16.getName().equals(var6)) {
                        Class[] var17 = var16.getParameterTypes();
                        if(var17.length == var21.length) {
                           boolean var18 = true;

                           for(int var19 = 0; var19 < var21.length; ++var19) {
                              if(var17[var19] != var21[var19]) {
                                 var18 = false;
                                 break;
                              }
                           }

                           if(var18 && var22 == var16.getReturnType()) {
                              var2.field3175[var3] = var16;
                           }
                        }
                     }
                  }

                  var2.field3170[var3] = var10;
               }
            } else {
               var5 = var0.method2617();
               var6 = var0.method2617();
               var7 = 0;
               if(var4 == 1) {
                  var7 = var0.method2614();
               }

               var2.field3171[var3] = var4;
               var2.field3174[var3] = var7;
               if(class213.method4010(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.field3173[var3] = class213.method4010(var5).getDeclaredField(var6);
            }
         } catch (ClassNotFoundException var24) {
            var2.field3172[var3] = -1;
         } catch (SecurityException var25) {
            var2.field3172[var3] = -2;
         } catch (NullPointerException var26) {
            var2.field3172[var3] = -3;
         } catch (Exception var27) {
            var2.field3172[var3] = -4;
         } catch (Throwable var28) {
            var2.field3172[var3] = -5;
         }
      }

      class214.field3177.method3935(var2);
   }
}
