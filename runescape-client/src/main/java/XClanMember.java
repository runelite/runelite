import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("u")
@Implements("XClanMember")
public class XClanMember extends Node {
   @ObfuscatedName("n")
   @Export("username")
   String username;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -501972081
   )
   @Export("world")
   int world;
   @ObfuscatedName("h")
   @Export("rank")
   byte rank;
   @ObfuscatedName("mg")
   static byte field273;
   @ObfuscatedName("bi")
   static class184 field275;
   @ObfuscatedName("d")
   String field277;
   @ObfuscatedName("hm")
   @ObfuscatedGetter(
      intValue = 322238141
   )
   @Export("menuY")
   static int menuY;

   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "872510139"
   )
   static final void method261() {
      for(int var0 = 0; var0 < Client.field337; ++var0) {
         int var1 = Client.field329[var0];
         NPC var2 = Client.cachedNPCs[var1];
         int var3 = Client.field370.method3033();
         if((var3 & 2) != 0) {
            var2.interacting = Client.field370.method3026();
            if(var2.interacting == '\uffff') {
               var2.interacting = -1;
            }
         }

         int var4;
         if((var3 & 4) != 0) {
            var2.graphic = Client.field370.method3025();
            var4 = Client.field370.method3037();
            var2.field636 = var4 >> 16;
            var2.field608 = Client.gameCycle + (var4 & '\uffff');
            var2.field633 = 0;
            var2.field616 = 0;
            if(var2.field608 > Client.gameCycle) {
               var2.field633 = -1;
            }

            if(var2.graphic == '\uffff') {
               var2.graphic = -1;
            }
         }

         if((var3 & 8) != 0) {
            var2.overhead = Client.field370.method3057();
            var2.field607 = 100;
         }

         int var5;
         int var6;
         int var7;
         if((var3 & 32) != 0) {
            var4 = Client.field370.method3017();
            int var8;
            int var9;
            int var10;
            if(var4 > 0) {
               for(var5 = 0; var5 < var4; ++var5) {
                  var7 = -1;
                  var8 = -1;
                  var9 = -1;
                  var6 = Client.field370.method3003();
                  if(var6 == 32767) {
                     var6 = Client.field370.method3003();
                     var8 = Client.field370.method3003();
                     var7 = Client.field370.method3003();
                     var9 = Client.field370.method3003();
                  } else if(var6 != 32766) {
                     var8 = Client.field370.method3003();
                  } else {
                     var6 = -1;
                  }

                  var10 = Client.field370.method3003();
                  var2.method624(var6, var8, var7, var9, Client.gameCycle, var10);
               }
            }

            var5 = Client.field370.method3017();
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var7 = Client.field370.method3003();
                  var8 = Client.field370.method3003();
                  if(var8 != 32767) {
                     var9 = Client.field370.method3003();
                     var10 = Client.field370.method3018();
                     int var11 = var8 > 0?Client.field370.method3033():var10;
                     var2.method620(var7, Client.gameCycle, var8, var9, var10, var11);
                  } else {
                     var2.method621(var7);
                  }
               }
            }
         }

         if((var3 & 16) != 0) {
            var4 = Client.field370.method3025();
            if(var4 == '\uffff') {
               var4 = -1;
            }

            var5 = Client.field370.method3018();
            if(var2.animation == var4 && var4 != -1) {
               var6 = class9.getAnimation(var4).replyMode;
               if(var6 == 1) {
                  var2.actionFrame = 0;
                  var2.field595 = 0;
                  var2.actionAnimationDisable = var5;
                  var2.field631 = 0;
               }

               if(var6 == 2) {
                  var2.field631 = 0;
               }
            } else if(var4 == -1 || var2.animation == -1 || class9.getAnimation(var4).field3054 >= class9.getAnimation(var2.animation).field3054) {
               var2.animation = var4;
               var2.actionFrame = 0;
               var2.field595 = 0;
               var2.actionAnimationDisable = var5;
               var2.field631 = 0;
               var2.field654 = var2.field649;
            }
         }

         if((var3 & 1) != 0) {
            var4 = Client.field370.method3097();
            var5 = Client.field370.method3153();
            var6 = var2.x - 64 * (var4 - class16.baseX - class16.baseX);
            var7 = var2.y - 64 * (var5 - Client.baseY - Client.baseY);
            if(var6 != 0 || var7 != 0) {
               var2.field623 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if((var3 & 64) != 0) {
            var2.composition = class152.getNpcDefinition(Client.field370.method3153());
            var2.field599 = var2.composition.field3009;
            var2.field629 = var2.composition.field3021;
            var2.field603 = var2.composition.field2998;
            var2.field650 = var2.composition.field3005;
            var2.field605 = var2.composition.field3011;
            var2.field606 = var2.composition.field3007;
            var2.idlePoseAnimation = var2.composition.field3001;
            var2.field601 = var2.composition.field3006;
            var2.field604 = var2.composition.field3003;
         }
      }

   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(IIIIB)V",
      garbageValue = "8"
   )
   static final void method262(int var0, int var1, int var2, int var3) {
      if(Client.field501 == 1) {
         class110.field1745[Client.field397 / 100].method4192(Client.field395 - 8, Client.field396 - 8);
      }

      if(Client.field501 == 2) {
         class110.field1745[4 + Client.field397 / 100].method4192(Client.field395 - 8, Client.field396 - 8);
      }

      WallObject.method1920();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "921071679"
   )
   public static boolean method263() {
      long var0 = class202.method3838();
      int var2 = (int)(var0 - class185.field2747);
      class185.field2747 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class185.field2746 += var2;
      if(class185.field2756 == 0 && class185.field2745 == 0 && class185.field2754 == 0 && class185.field2749 == 0) {
         return true;
      } else if(null == class185.field2761) {
         return false;
      } else {
         try {
            if(class185.field2746 > 30000) {
               throw new IOException();
            } else {
               class181 var3;
               Buffer var4;
               while(class185.field2745 < 20 && class185.field2749 > 0) {
                  var3 = (class181)class185.field2748.method2414();
                  var4 = new Buffer(4);
                  var4.method2975(1);
                  var4.method2977((int)var3.hash);
                  class185.field2761.method2107(var4.payload, 0, 4);
                  class185.field2750.method2406(var3, var3.hash);
                  --class185.field2749;
                  ++class185.field2745;
               }

               while(class185.field2756 < 20 && class185.field2754 > 0) {
                  var3 = (class181)class185.field2752.method2355();
                  var4 = new Buffer(4);
                  var4.method2975(0);
                  var4.method2977((int)var3.hash);
                  class185.field2761.method2107(var4.payload, 0, 4);
                  var3.method2483();
                  class185.field2755.method2406(var3, var3.hash);
                  --class185.field2754;
                  ++class185.field2756;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class185.field2761.method2105();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class185.field2746 = 0;
                  byte var5 = 0;
                  if(class162.field2308 == null) {
                     var5 = 8;
                  } else if(class185.field2751 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class185.field2758.offset;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class185.field2761.method2106(class185.field2758.payload, class185.field2758.offset, var6);
                     if(class185.field2762 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class185.field2758.payload[class185.field2758.offset + var7] ^= class185.field2762;
                        }
                     }

                     class185.field2758.offset += var6;
                     if(class185.field2758.offset < var5) {
                        break;
                     }

                     if(class162.field2308 == null) {
                        class185.field2758.offset = 0;
                        var7 = class185.field2758.method3033();
                        var8 = class185.field2758.method3097();
                        int var9 = class185.field2758.method3033();
                        var10 = class185.field2758.method2995();
                        long var11 = (long)(var8 + (var7 << 16));
                        class181 var13 = (class181)class185.field2750.method2405(var11);
                        class8.field77 = true;
                        if(var13 == null) {
                           var13 = (class181)class185.field2755.method2405(var11);
                           class8.field77 = false;
                        }

                        if(null == var13) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        class162.field2308 = var13;
                        PlayerComposition.field2046 = new Buffer(class162.field2308.field2705 + var10 + var14);
                        PlayerComposition.field2046.method2975(var9);
                        PlayerComposition.field2046.method2978(var10);
                        class185.field2751 = 8;
                        class185.field2758.offset = 0;
                     } else if(class185.field2751 == 0) {
                        if(class185.field2758.payload[0] == -1) {
                           class185.field2751 = 1;
                           class185.field2758.offset = 0;
                        } else {
                           class162.field2308 = null;
                        }
                     }
                  } else {
                     var6 = PlayerComposition.field2046.payload.length - class162.field2308.field2705;
                     var7 = 512 - class185.field2751;
                     if(var7 > var6 - PlayerComposition.field2046.offset) {
                        var7 = var6 - PlayerComposition.field2046.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class185.field2761.method2106(PlayerComposition.field2046.payload, PlayerComposition.field2046.offset, var7);
                     if(class185.field2762 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           PlayerComposition.field2046.payload[var8 + PlayerComposition.field2046.offset] ^= class185.field2762;
                        }
                     }

                     PlayerComposition.field2046.offset += var7;
                     class185.field2751 += var7;
                     if(PlayerComposition.field2046.offset == var6) {
                        if(class162.field2308.hash == 16711935L) {
                           class112.field1766 = PlayerComposition.field2046;

                           for(var8 = 0; var8 < 256; ++var8) {
                              class184 var17 = class185.field2760[var8];
                              if(null != var17) {
                                 class112.field1766.offset = 8 * var8 + 5;
                                 var10 = class112.field1766.method2995();
                                 int var21 = class112.field1766.method2995();
                                 var17.method3427(var10, var21);
                              }
                           }
                        } else {
                           class185.field2759.reset();
                           class185.field2759.update(PlayerComposition.field2046.payload, 0, var6);
                           var8 = (int)class185.field2759.getValue();
                           if(class162.field2308.field2704 != var8) {
                              try {
                                 class185.field2761.method2121();
                              } catch (Exception var19) {
                                 ;
                              }

                              ++class185.field2757;
                              class185.field2761 = null;
                              class185.field2762 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class185.field2757 = 0;
                           class185.field2763 = 0;
                           class162.field2308.field2703.method3445((int)(class162.field2308.hash & 65535L), PlayerComposition.field2046.payload, 16711680L == (class162.field2308.hash & 16711680L), class8.field77);
                        }

                        class162.field2308.unlink();
                        if(class8.field77) {
                           --class185.field2745;
                        } else {
                           --class185.field2756;
                        }

                        class185.field2751 = 0;
                        class162.field2308 = null;
                        PlayerComposition.field2046 = null;
                     } else {
                        if(class185.field2751 != 512) {
                           break;
                        }

                        class185.field2751 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var20) {
            try {
               class185.field2761.method2121();
            } catch (Exception var18) {
               ;
            }

            ++class185.field2763;
            class185.field2761 = null;
            return false;
         }
      }
   }

   @ObfuscatedName("ad")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-614725307"
   )
   static void method264() {
      int var0 = class16.field169;
      int var1 = class65.field1103;
      if(class166.field2322 < var0) {
         var0 = class166.field2322;
      }

      if(class49.field953 < var1) {
         var1 = class49.field953;
      }

      if(null != Tile.field1343) {
         try {
            Client var2 = Client.field281;
            Object[] var3 = new Object[]{Integer.valueOf(class105.method2061())};
            JSObject.getWindow(var2).call("resize", var3);
         } catch (Throwable var4) {
            ;
         }
      }

   }
}
