import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ak")
public class class45 extends class204 {
   @ObfuscatedName("x")
   public boolean field1053 = false;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = -1337684083
   )
   protected static int field1055;
   @ObfuscatedName("u")
   static class193 field1056 = new class193(64);
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = -607002629
   )
   static int field1058;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/Throwable;B)V",
      garbageValue = "76"
   )
   public static void method984(String var0, Throwable var1) {
      try {
         String var2 = "";
         if(null != var1) {
            Throwable var4 = var1;
            String var5;
            if(var1 instanceof class148) {
               class148 var6 = (class148)var1;
               var5 = var6.field2223 + " | ";
               var4 = var6.field2220;
            } else {
               var5 = "";
            }

            StringWriter var18 = new StringWriter();
            PrintWriter var7 = new PrintWriter(var18);
            var4.printStackTrace(var7);
            var7.close();
            String var8 = var18.toString();
            BufferedReader var9 = new BufferedReader(new StringReader(var8));
            String var10 = var9.readLine();

            while(true) {
               String var11 = var9.readLine();
               if(null == var11) {
                  var5 = var5 + "| " + var10;
                  var2 = var5;
                  break;
               }

               int var12 = var11.indexOf(40);
               int var13 = var11.indexOf(41, var12 + 1);
               if(var12 >= 0 && var13 >= 0) {
                  String var14 = var11.substring(var12 + 1, var13);
                  int var15 = var14.indexOf(".java:");
                  if(var15 >= 0) {
                     var14 = var14.substring(0, var15) + var14.substring(var15 + 5);
                     var5 = var5 + var14 + ' ';
                     continue;
                  }

                  var11 = var11.substring(0, var12);
               }

               var11 = var11.trim();
               var11 = var11.substring(var11.lastIndexOf(32) + 1);
               var11 = var11.substring(var11.lastIndexOf(9) + 1);
               var5 = var5 + var11 + ' ';
            }
         }

         if(var0 != null) {
            if(null != var1) {
               var2 = var2 + " | ";
            }

            var2 = var2 + var0;
         }

         System.out.println("Error: " + var2);
         var2 = var2.replace(':', '.');
         var2 = var2.replace('@', '_');
         var2 = var2.replace('&', '_');
         var2 = var2.replace('#', '_');
         if(null == class148.field2222) {
            return;
         }

         URL var3 = new URL(class148.field2222.getCodeBase(), "clienterror.ws?c=" + class148.field2228 + "&u=" + class148.field2221 + "&v1=" + class136.field2089 + "&v2=" + class136.field2090 + "&e=" + var2);
         DataInputStream var17 = new DataInputStream(var3.openStream());
         var17.read();
         var17.close();
      } catch (Exception var16) {
         ;
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass119;II)V",
      garbageValue = "1474455240"
   )
   void method986(class119 var1, int var2) {
      if(var2 == 2) {
         this.field1053 = true;
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass119;I)V",
      garbageValue = "2087104646"
   )
   void method997(class119 var1) {
      while(true) {
         int var2 = var1.method2554();
         if(var2 == 0) {
            return;
         }

         this.method986(var1, var2);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1059214653"
   )
   static int method1001(int var0, int var1) {
      class15 var2 = (class15)class15.field229.method3822((long)var0);
      return var2 == null?0:(var1 >= 0 && var1 < var2.field223.length?var2.field223[var1]:0);
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(Lclass173;IIS)V",
      garbageValue = "-17400"
   )
   static final void method1002(class173 var0, int var1, int var2) {
      if(var0.field2757 == 1) {
         class154.method3182(var0.field2871, "", 24, 0, 0, var0.field2869);
      }

      String var3;
      int var4;
      int var5;
      if(var0.field2757 == 2 && !client.field442) {
         var5 = class18.method205(var0);
         var4 = var5 >> 11 & 63;
         if(var4 == 0) {
            var3 = null;
         } else if(null != var0.field2795 && var0.field2795.trim().length() != 0) {
            var3 = var0.field2795;
         } else {
            var3 = null;
         }

         if(null != var3) {
            class154.method3182(var3, class164.method3251('\uff00') + var0.field2870, 25, 0, -1, var0.field2869);
         }
      }

      if(var0.field2757 == 3) {
         class154.method3182("Close", "", 26, 0, 0, var0.field2869);
      }

      if(var0.field2757 == 4) {
         class154.method3182(var0.field2871, "", 28, 0, 0, var0.field2869);
      }

      if(var0.field2757 == 5) {
         class154.method3182(var0.field2871, "", 29, 0, 0, var0.field2869);
      }

      if(var0.field2757 == 6 && client.field312 == null) {
         class154.method3182(var0.field2871, "", 30, 0, -1, var0.field2869);
      }

      int var12;
      if(var0.field2798 == 2) {
         var12 = 0;

         for(var4 = 0; var4 < var0.field2888; ++var4) {
            for(var5 = 0; var5 < var0.field2769; ++var5) {
               int var6 = var5 * (var0.field2820 + 32);
               int var7 = var4 * (32 + var0.field2821);
               if(var12 < 20) {
                  var6 += var0.field2822[var12];
                  var7 += var0.field2823[var12];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < 32 + var7) {
                  client.field406 = var12;
                  class51.field1165 = var0;
                  if(var0.field2889[var12] > 0) {
                     class51 var8 = class141.method3001(var0.field2889[var12] - 1);
                     if(client.field353 == 1 && class124.method2813(class18.method205(var0))) {
                        if(class110.field1956 != var0.field2869 || class42.field1016 != var12) {
                           class154.method3182("Use", client.field441 + " " + "->" + " " + class164.method3251(16748608) + var8.field1128, 31, var8.field1167, var12, var0.field2869);
                        }
                     } else if(client.field442 && class124.method2813(class18.method205(var0))) {
                        if((class84.field1465 & 16) == 16) {
                           class154.method3182(client.field445, client.field446 + " " + "->" + " " + class164.method3251(16748608) + var8.field1128, 32, var8.field1167, var12, var0.field2869);
                        }
                     } else {
                        String[] var9 = var8.field1149;
                        if(client.field458) {
                           var9 = class18.method207(var9);
                        }

                        int var10;
                        byte var11;
                        if(class124.method2813(class18.method205(var0))) {
                           for(var10 = 4; var10 >= 3; --var10) {
                              if(var9 != null && var9[var10] != null) {
                                 if(var10 == 3) {
                                    var11 = 36;
                                 } else {
                                    var11 = 37;
                                 }

                                 class154.method3182(var9[var10], class164.method3251(16748608) + var8.field1128, var11, var8.field1167, var12, var0.field2869);
                              } else if(var10 == 4) {
                                 class154.method3182("Drop", class164.method3251(16748608) + var8.field1128, 37, var8.field1167, var12, var0.field2869);
                              }
                           }
                        }

                        if(class108.method2469(class18.method205(var0))) {
                           class154.method3182("Use", class164.method3251(16748608) + var8.field1128, 38, var8.field1167, var12, var0.field2869);
                        }

                        if(class124.method2813(class18.method205(var0)) && var9 != null) {
                           for(var10 = 2; var10 >= 0; --var10) {
                              if(var9[var10] != null) {
                                 var11 = 0;
                                 if(var10 == 0) {
                                    var11 = 33;
                                 }

                                 if(var10 == 1) {
                                    var11 = 34;
                                 }

                                 if(var10 == 2) {
                                    var11 = 35;
                                 }

                                 class154.method3182(var9[var10], class164.method3251(16748608) + var8.field1128, var11, var8.field1167, var12, var0.field2869);
                              }
                           }
                        }

                        var9 = var0.field2796;
                        if(client.field458) {
                           var9 = class18.method207(var9);
                        }

                        if(var9 != null) {
                           for(var10 = 4; var10 >= 0; --var10) {
                              if(null != var9[var10]) {
                                 var11 = 0;
                                 if(var10 == 0) {
                                    var11 = 39;
                                 }

                                 if(var10 == 1) {
                                    var11 = 40;
                                 }

                                 if(var10 == 2) {
                                    var11 = 41;
                                 }

                                 if(var10 == 3) {
                                    var11 = 42;
                                 }

                                 if(var10 == 4) {
                                    var11 = 43;
                                 }

                                 class154.method3182(var9[var10], class164.method3251(16748608) + var8.field1128, var11, var8.field1167, var12, var0.field2869);
                              }
                           }
                        }

                        class154.method3182("Examine", class164.method3251(16748608) + var8.field1128, 1005, var8.field1167, var12, var0.field2869);
                     }
                  }
               }

               ++var12;
            }
         }
      }

      if(var0.field2860) {
         if(client.field442) {
            if(class76.method1721(class18.method205(var0)) && (class84.field1465 & 32) == 32) {
               class154.method3182(client.field445, client.field446 + " " + "->" + " " + var0.field2833, 58, 0, var0.field2755, var0.field2869);
            }
         } else {
            for(var12 = 9; var12 >= 5; --var12) {
               String var13 = class85.method1967(var0, var12);
               if(var13 != null) {
                  class154.method3182(var13, var0.field2833, 1007, var12 + 1, var0.field2755, var0.field2869);
               }
            }

            var5 = class18.method205(var0);
            var4 = var5 >> 11 & 63;
            if(var4 == 0) {
               var3 = null;
            } else if(var0.field2795 != null && var0.field2795.trim().length() != 0) {
               var3 = var0.field2795;
            } else {
               var3 = null;
            }

            for(var5 = 4; var5 >= 0; --var5) {
               String var14 = class85.method1967(var0, var5);
               if(null != var14) {
                  class154.method3182(var14, var0.field2833, 57, var5 + 1, var0.field2755, var0.field2869);
               }
            }

            if(class127.method2842(class18.method205(var0))) {
               class154.method3182("Continue", "", 30, 0, var0.field2755, var0.field2869);
            }
         }
      }

   }
}
