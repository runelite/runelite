import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
@Implements("XItemContainer")
public class XItemContainer extends Node {
   @ObfuscatedName("q")
   @Export("itemIds")
   int[] itemIds = new int[]{-1};
   @ObfuscatedName("k")
   @Export("itemContainers")
   static XHashTable itemContainers = new XHashTable(32);
   @ObfuscatedName("ni")
   @ObfuscatedGetter(
      intValue = 2136477313
   )
   static int field217;
   @ObfuscatedName("e")
   public static class231[] field218;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -396530513
   )
   static int field219;
   @ObfuscatedName("f")
   @Export("stackSizes")
   int[] stackSizes = new int[]{0};

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-490254074"
   )
   static final void method157(boolean var0) {
      Client.field405 = 0;
      Client.field321 = 0;
      Player.method43();

      int var1;
      NPC var3;
      int var4;
      int var5;
      int var6;
      int var7;
      int var8;
      while(Client.field314.method2824(Client.field276) >= 27) {
         var1 = Client.field314.method2807(15);
         if(var1 == 32767) {
            break;
         }

         boolean var2 = false;
         if(Client.cachedNPCs[var1] == null) {
            Client.cachedNPCs[var1] = new NPC();
            var2 = true;
         }

         var3 = Client.cachedNPCs[var1];
         Client.field501[++Client.field319 - 1] = var1;
         var3.field858 = Client.gameCycle;
         if(var0) {
            var4 = Client.field314.method2807(8);
            if(var4 > 127) {
               var4 -= 256;
            }
         } else {
            var4 = Client.field314.method2807(5);
            if(var4 > 15) {
               var4 -= 32;
            }
         }

         var5 = Client.field314.method2807(1);
         if(var5 == 1) {
            Client.field479[++Client.field321 - 1] = var1;
         }

         var6 = Client.field314.method2807(1);
         var7 = Client.field410[Client.field314.method2807(3)];
         if(var2) {
            var3.angle = var7 * 168139939;
            var3.field876 = var7;
         }

         if(var0) {
            var8 = Client.field314.method2807(8);
            if(var8 > 127) {
               var8 -= 256;
            }
         } else {
            var8 = Client.field314.method2807(5);
            if(var8 > 15) {
               var8 -= 32;
            }
         }

         var3.composition = class110.getNpcDefinition(Client.field314.method2807(14));
         var3.field841 = var3.composition.field899;
         var3.field878 = var3.composition.field918;
         if(var3.field878 == 0) {
            var3.angle = 0;
         }

         var3.field833 = var3.composition.field905;
         var3.field834 = var3.composition.field906;
         var3.field835 = var3.composition.field907;
         var3.field836 = var3.composition.field908;
         var3.idlePoseAnimation = var3.composition.field902;
         var3.field831 = var3.composition.field901;
         var3.field832 = var3.composition.field922;
         var3.method748(var4 + class165.localPlayer.pathX[0], var8 + class165.localPlayer.pathY[0], var6 == 1);
      }

      Client.field314.method2827();

      int var13;
      for(var1 = 0; var1 < Client.field321; ++var1) {
         var13 = Client.field479[var1];
         var3 = Client.cachedNPCs[var13];
         var4 = Client.field314.method2571();
         if((var4 & 2) != 0) {
            var5 = Client.field314.method2608();
            var6 = Client.field314.method2586();
            var7 = var3.x - (var5 - class47.baseX - class47.baseX) * 64;
            var8 = var3.y - 64 * (var6 - class21.baseY - class21.baseY);
            if(var7 != 0 || var8 != 0) {
               var3.field845 = (int)(Math.atan2((double)var7, (double)var8) * 325.949D) & 2047;
            }
         }

         if((var4 & 64) != 0) {
            var3.interacting = Client.field314.method2606();
            if(var3.interacting == '\uffff') {
               var3.interacting = -1;
            }
         }

         if((var4 & 4) != 0) {
            var3.graphic = Client.field314.method2586();
            var5 = Client.field314.method2616();
            var3.field866 = var5 >> 16;
            var3.field865 = (var5 & '\uffff') + Client.gameCycle;
            var3.field827 = 0;
            var3.field864 = 0;
            if(var3.field865 > Client.gameCycle) {
               var3.field827 = -1;
            }

            if(var3.graphic == '\uffff') {
               var3.graphic = -1;
            }
         }

         if((var4 & 16) != 0) {
            var5 = Client.field314.method2571();
            int var9;
            int var10;
            int var11;
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var8 = -1;
                  var9 = -1;
                  var10 = -1;
                  var7 = Client.field314.method2554();
                  if(var7 == 32767) {
                     var7 = Client.field314.method2554();
                     var9 = Client.field314.method2554();
                     var8 = Client.field314.method2554();
                     var10 = Client.field314.method2554();
                  } else if(var7 != 32766) {
                     var9 = Client.field314.method2554();
                  } else {
                     var7 = -1;
                  }

                  var11 = Client.field314.method2554();
                  var3.method775(var7, var9, var8, var10, Client.gameCycle, var11);
               }
            }

            var6 = Client.field314.method2598();
            if(var6 > 0) {
               for(var7 = 0; var7 < var6; ++var7) {
                  var8 = Client.field314.method2554();
                  var9 = Client.field314.method2554();
                  if(var9 != 32767) {
                     var10 = Client.field314.method2554();
                     var11 = Client.field314.method2599();
                     int var12 = var9 > 0?Client.field314.method2571():var11;
                     var3.method785(var8, Client.gameCycle, var9, var10, var11, var12);
                  } else {
                     var3.method779(var8);
                  }
               }
            }
         }

         if((var4 & 8) != 0) {
            var3.composition = class110.getNpcDefinition(Client.field314.method2586());
            var3.field841 = var3.composition.field899;
            var3.field878 = var3.composition.field918;
            var3.field833 = var3.composition.field905;
            var3.field834 = var3.composition.field906;
            var3.field835 = var3.composition.field907;
            var3.field836 = var3.composition.field908;
            var3.idlePoseAnimation = var3.composition.field902;
            var3.field831 = var3.composition.field901;
            var3.field832 = var3.composition.field922;
         }

         if((var4 & 32) != 0) {
            var3.overhead = Client.field314.method2579();
            var3.field884 = 100;
         }

         if((var4 & 1) != 0) {
            var5 = Client.field314.method2606();
            if(var5 == '\uffff') {
               var5 = -1;
            }

            var6 = Client.field314.method2598();
            if(var5 == var3.animation && var5 != -1) {
               var7 = NPC.getAnimation(var5).replyMode;
               if(var7 == 1) {
                  var3.actionFrame = 0;
                  var3.field839 = 0;
                  var3.actionAnimationDisable = var6;
                  var3.field861 = 0;
               }

               if(var7 == 2) {
                  var3.field861 = 0;
               }
            } else if(var5 == -1 || var3.animation == -1 || NPC.getAnimation(var5).field1012 >= NPC.getAnimation(var3.animation).field1012) {
               var3.animation = var5;
               var3.actionFrame = 0;
               var3.field839 = 0;
               var3.actionAnimationDisable = var6;
               var3.field861 = 0;
               var3.field863 = var3.field851;
            }
         }
      }

      for(var1 = 0; var1 < Client.field405; ++var1) {
         var13 = Client.field406[var1];
         if(Client.gameCycle != Client.cachedNPCs[var13].field858) {
            Client.cachedNPCs[var13].composition = null;
            Client.cachedNPCs[var13] = null;
         }
      }

      if(Client.field314.offset != Client.field276) {
         throw new RuntimeException(Client.field314.offset + "," + Client.field276);
      } else {
         for(var1 = 0; var1 < Client.field319; ++var1) {
            if(null == Client.cachedNPCs[Client.field501[var1]]) {
               throw new RuntimeException(var1 + "," + Client.field319);
            }
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LModIcon;I)V",
      garbageValue = "-82940183"
   )
   static final void method160(ModIcon var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class217.field3202.length; ++var2) {
         class217.field3202[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class217.field3202[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class31.field715[var5] = (class217.field3202[var5 - 128] + class217.field3202[1 + var5] + class217.field3202[var5 - 1] + class217.field3202[128 + var5]) / 4;
            }
         }

         int[] var8 = class217.field3202;
         class217.field3202 = class31.field715;
         class31.field715 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var0.offsetX + var4 + 16;
                  int var6 = var3 + 16 + var0.offsetY;
                  int var7 = (var6 << 7) + var5;
                  class217.field3202[var7] = 0;
               }
            }
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2122096232"
   )
   public static boolean method164() {
      long var0 = class169.method3276();
      int var2 = (int)(var0 - class174.field2762);
      class174.field2762 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class174.field2761 += var2;
      if(class174.field2771 == 0 && class174.field2775 == 0 && class174.field2779 == 0 && class174.field2774 == 0) {
         return true;
      } else if(null == class174.field2769) {
         return false;
      } else {
         try {
            if(class174.field2761 > 30000) {
               throw new IOException();
            } else {
               class175 var3;
               Buffer var4;
               while(class174.field2775 < 20 && class174.field2774 > 0) {
                  var3 = (class175)class174.field2776.method3825();
                  var4 = new Buffer(4);
                  var4.method2556(1);
                  var4.method2558((int)var3.hash);
                  class174.field2769.method3027(var4.payload, 0, 4);
                  class174.field2765.method3822(var3, var3.hash);
                  --class174.field2774;
                  ++class174.field2775;
               }

               while(class174.field2771 < 20 && class174.field2779 > 0) {
                  var3 = (class175)class174.field2767.method3914();
                  var4 = new Buffer(4);
                  var4.method2556(0);
                  var4.method2558((int)var3.hash);
                  class174.field2769.method3027(var4.payload, 0, 4);
                  var3.method3932();
                  class174.field2764.method3822(var3, var3.hash);
                  --class174.field2779;
                  ++class174.field2771;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class174.field2769.method3022();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class174.field2761 = 0;
                  byte var5 = 0;
                  if(class221.field3215 == null) {
                     var5 = 8;
                  } else if(class174.field2773 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class174.field2772.offset;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class174.field2769.method3024(class174.field2772.payload, class174.field2772.offset, var6);
                     if(class174.field2766 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class174.field2772.payload[var7 + class174.field2772.offset] ^= class174.field2766;
                        }
                     }

                     class174.field2772.offset += var6;
                     if(class174.field2772.offset < var5) {
                        break;
                     }

                     if(null == class221.field3215) {
                        class174.field2772.offset = 0;
                        var7 = class174.field2772.method2571();
                        var8 = class174.field2772.method2691();
                        int var9 = class174.field2772.method2571();
                        var10 = class174.field2772.method2576();
                        long var11 = (long)((var7 << 16) + var8);
                        class175 var13 = (class175)class174.field2765.method3828(var11);
                        class112.field1969 = true;
                        if(null == var13) {
                           var13 = (class175)class174.field2764.method3828(var11);
                           class112.field1969 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var9 == 0?5:9;
                        class221.field3215 = var13;
                        class18.field261 = new Buffer(var14 + var10 + class221.field3215.field2784);
                        class18.field261.method2556(var9);
                        class18.field261.method2559(var10);
                        class174.field2773 = 8;
                        class174.field2772.offset = 0;
                     } else if(class174.field2773 == 0) {
                        if(class174.field2772.payload[0] == -1) {
                           class174.field2773 = 1;
                           class174.field2772.offset = 0;
                        } else {
                           class221.field3215 = null;
                        }
                     }
                  } else {
                     var6 = class18.field261.payload.length - class221.field3215.field2784;
                     var7 = 512 - class174.field2773;
                     if(var7 > var6 - class18.field261.offset) {
                        var7 = var6 - class18.field261.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class174.field2769.method3024(class18.field261.payload, class18.field261.offset, var7);
                     if(class174.field2766 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           class18.field261.payload[class18.field261.offset + var8] ^= class174.field2766;
                        }
                     }

                     class18.field261.offset += var7;
                     class174.field2773 += var7;
                     if(class18.field261.offset == var6) {
                        if(16711935L == class221.field3215.hash) {
                           class31.field719 = class18.field261;

                           for(var8 = 0; var8 < 256; ++var8) {
                              class171 var17 = class174.field2781[var8];
                              if(null != var17) {
                                 class31.field719.offset = 5 + var8 * 8;
                                 var10 = class31.field719.method2576();
                                 int var21 = class31.field719.method2576();
                                 var17.method3367(var10, var21);
                              }
                           }
                        } else {
                           class174.field2760.reset();
                           class174.field2760.update(class18.field261.payload, 0, var6);
                           var8 = (int)class174.field2760.getValue();
                           if(var8 != class221.field3215.field2785) {
                              try {
                                 class174.field2769.method3020();
                              } catch (Exception var19) {
                                 ;
                              }

                              ++class174.field2777;
                              class174.field2769 = null;
                              class174.field2766 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class174.field2777 = 0;
                           class174.field2778 = 0;
                           class221.field3215.field2782.method3390((int)(class221.field3215.hash & 65535L), class18.field261.payload, (class221.field3215.hash & 16711680L) == 16711680L, class112.field1969);
                        }

                        class221.field3215.unlink();
                        if(class112.field1969) {
                           --class174.field2775;
                        } else {
                           --class174.field2771;
                        }

                        class174.field2773 = 0;
                        class221.field3215 = null;
                        class18.field261 = null;
                     } else {
                        if(class174.field2773 != 512) {
                           break;
                        }

                        class174.field2773 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var20) {
            try {
               class174.field2769.method3020();
            } catch (Exception var18) {
               ;
            }

            ++class174.field2778;
            class174.field2769 = null;
            return false;
         }
      }
   }

   @ObfuscatedName("bv")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1803673376"
   )
   static final void method165(int var0, int var1) {
      int var2 = PlayerComposition.field2977.method4047("Choose Option");

      int var3;
      for(var3 = 0; var3 < Client.menuOptionCount; ++var3) {
         class227 var4 = PlayerComposition.field2977;
         String var7;
         if(Client.menuTargets[var3].length() > 0) {
            var7 = Client.menuOptions[var3] + " " + Client.menuTargets[var3];
         } else {
            var7 = Client.menuOptions[var3];
         }

         int var6 = var4.method4047(var7);
         if(var6 > var2) {
            var2 = var6;
         }
      }

      var2 += 8;
      var3 = Client.menuOptionCount * 15 + 22;
      int var8 = var0 - var2 / 2;
      if(var2 + var8 > GroundObject.field1652) {
         var8 = GroundObject.field1652 - var2;
      }

      if(var8 < 0) {
         var8 = 0;
      }

      int var5 = var1;
      if(var1 + var3 > VertexNormal.field1689) {
         var5 = VertexNormal.field1689 - var3;
      }

      if(var5 < 0) {
         var5 = 0;
      }

      Client.isMenuOpen = true;
      Client.menuX = var8;
      class0.menuY = var5;
      class43.menuWidth = var2;
      class26.menuHeight = 22 + Client.menuOptionCount * 15;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "36"
   )
   static int method166() {
      return 9;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1809169475"
   )
   public static void method167(int var0) {
      class186.field3007 = 1;
      class133.field2114 = null;
      NPC.field794 = -1;
      class116.field2023 = -1;
      class28.field666 = 0;
      class93.field1626 = false;
      class165.field2689 = var0;
   }
}
