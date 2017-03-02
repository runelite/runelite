import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cx")
public class class103 implements Runnable {
   @ObfuscatedName("l")
   static String field1660;
   @ObfuscatedName("b")
   public static String field1661;
   @ObfuscatedName("h")
   boolean field1662 = false;
   @ObfuscatedName("t")
   class102 field1663 = null;
   @ObfuscatedName("k")
   Thread field1664;
   @ObfuscatedName("i")
   class102 field1665 = null;
   @ObfuscatedName("n")
   public EventQueue field1666;

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIIIIIILRegion;LCollisionData;B)V",
      garbageValue = "101"
   )
   static final void method2016(int var0, int var1, int var2, int var3, int var4, int var5, int var6, Region var7, CollisionData var8) {
      ObjectComposition var9 = class196.getObjectDefinition(var4);
      int var10;
      int var11;
      if(var5 != 1 && var5 != 3) {
         var10 = var9.sizeX;
         var11 = var9.sizeY;
      } else {
         var10 = var9.sizeY;
         var11 = var9.sizeX;
      }

      int var12;
      int var13;
      if(var2 + var10 <= 104) {
         var12 = var2 + (var10 >> 1);
         var13 = (var10 + 1 >> 1) + var2;
      } else {
         var12 = var2;
         var13 = 1 + var2;
      }

      int var14;
      int var15;
      if(var11 + var3 <= 104) {
         var14 = var3 + (var11 >> 1);
         var15 = var3 + (1 + var11 >> 1);
      } else {
         var14 = var3;
         var15 = var3 + 1;
      }

      int[][] var16 = class10.tileHeights[var1];
      int var17 = var16[var13][var15] + var16[var12][var14] + var16[var13][var14] + var16[var12][var15] >> 2;
      int var18 = (var10 << 6) + (var2 << 7);
      int var19 = (var3 << 7) + (var11 << 6);
      int var20 = (var4 << 14) + (var3 << 7) + var2 + 1073741824;
      if(var9.field2922 == 0) {
         var20 -= Integer.MIN_VALUE;
      }

      int var21 = (var5 << 6) + var6;
      if(var9.field2943 == 1) {
         var21 += 256;
      }

      Object var22;
      if(var6 == 22) {
         if(var9.animationId == -1 && var9.impostorIds == null) {
            var22 = var9.method3706(22, var5, var16, var18, var17, var19);
         } else {
            var22 = new class49(var4, 22, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
         }

         var7.groundObjectSpawned(var0, var2, var3, var17, (Renderable)var22, var20, var21);
         if(var9.field2914 == 1) {
            var8.method2320(var2, var3);
         }

      } else if(var6 != 10 && var6 != 11) {
         if(var6 >= 12) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method3706(var6, var5, var16, var18, var17, var19);
            } else {
               var22 = new class49(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.method1766(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
            if(var9.field2914 != 0) {
               var8.method2318(var2, var3, var10, var11, var9.field2915);
            }

         } else if(var6 == 0) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method3706(0, var5, var16, var18, var17, var19);
            } else {
               var22 = new class49(var4, 0, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.method1881(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class10.field88[var5], 0, var20, var21);
            if(var9.field2914 != 0) {
               var8.method2317(var2, var3, var6, var5, var9.field2915);
            }

         } else if(var6 == 1) {
            if(var9.animationId == -1 && var9.impostorIds == null) {
               var22 = var9.method3706(1, var5, var16, var18, var17, var19);
            } else {
               var22 = new class49(var4, 1, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
            }

            var7.method1881(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class10.field96[var5], 0, var20, var21);
            if(var9.field2914 != 0) {
               var8.method2317(var2, var3, var6, var5, var9.field2915);
            }

         } else {
            Object var24;
            int var27;
            if(var6 == 2) {
               var27 = 1 + var5 & 3;
               Object var28;
               if(var9.animationId == -1 && var9.impostorIds == null) {
                  var28 = var9.method3706(2, var5 + 4, var16, var18, var17, var19);
                  var24 = var9.method3706(2, var27, var16, var18, var17, var19);
               } else {
                  var28 = new class49(var4, 2, 4 + var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  var24 = new class49(var4, 2, var27, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.method1881(var0, var2, var3, var17, (Renderable)var28, (Renderable)var24, class10.field88[var5], class10.field88[var27], var20, var21);
               if(var9.field2914 != 0) {
                  var8.method2317(var2, var3, var6, var5, var9.field2915);
               }

            } else if(var6 == 3) {
               if(var9.animationId == -1 && null == var9.impostorIds) {
                  var22 = var9.method3706(3, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class49(var4, 3, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.method1881(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class10.field96[var5], 0, var20, var21);
               if(var9.field2914 != 0) {
                  var8.method2317(var2, var3, var6, var5, var9.field2915);
               }

            } else if(var6 == 9) {
               if(var9.animationId == -1 && null == var9.impostorIds) {
                  var22 = var9.method3706(var6, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class49(var4, var6, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.method1766(var0, var2, var3, var17, 1, 1, (Renderable)var22, 0, var20, var21);
               if(var9.field2914 != 0) {
                  var8.method2318(var2, var3, var10, var11, var9.field2915);
               }

            } else if(var6 == 4) {
               if(var9.animationId == -1 && null == var9.impostorIds) {
                  var22 = var9.method3706(4, var5, var16, var18, var17, var19);
               } else {
                  var22 = new class49(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
               }

               var7.method1765(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, class10.field88[var5], 0, 0, 0, var20, var21);
            } else {
               int var23;
               if(var6 == 5) {
                  var27 = 16;
                  var23 = var7.method1825(var0, var2, var3);
                  if(var23 != 0) {
                     var27 = class196.getObjectDefinition(var23 >> 14 & 32767).field2924;
                  }

                  if(var9.animationId == -1 && null == var9.impostorIds) {
                     var24 = var9.method3706(4, var5, var16, var18, var17, var19);
                  } else {
                     var24 = new class49(var4, 4, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.method1765(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, class10.field88[var5], 0, var27 * class10.field90[var5], class10.field99[var5] * var27, var20, var21);
               } else if(var6 == 6) {
                  var27 = 8;
                  var23 = var7.method1825(var0, var2, var3);
                  if(var23 != 0) {
                     var27 = class196.getObjectDefinition(var23 >> 14 & 32767).field2924 / 2;
                  }

                  if(var9.animationId == -1 && null == var9.impostorIds) {
                     var24 = var9.method3706(4, 4 + var5, var16, var18, var17, var19);
                  } else {
                     var24 = new class49(var4, 4, 4 + var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.method1765(var0, var2, var3, var17, (Renderable)var24, (Renderable)null, 256, var5, var27 * class10.field97[var5], class10.field100[var5] * var27, var20, var21);
               } else if(var6 == 7) {
                  var23 = var5 + 2 & 3;
                  if(var9.animationId == -1 && null == var9.impostorIds) {
                     var22 = var9.method3706(4, 4 + var23, var16, var18, var17, var19);
                  } else {
                     var22 = new class49(var4, 4, 4 + var23, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.method1765(var0, var2, var3, var17, (Renderable)var22, (Renderable)null, 256, var23, 0, 0, var20, var21);
               } else if(var6 == 8) {
                  var27 = 8;
                  var23 = var7.method1825(var0, var2, var3);
                  if(var23 != 0) {
                     var27 = class196.getObjectDefinition(var23 >> 14 & 32767).field2924 / 2;
                  }

                  int var26 = var5 + 2 & 3;
                  Object var25;
                  if(var9.animationId == -1 && null == var9.impostorIds) {
                     var24 = var9.method3706(4, 4 + var5, var16, var18, var17, var19);
                     var25 = var9.method3706(4, 4 + var26, var16, var18, var17, var19);
                  } else {
                     var24 = new class49(var4, 4, var5 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                     var25 = new class49(var4, 4, var26 + 4, var1, var2, var3, var9.animationId, true, (Renderable)null);
                  }

                  var7.method1765(var0, var2, var3, var17, (Renderable)var24, (Renderable)var25, 256, var5, class10.field97[var5] * var27, class10.field100[var5] * var27, var20, var21);
               }
            }
         }
      } else {
         if(var9.animationId == -1 && null == var9.impostorIds) {
            var22 = var9.method3706(10, var5, var16, var18, var17, var19);
         } else {
            var22 = new class49(var4, 10, var5, var1, var2, var3, var9.animationId, true, (Renderable)null);
         }

         if(null != var22) {
            var7.method1766(var0, var2, var3, var17, var10, var11, (Renderable)var22, var6 == 11?256:0, var20, var21);
         }

         if(var9.field2914 != 0) {
            var8.method2318(var2, var3, var10, var11, var9.field2915);
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Lclass102;",
      garbageValue = "-1187503700"
   )
   public final class102 method2017(int var1) {
      return this.method2039(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Lclass102;",
      garbageValue = "-1942570313"
   )
   public final class102 method2020(String var1, int var2) {
      return this.method2039(1, var2, 0, var1);
   }

   class103() {
      field1661 = "Unknown";
      field1660 = "1.1";

      try {
         field1661 = System.getProperty("java.vendor");
         field1660 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field1666 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field1662 = false;
      this.field1664 = new Thread(this);
      this.field1664.setPriority(10);
      this.field1664.setDaemon(true);
      this.field1664.start();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;B)Lclass102;",
      garbageValue = "58"
   )
   public final class102 method2022(URL var1) {
      return this.method2039(4, 0, 0, var1);
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(IIIIZS)V",
      garbageValue = "128"
   )
   static final void method2025(int var0, int var1, int var2, int var3, boolean var4) {
      if(var2 < 1) {
         var2 = 1;
      }

      if(var3 < 1) {
         var3 = 1;
      }

      int var5 = var3 - 334;
      if(var5 < 0) {
         var5 = 0;
      } else if(var5 > 100) {
         var5 = 100;
      }

      int var6 = var5 * (Client.field360 - Client.field539) / 100 + Client.field539;
      int var7 = 512 * var6 * var3 / (334 * var2);
      int var8;
      int var9;
      short var15;
      if(var7 < Client.field555) {
         var15 = Client.field555;
         var6 = var2 * var15 * 334 / (512 * var3);
         if(var6 > Client.field505) {
            var6 = Client.field505;
            var8 = 512 * var3 * var6 / (334 * var15);
            var9 = (var2 - var8) / 2;
            if(var4) {
               Rasterizer2D.method4140();
               Rasterizer2D.method4099(var0, var1, var9, var3, -16777216);
               Rasterizer2D.method4099(var0 + var2 - var9, var1, var9, var3, -16777216);
            }

            var0 += var9;
            var2 -= 2 * var9;
         }
      } else if(var7 > Client.field556) {
         var15 = Client.field556;
         var6 = var2 * var15 * 334 / (512 * var3);
         if(var6 < Client.field400) {
            var6 = Client.field400;
            var8 = var2 * var15 * 334 / (512 * var6);
            var9 = (var3 - var8) / 2;
            if(var4) {
               Rasterizer2D.method4140();
               Rasterizer2D.method4099(var0, var1, var2, var9, -16777216);
               Rasterizer2D.method4099(var0, var1 + var3 - var9, var2, var9, -16777216);
            }

            var1 += var9;
            var3 -= var9 * 2;
         }
      }

      var8 = Client.field541 + (Client.field542 - Client.field541) * var5 / 100;
      Client.scale = var8 * var6 * var3 / 85504 << 1;
      if(Client.camera2 != var2 || var3 != Client.camera3) {
         int[] var14 = new int[9];

         for(int var10 = 0; var10 < 9; ++var10) {
            int var11 = 15 + 32 * var10 + 128;
            int var12 = 600 + var11 * 3;
            int var13 = class84.field1435[var11];
            var14[var10] = var13 * var12 >> 16;
         }

         Region.method1879(var14, 500, 800, var2, var3);
      }

      Client.field316 = var0;
      Client.field548 = var1;
      Client.camera2 = var2;
      Client.camera3 = var3;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "104"
   )
   final void method2029() {
      synchronized(this) {
         this.field1662 = true;
         this.notifyAll();
      }

      try {
         this.field1664.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;IB)Lclass102;",
      garbageValue = "97"
   )
   public final class102 method2031(Runnable var1, int var2) {
      return this.method2039(2, var2, 0, var1);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass102;",
      garbageValue = "1250637109"
   )
   final class102 method2039(int var1, int var2, int var3, Object var4) {
      class102 var5 = new class102();
      var5.field1653 = var1;
      var5.field1657 = var2;
      var5.field1651 = var4;
      synchronized(this) {
         if(this.field1663 != null) {
            this.field1663.field1654 = var5;
            this.field1663 = var5;
         } else {
            this.field1663 = this.field1665 = var5;
         }

         this.notify();
         return var5;
      }
   }

   public final void run() {
      while(true) {
         class102 var1;
         synchronized(this) {
            while(true) {
               if(this.field1662) {
                  return;
               }

               if(null != this.field1665) {
                  var1 = this.field1665;
                  this.field1665 = this.field1665.field1654;
                  if(null == this.field1665) {
                     this.field1663 = null;
                  }
                  break;
               }

               try {
                  this.wait();
               } catch (InterruptedException var8) {
                  ;
               }
            }
         }

         try {
            int var5 = var1.field1653;
            if(var5 == 1) {
               var1.field1659 = new Socket(InetAddress.getByName((String)var1.field1651), var1.field1657);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field1651);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field1657);
               var1.field1659 = var3;
            } else if(var5 == 4) {
               var1.field1659 = new DataInputStream(((URL)var1.field1651).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field1657 >> 24 & 255) + "." + (var1.field1657 >> 16 & 255) + "." + (var1.field1657 >> 8 & 255) + "." + (var1.field1657 & 255);
               var1.field1659 = InetAddress.getByName(var10).getHostName();
            }

            var1.field1655 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field1655 = 2;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ZZI)I",
      garbageValue = "-291448809"
   )
   public static int method2040(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class185.field2747 + class185.field2755;
      return var3;
   }
}
