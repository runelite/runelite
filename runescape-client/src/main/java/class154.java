import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import javax.imageio.ImageIO;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ev")
public class class154 implements Runnable {
   @ObfuscatedName("v")
   boolean field2212;
   @ObfuscatedName("h")
   public static String field2213;
   @ObfuscatedName("u")
   class153 field2214;
   @ObfuscatedName("i")
   public static String field2215;
   @ObfuscatedName("pr")
   static class116 field2216;
   @ObfuscatedName("q")
   class153 field2217;
   @ObfuscatedName("g")
   Thread field2219;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass153;",
      garbageValue = "578731113"
   )
   final class153 method2966(int var1, int var2, int var3, Object var4) {
      class153 var5 = new class153();
      var5.field2208 = var1;
      var5.field2205 = var2;
      var5.field2210 = var4;
      synchronized(this) {
         if(this.field2217 != null) {
            this.field2217.field2207 = var5;
            this.field2217 = var5;
         } else {
            this.field2217 = this.field2214 = var5;
         }

         this.notify();
         return var5;
      }
   }

   public final void run() {
      while(true) {
         class153 var1;
         synchronized(this) {
            while(true) {
               if(this.field2212) {
                  return;
               }

               if(this.field2214 != null) {
                  var1 = this.field2214;
                  this.field2214 = this.field2214.field2207;
                  if(this.field2214 == null) {
                     this.field2217 = null;
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
            int var5 = var1.field2208;
            if(var5 == 1) {
               var1.field2211 = new Socket(InetAddress.getByName((String)var1.field2210), var1.field2205);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2210);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2205);
               var1.field2211 = var3;
            } else if(var5 == 4) {
               var1.field2211 = new DataInputStream(((URL)var1.field2210).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2205 >> 24 & 255) + "." + (var1.field2205 >> 16 & 255) + "." + (var1.field2205 >> 8 & 255) + "." + (var1.field2205 & 255);
               var1.field2211 = InetAddress.getByName(var10).getHostName();
            }

            var1.field2209 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field2209 = 2;
         }
      }
   }

   public class154() {
      this.field2214 = null;
      this.field2217 = null;
      this.field2212 = false;
      field2215 = "Unknown";
      field2213 = "1.6";

      try {
         field2215 = System.getProperty("java.vendor");
         field2213 = System.getProperty("java.version");
      } catch (Exception var2) {
         ;
      }

      this.field2212 = false;
      this.field2219 = new Thread(this);
      this.field2219.setPriority(10);
      this.field2219.setDaemon(true);
      this.field2219.start();
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)Lclass153;",
      garbageValue = "1"
   )
   public final class153 method2968(String var1, int var2) {
      return this.method2966(1, var2, 0, var1);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;IB)Lclass153;",
      garbageValue = "79"
   )
   public final class153 method2969(Runnable var1, int var2) {
      return this.method2966(2, var2, 0, var1);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lclass153;",
      garbageValue = "978649259"
   )
   public final class153 method2970(int var1) {
      return this.method2966(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;I)Lclass153;",
      garbageValue = "-1131716705"
   )
   public final class153 method2971(URL var1) {
      return this.method2966(4, 0, 0, var1);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BS)LSpritePixels;",
      garbageValue = "11926"
   )
   public static final SpritePixels method2980(byte[] var0) {
      BufferedImage var1 = null;

      try {
         var1 = ImageIO.read(new ByteArrayInputStream(var0));
         int var2 = var1.getWidth();
         int var3 = var1.getHeight();
         int[] var4 = new int[var3 * var2];
         PixelGrabber var5 = new PixelGrabber(var1, 0, 0, var2, var3, var4, 0, var2);
         var5.grabPixels();
         return new SpritePixels(var4, var2, var3);
      } catch (IOException var7) {
         ;
      } catch (InterruptedException var8) {
         ;
      }

      return new SpritePixels(0, 0);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "-237819301"
   )
   public static char method2984(char var0) {
      return (char)(var0 == 198?'E':(var0 == 230?'e':(var0 == 223?'s':(var0 == 338?'E':(var0 == 339?'e':'\u0000')))));
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;I)V",
      garbageValue = "1371309110"
   )
   public static void method2989(IndexDataBase var0) {
      class241.field3273 = var0;
      class168.field2316 = class241.field3273.method4184(16);
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1951911621"
   )
   public final void method2990() {
      synchronized(this) {
         this.field2212 = true;
         this.notifyAll();
      }

      try {
         this.field2219.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "112"
   )
   public static void method2991() {
      CombatInfo2.field3352.reset();
      CombatInfo2.spriteCache.reset();
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(IIIIIIII)V",
      garbageValue = "-688952526"
   )
   static final void method2992(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if(var2 >= 1 && var3 >= 1 && var2 <= 102 && var3 <= 102) {
         if(Client.field895 && Sequence.plane != var0) {
            return;
         }

         int var7 = 0;
         boolean var8 = true;
         boolean var9 = false;
         boolean var10 = false;
         if(var1 == 0) {
            var7 = class46.region.method2733(var0, var2, var3);
         }

         if(var1 == 1) {
            var7 = class46.region.method2734(var0, var2, var3);
         }

         if(var1 == 2) {
            var7 = class46.region.method2821(var0, var2, var3);
         }

         if(var1 == 3) {
            var7 = class46.region.method2736(var0, var2, var3);
         }

         int var11;
         if(var7 != 0) {
            var11 = class46.region.method2896(var0, var2, var3, var7);
            int var34 = var7 >> 14 & 32767;
            int var35 = var11 & 31;
            int var36 = var11 >> 6 & 3;
            ObjectComposition var12;
            if(var1 == 0) {
               class46.region.method2724(var0, var2, var3);
               var12 = class43.getObjectDefinition(var34);
               if(var12.field3446 != 0) {
                  Client.collisionMaps[var0].method3078(var2, var3, var35, var36, var12.field3447);
               }
            }

            if(var1 == 1) {
               class46.region.method2740(var0, var2, var3);
            }

            if(var1 == 2) {
               class46.region.method2800(var0, var2, var3);
               var12 = class43.getObjectDefinition(var34);
               if(var2 + var12.sizeX > 103 || var3 + var12.sizeX > 103 || var2 + var12.sizeY > 103 || var12.sizeY + var3 > 103) {
                  return;
               }

               if(var12.field3446 != 0) {
                  Client.collisionMaps[var0].method3088(var2, var3, var12.sizeX, var12.sizeY, var36, var12.field3447);
               }
            }

            if(var1 == 3) {
               class46.region.method2727(var0, var2, var3);
               var12 = class43.getObjectDefinition(var34);
               if(var12.field3446 == 1) {
                  Client.collisionMaps[var0].method3079(var2, var3);
               }
            }
         }

         if(var4 >= 0) {
            var11 = var0;
            if(var0 < 3 && (class61.tileSettings[1][var2][var3] & 2) == 2) {
               var11 = var0 + 1;
            }

            Region var37 = class46.region;
            CollisionData var13 = Client.collisionMaps[var0];
            ObjectComposition var14 = class43.getObjectDefinition(var4);
            int var15;
            int var16;
            if(var5 != 1 && var5 != 3) {
               var15 = var14.sizeX;
               var16 = var14.sizeY;
            } else {
               var15 = var14.sizeY;
               var16 = var14.sizeX;
            }

            int var17;
            int var18;
            if(var15 + var2 <= 104) {
               var17 = (var15 >> 1) + var2;
               var18 = var2 + (var15 + 1 >> 1);
            } else {
               var17 = var2;
               var18 = var2 + 1;
            }

            int var19;
            int var20;
            if(var16 + var3 <= 104) {
               var19 = (var16 >> 1) + var3;
               var20 = var3 + (var16 + 1 >> 1);
            } else {
               var19 = var3;
               var20 = var3 + 1;
            }

            int[][] var21 = class61.tileHeights[var11];
            int var22 = var21[var18][var20] + var21[var18][var19] + var21[var17][var19] + var21[var17][var20] >> 2;
            int var23 = (var15 << 6) + (var2 << 7);
            int var24 = (var16 << 6) + (var3 << 7);
            int var25 = var2 + (var3 << 7) + (var4 << 14) + 1073741824;
            if(var14.field3456 == 0) {
               var25 -= Integer.MIN_VALUE;
            }

            int var26 = (var5 << 6) + var6;
            if(var14.field3443 == 1) {
               var26 += 256;
            }

            Object var27;
            if(var6 == 22) {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var27 = var14.method4585(22, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class100(var4, 22, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               var37.groundObjectSpawned(var0, var2, var3, var22, (Renderable)var27, var25, var26);
               if(var14.field3446 == 1) {
                  var13.method3072(var2, var3);
               }
            } else if(var6 != 10 && var6 != 11) {
               if(var6 >= 12) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method4585(var6, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class100(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method2787(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                  if(var14.field3446 != 0) {
                     var13.method3074(var2, var3, var15, var16, var14.field3447);
                  }
               } else if(var6 == 0) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method4585(0, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class100(var4, 0, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method2717(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field755[var5], 0, var25, var26);
                  if(var14.field3446 != 0) {
                     var13.method3100(var2, var3, var6, var5, var14.field3447);
                  }
               } else if(var6 == 1) {
                  if(var14.animationId == -1 && var14.impostorIds == null) {
                     var27 = var14.method4585(1, var5, var21, var23, var22, var24);
                  } else {
                     var27 = new class100(var4, 1, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                  }

                  var37.method2717(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field750[var5], 0, var25, var26);
                  if(var14.field3446 != 0) {
                     var13.method3100(var2, var3, var6, var5, var14.field3447);
                  }
               } else {
                  Object var29;
                  int var32;
                  if(var6 == 2) {
                     var32 = var5 + 1 & 3;
                     Object var28;
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var28 = var14.method4585(2, var5 + 4, var21, var23, var22, var24);
                        var29 = var14.method4585(2, var32, var21, var23, var22, var24);
                     } else {
                        var28 = new class100(var4, 2, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        var29 = new class100(var4, 2, var32, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method2717(var0, var2, var3, var22, (Renderable)var28, (Renderable)var29, class61.field755[var5], class61.field755[var32], var25, var26);
                     if(var14.field3446 != 0) {
                        var13.method3100(var2, var3, var6, var5, var14.field3447);
                     }
                  } else if(var6 == 3) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method4585(3, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class100(var4, 3, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method2717(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field750[var5], 0, var25, var26);
                     if(var14.field3446 != 0) {
                        var13.method3100(var2, var3, var6, var5, var14.field3447);
                     }
                  } else if(var6 == 9) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method4585(var6, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class100(var4, var6, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method2787(var0, var2, var3, var22, 1, 1, (Renderable)var27, 0, var25, var26);
                     if(var14.field3446 != 0) {
                        var13.method3074(var2, var3, var15, var16, var14.field3447);
                     }
                  } else if(var6 == 4) {
                     if(var14.animationId == -1 && var14.impostorIds == null) {
                        var27 = var14.method4585(4, var5, var21, var23, var22, var24);
                     } else {
                        var27 = new class100(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                     }

                     var37.method2777(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, class61.field755[var5], 0, 0, 0, var25, var26);
                  } else {
                     int var33;
                     if(var6 == 5) {
                        var32 = 16;
                        var33 = var37.method2733(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = class43.getObjectDefinition(var33 >> 14 & 32767).field3453;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method4585(4, var5, var21, var23, var22, var24);
                        } else {
                           var29 = new class100(var4, 4, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method2777(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, class61.field755[var5], 0, class61.field751[var5] * var32, var32 * class61.field757[var5], var25, var26);
                     } else if(var6 == 6) {
                        var32 = 8;
                        var33 = var37.method2733(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = class43.getObjectDefinition(var33 >> 14 & 32767).field3453 / 2;
                        }

                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method4585(4, var5 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class100(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method2777(var0, var2, var3, var22, (Renderable)var29, (Renderable)null, 256, var5, var32 * class61.field753[var5], class61.field742[var5] * var32, var25, var26);
                     } else if(var6 == 7) {
                        var33 = var5 + 2 & 3;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var27 = var14.method4585(4, var33 + 4, var21, var23, var22, var24);
                        } else {
                           var27 = new class100(var4, 4, var33 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method2777(var0, var2, var3, var22, (Renderable)var27, (Renderable)null, 256, var33, 0, 0, var25, var26);
                     } else if(var6 == 8) {
                        var32 = 8;
                        var33 = var37.method2733(var0, var2, var3);
                        if(var33 != 0) {
                           var32 = class43.getObjectDefinition(var33 >> 14 & 32767).field3453 / 2;
                        }

                        int var31 = var5 + 2 & 3;
                        Object var30;
                        if(var14.animationId == -1 && var14.impostorIds == null) {
                           var29 = var14.method4585(4, var5 + 4, var21, var23, var22, var24);
                           var30 = var14.method4585(4, var31 + 4, var21, var23, var22, var24);
                        } else {
                           var29 = new class100(var4, 4, var5 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                           var30 = new class100(var4, 4, var31 + 4, var11, var2, var3, var14.animationId, true, (Renderable)null);
                        }

                        var37.method2777(var0, var2, var3, var22, (Renderable)var29, (Renderable)var30, 256, var5, class61.field753[var5] * var32, var32 * class61.field742[var5], var25, var26);
                     }
                  }
               }
            } else {
               if(var14.animationId == -1 && var14.impostorIds == null) {
                  var27 = var14.method4585(10, var5, var21, var23, var22, var24);
               } else {
                  var27 = new class100(var4, 10, var5, var11, var2, var3, var14.animationId, true, (Renderable)null);
               }

               if(var27 != null) {
                  var37.method2787(var0, var2, var3, var22, var15, var16, (Renderable)var27, var6 == 11?256:0, var25, var26);
               }

               if(var14.field3446 != 0) {
                  var13.method3074(var2, var3, var15, var16, var14.field3447);
               }
            }
         }
      }

   }
}
