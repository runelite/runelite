import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bm")
public class class60 {
   @ObfuscatedName("k")
   XHashTable field1082 = new XHashTable(256);
   @ObfuscatedName("e")
   class182 field1083;
   @ObfuscatedName("f")
   XHashTable field1084 = new XHashTable(256);
   @ObfuscatedName("i")
   class182 field1085;

   public class60(class182 var1, class182 var2) {
      this.field1085 = var1;
      this.field1083 = var2;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass55;",
      garbageValue = "1000355726"
   )
   class55 method1105(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class55 var7 = (class55)this.field1082.method2311(var5);
      if(var7 != null) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class53 var8 = class53.method950(this.field1085, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method938();
            this.field1082.method2312(var7, var5);
            if(null != var3) {
               var3[0] -= var7.field1022.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II[IS)Lclass55;",
      garbageValue = "-24787"
   )
   class55 method1106(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class55 var7 = (class55)this.field1082.method2311(var5);
      if(null != var7) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class54 var8 = (class54)this.field1084.method2311(var5);
         if(null == var8) {
            var8 = class54.method959(this.field1083, var1, var2);
            if(var8 == null) {
               return null;
            }

            this.field1084.method2312(var8, var5);
         }

         var7 = var8.method960(var3);
         if(var7 == null) {
            return null;
         } else {
            var8.unlink();
            this.field1082.method2312(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I[IB)Lclass55;",
      garbageValue = "8"
   )
   public class55 method1107(int var1, int[] var2) {
      if(this.field1085.method3221() == 1) {
         return this.method1105(0, var1, var2);
      } else if(this.field1085.method3220(var1) == 1) {
         return this.method1105(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass55;",
      garbageValue = "862822109"
   )
   public class55 method1108(int var1, int[] var2) {
      if(this.field1083.method3221() == 1) {
         return this.method1106(0, var1, var2);
      } else if(this.field1083.method3220(var1) == 1) {
         return this.method1106(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIIB)V",
      garbageValue = "-32"
   )
   static final void method1114(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class25 var9 = null;

      for(class25 var10 = (class25)Client.field370.method2359(); var10 != null; var10 = (class25)Client.field370.method2361()) {
         if(var10.field586 == var0 && var1 == var10.field574 && var10.field581 == var2 && var3 == var10.field573) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class25();
         var9.field586 = var0;
         var9.field573 = var3;
         var9.field574 = var1;
         var9.field581 = var2;
         class101.method1916(var9);
         Client.field370.method2376(var9);
      }

      var9.field579 = var4;
      var9.field572 = var5;
      var9.field580 = var6;
      var9.field582 = var7;
      var9.field578 = var8;
   }

   @ObfuscatedName("cc")
   @ObfuscatedSignature(
      signature = "(LWidget;IIB)V",
      garbageValue = "115"
   )
   static final void method1121(Widget var0, int var1, int var2) {
      if(var0.field2211 == 1) {
         class184.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var16;
      if(var0.field2211 == 2 && !Client.field523) {
         var16 = class142.method2644(var0);
         if(null != var16) {
            class184.addMenuEntry(var16, class155.method2949('\uff00') + var0.field2272, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2211 == 3) {
         class184.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2211 == 4) {
         class184.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2211 == 5) {
         class184.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2211 == 6 && null == Client.field450) {
         class184.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var3;
      int var4;
      int var5;
      if(var0.type == 2) {
         var3 = 0;

         for(var4 = 0; var4 < var0.height; ++var4) {
            for(var5 = 0; var5 < var0.width; ++var5) {
               int var6 = var5 * (var0.field2274 + 32);
               int var7 = var4 * (var0.field2228 + 32);
               if(var3 < 20) {
                  var6 += var0.field2261[var3];
                  var7 += var0.field2277[var3];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < var6 + 32 && var2 < 32 + var7) {
                  Client.field404 = var3;
                  class156.field2119 = var0;
                  if(var0.itemIds[var3] > 0) {
                     label361: {
                        ItemComposition var8 = class7.getItemDefinition(var0.itemIds[var3] - 1);
                        int var10;
                        boolean var17;
                        if(Client.field526 == 1) {
                           var10 = class143.method2647(var0);
                           var17 = (var10 >> 30 & 1) != 0;
                           if(var17) {
                              if(ObjectComposition.field2941 != var0.id || class10.field103 != var3) {
                                 class184.addMenuEntry("Use", Client.field375 + " " + "->" + " " + class155.method2949(16748608) + var8.name, 31, var8.id, var3, var0.id);
                              }
                              break label361;
                           }
                        }

                        if(Client.field523) {
                           var10 = class143.method2647(var0);
                           var17 = (var10 >> 30 & 1) != 0;
                           if(var17) {
                              if((class187.field2780 & 16) == 16) {
                                 class184.addMenuEntry(Client.field444, Client.field327 + " " + "->" + " " + class155.method2949(16748608) + var8.name, 32, var8.id, var3, var0.id);
                              }
                              break label361;
                           }
                        }

                        String[] var9 = var8.inventoryActions;
                        if(Client.field570) {
                           var9 = class139.method2591(var9);
                        }

                        int var11 = class143.method2647(var0);
                        boolean var21 = (var11 >> 30 & 1) != 0;
                        if(var21) {
                           for(int var12 = 4; var12 >= 3; --var12) {
                              if(null != var9 && var9[var12] != null) {
                                 byte var13;
                                 if(var12 == 3) {
                                    var13 = 36;
                                 } else {
                                    var13 = 37;
                                 }

                                 class184.addMenuEntry(var9[var12], class155.method2949(16748608) + var8.name, var13, var8.id, var3, var0.id);
                              } else if(var12 == 4) {
                                 class184.addMenuEntry("Drop", class155.method2949(16748608) + var8.name, 37, var8.id, var3, var0.id);
                              }
                           }
                        }

                        Object var10000 = null;
                        if(class162.method3012(class143.method2647(var0))) {
                           class184.addMenuEntry("Use", class155.method2949(16748608) + var8.name, 38, var8.id, var3, var0.id);
                        }

                        int var23 = class143.method2647(var0);
                        boolean var22 = (var23 >> 30 & 1) != 0;
                        int var14;
                        byte var15;
                        if(var22 && var9 != null) {
                           for(var14 = 2; var14 >= 0; --var14) {
                              if(var9[var14] != null) {
                                 var15 = 0;
                                 if(var14 == 0) {
                                    var15 = 33;
                                 }

                                 if(var14 == 1) {
                                    var15 = 34;
                                 }

                                 if(var14 == 2) {
                                    var15 = 35;
                                 }

                                 class184.addMenuEntry(var9[var14], class155.method2949(16748608) + var8.name, var15, var8.id, var3, var0.id);
                              }
                           }
                        }

                        var9 = var0.field2279;
                        if(Client.field570) {
                           var9 = class139.method2591(var9);
                        }

                        if(null != var9) {
                           for(var14 = 4; var14 >= 0; --var14) {
                              if(var9[var14] != null) {
                                 var15 = 0;
                                 if(var14 == 0) {
                                    var15 = 39;
                                 }

                                 if(var14 == 1) {
                                    var15 = 40;
                                 }

                                 if(var14 == 2) {
                                    var15 = 41;
                                 }

                                 if(var14 == 3) {
                                    var15 = 42;
                                 }

                                 if(var14 == 4) {
                                    var15 = 43;
                                 }

                                 class184.addMenuEntry(var9[var14], class155.method2949(16748608) + var8.name, var15, var8.id, var3, var0.id);
                              }
                           }
                        }

                        class184.addMenuEntry("Examine", class155.method2949(16748608) + var8.name, 1005, var8.id, var3, var0.id);
                     }
                  }
               }

               ++var3;
            }
         }
      }

      if(var0.field2198) {
         if(Client.field523) {
            if(class45.method792(class143.method2647(var0)) && (class187.field2780 & 32) == 32) {
               class184.addMenuEntry(Client.field444, Client.field327 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var3 = 9; var3 >= 5; --var3) {
               String var18 = class41.method761(var0, var3);
               if(null != var18) {
                  class184.addMenuEntry(var18, var0.name, 1007, var3 + 1, var0.index, var0.id);
               }
            }

            var16 = class142.method2644(var0);
            if(var16 != null) {
               class184.addMenuEntry(var16, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var4 = 4; var4 >= 0; --var4) {
               String var19 = class41.method761(var0, var4);
               if(var19 != null) {
                  class184.addMenuEntry(var19, var0.name, 57, 1 + var4, var0.index, var0.id);
               }
            }

            var5 = class143.method2647(var0);
            boolean var20 = (var5 & 1) != 0;
            if(var20) {
               class184.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }
}
