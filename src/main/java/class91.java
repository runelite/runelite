import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("ck")
public class class91 extends class79 {
   @ObfuscatedName("x")
   static boolean field1572 = false;
   @ObfuscatedName("ai")
   public static int[] field1573 = new int[2048];
   @ObfuscatedName("p")
   public static boolean field1574 = true;
   @ObfuscatedName("e")
   static int field1575 = 0;
   @ObfuscatedName("t")
   static boolean field1578 = false;
   @ObfuscatedName("l")
   public static int field1580 = 512;
   @ObfuscatedName("w")
   static boolean field1581 = false;
   @ObfuscatedName("ar")
   static int[] field1582 = new int[512];
   @ObfuscatedName("h")
   static int field1583;
   @ObfuscatedName("k")
   static int field1584;
   @ObfuscatedName("f")
   static int field1585;
   @ObfuscatedName("r")
   static int field1586;
   @ObfuscatedName("n")
   static int field1587;
   @ObfuscatedName("g")
   static int field1588;
   @ObfuscatedName("s")
   static int field1589;
   @ObfuscatedName("af")
   public static int[] field1590 = new int[65536];
   @ObfuscatedName("am")
   public static class92 field1591;
   @ObfuscatedName("z")
   static int field1592;
   @ObfuscatedName("ay")
   static int[] field1593 = new int[2048];
   @ObfuscatedName("b")
   static int[] field1594 = new int[1024];
   @ObfuscatedName("ab")
   public static int[] field1595 = new int[2048];

   @ObfuscatedName("z")
   static final void method2081(int[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(field1581) {
         if(var5 > field1583) {
            var5 = field1583;
         }

         if(var4 < 0) {
            var4 = 0;
         }
      }

      if(var4 < var5) {
         var1 += var4;
         var6 += var7 * var4;
         int var8;
         int var9;
         int var10;
         if(field1574) {
            var3 = var5 - var4 >> 2;
            var7 <<= 2;
            if(field1575 == 0) {
               if(var3 > 0) {
                  do {
                     var2 = field1590[var6 >> 8];
                     var6 += var7;
                     var0[var1++] = var2;
                     var0[var1++] = var2;
                     var0[var1++] = var2;
                     var0[var1++] = var2;
                     --var3;
                  } while(var3 > 0);
               }

               var3 = var5 - var4 & 3;
               if(var3 > 0) {
                  var2 = field1590[var6 >> 8];

                  do {
                     var0[var1++] = var2;
                     --var3;
                  } while(var3 > 0);
               }
            } else {
               var8 = field1575;
               var9 = 256 - field1575;
               if(var3 > 0) {
                  do {
                     var2 = field1590[var6 >> 8];
                     var6 += var7;
                     var2 = ((var2 & 16711935) * var9 >> 8 & 16711935) + ((var2 & '\uff00') * var9 >> 8 & '\uff00');
                     var10 = var0[var1];
                     var0[var1++] = var2 + ((var10 & 16711935) * var8 >> 8 & 16711935) + ((var10 & '\uff00') * var8 >> 8 & '\uff00');
                     var10 = var0[var1];
                     var0[var1++] = var2 + ((var10 & 16711935) * var8 >> 8 & 16711935) + ((var10 & '\uff00') * var8 >> 8 & '\uff00');
                     var10 = var0[var1];
                     var0[var1++] = var2 + ((var10 & 16711935) * var8 >> 8 & 16711935) + ((var10 & '\uff00') * var8 >> 8 & '\uff00');
                     var10 = var0[var1];
                     var0[var1++] = var2 + ((var10 & 16711935) * var8 >> 8 & 16711935) + ((var10 & '\uff00') * var8 >> 8 & '\uff00');
                     --var3;
                  } while(var3 > 0);
               }

               var3 = var5 - var4 & 3;
               if(var3 > 0) {
                  var2 = field1590[var6 >> 8];
                  var2 = ((var2 & 16711935) * var9 >> 8 & 16711935) + ((var2 & '\uff00') * var9 >> 8 & '\uff00');

                  do {
                     var10 = var0[var1];
                     var0[var1++] = var2 + ((var10 & 16711935) * var8 >> 8 & 16711935) + ((var10 & '\uff00') * var8 >> 8 & '\uff00');
                     --var3;
                  } while(var3 > 0);
               }
            }

         } else {
            var3 = var5 - var4;
            if(field1575 == 0) {
               do {
                  var0[var1++] = field1590[var6 >> 8];
                  var6 += var7;
                  --var3;
               } while(var3 > 0);
            } else {
               var8 = field1575;
               var9 = 256 - field1575;

               do {
                  var2 = field1590[var6 >> 8];
                  var6 += var7;
                  var2 = ((var2 & 16711935) * var9 >> 8 & 16711935) + ((var2 & '\uff00') * var9 >> 8 & '\uff00');
                  var10 = var0[var1];
                  var0[var1++] = var2 + ((var10 & 16711935) * var8 >> 8 & 16711935) + ((var10 & '\uff00') * var8 >> 8 & '\uff00');
                  --var3;
               } while(var3 > 0);
            }

         }
      }
   }

   @ObfuscatedName("w")
   public static final void method2082() {
      method2083(class79.field1419, class79.field1418, class79.field1417, class79.field1413);
   }

   @ObfuscatedName("x")
   static final void method2083(int var0, int var1, int var2, int var3) {
      field1583 = var2 - var0;
      field1584 = var3 - var1;
      method2084();
      if(field1594.length < field1584) {
         field1594 = new int[class126.method2812(field1584)];
      }

      int var4 = var1 * class79.field1414 + var0;

      for(int var5 = 0; var5 < field1584; ++var5) {
         field1594[var5] = var4;
         var4 += class79.field1414;
      }

   }

   @ObfuscatedName("t")
   public static final void method2084() {
      field1592 = field1583 / 2;
      field1589 = field1584 / 2;
      field1585 = -field1592;
      field1586 = field1583 - field1592;
      field1587 = -field1589;
      field1588 = field1584 - field1589;
   }

   @ObfuscatedName("y")
   public static final void method2087(double var0) {
      method2124(var0, 0, 512);
   }

   @ObfuscatedName("c")
   static int method2089(int var0, double var1) {
      double var3 = (double)(var0 >> 16) / 256.0D;
      double var5 = (double)(var0 >> 8 & 255) / 256.0D;
      double var7 = (double)(var0 & 255) / 256.0D;
      var3 = Math.pow(var3, var1);
      var5 = Math.pow(var5, var1);
      var7 = Math.pow(var7, var1);
      int var9 = (int)(var3 * 256.0D);
      int var10 = (int)(var5 * 256.0D);
      int var11 = (int)(var7 * 256.0D);
      return (var9 << 16) + (var10 << 8) + var11;
   }

   @ObfuscatedName("l")
   static final void method2091(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      int var9 = var4 - var3;
      int var10 = var1 - var0;
      int var11 = var5 - var3;
      int var12 = var2 - var0;
      int var13 = var7 - var6;
      int var14 = var8 - var6;
      int var15;
      if(var2 != var1) {
         var15 = (var5 - var4 << 14) / (var2 - var1);
      } else {
         var15 = 0;
      }

      int var16;
      if(var1 != var0) {
         var16 = (var9 << 14) / var10;
      } else {
         var16 = 0;
      }

      int var17;
      if(var2 != var0) {
         var17 = (var11 << 14) / var12;
      } else {
         var17 = 0;
      }

      int var18 = var9 * var12 - var11 * var10;
      if(var18 != 0) {
         int var19 = (var13 * var12 - var14 * var10 << 8) / var18;
         int var20 = (var14 * var9 - var13 * var11 << 8) / var18;
         if(var0 <= var1 && var0 <= var2) {
            if(var0 < field1584) {
               if(var1 > field1584) {
                  var1 = field1584;
               }

               if(var2 > field1584) {
                  var2 = field1584;
               }

               var6 = (var6 << 8) - var19 * var3 + var19;
               if(var1 < var2) {
                  var5 = var3 <<= 14;
                  if(var0 < 0) {
                     var5 -= var17 * var0;
                     var3 -= var16 * var0;
                     var6 -= var20 * var0;
                     var0 = 0;
                  }

                  var4 <<= 14;
                  if(var1 < 0) {
                     var4 -= var15 * var1;
                     var1 = 0;
                  }

                  if(var0 != var1 && var17 < var16 || var0 == var1 && var17 > var15) {
                     var2 -= var1;
                     var1 -= var0;
                     var0 = field1594[var0];

                     while(true) {
                        --var1;
                        if(var1 < 0) {
                           while(true) {
                              --var2;
                              if(var2 < 0) {
                                 return;
                              }

                              method2081(class79.field1416, var0, 0, 0, var5 >> 14, var4 >> 14, var6, var19);
                              var5 += var17;
                              var4 += var15;
                              var6 += var20;
                              var0 += class79.field1414;
                           }
                        }

                        method2081(class79.field1416, var0, 0, 0, var5 >> 14, var3 >> 14, var6, var19);
                        var5 += var17;
                        var3 += var16;
                        var6 += var20;
                        var0 += class79.field1414;
                     }
                  } else {
                     var2 -= var1;
                     var1 -= var0;
                     var0 = field1594[var0];

                     while(true) {
                        --var1;
                        if(var1 < 0) {
                           while(true) {
                              --var2;
                              if(var2 < 0) {
                                 return;
                              }

                              method2081(class79.field1416, var0, 0, 0, var4 >> 14, var5 >> 14, var6, var19);
                              var5 += var17;
                              var4 += var15;
                              var6 += var20;
                              var0 += class79.field1414;
                           }
                        }

                        method2081(class79.field1416, var0, 0, 0, var3 >> 14, var5 >> 14, var6, var19);
                        var5 += var17;
                        var3 += var16;
                        var6 += var20;
                        var0 += class79.field1414;
                     }
                  }
               } else {
                  var4 = var3 <<= 14;
                  if(var0 < 0) {
                     var4 -= var17 * var0;
                     var3 -= var16 * var0;
                     var6 -= var20 * var0;
                     var0 = 0;
                  }

                  var5 <<= 14;
                  if(var2 < 0) {
                     var5 -= var15 * var2;
                     var2 = 0;
                  }

                  if(var0 != var2 && var17 < var16 || var0 == var2 && var15 > var16) {
                     var1 -= var2;
                     var2 -= var0;
                     var0 = field1594[var0];

                     while(true) {
                        --var2;
                        if(var2 < 0) {
                           while(true) {
                              --var1;
                              if(var1 < 0) {
                                 return;
                              }

                              method2081(class79.field1416, var0, 0, 0, var5 >> 14, var3 >> 14, var6, var19);
                              var5 += var15;
                              var3 += var16;
                              var6 += var20;
                              var0 += class79.field1414;
                           }
                        }

                        method2081(class79.field1416, var0, 0, 0, var4 >> 14, var3 >> 14, var6, var19);
                        var4 += var17;
                        var3 += var16;
                        var6 += var20;
                        var0 += class79.field1414;
                     }
                  } else {
                     var1 -= var2;
                     var2 -= var0;
                     var0 = field1594[var0];

                     while(true) {
                        --var2;
                        if(var2 < 0) {
                           while(true) {
                              --var1;
                              if(var1 < 0) {
                                 return;
                              }

                              method2081(class79.field1416, var0, 0, 0, var3 >> 14, var5 >> 14, var6, var19);
                              var5 += var15;
                              var3 += var16;
                              var6 += var20;
                              var0 += class79.field1414;
                           }
                        }

                        method2081(class79.field1416, var0, 0, 0, var3 >> 14, var4 >> 14, var6, var19);
                        var4 += var17;
                        var3 += var16;
                        var6 += var20;
                        var0 += class79.field1414;
                     }
                  }
               }
            }
         } else if(var1 <= var2) {
            if(var1 < field1584) {
               if(var2 > field1584) {
                  var2 = field1584;
               }

               if(var0 > field1584) {
                  var0 = field1584;
               }

               var7 = (var7 << 8) - var19 * var4 + var19;
               if(var2 < var0) {
                  var3 = var4 <<= 14;
                  if(var1 < 0) {
                     var3 -= var16 * var1;
                     var4 -= var15 * var1;
                     var7 -= var20 * var1;
                     var1 = 0;
                  }

                  var5 <<= 14;
                  if(var2 < 0) {
                     var5 -= var17 * var2;
                     var2 = 0;
                  }

                  if(var1 != var2 && var16 < var15 || var1 == var2 && var16 > var17) {
                     var0 -= var2;
                     var2 -= var1;
                     var1 = field1594[var1];

                     while(true) {
                        --var2;
                        if(var2 < 0) {
                           while(true) {
                              --var0;
                              if(var0 < 0) {
                                 return;
                              }

                              method2081(class79.field1416, var1, 0, 0, var3 >> 14, var5 >> 14, var7, var19);
                              var3 += var16;
                              var5 += var17;
                              var7 += var20;
                              var1 += class79.field1414;
                           }
                        }

                        method2081(class79.field1416, var1, 0, 0, var3 >> 14, var4 >> 14, var7, var19);
                        var3 += var16;
                        var4 += var15;
                        var7 += var20;
                        var1 += class79.field1414;
                     }
                  } else {
                     var0 -= var2;
                     var2 -= var1;
                     var1 = field1594[var1];

                     while(true) {
                        --var2;
                        if(var2 < 0) {
                           while(true) {
                              --var0;
                              if(var0 < 0) {
                                 return;
                              }

                              method2081(class79.field1416, var1, 0, 0, var5 >> 14, var3 >> 14, var7, var19);
                              var3 += var16;
                              var5 += var17;
                              var7 += var20;
                              var1 += class79.field1414;
                           }
                        }

                        method2081(class79.field1416, var1, 0, 0, var4 >> 14, var3 >> 14, var7, var19);
                        var3 += var16;
                        var4 += var15;
                        var7 += var20;
                        var1 += class79.field1414;
                     }
                  }
               } else {
                  var5 = var4 <<= 14;
                  if(var1 < 0) {
                     var5 -= var16 * var1;
                     var4 -= var15 * var1;
                     var7 -= var20 * var1;
                     var1 = 0;
                  }

                  var3 <<= 14;
                  if(var0 < 0) {
                     var3 -= var17 * var0;
                     var0 = 0;
                  }

                  if(var16 < var15) {
                     var2 -= var0;
                     var0 -= var1;
                     var1 = field1594[var1];

                     while(true) {
                        --var0;
                        if(var0 < 0) {
                           while(true) {
                              --var2;
                              if(var2 < 0) {
                                 return;
                              }

                              method2081(class79.field1416, var1, 0, 0, var3 >> 14, var4 >> 14, var7, var19);
                              var3 += var17;
                              var4 += var15;
                              var7 += var20;
                              var1 += class79.field1414;
                           }
                        }

                        method2081(class79.field1416, var1, 0, 0, var5 >> 14, var4 >> 14, var7, var19);
                        var5 += var16;
                        var4 += var15;
                        var7 += var20;
                        var1 += class79.field1414;
                     }
                  } else {
                     var2 -= var0;
                     var0 -= var1;
                     var1 = field1594[var1];

                     while(true) {
                        --var0;
                        if(var0 < 0) {
                           while(true) {
                              --var2;
                              if(var2 < 0) {
                                 return;
                              }

                              method2081(class79.field1416, var1, 0, 0, var4 >> 14, var3 >> 14, var7, var19);
                              var3 += var17;
                              var4 += var15;
                              var7 += var20;
                              var1 += class79.field1414;
                           }
                        }

                        method2081(class79.field1416, var1, 0, 0, var4 >> 14, var5 >> 14, var7, var19);
                        var5 += var16;
                        var4 += var15;
                        var7 += var20;
                        var1 += class79.field1414;
                     }
                  }
               }
            }
         } else if(var2 < field1584) {
            if(var0 > field1584) {
               var0 = field1584;
            }

            if(var1 > field1584) {
               var1 = field1584;
            }

            var8 = (var8 << 8) - var19 * var5 + var19;
            if(var0 < var1) {
               var4 = var5 <<= 14;
               if(var2 < 0) {
                  var4 -= var15 * var2;
                  var5 -= var17 * var2;
                  var8 -= var20 * var2;
                  var2 = 0;
               }

               var3 <<= 14;
               if(var0 < 0) {
                  var3 -= var16 * var0;
                  var0 = 0;
               }

               if(var15 < var17) {
                  var1 -= var0;
                  var0 -= var2;
                  var2 = field1594[var2];

                  while(true) {
                     --var0;
                     if(var0 < 0) {
                        while(true) {
                           --var1;
                           if(var1 < 0) {
                              return;
                           }

                           method2081(class79.field1416, var2, 0, 0, var4 >> 14, var3 >> 14, var8, var19);
                           var4 += var15;
                           var3 += var16;
                           var8 += var20;
                           var2 += class79.field1414;
                        }
                     }

                     method2081(class79.field1416, var2, 0, 0, var4 >> 14, var5 >> 14, var8, var19);
                     var4 += var15;
                     var5 += var17;
                     var8 += var20;
                     var2 += class79.field1414;
                  }
               } else {
                  var1 -= var0;
                  var0 -= var2;
                  var2 = field1594[var2];

                  while(true) {
                     --var0;
                     if(var0 < 0) {
                        while(true) {
                           --var1;
                           if(var1 < 0) {
                              return;
                           }

                           method2081(class79.field1416, var2, 0, 0, var3 >> 14, var4 >> 14, var8, var19);
                           var4 += var15;
                           var3 += var16;
                           var8 += var20;
                           var2 += class79.field1414;
                        }
                     }

                     method2081(class79.field1416, var2, 0, 0, var5 >> 14, var4 >> 14, var8, var19);
                     var4 += var15;
                     var5 += var17;
                     var8 += var20;
                     var2 += class79.field1414;
                  }
               }
            } else {
               var3 = var5 <<= 14;
               if(var2 < 0) {
                  var3 -= var15 * var2;
                  var5 -= var17 * var2;
                  var8 -= var20 * var2;
                  var2 = 0;
               }

               var4 <<= 14;
               if(var1 < 0) {
                  var4 -= var16 * var1;
                  var1 = 0;
               }

               if(var15 < var17) {
                  var0 -= var1;
                  var1 -= var2;
                  var2 = field1594[var2];

                  while(true) {
                     --var1;
                     if(var1 < 0) {
                        while(true) {
                           --var0;
                           if(var0 < 0) {
                              return;
                           }

                           method2081(class79.field1416, var2, 0, 0, var4 >> 14, var5 >> 14, var8, var19);
                           var4 += var16;
                           var5 += var17;
                           var8 += var20;
                           var2 += class79.field1414;
                        }
                     }

                     method2081(class79.field1416, var2, 0, 0, var3 >> 14, var5 >> 14, var8, var19);
                     var3 += var15;
                     var5 += var17;
                     var8 += var20;
                     var2 += class79.field1414;
                  }
               } else {
                  var0 -= var1;
                  var1 -= var2;
                  var2 = field1594[var2];

                  while(true) {
                     --var1;
                     if(var1 < 0) {
                        while(true) {
                           --var0;
                           if(var0 < 0) {
                              return;
                           }

                           method2081(class79.field1416, var2, 0, 0, var5 >> 14, var4 >> 14, var8, var19);
                           var4 += var16;
                           var5 += var17;
                           var8 += var20;
                           var2 += class79.field1414;
                        }
                     }

                     method2081(class79.field1416, var2, 0, 0, var5 >> 14, var3 >> 14, var8, var19);
                     var3 += var15;
                     var5 += var17;
                     var8 += var20;
                     var2 += class79.field1414;
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("s")
   public static final void method2093(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = 0;
      if(var1 != var0) {
         var7 = (var4 - var3 << 14) / (var1 - var0);
      }

      int var8 = 0;
      if(var2 != var1) {
         var8 = (var5 - var4 << 14) / (var2 - var1);
      }

      int var9 = 0;
      if(var2 != var0) {
         var9 = (var3 - var5 << 14) / (var0 - var2);
      }

      if(var0 <= var1 && var0 <= var2) {
         if(var0 < field1584) {
            if(var1 > field1584) {
               var1 = field1584;
            }

            if(var2 > field1584) {
               var2 = field1584;
            }

            if(var1 < var2) {
               var5 = var3 <<= 14;
               if(var0 < 0) {
                  var5 -= var9 * var0;
                  var3 -= var7 * var0;
                  var0 = 0;
               }

               var4 <<= 14;
               if(var1 < 0) {
                  var4 -= var8 * var1;
                  var1 = 0;
               }

               if(var0 != var1 && var9 < var7 || var0 == var1 && var9 > var8) {
                  var2 -= var1;
                  var1 -= var0;
                  var0 = field1594[var0];

                  while(true) {
                     --var1;
                     if(var1 < 0) {
                        while(true) {
                           --var2;
                           if(var2 < 0) {
                              return;
                           }

                           method2133(class79.field1416, var0, var6, 0, var5 >> 14, var4 >> 14);
                           var5 += var9;
                           var4 += var8;
                           var0 += class79.field1414;
                        }
                     }

                     method2133(class79.field1416, var0, var6, 0, var5 >> 14, var3 >> 14);
                     var5 += var9;
                     var3 += var7;
                     var0 += class79.field1414;
                  }
               } else {
                  var2 -= var1;
                  var1 -= var0;
                  var0 = field1594[var0];

                  while(true) {
                     --var1;
                     if(var1 < 0) {
                        while(true) {
                           --var2;
                           if(var2 < 0) {
                              return;
                           }

                           method2133(class79.field1416, var0, var6, 0, var4 >> 14, var5 >> 14);
                           var5 += var9;
                           var4 += var8;
                           var0 += class79.field1414;
                        }
                     }

                     method2133(class79.field1416, var0, var6, 0, var3 >> 14, var5 >> 14);
                     var5 += var9;
                     var3 += var7;
                     var0 += class79.field1414;
                  }
               }
            } else {
               var4 = var3 <<= 14;
               if(var0 < 0) {
                  var4 -= var9 * var0;
                  var3 -= var7 * var0;
                  var0 = 0;
               }

               var5 <<= 14;
               if(var2 < 0) {
                  var5 -= var8 * var2;
                  var2 = 0;
               }

               if(var0 != var2 && var9 < var7 || var0 == var2 && var8 > var7) {
                  var1 -= var2;
                  var2 -= var0;
                  var0 = field1594[var0];

                  while(true) {
                     --var2;
                     if(var2 < 0) {
                        while(true) {
                           --var1;
                           if(var1 < 0) {
                              return;
                           }

                           method2133(class79.field1416, var0, var6, 0, var5 >> 14, var3 >> 14);
                           var5 += var8;
                           var3 += var7;
                           var0 += class79.field1414;
                        }
                     }

                     method2133(class79.field1416, var0, var6, 0, var4 >> 14, var3 >> 14);
                     var4 += var9;
                     var3 += var7;
                     var0 += class79.field1414;
                  }
               } else {
                  var1 -= var2;
                  var2 -= var0;
                  var0 = field1594[var0];

                  while(true) {
                     --var2;
                     if(var2 < 0) {
                        while(true) {
                           --var1;
                           if(var1 < 0) {
                              return;
                           }

                           method2133(class79.field1416, var0, var6, 0, var3 >> 14, var5 >> 14);
                           var5 += var8;
                           var3 += var7;
                           var0 += class79.field1414;
                        }
                     }

                     method2133(class79.field1416, var0, var6, 0, var3 >> 14, var4 >> 14);
                     var4 += var9;
                     var3 += var7;
                     var0 += class79.field1414;
                  }
               }
            }
         }
      } else if(var1 <= var2) {
         if(var1 < field1584) {
            if(var2 > field1584) {
               var2 = field1584;
            }

            if(var0 > field1584) {
               var0 = field1584;
            }

            if(var2 < var0) {
               var3 = var4 <<= 14;
               if(var1 < 0) {
                  var3 -= var7 * var1;
                  var4 -= var8 * var1;
                  var1 = 0;
               }

               var5 <<= 14;
               if(var2 < 0) {
                  var5 -= var9 * var2;
                  var2 = 0;
               }

               if(var1 != var2 && var7 < var8 || var1 == var2 && var7 > var9) {
                  var0 -= var2;
                  var2 -= var1;
                  var1 = field1594[var1];

                  while(true) {
                     --var2;
                     if(var2 < 0) {
                        while(true) {
                           --var0;
                           if(var0 < 0) {
                              return;
                           }

                           method2133(class79.field1416, var1, var6, 0, var3 >> 14, var5 >> 14);
                           var3 += var7;
                           var5 += var9;
                           var1 += class79.field1414;
                        }
                     }

                     method2133(class79.field1416, var1, var6, 0, var3 >> 14, var4 >> 14);
                     var3 += var7;
                     var4 += var8;
                     var1 += class79.field1414;
                  }
               } else {
                  var0 -= var2;
                  var2 -= var1;
                  var1 = field1594[var1];

                  while(true) {
                     --var2;
                     if(var2 < 0) {
                        while(true) {
                           --var0;
                           if(var0 < 0) {
                              return;
                           }

                           method2133(class79.field1416, var1, var6, 0, var5 >> 14, var3 >> 14);
                           var3 += var7;
                           var5 += var9;
                           var1 += class79.field1414;
                        }
                     }

                     method2133(class79.field1416, var1, var6, 0, var4 >> 14, var3 >> 14);
                     var3 += var7;
                     var4 += var8;
                     var1 += class79.field1414;
                  }
               }
            } else {
               var5 = var4 <<= 14;
               if(var1 < 0) {
                  var5 -= var7 * var1;
                  var4 -= var8 * var1;
                  var1 = 0;
               }

               var3 <<= 14;
               if(var0 < 0) {
                  var3 -= var9 * var0;
                  var0 = 0;
               }

               if(var7 < var8) {
                  var2 -= var0;
                  var0 -= var1;
                  var1 = field1594[var1];

                  while(true) {
                     --var0;
                     if(var0 < 0) {
                        while(true) {
                           --var2;
                           if(var2 < 0) {
                              return;
                           }

                           method2133(class79.field1416, var1, var6, 0, var3 >> 14, var4 >> 14);
                           var3 += var9;
                           var4 += var8;
                           var1 += class79.field1414;
                        }
                     }

                     method2133(class79.field1416, var1, var6, 0, var5 >> 14, var4 >> 14);
                     var5 += var7;
                     var4 += var8;
                     var1 += class79.field1414;
                  }
               } else {
                  var2 -= var0;
                  var0 -= var1;
                  var1 = field1594[var1];

                  while(true) {
                     --var0;
                     if(var0 < 0) {
                        while(true) {
                           --var2;
                           if(var2 < 0) {
                              return;
                           }

                           method2133(class79.field1416, var1, var6, 0, var4 >> 14, var3 >> 14);
                           var3 += var9;
                           var4 += var8;
                           var1 += class79.field1414;
                        }
                     }

                     method2133(class79.field1416, var1, var6, 0, var4 >> 14, var5 >> 14);
                     var5 += var7;
                     var4 += var8;
                     var1 += class79.field1414;
                  }
               }
            }
         }
      } else if(var2 < field1584) {
         if(var0 > field1584) {
            var0 = field1584;
         }

         if(var1 > field1584) {
            var1 = field1584;
         }

         if(var0 < var1) {
            var4 = var5 <<= 14;
            if(var2 < 0) {
               var4 -= var8 * var2;
               var5 -= var9 * var2;
               var2 = 0;
            }

            var3 <<= 14;
            if(var0 < 0) {
               var3 -= var7 * var0;
               var0 = 0;
            }

            if(var8 < var9) {
               var1 -= var0;
               var0 -= var2;
               var2 = field1594[var2];

               while(true) {
                  --var0;
                  if(var0 < 0) {
                     while(true) {
                        --var1;
                        if(var1 < 0) {
                           return;
                        }

                        method2133(class79.field1416, var2, var6, 0, var4 >> 14, var3 >> 14);
                        var4 += var8;
                        var3 += var7;
                        var2 += class79.field1414;
                     }
                  }

                  method2133(class79.field1416, var2, var6, 0, var4 >> 14, var5 >> 14);
                  var4 += var8;
                  var5 += var9;
                  var2 += class79.field1414;
               }
            } else {
               var1 -= var0;
               var0 -= var2;
               var2 = field1594[var2];

               while(true) {
                  --var0;
                  if(var0 < 0) {
                     while(true) {
                        --var1;
                        if(var1 < 0) {
                           return;
                        }

                        method2133(class79.field1416, var2, var6, 0, var3 >> 14, var4 >> 14);
                        var4 += var8;
                        var3 += var7;
                        var2 += class79.field1414;
                     }
                  }

                  method2133(class79.field1416, var2, var6, 0, var5 >> 14, var4 >> 14);
                  var4 += var8;
                  var5 += var9;
                  var2 += class79.field1414;
               }
            }
         } else {
            var3 = var5 <<= 14;
            if(var2 < 0) {
               var3 -= var8 * var2;
               var5 -= var9 * var2;
               var2 = 0;
            }

            var4 <<= 14;
            if(var1 < 0) {
               var4 -= var7 * var1;
               var1 = 0;
            }

            if(var8 < var9) {
               var0 -= var1;
               var1 -= var2;
               var2 = field1594[var2];

               while(true) {
                  --var1;
                  if(var1 < 0) {
                     while(true) {
                        --var0;
                        if(var0 < 0) {
                           return;
                        }

                        method2133(class79.field1416, var2, var6, 0, var4 >> 14, var5 >> 14);
                        var4 += var7;
                        var5 += var9;
                        var2 += class79.field1414;
                     }
                  }

                  method2133(class79.field1416, var2, var6, 0, var3 >> 14, var5 >> 14);
                  var3 += var8;
                  var5 += var9;
                  var2 += class79.field1414;
               }
            } else {
               var0 -= var1;
               var1 -= var2;
               var2 = field1594[var2];

               while(true) {
                  --var1;
                  if(var1 < 0) {
                     while(true) {
                        --var0;
                        if(var0 < 0) {
                           return;
                        }

                        method2133(class79.field1416, var2, var6, 0, var5 >> 14, var4 >> 14);
                        var4 += var7;
                        var5 += var9;
                        var2 += class79.field1414;
                     }
                  }

                  method2133(class79.field1416, var2, var6, 0, var5 >> 14, var3 >> 14);
                  var3 += var8;
                  var5 += var9;
                  var2 += class79.field1414;
               }
            }
         }
      }
   }

   @ObfuscatedName("q")
   static final void method2096(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18) {
      int[] var19 = field1591.vmethod2175(var18);
      int var20;
      if(var19 == null) {
         var20 = field1591.vmethod2162(var18);
         method2091(var0, var1, var2, var3, var4, var5, method2099(var20, var6), method2099(var20, var7), method2099(var20, var8));
      } else {
         field1578 = field1591.vmethod2165();
         field1572 = field1591.vmethod2161(var18);
         var20 = var4 - var3;
         int var21 = var1 - var0;
         int var22 = var5 - var3;
         int var23 = var2 - var0;
         int var24 = var7 - var6;
         int var25 = var8 - var6;
         int var26 = 0;
         if(var1 != var0) {
            var26 = (var4 - var3 << 14) / (var1 - var0);
         }

         int var27 = 0;
         if(var2 != var1) {
            var27 = (var5 - var4 << 14) / (var2 - var1);
         }

         int var28 = 0;
         if(var2 != var0) {
            var28 = (var3 - var5 << 14) / (var0 - var2);
         }

         int var29 = var20 * var23 - var22 * var21;
         if(var29 != 0) {
            int var30 = (var24 * var23 - var25 * var21 << 9) / var29;
            int var31 = (var25 * var20 - var24 * var22 << 9) / var29;
            var10 = var9 - var10;
            var13 = var12 - var13;
            var16 = var15 - var16;
            var11 -= var9;
            var14 -= var12;
            var17 -= var15;
            int var32 = var11 * var12 - var14 * var9 << 14;
            int var33 = (int)(((long)(var14 * var15 - var17 * var12) << 3 << 14) / (long)field1580);
            int var34 = (int)(((long)(var17 * var9 - var11 * var15) << 14) / (long)field1580);
            int var35 = var10 * var12 - var13 * var9 << 14;
            int var36 = (int)(((long)(var13 * var15 - var16 * var12) << 3 << 14) / (long)field1580);
            int var37 = (int)(((long)(var16 * var9 - var10 * var15) << 14) / (long)field1580);
            int var38 = var13 * var11 - var10 * var14 << 14;
            int var39 = (int)(((long)(var16 * var14 - var13 * var17) << 3 << 14) / (long)field1580);
            int var40 = (int)(((long)(var10 * var17 - var16 * var11) << 14) / (long)field1580);
            int var41;
            if(var0 <= var1 && var0 <= var2) {
               if(var0 < field1584) {
                  if(var1 > field1584) {
                     var1 = field1584;
                  }

                  if(var2 > field1584) {
                     var2 = field1584;
                  }

                  var6 = (var6 << 9) - var30 * var3 + var30;
                  if(var1 < var2) {
                     var5 = var3 <<= 14;
                     if(var0 < 0) {
                        var5 -= var28 * var0;
                        var3 -= var26 * var0;
                        var6 -= var31 * var0;
                        var0 = 0;
                     }

                     var4 <<= 14;
                     if(var1 < 0) {
                        var4 -= var27 * var1;
                        var1 = 0;
                     }

                     var41 = var0 - field1589;
                     var32 += var34 * var41;
                     var35 += var37 * var41;
                     var38 += var40 * var41;
                     if(var0 != var1 && var28 < var26 || var0 == var1 && var28 > var27) {
                        var2 -= var1;
                        var1 -= var0;
                        var0 = field1594[var0];

                        while(true) {
                           --var1;
                           if(var1 < 0) {
                              while(true) {
                                 --var2;
                                 if(var2 < 0) {
                                    return;
                                 }

                                 method2120(class79.field1416, var19, 0, 0, var0, var5 >> 14, var4 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                 var5 += var28;
                                 var4 += var27;
                                 var6 += var31;
                                 var0 += class79.field1414;
                                 var32 += var34;
                                 var35 += var37;
                                 var38 += var40;
                              }
                           }

                           method2120(class79.field1416, var19, 0, 0, var0, var5 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                           var5 += var28;
                           var3 += var26;
                           var6 += var31;
                           var0 += class79.field1414;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     } else {
                        var2 -= var1;
                        var1 -= var0;
                        var0 = field1594[var0];

                        while(true) {
                           --var1;
                           if(var1 < 0) {
                              while(true) {
                                 --var2;
                                 if(var2 < 0) {
                                    return;
                                 }

                                 method2120(class79.field1416, var19, 0, 0, var0, var4 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                 var5 += var28;
                                 var4 += var27;
                                 var6 += var31;
                                 var0 += class79.field1414;
                                 var32 += var34;
                                 var35 += var37;
                                 var38 += var40;
                              }
                           }

                           method2120(class79.field1416, var19, 0, 0, var0, var3 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                           var5 += var28;
                           var3 += var26;
                           var6 += var31;
                           var0 += class79.field1414;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     }
                  } else {
                     var4 = var3 <<= 14;
                     if(var0 < 0) {
                        var4 -= var28 * var0;
                        var3 -= var26 * var0;
                        var6 -= var31 * var0;
                        var0 = 0;
                     }

                     var5 <<= 14;
                     if(var2 < 0) {
                        var5 -= var27 * var2;
                        var2 = 0;
                     }

                     var41 = var0 - field1589;
                     var32 += var34 * var41;
                     var35 += var37 * var41;
                     var38 += var40 * var41;
                     if(var0 != var2 && var28 < var26 || var0 == var2 && var27 > var26) {
                        var1 -= var2;
                        var2 -= var0;
                        var0 = field1594[var0];

                        while(true) {
                           --var2;
                           if(var2 < 0) {
                              while(true) {
                                 --var1;
                                 if(var1 < 0) {
                                    return;
                                 }

                                 method2120(class79.field1416, var19, 0, 0, var0, var5 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                 var5 += var27;
                                 var3 += var26;
                                 var6 += var31;
                                 var0 += class79.field1414;
                                 var32 += var34;
                                 var35 += var37;
                                 var38 += var40;
                              }
                           }

                           method2120(class79.field1416, var19, 0, 0, var0, var4 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                           var4 += var28;
                           var3 += var26;
                           var6 += var31;
                           var0 += class79.field1414;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     } else {
                        var1 -= var2;
                        var2 -= var0;
                        var0 = field1594[var0];

                        while(true) {
                           --var2;
                           if(var2 < 0) {
                              while(true) {
                                 --var1;
                                 if(var1 < 0) {
                                    return;
                                 }

                                 method2120(class79.field1416, var19, 0, 0, var0, var3 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                 var5 += var27;
                                 var3 += var26;
                                 var6 += var31;
                                 var0 += class79.field1414;
                                 var32 += var34;
                                 var35 += var37;
                                 var38 += var40;
                              }
                           }

                           method2120(class79.field1416, var19, 0, 0, var0, var3 >> 14, var4 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                           var4 += var28;
                           var3 += var26;
                           var6 += var31;
                           var0 += class79.field1414;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     }
                  }
               }
            } else if(var1 <= var2) {
               if(var1 < field1584) {
                  if(var2 > field1584) {
                     var2 = field1584;
                  }

                  if(var0 > field1584) {
                     var0 = field1584;
                  }

                  var7 = (var7 << 9) - var30 * var4 + var30;
                  if(var2 < var0) {
                     var3 = var4 <<= 14;
                     if(var1 < 0) {
                        var3 -= var26 * var1;
                        var4 -= var27 * var1;
                        var7 -= var31 * var1;
                        var1 = 0;
                     }

                     var5 <<= 14;
                     if(var2 < 0) {
                        var5 -= var28 * var2;
                        var2 = 0;
                     }

                     var41 = var1 - field1589;
                     var32 += var34 * var41;
                     var35 += var37 * var41;
                     var38 += var40 * var41;
                     if(var1 != var2 && var26 < var27 || var1 == var2 && var26 > var28) {
                        var0 -= var2;
                        var2 -= var1;
                        var1 = field1594[var1];

                        while(true) {
                           --var2;
                           if(var2 < 0) {
                              while(true) {
                                 --var0;
                                 if(var0 < 0) {
                                    return;
                                 }

                                 method2120(class79.field1416, var19, 0, 0, var1, var3 >> 14, var5 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                 var3 += var26;
                                 var5 += var28;
                                 var7 += var31;
                                 var1 += class79.field1414;
                                 var32 += var34;
                                 var35 += var37;
                                 var38 += var40;
                              }
                           }

                           method2120(class79.field1416, var19, 0, 0, var1, var3 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                           var3 += var26;
                           var4 += var27;
                           var7 += var31;
                           var1 += class79.field1414;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     } else {
                        var0 -= var2;
                        var2 -= var1;
                        var1 = field1594[var1];

                        while(true) {
                           --var2;
                           if(var2 < 0) {
                              while(true) {
                                 --var0;
                                 if(var0 < 0) {
                                    return;
                                 }

                                 method2120(class79.field1416, var19, 0, 0, var1, var5 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                 var3 += var26;
                                 var5 += var28;
                                 var7 += var31;
                                 var1 += class79.field1414;
                                 var32 += var34;
                                 var35 += var37;
                                 var38 += var40;
                              }
                           }

                           method2120(class79.field1416, var19, 0, 0, var1, var4 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                           var3 += var26;
                           var4 += var27;
                           var7 += var31;
                           var1 += class79.field1414;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     }
                  } else {
                     var5 = var4 <<= 14;
                     if(var1 < 0) {
                        var5 -= var26 * var1;
                        var4 -= var27 * var1;
                        var7 -= var31 * var1;
                        var1 = 0;
                     }

                     var3 <<= 14;
                     if(var0 < 0) {
                        var3 -= var28 * var0;
                        var0 = 0;
                     }

                     var41 = var1 - field1589;
                     var32 += var34 * var41;
                     var35 += var37 * var41;
                     var38 += var40 * var41;
                     if(var26 < var27) {
                        var2 -= var0;
                        var0 -= var1;
                        var1 = field1594[var1];

                        while(true) {
                           --var0;
                           if(var0 < 0) {
                              while(true) {
                                 --var2;
                                 if(var2 < 0) {
                                    return;
                                 }

                                 method2120(class79.field1416, var19, 0, 0, var1, var3 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                 var3 += var28;
                                 var4 += var27;
                                 var7 += var31;
                                 var1 += class79.field1414;
                                 var32 += var34;
                                 var35 += var37;
                                 var38 += var40;
                              }
                           }

                           method2120(class79.field1416, var19, 0, 0, var1, var5 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                           var5 += var26;
                           var4 += var27;
                           var7 += var31;
                           var1 += class79.field1414;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     } else {
                        var2 -= var0;
                        var0 -= var1;
                        var1 = field1594[var1];

                        while(true) {
                           --var0;
                           if(var0 < 0) {
                              while(true) {
                                 --var2;
                                 if(var2 < 0) {
                                    return;
                                 }

                                 method2120(class79.field1416, var19, 0, 0, var1, var4 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                 var3 += var28;
                                 var4 += var27;
                                 var7 += var31;
                                 var1 += class79.field1414;
                                 var32 += var34;
                                 var35 += var37;
                                 var38 += var40;
                              }
                           }

                           method2120(class79.field1416, var19, 0, 0, var1, var4 >> 14, var5 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                           var5 += var26;
                           var4 += var27;
                           var7 += var31;
                           var1 += class79.field1414;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     }
                  }
               }
            } else if(var2 < field1584) {
               if(var0 > field1584) {
                  var0 = field1584;
               }

               if(var1 > field1584) {
                  var1 = field1584;
               }

               var8 = (var8 << 9) - var30 * var5 + var30;
               if(var0 < var1) {
                  var4 = var5 <<= 14;
                  if(var2 < 0) {
                     var4 -= var27 * var2;
                     var5 -= var28 * var2;
                     var8 -= var31 * var2;
                     var2 = 0;
                  }

                  var3 <<= 14;
                  if(var0 < 0) {
                     var3 -= var26 * var0;
                     var0 = 0;
                  }

                  var41 = var2 - field1589;
                  var32 += var34 * var41;
                  var35 += var37 * var41;
                  var38 += var40 * var41;
                  if(var27 < var28) {
                     var1 -= var0;
                     var0 -= var2;
                     var2 = field1594[var2];

                     while(true) {
                        --var0;
                        if(var0 < 0) {
                           while(true) {
                              --var1;
                              if(var1 < 0) {
                                 return;
                              }

                              method2120(class79.field1416, var19, 0, 0, var2, var4 >> 14, var3 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                              var4 += var27;
                              var3 += var26;
                              var8 += var31;
                              var2 += class79.field1414;
                              var32 += var34;
                              var35 += var37;
                              var38 += var40;
                           }
                        }

                        method2120(class79.field1416, var19, 0, 0, var2, var4 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                        var4 += var27;
                        var5 += var28;
                        var8 += var31;
                        var2 += class79.field1414;
                        var32 += var34;
                        var35 += var37;
                        var38 += var40;
                     }
                  } else {
                     var1 -= var0;
                     var0 -= var2;
                     var2 = field1594[var2];

                     while(true) {
                        --var0;
                        if(var0 < 0) {
                           while(true) {
                              --var1;
                              if(var1 < 0) {
                                 return;
                              }

                              method2120(class79.field1416, var19, 0, 0, var2, var3 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                              var4 += var27;
                              var3 += var26;
                              var8 += var31;
                              var2 += class79.field1414;
                              var32 += var34;
                              var35 += var37;
                              var38 += var40;
                           }
                        }

                        method2120(class79.field1416, var19, 0, 0, var2, var5 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                        var4 += var27;
                        var5 += var28;
                        var8 += var31;
                        var2 += class79.field1414;
                        var32 += var34;
                        var35 += var37;
                        var38 += var40;
                     }
                  }
               } else {
                  var3 = var5 <<= 14;
                  if(var2 < 0) {
                     var3 -= var27 * var2;
                     var5 -= var28 * var2;
                     var8 -= var31 * var2;
                     var2 = 0;
                  }

                  var4 <<= 14;
                  if(var1 < 0) {
                     var4 -= var26 * var1;
                     var1 = 0;
                  }

                  var41 = var2 - field1589;
                  var32 += var34 * var41;
                  var35 += var37 * var41;
                  var38 += var40 * var41;
                  if(var27 < var28) {
                     var0 -= var1;
                     var1 -= var2;
                     var2 = field1594[var2];

                     while(true) {
                        --var1;
                        if(var1 < 0) {
                           while(true) {
                              --var0;
                              if(var0 < 0) {
                                 return;
                              }

                              method2120(class79.field1416, var19, 0, 0, var2, var4 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                              var4 += var26;
                              var5 += var28;
                              var8 += var31;
                              var2 += class79.field1414;
                              var32 += var34;
                              var35 += var37;
                              var38 += var40;
                           }
                        }

                        method2120(class79.field1416, var19, 0, 0, var2, var3 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                        var3 += var27;
                        var5 += var28;
                        var8 += var31;
                        var2 += class79.field1414;
                        var32 += var34;
                        var35 += var37;
                        var38 += var40;
                     }
                  } else {
                     var0 -= var1;
                     var1 -= var2;
                     var2 = field1594[var2];

                     while(true) {
                        --var1;
                        if(var1 < 0) {
                           while(true) {
                              --var0;
                              if(var0 < 0) {
                                 return;
                              }

                              method2120(class79.field1416, var19, 0, 0, var2, var5 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                              var4 += var26;
                              var5 += var28;
                              var8 += var31;
                              var2 += class79.field1414;
                              var32 += var34;
                              var35 += var37;
                              var38 += var40;
                           }
                        }

                        method2120(class79.field1416, var19, 0, 0, var2, var5 >> 14, var3 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                        var3 += var27;
                        var5 += var28;
                        var8 += var31;
                        var2 += class79.field1414;
                        var32 += var34;
                        var35 += var37;
                        var38 += var40;
                     }
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("d")
   static final void method2097(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14, int var15, int var16, int var17, int var18) {
      int[] var19 = field1591.vmethod2175(var18);
      int var20;
      if(var19 == null) {
         var20 = field1591.vmethod2162(var18);
         method2091(var0, var1, var2, var3, var4, var5, method2099(var20, var6), method2099(var20, var7), method2099(var20, var8));
      } else {
         field1578 = field1591.vmethod2165();
         field1572 = field1591.vmethod2161(var18);
         var20 = var4 - var3;
         int var21 = var1 - var0;
         int var22 = var5 - var3;
         int var23 = var2 - var0;
         int var24 = var7 - var6;
         int var25 = var8 - var6;
         int var26 = 0;
         if(var1 != var0) {
            var26 = (var4 - var3 << 14) / (var1 - var0);
         }

         int var27 = 0;
         if(var2 != var1) {
            var27 = (var5 - var4 << 14) / (var2 - var1);
         }

         int var28 = 0;
         if(var2 != var0) {
            var28 = (var3 - var5 << 14) / (var0 - var2);
         }

         int var29 = var20 * var23 - var22 * var21;
         if(var29 != 0) {
            int var30 = (var24 * var23 - var25 * var21 << 9) / var29;
            int var31 = (var25 * var20 - var24 * var22 << 9) / var29;
            var10 = var9 - var10;
            var13 = var12 - var13;
            var16 = var15 - var16;
            var11 -= var9;
            var14 -= var12;
            var17 -= var15;
            int var32 = var11 * var12 - var14 * var9 << 14;
            int var33 = (int)(((long)(var14 * var15 - var17 * var12) << 14) / (long)field1580);
            int var34 = (int)(((long)(var17 * var9 - var11 * var15) << 14) / (long)field1580);
            int var35 = var10 * var12 - var13 * var9 << 14;
            int var36 = (int)(((long)(var13 * var15 - var16 * var12) << 14) / (long)field1580);
            int var37 = (int)(((long)(var16 * var9 - var10 * var15) << 14) / (long)field1580);
            int var38 = var13 * var11 - var10 * var14 << 14;
            int var39 = (int)(((long)(var16 * var14 - var13 * var17) << 14) / (long)field1580);
            int var40 = (int)(((long)(var10 * var17 - var16 * var11) << 14) / (long)field1580);
            int var41;
            if(var0 <= var1 && var0 <= var2) {
               if(var0 < field1584) {
                  if(var1 > field1584) {
                     var1 = field1584;
                  }

                  if(var2 > field1584) {
                     var2 = field1584;
                  }

                  var6 = (var6 << 9) - var30 * var3 + var30;
                  if(var1 < var2) {
                     var5 = var3 <<= 14;
                     if(var0 < 0) {
                        var5 -= var28 * var0;
                        var3 -= var26 * var0;
                        var6 -= var31 * var0;
                        var0 = 0;
                     }

                     var4 <<= 14;
                     if(var1 < 0) {
                        var4 -= var27 * var1;
                        var1 = 0;
                     }

                     var41 = var0 - field1589;
                     var32 += var34 * var41;
                     var35 += var37 * var41;
                     var38 += var40 * var41;
                     if((var0 == var1 || var28 >= var26) && (var0 != var1 || var28 <= var27)) {
                        var2 -= var1;
                        var1 -= var0;
                        var0 = field1594[var0];

                        while(true) {
                           --var1;
                           if(var1 < 0) {
                              while(true) {
                                 --var2;
                                 if(var2 < 0) {
                                    return;
                                 }

                                 method2098(class79.field1416, var19, 0, 0, var0, var4 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                 var5 += var28;
                                 var4 += var27;
                                 var6 += var31;
                                 var0 += class79.field1414;
                                 var32 += var34;
                                 var35 += var37;
                                 var38 += var40;
                              }
                           }

                           method2098(class79.field1416, var19, 0, 0, var0, var3 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                           var5 += var28;
                           var3 += var26;
                           var6 += var31;
                           var0 += class79.field1414;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     } else {
                        var2 -= var1;
                        var1 -= var0;
                        var0 = field1594[var0];

                        while(true) {
                           --var1;
                           if(var1 < 0) {
                              while(true) {
                                 --var2;
                                 if(var2 < 0) {
                                    return;
                                 }

                                 method2098(class79.field1416, var19, 0, 0, var0, var5 >> 14, var4 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                 var5 += var28;
                                 var4 += var27;
                                 var6 += var31;
                                 var0 += class79.field1414;
                                 var32 += var34;
                                 var35 += var37;
                                 var38 += var40;
                              }
                           }

                           method2098(class79.field1416, var19, 0, 0, var0, var5 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                           var5 += var28;
                           var3 += var26;
                           var6 += var31;
                           var0 += class79.field1414;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     }
                  } else {
                     var4 = var3 <<= 14;
                     if(var0 < 0) {
                        var4 -= var28 * var0;
                        var3 -= var26 * var0;
                        var6 -= var31 * var0;
                        var0 = 0;
                     }

                     var5 <<= 14;
                     if(var2 < 0) {
                        var5 -= var27 * var2;
                        var2 = 0;
                     }

                     var41 = var0 - field1589;
                     var32 += var34 * var41;
                     var35 += var37 * var41;
                     var38 += var40 * var41;
                     if(var0 != var2 && var28 < var26 || var0 == var2 && var27 > var26) {
                        var1 -= var2;
                        var2 -= var0;
                        var0 = field1594[var0];

                        while(true) {
                           --var2;
                           if(var2 < 0) {
                              while(true) {
                                 --var1;
                                 if(var1 < 0) {
                                    return;
                                 }

                                 method2098(class79.field1416, var19, 0, 0, var0, var5 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                 var5 += var27;
                                 var3 += var26;
                                 var6 += var31;
                                 var0 += class79.field1414;
                                 var32 += var34;
                                 var35 += var37;
                                 var38 += var40;
                              }
                           }

                           method2098(class79.field1416, var19, 0, 0, var0, var4 >> 14, var3 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                           var4 += var28;
                           var3 += var26;
                           var6 += var31;
                           var0 += class79.field1414;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     } else {
                        var1 -= var2;
                        var2 -= var0;
                        var0 = field1594[var0];

                        while(true) {
                           --var2;
                           if(var2 < 0) {
                              while(true) {
                                 --var1;
                                 if(var1 < 0) {
                                    return;
                                 }

                                 method2098(class79.field1416, var19, 0, 0, var0, var3 >> 14, var5 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                                 var5 += var27;
                                 var3 += var26;
                                 var6 += var31;
                                 var0 += class79.field1414;
                                 var32 += var34;
                                 var35 += var37;
                                 var38 += var40;
                              }
                           }

                           method2098(class79.field1416, var19, 0, 0, var0, var3 >> 14, var4 >> 14, var6, var30, var32, var35, var38, var33, var36, var39);
                           var4 += var28;
                           var3 += var26;
                           var6 += var31;
                           var0 += class79.field1414;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     }
                  }
               }
            } else if(var1 <= var2) {
               if(var1 < field1584) {
                  if(var2 > field1584) {
                     var2 = field1584;
                  }

                  if(var0 > field1584) {
                     var0 = field1584;
                  }

                  var7 = (var7 << 9) - var30 * var4 + var30;
                  if(var2 < var0) {
                     var3 = var4 <<= 14;
                     if(var1 < 0) {
                        var3 -= var26 * var1;
                        var4 -= var27 * var1;
                        var7 -= var31 * var1;
                        var1 = 0;
                     }

                     var5 <<= 14;
                     if(var2 < 0) {
                        var5 -= var28 * var2;
                        var2 = 0;
                     }

                     var41 = var1 - field1589;
                     var32 += var34 * var41;
                     var35 += var37 * var41;
                     var38 += var40 * var41;
                     if((var1 == var2 || var26 >= var27) && (var1 != var2 || var26 <= var28)) {
                        var0 -= var2;
                        var2 -= var1;
                        var1 = field1594[var1];

                        while(true) {
                           --var2;
                           if(var2 < 0) {
                              while(true) {
                                 --var0;
                                 if(var0 < 0) {
                                    return;
                                 }

                                 method2098(class79.field1416, var19, 0, 0, var1, var5 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                 var3 += var26;
                                 var5 += var28;
                                 var7 += var31;
                                 var1 += class79.field1414;
                                 var32 += var34;
                                 var35 += var37;
                                 var38 += var40;
                              }
                           }

                           method2098(class79.field1416, var19, 0, 0, var1, var4 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                           var3 += var26;
                           var4 += var27;
                           var7 += var31;
                           var1 += class79.field1414;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     } else {
                        var0 -= var2;
                        var2 -= var1;
                        var1 = field1594[var1];

                        while(true) {
                           --var2;
                           if(var2 < 0) {
                              while(true) {
                                 --var0;
                                 if(var0 < 0) {
                                    return;
                                 }

                                 method2098(class79.field1416, var19, 0, 0, var1, var3 >> 14, var5 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                 var3 += var26;
                                 var5 += var28;
                                 var7 += var31;
                                 var1 += class79.field1414;
                                 var32 += var34;
                                 var35 += var37;
                                 var38 += var40;
                              }
                           }

                           method2098(class79.field1416, var19, 0, 0, var1, var3 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                           var3 += var26;
                           var4 += var27;
                           var7 += var31;
                           var1 += class79.field1414;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     }
                  } else {
                     var5 = var4 <<= 14;
                     if(var1 < 0) {
                        var5 -= var26 * var1;
                        var4 -= var27 * var1;
                        var7 -= var31 * var1;
                        var1 = 0;
                     }

                     var3 <<= 14;
                     if(var0 < 0) {
                        var3 -= var28 * var0;
                        var0 = 0;
                     }

                     var41 = var1 - field1589;
                     var32 += var34 * var41;
                     var35 += var37 * var41;
                     var38 += var40 * var41;
                     if(var26 < var27) {
                        var2 -= var0;
                        var0 -= var1;
                        var1 = field1594[var1];

                        while(true) {
                           --var0;
                           if(var0 < 0) {
                              while(true) {
                                 --var2;
                                 if(var2 < 0) {
                                    return;
                                 }

                                 method2098(class79.field1416, var19, 0, 0, var1, var3 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                 var3 += var28;
                                 var4 += var27;
                                 var7 += var31;
                                 var1 += class79.field1414;
                                 var32 += var34;
                                 var35 += var37;
                                 var38 += var40;
                              }
                           }

                           method2098(class79.field1416, var19, 0, 0, var1, var5 >> 14, var4 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                           var5 += var26;
                           var4 += var27;
                           var7 += var31;
                           var1 += class79.field1414;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     } else {
                        var2 -= var0;
                        var0 -= var1;
                        var1 = field1594[var1];

                        while(true) {
                           --var0;
                           if(var0 < 0) {
                              while(true) {
                                 --var2;
                                 if(var2 < 0) {
                                    return;
                                 }

                                 method2098(class79.field1416, var19, 0, 0, var1, var4 >> 14, var3 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                                 var3 += var28;
                                 var4 += var27;
                                 var7 += var31;
                                 var1 += class79.field1414;
                                 var32 += var34;
                                 var35 += var37;
                                 var38 += var40;
                              }
                           }

                           method2098(class79.field1416, var19, 0, 0, var1, var4 >> 14, var5 >> 14, var7, var30, var32, var35, var38, var33, var36, var39);
                           var5 += var26;
                           var4 += var27;
                           var7 += var31;
                           var1 += class79.field1414;
                           var32 += var34;
                           var35 += var37;
                           var38 += var40;
                        }
                     }
                  }
               }
            } else if(var2 < field1584) {
               if(var0 > field1584) {
                  var0 = field1584;
               }

               if(var1 > field1584) {
                  var1 = field1584;
               }

               var8 = (var8 << 9) - var30 * var5 + var30;
               if(var0 < var1) {
                  var4 = var5 <<= 14;
                  if(var2 < 0) {
                     var4 -= var27 * var2;
                     var5 -= var28 * var2;
                     var8 -= var31 * var2;
                     var2 = 0;
                  }

                  var3 <<= 14;
                  if(var0 < 0) {
                     var3 -= var26 * var0;
                     var0 = 0;
                  }

                  var41 = var2 - field1589;
                  var32 += var34 * var41;
                  var35 += var37 * var41;
                  var38 += var40 * var41;
                  if(var27 < var28) {
                     var1 -= var0;
                     var0 -= var2;
                     var2 = field1594[var2];

                     while(true) {
                        --var0;
                        if(var0 < 0) {
                           while(true) {
                              --var1;
                              if(var1 < 0) {
                                 return;
                              }

                              method2098(class79.field1416, var19, 0, 0, var2, var4 >> 14, var3 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                              var4 += var27;
                              var3 += var26;
                              var8 += var31;
                              var2 += class79.field1414;
                              var32 += var34;
                              var35 += var37;
                              var38 += var40;
                           }
                        }

                        method2098(class79.field1416, var19, 0, 0, var2, var4 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                        var4 += var27;
                        var5 += var28;
                        var8 += var31;
                        var2 += class79.field1414;
                        var32 += var34;
                        var35 += var37;
                        var38 += var40;
                     }
                  } else {
                     var1 -= var0;
                     var0 -= var2;
                     var2 = field1594[var2];

                     while(true) {
                        --var0;
                        if(var0 < 0) {
                           while(true) {
                              --var1;
                              if(var1 < 0) {
                                 return;
                              }

                              method2098(class79.field1416, var19, 0, 0, var2, var3 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                              var4 += var27;
                              var3 += var26;
                              var8 += var31;
                              var2 += class79.field1414;
                              var32 += var34;
                              var35 += var37;
                              var38 += var40;
                           }
                        }

                        method2098(class79.field1416, var19, 0, 0, var2, var5 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                        var4 += var27;
                        var5 += var28;
                        var8 += var31;
                        var2 += class79.field1414;
                        var32 += var34;
                        var35 += var37;
                        var38 += var40;
                     }
                  }
               } else {
                  var3 = var5 <<= 14;
                  if(var2 < 0) {
                     var3 -= var27 * var2;
                     var5 -= var28 * var2;
                     var8 -= var31 * var2;
                     var2 = 0;
                  }

                  var4 <<= 14;
                  if(var1 < 0) {
                     var4 -= var26 * var1;
                     var1 = 0;
                  }

                  var41 = var2 - field1589;
                  var32 += var34 * var41;
                  var35 += var37 * var41;
                  var38 += var40 * var41;
                  if(var27 < var28) {
                     var0 -= var1;
                     var1 -= var2;
                     var2 = field1594[var2];

                     while(true) {
                        --var1;
                        if(var1 < 0) {
                           while(true) {
                              --var0;
                              if(var0 < 0) {
                                 return;
                              }

                              method2098(class79.field1416, var19, 0, 0, var2, var4 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                              var4 += var26;
                              var5 += var28;
                              var8 += var31;
                              var2 += class79.field1414;
                              var32 += var34;
                              var35 += var37;
                              var38 += var40;
                           }
                        }

                        method2098(class79.field1416, var19, 0, 0, var2, var3 >> 14, var5 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                        var3 += var27;
                        var5 += var28;
                        var8 += var31;
                        var2 += class79.field1414;
                        var32 += var34;
                        var35 += var37;
                        var38 += var40;
                     }
                  } else {
                     var0 -= var1;
                     var1 -= var2;
                     var2 = field1594[var2];

                     while(true) {
                        --var1;
                        if(var1 < 0) {
                           while(true) {
                              --var0;
                              if(var0 < 0) {
                                 return;
                              }

                              method2098(class79.field1416, var19, 0, 0, var2, var5 >> 14, var4 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                              var4 += var26;
                              var5 += var28;
                              var8 += var31;
                              var2 += class79.field1414;
                              var32 += var34;
                              var35 += var37;
                              var38 += var40;
                           }
                        }

                        method2098(class79.field1416, var19, 0, 0, var2, var5 >> 14, var3 >> 14, var8, var30, var32, var35, var38, var33, var36, var39);
                        var3 += var27;
                        var5 += var28;
                        var8 += var31;
                        var2 += class79.field1414;
                        var32 += var34;
                        var35 += var37;
                        var38 += var40;
                     }
                  }
               }
            }
         }
      }
   }

   @ObfuscatedName("u")
   static final void method2098(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14) {
      if(field1581) {
         if(var6 > field1583) {
            var6 = field1583;
         }

         if(var5 < 0) {
            var5 = 0;
         }
      }

      if(var5 < var6) {
         var4 += var5;
         var7 += var8 * var5;
         int var17 = var6 - var5;
         int var15;
         int var16;
         int var18;
         int var19;
         int var20;
         int var21;
         int var22;
         int var23;
         if(field1578) {
            var23 = var5 - field1592;
            var9 += var12 * var23;
            var10 += var13 * var23;
            var11 += var14 * var23;
            var22 = var11 >> 12;
            if(var22 != 0) {
               var18 = var9 / var22;
               var19 = var10 / var22;
            } else {
               var18 = 0;
               var19 = 0;
            }

            var9 += var12 * var17;
            var10 += var13 * var17;
            var11 += var14 * var17;
            var22 = var11 >> 12;
            if(var22 != 0) {
               var20 = var9 / var22;
               var21 = var10 / var22;
            } else {
               var20 = 0;
               var21 = 0;
            }

            var2 = (var18 << 20) + var19;
            var16 = ((var20 - var18) / var17 << 20) + (var21 - var19) / var17;
            var17 >>= 3;
            var8 <<= 3;
            var15 = var7 >> 8;
            if(field1572) {
               if(var17 > 0) {
                  do {
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var7 += var8;
                     var15 = var7 >> 8;
                     --var17;
                  } while(var17 > 0);
               }

               var17 = var6 - var5 & 7;
               if(var17 > 0) {
                  do {
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     --var17;
                  } while(var17 > 0);
               }
            } else {
               if(var17 > 0) {
                  do {
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     var7 += var8;
                     var15 = var7 >> 8;
                     --var17;
                  } while(var17 > 0);
               }

               var17 = var6 - var5 & 7;
               if(var17 > 0) {
                  do {
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     --var17;
                  } while(var17 > 0);
               }
            }
         } else {
            var23 = var5 - field1592;
            var9 += var12 * var23;
            var10 += var13 * var23;
            var11 += var14 * var23;
            var22 = var11 >> 14;
            if(var22 != 0) {
               var18 = var9 / var22;
               var19 = var10 / var22;
            } else {
               var18 = 0;
               var19 = 0;
            }

            var9 += var12 * var17;
            var10 += var13 * var17;
            var11 += var14 * var17;
            var22 = var11 >> 14;
            if(var22 != 0) {
               var20 = var9 / var22;
               var21 = var10 / var22;
            } else {
               var20 = 0;
               var21 = 0;
            }

            var2 = (var18 << 18) + var19;
            var16 = ((var20 - var18) / var17 << 18) + (var21 - var19) / var17;
            var17 >>= 3;
            var8 <<= 3;
            var15 = var7 >> 8;
            if(field1572) {
               if(var17 > 0) {
                  do {
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var7 += var8;
                     var15 = var7 >> 8;
                     --var17;
                  } while(var17 > 0);
               }

               var17 = var6 - var5 & 7;
               if(var17 > 0) {
                  do {
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     --var17;
                  } while(var17 > 0);
               }
            } else {
               if(var17 > 0) {
                  do {
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     var7 += var8;
                     var15 = var7 >> 8;
                     --var17;
                  } while(var17 > 0);
               }

               var17 = var6 - var5 & 7;
               if(var17 > 0) {
                  do {
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     --var17;
                  } while(var17 > 0);
               }
            }
         }

      }
   }

   @ObfuscatedName("i")
   static final int method2099(int var0, int var1) {
      var1 = var1 * (var0 & 127) >> 7;
      if(var1 < 2) {
         var1 = 2;
      } else if(var1 > 126) {
         var1 = 126;
      }

      return (var0 & 'ﾀ') + var1;
   }

   static {
      int var0;
      for(var0 = 1; var0 < 512; ++var0) {
         field1582[var0] = '耀' / var0;
      }

      for(var0 = 1; var0 < 2048; ++var0) {
         field1593[var0] = 65536 / var0;
      }

      for(var0 = 0; var0 < 2048; ++var0) {
         field1573[var0] = (int)(65536.0D * Math.sin((double)var0 * 0.0030679615D));
         field1595[var0] = (int)(65536.0D * Math.cos((double)var0 * 0.0030679615D));
      }

   }

   @ObfuscatedName("p")
   public static final void method2104(int var0, int var1) {
      int var2 = field1594[0];
      int var3 = var2 / class79.field1414;
      int var4 = var2 - var3 * class79.field1414;
      field1592 = var0 - var4;
      field1589 = var1 - var3;
      field1585 = -field1592;
      field1586 = field1583 - field1592;
      field1587 = -field1589;
      field1588 = field1584 - field1589;
   }

   @ObfuscatedName("e")
   public static final void method2105(class92 var0) {
      field1591 = var0;
   }

   @ObfuscatedName("a")
   static final void method2120(int[] var0, int[] var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10, int var11, int var12, int var13, int var14) {
      if(field1581) {
         if(var6 > field1583) {
            var6 = field1583;
         }

         if(var5 < 0) {
            var5 = 0;
         }
      }

      if(var5 < var6) {
         var4 += var5;
         var7 += var8 * var5;
         int var17 = var6 - var5;
         int var15;
         int var16;
         int var10000;
         int var18;
         int var19;
         int var20;
         int var21;
         int var22;
         int var23;
         if(field1578) {
            var23 = var5 - field1592;
            var9 += (var12 >> 3) * var23;
            var10 += (var13 >> 3) * var23;
            var11 += (var14 >> 3) * var23;
            var22 = var11 >> 12;
            if(var22 != 0) {
               var18 = var9 / var22;
               var19 = var10 / var22;
               if(var18 < 0) {
                  var18 = 0;
               } else if(var18 > 4032) {
                  var18 = 4032;
               }
            } else {
               var18 = 0;
               var19 = 0;
            }

            var9 += var12;
            var10 += var13;
            var11 += var14;
            var22 = var11 >> 12;
            if(var22 != 0) {
               var20 = var9 / var22;
               var21 = var10 / var22;
               if(var20 < 0) {
                  var20 = 0;
               } else if(var20 > 4032) {
                  var20 = 4032;
               }
            } else {
               var20 = 0;
               var21 = 0;
            }

            var2 = (var18 << 20) + var19;
            var16 = (var20 - var18 >> 3 << 20) + (var21 - var19 >> 3);
            var17 >>= 3;
            var8 <<= 3;
            var15 = var7 >> 8;
            if(field1572) {
               if(var17 > 0) {
                  do {
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var10000 = var2 + var16;
                     var18 = var20;
                     var19 = var21;
                     var9 += var12;
                     var10 += var13;
                     var11 += var14;
                     var22 = var11 >> 12;
                     if(var22 != 0) {
                        var20 = var9 / var22;
                        var21 = var10 / var22;
                        if(var20 < 0) {
                           var20 = 0;
                        } else if(var20 > 4032) {
                           var20 = 4032;
                        }
                     } else {
                        var20 = 0;
                        var21 = 0;
                     }

                     var2 = (var18 << 20) + var19;
                     var16 = (var20 - var18 >> 3 << 20) + (var21 - var19 >> 3);
                     var7 += var8;
                     var15 = var7 >> 8;
                     --var17;
                  } while(var17 > 0);
               }

               var17 = var6 - var5 & 7;
               if(var17 > 0) {
                  do {
                     var3 = var1[(var2 & 4032) + (var2 >>> 26)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     --var17;
                  } while(var17 > 0);
               }
            } else {
               if(var17 > 0) {
                  do {
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var10000 = var2 + var16;
                     var18 = var20;
                     var19 = var21;
                     var9 += var12;
                     var10 += var13;
                     var11 += var14;
                     var22 = var11 >> 12;
                     if(var22 != 0) {
                        var20 = var9 / var22;
                        var21 = var10 / var22;
                        if(var20 < 0) {
                           var20 = 0;
                        } else if(var20 > 4032) {
                           var20 = 4032;
                        }
                     } else {
                        var20 = 0;
                        var21 = 0;
                     }

                     var2 = (var18 << 20) + var19;
                     var16 = (var20 - var18 >> 3 << 20) + (var21 - var19 >> 3);
                     var7 += var8;
                     var15 = var7 >> 8;
                     --var17;
                  } while(var17 > 0);
               }

               var17 = var6 - var5 & 7;
               if(var17 > 0) {
                  do {
                     if((var3 = var1[(var2 & 4032) + (var2 >>> 26)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     --var17;
                  } while(var17 > 0);
               }
            }
         } else {
            var23 = var5 - field1592;
            var9 += (var12 >> 3) * var23;
            var10 += (var13 >> 3) * var23;
            var11 += (var14 >> 3) * var23;
            var22 = var11 >> 14;
            if(var22 != 0) {
               var18 = var9 / var22;
               var19 = var10 / var22;
               if(var18 < 0) {
                  var18 = 0;
               } else if(var18 > 16256) {
                  var18 = 16256;
               }
            } else {
               var18 = 0;
               var19 = 0;
            }

            var9 += var12;
            var10 += var13;
            var11 += var14;
            var22 = var11 >> 14;
            if(var22 != 0) {
               var20 = var9 / var22;
               var21 = var10 / var22;
               if(var20 < 0) {
                  var20 = 0;
               } else if(var20 > 16256) {
                  var20 = 16256;
               }
            } else {
               var20 = 0;
               var21 = 0;
            }

            var2 = (var18 << 18) + var19;
            var16 = (var20 - var18 >> 3 << 18) + (var21 - var19 >> 3);
            var17 >>= 3;
            var8 <<= 3;
            var15 = var7 >> 8;
            if(field1572) {
               if(var17 > 0) {
                  do {
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var10000 = var2 + var16;
                     var18 = var20;
                     var19 = var21;
                     var9 += var12;
                     var10 += var13;
                     var11 += var14;
                     var22 = var11 >> 14;
                     if(var22 != 0) {
                        var20 = var9 / var22;
                        var21 = var10 / var22;
                        if(var20 < 0) {
                           var20 = 0;
                        } else if(var20 > 16256) {
                           var20 = 16256;
                        }
                     } else {
                        var20 = 0;
                        var21 = 0;
                     }

                     var2 = (var18 << 18) + var19;
                     var16 = (var20 - var18 >> 3 << 18) + (var21 - var19 >> 3);
                     var7 += var8;
                     var15 = var7 >> 8;
                     --var17;
                  } while(var17 > 0);
               }

               var17 = var6 - var5 & 7;
               if(var17 > 0) {
                  do {
                     var3 = var1[(var2 & 16256) + (var2 >>> 25)];
                     var0[var4++] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     var2 += var16;
                     --var17;
                  } while(var17 > 0);
               }
            } else {
               if(var17 > 0) {
                  do {
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var10000 = var2 + var16;
                     var18 = var20;
                     var19 = var21;
                     var9 += var12;
                     var10 += var13;
                     var11 += var14;
                     var22 = var11 >> 14;
                     if(var22 != 0) {
                        var20 = var9 / var22;
                        var21 = var10 / var22;
                        if(var20 < 0) {
                           var20 = 0;
                        } else if(var20 > 16256) {
                           var20 = 16256;
                        }
                     } else {
                        var20 = 0;
                        var21 = 0;
                     }

                     var2 = (var18 << 18) + var19;
                     var16 = (var20 - var18 >> 3 << 18) + (var21 - var19 >> 3);
                     var7 += var8;
                     var15 = var7 >> 8;
                     --var17;
                  } while(var17 > 0);
               }

               var17 = var6 - var5 & 7;
               if(var17 > 0) {
                  do {
                     if((var3 = var1[(var2 & 16256) + (var2 >>> 25)]) != 0) {
                        var0[var4] = ((var3 & 16711935) * var15 & -16711936) + ((var3 & '\uff00') * var15 & 16711680) >> 8;
                     }

                     ++var4;
                     var2 += var16;
                     --var17;
                  } while(var17 > 0);
               }
            }
         }

      }
   }

   @ObfuscatedName("m")
   static final void method2124(double var0, int var2, int var3) {
      var0 += Math.random() * 0.03D - 0.015D;
      int var4 = var2 * 128;

      for(int var5 = var2; var5 < var3; ++var5) {
         double var6 = (double)(var5 >> 3) / 64.0D + 0.0078125D;
         double var8 = (double)(var5 & 7) / 8.0D + 0.0625D;

         for(int var10 = 0; var10 < 128; ++var10) {
            double var11 = (double)var10 / 128.0D;
            double var13 = var11;
            double var15 = var11;
            double var17 = var11;
            if(var8 != 0.0D) {
               double var19;
               if(var11 < 0.5D) {
                  var19 = var11 * (1.0D + var8);
               } else {
                  var19 = var11 + var8 - var11 * var8;
               }

               double var21 = 2.0D * var11 - var19;
               double var23 = var6 + 0.3333333333333333D;
               if(var23 > 1.0D) {
                  --var23;
               }

               double var27 = var6 - 0.3333333333333333D;
               if(var27 < 0.0D) {
                  ++var27;
               }

               if(6.0D * var23 < 1.0D) {
                  var13 = var21 + (var19 - var21) * 6.0D * var23;
               } else if(2.0D * var23 < 1.0D) {
                  var13 = var19;
               } else if(3.0D * var23 < 2.0D) {
                  var13 = var21 + (var19 - var21) * (0.6666666666666666D - var23) * 6.0D;
               } else {
                  var13 = var21;
               }

               if(6.0D * var6 < 1.0D) {
                  var15 = var21 + (var19 - var21) * 6.0D * var6;
               } else if(2.0D * var6 < 1.0D) {
                  var15 = var19;
               } else if(3.0D * var6 < 2.0D) {
                  var15 = var21 + (var19 - var21) * (0.6666666666666666D - var6) * 6.0D;
               } else {
                  var15 = var21;
               }

               if(6.0D * var27 < 1.0D) {
                  var17 = var21 + (var19 - var21) * 6.0D * var27;
               } else if(2.0D * var27 < 1.0D) {
                  var17 = var19;
               } else if(3.0D * var27 < 2.0D) {
                  var17 = var21 + (var19 - var21) * (0.6666666666666666D - var27) * 6.0D;
               } else {
                  var17 = var21;
               }
            }

            int var30 = (int)(var13 * 256.0D);
            int var20 = (int)(var15 * 256.0D);
            int var29 = (int)(var17 * 256.0D);
            int var22 = (var30 << 16) + (var20 << 8) + var29;
            var22 = method2089(var22, var0);
            if(var22 == 0) {
               var22 = 1;
            }

            field1590[var4++] = var22;
         }
      }

   }

   @ObfuscatedName("j")
   static final void method2133(int[] var0, int var1, int var2, int var3, int var4, int var5) {
      if(field1581) {
         if(var5 > field1583) {
            var5 = field1583;
         }

         if(var4 < 0) {
            var4 = 0;
         }
      }

      if(var4 < var5) {
         var1 += var4;
         var3 = var5 - var4 >> 2;
         if(field1575 != 0) {
            if(field1575 == 254) {
               while(true) {
                  --var3;
                  if(var3 < 0) {
                     var3 = var5 - var4 & 3;

                     while(true) {
                        --var3;
                        if(var3 < 0) {
                           return;
                        }

                        var0[var1++] = var0[var1];
                     }
                  }

                  var0[var1++] = var0[var1];
                  var0[var1++] = var0[var1];
                  var0[var1++] = var0[var1];
                  var0[var1++] = var0[var1];
               }
            } else {
               int var6 = field1575;
               int var7 = 256 - field1575;
               var2 = ((var2 & 16711935) * var7 >> 8 & 16711935) + ((var2 & '\uff00') * var7 >> 8 & '\uff00');

               while(true) {
                  --var3;
                  int var8;
                  if(var3 < 0) {
                     var3 = var5 - var4 & 3;

                     while(true) {
                        --var3;
                        if(var3 < 0) {
                           return;
                        }

                        var8 = var0[var1];
                        var0[var1++] = var2 + ((var8 & 16711935) * var6 >> 8 & 16711935) + ((var8 & '\uff00') * var6 >> 8 & '\uff00');
                     }
                  }

                  var8 = var0[var1];
                  var0[var1++] = var2 + ((var8 & 16711935) * var6 >> 8 & 16711935) + ((var8 & '\uff00') * var6 >> 8 & '\uff00');
                  var8 = var0[var1];
                  var0[var1++] = var2 + ((var8 & 16711935) * var6 >> 8 & 16711935) + ((var8 & '\uff00') * var6 >> 8 & '\uff00');
                  var8 = var0[var1];
                  var0[var1++] = var2 + ((var8 & 16711935) * var6 >> 8 & 16711935) + ((var8 & '\uff00') * var6 >> 8 & '\uff00');
                  var8 = var0[var1];
                  var0[var1++] = var2 + ((var8 & 16711935) * var6 >> 8 & 16711935) + ((var8 & '\uff00') * var6 >> 8 & '\uff00');
               }
            }
         } else {
            while(true) {
               --var3;
               if(var3 < 0) {
                  var3 = var5 - var4 & 3;

                  while(true) {
                     --var3;
                     if(var3 < 0) {
                        return;
                     }

                     var0[var1++] = var2;
                  }
               }

               var0[var1++] = var2;
               var0[var1++] = var2;
               var0[var1++] = var2;
               var0[var1++] = var2;
            }
         }
      }
   }

   @ObfuscatedName("v")
   public static void method2140(int var0, int var1, int var2) {
      field1581 = var0 < 0 || var0 > field1583 || var1 < 0 || var1 > field1583 || var2 < 0 || var2 > field1583;
   }
}
