import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
public class class160 {
   @ObfuscatedName("r")
   static char[] field2625;
   @ObfuscatedName("a")
   static char[] field2627 = new char[64];
   @ObfuscatedName("f")
   static int[] field2628;

   static {
      int var0;
      for(var0 = 0; var0 < 26; ++var0) {
         field2627[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2627[var0] = (char)(97 + var0 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2627[var0] = (char)(48 + var0 - 52);
      }

      field2627[62] = 43;
      field2627[63] = 47;
      field2625 = new char[64];

      for(var0 = 0; var0 < 26; ++var0) {
         field2625[var0] = (char)(var0 + 65);
      }

      for(var0 = 26; var0 < 52; ++var0) {
         field2625[var0] = (char)(var0 + 97 - 26);
      }

      for(var0 = 52; var0 < 62; ++var0) {
         field2625[var0] = (char)(48 + var0 - 52);
      }

      field2625[62] = 42;
      field2625[63] = 45;
      field2628 = new int[128];

      for(var0 = 0; var0 < field2628.length; ++var0) {
         field2628[var0] = -1;
      }

      for(var0 = 65; var0 <= 90; ++var0) {
         field2628[var0] = var0 - 65;
      }

      for(var0 = 97; var0 <= 122; ++var0) {
         field2628[var0] = var0 - 97 + 26;
      }

      for(var0 = 48; var0 <= 57; ++var0) {
         field2628[var0] = var0 - 48 + 52;
      }

      int[] var2 = field2628;
      field2628[43] = 62;
      var2[42] = 62;
      int[] var1 = field2628;
      field2628[47] = 63;
      var1[45] = 63;
   }

   @ObfuscatedName("ca")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1364695970"
   )
   static final void method3201(int var0, int var1, int var2, int var3) {
      if(0 == client.field446 && !client.field448) {
         class212.method3983("Walk here", "", 23, 0, var0 - var2, var1 - var3);
      }

      int var4 = -1;
      int var5 = -1;

      int var6;
      int var7;
      for(var6 = 0; var6 < class104.field1844; ++var6) {
         var7 = class104.field1796[var6];
         int var8 = var7 & 127;
         int var9 = var7 >> 7 & 127;
         int var10 = var7 >> 29 & 3;
         int var11 = var7 >> 14 & 32767;
         if(var5 != var7) {
            var5 = var7;
            if(2 == var10 && class77.field1396.method2087(class48.field1078, var8, var9, var7) >= 0) {
               class40 var12 = class156.method3176(var11);
               if(null != var12.field955) {
                  var12 = var12.method848();
               }

               if(null == var12) {
                  continue;
               }

               if(client.field446 == 1) {
                  class212.method3983("Use", client.field447 + " " + "->" + " " + class51.method1090('\uffff') + var12.field954, 1, var7, var8, var9);
               } else if(client.field448) {
                  if((class15.field218 & 4) == 4) {
                     class212.method3983(client.field451, client.field452 + " " + "->" + " " + class51.method1090('\uffff') + var12.field954, 2, var7, var8, var9);
                  }
               } else {
                  String[] var13 = var12.field950;
                  if(client.field464) {
                     var13 = client.method553(var13);
                  }

                  if(null != var13) {
                     for(int var14 = 4; var14 >= 0; --var14) {
                        if(null != var13[var14]) {
                           short var15 = 0;
                           if(var14 == 0) {
                              var15 = 3;
                           }

                           if(1 == var14) {
                              var15 = 4;
                           }

                           if(2 == var14) {
                              var15 = 5;
                           }

                           if(3 == var14) {
                              var15 = 6;
                           }

                           if(4 == var14) {
                              var15 = 1001;
                           }

                           class212.method3983(var13[var14], class51.method1090('\uffff') + var12.field954, var15, var7, var8, var9);
                        }
                     }
                  }

                  class212.method3983("Examine", class51.method1090('\uffff') + var12.field954, 1002, var12.field930 << 14, var8, var9);
               }
            }

            class2 var16;
            int var22;
            class34 var23;
            int[] var24;
            int var28;
            if(1 == var10) {
               class34 var19 = client.field358[var11];
               if(var19 == null) {
                  continue;
               }

               if(1 == var19.field785.field881 && (var19.field870 & 127) == 64 && (var19.field813 & 127) == 64) {
                  for(var22 = 0; var22 < client.field331; ++var22) {
                     var23 = client.field358[client.field564[var22]];
                     if(null != var23 && var23 != var19 && 1 == var23.field785.field881 && var23.field870 == var19.field870 && var23.field813 == var19.field813) {
                        class43.method927(var23.field785, client.field564[var22], var8, var9);
                     }
                  }

                  var22 = class32.field774;
                  var24 = class32.field759;

                  for(var28 = 0; var28 < var22; ++var28) {
                     var16 = client.field415[var24[var28]];
                     if(var16 != null && var16.field870 == var19.field870 && var19.field813 == var16.field813) {
                        class150.method3149(var16, var24[var28], var8, var9);
                     }
                  }
               }

               class43.method927(var19.field785, var11, var8, var9);
            }

            if(0 == var10) {
               class2 var20 = client.field415[var11];
               if(null == var20) {
                  continue;
               }

               if((var20.field870 & 127) == 64 && 64 == (var20.field813 & 127)) {
                  for(var22 = 0; var22 < client.field331; ++var22) {
                     var23 = client.field358[client.field564[var22]];
                     if(null != var23 && 1 == var23.field785.field881 && var23.field870 == var20.field870 && var20.field813 == var23.field813) {
                        class43.method927(var23.field785, client.field564[var22], var8, var9);
                     }
                  }

                  var22 = class32.field774;
                  var24 = class32.field759;

                  for(var28 = 0; var28 < var22; ++var28) {
                     var16 = client.field415[var24[var28]];
                     if(var16 != null && var20 != var16 && var16.field870 == var20.field870 && var20.field813 == var16.field813) {
                        class150.method3149(var16, var24[var28], var8, var9);
                     }
                  }
               }

               if(var11 != client.field521) {
                  class150.method3149(var20, var11, var8, var9);
               } else {
                  var4 = var7;
               }
            }

            if(var10 == 3) {
               class198 var21 = client.field419[class48.field1078][var8][var9];
               if(null != var21) {
                  for(class28 var25 = (class28)var21.method3872(); var25 != null; var25 = (class28)var21.method3863()) {
                     class51 var26 = class75.method1648(var25.field681);
                     if(client.field446 == 1) {
                        class212.method3983("Use", client.field447 + " " + "->" + " " + class51.method1090(16748608) + var26.field1115, 16, var25.field681, var8, var9);
                     } else if(client.field448) {
                        if((class15.field218 & 1) == 1) {
                           class212.method3983(client.field451, client.field452 + " " + "->" + " " + class51.method1090(16748608) + var26.field1115, 17, var25.field681, var8, var9);
                        }
                     } else {
                        String[] var29 = var26.field1129;
                        if(client.field464) {
                           var29 = client.method553(var29);
                        }

                        for(int var27 = 4; var27 >= 0; --var27) {
                           if(var29 != null && null != var29[var27]) {
                              byte var17 = 0;
                              if(var27 == 0) {
                                 var17 = 18;
                              }

                              if(1 == var27) {
                                 var17 = 19;
                              }

                              if(2 == var27) {
                                 var17 = 20;
                              }

                              if(3 == var27) {
                                 var17 = 21;
                              }

                              if(4 == var27) {
                                 var17 = 22;
                              }

                              class212.method3983(var29[var27], class51.method1090(16748608) + var26.field1115, var17, var25.field681, var8, var9);
                           } else if(2 == var27) {
                              class212.method3983("Take", class51.method1090(16748608) + var26.field1115, 20, var25.field681, var8, var9);
                           }
                        }

                        class212.method3983("Examine", class51.method1090(16748608) + var26.field1115, 1004, var25.field681, var8, var9);
                     }
                  }
               }
            }
         }
      }

      if(var4 != -1) {
         var6 = var4 & 127;
         var7 = var4 >> 7 & 127;
         class2 var18 = client.field415[client.field521];
         class150.method3149(var18, client.field521, var6, var7);
      }

   }
}
