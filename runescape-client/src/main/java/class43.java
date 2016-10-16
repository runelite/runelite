import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("az")
public class class43 extends CacheableNode {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -158262165
   )
   public int field958;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 869417547
   )
   int field959 = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1051164903
   )
   public int field960;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1555305855
   )
   public int field961;
   @ObfuscatedName("a")
   public static Buffer field962;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1465919453
   )
   public int field963;
   @ObfuscatedName("z")
   public static NodeCache field964 = new NodeCache(64);

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1955526166"
   )
   void method857() {
      this.method875(this.field959);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;III)V",
      garbageValue = "1830777830"
   )
   void method858(Buffer var1, int var2, int var3) {
      if(var2 == 1) {
         this.field959 = var1.method2485();
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "995013881"
   )
   void method860(Buffer var1, int var2) {
      while(true) {
         int var3 = var1.method2481();
         if(var3 == 0) {
            return;
         }

         this.method858(var1, var3, var2);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1710100454"
   )
   static final int method865(int var0, int var1, int var2) {
      int var3 = 256 - var2;
      return ((var1 & '\uff00') * var2 + (var0 & '\uff00') * var3 & 16711680) + (var2 * (var1 & 16711935) + var3 * (var0 & 16711935) & -16711936) >> 8;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)I",
      garbageValue = "-159083467"
   )
   static int method874(class125 var0) {
      int var1 = var0.method2762(2);
      int var2;
      if(var1 == 0) {
         var2 = 0;
      } else if(var1 == 1) {
         var2 = var0.method2762(5);
      } else if(var1 == 2) {
         var2 = var0.method2762(8);
      } else {
         var2 = var0.method2762(11);
      }

      return var2;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "645486401"
   )
   void method875(int var1) {
      double var2 = (double)(var1 >> 16 & 255) / 256.0D;
      double var4 = (double)(var1 >> 8 & 255) / 256.0D;
      double var6 = (double)(var1 & 255) / 256.0D;
      double var8 = var2;
      if(var4 < var2) {
         var8 = var4;
      }

      if(var6 < var8) {
         var8 = var6;
      }

      double var10 = var2;
      if(var4 > var2) {
         var10 = var4;
      }

      if(var6 > var10) {
         var10 = var6;
      }

      double var12 = 0.0D;
      double var14 = 0.0D;
      double var16 = (var8 + var10) / 2.0D;
      if(var8 != var10) {
         if(var16 < 0.5D) {
            var14 = (var10 - var8) / (var10 + var8);
         }

         if(var16 >= 0.5D) {
            var14 = (var10 - var8) / (2.0D - var10 - var8);
         }

         if(var10 == var2) {
            var12 = (var4 - var6) / (var10 - var8);
         } else if(var10 == var4) {
            var12 = 2.0D + (var6 - var2) / (var10 - var8);
         } else if(var6 == var10) {
            var12 = 4.0D + (var2 - var4) / (var10 - var8);
         }
      }

      var12 /= 6.0D;
      this.field961 = (int)(var14 * 256.0D);
      this.field963 = (int)(256.0D * var16);
      if(this.field961 < 0) {
         this.field961 = 0;
      } else if(this.field961 > 255) {
         this.field961 = 255;
      }

      if(this.field963 < 0) {
         this.field963 = 0;
      } else if(this.field963 > 255) {
         this.field963 = 255;
      }

      if(var16 > 0.5D) {
         this.field958 = (int)(var14 * (1.0D - var16) * 512.0D);
      } else {
         this.field958 = (int)(var16 * var14 * 512.0D);
      }

      if(this.field958 < 1) {
         this.field958 = 1;
      }

      this.field960 = (int)(var12 * (double)this.field958);
   }

   @ObfuscatedName("bd")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;III)V",
      garbageValue = "-997996377"
   )
   @Export("menuAction")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      Widget var8;
      if(var2 == 24) {
         var8 = class92.method2078(var1);
         boolean var9 = true;
         if(var8.contentType > 0) {
            var9 = class21.method551(var8);
         }

         if(var9) {
            Client.field300.method2748(229);
            Client.field300.method2642(var1);
         }
      }

      Player var18;
      if(var2 == 44) {
         var18 = Client.cachedPlayers[var3];
         if(var18 != null) {
            Client.field454 = var6;
            Client.field378 = var7;
            Client.field468 = 2;
            Client.field539 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field300.method2748(139);
            Client.field300.method2513(var3);
            Client.field300.method2467(class140.field2157[82]?1:0);
         }
      }

      if(var2 == 19) {
         Client.field454 = var6;
         Client.field378 = var7;
         Client.field468 = 2;
         Client.field539 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field300.method2748(80);
         Client.field300.method2513(var1 + class8.baseY);
         Client.field300.method2513(var3);
         Client.field300.method2611(class140.field2157[82]?1:0);
         Client.field300.method2655(class23.baseX + var0);
      }

      if(var2 == 51) {
         var18 = Client.cachedPlayers[var3];
         if(var18 != null) {
            Client.field454 = var6;
            Client.field378 = var7;
            Client.field468 = 2;
            Client.field539 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field300.method2748(11);
            Client.field300.method2467(class140.field2157[82]?1:0);
            Client.field300.method2514(var3);
         }
      }

      if(var2 == 35) {
         Client.field300.method2748(254);
         Client.field300.method2655(var0);
         Client.field300.method2468(var3);
         Client.field300.method2557(var1);
         Client.field334 = 0;
         NPCComposition.field873 = class92.method2078(var1);
         Client.field317 = var0;
      }

      if(var2 == 32) {
         Client.field300.method2748(31);
         Client.field300.method2655(Client.field269);
         Client.field300.method2514(var0);
         Client.field300.method2557(class144.field2208);
         Client.field300.method2642(var1);
         Client.field300.method2468(var3);
         Client.field334 = 0;
         NPCComposition.field873 = class92.method2078(var1);
         Client.field317 = var0;
      }

      if(var2 == 50) {
         var18 = Client.cachedPlayers[var3];
         if(null != var18) {
            Client.field454 = var6;
            Client.field378 = var7;
            Client.field468 = 2;
            Client.field539 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field300.method2748(240);
            Client.field300.method2655(var3);
            Client.field300.method2467(class140.field2157[82]?1:0);
         }
      }

      if(var2 == 43) {
         Client.field300.method2748(141);
         Client.field300.method2642(var1);
         Client.field300.method2655(var0);
         Client.field300.method2468(var3);
         Client.field334 = 0;
         NPCComposition.field873 = class92.method2078(var1);
         Client.field317 = var0;
      }

      if(var2 == 22) {
         Client.field454 = var6;
         Client.field378 = var7;
         Client.field468 = 2;
         Client.field539 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field300.method2748(252);
         Client.field300.method2655(var3);
         Client.field300.method2468(class8.baseY + var1);
         Client.field300.method2505(class140.field2157[82]?1:0);
         Client.field300.method2514(var0 + class23.baseX);
      }

      if(var2 == 5) {
         Client.field454 = var6;
         Client.field378 = var7;
         Client.field468 = 2;
         Client.field539 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field300.method2748(179);
         Client.field300.method2513(class8.baseY + var1);
         Client.field300.method2513(class23.baseX + var0);
         Client.field300.method2514(var3 >> 14 & 32767);
         Client.field300.method2611(class140.field2157[82]?1:0);
      }

      if(var2 == 4) {
         Client.field454 = var6;
         Client.field378 = var7;
         Client.field468 = 2;
         Client.field539 = 0;
         Client.flagX = var0;
         Client.flagY = var1;
         Client.field300.method2748(241);
         Client.field300.method2514(class23.baseX + var0);
         Client.field300.method2505(class140.field2157[82]?1:0);
         Client.field300.method2468(var3 >> 14 & 32767);
         Client.field300.method2514(var1 + class8.baseY);
      }

      if(var2 == 26) {
         class113.method2396();
      }

      if(var2 == 58) {
         var8 = class163.method3174(var1, var0);
         if(null != var8) {
            Client.field300.method2748(57);
            Client.field300.method2468(var0);
            Client.field300.method2514(Client.field425);
            Client.field300.method2524(var1);
            Client.field300.method2655(Client.field269);
            Client.field300.method2655(var8.item);
            Client.field300.method2557(class144.field2208);
         }
      }

      if(var2 == 41) {
         Client.field300.method2748(164);
         Client.field300.method2513(var3);
         Client.field300.method2655(var0);
         Client.field300.method2524(var1);
         Client.field334 = 0;
         NPCComposition.field873 = class92.method2078(var1);
         Client.field317 = var0;
      }

      if(var2 == 23) {
         class114.region.method2036(class59.plane, var0, var1);
      }

      NPC var19;
      if(var2 == 10) {
         var19 = Client.cachedNPCs[var3];
         if(var19 != null) {
            Client.field454 = var6;
            Client.field378 = var7;
            Client.field468 = 2;
            Client.field539 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field300.method2748(147);
            Client.field300.method2655(var3);
            Client.field300.method2611(class140.field2157[82]?1:0);
         }
      }

      if(var2 == 49) {
         var18 = Client.cachedPlayers[var3];
         if(var18 != null) {
            Client.field454 = var6;
            Client.field378 = var7;
            Client.field468 = 2;
            Client.field539 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field300.method2748(249);
            Client.field300.method2513(var3);
            Client.field300.method2466(class140.field2157[82]?1:0);
         }
      }

      if(var2 == 42) {
         Client.field300.method2748(233);
         Client.field300.method2514(var0);
         Client.field300.method2514(var3);
         Client.field300.method2557(var1);
         Client.field334 = 0;
         NPCComposition.field873 = class92.method2078(var1);
         Client.field317 = var0;
      }

      if(var2 == 11) {
         var19 = Client.cachedNPCs[var3];
         if(null != var19) {
            Client.field454 = var6;
            Client.field378 = var7;
            Client.field468 = 2;
            Client.field539 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field300.method2748(186);
            Client.field300.method2611(class140.field2157[82]?1:0);
            Client.field300.method2514(var3);
         }
      }

      int var20;
      if(var2 == 29) {
         Client.field300.method2748(229);
         Client.field300.method2642(var1);
         var8 = class92.method2078(var1);
         if(var8.dynamicValues != null && var8.dynamicValues[0][0] == 5) {
            var20 = var8.dynamicValues[0][1];
            if(class179.widgetSettings[var20] != var8.field2912[0]) {
               class179.widgetSettings[var20] = var8.field2912[0];
               class20.method539(var20);
            }
         }
      }

      if(var2 == 30 && Client.field432 == null) {
         class34.method728(var1, var0);
         Client.field432 = class163.method3174(var1, var0);
         class32.method685(Client.field432);
      }

      if(var2 == 25) {
         var8 = class163.method3174(var1, var0);
         if(var8 != null) {
            class190.method3734();
            int var10 = class11.method138(var8);
            var20 = var10 >> 11 & 63;
            int var12 = var8.item;
            Widget var13 = class163.method3174(var1, var0);
            if(var13 != null && null != var13.field2889) {
               class0 var14 = new class0();
               var14.field2 = var13;
               var14.field5 = var13.field2889;
               MessageNode.method754(var14);
            }

            Client.field425 = var12;
            Client.field270 = true;
            class144.field2208 = var1;
            Client.field269 = var0;
            class124.field2042 = var20;
            class32.method685(var13);
            Client.field421 = 0;
            Client.field333 = Projectile.method101(var8);
            if(Client.field333 == null) {
               Client.field333 = "Null";
            }

            if(var8.field2797) {
               Client.field497 = var8.name + class188.method3706(16777215);
            } else {
               Client.field497 = class188.method3706('\uff00') + var8.field2914 + class188.method3706(16777215);
            }
         }

      } else {
         if(var2 == 46) {
            var18 = Client.cachedPlayers[var3];
            if(null != var18) {
               Client.field454 = var6;
               Client.field378 = var7;
               Client.field468 = 2;
               Client.field539 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field300.method2748(100);
               Client.field300.method2466(class140.field2157[82]?1:0);
               Client.field300.method2468(var3);
            }
         }

         if(var2 == 15) {
            var18 = Client.cachedPlayers[var3];
            if(var18 != null) {
               Client.field454 = var6;
               Client.field378 = var7;
               Client.field468 = 2;
               Client.field539 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field300.method2748(172);
               Client.field300.method2513(var3);
               Client.field300.method2611(class140.field2157[82]?1:0);
               Client.field300.method2468(Client.field269);
               Client.field300.method2565(class144.field2208);
            }
         }

         if(var2 == 48) {
            var18 = Client.cachedPlayers[var3];
            if(var18 != null) {
               Client.field454 = var6;
               Client.field378 = var7;
               Client.field468 = 2;
               Client.field539 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field300.method2748(54);
               Client.field300.method2505(class140.field2157[82]?1:0);
               Client.field300.method2514(var3);
            }
         }

         if(var2 == 2) {
            Client.field454 = var6;
            Client.field378 = var7;
            Client.field468 = 2;
            Client.field539 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field300.method2748(47);
            Client.field300.method2655(var3 >> 14 & 32767);
            Client.field300.method2513(Client.field269);
            Client.field300.method2468(class8.baseY + var1);
            Client.field300.method2611(class140.field2157[82]?1:0);
            Client.field300.method2524(class144.field2208);
            Client.field300.method2468(var0 + class23.baseX);
         }

         if(var2 == 39) {
            Client.field300.method2748(245);
            Client.field300.method2468(var0);
            Client.field300.method2655(var3);
            Client.field300.method2524(var1);
            Client.field334 = 0;
            NPCComposition.field873 = class92.method2078(var1);
            Client.field317 = var0;
         }

         if(var2 == 20) {
            Client.field454 = var6;
            Client.field378 = var7;
            Client.field468 = 2;
            Client.field539 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field300.method2748(9);
            Client.field300.method2514(var3);
            Client.field300.method2467(class140.field2157[82]?1:0);
            Client.field300.method2468(class23.baseX + var0);
            Client.field300.method2514(class8.baseY + var1);
         }

         if(var2 == 12) {
            var19 = Client.cachedNPCs[var3];
            if(null != var19) {
               Client.field454 = var6;
               Client.field378 = var7;
               Client.field468 = 2;
               Client.field539 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field300.method2748(59);
               Client.field300.method2467(class140.field2157[82]?1:0);
               Client.field300.method2655(var3);
            }
         }

         if(var2 == 57 || var2 == 1007) {
            var8 = class163.method3174(var1, var0);
            if(null != var8) {
               var20 = var8.item;
               Widget var15 = class163.method3174(var1, var0);
               if(var15 != null) {
                  if(var15.field2873 != null) {
                     class0 var16 = new class0();
                     var16.field2 = var15;
                     var16.field6 = var3;
                     var16.field9 = var5;
                     var16.field5 = var15.field2873;
                     MessageNode.method754(var16);
                  }

                  boolean var11 = true;
                  if(var15.contentType > 0) {
                     var11 = class21.method551(var15);
                  }

                  if(var11 && MessageNode.method757(class11.method138(var15), var3 - 1)) {
                     if(var3 == 1) {
                        Client.field300.method2748(174);
                        Client.field300.method2642(var1);
                        Client.field300.method2468(var0);
                        Client.field300.method2468(var20);
                     }

                     if(var3 == 2) {
                        Client.field300.method2748(149);
                        Client.field300.method2642(var1);
                        Client.field300.method2468(var0);
                        Client.field300.method2468(var20);
                     }

                     if(var3 == 3) {
                        Client.field300.method2748(103);
                        Client.field300.method2642(var1);
                        Client.field300.method2468(var0);
                        Client.field300.method2468(var20);
                     }

                     if(var3 == 4) {
                        Client.field300.method2748(101);
                        Client.field300.method2642(var1);
                        Client.field300.method2468(var0);
                        Client.field300.method2468(var20);
                     }

                     if(var3 == 5) {
                        Client.field300.method2748(193);
                        Client.field300.method2642(var1);
                        Client.field300.method2468(var0);
                        Client.field300.method2468(var20);
                     }

                     if(var3 == 6) {
                        Client.field300.method2748(188);
                        Client.field300.method2642(var1);
                        Client.field300.method2468(var0);
                        Client.field300.method2468(var20);
                     }

                     if(var3 == 7) {
                        Client.field300.method2748(55);
                        Client.field300.method2642(var1);
                        Client.field300.method2468(var0);
                        Client.field300.method2468(var20);
                     }

                     if(var3 == 8) {
                        Client.field300.method2748(39);
                        Client.field300.method2642(var1);
                        Client.field300.method2468(var0);
                        Client.field300.method2468(var20);
                     }

                     if(var3 == 9) {
                        Client.field300.method2748(255);
                        Client.field300.method2642(var1);
                        Client.field300.method2468(var0);
                        Client.field300.method2468(var20);
                     }

                     if(var3 == 10) {
                        Client.field300.method2748(68);
                        Client.field300.method2642(var1);
                        Client.field300.method2468(var0);
                        Client.field300.method2468(var20);
                     }
                  }
               }
            }
         }

         if(var2 == 8) {
            var19 = Client.cachedNPCs[var3];
            if(var19 != null) {
               Client.field454 = var6;
               Client.field378 = var7;
               Client.field468 = 2;
               Client.field539 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field300.method2748(97);
               Client.field300.method2505(class140.field2157[82]?1:0);
               Client.field300.method2513(Client.field269);
               Client.field300.method2524(class144.field2208);
               Client.field300.method2513(var3);
            }
         }

         if(var2 == 3) {
            Client.field454 = var6;
            Client.field378 = var7;
            Client.field468 = 2;
            Client.field539 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field300.method2748(156);
            Client.field300.method2513(var3 >> 14 & 32767);
            Client.field300.method2468(class23.baseX + var0);
            Client.field300.method2505(class140.field2157[82]?1:0);
            Client.field300.method2468(class8.baseY + var1);
         }

         if(var2 == 1) {
            Client.field454 = var6;
            Client.field378 = var7;
            Client.field468 = 2;
            Client.field539 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field300.method2748(56);
            Client.field300.method2655(var1 + class8.baseY);
            Client.field300.method2565(Item.field670);
            Client.field300.method2514(class168.field2711);
            Client.field300.method2513(class145.field2215);
            Client.field300.method2611(class140.field2157[82]?1:0);
            Client.field300.method2655(var0 + class23.baseX);
            Client.field300.method2468(var3 >> 14 & 32767);
         }

         if(var2 == 9) {
            var19 = Client.cachedNPCs[var3];
            if(null != var19) {
               Client.field454 = var6;
               Client.field378 = var7;
               Client.field468 = 2;
               Client.field539 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field300.method2748(157);
               Client.field300.method2468(var3);
               Client.field300.method2611(class140.field2157[82]?1:0);
            }
         }

         if(var2 == 47) {
            var18 = Client.cachedPlayers[var3];
            if(null != var18) {
               Client.field454 = var6;
               Client.field378 = var7;
               Client.field468 = 2;
               Client.field539 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field300.method2748(247);
               Client.field300.method2466(class140.field2157[82]?1:0);
               Client.field300.method2655(var3);
            }
         }

         if(var2 == 36) {
            Client.field300.method2748(67);
            Client.field300.method2655(var0);
            Client.field300.method2513(var3);
            Client.field300.method2565(var1);
            Client.field334 = 0;
            NPCComposition.field873 = class92.method2078(var1);
            Client.field317 = var0;
         }

         if(var2 == 17) {
            Client.field454 = var6;
            Client.field378 = var7;
            Client.field468 = 2;
            Client.field539 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field300.method2748(2);
            Client.field300.method2467(class140.field2157[82]?1:0);
            Client.field300.method2468(var3);
            Client.field300.method2642(class144.field2208);
            Client.field300.method2513(Client.field269);
            Client.field300.method2514(var1 + class8.baseY);
            Client.field300.method2514(var0 + class23.baseX);
         }

         if(var2 == 37) {
            Client.field300.method2748(224);
            Client.field300.method2557(var1);
            Client.field300.method2513(var0);
            Client.field300.method2513(var3);
            Client.field334 = 0;
            NPCComposition.field873 = class92.method2078(var1);
            Client.field317 = var0;
         }

         if(var2 == 28) {
            Client.field300.method2748(229);
            Client.field300.method2642(var1);
            var8 = class92.method2078(var1);
            if(null != var8.dynamicValues && var8.dynamicValues[0][0] == 5) {
               var20 = var8.dynamicValues[0][1];
               class179.widgetSettings[var20] = 1 - class179.widgetSettings[var20];
               class20.method539(var20);
            }
         }

         if(var2 == 45) {
            var18 = Client.cachedPlayers[var3];
            if(var18 != null) {
               Client.field454 = var6;
               Client.field378 = var7;
               Client.field468 = 2;
               Client.field539 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field300.method2748(49);
               Client.field300.method2513(var3);
               Client.field300.method2611(class140.field2157[82]?1:0);
            }
         }

         if(var2 == 1004) {
            Client.field454 = var6;
            Client.field378 = var7;
            Client.field468 = 2;
            Client.field539 = 0;
            Client.field300.method2748(25);
            Client.field300.method2513(var3);
         }

         if(var2 == 1002) {
            Client.field454 = var6;
            Client.field378 = var7;
            Client.field468 = 2;
            Client.field539 = 0;
            Client.field300.method2748(163);
            Client.field300.method2513(var3 >> 14 & 32767);
         }

         if(var2 == 1003) {
            Client.field454 = var6;
            Client.field378 = var7;
            Client.field468 = 2;
            Client.field539 = 0;
            var19 = Client.cachedNPCs[var3];
            if(null != var19) {
               NPCComposition var17 = var19.composition;
               if(var17.field897 != null) {
                  var17 = var17.method790();
               }

               if(null != var17) {
                  Client.field300.method2748(160);
                  Client.field300.method2655(var17.id);
               }
            }
         }

         if(var2 == 13) {
            var19 = Client.cachedNPCs[var3];
            if(null != var19) {
               Client.field454 = var6;
               Client.field378 = var7;
               Client.field468 = 2;
               Client.field539 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field300.method2748(117);
               Client.field300.method2611(class140.field2157[82]?1:0);
               Client.field300.method2655(var3);
            }
         }

         if(var2 == 7) {
            var19 = Client.cachedNPCs[var3];
            if(null != var19) {
               Client.field454 = var6;
               Client.field378 = var7;
               Client.field468 = 2;
               Client.field539 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field300.method2748(61);
               Client.field300.method2466(class140.field2157[82]?1:0);
               Client.field300.method2468(class145.field2215);
               Client.field300.method2514(var3);
               Client.field300.method2565(Item.field670);
               Client.field300.method2514(class168.field2711);
            }
         }

         if(var2 == 40) {
            Client.field300.method2748(105);
            Client.field300.method2642(var1);
            Client.field300.method2514(var3);
            Client.field300.method2655(var0);
            Client.field334 = 0;
            NPCComposition.field873 = class92.method2078(var1);
            Client.field317 = var0;
         }

         if(var2 == 1005) {
            var8 = class92.method2078(var1);
            if(null != var8 && var8.itemQuantities[var0] >= 100000) {
               Player.sendGameMessage(27, "", var8.itemQuantities[var0] + " x " + class174.getItemDefinition(var3).name);
            } else {
               Client.field300.method2748(25);
               Client.field300.method2513(var3);
            }

            Client.field334 = 0;
            NPCComposition.field873 = class92.method2078(var1);
            Client.field317 = var0;
         }

         if(var2 == 16) {
            Client.field454 = var6;
            Client.field378 = var7;
            Client.field468 = 2;
            Client.field539 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field300.method2748(243);
            Client.field300.method2655(class8.baseY + var1);
            Client.field300.method2513(class168.field2711);
            Client.field300.method2505(class140.field2157[82]?1:0);
            Client.field300.method2514(var3);
            Client.field300.method2513(class145.field2215);
            Client.field300.method2557(Item.field670);
            Client.field300.method2513(var0 + class23.baseX);
         }

         if(var2 == 21) {
            Client.field454 = var6;
            Client.field378 = var7;
            Client.field468 = 2;
            Client.field539 = 0;
            Client.flagX = var0;
            Client.flagY = var1;
            Client.field300.method2748(66);
            Client.field300.method2655(class8.baseY + var1);
            Client.field300.method2513(var3);
            Client.field300.method2655(var0 + class23.baseX);
            Client.field300.method2611(class140.field2157[82]?1:0);
         }

         if(var2 == 33) {
            Client.field300.method2748(78);
            Client.field300.method2642(var1);
            Client.field300.method2655(var3);
            Client.field300.method2468(var0);
            Client.field334 = 0;
            NPCComposition.field873 = class92.method2078(var1);
            Client.field317 = var0;
         }

         if(var2 == 38) {
            class190.method3734();
            var8 = class92.method2078(var1);
            Client.field421 = 1;
            class145.field2215 = var0;
            Item.field670 = var1;
            class168.field2711 = var3;
            class32.method685(var8);
            Client.field416 = class188.method3706(16748608) + class174.getItemDefinition(var3).name + class188.method3706(16777215);
            if(null == Client.field416) {
               Client.field416 = "null";
            }

         } else {
            if(var2 == 1001) {
               Client.field454 = var6;
               Client.field378 = var7;
               Client.field468 = 2;
               Client.field539 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field300.method2748(230);
               Client.field300.method2514(var3 >> 14 & 32767);
               Client.field300.method2505(class140.field2157[82]?1:0);
               Client.field300.method2513(var0 + class23.baseX);
               Client.field300.method2513(var1 + class8.baseY);
            }

            if(var2 == 6) {
               Client.field454 = var6;
               Client.field378 = var7;
               Client.field468 = 2;
               Client.field539 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field300.method2748(124);
               Client.field300.method2513(class8.baseY + var1);
               Client.field300.method2467(class140.field2157[82]?1:0);
               Client.field300.method2513(var0 + class23.baseX);
               Client.field300.method2655(var3 >> 14 & 32767);
            }

            if(var2 == 18) {
               Client.field454 = var6;
               Client.field378 = var7;
               Client.field468 = 2;
               Client.field539 = 0;
               Client.flagX = var0;
               Client.flagY = var1;
               Client.field300.method2748(19);
               Client.field300.method2514(class23.baseX + var0);
               Client.field300.method2655(class8.baseY + var1);
               Client.field300.method2467(class140.field2157[82]?1:0);
               Client.field300.method2468(var3);
            }

            if(var2 == 34) {
               Client.field300.method2748(35);
               Client.field300.method2514(var3);
               Client.field300.method2642(var1);
               Client.field300.method2514(var0);
               Client.field334 = 0;
               NPCComposition.field873 = class92.method2078(var1);
               Client.field317 = var0;
            }

            if(var2 == 31) {
               Client.field300.method2748(36);
               Client.field300.method2468(class145.field2215);
               Client.field300.method2557(Item.field670);
               Client.field300.method2655(var3);
               Client.field300.method2514(var0);
               Client.field300.method2468(class168.field2711);
               Client.field300.method2565(var1);
               Client.field334 = 0;
               NPCComposition.field873 = class92.method2078(var1);
               Client.field317 = var0;
            }

            if(var2 == 14) {
               var18 = Client.cachedPlayers[var3];
               if(null != var18) {
                  Client.field454 = var6;
                  Client.field378 = var7;
                  Client.field468 = 2;
                  Client.field539 = 0;
                  Client.flagX = var0;
                  Client.flagY = var1;
                  Client.field300.method2748(205);
                  Client.field300.method2514(class145.field2215);
                  Client.field300.method2514(class168.field2711);
                  Client.field300.method2557(Item.field670);
                  Client.field300.method2505(class140.field2157[82]?1:0);
                  Client.field300.method2468(var3);
               }
            }

            if(Client.field421 != 0) {
               Client.field421 = 0;
               class32.method685(class92.method2078(Item.field670));
            }

            if(Client.field270) {
               class190.method3734();
            }

            if(NPCComposition.field873 != null && Client.field334 == 0) {
               class32.method685(NPCComposition.field873);
            }

         }
      }
   }
}
