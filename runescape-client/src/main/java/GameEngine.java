import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("qp")
   protected static volatile boolean field2229 = true;
   @ObfuscatedName("qx")
   protected static boolean field2230 = false;
   @ObfuscatedName("pa")
   @ObfuscatedGetter(
      longValue = -3561957674823158811L
   )
   static long field2231 = 0L;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -71371387
   )
   static int field2232;
   @ObfuscatedName("pp")
   static boolean field2233 = false;
   @ObfuscatedName("pu")
   @ObfuscatedGetter(
      intValue = 238231787
   )
   static int field2234 = 20;
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = 81555697
   )
   static int field2235 = 1;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = 1285270849
   )
   @Export("FPS")
   protected static int FPS = 0;
   @ObfuscatedName("pn")
   static GameEngine field2237 = null;
   @ObfuscatedName("qo")
   protected static long[] field2238 = new long[32];
   @ObfuscatedName("qy")
   @ObfuscatedGetter(
      intValue = 48425973
   )
   protected static int field2239 = 0;
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      intValue = 1729696967
   )
   protected static int field2240 = 0;
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      longValue = 3425088861007314355L
   )
   static volatile long field2241 = 0L;
   @ObfuscatedName("qh")
   @ObfuscatedGetter(
      intValue = 1989583459
   )
   static int field2242 = 500;
   @ObfuscatedName("pc")
   boolean field2243;
   @ObfuscatedName("qf")
   protected static volatile boolean field2244 = false;
   @ObfuscatedName("pq")
   @ObfuscatedGetter(
      intValue = 582311207
   )
   static int field2245 = 0;
   @ObfuscatedName("rn")
   static volatile boolean field2246 = true;
   @ObfuscatedName("m")
   static class156 field2247;
   @ObfuscatedName("s")
   static class170 field2248;
   @ObfuscatedName("ay")
   static class149 field2249;
   @ObfuscatedName("qw")
   protected static long[] field2251 = new long[32];

   public final void windowClosed(WindowEvent var1) {
   }

   @ObfuscatedName("pm")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "75"
   )
   protected final synchronized void method3008() {
      Container var1 = this.method3063();
      if(Frames.canvas != null) {
         Frames.canvas.removeFocusListener(this);
         var1.remove(Frames.canvas);
      }

      class50.field1069 = Math.max(var1.getWidth(), class157.field2334);
      class139.field2143 = Math.max(var1.getHeight(), XClanMember.field613);
      Insets var2;
      if(null != class118.field2008) {
         var2 = class118.field2008.getInsets();
         class50.field1069 -= var2.left + var2.right;
         class139.field2143 -= var2.bottom + var2.top;
      }

      Frames.canvas = new RSCanvas(this);
      var1.add(Frames.canvas);
      Frames.canvas.setSize(class50.field1069, class139.field2143);
      Frames.canvas.setVisible(true);
      if(var1 == class118.field2008) {
         var2 = class118.field2008.getInsets();
         Frames.canvas.setLocation(field2239 + var2.left, var2.top + field2240);
      } else {
         Frames.canvas.setLocation(field2239, field2240);
      }

      Frames.canvas.addFocusListener(this);
      Frames.canvas.requestFocus();
      field2229 = true;
      int var3 = class50.field1069;
      int var4 = class139.field2143;
      Canvas var5 = Frames.canvas;

      Object var9;
      try {
         MainBufferProvider var6 = new MainBufferProvider();
         var6.init(var3, var4, var5);
         var9 = var6;
      } catch (Throwable var8) {
         SecondaryBufferProvider var7 = new SecondaryBufferProvider();
         var7.init(var3, var4, var5);
         var9 = var7;
      }

      if(Player.bufferProvider != null) {
         Player.bufferProvider.draw(((BufferProvider)var9).image.getGraphics(), 0, 0);
      }

      Player.bufferProvider = (BufferProvider)var9;
      field2244 = false;
      field2241 = class113.method2394();
   }

   public void run() {
      try {
         if(class139.field2137 != null) {
            String var1 = class139.field2137.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class139.field2136;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method3022("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && WallObject.method2077(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  boolean var5 = class59.method1228(var4, 10, true);
                  if(var5 && class8.method117(var4) < 10) {
                     this.method3022("wrongjava");
                     return;
                  }
               }

               field2235 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method3008();
         this.vmethod3018();
         class14.field199 = class124.method2743();

         while(0L == field2231 || class113.method2394() < field2231) {
            class34.field752 = class14.field199.vmethod3114(field2234, field2235);

            for(int var6 = 0; var6 < class34.field752; ++var6) {
               this.method3052();
            }

            this.method3011();
            ChatMessages.method223(class8.field121, Frames.canvas);
         }
      } catch (Exception var7) {
         class144.method2970((String)null, var7);
         this.method3022("crash");
      }

      this.method3012();
   }

   @ObfuscatedName("ps")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1739478271"
   )
   protected final void method3010(int var1, int var2, int var3) {
      try {
         if(field2237 != null) {
            ++field2245;
            if(field2245 >= 3) {
               this.method3022("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field2237 = this;
         class50.field1069 = var1;
         class139.field2143 = var2;
         class114.field1985 = var3;
         class151.field2266 = this;
         if(class8.field121 == null) {
            class8.field121 = new class139();
         }

         class8.field121.method2878(this, 1);
      } catch (Exception var5) {
         class144.method2970((String)null, var5);
         this.method3022("crash");
      }

   }

   @ObfuscatedName("pn")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1450247325"
   )
   void method3011() {
      Container var1 = this.method3063();
      long var2 = class113.method2394();
      long var4 = field2251[class10.field155];
      field2251[class10.field155] = var2;
      class10.field155 = class10.field155 + 1 & 31;
      if(var4 != 0L && var2 > var4) {
         int var6 = (int)(var2 - var4);
         FPS = ((var6 >> 1) + 32000) / var6;
      }

      if(++field2242 - 1 > 50) {
         field2242 -= 50;
         field2229 = true;
         Frames.canvas.setSize(class50.field1069, class139.field2143);
         Frames.canvas.setVisible(true);
         if(var1 == class118.field2008) {
            Insets var7 = class118.field2008.getInsets();
            Frames.canvas.setLocation(field2239 + var7.left, field2240 + var7.top);
         } else {
            Frames.canvas.setLocation(field2239, field2240);
         }
      }

      this.vmethod3020();
   }

   @ObfuscatedName("pq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-893590932"
   )
   final synchronized void method3012() {
      if(!field2233) {
         field2233 = true;

         try {
            Frames.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod3021();
         } catch (Exception var4) {
            ;
         }

         if(class118.field2008 != null) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(class8.field121 != null) {
            try {
               class8.field121.method2877();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod3025();
      }
   }

   public void stop() {
      if(field2237 == this && !field2233) {
         field2231 = class113.method2394() + 4000L;
      }
   }

   public void destroy() {
      if(field2237 == this && !field2233) {
         field2231 = class113.method2394();
         class16.method185(5000L);
         this.method3012();
      }
   }

   @ObfuscatedName("bo")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2131451753"
   )
   static final void method3014() {
      int var1;
      int var2;
      int var3;
      Item var30;
      int var35;
      if(Client.packetOpcode == 41) {
         var35 = Client.field312.method2668();
         var1 = Client.field312.method2510();
         var2 = (var1 >> 4 & 7) + class59.field1237;
         var3 = Client.field362 + (var1 & 7);
         if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
            Deque var29 = Client.groundItemDeque[class59.plane][var2][var3];
            if(null != var29) {
               for(var30 = (Item)var29.method3808(); var30 != null; var30 = (Item)var29.method3810()) {
                  if((var35 & 32767) == var30.id) {
                     var30.unlink();
                     break;
                  }
               }

               if(var29.method3808() == null) {
                  Client.groundItemDeque[class59.plane][var2][var3] = null;
               }

               class116.groundItemSpawned(var2, var3);
            }
         }

      } else {
         int var4;
         int var5;
         int var6;
         if(Client.packetOpcode == 250) {
            var35 = Client.field312.method2481();
            var1 = class59.field1237 + (var35 >> 4 & 7);
            var2 = (var35 & 7) + Client.field362;
            var3 = Client.field312.method2481();
            var4 = var3 >> 2;
            var5 = var3 & 3;
            var6 = Client.field331[var4];
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               class14.method168(class59.plane, var1, var2, var6, -1, var4, var5, 0, -1);
            }

         } else if(Client.packetOpcode == 249) {
            var35 = Client.field312.method2481();
            var1 = (var35 >> 4 & 7) + class59.field1237;
            var2 = (var35 & 7) + Client.field362;
            var3 = Client.field312.method2668();
            var4 = Client.field312.method2668();
            var5 = Client.field312.method2668();
            if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
               Deque var41 = Client.groundItemDeque[class59.plane][var1][var2];
               if(var41 != null) {
                  for(Item var7 = (Item)var41.method3808(); null != var7; var7 = (Item)var41.method3810()) {
                     if((var3 & 32767) == var7.id && var4 == var7.quantity) {
                        var7.quantity = var5;
                        break;
                     }
                  }

                  class116.groundItemSpawned(var1, var2);
               }
            }

         } else {
            int var32;
            if(Client.packetOpcode == 35) {
               var35 = Client.field312.method2481();
               var1 = var35 >> 2;
               var2 = var35 & 3;
               var3 = Client.field331[var1];
               var4 = Client.field312.method2510();
               var5 = class59.field1237 + (var4 >> 4 & 7);
               var6 = (var4 & 7) + Client.field362;
               var32 = Client.field312.method2517();
               if(var5 >= 0 && var6 >= 0 && var5 < 104 && var6 < 104) {
                  class14.method168(class59.plane, var5, var6, var3, var32, var1, var2, 0, -1);
               }

            } else {
               int var11;
               int var12;
               int var39;
               int var42;
               if(Client.packetOpcode == 68) {
                  var35 = Client.field312.method2481();
                  var1 = class59.field1237 + (var35 >> 4 & 7);
                  var2 = (var35 & 7) + Client.field362;
                  var3 = var1 + Client.field312.method2601();
                  var4 = var2 + Client.field312.method2601();
                  var5 = Client.field312.method2474();
                  var6 = Client.field312.method2668();
                  var32 = Client.field312.method2481() * 4;
                  var42 = Client.field312.method2481() * 4;
                  var39 = Client.field312.method2668();
                  int var40 = Client.field312.method2668();
                  var11 = Client.field312.method2481();
                  var12 = Client.field312.method2481();
                  if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104 && var3 >= 0 && var4 >= 0 && var3 < 104 && var4 < 104 && var6 != '\uffff') {
                     var1 = 64 + 128 * var1;
                     var2 = 64 + var2 * 128;
                     var3 = 64 + 128 * var3;
                     var4 = 64 + 128 * var4;
                     Projectile var13 = new Projectile(var6, class59.plane, var1, var2, class79.method1656(var1, var2, class59.plane) - var32, var39 + Client.gameCycle, Client.gameCycle + var40, var11, var12, var5, var42);
                     var13.method90(var3, var4, class79.method1656(var3, var4, class59.plane) - var42, Client.gameCycle + var39);
                     Client.projectiles.method3801(var13);
                  }

               } else {
                  if(Client.packetOpcode == 186) {
                     byte var0 = Client.field312.method2601();
                     var1 = Client.field312.method2517();
                     var2 = Client.field312.method2516();
                     var3 = Client.field312.method2516();
                     var4 = Client.field312.method2510();
                     var5 = class59.field1237 + (var4 >> 4 & 7);
                     var6 = (var4 & 7) + Client.field362;
                     var32 = Client.field312.method2517();
                     byte var33 = Client.field312.method2675();
                     byte var9 = Client.field312.method2511();
                     byte var10 = Client.field312.method2675();
                     var11 = Client.field312.method2508();
                     var12 = var11 >> 2;
                     int var34 = var11 & 3;
                     int var14 = Client.field331[var12];
                     Player var15;
                     if(var1 == Client.localInteractingIndex) {
                        var15 = TextureProvider.localPlayer;
                     } else {
                        var15 = Client.cachedPlayers[var1];
                     }

                     if(null != var15) {
                        ObjectComposition var16 = class40.getObjectDefinition(var2);
                        int var17;
                        int var18;
                        if(var34 != 1 && var34 != 3) {
                           var17 = var16.field923;
                           var18 = var16.field924;
                        } else {
                           var17 = var16.field924;
                           var18 = var16.field923;
                        }

                        int var19 = (var17 >> 1) + var5;
                        int var20 = (1 + var17 >> 1) + var5;
                        int var21 = var6 + (var18 >> 1);
                        int var22 = var6 + (1 + var18 >> 1);
                        int[][] var23 = class5.tileHeights[class59.plane];
                        int var24 = var23[var19][var22] + var23[var19][var21] + var23[var20][var21] + var23[var20][var22] >> 2;
                        int var25 = (var17 << 6) + (var5 << 7);
                        int var26 = (var18 << 6) + (var6 << 7);
                        Model var27 = var16.method819(var12, var34, var23, var25, var24, var26);
                        if(var27 != null) {
                           class14.method168(class59.plane, var5, var6, var14, -1, 0, 0, var32 + 1, 1 + var3);
                           var15.totalLevel = var32 + Client.gameCycle;
                           var15.field35 = var3 + Client.gameCycle;
                           var15.model = var27;
                           var15.field44 = 128 * var5 + var17 * 64;
                           var15.field38 = var18 * 64 + 128 * var6;
                           var15.field37 = var24;
                           byte var28;
                           if(var0 > var9) {
                              var28 = var0;
                              var0 = var9;
                              var9 = var28;
                           }

                           if(var10 > var33) {
                              var28 = var10;
                              var10 = var33;
                              var33 = var28;
                           }

                           var15.field40 = var5 + var0;
                           var15.field42 = var9 + var5;
                           var15.field41 = var10 + var6;
                           var15.field43 = var33 + var6;
                        }
                     }
                  }

                  if(Client.packetOpcode == 109) {
                     var35 = Client.field312.method2481();
                     var1 = class59.field1237 + (var35 >> 4 & 7);
                     var2 = (var35 & 7) + Client.field362;
                     var3 = Client.field312.method2668();
                     var4 = Client.field312.method2481();
                     var5 = Client.field312.method2668();
                     if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                        var1 = var1 * 128 + 64;
                        var2 = 64 + 128 * var2;
                        class31 var31 = new class31(var3, class59.plane, var1, var2, class79.method1656(var1, var2, class59.plane) - var4, var5, Client.gameCycle);
                        Client.field403.method3801(var31);
                     }

                  } else if(Client.packetOpcode == 17) {
                     var35 = Client.field312.method2668();
                     var1 = Client.field312.method2554();
                     var2 = (var1 >> 4 & 7) + class59.field1237;
                     var3 = (var1 & 7) + Client.field362;
                     var4 = Client.field312.method2516();
                     if(var2 >= 0 && var3 >= 0 && var2 < 104 && var3 < 104) {
                        var30 = new Item();
                        var30.id = var4;
                        var30.quantity = var35;
                        if(Client.groundItemDeque[class59.plane][var2][var3] == null) {
                           Client.groundItemDeque[class59.plane][var2][var3] = new Deque();
                        }

                        Client.groundItemDeque[class59.plane][var2][var3].method3801(var30);
                        class116.groundItemSpawned(var2, var3);
                     }

                  } else {
                     if(Client.packetOpcode == 110) {
                        var35 = Client.field312.method2481();
                        var1 = class59.field1237 + (var35 >> 4 & 7);
                        var2 = Client.field362 + (var35 & 7);
                        var3 = Client.field312.method2668();
                        var4 = Client.field312.method2481();
                        var5 = var4 >> 4 & 15;
                        var6 = var4 & 7;
                        var32 = Client.field312.method2481();
                        if(var1 >= 0 && var2 >= 0 && var1 < 104 && var2 < 104) {
                           var42 = var5 + 1;
                           if(TextureProvider.localPlayer.pathX[0] >= var1 - var42 && TextureProvider.localPlayer.pathX[0] <= var1 + var42 && TextureProvider.localPlayer.pathY[0] >= var2 - var42 && TextureProvider.localPlayer.pathY[0] <= var2 + var42 && Client.field303 != 0 && var6 > 0 && Client.field510 < 50) {
                              Client.field511[Client.field510] = var3;
                              Client.field315[Client.field510] = var6;
                              Client.field482[Client.field510] = var32;
                              Client.field515[Client.field510] = null;
                              Client.field514[Client.field510] = var5 + (var2 << 8) + (var1 << 16);
                              ++Client.field510;
                           }
                        }
                     }

                     if(Client.packetOpcode == 53) {
                        var35 = Client.field312.method2510();
                        var1 = (var35 >> 4 & 7) + class59.field1237;
                        var2 = (var35 & 7) + Client.field362;
                        var3 = Client.field312.method2668();
                        var4 = Client.field312.method2510();
                        var5 = var4 >> 2;
                        var6 = var4 & 3;
                        var32 = Client.field331[var5];
                        if(var1 >= 0 && var2 >= 0 && var1 < 103 && var2 < 103) {
                           if(var32 == 0) {
                              WallObject var8 = class114.region.method1940(class59.plane, var1, var2);
                              if(null != var8) {
                                 var39 = var8.hash >> 14 & 32767;
                                 if(var5 == 2) {
                                    var8.renderable1 = new class12(var39, 2, 4 + var6, class59.plane, var1, var2, var3, false, var8.renderable1);
                                    var8.renderable2 = new class12(var39, 2, 1 + var6 & 3, class59.plane, var1, var2, var3, false, var8.renderable2);
                                 } else {
                                    var8.renderable1 = new class12(var39, var5, var6, class59.plane, var1, var2, var3, false, var8.renderable1);
                                 }
                              }
                           }

                           if(var32 == 1) {
                              DecorativeObject var36 = class114.region.method1938(class59.plane, var1, var2);
                              if(var36 != null) {
                                 var39 = var36.hash >> 14 & 32767;
                                 if(var5 != 4 && var5 != 5) {
                                    if(var5 == 6) {
                                       var36.renderable1 = new class12(var39, 4, 4 + var6, class59.plane, var1, var2, var3, false, var36.renderable1);
                                    } else if(var5 == 7) {
                                       var36.renderable1 = new class12(var39, 4, (2 + var6 & 3) + 4, class59.plane, var1, var2, var3, false, var36.renderable1);
                                    } else if(var5 == 8) {
                                       var36.renderable1 = new class12(var39, 4, var6 + 4, class59.plane, var1, var2, var3, false, var36.renderable1);
                                       var36.renderable2 = new class12(var39, 4, (var6 + 2 & 3) + 4, class59.plane, var1, var2, var3, false, var36.renderable2);
                                    }
                                 } else {
                                    var36.renderable1 = new class12(var39, 4, var6, class59.plane, var1, var2, var3, false, var36.renderable1);
                                 }
                              }
                           }

                           if(var32 == 2) {
                              GameObject var37 = class114.region.method1939(class59.plane, var1, var2);
                              if(var5 == 11) {
                                 var5 = 10;
                              }

                              if(null != var37) {
                                 var37.renderable = new class12(var37.hash >> 14 & 32767, var5, var6, class59.plane, var1, var2, var3, false, var37.renderable);
                              }
                           }

                           if(var32 == 3) {
                              GroundObject var38 = class114.region.method1932(class59.plane, var1, var2);
                              if(var38 != null) {
                                 var38.renderable = new class12(var38.hash >> 14 & 32767, 22, var6, class59.plane, var1, var2, var3, false, var38.renderable);
                              }
                           }
                        }

                     }
                  }
               }
            }
         }
      }
   }

   public final synchronized void paint(Graphics var1) {
      if(field2237 == this && !field2233) {
         field2229 = true;
         if(null != class139.field2136 && class139.field2136.startsWith("1.5") && class113.method2394() - field2241 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(null == var2 || var2.width >= class50.field1069 && var2.height >= class139.field2143) {
               field2244 = true;
            }
         }

      }
   }

   public final void focusGained(FocusEvent var1) {
      field2246 = true;
      field2229 = true;
   }

   public final void focusLost(FocusEvent var1) {
      field2246 = false;
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "79"
   )
   protected abstract void vmethod3018();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "35"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "6"
   )
   protected abstract void vmethod3020();

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "96"
   )
   protected abstract void vmethod3021();

   @ObfuscatedName("pc")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1051304179"
   )
   protected void method3022(String var1) {
      if(!this.field2243) {
         this.field2243 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "152621234"
   )
   protected abstract void vmethod3025();

   @ObfuscatedName("pu")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Dimension;",
      garbageValue = "1389851137"
   )
   protected Dimension method3033() {
      Container var1 = this.method3063();
      int var2 = Math.max(var1.getWidth(), class157.field2334);
      int var3 = Math.max(var1.getHeight(), XClanMember.field613);
      if(null != class118.field2008) {
         Insets var4 = class118.field2008.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.bottom + var4.top;
      }

      return new Dimension(var2, var3);
   }

   @ObfuscatedName("pb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2003899572"
   )
   void method3052() {
      long var1 = class113.method2394();
      long var3 = field2238[class184.field2979];
      field2238[class184.field2979] = var1;
      class184.field2979 = 1 + class184.field2979 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         class85.field1475 = field2246;
      }

      this.packetHandler();
   }

   public abstract void init();

   public void start() {
      if(field2237 == this && !field2233) {
         field2231 = 0L;
      }
   }

   @ObfuscatedName("py")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-911753665"
   )
   protected Container method3063() {
      return (Container)(null != class118.field2008?class118.field2008:this);
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   @ObfuscatedName("pt")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "598968464"
   )
   protected final boolean method3092() {
      String var1 = this.getDocumentBase().getHost().toLowerCase();
      if(!var1.equals("jagex.com") && !var1.endsWith(".jagex.com")) {
         if(!var1.equals("runescape.com") && !var1.endsWith(".runescape.com")) {
            if(!var1.equals("mechscape.com") && !var1.endsWith(".mechscape.com")) {
               if(var1.endsWith("127.0.0.1")) {
                  return true;
               } else {
                  while(var1.length() > 0 && var1.charAt(var1.length() - 1) >= 48 && var1.charAt(var1.length() - 1) <= 57) {
                     var1 = var1.substring(0, var1.length() - 1);
                  }

                  if(var1.endsWith("192.168.1.")) {
                     return true;
                  } else {
                     this.method3022("invalidhost");
                     return false;
                  }
               }
            } else {
               return true;
            }
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(LWidget;III)V",
      garbageValue = "-769202198"
   )
   static final void method3095(Widget var0, int var1, int var2) {
      if(var0.field2801 == 1) {
         class10.addMenuEntry(var0.tooltip, "", 24, 0, 0, var0.id);
      }

      String var16;
      if(var0.field2801 == 2 && !Client.field270) {
         var16 = Projectile.method101(var0);
         if(null != var16) {
            class10.addMenuEntry(var16, class188.method3706('\uff00') + var0.field2914, 25, 0, -1, var0.id);
         }
      }

      if(var0.field2801 == 3) {
         class10.addMenuEntry("Close", "", 26, 0, 0, var0.id);
      }

      if(var0.field2801 == 4) {
         class10.addMenuEntry(var0.tooltip, "", 28, 0, 0, var0.id);
      }

      if(var0.field2801 == 5) {
         class10.addMenuEntry(var0.tooltip, "", 29, 0, 0, var0.id);
      }

      if(var0.field2801 == 6 && null == Client.field432) {
         class10.addMenuEntry(var0.tooltip, "", 30, 0, -1, var0.id);
      }

      int var3;
      int var4;
      int var5;
      if(var0.type == 2) {
         var3 = 0;

         for(var4 = 0; var4 < var0.height; ++var4) {
            for(var5 = 0; var5 < var0.width; ++var5) {
               int var6 = (32 + var0.field2795) * var5;
               int var7 = (var0.field2865 + 32) * var4;
               if(var3 < 20) {
                  var6 += var0.field2866[var3];
                  var7 += var0.field2867[var3];
               }

               if(var1 >= var6 && var2 >= var7 && var1 < 32 + var6 && var2 < 32 + var7) {
                  Client.field386 = var3;
                  class35.field762 = var0;
                  if(var0.itemIds[var3] > 0) {
                     label418: {
                        ItemComposition var8 = class174.getItemDefinition(var0.itemIds[var3] - 1);
                        int var10;
                        boolean var17;
                        if(Client.field421 == 1) {
                           var10 = class11.method138(var0);
                           var17 = (var10 >> 30 & 1) != 0;
                           if(var17) {
                              if(var0.id != Item.field670 || class145.field2215 != var3) {
                                 class10.addMenuEntry("Use", Client.field416 + " " + "->" + " " + class188.method3706(16748608) + var8.name, 31, var8.id, var3, var0.id);
                              }
                              break label418;
                           }
                        }

                        if(Client.field270) {
                           var10 = class11.method138(var0);
                           var17 = (var10 >> 30 & 1) != 0;
                           if(var17) {
                              if((class124.field2042 & 16) == 16) {
                                 class10.addMenuEntry(Client.field333, Client.field497 + " " + "->" + " " + class188.method3706(16748608) + var8.name, 32, var8.id, var3, var0.id);
                              }
                              break label418;
                           }
                        }

                        String[] var9 = var8.inventoryActions;
                        if(Client.field439) {
                           var9 = MessageNode.method755(var9);
                        }

                        int var11 = class11.method138(var0);
                        boolean var23 = (var11 >> 30 & 1) != 0;
                        if(var23) {
                           for(int var12 = 4; var12 >= 3; --var12) {
                              if(null != var9 && null != var9[var12]) {
                                 byte var13;
                                 if(var12 == 3) {
                                    var13 = 36;
                                 } else {
                                    var13 = 37;
                                 }

                                 class10.addMenuEntry(var9[var12], class188.method3706(16748608) + var8.name, var13, var8.id, var3, var0.id);
                              } else if(var12 == 4) {
                                 class10.addMenuEntry("Drop", class188.method3706(16748608) + var8.name, 37, var8.id, var3, var0.id);
                              }
                           }
                        }

                        Object var10000 = null;
                        if(class166.method3195(class11.method138(var0))) {
                           class10.addMenuEntry("Use", class188.method3706(16748608) + var8.name, 38, var8.id, var3, var0.id);
                        }

                        int var25 = class11.method138(var0);
                        boolean var24 = (var25 >> 30 & 1) != 0;
                        int var14;
                        byte var15;
                        if(var24 && var9 != null) {
                           for(var14 = 2; var14 >= 0; --var14) {
                              if(null != var9[var14]) {
                                 var15 = 0;
                                 if(var14 == 0) {
                                    var15 = 33;
                                 }

                                 if(var14 == 1) {
                                    var15 = 34;
                                 }

                                 if(var14 == 2) {
                                    var15 = 35;
                                 }

                                 class10.addMenuEntry(var9[var14], class188.method3706(16748608) + var8.name, var15, var8.id, var3, var0.id);
                              }
                           }
                        }

                        var9 = var0.field2869;
                        if(Client.field439) {
                           var9 = MessageNode.method755(var9);
                        }

                        if(var9 != null) {
                           for(var14 = 4; var14 >= 0; --var14) {
                              if(null != var9[var14]) {
                                 var15 = 0;
                                 if(var14 == 0) {
                                    var15 = 39;
                                 }

                                 if(var14 == 1) {
                                    var15 = 40;
                                 }

                                 if(var14 == 2) {
                                    var15 = 41;
                                 }

                                 if(var14 == 3) {
                                    var15 = 42;
                                 }

                                 if(var14 == 4) {
                                    var15 = 43;
                                 }

                                 class10.addMenuEntry(var9[var14], class188.method3706(16748608) + var8.name, var15, var8.id, var3, var0.id);
                              }
                           }
                        }

                        class10.addMenuEntry("Examine", class188.method3706(16748608) + var8.name, 1005, var8.id, var3, var0.id);
                     }
                  }
               }

               ++var3;
            }
         }
      }

      if(var0.field2797) {
         if(Client.field270) {
            var4 = class11.method138(var0);
            boolean var21 = (var4 >> 21 & 1) != 0;
            if(var21 && (class124.field2042 & 32) == 32) {
               class10.addMenuEntry(Client.field333, Client.field497 + " " + "->" + " " + var0.name, 58, 0, var0.index, var0.id);
            }
         } else {
            for(var3 = 9; var3 >= 5; --var3) {
               String var18;
               if(!MessageNode.method757(class11.method138(var0), var3) && null == var0.field2873) {
                  var18 = null;
               } else if(null != var0.actions && var0.actions.length > var3 && var0.actions[var3] != null && var0.actions[var3].trim().length() != 0) {
                  var18 = var0.actions[var3];
               } else {
                  var18 = null;
               }

               if(var18 != null) {
                  class10.addMenuEntry(var18, var0.name, 1007, 1 + var3, var0.index, var0.id);
               }
            }

            var16 = Projectile.method101(var0);
            if(var16 != null) {
               class10.addMenuEntry(var16, var0.name, 25, 0, var0.index, var0.id);
            }

            for(var4 = 4; var4 >= 0; --var4) {
               String var19;
               if(!MessageNode.method757(class11.method138(var0), var4) && null == var0.field2873) {
                  var19 = null;
               } else if(null != var0.actions && var0.actions.length > var4 && var0.actions[var4] != null && var0.actions[var4].trim().length() != 0) {
                  var19 = var0.actions[var4];
               } else {
                  var19 = null;
               }

               if(null != var19) {
                  class10.addMenuEntry(var19, var0.name, 57, 1 + var4, var0.index, var0.id);
               }
            }

            var5 = class11.method138(var0);
            boolean var22 = (var5 & 1) != 0;
            if(var22) {
               class10.addMenuEntry("Continue", "", 30, 0, var0.index, var0.id);
            }
         }
      }

   }
}
