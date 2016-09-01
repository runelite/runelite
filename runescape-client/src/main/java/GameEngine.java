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

@ObfuscatedName("ep")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("pc")
   @ObfuscatedGetter(
      intValue = 904977581
   )
   static int field2245 = 0;
   @ObfuscatedName("qt")
   static long[] field2246 = new long[32];
   @ObfuscatedName("py")
   @ObfuscatedGetter(
      longValue = -4481068026636879335L
   )
   static long field2247 = 0L;
   @ObfuscatedName("qd")
   static long[] field2248 = new long[32];
   @ObfuscatedName("pg")
   boolean field2249;
   @ObfuscatedName("pi")
   @ObfuscatedGetter(
      intValue = 1899867273
   )
   static int field2250 = 20;
   @ObfuscatedName("pd")
   static boolean field2251 = false;
   @ObfuscatedName("qc")
   @ObfuscatedGetter(
      intValue = -864267149
   )
   @Export("FPS")
   protected static int FPS = 0;
   @ObfuscatedName("px")
   static GameEngine field2254 = null;
   @ObfuscatedName("qo")
   @ObfuscatedGetter(
      intValue = -159760245
   )
   protected static int field2255 = 0;
   @ObfuscatedName("ql")
   @ObfuscatedGetter(
      intValue = 274405691
   )
   protected static int field2256 = 0;
   @ObfuscatedName("qp")
   protected static volatile boolean field2257 = true;
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = -1148468799
   )
   static int field2258 = 1;
   @ObfuscatedName("qj")
   protected static boolean field2259 = false;
   @ObfuscatedName("qb")
   protected static volatile boolean field2260 = false;
   @ObfuscatedName("qr")
   @ObfuscatedGetter(
      longValue = -1770284704444766845L
   )
   static volatile long field2261 = 0L;
   @ObfuscatedName("ry")
   static volatile boolean field2262 = true;
   @ObfuscatedName("qa")
   @ObfuscatedGetter(
      intValue = -1115992277
   )
   static int field2263 = 500;

   @ObfuscatedName("pt")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "122030146"
   )
   protected final void method3062(int var1, int var2, int var3) {
      try {
         if(field2254 != null) {
            ++field2245;
            if(field2245 >= 3) {
               this.method3078("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field2254 = this;
         FaceNormal.field1499 = var1;
         class212.field3175 = var2;
         class192.field3104 = var3;
         class151.field2280 = this;
         if(class127.field2086 == null) {
            class127.field2086 = new class139();
         }

         class127.field2086.method2927(this, 1);
      } catch (Exception var5) {
         class107.method2357((String)null, var5);
         this.method3078("crash");
      }

   }

   @ObfuscatedName("pj")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "925199842"
   )
   protected final synchronized void method3063() {
      Container var1 = this.method3079();
      if(class129.canvas != null) {
         class129.canvas.removeFocusListener(this);
         var1.remove(class129.canvas);
      }

      FaceNormal.field1499 = Math.max(var1.getWidth(), ObjectComposition.field935);
      class212.field3175 = Math.max(var1.getHeight(), ItemLayer.field1738);
      Insets var2;
      if(FaceNormal.field1496 != null) {
         var2 = FaceNormal.field1496.getInsets();
         FaceNormal.field1499 -= var2.left + var2.right;
         class212.field3175 -= var2.top + var2.bottom;
      }

      class129.canvas = new RSCanvas(this);
      var1.add(class129.canvas);
      class129.canvas.setSize(FaceNormal.field1499, class212.field3175);
      class129.canvas.setVisible(true);
      if(var1 == FaceNormal.field1496) {
         var2 = FaceNormal.field1496.getInsets();
         class129.canvas.setLocation(var2.left + field2255, var2.top + field2256);
      } else {
         class129.canvas.setLocation(field2255, field2256);
      }

      class129.canvas.addFocusListener(this);
      class129.canvas.requestFocus();
      field2257 = true;
      int var3 = FaceNormal.field1499;
      int var4 = class212.field3175;
      Canvas var5 = class129.canvas;

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

      if(class40.bufferProvider != null) {
         class40.bufferProvider.draw(((BufferProvider)var9).image.getGraphics(), 0, 0);
      }

      class40.bufferProvider = (BufferProvider)var9;
      field2260 = false;
      field2261 = class34.method713();
   }

   @ObfuscatedName("pl")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1248269205"
   )
   protected final boolean method3064() {
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
                     this.method3078("invalidhost");
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "115775272"
   )
   protected abstract void vmethod3065();

   @ObfuscatedName("px")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "1701"
   )
   void method3067() {
      Container var1 = this.method3079();
      long var2 = class34.method713();
      long var4 = field2248[CollisionData.field1965];
      field2248[CollisionData.field1965] = var2;
      CollisionData.field1965 = CollisionData.field1965 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var7 = (int)(var2 - var4);
         FPS = (32000 + (var7 >> 1)) / var7;
      }

      if(++field2263 - 1 > 50) {
         field2263 -= 50;
         field2257 = true;
         class129.canvas.setSize(FaceNormal.field1499, class212.field3175);
         class129.canvas.setVisible(true);
         if(FaceNormal.field1496 == var1) {
            Insets var6 = FaceNormal.field1496.getInsets();
            class129.canvas.setLocation(var6.left + field2255, var6.top + field2256);
         } else {
            class129.canvas.setLocation(field2255, field2256);
         }
      }

      this.vmethod3133();
   }

   @ObfuscatedName("pc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1037982524"
   )
   final synchronized void method3068() {
      if(!field2251) {
         field2251 = true;

         try {
            class129.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod3077();
         } catch (Exception var4) {
            ;
         }

         if(null != FaceNormal.field1496) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(class127.field2086 != null) {
            try {
               class127.field2086.method2923();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod3065();
      }
   }

   @ObfuscatedName("pq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "813674026"
   )
   void method3069() {
      long var1 = class34.method713();
      long var3 = field2246[class134.field2116];
      field2246[class134.field2116] = var1;
      class134.field2116 = 1 + class134.field2116 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         class184.field2991 = field2262;
      }

      this.packetHandler();
   }

   public void stop() {
      if(field2254 == this && !field2251) {
         field2247 = class34.method713() + 4000L;
      }
   }

   public void destroy() {
      if(this == field2254 && !field2251) {
         field2247 = class34.method713();
         class125.method2820(5000L);
         this.method3068();
      }
   }

   public final synchronized void paint(Graphics var1) {
      if(field2254 == this && !field2251) {
         field2257 = true;
         if(null != class139.field2138 && class139.field2138.startsWith("1.5") && class34.method713() - field2261 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(null == var2 || var2.width >= FaceNormal.field1499 && var2.height >= class212.field3175) {
               field2260 = true;
            }
         }

      }
   }

   public final void focusGained(FocusEvent var1) {
      field2262 = true;
      field2257 = true;
   }

   public final void focusLost(FocusEvent var1) {
      field2262 = false;
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final void windowDeiconified(WindowEvent var1) {
   }

   public final void windowIconified(WindowEvent var1) {
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public abstract void init();

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "25292714"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-224721789"
   )
   protected abstract void vmethod3077();

   @ObfuscatedName("pd")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "16711680"
   )
   protected void method3078(String var1) {
      if(!this.field2249) {
         this.field2249 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("pg")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-495080898"
   )
   protected Container method3079() {
      return (Container)(null != FaceNormal.field1496?FaceNormal.field1496:this);
   }

   @ObfuscatedName("pw")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Dimension;",
      garbageValue = "1042830557"
   )
   protected Dimension method3080() {
      Container var1 = this.method3079();
      int var2 = Math.max(var1.getWidth(), ObjectComposition.field935);
      int var3 = Math.max(var1.getHeight(), ItemLayer.field1738);
      if(null != FaceNormal.field1496) {
         Insets var4 = FaceNormal.field1496.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.bottom + var4.top;
      }

      return new Dimension(var2, var3);
   }

   public void start() {
      if(this == field2254 && !field2251) {
         field2247 = 0L;
      }
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1038456919"
   )
   protected abstract void vmethod3133();

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1659072882"
   )
   protected abstract void vmethod3140();

   public void run() {
      try {
         if(class139.field2141 != null) {
            String var1 = class139.field2141.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class139.field2138;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method3078("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length() && class165.method3223(var2.charAt(var3)); ++var3) {
                     ;
                  }

                  String var4 = var2.substring(6, var3);
                  if(VertexNormal.method2253(var4)) {
                     int var5 = SecondaryBufferProvider.method1672(var4, 10, true);
                     if(var5 < 10) {
                        this.method3078("wrongjava");
                        return;
                     }
                  }
               }

               field2258 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method3063();
         this.vmethod3140();

         Object var9;
         try {
            var9 = new class150();
         } catch (Throwable var7) {
            var9 = new class144();
         }

         class138.field2133 = (class136)var9;

         while(field2247 == 0L || class34.method713() < field2247) {
            class0.field13 = class138.field2133.vmethod3169(field2250, field2258);

            for(int var6 = 0; var6 < class0.field13; ++var6) {
               this.method3069();
            }

            this.method3067();
            class128.method2861(class127.field2086, class129.canvas);
         }
      } catch (Exception var8) {
         class107.method2357((String)null, var8);
         this.method3078("crash");
      }

      this.method3068();
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void windowClosed(WindowEvent var1) {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IIIIIILRegion;LCollisionData;I)V",
      garbageValue = "-25210327"
   )
   static final void method3158(int var0, int var1, int var2, int var3, int var4, int var5, Region var6, CollisionData var7) {
      if(!Client.field314 || (class5.tileSettings[0][var1][var2] & 2) != 0 || (class5.tileSettings[var0][var1][var2] & 16) == 0) {
         if(var0 < class5.field73) {
            class5.field73 = var0;
         }

         ObjectComposition var8 = class1.getObjectDefinition(var3);
         int var9;
         int var10;
         if(var4 != 1 && var4 != 3) {
            var9 = var8.field938;
            var10 = var8.field939;
         } else {
            var9 = var8.field939;
            var10 = var8.field938;
         }

         int var11;
         int var12;
         if(var9 + var1 <= 104) {
            var11 = (var9 >> 1) + var1;
            var12 = var1 + (1 + var9 >> 1);
         } else {
            var11 = var1;
            var12 = var1 + 1;
         }

         int var13;
         int var14;
         if(var10 + var2 <= 104) {
            var13 = var2 + (var10 >> 1);
            var14 = (1 + var10 >> 1) + var2;
         } else {
            var13 = var2;
            var14 = var2 + 1;
         }

         int[][] var15 = class5.tileHeights[var0];
         int var16 = var15[var11][var14] + var15[var12][var13] + var15[var11][var13] + var15[var12][var14] >> 2;
         int var17 = (var1 << 7) + (var9 << 6);
         int var18 = (var2 << 7) + (var10 << 6);
         int var19 = 1073741824 + (var3 << 14) + var1 + (var2 << 7);
         if(var8.field966 == 0) {
            var19 -= Integer.MIN_VALUE;
         }

         int var20 = (var4 << 6) + var5;
         if(var8.field963 == 1) {
            var20 += 256;
         }

         if(var8.method797()) {
            class0.method2(var0, var1, var2, var8, var4);
         }

         Object var21;
         if(var5 == 22) {
            if(!Client.field314 || var8.field966 != 0 || var8.field940 == 1 || var8.field961) {
               if(var8.field946 == -1 && var8.impostorIds == null) {
                  var21 = var8.method803(22, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class12(var3, 22, var4, var0, var1, var2, var8.field946, true, (Renderable)null);
               }

               var6.groundObjectSpawned(var0, var1, var2, var16, (Renderable)var21, var19, var20);
               if(var8.field940 == 1 && var7 != null) {
                  var7.method2446(var1, var2);
               }

            }
         } else {
            int var22;
            if(var5 != 10 && var5 != 11) {
               if(var5 >= 12) {
                  if(var8.field946 == -1 && var8.impostorIds == null) {
                     var21 = var8.method803(var5, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class12(var3, var5, var4, var0, var1, var2, var8.field946, true, (Renderable)null);
                  }

                  var6.method1958(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                  if(var5 >= 12 && var5 <= 17 && var5 != 13 && var0 > 0) {
                     class220.field3214[var0][var1][var2] |= 2340;
                  }

                  if(var8.field940 != 0 && null != var7) {
                     var7.method2444(var1, var2, var9, var10, var8.field973);
                  }

               } else if(var5 == 0) {
                  if(var8.field946 == -1 && var8.impostorIds == null) {
                     var21 = var8.method803(0, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class12(var3, 0, var4, var0, var1, var2, var8.field946, true, (Renderable)null);
                  }

                  var6.method2010(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class5.field82[var4], 0, var19, var20);
                  if(var4 == 0) {
                     if(var8.field932) {
                        class132.field2104[var0][var1][var2] = 50;
                        class132.field2104[var0][var1][1 + var2] = 50;
                     }

                     if(var8.field945) {
                        class220.field3214[var0][var1][var2] |= 585;
                     }
                  } else if(var4 == 1) {
                     if(var8.field932) {
                        class132.field2104[var0][var1][var2 + 1] = 50;
                        class132.field2104[var0][1 + var1][1 + var2] = 50;
                     }

                     if(var8.field945) {
                        class220.field3214[var0][var1][var2 + 1] |= 1170;
                     }
                  } else if(var4 == 2) {
                     if(var8.field932) {
                        class132.field2104[var0][1 + var1][var2] = 50;
                        class132.field2104[var0][1 + var1][var2 + 1] = 50;
                     }

                     if(var8.field945) {
                        class220.field3214[var0][var1 + 1][var2] |= 585;
                     }
                  } else if(var4 == 3) {
                     if(var8.field932) {
                        class132.field2104[var0][var1][var2] = 50;
                        class132.field2104[var0][1 + var1][var2] = 50;
                     }

                     if(var8.field945) {
                        class220.field3214[var0][var1][var2] |= 1170;
                     }
                  }

                  if(var8.field940 != 0 && var7 != null) {
                     var7.method2443(var1, var2, var5, var4, var8.field973);
                  }

                  if(var8.field976 != 16) {
                     var6.method1964(var0, var1, var2, var8.field976);
                  }

               } else if(var5 == 1) {
                  if(var8.field946 == -1 && var8.impostorIds == null) {
                     var21 = var8.method803(1, var4, var15, var17, var16, var18);
                  } else {
                     var21 = new class12(var3, 1, var4, var0, var1, var2, var8.field946, true, (Renderable)null);
                  }

                  var6.method2010(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class5.field83[var4], 0, var19, var20);
                  if(var8.field932) {
                     if(var4 == 0) {
                        class132.field2104[var0][var1][1 + var2] = 50;
                     } else if(var4 == 1) {
                        class132.field2104[var0][1 + var1][1 + var2] = 50;
                     } else if(var4 == 2) {
                        class132.field2104[var0][1 + var1][var2] = 50;
                     } else if(var4 == 3) {
                        class132.field2104[var0][var1][var2] = 50;
                     }
                  }

                  if(var8.field940 != 0 && var7 != null) {
                     var7.method2443(var1, var2, var5, var4, var8.field973);
                  }

               } else {
                  Object var26;
                  int var27;
                  if(var5 == 2) {
                     var27 = var4 + 1 & 3;
                     Object var29;
                     if(var8.field946 == -1 && var8.impostorIds == null) {
                        var29 = var8.method803(2, 4 + var4, var15, var17, var16, var18);
                        var26 = var8.method803(2, var27, var15, var17, var16, var18);
                     } else {
                        var29 = new class12(var3, 2, 4 + var4, var0, var1, var2, var8.field946, true, (Renderable)null);
                        var26 = new class12(var3, 2, var27, var0, var1, var2, var8.field946, true, (Renderable)null);
                     }

                     var6.method2010(var0, var1, var2, var16, (Renderable)var29, (Renderable)var26, class5.field82[var4], class5.field82[var27], var19, var20);
                     if(var8.field945) {
                        if(var4 == 0) {
                           class220.field3214[var0][var1][var2] |= 585;
                           class220.field3214[var0][var1][var2 + 1] |= 1170;
                        } else if(var4 == 1) {
                           class220.field3214[var0][var1][1 + var2] |= 1170;
                           class220.field3214[var0][var1 + 1][var2] |= 585;
                        } else if(var4 == 2) {
                           class220.field3214[var0][var1 + 1][var2] |= 585;
                           class220.field3214[var0][var1][var2] |= 1170;
                        } else if(var4 == 3) {
                           class220.field3214[var0][var1][var2] |= 1170;
                           class220.field3214[var0][var1][var2] |= 585;
                        }
                     }

                     if(var8.field940 != 0 && var7 != null) {
                        var7.method2443(var1, var2, var5, var4, var8.field973);
                     }

                     if(var8.field976 != 16) {
                        var6.method1964(var0, var1, var2, var8.field976);
                     }

                  } else if(var5 == 3) {
                     if(var8.field946 == -1 && null == var8.impostorIds) {
                        var21 = var8.method803(3, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, 3, var4, var0, var1, var2, var8.field946, true, (Renderable)null);
                     }

                     var6.method2010(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class5.field83[var4], 0, var19, var20);
                     if(var8.field932) {
                        if(var4 == 0) {
                           class132.field2104[var0][var1][var2 + 1] = 50;
                        } else if(var4 == 1) {
                           class132.field2104[var0][var1 + 1][var2 + 1] = 50;
                        } else if(var4 == 2) {
                           class132.field2104[var0][var1 + 1][var2] = 50;
                        } else if(var4 == 3) {
                           class132.field2104[var0][var1][var2] = 50;
                        }
                     }

                     if(var8.field940 != 0 && var7 != null) {
                        var7.method2443(var1, var2, var5, var4, var8.field973);
                     }

                  } else if(var5 == 9) {
                     if(var8.field946 == -1 && null == var8.impostorIds) {
                        var21 = var8.method803(var5, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, var5, var4, var0, var1, var2, var8.field946, true, (Renderable)null);
                     }

                     var6.method1958(var0, var1, var2, var16, 1, 1, (Renderable)var21, 0, var19, var20);
                     if(var8.field940 != 0 && var7 != null) {
                        var7.method2444(var1, var2, var9, var10, var8.field973);
                     }

                     if(var8.field976 != 16) {
                        var6.method1964(var0, var1, var2, var8.field976);
                     }

                  } else if(var5 == 4) {
                     if(var8.field946 == -1 && var8.impostorIds == null) {
                        var21 = var8.method803(4, var4, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, 4, var4, var0, var1, var2, var8.field946, true, (Renderable)null);
                     }

                     var6.method1957(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, class5.field82[var4], 0, 0, 0, var19, var20);
                  } else if(var5 == 5) {
                     var27 = 16;
                     var22 = var6.method1974(var0, var1, var2);
                     if(var22 != 0) {
                        var27 = class1.getObjectDefinition(var22 >> 14 & 32767).field976;
                     }

                     if(var8.field946 == -1 && null == var8.impostorIds) {
                        var26 = var8.method803(4, var4, var15, var17, var16, var18);
                     } else {
                        var26 = new class12(var3, 4, var4, var0, var1, var2, var8.field946, true, (Renderable)null);
                     }

                     var6.method1957(var0, var1, var2, var16, (Renderable)var26, (Renderable)null, class5.field82[var4], 0, class5.field84[var4] * var27, class5.field77[var4] * var27, var19, var20);
                  } else if(var5 == 6) {
                     var27 = 8;
                     var22 = var6.method1974(var0, var1, var2);
                     if(var22 != 0) {
                        var27 = class1.getObjectDefinition(var22 >> 14 & 32767).field976 / 2;
                     }

                     if(var8.field946 == -1 && null == var8.impostorIds) {
                        var26 = var8.method803(4, 4 + var4, var15, var17, var16, var18);
                     } else {
                        var26 = new class12(var3, 4, var4 + 4, var0, var1, var2, var8.field946, true, (Renderable)null);
                     }

                     var6.method1957(var0, var1, var2, var16, (Renderable)var26, (Renderable)null, 256, var4, var27 * class5.field90[var4], var27 * class5.field87[var4], var19, var20);
                  } else if(var5 == 7) {
                     var22 = var4 + 2 & 3;
                     if(var8.field946 == -1 && null == var8.impostorIds) {
                        var21 = var8.method803(4, 4 + var22, var15, var17, var16, var18);
                     } else {
                        var21 = new class12(var3, 4, var22 + 4, var0, var1, var2, var8.field946, true, (Renderable)null);
                     }

                     var6.method1957(var0, var1, var2, var16, (Renderable)var21, (Renderable)null, 256, var22, 0, 0, var19, var20);
                  } else if(var5 == 8) {
                     var27 = 8;
                     var22 = var6.method1974(var0, var1, var2);
                     if(var22 != 0) {
                        var27 = class1.getObjectDefinition(var22 >> 14 & 32767).field976 / 2;
                     }

                     int var25 = 2 + var4 & 3;
                     Object var28;
                     if(var8.field946 == -1 && null == var8.impostorIds) {
                        var26 = var8.method803(4, 4 + var4, var15, var17, var16, var18);
                        var28 = var8.method803(4, var25 + 4, var15, var17, var16, var18);
                     } else {
                        var26 = new class12(var3, 4, var4 + 4, var0, var1, var2, var8.field946, true, (Renderable)null);
                        var28 = new class12(var3, 4, 4 + var25, var0, var1, var2, var8.field946, true, (Renderable)null);
                     }

                     var6.method1957(var0, var1, var2, var16, (Renderable)var26, (Renderable)var28, 256, var4, class5.field90[var4] * var27, class5.field87[var4] * var27, var19, var20);
                  }
               }
            } else {
               if(var8.field946 == -1 && null == var8.impostorIds) {
                  var21 = var8.method803(10, var4, var15, var17, var16, var18);
               } else {
                  var21 = new class12(var3, 10, var4, var0, var1, var2, var8.field946, true, (Renderable)null);
               }

               if(var21 != null && var6.method1958(var0, var1, var2, var16, var9, var10, (Renderable)var21, var5 == 11?256:0, var19, var20) && var8.field932) {
                  var22 = 15;
                  if(var21 instanceof Model) {
                     var22 = ((Model)var21).method2365() / 4;
                     if(var22 > 30) {
                        var22 = 30;
                     }
                  }

                  for(int var23 = 0; var23 <= var9; ++var23) {
                     for(int var24 = 0; var24 <= var10; ++var24) {
                        if(var22 > class132.field2104[var0][var23 + var1][var24 + var2]) {
                           class132.field2104[var0][var23 + var1][var2 + var24] = (byte)var22;
                        }
                     }
                  }
               }

               if(var8.field940 != 0 && null != var7) {
                  var7.method2444(var1, var2, var9, var10, var8.field973);
               }

            }
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "207753269"
   )
   public static int method3159(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }
}
