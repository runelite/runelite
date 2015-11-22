package net.runelite.rs.client;

import java.util.zip.Inflater;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("dq")
public class class115 {
   @ObfuscatedName("nz")
   @ObfuscatedGetter(
      intValue = -1155187455
   )
   static int field1963;
   @ObfuscatedName("ee")
   static class78[] field1965;
   @ObfuscatedName("j")
   Inflater field1967;

   @ObfuscatedName("j")
   public void method2469(class118 var1, byte[] var2) {
      if(var1.field1980[var1.field1981] == 31 && -117 == var1.field1980[1 + var1.field1981]) {
         if(this.field1967 == null) {
            this.field1967 = new Inflater(true);
         }

         try {
            this.field1967.setInput(var1.field1980, 10 + var1.field1981, var1.field1980.length - (8 + var1.field1981 + 10));
            this.field1967.inflate(var2);
         } catch (Exception var4) {
            this.field1967.reset();
            throw new RuntimeException("");
         }

         this.field1967.reset();
      } else {
         throw new RuntimeException("");
      }
   }

   @ObfuscatedName("cv")
   static final void method2471(class172[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         class172 var3 = var0[var2];
         if(null != var3 && var1 == var3.field2742 && (!var3.field2733 || !class153.method3195(var3))) {
            int var5;
            if(0 == var3.field2736) {
               if(!var3.field2733 && class153.method3195(var3) && var3 != class3.field65) {
                  continue;
               }

               method2471(var0, var3.field2734 * -1);
               if(null != var3.field2806) {
                  method2471(var3.field2806, var3.field2734 * -1);
               }

               class3 var4 = (class3)client.field304.method3836((long)(var3.field2734 * -1));
               if(null != var4) {
                  var5 = var4.field63;
                  if(class167.method3400(var5)) {
                     method2471(class172.field2857[var5], -1);
                  }
               }
            }

            if(var3.field2736 == 6) {
               if(var3.field2802 != -1 || -1 != var3.field2780) {
                  boolean var7 = class161.method3232(var3);
                  if(var7) {
                     var5 = var3.field2780;
                  } else {
                     var5 = var3.field2802;
                  }

                  if(var5 != -1) {
                     class42 var6 = client.method584(var5);

                     for(var3.field2773 += client.field420; var3.field2773 > var6.field975[var3.field2854]; class42.method942(var3)) {
                        var3.field2773 -= var6.field975[var3.field2854];
                        ++var3.field2854;
                        if(var3.field2854 >= var6.field973.length) {
                           var3.field2854 -= var6.field977 * -1;
                           if(var3.field2854 < 0 || var3.field2854 >= var6.field973.length) {
                              var3.field2854 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2797 != 0 && !var3.field2733) {
                  int var8 = var3.field2797 >> 16;
                  var5 = var3.field2797 << 16 >> 16;
                  var8 *= client.field420;
                  var5 *= client.field420;
                  var3.field2783 = var8 + var3.field2783 & 2047;
                  var3.field2760 = var3.field2760 + var5 & 2047;
                  class42.method942(var3);
               }
            }
         }
      }

   }

   class115(int var1, int var2, int var3) {
   }

   @ObfuscatedName("bb")
   static final void method2474(class39 var0, int var1, int var2, int var3) {
      if(client.field416 < 400) {
         if(var0.field895 != null) {
            var0 = var0.method813();
         }

         if(null != var0) {
            if(var0.field881) {
               if(!var0.field898 || var1 == client.field463) {
                  String var4 = var0.field870;
                  if(var0.field887 != 0) {
                     var4 = var4 + class124.method2833(var0.field887, class0.field12.field53) + " " + " (" + "level-" + var0.field887 + ")";
                  }

                  if(client.field398 == 1) {
                     class25.method674("Use", client.field428 + " " + "->" + " " + class74.method1617(16776960) + var4, 7, var1, var2, var3);
                  } else if(client.field546) {
                     if((class138.field2124 & 2) == 2) {
                        class25.method674(client.field432, client.field433 + " " + "->" + " " + class74.method1617(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.field885;
                     if(client.field374) {
                        var5 = class143.method3145(var5);
                     }

                     int var6;
                     if(null != var5) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(var5[var6] != null && !var5[var6].equalsIgnoreCase("Attack")) {
                              byte var7 = 0;
                              if(var6 == 0) {
                                 var7 = 9;
                              }

                              if(1 == var6) {
                                 var7 = 10;
                              }

                              if(var6 == 2) {
                                 var7 = 11;
                              }

                              if(3 == var6) {
                                 var7 = 12;
                              }

                              if(var6 == 4) {
                                 var7 = 13;
                              }

                              class25.method674(var5[var6], class74.method1617(16776960) + var4, var7, var1, var2, var3);
                           }
                        }
                     }

                     if(var5 != null) {
                        for(var6 = 4; var6 >= 0; --var6) {
                           if(null != var5[var6] && var5[var6].equalsIgnoreCase("Attack")) {
                              short var9 = 0;
                              if(client.field303 != class20.field560) {
                                 if(client.field303 == class20.field565 || class20.field559 == client.field303 && var0.field887 > class0.field12.field53) {
                                    var9 = 2000;
                                 }

                                 int var8 = 0;
                                 if(var6 == 0) {
                                    var8 = 9 + var9;
                                 }

                                 if(1 == var6) {
                                    var8 = var9 + 10;
                                 }

                                 if(var6 == 2) {
                                    var8 = var9 + 11;
                                 }

                                 if(3 == var6) {
                                    var8 = 12 + var9;
                                 }

                                 if(var6 == 4) {
                                    var8 = var9 + 13;
                                 }

                                 class25.method674(var5[var6], class74.method1617(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     class25.method674("Examine", class74.method1617(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("f")
   public static int method2475(int var0, int var1, int var2, int var3, int var4, int var5) {
      if(1 == (var5 & 1)) {
         int var6 = var3;
         var3 = var4;
         var4 = var6;
      }

      var2 &= 3;
      return 0 == var2?var1:(var2 == 1?7 - var0 - (var3 - 1):(2 == var2?7 - var1 - (var4 - 1):var0));
   }

   @ObfuscatedName("j")
   public static void method2476(class166 var0) {
      class48.field1069 = var0;
   }

   public class115() {
      this(-1, 1000000, 1000000);
   }
}
