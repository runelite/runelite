import java.applet.Applet;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("bz")
@Implements("MouseRecorder")
public class MouseRecorder implements Runnable {
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lkp;"
   )
   public static Font field793;
   @ObfuscatedName("gm")
   @ObfuscatedGetter(
      intValue = 1730295719
   )
   static int field789;
   @ObfuscatedName("s")
   @Export("isRunning")
   boolean isRunning;
   @ObfuscatedName("g")
   @Export("lock")
   Object lock;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1781897163
   )
   @Export("index")
   int index;
   @ObfuscatedName("h")
   @Export("xs")
   int[] xs;
   @ObfuscatedName("i")
   @Export("ys")
   int[] ys;

   MouseRecorder() {
      this.isRunning = true;
      this.lock = new Object();
      this.index = 0;
      this.xs = new int[500];
      this.ys = new int[500];
   }

   public void run() {
      for(; this.isRunning; Tile.method2712(50L)) {
         Object var1 = this.lock;
         synchronized(this.lock) {
            if(this.index < 500) {
               this.xs[this.index] = MouseInput.mouseLastX;
               this.ys[this.index] = MouseInput.mouseLastY;
               ++this.index;
            }
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "-2045806084"
   )
   public static boolean method1078(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class56.field638.startsWith("win")) {
               throw new Exception();
            } else if(!var0.startsWith("http://") && !var0.startsWith("https://")) {
               throw new Exception();
            } else {
               String var14 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789?&=,.%+-_#:/*";

               for(int var4 = 0; var4 < var0.length(); ++var4) {
                  if(var14.indexOf(var0.charAt(var4)) == -1) {
                     throw new Exception();
                  }
               }

               Runtime.getRuntime().exec("cmd /c start \"j\" \"" + var0 + "\"");
               return true;
            }
         } catch (Throwable var8) {
            return false;
         }
      } else if(var1 == 1) {
         try {
            Applet var7 = class56.field639;
            Object[] var5 = new Object[]{(new URL(class56.field639.getCodeBase(), var0)).toString()};
            Object var13 = JSObject.getWindow(var7).call(var2, var5);
            return var13 != null;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class56.field639.getAppletContext().showDocument(new URL(class56.field639.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            Applet var3 = class56.field639;
            JSObject.getWindow(var3).call("loggedout", (Object[])null);
         } catch (Throwable var12) {
            ;
         }

         try {
            class56.field639.getAppletContext().showDocument(new URL(class56.field639.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgy;J)V"
   )
   static void method1075(Buffer var0, long var1) {
      var1 /= 10L;
      if(var1 < 0L) {
         var1 = 0L;
      } else if(var1 > 65535L) {
         var1 = 65535L;
      }

      var0.putShort((int)var1);
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "-79"
   )
   static final void method1077(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.lowMemory && var0 != class60.plane) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = TotalQuantityComparator.region.method2930(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = TotalQuantityComparator.region.method2931(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = TotalQuantityComparator.region.method2932(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = TotalQuantityComparator.region.method2933(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = TotalQuantityComparator.region.getObjectFlags(var0, var2, var3, var7);
            int var13 = var7 >> 14 & 32767;
            int var14 = var11 & 31;
            int var15 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               TotalQuantityComparator.region.removeBoundaryObject(var0, var2, var3);
               var12 = class219.getObjectDefinition(var13);
               if(var12.clipType != 0) {
                  Client.collisionMaps[var0].removeWall(var2, var3, var14, var15, var12.blocksProjectile);
               }
            }

            if(var1 == 1) {
               TotalQuantityComparator.region.removeWallDecoration(var0, var2, var3);
            }

            if(var1 == 2) {
               TotalQuantityComparator.region.method2939(var0, var2, var3);
               var12 = class219.getObjectDefinition(var13);
               if(var2 + var12.width > 103 || var3 + var12.width > 103 || var2 + var12.length > 103 || var3 + var12.length > 103) {
                  return;
               }

               if(var12.clipType != 0) {
                  Client.collisionMaps[var0].removeObject(var2, var3, var12.width, var12.length, var15, var12.blocksProjectile);
               }
            }

            if(var1 == 3) {
               TotalQuantityComparator.region.removeFloorDecoration(var0, var2, var3);
               var12 = class219.getObjectDefinition(var13);
               if(var12.clipType == 1) {
                  Client.collisionMaps[var0].method3354(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class62.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            class39.method527(var0, var11, var2, var3, var4, var5, var6, TotalQuantityComparator.region, Client.collisionMaps[var0]);
         }
      }

   }
}
