import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public final class class137 implements KeyListener, FocusListener {
   @ObfuscatedName("cq")
   @ObfuscatedGetter(
      intValue = -1351088807
   )
   static int field2116 = 0;
   @ObfuscatedName("cf")
   @ObfuscatedGetter(
      intValue = -1355258317
   )
   public static int field2118;
   @ObfuscatedName("cd")
   static int[] field2121 = new int[128];
   @ObfuscatedName("cx")
   static int[] field2122 = new int[128];
   @ObfuscatedName("cn")
   @ObfuscatedGetter(
      intValue = 476989445
   )
   static int field2125 = 0;
   @ObfuscatedName("cr")
   public static int[] field2130 = new int[128];
   @ObfuscatedName("w")
   public static class137 field2131 = new class137();
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = -1920501089
   )
   public static int field2133 = 0;
   @ObfuscatedName("ct")
   static char[] field2134 = new char[128];
   @ObfuscatedName("cy")
   public static boolean[] field2135 = new boolean[112];
   @ObfuscatedName("cp")
   @ObfuscatedGetter(
      intValue = 2144045051
   )
   public static int field2137 = 0;
   @ObfuscatedName("ce")
   @ObfuscatedGetter(
      intValue = 946852671
   )
   static int field2138 = 0;
   @ObfuscatedName("cu")
   public static int[] field2139 = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, 85, 80, 84, -1, 91, -1, -1, -1, 81, 82, 86, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, 83, 104, 105, 103, 102, 96, 98, 97, 99, -1, -1, -1, -1, -1, -1, -1, 25, 16, 17, 18, 19, 20, 21, 22, 23, 24, -1, -1, -1, -1, -1, -1, -1, 48, 68, 66, 50, 34, 51, 52, 53, 39, 54, 55, 56, 70, 69, 40, 41, 32, 35, 49, 36, 38, 67, 33, 65, 37, 64, -1, -1, -1, -1, -1, 228, 231, 227, 233, 224, 219, 225, 230, 226, 232, 89, 87, -1, 88, 229, 90, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, -1, -1, -1, 101, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 100, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
   @ObfuscatedName("cg")
   @ObfuscatedGetter(
      intValue = -1934100431
   )
   static int field2140 = 0;
   @ObfuscatedName("cj")
   @ObfuscatedGetter(
      intValue = 1923749687
   )
   public static volatile int field2141 = 0;
   @ObfuscatedName("nh")
   @ObfuscatedGetter(
      intValue = -1662555315
   )
   static int field2143;
   @ObfuscatedName("y")
   static byte[][][] field2147;

   @ObfuscatedName("ch")
   static final String[] method2910(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(null != var0 && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   public final synchronized void keyPressed(KeyEvent var1) {
      if(field2131 != null) {
         field2141 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2139.length) {
            var2 = field2139[var2];
            if((var2 & 128) != 0) {
               var2 = -1;
            }
         } else {
            var2 = -1;
         }

         if(field2133 >= 0 && var2 >= 0) {
            field2121[field2133] = var2;
            field2133 = 1 + field2133 & 127;
            if(field2125 == field2133) {
               field2133 = -1;
            }
         }

         int var3;
         if(var2 >= 0) {
            var3 = field2116 + 1 & 127;
            if(field2138 != var3) {
               field2122[field2116] = var2;
               field2134[field2116] = 0;
               field2116 = var3;
            }
         }

         var3 = var1.getModifiers();
         if(0 != (var3 & 10) || var2 == 85 || 10 == var2) {
            var1.consume();
         }
      }

   }

   public final synchronized void keyReleased(KeyEvent var1) {
      if(null != field2131) {
         field2141 = 0;
         int var2 = var1.getKeyCode();
         if(var2 >= 0 && var2 < field2139.length) {
            var2 = field2139[var2] & -129;
         } else {
            var2 = -1;
         }

         if(field2133 >= 0 && var2 >= 0) {
            field2121[field2133] = ~var2;
            field2133 = 1 + field2133 & 127;
            if(field2125 == field2133) {
               field2133 = -1;
            }
         }
      }

      var1.consume();
   }

   public final void keyTyped(KeyEvent var1) {
      if(null != field2131) {
         char var2 = var1.getKeyChar();
         if(var2 != 0 && '\uffff' != var2) {
            boolean var3;
            if(var2 > 0 && var2 < 128 || var2 >= 160 && var2 <= 255) {
               var3 = true;
            } else {
               label71: {
                  if(0 != var2) {
                     char[] var4 = class165.field2681;

                     for(int var5 = 0; var5 < var4.length; ++var5) {
                        char var6 = var4[var5];
                        if(var2 == var6) {
                           var3 = true;
                           break label71;
                        }
                     }
                  }

                  var3 = false;
               }
            }

            if(var3) {
               int var7 = field2116 + 1 & 127;
               if(var7 != field2138) {
                  field2122[field2116] = -1;
                  field2134[field2116] = var2;
                  field2116 = var7;
               }
            }
         }
      }

      var1.consume();
   }

   public final void focusGained(FocusEvent var1) {
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(Lclass39;IIII)V",
      garbageValue = "-331888263"
   )
   static final void method2924(class39 var0, int var1, int var2, int var3) {
      if(client.field435 < 400) {
         if(var0.field915 != null) {
            var0 = var0.method793();
         }

         if(var0 != null) {
            if(var0.field896) {
               if(!var0.field920 || var1 == client.field462) {
                  String var4 = var0.field890;
                  int var8;
                  if(var0.field899 != 0) {
                     int var7 = var0.field899;
                     var8 = class167.field2692.field50;
                     int var9 = var8 - var7;
                     String var6;
                     if(var9 < -9) {
                        var6 = class72.method1574(16711680);
                     } else if(var9 < -6) {
                        var6 = class72.method1574(16723968);
                     } else if(var9 < -3) {
                        var6 = class72.method1574(16740352);
                     } else if(var9 < 0) {
                        var6 = class72.method1574(16756736);
                     } else if(var9 > 9) {
                        var6 = class72.method1574('\uff00');
                     } else if(var9 > 6) {
                        var6 = class72.method1574(4259584);
                     } else if(var9 > 3) {
                        var6 = class72.method1574(8453888);
                     } else if(var9 > 0) {
                        var6 = class72.method1574(12648192);
                     } else {
                        var6 = class72.method1574(16776960);
                     }

                     var4 = var4 + var6 + " " + " (" + "level-" + var0.field899 + ")";
                  }

                  if(client.field381 == 1) {
                     class75.method1625("Use", client.field366 + " " + "->" + " " + class72.method1574(16776960) + var4, 7, var1, var2, var3);
                  } else if(client.field573) {
                     if((class1.field20 & 2) == 2) {
                        class75.method1625(client.field315, client.field453 + " " + "->" + " " + class72.method1574(16776960) + var4, 8, var1, var2, var3);
                     }
                  } else {
                     String[] var5 = var0.field893;
                     if(client.field465) {
                        var5 = method2910(var5);
                     }

                     int var11;
                     if(null != var5) {
                        for(var11 = 4; var11 >= 0; --var11) {
                           if(var5[var11] != null && !var5[var11].equalsIgnoreCase("Attack")) {
                              byte var10 = 0;
                              if(var11 == 0) {
                                 var10 = 9;
                              }

                              if(1 == var11) {
                                 var10 = 10;
                              }

                              if(2 == var11) {
                                 var10 = 11;
                              }

                              if(var11 == 3) {
                                 var10 = 12;
                              }

                              if(var11 == 4) {
                                 var10 = 13;
                              }

                              class75.method1625(var5[var11], class72.method1574(16776960) + var4, var10, var1, var2, var3);
                           }
                        }
                     }

                     if(var5 != null) {
                        for(var11 = 4; var11 >= 0; --var11) {
                           if(var5[var11] != null && var5[var11].equalsIgnoreCase("Attack")) {
                              short var12 = 0;
                              if(class20.field586 != client.field322) {
                                 if(class20.field579 == client.field322 || class20.field578 == client.field322 && var0.field899 > class167.field2692.field50) {
                                    var12 = 2000;
                                 }

                                 var8 = 0;
                                 if(0 == var11) {
                                    var8 = var12 + 9;
                                 }

                                 if(1 == var11) {
                                    var8 = 10 + var12;
                                 }

                                 if(var11 == 2) {
                                    var8 = var12 + 11;
                                 }

                                 if(3 == var11) {
                                    var8 = var12 + 12;
                                 }

                                 if(var11 == 4) {
                                    var8 = 13 + var12;
                                 }

                                 class75.method1625(var5[var11], class72.method1574(16776960) + var4, var8, var1, var2, var3);
                              }
                           }
                        }
                     }

                     class75.method1625("Examine", class72.method1574(16776960) + var4, 1003, var1, var2, var3);
                  }

               }
            }
         }
      }
   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(field2131 != null) {
         field2133 = -1;
      }

   }
}
