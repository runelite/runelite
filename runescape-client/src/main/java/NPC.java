import java.applet.Applet;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("av")
@Implements("NPC")
public final class NPC extends Actor {
   @ObfuscatedName("k")
   static byte[][][] field763;
   @ObfuscatedName("i")
   @Export("composition")
   NPCComposition composition;

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass164;B)V",
      garbageValue = "-73"
   )
   static final void method675(int var0, int var1, int var2, int var3, SpritePixels var4, class164 var5) {
      if(null != var4) {
         int var6 = Client.mapScale + Client.mapAngle & 2047;
         int var7 = var2 * var2 + var3 * var3;
         if(var7 <= 6400) {
            int var8 = class84.field1453[var6];
            int var9 = class84.field1454[var6];
            var8 = var8 * 256 / (Client.mapScaleDelta + 256);
            var9 = 256 * var9 / (256 + Client.mapScaleDelta);
            int var10 = var3 * var8 + var2 * var9 >> 16;
            int var11 = var9 * var3 - var2 * var8 >> 16;
            if(var7 > 2500) {
               var4.method4022(var10 + var5.field2159 / 2 - var4.field3210 / 2, var5.field2167 / 2 - var11 - var4.field3208 / 2, var0, var1, var5.field2159, var5.field2167, var5.field2161, var5.field2158);
            } else {
               var4.method4032(var10 + var0 + var5.field2159 / 2 - var4.field3210 / 2, var5.field2167 / 2 + var1 - var11 - var4.field3208 / 2);
            }

         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "7"
   )
   protected final Model getModel() {
      if(null == this.composition) {
         return null;
      } else {
         Sequence var1 = super.animation != -1 && super.actionAnimationDisable == 0?GameEngine.getAnimation(super.animation):null;
         Sequence var2 = super.poseAnimation == -1 || super.poseAnimation == super.idlePoseAnimation && var1 != null?null:GameEngine.getAnimation(super.poseAnimation);
         Model var3 = this.composition.method3634(var1, super.actionFrame, var2, super.poseFrame);
         if(null == var3) {
            return null;
         } else {
            var3.method1546();
            super.field601 = var3.modelHeight;
            if(super.graphic != -1 && super.field636 != -1) {
               Model var4 = Ignore.method193(super.graphic).method3414(super.field636);
               if(var4 != null) {
                  var4.method1554(0, -super.field639, 0);
                  Model[] var5 = new Model[]{var3, var4};
                  var3 = new Model(var5, 2);
               }
            }

            if(this.composition.field3012 == 1) {
               var3.field1381 = true;
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIZI)V",
      garbageValue = "-1393202761"
   )
   final void method677(int var1, int var2, boolean var3) {
      if(super.animation != -1 && GameEngine.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(!var3) {
         int var4 = var1 - super.pathX[0];
         int var5 = var2 - super.pathY[0];
         if(var4 >= -8 && var4 <= 8 && var5 >= -8 && var5 <= 8) {
            if(super.field652 < 9) {
               ++super.field652;
            }

            for(int var6 = super.field652; var6 > 0; --var6) {
               super.pathX[var6] = super.pathX[var6 - 1];
               super.pathY[var6] = super.pathY[var6 - 1];
               super.field655[var6] = super.field655[var6 - 1];
            }

            super.pathX[0] = var1;
            super.pathY[0] = var2;
            super.field655[0] = 1;
            return;
         }
      }

      super.field652 = 0;
      super.field607 = 0;
      super.field603 = 0;
      super.pathX[0] = var1;
      super.pathY[0] = var2;
      super.x = 128 * super.pathX[0] + super.field640 * 64;
      super.y = super.pathY[0] * 128 + super.field640 * 64;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1060306260"
   )
   final boolean vmethod679() {
      return this.composition != null;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IBI)V",
      garbageValue = "-581929155"
   )
   final void method686(int var1, byte var2) {
      int var3 = super.pathX[0];
      int var4 = super.pathY[0];
      if(var1 == 0) {
         --var3;
         ++var4;
      }

      if(var1 == 1) {
         ++var4;
      }

      if(var1 == 2) {
         ++var3;
         ++var4;
      }

      if(var1 == 3) {
         --var3;
      }

      if(var1 == 4) {
         ++var3;
      }

      if(var1 == 5) {
         --var3;
         --var4;
      }

      if(var1 == 6) {
         --var4;
      }

      if(var1 == 7) {
         ++var3;
         --var4;
      }

      if(super.animation != -1 && GameEngine.getAnimation(super.animation).priority == 1) {
         super.animation = -1;
      }

      if(super.field652 < 9) {
         ++super.field652;
      }

      for(int var5 = super.field652; var5 > 0; --var5) {
         super.pathX[var5] = super.pathX[var5 - 1];
         super.pathY[var5] = super.pathY[var5 - 1];
         super.field655[var5] = super.field655[var5 - 1];
      }

      super.pathX[0] = var3;
      super.pathY[0] = var4;
      super.field655[0] = var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;ZI)LFileOnDisk;",
      garbageValue = "-1391269895"
   )
   public static FileOnDisk method688(String var0, String var1, boolean var2) {
      File var3 = new File(class104.field1670, "preferences" + var0 + ".dat");
      if(var3.exists()) {
         try {
            FileOnDisk var10 = new FileOnDisk(var3, "rw", 10000L);
            return var10;
         } catch (IOException var9) {
            ;
         }
      }

      String var4 = "";
      if(class143.field2006 == 33) {
         var4 = "_rc";
      } else if(class143.field2006 == 34) {
         var4 = "_wip";
      }

      File var5 = new File(class39.field805, "jagex_" + var1 + "_preferences" + var0 + var4 + ".dat");
      FileOnDisk var6;
      if(!var2 && var5.exists()) {
         try {
            var6 = new FileOnDisk(var5, "rw", 10000L);
            return var6;
         } catch (IOException var8) {
            ;
         }
      }

      try {
         var6 = new FileOnDisk(var3, "rw", 10000L);
         return var6;
      } catch (IOException var7) {
         throw new RuntimeException();
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ILjava/lang/String;I)Z",
      garbageValue = "-2087564422"
   )
   public static boolean method689(String var0, int var1, String var2) {
      if(var1 == 0) {
         try {
            if(!class114.field1784.startsWith("win")) {
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
            Applet var7 = class114.field1788;
            Object[] var5 = new Object[]{(new URL(class114.field1788.getCodeBase(), var0)).toString()};
            Object var13 = JSObject.getWindow(var7).call(var2, var5);
            return var13 != null;
         } catch (Throwable var9) {
            return false;
         }
      } else if(var1 == 2) {
         try {
            class114.field1788.getAppletContext().showDocument(new URL(class114.field1788.getCodeBase(), var0), "_blank");
            return true;
         } catch (Exception var10) {
            return false;
         }
      } else if(var1 == 3) {
         try {
            Applet var3 = class114.field1788;
            JSObject.getWindow(var3).call("loggedout", (Object[])null);
         } catch (Throwable var12) {
            ;
         }

         try {
            class114.field1788.getAppletContext().showDocument(new URL(class114.field1788.getCodeBase(), var0), "_top");
            return true;
         } catch (Exception var11) {
            return false;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILclass182;Ljava/lang/String;Ljava/lang/String;IZI)V",
      garbageValue = "-888833646"
   )
   public static void method690(int var0, class182 var1, String var2, String var3, int var4, boolean var5) {
      int var6 = var1.method3225(var2);
      int var7 = var1.method3226(var6, var3);
      class138.field1914 = 1;
      class145.field2014 = var1;
      class30.field693 = var6;
      class138.field1915 = var7;
      ItemLayer.field1220 = var4;
      ItemLayer.field1221 = var5;
      class138.field1916 = var0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIIZIZB)V",
      garbageValue = "1"
   )
   static void method691(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = class107.worldList[var6];
         class107.worldList[var6] = class107.worldList[var1];
         class107.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = class107.worldList[var9];
            int var12 = class94.method1891(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = class94.method1891(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = class107.worldList[var9];
               class107.worldList[var9] = class107.worldList[var7];
               class107.worldList[var7++] = var14;
            }
         }

         class107.worldList[var1] = class107.worldList[var7];
         class107.worldList[var7] = var8;
         method691(var0, var7 - 1, var2, var3, var4, var5);
         method691(var7 + 1, var1, var2, var3, var4, var5);
      }

   }
}
