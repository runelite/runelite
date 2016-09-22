import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
public class class52 extends CacheableNode {
   @ObfuscatedName("v")
   public char field1144;
   @ObfuscatedName("m")
   public String[] field1145;
   @ObfuscatedName("a")
   public static class170 field1146;
   @ObfuscatedName("r")
   public char field1147;
   @ObfuscatedName("z")
   public String field1148 = "null";
   @ObfuscatedName("d")
   public static NodeCache field1149 = new NodeCache(64);
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -593231841
   )
   public int field1150 = 0;
   @ObfuscatedName("i")
   public int[] field1151;
   @ObfuscatedName("g")
   public int[] field1152;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -758477987
   )
   public int field1153;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "13"
   )
   public void method1090(Buffer var1) {
      while(true) {
         int var2 = var1.method2528();
         if(var2 == 0) {
            return;
         }

         this.method1091(var1, var2);
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1729118658"
   )
   void method1091(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1144 = (char)var1.method2528();
      } else if(var2 == 2) {
         this.field1147 = (char)var1.method2528();
      } else if(var2 == 3) {
         this.field1148 = var1.method2530();
      } else if(var2 == 4) {
         this.field1153 = var1.method2533();
      } else {
         int var3;
         if(var2 == 5) {
            this.field1150 = var1.method2717();
            this.field1151 = new int[this.field1150];
            this.field1145 = new String[this.field1150];

            for(var3 = 0; var3 < this.field1150; ++var3) {
               this.field1151[var3] = var1.method2533();
               this.field1145[var3] = var1.method2530();
            }
         } else if(var2 == 6) {
            this.field1150 = var1.method2717();
            this.field1151 = new int[this.field1150];
            this.field1152 = new int[this.field1150];

            for(var3 = 0; var3 < this.field1150; ++var3) {
               this.field1151[var3] = var1.method2533();
               this.field1152[var3] = var1.method2533();
            }
         }
      }

   }

   @ObfuscatedName("bt")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   static final void method1097() {
      for(int var0 = 0; var0 < Client.field321; ++var0) {
         int var1 = Client.field399[var0];
         NPC var2 = Client.cachedNPCs[var1];
         int var3 = Client.field325.method2528();
         int var4;
         int var5;
         int var6;
         int var7;
         if((var3 & 32) != 0) {
            var4 = Client.field325.method2566();
            var5 = Client.field325.method2565();
            var6 = var2.x - (var4 - class9.baseX - class9.baseX) * 64;
            var7 = var2.y - (var5 - KitDefinition.baseY - KitDefinition.baseY) * 64;
            if(var6 != 0 || var7 != 0) {
               var2.field885 = (int)(Math.atan2((double)var6, (double)var7) * 325.949D) & 2047;
            }
         }

         if((var3 & 4) != 0) {
            var4 = Client.field325.method2566();
            if(var4 == '\uffff') {
               var4 = -1;
            }

            var5 = Client.field325.method2556();
            if(var2.animation == var4 && var4 != -1) {
               var6 = Friend.getAnimation(var4).replyMode;
               if(var6 == 1) {
                  var2.actionFrame = 0;
                  var2.field881 = 0;
                  var2.actionAnimationDisable = var5;
                  var2.field875 = 0;
               }

               if(var6 == 2) {
                  var2.field875 = 0;
               }
            } else if(var4 == -1 || var2.animation == -1 || Friend.getAnimation(var4).field1020 >= Friend.getAnimation(var2.animation).field1020) {
               var2.animation = var4;
               var2.actionFrame = 0;
               var2.field881 = 0;
               var2.actionAnimationDisable = var5;
               var2.field875 = 0;
               var2.field898 = var2.field893;
            }
         }

         if((var3 & 2) != 0) {
            var2.overhead = Client.field325.method2530();
            var2.field855 = 100;
         }

         if((var3 & 64) != 0) {
            var2.graphic = Client.field325.method2566();
            var4 = Client.field325.method2526();
            var2.field880 = var4 >> 16;
            var2.field879 = (var4 & '\uffff') + Client.gameCycle;
            var2.field877 = 0;
            var2.field878 = 0;
            if(var2.field879 > Client.gameCycle) {
               var2.field877 = -1;
            }

            if(var2.graphic == '\uffff') {
               var2.graphic = -1;
            }
         }

         if((var3 & 16) != 0) {
            var4 = Client.field325.method2556();
            int var8;
            int var9;
            int var10;
            if(var4 > 0) {
               for(var5 = 0; var5 < var4; ++var5) {
                  var7 = -1;
                  var8 = -1;
                  var9 = -1;
                  var6 = Client.field325.method2710();
                  if(var6 == 32767) {
                     var6 = Client.field325.method2710();
                     var8 = Client.field325.method2710();
                     var7 = Client.field325.method2710();
                     var9 = Client.field325.method2710();
                  } else if(var6 != 32766) {
                     var8 = Client.field325.method2710();
                  } else {
                     var6 = -1;
                  }

                  var10 = Client.field325.method2710();
                  var2.method794(var6, var8, var7, var9, Client.gameCycle, var10);
               }
            }

            var5 = Client.field325.method2528();
            if(var5 > 0) {
               for(var6 = 0; var6 < var5; ++var6) {
                  var7 = Client.field325.method2710();
                  var8 = Client.field325.method2710();
                  if(var8 != 32767) {
                     var9 = Client.field325.method2710();
                     var10 = Client.field325.method2556();
                     int var11 = var8 > 0?Client.field325.method2556():var10;
                     var2.method787(var7, Client.gameCycle, var8, var9, var10, var11);
                  } else {
                     var2.method788(var7);
                  }
               }
            }
         }

         if((var3 & 8) != 0) {
            var2.composition = ObjectComposition.getNpcDefinition(Client.field325.method2565());
            var2.field843 = var2.composition.field915;
            var2.field892 = var2.composition.field938;
            var2.field847 = var2.composition.field921;
            var2.field887 = var2.composition.field913;
            var2.field863 = var2.composition.field928;
            var2.field850 = var2.composition.field924;
            var2.idlePoseAnimation = var2.composition.field935;
            var2.field849 = var2.composition.field934;
            var2.field890 = var2.composition.field920;
         }

         if((var3 & 1) != 0) {
            var2.interacting = Client.field325.method2566();
            if(var2.interacting == '\uffff') {
               var2.interacting = -1;
            }
         }
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lclass125;B)V",
      garbageValue = "82"
   )
   static final void method1098(class125 var0) {
      for(int var1 = 0; var1 < class34.field786; ++var1) {
         int var2 = class34.field787[var1];
         Player var3 = Client.cachedPlayers[var2];
         int var4 = var0.method2528();
         if((var4 & 8) != 0) {
            var4 += var0.method2528() << 8;
         }

         byte var5 = -1;
         int var6;
         if((var4 & 32) != 0) {
            var6 = var0.method2528();
            byte[] var7 = new byte[var6];
            Buffer var8 = new Buffer(var7);
            var0.method2726(var7, 0, var6);
            class34.field778[var2] = var8;
            var3.method14(var8);
         }

         int var20;
         if((var4 & 1) != 0) {
            var6 = var0.method2717();
            if(var6 == '\uffff') {
               var6 = -1;
            }

            var20 = var0.method2528();
            class45.method949(var3, var6, var20);
         }

         if((var4 & 128) != 0) {
            var3.interacting = var0.method2717();
            if(var3.interacting == '\uffff') {
               var3.interacting = -1;
            }
         }

         if((var4 & 16) != 0) {
            var3.overhead = var0.method2530();
            if(var3.overhead.charAt(0) == 126) {
               var3.overhead = var3.overhead.substring(1);
               class10.sendGameMessage(2, var3.name, var3.overhead);
            } else if(WidgetNode.localPlayer == var3) {
               class10.sendGameMessage(2, var3.name, var3.overhead);
            }

            var3.field853 = false;
            var3.field856 = 0;
            var3.field857 = 0;
            var3.field855 = 150;
         }

         int var10;
         int var11;
         if((var4 & 4) != 0) {
            var6 = var0.method2528();
            int var9;
            int var12;
            int var21;
            if(var6 > 0) {
               for(var20 = 0; var20 < var6; ++var20) {
                  var9 = -1;
                  var10 = -1;
                  var11 = -1;
                  var21 = var0.method2710();
                  if(var21 == 32767) {
                     var21 = var0.method2710();
                     var10 = var0.method2710();
                     var9 = var0.method2710();
                     var11 = var0.method2710();
                  } else if(var21 != 32766) {
                     var10 = var0.method2710();
                  } else {
                     var21 = -1;
                  }

                  var12 = var0.method2710();
                  var3.method794(var21, var10, var9, var11, Client.gameCycle, var12);
               }
            }

            var20 = var0.method2528();
            if(var20 > 0) {
               for(var21 = 0; var21 < var20; ++var21) {
                  var9 = var0.method2710();
                  var10 = var0.method2710();
                  if(var10 != 32767) {
                     var11 = var0.method2710();
                     var12 = var0.method2528();
                     int var13 = var10 > 0?var0.method2528():var12;
                     var3.method787(var9, Client.gameCycle, var10, var11, var12, var13);
                  } else {
                     var3.method788(var9);
                  }
               }
            }
         }

         if((var4 & 64) != 0) {
            var3.field885 = var0.method2717();
            if(var3.field893 == 0) {
               var3.field891 = var3.field885;
               var3.field885 = -1;
            }
         }

         if((var4 & 2) != 0) {
            var6 = var0.method2717();
            class155[] var26 = new class155[]{class155.field2329, class155.field2328, class155.field2330, class155.field2337, class155.field2331};
            class155 var27 = (class155)class54.method1117(var26, var0.method2528());
            boolean var29 = var0.method2528() == 1;
            var10 = var0.method2528();
            var11 = var0.offset;
            if(null != var3.name && null != var3.composition) {
               boolean var30 = false;
               if(var27.field2336 && SecondaryBufferProvider.method1676(var3.name)) {
                  var30 = true;
               }

               if(!var30 && Client.field401 == 0 && !var3.field41) {
                  class34.field792.offset = 0;
                  var0.method2726(class34.field792.payload, 0, var10);
                  class34.field792.offset = 0;
                  Buffer var14 = class34.field792;

                  String var15;
                  int var16;
                  String var18;
                  try {
                     var16 = var14.method2710();
                     if(var16 > 32767) {
                        var16 = 32767;
                     }

                     byte[] var17 = new byte[var16];
                     var14.offset += class225.field3229.method2455(var14.payload, var14.offset, var17, 0, var16);
                     var18 = class166.method3283(var17, 0, var16);
                     var15 = var18;
                  } catch (Exception var25) {
                     var15 = "Cabbage";
                  }

                  var15 = class226.method4069(class24.method590(var15));
                  var3.overhead = var15.trim();
                  var3.field856 = var6 >> 8;
                  var3.field857 = var6 & 255;
                  var3.field855 = 150;
                  var3.field853 = var29;
                  var3.inSequence = var3 != WidgetNode.localPlayer && var27.field2336 && Client.field500 != "" && var15.toLowerCase().indexOf(Client.field500) == -1;
                  if(var27.field2335) {
                     var16 = var29?91:1;
                  } else {
                     var16 = var29?90:2;
                  }

                  if(var27.field2334 != -1) {
                     int var19 = var27.field2334;
                     var18 = "<img=" + var19 + ">";
                     class10.sendGameMessage(var16, var18 + var3.name, var15);
                  } else {
                     class10.sendGameMessage(var16, var3.name, var15);
                  }
               }
            }

            var0.offset = var10 + var11;
         }

         if((var4 & 4096) != 0) {
            var3.graphic = var0.method2717();
            var6 = var0.method2533();
            var3.field880 = var6 >> 16;
            var3.field879 = (var6 & '\uffff') + Client.gameCycle;
            var3.field877 = 0;
            var3.field878 = 0;
            if(var3.field879 > Client.gameCycle) {
               var3.field877 = -1;
            }

            if(var3.graphic == '\uffff') {
               var3.graphic = -1;
            }
         }

         if((var4 & 2048) != 0) {
            var3.field882 = var0.method2529();
            var3.field883 = var0.method2529();
            var3.field854 = var0.method2529();
            var3.field884 = var0.method2529();
            var3.field859 = var0.method2717() + Client.gameCycle;
            var3.field845 = var0.method2717() + Client.gameCycle;
            var3.field839 = var0.method2717();
            if(var3.field55) {
               var3.field882 += var3.field45;
               var3.field883 += var3.field57;
               var3.field854 += var3.field45;
               var3.field884 += var3.field57;
               var3.field893 = 0;
            } else {
               var3.field882 += var3.pathX[0];
               var3.field883 += var3.pathY[0];
               var3.field854 += var3.pathX[0];
               var3.field884 += var3.pathY[0];
               var3.field893 = 1;
            }

            var3.field898 = 0;
         }

         if((var4 & 256) != 0) {
            class34.field777[var2] = var0.method2529();
         }

         if((var4 & 512) != 0) {
            var5 = var0.method2529();
         }

         if((var4 & 1024) != 0) {
            for(var6 = 0; var6 < 3; ++var6) {
               var3.actions[var6] = var0.method2530();
            }
         }

         if(var3.field55) {
            if(var5 == 127) {
               var3.method20(var3.field45, var3.field57);
            } else {
               byte var28;
               if(var5 != -1) {
                  var28 = var5;
               } else {
                  var28 = class34.field777[var2];
               }

               var3.method29(var3.field45, var3.field57, var28);
            }
         }
      }

   }
}
