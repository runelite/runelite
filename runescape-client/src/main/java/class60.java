import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("be")
public class class60 {
   @ObfuscatedName("fh")
   @ObfuscatedGetter(
      intValue = 1373831019
   )
   @Export("cameraYaw")
   static int cameraYaw;
   @ObfuscatedName("o")
   class182 field1079;
   @ObfuscatedName("b")
   XHashTable field1080 = new XHashTable(256);
   @ObfuscatedName("g")
   XHashTable field1081 = new XHashTable(256);
   @ObfuscatedName("m")
   class182 field1082;
   @ObfuscatedName("y")
   public static class144 field1083;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass55;",
      garbageValue = "1788201606"
   )
   class55 method1118(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4;
      class55 var7 = (class55)this.field1081.method2299(var5);
      if(null != var7) {
         return var7;
      } else if(null != var3 && var3[0] <= 0) {
         return null;
      } else {
         class53 var8 = class53.method955(this.field1079, var1, var2);
         if(var8 == null) {
            return null;
         } else {
            var7 = var8.method944();
            this.field1081.method2291(var7, var5);
            if(null != var3) {
               var3[0] -= var7.field1022.length;
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass55;",
      garbageValue = "-726109313"
   )
   public class55 method1119(int var1, int[] var2) {
      if(this.field1082.method3254() == 1) {
         return this.method1125(0, var1, var2);
      } else if(this.field1082.method3245(var1) == 1) {
         return this.method1125(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I[II)Lclass55;",
      garbageValue = "104653714"
   )
   public class55 method1120(int var1, int[] var2) {
      if(this.field1079.method3254() == 1) {
         return this.method1118(0, var1, var2);
      } else if(this.field1079.method3245(var1) == 1) {
         return this.method1118(var1, 0, var2);
      } else {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-910132286"
   )
   static final void method1121() {
      for(class33 var0 = (class33)Client.field511.method2349(); null != var0; var0 = (class33)Client.field511.method2351()) {
         if(class63.plane == var0.field747 && !var0.field754) {
            if(Client.gameCycle >= var0.field758) {
               var0.method672(Client.field363);
               if(var0.field754) {
                  var0.unlink();
               } else {
                  class159.region.method1677(var0.field747, var0.field750, var0.field745, var0.field755, 60, var0, 0, -1, false);
               }
            }
         } else {
            var0.unlink();
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II[II)Lclass55;",
      garbageValue = "2058705862"
   )
   class55 method1125(int var1, int var2, int[] var3) {
      int var4 = var2 ^ (var1 << 4 & '\uffff' | var1 >>> 12);
      var4 |= var1 << 16;
      long var5 = (long)var4 ^ 4294967296L;
      class55 var7 = (class55)this.field1081.method2299(var5);
      if(null != var7) {
         return var7;
      } else if(var3 != null && var3[0] <= 0) {
         return null;
      } else {
         class54 var8 = (class54)this.field1080.method2299(var5);
         if(null == var8) {
            var8 = class54.method961(this.field1082, var1, var2);
            if(null == var8) {
               return null;
            }

            this.field1080.method2291(var8, var5);
         }

         var7 = var8.method966(var3);
         if(null == var7) {
            return null;
         } else {
            var8.unlink();
            this.field1081.method2291(var7, var5);
            return var7;
         }
      }
   }

   @ObfuscatedName("dp")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "396296161"
   )
   static final void method1130(String var0) {
      if(var0 != null) {
         String var1 = class162.method3013(var0, Friend.field155);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
               Ignore var3 = Client.ignores[var2];
               String var4 = var3.name;
               String var5 = class162.method3013(var4, Friend.field155);
               boolean var6;
               if(null != var0 && var4 != null) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --Client.ignoreCount;

                  for(int var7 = var2; var7 < Client.ignoreCount; ++var7) {
                     Client.ignores[var7] = Client.ignores[1 + var7];
                  }

                  Client.field477 = Client.field469;
                  Client.field330.method2967(184);
                  Client.field330.method2815(class112.method2050(var0));
                  Client.field330.method2717(var0);
                  break;
               }
            }

         }
      }
   }

   public class60(class182 var1, class182 var2) {
      this.field1079 = var1;
      this.field1082 = var2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1762454557"
   )
   static int method1132() {
      return 9;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIILclass119;LCollisionData;I)Z",
      garbageValue = "-1472420514"
   )
   public static final boolean method1133(int var0, int var1, int var2, class119 var3, CollisionData var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class118.field1855[var7][var8] = 99;
      class118.field1856[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class118.field1853[var11] = var0;
      int var20 = var11 + 1;
      class118.field1859[var11] = var1;
      int[][] var13 = var4.flags;

      while(true) {
         label353:
         while(true) {
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            do {
               do {
                  do {
                     label330:
                     do {
                        if(var12 == var20) {
                           class118.field1863 = var5;
                           class168.field2197 = var6;
                           return false;
                        }

                        var5 = class118.field1853[var12];
                        var6 = class118.field1859[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.x;
                        var15 = var6 - var4.y;
                        if(var3.vmethod2239(var2, var5, var6, var4)) {
                           class118.field1863 = var5;
                           class168.field2197 = var6;
                           return true;
                        }

                        var16 = class118.field1856[var18][var19] + 1;
                        if(var18 > 0 && class118.field1855[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var2 + var15 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class118.field1853[var20] = var5 - 1;
                                 class118.field1859[var20] = var6;
                                 var20 = 1 + var20 & 4095;
                                 class118.field1855[var18 - 1][var19] = 2;
                                 class118.field1856[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class118.field1855[var18 + 1][var19] == 0 && (var13[var2 + var14][var15] & 19136899) == 0 && (var13[var14 + var2][var15 + var2 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class118.field1853[var20] = var5 + 1;
                                 class118.field1859[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class118.field1855[1 + var18][var19] = 8;
                                 class118.field1856[1 + var18][var19] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class118.field1855[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class118.field1853[var20] = var5;
                                 class118.field1859[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class118.field1855[var18][var19 - 1] = 1;
                                 class118.field1856[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var17 + var14][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class118.field1855[var18][var19 + 1] == 0 && (var13[var14][var2 + var15] & 19136824) == 0 && (var13[var14 + var2 - 1][var15 + var2] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class118.field1853[var20] = var5;
                                 class118.field1859[var20] = var6 + 1;
                                 var20 = var20 + 1 & 4095;
                                 class118.field1855[var18][1 + var19] = 4;
                                 class118.field1856[var18][var19 + 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var2 + var15] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class118.field1855[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class118.field1853[var20] = var5 - 1;
                                 class118.field1859[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class118.field1855[var18 - 1][var19 - 1] = 3;
                                 class118.field1856[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var15 - 1 + var17] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class118.field1855[1 + var18][var19 - 1] == 0 && (var13[var14 + var2][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class118.field1853[var20] = var5 + 1;
                                 class118.field1859[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class118.field1855[var18 + 1][var19 - 1] = 9;
                                 class118.field1856[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var17 + (var15 - 1)] & 19136995) != 0 || (var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class118.field1855[var18 - 1][1 + var19] == 0 && (var13[var14 - 1][var15 + var2] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0 || (var13[var14 - 1 + var17][var2 + var15] & 19137016) != 0) {
                                 continue label330;
                              }
                           }

                           class118.field1853[var20] = var5 - 1;
                           class118.field1859[var20] = 1 + var6;
                           var20 = var20 + 1 & 4095;
                           class118.field1855[var18 - 1][1 + var19] = 6;
                           class118.field1856[var18 - 1][1 + var19] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class118.field1855[var18 + 1][1 + var19] != 0);
            } while((var13[var2 + var14][var2 + var15] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var17 + var14][var15 + var2] & 19137016) != 0 || (var13[var2 + var14][var17 + var15] & 19136995) != 0) {
                  continue label353;
               }
            }

            class118.field1853[var20] = 1 + var5;
            class118.field1859[var20] = var6 + 1;
            var20 = var20 + 1 & 4095;
            class118.field1855[1 + var18][var19 + 1] = 12;
            class118.field1856[var18 + 1][1 + var19] = var16;
         }
      }
   }
}
