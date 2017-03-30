import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fj")
public class class173 {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;I)V",
      garbageValue = "1434318672"
   )
   static final void method3308(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field306 || (class10.tileSettings[0][var1][var2] & 2) != 0 || (class10.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class10.field86) {
            class10.field86 = var0;
         }

         ObjectComposition var8 = class140.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.sizeX;
            var10 = var8.sizeY;
         } else {
            var9 = var8.sizeY;
            var10 = var8.sizeX;
         }

         int var11;
         int var12;
         if(var9 + var1 <= 104) {
            var11 = var1 + (var9 >> 1);
            var12 = var1 + (1 + var9 >> 1);
         } else {
            var11 = var1;
            var12 = 1 + var1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = var2 + (var10 >> 1);
            var14 = var2 + (var10 + 1 >> 1);
         } else {
            var13 = var2;
            var14 = 1 + var2;
         }

         int[][] var15 = class10.tileHeights[var0];
         int var16 = var15[var11][var14] + var15[var12][var13] + var15[var11][var13] + var15[var12][var14] >> 2;
         int var17 = (var9 << 6) + (var1 << 7);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = 1073741824 + var1 + (var2 << 7) + (var3 << 14);
         if(var8.field2916 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = (var4 << 6) + var5;
         if(var8.field2937 == 1) {
            var20 += 256;
         }

         if(var8.method3658()) {
            Ignore.method176(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(var5 == 22) {
            if(!Client.field306 || var8.field2916 != 0 || var8.field2914 == 1 || var8.field2945) {
               if(var8.animationId == -1 && null == var8.impostorIds) {
                  var21 = var8.method3652(22, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class49(var3, 22, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var21, var19, var20);
               if(var8.field2914 == 1 && var7 != null) {
                  var7.method2320(var1, var2);
               }

            }
         } else {
            int var22;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.animationId == -1 && var8.impostorIds == null) {
                     var21 = var8.method3652(var5, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class49(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1749(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class162.field2166[var0][var1][var2] |= 2340;
                  }

                  if(var8.field2914 != 0 && var7 != null) {
                     var7.method2330(var1, var2, var9, var10, var8.field2915);
                  }

               } else if(var5 == 0) {
                  if(var8.animationId == -1 && null == var8.impostorIds) {
                     var21 = var8.method3652(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class49(var3, 0, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1876(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class10.field90[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.field2922) {
                        Ignore.field219[var0][var1][var2] = 50;
                        Ignore.field219[var0][var1][var2 + 1] = 50;
                     }

                     if(var8.field2933) {
                        class162.field2166[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.field2922) {
                        Ignore.field219[var0][var1][var2 + 1] = 50;
                        Ignore.field219[var0][1 + var1][1 + var2] = 50;
                     }

                     if(var8.field2933) {
                        class162.field2166[var0][var1][var2 + 1] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.field2922) {
                        Ignore.field219[var0][var1 + 1][var2] = 50;
                        Ignore.field219[var0][1 + var1][1 + var2] = 50;
                     }

                     if(var8.field2933) {
                        class162.field2166[var0][1 + var1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.field2922) {
                        Ignore.field219[var0][var1][var2] = 50;
                        Ignore.field219[var0][var1 + 1][var2] = 50;
                     }

                     if(var8.field2933) {
                        class162.field2166[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.field2914 != 0 && var7 != null) {
                     var7.method2317(var1, var2, var5, var4, var8.field2915);
                  }

                  if(var8.field2899 != 16) {
                     var6.method1752(var0, var1, var2, var8.field2899);
                  }

               } else if(var5 == 1) {
                  if(var8.animationId == -1 && null == var8.impostorIds) {
                     var21 = var8.method3652(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class49(var3, 1, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                  }

                  var6.method1876(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class10.field101[var4], 0, var19, var20);
                  if(var8.field2922) {
                     if(var4 == 0) {
                        Ignore.field219[var0][var1][var2 + 1] = 50;
                     } else if(var4 == 1) {
                        Ignore.field219[var0][var1 + 1][var2 + 1] = 50;
                     } else if(var4 == 2) {
                        Ignore.field219[var0][var1 + 1][var2] = 50;
                     } else if(var4 == 3) {
                        Ignore.field219[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field2914 != 0 && var7 != null) {
                     var7.method2317(var1, var2, var5, var4, var8.field2915);
                  }

               } else {
                  int var27;
                  Object var28;
                  if(var5 == 2) {
                     var27 = 1 + var4 & 3;
                     Object var29;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var29 = var8.method3652(2, var4 + 4, var15, var17, var16, var18);
                        var28 = var8.method3652(2, var27, var15, var17, var16, var18);
                     } else {
                        var29 = new class49(var3, 2, 4 + var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var28 = new class49(var3, 2, var27, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1876(var0, var1, var2, var16, (Renderable)var29, (Renderable)var28, class10.field90[var4], class10.field90[var27], var19, var20);
                     if(var8.field2933) {
                        if(var4 == 0) {
                           class162.field2166[var0][var1][var2] |= 585;
                           class162.field2166[var0][var1][1 + var2] |= 1170;
                        } else if(var4 == 1) {
                           class162.field2166[var0][var1][var2 + 1] |= 1170;
                           class162.field2166[var0][var1 + 1][var2] |= 585;
                        } else if(var4 == 2) {
                           class162.field2166[var0][1 + var1][var2] |= 585;
                           class162.field2166[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class162.field2166[var0][var1][var2] |= 1170;
                           class162.field2166[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.field2914 != 0 && null != var7) {
                        var7.method2317(var1, var2, var5, var4, var8.field2915);
                     }

                     if(var8.field2899 != 16) {
                        var6.method1752(var0, var1, var2, var8.field2899);
                     }

                  } else if(var5 == 3) {
                     if(var8.animationId == -1 && null == var8.impostorIds) {
                        var21 = var8.method3652(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, 3, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1876(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class10.field101[var4], 0, var19, var20);
                     if(var8.field2922) {
                        if(var4 == 0) {
                           Ignore.field219[var0][var1][var2 + 1] = 50;
                        } else if(var4 == 1) {
                           Ignore.field219[var0][var1 + 1][var2 + 1] = 50;
                        } else if(var4 == 2) {
                           Ignore.field219[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           Ignore.field219[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.field2914 != 0 && null != var7) {
                        var7.method2317(var1, var2, var5, var4, var8.field2915);
                     }

                  } else if(var5 == 9) {
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var21 = var8.method3652(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, var5, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1749(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                     if(var8.field2914 != 0 && var7 != null) {
                        var7.method2330(var1, var2, var9, var10, var8.field2915);
                     }

                     if(var8.field2899 != 16) {
                        var6.method1752(var0, var1, var2, var8.field2899);
                     }

                  } else if(var5 == 4) {
                     if(var8.animationId == -1 && null == var8.impostorIds) {
                        var21 = var8.method3652(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1745(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class10.field90[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var27 = 16;
                     var22 = var6.method1762(var0, var1, var2);
                     if(var22 != 0) {
                        var27 = class140.getObjectDefinition(var22 >> 14 & 32767).field2899;
                     }

                     if(var8.animationId == -1 && null == var8.impostorIds) {
                        var28 = var8.method3652(4, var4, var15, var17, var16, var18);
                     } else {
                        var28 = new class49(var3, 4, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1745(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, class10.field90[var4], 0, class10.field92[var4] * var27, var27 * class10.field93[var4], var19, var20);
                  } else if(var5 == 6) {
                     var27 = 8;
                     var22 = var6.method1762(var0, var1, var2);
                     if(var22 != 0) {
                        var27 = class140.getObjectDefinition(var22 >> 14 & 32767).field2899 / 2;
                     }

                     if(var8.animationId == -1 && null == var8.impostorIds) {
                        var28 = var8.method3652(4, 4 + var4, var15, var17, var16, var18);
                     } else {
                        var28 = new class49(var3, 4, var4 + 4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1745(var0, var1, var2, var16, (Renderable)var28, (Renderable)null, 256, var4, var27 * class10.field84[var4], class10.field95[var4] * var27, var19, var20);
                  } else if(var5 == 7) {
                     var22 = 2 + var4 & 3;
                     if(var8.animationId == -1 && null == var8.impostorIds) {
                        var21 = var8.method3652(4, var22 + 4, var15, var17, var16, var18);
                     } else {
                        var21 = new class49(var3, 4, 4 + var22, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1745(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, 256, var22, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var27 = 8;
                     var22 = var6.method1762(var0, var1, var2);
                     if(var22 != 0) {
                        var27 = class140.getObjectDefinition(var22 >> 14 & 32767).field2899 / 2;
                     }

                     int var25 = 2 + var4 & 3;
                     Object var26;
                     if(var8.animationId == -1 && var8.impostorIds == null) {
                        var28 = var8.method3652(4, var4 + 4, var15, var17, var16, var18);
                        var26 = var8.method3652(4, 4 + var25, var15, var17, var16, var18);
                     } else {
                        var28 = new class49(var3, 4, 4 + var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
                        var26 = new class49(var3, 4, 4 + var25, var0, var1, var2, var8.animationId, true, (Renderable)null);
                     }

                     var6.method1745(var0, var1, var2, var16, (Renderable)var28, (Renderable)var26, 256, var4, class10.field84[var4] * var27, var27 * class10.field95[var4], var19, var20);
                  }
               }
            } else {
               if(var8.animationId == -1 && var8.impostorIds == null) {
                  var21 = var8.method3652(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class49(var3, 10, var4, var0, var1, var2, var8.animationId, true, (Renderable)null);
               }

               if(var21 != null && var6.method1749(var0, var1, var2, var16, var9, var10, (Renderable)var21, var5 == 11?256:0, var19, var20) && var8.field2922) {
                  var22 = 15;
                  if(var21 instanceof Model) {
                     var22 = ((Model)var21).method1589() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var23 = 0; var23 <= var9; ++var23) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > Ignore.field219[var0][var23 + var1][var2 + var24]) {
                           Ignore.field219[var0][var1 + var23][var24 + var2] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.field2914 != 0 && null != var7) {
                  var7.method2330(var1, var2, var9, var10, var8.field2915);
               }

            }
         }
      }
   }

   class173() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "65536"
   )
   static char method3309(char var0) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
      case 'À':
      case 'Á':
      case 'Â':
      case 'Ã':
      case 'Ä':
      case 'à':
      case 'á':
      case 'â':
      case 'ã':
      case 'ä':
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
      case 'Ò':
      case 'Ó':
      case 'Ô':
      case 'Õ':
      case 'Ö':
      case 'ò':
      case 'ó':
      case 'ô':
      case 'õ':
      case 'ö':
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(var0);
      }
   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZB)Ljava/lang/String;",
      garbageValue = "6"
   )
   static String method3310(String var0, boolean var1) {
      String var2 = var1?"https://":"http://";
      if(Client.field580 == 1) {
         var0 = var0 + "-wtrc";
      } else if(Client.field580 == 2) {
         var0 = var0 + "-wtqa";
      } else if(Client.field580 == 3) {
         var0 = var0 + "-wtwip";
      } else if(Client.field580 == 5) {
         var0 = var0 + "-wti";
      } else if(Client.field580 == 4) {
         var0 = "local";
      }

      String var3 = "";
      if(null != class156.field2133) {
         var3 = "/p=" + class156.field2133;
      }

      String var4 = "runescape.com";
      return var2 + var0 + "." + var4 + "/l=" + Client.field308 + "/a=" + Client.field377 + var3 + "/";
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass184;II)V",
      garbageValue = "-1471370695"
   )
   static void method3311(IndexData var0, int var1) {
      if(null != class149.field2064) {
         class149.field2064.offset = 5 + var1 * 8;
         int var2 = class149.field2064.readInt();
         int var3 = class149.field2064.readInt();
         var0.method3420(var2, var3);
      } else {
         class205.method3844((IndexData)null, 255, 255, 0, (byte)0, true);
         class185.field2779[var1] = var0;
      }
   }
}
