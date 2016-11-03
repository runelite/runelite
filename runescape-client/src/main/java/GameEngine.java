import java.applet.Applet;
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

@ObfuscatedName("ez")
@Implements("GameEngine")
public abstract class GameEngine extends Applet implements Runnable, FocusListener, WindowListener {
   @ObfuscatedName("pz")
   @ObfuscatedGetter(
      intValue = 1756056359
   )
   static int field2241 = 20;
   @ObfuscatedName("qx")
   @ObfuscatedGetter(
      intValue = -397034111
   )
   protected static int field2242 = 0;
   @ObfuscatedName("pb")
   @ObfuscatedGetter(
      longValue = -2392504627641587639L
   )
   static long field2243 = 0L;
   @ObfuscatedName("py")
   static boolean field2244 = false;
   @ObfuscatedName("px")
   @ObfuscatedGetter(
      intValue = -866793177
   )
   static int field2245 = 0;
   @ObfuscatedName("pf")
   static GameEngine field2246 = null;
   @ObfuscatedName("qd")
   @ObfuscatedGetter(
      intValue = 487673609
   )
   static int field2247 = 1;
   @ObfuscatedName("qt")
   @ObfuscatedGetter(
      intValue = -1038734311
   )
   @Export("FPS")
   protected static int FPS = 0;
   @ObfuscatedName("qn")
   static long[] field2249 = new long[32];
   @ObfuscatedName("qv")
   static long[] field2250 = new long[32];
   @ObfuscatedName("qg")
   @ObfuscatedGetter(
      intValue = 1900050677
   )
   protected static int field2251 = 0;
   @ObfuscatedName("qz")
   @ObfuscatedGetter(
      intValue = -585643221
   )
   static int field2252 = 500;
   @ObfuscatedName("qy")
   protected static volatile boolean field2253 = true;
   @ObfuscatedName("pw")
   boolean field2254;
   @ObfuscatedName("qi")
   protected static boolean field2255 = false;
   @ObfuscatedName("qr")
   protected static volatile boolean field2256 = false;
   @ObfuscatedName("qq")
   @ObfuscatedGetter(
      longValue = 182483545594188871L
   )
   static volatile long field2257 = 0L;
   @ObfuscatedName("rk")
   static volatile boolean field2258 = true;

   @ObfuscatedName("rg")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "166587775"
   )
   protected final void method3044(int var1, int var2, int var3) {
      try {
         if(field2246 != null) {
            ++field2245;
            if(field2245 >= 3) {
               this.method3060("alreadyloaded");
               return;
            }

            this.getAppletContext().showDocument(this.getDocumentBase(), "_self");
            return;
         }

         field2246 = this;
         GroundObject.field1652 = var1;
         VertexNormal.field1689 = var2;
         class151.field2271 = var3;
         class151.field2270 = this;
         if(Item.field699 == null) {
            Item.field699 = new class139();
         }

         Item.field699.method2918(this, 1);
      } catch (Exception var5) {
         RSCanvas.method2969((String)null, var5);
         this.method3060("crash");
      }

   }

   @ObfuscatedName("rn")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "4"
   )
   protected final boolean method3046() {
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
                     this.method3060("invalidhost");
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

   public void run() {
      try {
         if(null != class139.field2144) {
            String var1 = class139.field2144.toLowerCase();
            if(var1.indexOf("sun") != -1 || var1.indexOf("apple") != -1) {
               String var2 = class139.field2148;
               if(var2.equals("1.1") || var2.startsWith("1.1.") || var2.equals("1.2") || var2.startsWith("1.2.") || var2.equals("1.3") || var2.startsWith("1.3.") || var2.equals("1.4") || var2.startsWith("1.4.") || var2.equals("1.5") || var2.startsWith("1.5.") || var2.equals("1.6.0")) {
                  this.method3060("wrongjava");
                  return;
               }

               if(var2.startsWith("1.6.0_")) {
                  int var3;
                  for(var3 = 6; var3 < var2.length(); ++var3) {
                     char var5 = var2.charAt(var3);
                     boolean var4 = var5 >= 48 && var5 <= 57;
                     if(!var4) {
                        break;
                     }
                  }

                  String var14 = var2.substring(6, var3);
                  boolean var7 = false;
                  boolean var8 = false;
                  int var9 = 0;
                  int var10 = var14.length();
                  int var11 = 0;

                  boolean var6;
                  while(true) {
                     if(var11 >= var10) {
                        var6 = var8;
                        break;
                     }

                     label177: {
                        char var12 = var14.charAt(var11);
                        if(var11 == 0) {
                           if(var12 == 45) {
                              var7 = true;
                              break label177;
                           }

                           if(var12 == 43) {
                              break label177;
                           }
                        }

                        int var17;
                        if(var12 >= 48 && var12 <= 57) {
                           var17 = var12 - 48;
                        } else if(var12 >= 65 && var12 <= 90) {
                           var17 = var12 - 55;
                        } else {
                           if(var12 < 97 || var12 > 122) {
                              var6 = false;
                              break;
                           }

                           var17 = var12 - 87;
                        }

                        if(var17 >= 10) {
                           var6 = false;
                           break;
                        }

                        if(var7) {
                           var17 = -var17;
                        }

                        int var13 = var17 + 10 * var9;
                        if(var13 / 10 != var9) {
                           var6 = false;
                           break;
                        }

                        var9 = var13;
                        var8 = true;
                     }

                     ++var11;
                  }

                  if(var6 && class143.method3003(var14) < 10) {
                     this.method3060("wrongjava");
                     return;
                  }
               }

               field2247 = 5;
            }
         }

         this.setFocusCycleRoot(true);
         this.method3051();
         this.vmethod3056();
         CollisionData.field1963 = class1.method6();

         while(field2243 == 0L || class169.method3276() < field2243) {
            class92.field1615 = CollisionData.field1963.vmethod3137(field2241, field2247);

            for(int var15 = 0; var15 < class92.field1615; ++var15) {
               this.method3047();
            }

            this.method3048();
            ChatMessages.method214(Item.field699, VertexNormal.canvas);
         }
      } catch (Exception var16) {
         RSCanvas.method2969((String)null, var16);
         this.method3060("crash");
      }

      this.method3092();
   }

   @ObfuscatedName("rz")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-233904595"
   )
   void method3047() {
      long var1 = class169.method3276();
      long var3 = field2250[class26.field636];
      field2250[class26.field636] = var1;
      class26.field636 = 1 + class26.field636 & 31;
      if(var3 != 0L && var1 > var3) {
         ;
      }

      synchronized(this) {
         class107.field1854 = field2258;
      }

      this.packetHandler();
   }

   @ObfuscatedName("ro")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1639088148"
   )
   void method3048() {
      Container var1 = this.method3061();
      long var2 = class169.method3276();
      long var4 = field2249[Sequence.field1004];
      field2249[Sequence.field1004] = var2;
      Sequence.field1004 = Sequence.field1004 + 1 & 31;
      if(0L != var4 && var2 > var4) {
         int var7 = (int)(var2 - var4);
         FPS = (32000 + (var7 >> 1)) / var7;
      }

      if(++field2252 - 1 > 50) {
         field2252 -= 50;
         field2253 = true;
         VertexNormal.canvas.setSize(GroundObject.field1652, VertexNormal.field1689);
         VertexNormal.canvas.setVisible(true);
         if(var1 == class12.field188) {
            Insets var6 = class12.field188.getInsets();
            VertexNormal.canvas.setLocation(field2251 + var6.left, var6.top + field2242);
         } else {
            VertexNormal.canvas.setLocation(field2251, field2242);
         }
      }

      this.vmethod3058();
   }

   public void start() {
      if(this == field2246 && !field2244) {
         field2243 = 0L;
      }
   }

   public void stop() {
      if(this == field2246 && !field2244) {
         field2243 = class169.method3276() + 4000L;
      }
   }

   public void destroy() {
      if(field2246 == this && !field2244) {
         field2243 = class169.method3276();
         class127.method2846(5000L);
         this.method3092();
      }
   }

   public final void update(Graphics var1) {
      this.paint(var1);
   }

   public final synchronized void paint(Graphics var1) {
      if(this == field2246 && !field2244) {
         field2253 = true;
         if(class139.field2148 != null && class139.field2148.startsWith("1.5") && class169.method3276() - field2257 > 1000L) {
            Rectangle var2 = var1.getClipBounds();
            if(null == var2 || var2.width >= GroundObject.field1652 && var2.height >= VertexNormal.field1689) {
               field2256 = true;
            }
         }

      }
   }

   @ObfuscatedName("ry")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-25943"
   )
   protected final synchronized void method3051() {
      Container var1 = this.method3061();
      if(null != VertexNormal.canvas) {
         VertexNormal.canvas.removeFocusListener(this);
         var1.remove(VertexNormal.canvas);
      }

      GroundObject.field1652 = Math.max(var1.getWidth(), MessageNode.field806);
      VertexNormal.field1689 = Math.max(var1.getHeight(), class159.field2344);
      Insets var2;
      if(class12.field188 != null) {
         var2 = class12.field188.getInsets();
         GroundObject.field1652 -= var2.right + var2.left;
         VertexNormal.field1689 -= var2.top + var2.bottom;
      }

      VertexNormal.canvas = new RSCanvas(this);
      var1.add(VertexNormal.canvas);
      VertexNormal.canvas.setSize(GroundObject.field1652, VertexNormal.field1689);
      VertexNormal.canvas.setVisible(true);
      if(var1 == class12.field188) {
         var2 = class12.field188.getInsets();
         VertexNormal.canvas.setLocation(var2.left + field2251, var2.top + field2242);
      } else {
         VertexNormal.canvas.setLocation(field2251, field2242);
      }

      VertexNormal.canvas.addFocusListener(this);
      VertexNormal.canvas.requestFocus();
      field2253 = true;
      BufferProvider var3 = class18.method183(GroundObject.field1652, VertexNormal.field1689, VertexNormal.canvas);
      if(Sequence.bufferProvider != null) {
         Sequence.bufferProvider.draw(var3.image.getGraphics(), 0, 0);
      }

      Sequence.bufferProvider = var3;
      field2256 = false;
      field2257 = class169.method3276();
   }

   public final void windowClosed(WindowEvent var1) {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-958207511"
   )
   protected abstract void vmethod3052();

   public final void windowIconified(WindowEvent var1) {
   }

   public abstract void init();

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1223229248"
   )
   protected abstract void vmethod3056();

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1685336898"
   )
   protected abstract void packetHandler();

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1247559991"
   )
   protected abstract void vmethod3058();

   @ObfuscatedName("re")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "892180021"
   )
   protected void method3060(String var1) {
      if(!this.field2254) {
         this.field2254 = true;
         System.out.println("error_game_" + var1);

         try {
            this.getAppletContext().showDocument(new URL(this.getCodeBase(), "error_game_" + var1 + ".ws"), "_self");
         } catch (Exception var3) {
            ;
         }

      }
   }

   @ObfuscatedName("rv")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Container;",
      garbageValue = "-554901692"
   )
   protected Container method3061() {
      return (Container)(class12.field188 != null?class12.field188:this);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1478774694"
   )
   protected abstract void vmethod3063();

   public final void windowDeiconified(WindowEvent var1) {
   }

   @ObfuscatedName("rd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-197672691"
   )
   final synchronized void method3092() {
      if(!field2244) {
         field2244 = true;

         try {
            VertexNormal.canvas.removeFocusListener(this);
         } catch (Exception var5) {
            ;
         }

         try {
            this.vmethod3052();
         } catch (Exception var4) {
            ;
         }

         if(null != class12.field188) {
            try {
               System.exit(0);
            } catch (Throwable var3) {
               ;
            }
         }

         if(null != Item.field699) {
            try {
               Item.field699.method2937();
            } catch (Exception var2) {
               ;
            }
         }

         this.vmethod3063();
      }
   }

   public final void windowActivated(WindowEvent var1) {
   }

   public final void focusLost(FocusEvent var1) {
      field2258 = false;
   }

   public final void windowOpened(WindowEvent var1) {
   }

   public final void focusGained(FocusEvent var1) {
      field2258 = true;
      field2253 = true;
   }

   public final void windowDeactivated(WindowEvent var1) {
   }

   @ObfuscatedName("rl")
   @ObfuscatedSignature(
      signature = "(I)Ljava/awt/Dimension;",
      garbageValue = "-1985721938"
   )
   protected Dimension method3107() {
      Container var1 = this.method3061();
      int var2 = Math.max(var1.getWidth(), MessageNode.field806);
      int var3 = Math.max(var1.getHeight(), class159.field2344);
      if(class12.field188 != null) {
         Insets var4 = class12.field188.getInsets();
         var2 -= var4.right + var4.left;
         var3 -= var4.bottom + var4.top;
      }

      return new Dimension(var2, var3);
   }

   public final void windowClosing(WindowEvent var1) {
      this.destroy();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Lclass48;",
      garbageValue = "-16711936"
   )
   public static class48 method3129(int var0) {
      class48 var1 = (class48)class48.field1076.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = class169.field2712.method3305(4, var0);
         var1 = new class48();
         if(null != var2) {
            var1.method995(new Buffer(var2), var0);
         }

         var1.method1000();
         class48.field1076.put(var1, (long)var0);
         return var1;
      }
   }
}
