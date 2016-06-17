import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.Replace;

@ObfuscatedName("ey")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class class139 extends Canvas {
   @ObfuscatedName("kl")
   @Export("chatMessages")
   static class19 field2124;
   @ObfuscatedName("f")
   static String field2125;
   @ObfuscatedName("b")
   Component field2126;

   public final void update(Graphics var1) {
      this.field2126.update(var1);
   }

   class139(Component var1) {
      this.field2126 = var1;
   }

   public final void paint(Graphics var1) {
      this.field2126.paint(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "478692071"
   )
   public static void method2969(class119 var0, int var1) {
      class210 var2 = new class210();
      var2.field3120 = var0.method2514();
      var2.field3124 = var0.method2519();
      var2.field3121 = new int[var2.field3120];
      var2.field3119 = new int[var2.field3120];
      var2.field3123 = new Field[var2.field3120];
      var2.field3125 = new int[var2.field3120];
      var2.field3122 = new Method[var2.field3120];
      var2.field3126 = new byte[var2.field3120][][];

      for(int var3 = 0; var3 < var2.field3120; ++var3) {
         try {
            int var4 = var0.method2514();
            String var5;
            String var6;
            int var7;
            if(var4 != 0 && var4 != 1 && var4 != 2) {
               if(var4 == 3 || var4 == 4) {
                  var5 = var0.method2522();
                  var6 = var0.method2522();
                  var7 = var0.method2514();
                  String[] var8 = new String[var7];

                  for(int var9 = 0; var9 < var7; ++var9) {
                     var8[var9] = var0.method2522();
                  }

                  String var20 = var0.method2522();
                  byte[][] var10 = new byte[var7][];
                  int var12;
                  if(var4 == 3) {
                     for(int var11 = 0; var11 < var7; ++var11) {
                        var12 = var0.method2519();
                        var10[var11] = new byte[var12];
                        var0.method2525(var10[var11], 0, var12);
                     }
                  }

                  var2.field3121[var3] = var4;
                  Class[] var21 = new Class[var7];

                  for(var12 = 0; var12 < var7; ++var12) {
                     var21[var12] = class101.method2287(var8[var12]);
                  }

                  Class var22 = class101.method2287(var20);
                  if(class101.method2287(var5).getClassLoader() == null) {
                     throw new SecurityException();
                  }

                  Method[] var13 = class101.method2287(var5).getDeclaredMethods();
                  Method[] var14 = var13;

                  for(int var15 = 0; var15 < var14.length; ++var15) {
                     Method var16 = var14[var15];
                     if(var16.getName().equals(var6)) {
                        Class[] var17 = var16.getParameterTypes();
                        if(var17.length == var21.length) {
                           boolean var18 = true;

                           for(int var19 = 0; var19 < var21.length; ++var19) {
                              if(var21[var19] != var17[var19]) {
                                 var18 = false;
                                 break;
                              }
                           }

                           if(var18 && var22 == var16.getReturnType()) {
                              var2.field3122[var3] = var16;
                           }
                        }
                     }
                  }

                  var2.field3126[var3] = var10;
               }
            } else {
               var5 = var0.method2522();
               var6 = var0.method2522();
               var7 = 0;
               if(var4 == 1) {
                  var7 = var0.method2519();
               }

               var2.field3121[var3] = var4;
               var2.field3125[var3] = var7;
               if(class101.method2287(var5).getClassLoader() == null) {
                  throw new SecurityException();
               }

               var2.field3123[var3] = class101.method2287(var5).getDeclaredField(var6);
            }
         } catch (ClassNotFoundException var24) {
            var2.field3119[var3] = -1;
         } catch (SecurityException var25) {
            var2.field3119[var3] = -2;
         } catch (NullPointerException var26) {
            var2.field3119[var3] = -3;
         } catch (Exception var27) {
            var2.field3119[var3] = -4;
         } catch (Throwable var28) {
            var2.field3119[var3] = -5;
         }
      }

      class211.field3127.method3863(var2);
   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(Lclass3;ZI)V",
      garbageValue = "1"
   )
   static final void method2971(class3 var0, boolean var1) {
      int var2 = var0.field60;
      int var3 = (int)var0.field3113;
      var0.method3916();
      class50.method1007(var2);
      class217.method3975(var2);
      class173 var4 = class161.method3205(var3);
      if(var4 != null) {
         class4.method37(var4);
      }

      class26.method635();
      if(client.field456 != -1) {
         class32.method720(client.field456, 1);
      }

   }

   @ObfuscatedName("bb")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1"
   )
   static final void method2973(boolean var0) {
      client.field344 = 0;
      client.field462 = 0;
      class34.method731();

      int var1;
      while(client.field332.method2786(client.field334) >= 27) {
         var1 = client.field332.method2784(15);
         if(var1 == 32767) {
            break;
         }

         boolean var2 = false;
         if(client.field326[var1] == null) {
            client.field326[var1] = new class34();
            var2 = true;
         }

         class34 var3 = client.field326[var1];
         client.field318[++client.field449 - 1] = var1;
         var3.field838 = client.field296;
         var3.field762 = class176.method3460(client.field332.method2784(14));
         int var4 = client.field332.method2784(8);
         if(var4 > 127) {
            var4 -= 256;
         }

         int var5 = client.field418[client.field332.method2784(3)];
         if(var2) {
            var3.field840 = var3.field792 = var5;
         }

         int var6 = client.field332.method2784(8);
         if(var6 > 127) {
            var6 -= 256;
         }

         int var7 = client.field332.method2784(1);
         int var8 = client.field332.method2784(1);
         if(var8 == 1) {
            client.field330[++client.field462 - 1] = var1;
         }

         var3.field832 = var3.field762.field865;
         var3.field842 = var3.field762.field891;
         if(var3.field842 == 0) {
            var3.field792 = 0;
         }

         var3.field798 = var3.field762.field871;
         var3.field821 = var3.field762.field894;
         var3.field800 = var3.field762.field873;
         var3.field848 = var3.field762.field866;
         var3.field795 = var3.field762.field868;
         var3.field796 = var3.field762.field869;
         var3.field797 = var3.field762.field860;
         var3.method724(var6 + class153.field2262.field844[0], var4 + class153.field2262.field831[0], var7 == 1);
      }

      client.field332.method2785();
      class153.method3170();

      for(var1 = 0; var1 < client.field344; ++var1) {
         int var9 = client.field414[var1];
         if(client.field296 != client.field326[var9].field838) {
            client.field326[var9].field762 = null;
            client.field326[var9] = null;
         }
      }

      if(client.field332.field1976 != client.field334) {
         throw new RuntimeException(client.field332.field1976 + "," + client.field334);
      } else {
         for(var1 = 0; var1 < client.field449; ++var1) {
            if(null == client.field326[client.field318[var1]]) {
               throw new RuntimeException(var1 + "," + client.field449);
            }
         }

      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)Lclass227;",
      garbageValue = "-1917032271"
   )
   public static class227 method2974(String var0, String var1, boolean var2) {
      File var3 = new File(class103.field1759, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            class227 var10 = new class227(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class124.field2021 == 33) {
         var4 = "_rc";
      } else if(class124.field2021 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class119.field1985, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      class227 var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new class227(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new class227(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }
}
