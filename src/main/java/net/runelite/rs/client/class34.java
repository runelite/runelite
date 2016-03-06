package net.runelite.rs.client;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ar")
@Implements("NPC")
public final class class34 extends class37 {
   @ObfuscatedName("rj")
   protected static String field773;
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = 1793187307
   )
   protected static int field775;
   @ObfuscatedName("j")
   @Export("composition")
   class39 field779;

   @ObfuscatedName("a")
   protected final class104 vmethod1870() {
      if(this.field779 == null) {
         return null;
      } else {
         class42 var1 = -1 != super.field820 && 0 == super.field844?class36.method741(super.field820):null;
         class42 var2 = super.field838 != -1 && (super.field838 != super.field815 || var1 == null)?class36.method741(super.field838):null;
         class104 var3 = this.field779.method769(var1, super.field827, var2, super.field829);
         if(null == var3) {
            return null;
         } else {
            var3.method2261();
            super.field843 = var3.field1461;
            if(super.field846 != -1 && super.field847 != -1) {
               class104 var4 = class26.method635(super.field846).method899(super.field847);
               if(var4 != null) {
                  var4.method2270(0, -super.field850, 0);
                  class104[] var5 = new class104[]{var3, var4};
                  var3 = new class104(var5, 2);
               }
            }

            if(this.field779.field885 == 1) {
               var3.field1829 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("o")
   final boolean vmethod753() {
      return null != this.field779;
   }

   @ObfuscatedName("bp")
   static final void method726(class39 var0, int var1, int var2, int var3) {
      if(client.field430 < 400) {
         if(null != var0.field909) {
            var0 = var0.method789();
         }

         if(var0 != null) {
            if(var0.field883) {
               if(!var0.field914 || var1 == client.field450) {
                  String var4 = var0.field884;
                  int var8;
                  if(var0.field901 != 0) {
                     int var7 = var0.field901;
                     var8 = class148.field2249.field39;
                     int var9 = var8 - var7;
                     String var6;
                     if(var9 < -9) {
                        var6 = class24.method592(16711680);
                     } else if(var9 < -6) {
                        var6 = class24.method592(16723968);
                     } else if(var9 < -3) {
                        var6 = class24.method592(16740352);
                     } else if(var9 < 0) {
                        var6 = class24.method592(16756736);
                     } else if(var9 > 9) {
                        var6 = class24.method592('\uff00');
                     } else if(var9 > 6) {
                        var6 = class24.method592(4259584);
                     } else if(var9 > 3) {
                        var6 = class24.method592(8453888);
                     } else if(var9 > 0) {
                        var6 = class24.method592(12648192);
                     } else {
                        var6 = class24.method592(16776960);
                     }

                     var4 = var4 + var6 + " " + " (" + "level-" + var0.field901 + ")";
                  }

                  if(client.field301 == 1) {
                     class118.method2510("Use", client.field442 + " " + "->" + " " + class24.method592(16776960) + var4, 7, var1, var2, var3);
                  } else if(client.field408) {
                     if(2 == (client.field573 & 2)) {
                        class118.method2510(client.field446, client.field447 + " " + "->" + " " + class24.method592(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.field899;
                     if(client.field459) {
                        var5 = class100.method2242(var5);
                     }

                     int var11;
                     if(var5 != null) {
                        for(var11 = 4; var11 >= 0; --var11) {
                           if(null != var5[var11] && !var5[var11].equalsIgnoreCase("Attack")) {
                              byte var10 = 0;
                              if(0 == var11) {
                                 var10 = 9;
                              }

                              if(var11 == 1) {
                                 var10 = 10;
                              }

                              if(var11 == 2) {
                                 var10 = 11;
                              }

                              if(var11 == 3) {
                                 var10 = 12;
                              }

                              if(4 == var11) {
                                 var10 = 13;
                              }

                              class118.method2510(var5[var11], class24.method592(16776960) + var4, var10, var1, var2, var3);
                           }
                        }
                     }

                     if(var5 != null) {
                        for(var11 = 4; var11 >= 0; --var11) {
                           if(var5[var11] != null && var5[var11].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(client.field357 != class20.field579) {
                                 if(class20.field576 == client.field357 || class20.field578 == client.field357 && var0.field901 > class148.field2249.field39) {
                                    var12 = 2000;
                                 }

                                 var8 = 0;
                                 if(0 == var11) {
                                    var8 = var12 + 9;
                                 }

                                 if(1 == var11) {
                                    var8 = 10 + var12;
                                 }

                                 if(2 == var11) {
                                    var8 = var12 + 11;
                                 }

                                 if(var11 == 3) {
                                    var8 = 12 + var12;
                                 }

                                 if(4 == var11) {
                                    var8 = var12 + 13;
                                 }

                                 class118.method2510(var5[var11], class24.method592(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     class118.method2510("Examine", class24.method592(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }

   @ObfuscatedName("j")
   final void method727(int var1, byte var2) {
      int var3 = super.field864[0];
      int var4 = super.field817[0];
      if(var1 == 0) {
         --var3;
         ++var4;
      }

      if(1 == var1) {
         ++var4;
      }

      if(2 == var1) {
         ++var3;
         ++var4;
      }

      if(3 == var1) {
         --var3;
      }

      if(4 == var1) {
         ++var3;
      }

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(6 == var1) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(-1 != super.field820 && class36.method741(super.field820).field998 == 1) {
         super.field820 = -1;
      }

      if(super.field824 < 9) {
         ++super.field824;
      }

      for(int var5 = super.field824; var5 > 0; --var5) {
         super.field864[var5] = super.field864[var5 - 1];
         super.field817[var5] = super.field817[var5 - 1];
         super.field866[var5] = super.field866[var5 - 1];
      }

      super.field864[0] = var3;
      super.field817[0] = var4;
      super.field866[0] = var2;
   }

   @ObfuscatedName("l")
   final void method734(int var1, int var2, boolean var3) {
      if(-1 != super.field820 && class36.method741(super.field820).field998 == 1) {
         super.field820 = -1;
      }

      if(!var3) {
         int var4 = var1 - super.field864[0];
         int var5 = var2 - super.field817[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field824 < 9) {
               ++super.field824;
            }

            for(int var6 = super.field824; var6 > 0; --var6) {
               super.field864[var6] = super.field864[var6 - 1];
               super.field817[var6] = super.field817[var6 - 1];
               super.field866[var6] = super.field866[var6 - 1];
            }

            super.field864[0] = var1;
            super.field817[0] = var2;
            super.field866[0] = 1;
            return;
         }
      }

      super.field824 = 0;
      super.field868 = 0;
      super.field867 = 0;
      super.field864[0] = var1;
      super.field817[0] = var2;
      super.field839 = super.field814 * 64 + 128 * super.field864[0];
      super.field848 = super.field814 * 64 + super.field817[0] * 128;
   }
}
