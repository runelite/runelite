import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dk")
public class class115 implements MouseListener, MouseMotionListener, FocusListener {
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1896666135
   )
   public static int field1801 = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1290979005
   )
   @Export("mouseIdleTicks")
   public static volatile int mouseIdleTicks = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -479736167
   )
   static volatile int field1803 = 0;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1305567879
   )
   static volatile int field1804 = -1;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 526967857
   )
   static volatile int field1805 = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1011501229
   )
   public static int field1806 = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1672519119
   )
   public static int field1807 = 0;
   @ObfuscatedName("j")
   @Export("mouse")
   public static class115 mouse = new class115();
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1410793039
   )
   static volatile int field1809 = 0;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2127279843
   )
   static volatile int field1810 = -1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1913072787
   )
   static volatile int field1811 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = 1586812740019762345L
   )
   static volatile long field1812 = 0L;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 979761829
   )
   public static int field1813 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1366784847
   )
   public static int field1814 = 0;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1856934175
   )
   public static int field1815 = 0;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      longValue = -1012088238120603779L
   )
   public static long field1816 = 0L;

   public final void focusGained(FocusEvent var1) {
   }

   public final synchronized void mousePressed(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1805 = var1.getX();
         field1811 = var1.getY();
         field1812 = class99.method2005();
         if(var1.isAltDown()) {
            field1809 = 4;
            field1803 = 4;
         } else if(var1.isMetaDown()) {
            field1809 = 2;
            field1803 = 2;
         } else {
            field1809 = 1;
            field1803 = 1;
         }
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseReleased(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1803 = 0;
      }

      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final void mouseClicked(MouseEvent var1) {
      if(var1.isPopupTrigger()) {
         var1.consume();
      }

   }

   public final synchronized void mouseExited(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1804 = -1;
         field1810 = -1;
      }

   }

   public final synchronized void mouseDragged(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1804 = var1.getX();
         field1810 = var1.getY();
      }

   }

   public final synchronized void mouseMoved(MouseEvent var1) {
      if(mouse != null) {
         mouseIdleTicks = 0;
         field1804 = var1.getX();
         field1810 = var1.getY();
      }

   }

   public final synchronized void focusLost(FocusEvent var1) {
      if(mouse != null) {
         field1803 = 0;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   static void method2271() {
      int var0;
      if(Client.field338 == 0) {
         Friend.region = new Region(4, 104, 104, class10.tileHeights);

         for(var0 = 0; var0 < 4; ++var0) {
            Client.collisionMaps[var0] = new CollisionData(104, 104);
         }

         Actor.field685 = new SpritePixels(512, 512);
         class41.field866 = "Starting game engine...";
         class41.field872 = 5;
         Client.field338 = 20;
      } else {
         int var1;
         int var2;
         int var3;
         int var4;
         if(Client.field338 == 20) {
            int[] var27 = new int[9];

            for(var1 = 0; var1 < 9; ++var1) {
               var2 = 128 + var1 * 32 + 15;
               var3 = 600 + 3 * var2;
               var4 = class84.field1441[var2];
               var27[var1] = var4 * var3 >> 16;
            }

            Region.method1788(var27, 500, 800, 512, 334);
            class41.field866 = "Prepared visibility map";
            class41.field872 = 10;
            Client.field338 = 30;
         } else if(Client.field338 == 30) {
            Client.field341 = class170.method3264(0, false, true, true);
            FloorUnderlayDefinition.field2811 = class170.method3264(1, false, true, true);
            class2.field27 = class170.method3264(2, true, false, true);
            RSCanvas.field1765 = class170.method3264(3, false, true, true);
            class188.field2778 = class170.method3264(4, false, true, true);
            class33.field778 = class170.method3264(5, true, true, true);
            class3.field39 = class170.method3264(6, true, true, false);
            class195.field2859 = class170.method3264(7, false, true, true);
            class0.field2 = class170.method3264(8, false, true, true);
            KitDefinition.field2825 = class170.method3264(9, false, true, true);
            class99.field1655 = class170.method3264(10, false, true, true);
            class1.field12 = class170.method3264(11, false, true, true);
            class110.field1763 = class170.method3264(12, false, true, true);
            class140.field1965 = class170.method3264(13, true, false, true);
            class37.field820 = class170.method3264(14, false, true, false);
            Client.field460 = class170.method3264(15, false, true, true);
            class41.field866 = "Connecting to update server";
            class41.field872 = 20;
            Client.field338 = 40;
         } else if(Client.field338 == 40) {
            byte var24 = 0;
            var0 = var24 + Client.field341.method3406() * 4 / 100;
            var0 += FloorUnderlayDefinition.field2811.method3406() * 4 / 100;
            var0 += class2.field27.method3406() * 2 / 100;
            var0 += RSCanvas.field1765.method3406() * 2 / 100;
            var0 += class188.field2778.method3406() * 6 / 100;
            var0 += class33.field778.method3406() * 4 / 100;
            var0 += class3.field39.method3406() * 2 / 100;
            var0 += class195.field2859.method3406() * 60 / 100;
            var0 += class0.field2.method3406() * 2 / 100;
            var0 += KitDefinition.field2825.method3406() * 2 / 100;
            var0 += class99.field1655.method3406() * 2 / 100;
            var0 += class1.field12.method3406() * 2 / 100;
            var0 += class110.field1763.method3406() * 2 / 100;
            var0 += class140.field1965.method3406() * 2 / 100;
            var0 += class37.field820.method3406() * 2 / 100;
            var0 += Client.field460.method3406() * 2 / 100;
            if(var0 != 100) {
               if(var0 != 0) {
                  class41.field866 = "Checking for updates - " + var0 + "%";
               }

               class41.field872 = 30;
            } else {
               class41.field866 = "Loaded update list";
               class41.field872 = 30;
               Client.field338 = 45;
            }
         } else {
            class184 var17;
            class184 var19;
            if(Client.field338 == 45) {
               boolean var23 = !Client.field439;
               class148.field2033 = 22050;
               class57.field1058 = var23;
               class57.field1051 = 2;
               class139 var29 = new class139();
               var29.method2538(9, 128);
               Buffer.field2089 = class33.method756(class72.field1193, CollisionData.canvas, 0, 22050);
               Buffer.field2089.method1155(var29);
               var19 = Client.field460;
               class184 var18 = class37.field820;
               var17 = class188.field2778;
               class138.field1924 = var19;
               class138.field1917 = var18;
               class138.field1918 = var17;
               class138.field1919 = var29;
               class140.field1977 = class33.method756(class72.field1193, CollisionData.canvas, 1, 2048);
               class195.field2863 = new class51();
               class140.field1977.method1155(class195.field2863);
               ItemLayer.field1224 = new class65(22050, class148.field2033);
               class41.field866 = "Prepared sound engine";
               class41.field872 = 35;
               Client.field338 = 50;
            } else if(Client.field338 == 50) {
               var0 = 0;
               if(null == class31.field727) {
                  class31.field727 = Varbit.method3567(class0.field2, class140.field1965, "p11_full", "");
               } else {
                  ++var0;
               }

               if(class15.field185 == null) {
                  class15.field185 = Varbit.method3567(class0.field2, class140.field1965, "p12_full", "");
               } else {
                  ++var0;
               }

               if(null == BufferProvider.field3198) {
                  BufferProvider.field3198 = Varbit.method3567(class0.field2, class140.field1965, "b12_full", "");
               } else {
                  ++var0;
               }

               if(var0 < 3) {
                  class41.field866 = "Loading fonts - " + 100 * var0 / 3 + "%";
                  class41.field872 = 40;
               } else {
                  class7.field75 = new class230(true);
                  class41.field866 = "Loaded fonts";
                  class41.field872 = 40;
                  Client.field338 = 60;
               }
            } else if(Client.field338 == 60) {
               var0 = class189.method3464(class99.field1655, class0.field2);
               byte var21 = 9;
               if(var0 < var21) {
                  class41.field866 = "Loading title screen - " + var0 * 100 / var21 + "%";
                  class41.field872 = 50;
               } else {
                  class41.field866 = "Loaded title screen";
                  class41.field872 = 50;
                  class187.setGameState(5);
                  Client.field338 = 70;
               }
            } else if(Client.field338 == 70) {
               if(!class2.field27.method3310()) {
                  class41.field866 = "Loading config - " + class2.field27.method3419() + "%";
                  class41.field872 = 60;
               } else {
                  class145.method2763(class2.field27);
                  class184 var26 = class2.field27;
                  FloorUnderlayDefinition.field2806 = var26;
                  World.method671(class2.field27, class195.field2859);
                  class184 var28 = class2.field27;
                  var19 = class195.field2859;
                  boolean var22 = Client.field439;
                  ObjectComposition.field2940 = var28;
                  ObjectComposition.field2895 = var19;
                  ObjectComposition.field2903 = var22;
                  class180.method3299(class2.field27, class195.field2859);
                  class44.method891(class2.field27, class195.field2859, Client.isMembers, class31.field727);
                  class97.method1988(class2.field27, Client.field341, FloorUnderlayDefinition.field2811);
                  NPCComposition.method3742(class2.field27, class195.field2859);
                  class99.method2007(class2.field27);
                  class215.method3983(class2.field27);
                  var17 = RSCanvas.field1765;
                  class184 var5 = class195.field2859;
                  class184 var6 = class0.field2;
                  class184 var7 = class140.field1965;
                  Widget.field2269 = var17;
                  class8.field90 = var5;
                  Widget.field2259 = var6;
                  FaceNormal.field1574 = var7;
                  Widget.widgets = new Widget[Widget.field2269.method3317()][];
                  NPC.validInterfaces = new boolean[Widget.field2269.method3317()];
                  class161.method3120(class2.field27);
                  class184 var8 = class2.field27;
                  class195.field2850 = var8;
                  class184 var9 = class2.field27;
                  class188.field2775 = var9;
                  class180.method3298(class2.field27);
                  class7.chatMessages = new ChatMessages();
                  class184 var10 = class2.field27;
                  class184 var11 = class0.field2;
                  class184 var12 = class140.field1965;
                  class196.field2883 = var10;
                  class196.field2865 = var11;
                  class196.field2887 = var12;
                  class184 var13 = class2.field27;
                  class184 var14 = class0.field2;
                  CombatInfo2.field2827 = var13;
                  CombatInfo2.field2826 = var14;
                  class41.field866 = "Loaded config";
                  class41.field872 = 60;
                  Client.field338 = 80;
               }
            } else if(Client.field338 != 80) {
               if(Client.field338 == 90) {
                  if(!KitDefinition.field2825.method3310()) {
                     class41.field866 = "Loading textures - " + KitDefinition.field2825.method3419() + "%";
                     class41.field872 = 90;
                  } else {
                     TextureProvider var25 = new TextureProvider(KitDefinition.field2825, class0.field2, 20, 0.8D, Client.field439?64:128);
                     class84.method1698(var25);
                     class84.method1717(0.8D);
                     class41.field866 = "Loaded textures";
                     class41.field872 = 90;
                     Client.field338 = 110;
                  }
               } else if(Client.field338 == 110) {
                  Client.field321 = new class20();
                  class72.field1193.method2023(Client.field321, 10);
                  class41.field866 = "Loaded input handler";
                  class41.field872 = 94;
                  Client.field338 = 120;
               } else if(Client.field338 == 120) {
                  if(!class99.field1655.method3324("huffman", "")) {
                     class41.field866 = "Loading wordpack - " + 0 + "%";
                     class41.field872 = 96;
                  } else {
                     class145 var15 = new class145(class99.field1655.method3323("huffman", ""));
                     class140.method2658(var15);
                     class41.field866 = "Loaded wordpack";
                     class41.field872 = 96;
                     Client.field338 = 130;
                  }
               } else if(Client.field338 == 130) {
                  if(!RSCanvas.field1765.method3310()) {
                     class41.field866 = "Loading interfaces - " + RSCanvas.field1765.method3419() * 4 / 5 + "%";
                     class41.field872 = 100;
                  } else if(!class110.field1763.method3310()) {
                     class41.field866 = "Loading interfaces - " + (80 + class110.field1763.method3419() / 6) + "%";
                     class41.field872 = 100;
                  } else if(!class140.field1965.method3310()) {
                     class41.field866 = "Loading interfaces - " + (96 + class140.field1965.method3419() / 20) + "%";
                     class41.field872 = 100;
                  } else {
                     class41.field866 = "Loaded interfaces";
                     class41.field872 = 100;
                     Client.field338 = 140;
                  }
               } else if(Client.field338 == 140) {
                  class187.setGameState(10);
               }
            } else {
               var0 = 0;
               SpritePixels var16;
               if(class15.field193 == null) {
                  var19 = class0.field2;
                  var3 = var19.method3321("compass");
                  var4 = var19.method3322(var3, "");
                  var16 = class99.method1997(var19, var3, var4);
                  class15.field193 = var16;
               } else {
                  ++var0;
               }

               if(Frames.field1583 == null) {
                  var19 = class0.field2;
                  var3 = var19.method3321("mapedge");
                  var4 = var19.method3322(var3, "");
                  var16 = class99.method1997(var19, var3, var4);
                  Frames.field1583 = var16;
               } else {
                  ++var0;
               }

               if(class65.field1116 == null) {
                  class65.field1116 = class0.method15(class0.field2, "mapscene", "");
               } else {
                  ++var0;
               }

               if(null == class172.field2335) {
                  class172.field2335 = class142.method2715(class0.field2, "mapfunction", "");
               } else {
                  ++var0;
               }

               if(class15.field194 == null) {
                  class15.field194 = class142.method2715(class0.field2, "headicons_pk", "");
               } else {
                  ++var0;
               }

               if(class149.field2037 == null) {
                  class149.field2037 = class142.method2715(class0.field2, "headicons_prayer", "");
               } else {
                  ++var0;
               }

               if(class15.field189 == null) {
                  class15.field189 = class142.method2715(class0.field2, "headicons_hint", "");
               } else {
                  ++var0;
               }

               if(null == class10.field129) {
                  class10.field129 = class142.method2715(class0.field2, "mapmarker", "");
               } else {
                  ++var0;
               }

               if(Client.field449 == null) {
                  Client.field449 = class142.method2715(class0.field2, "cross", "");
               } else {
                  ++var0;
               }

               if(ItemLayer.field1223 == null) {
                  ItemLayer.field1223 = class142.method2715(class0.field2, "mapdots", "");
               } else {
                  ++var0;
               }

               if(null == GroundObject.field1309) {
                  GroundObject.field1309 = class0.method15(class0.field2, "scrollbar", "");
               } else {
                  ++var0;
               }

               if(null == Spotanim.field2800) {
                  Spotanim.field2800 = class0.method15(class0.field2, "mod_icons", "");
               } else {
                  ++var0;
               }

               if(var0 < 12) {
                  class41.field866 = "Loading sprites - " + 100 * var0 / 12 + "%";
                  class41.field872 = 70;
               } else {
                  FontTypeFace.modIcons = Spotanim.field2800;
                  Frames.field1583.method4184();
                  var1 = (int)(Math.random() * 21.0D) - 10;
                  var2 = (int)(Math.random() * 21.0D) - 10;
                  var3 = (int)(Math.random() * 21.0D) - 10;
                  var4 = (int)(Math.random() * 41.0D) - 20;

                  for(int var20 = 0; var20 < class172.field2335.length; ++var20) {
                     class172.field2335[var20].method4218(var4 + var1, var2 + var4, var4 + var3);
                  }

                  class65.field1116[0].method4089(var4 + var1, var4 + var2, var3 + var4);
                  class41.field866 = "Loaded sprites";
                  class41.field872 = 70;
                  Client.field338 = 90;
               }
            }
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([LWorld;II[I[II)V",
      garbageValue = "-1915784361"
   )
   static void method2274(World[] var0, int var1, int var2, int[] var3, int[] var4) {
      if(var1 < var2) {
         int var5 = var1 - 1;
         int var6 = var2 + 1;
         int var7 = (var2 + var1) / 2;
         World var8 = var0[var7];
         var0[var7] = var0[var1];
         var0[var1] = var8;

         while(var5 < var6) {
            boolean var9 = true;

            int var10;
            int var11;
            int var12;
            do {
               --var6;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var6].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var6].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var6].method673()?1:0;
                     var12 = var8.method673()?1:0;
                  } else {
                     var11 = var0[var6].id;
                     var12 = var8.id;
                  }

                  if(var12 != var11) {
                     if((var4[var10] != 1 || var11 <= var12) && (var4[var10] != 0 || var11 >= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            var9 = true;

            do {
               ++var5;

               for(var10 = 0; var10 < 4; ++var10) {
                  if(var3[var10] == 2) {
                     var11 = var0[var5].index;
                     var12 = var8.index;
                  } else if(var3[var10] == 1) {
                     var11 = var0[var5].playerCount;
                     var12 = var8.playerCount;
                     if(var11 == -1 && var4[var10] == 1) {
                        var11 = 2001;
                     }

                     if(var12 == -1 && var4[var10] == 1) {
                        var12 = 2001;
                     }
                  } else if(var3[var10] == 3) {
                     var11 = var0[var5].method673()?1:0;
                     var12 = var8.method673()?1:0;
                  } else {
                     var11 = var0[var5].id;
                     var12 = var8.id;
                  }

                  if(var11 != var12) {
                     if((var4[var10] != 1 || var11 >= var12) && (var4[var10] != 0 || var11 <= var12)) {
                        var9 = false;
                     }
                     break;
                  }

                  if(var10 == 3) {
                     var9 = false;
                  }
               }
            } while(var9);

            if(var5 < var6) {
               World var13 = var0[var5];
               var0[var5] = var0[var6];
               var0[var6] = var13;
            }
         }

         method2274(var0, var1, var6, var3, var4);
         method2274(var0, 1 + var6, var2, var3, var4);
      }

   }

   public final synchronized void mouseEntered(MouseEvent var1) {
      if(null != mouse) {
         mouseIdleTicks = 0;
         field1804 = var1.getX();
         field1810 = var1.getY();
      }

   }
}
