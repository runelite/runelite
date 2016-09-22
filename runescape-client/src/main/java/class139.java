import java.awt.EventQueue;
import java.awt.Toolkit;
import java.io.DataInputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
public class class139 implements Runnable {
   @ObfuscatedName("v")
   class149 field2160 = null;
   @ObfuscatedName("d")
   static String field2161;
   @ObfuscatedName("a")
   public static String field2162;
   @ObfuscatedName("r")
   class149 field2163 = null;
   @ObfuscatedName("z")
   Thread field2164;
   @ObfuscatedName("t")
   boolean field2165 = false;
   @ObfuscatedName("n")
   EventQueue field2166;
   @ObfuscatedName("eh")
   static SpritePixels[] field2167;
   @ObfuscatedName("qb")
   @ObfuscatedGetter(
      intValue = -1684045887
   )
   static int field2168;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/net/URL;B)Lclass149;",
      garbageValue = "-14"
   )
   public final class149 method2915(URL var1) {
      return this.method2929(4, 0, 0, var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "69373386"
   )
   final void method2916() {
      synchronized(this) {
         this.field2165 = true;
         this.notifyAll();
      }

      try {
         this.field2164.join();
      } catch (InterruptedException var3) {
         ;
      }

   }

   public final void run() {
      while(true) {
         class149 var1;
         synchronized(this) {
            while(true) {
               if(this.field2165) {
                  return;
               }

               if(this.field2160 != null) {
                  var1 = this.field2160;
                  this.field2160 = this.field2160.field2283;
                  if(this.field2160 == null) {
                     this.field2163 = null;
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
            int var5 = var1.field2281;
            if(var5 == 1) {
               var1.field2287 = new Socket(InetAddress.getByName((String)var1.field2279), var1.field2285);
            } else if(var5 == 2) {
               Thread var3 = new Thread((Runnable)var1.field2279);
               var3.setDaemon(true);
               var3.start();
               var3.setPriority(var1.field2285);
               var1.field2287 = var3;
            } else if(var5 == 4) {
               var1.field2287 = new DataInputStream(((URL)var1.field2279).openStream());
            } else if(var5 == 3) {
               String var10 = (var1.field2285 >> 24 & 255) + "." + (var1.field2285 >> 16 & 255) + "." + (var1.field2285 >> 8 & 255) + "." + (var1.field2285 & 255);
               var1.field2287 = InetAddress.getByName(var10).getHostName();
            }

            var1.field2284 = 1;
         } catch (ThreadDeath var6) {
            throw var6;
         } catch (Throwable var7) {
            var1.field2284 = 2;
         }
      }
   }

   class139() {
      field2162 = "Unknown";
      field2161 = "1.1";

      try {
         field2162 = System.getProperty("java.vendor");
         field2161 = System.getProperty("java.version");
      } catch (Exception var3) {
         ;
      }

      try {
         this.field2166 = Toolkit.getDefaultToolkit().getSystemEventQueue();
      } catch (Throwable var2) {
         ;
      }

      this.field2165 = false;
      this.field2164 = new Thread(this);
      this.field2164.setPriority(10);
      this.field2164.setDaemon(true);
      this.field2164.start();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Lclass149;",
      garbageValue = "-444278009"
   )
   public final class149 method2919(int var1) {
      return this.method2929(3, var1, 0, (Object)null);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)Lclass149;",
      garbageValue = "0"
   )
   public final class149 method2928(String var1, int var2) {
      return this.method2929(1, var2, 0, var1);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIILjava/lang/Object;I)Lclass149;",
      garbageValue = "2116126816"
   )
   final class149 method2929(int var1, int var2, int var3, Object var4) {
      class149 var5 = new class149();
      var5.field2281 = var1;
      var5.field2285 = var2;
      var5.field2279 = var4;
      synchronized(this) {
         if(this.field2163 != null) {
            this.field2163.field2283 = var5;
            this.field2163 = var5;
         } else {
            this.field2163 = this.field2160 = var5;
         }

         this.notify();
         return var5;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(CB)C",
      garbageValue = "1"
   )
   static char method2930(char var0) {
      return var0 != 181 && var0 != 402?Character.toTitleCase(var0):var0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Runnable;II)Lclass149;",
      garbageValue = "734911625"
   )
   public final class149 method2934(Runnable var1, int var2) {
      return this.method2929(2, var2, 0, var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIILclass110;LCollisionData;B)Z",
      garbageValue = "-18"
   )
   public static final boolean method2935(int var0, int var1, int var2, class110 var3, CollisionData var4) {
      int var5 = var0;
      int var6 = var1;
      byte var7 = 64;
      byte var8 = 64;
      int var9 = var0 - var7;
      int var10 = var1 - var8;
      class109.field1949[var7][var8] = 99;
      class109.field1950[var7][var8] = 0;
      byte var11 = 0;
      int var12 = 0;
      class109.field1953[var11] = var0;
      int var20 = var11 + 1;
      class109.field1954[var11] = var1;
      int[][] var13 = var4.flags;

      while(true) {
         label351:
         while(true) {
            int var14;
            int var15;
            int var16;
            int var17;
            int var18;
            int var19;
            do {
               do {
                  do {
                     label328:
                     do {
                        if(var20 == var12) {
                           class35.field800 = var5;
                           class109.field1948 = var6;
                           return false;
                        }

                        var5 = class109.field1953[var12];
                        var6 = class109.field1954[var12];
                        var12 = var12 + 1 & 4095;
                        var18 = var5 - var9;
                        var19 = var6 - var10;
                        var14 = var5 - var4.x;
                        var15 = var6 - var4.y;
                        if(var3.vmethod2408(var2, var5, var6, var4)) {
                           class35.field800 = var5;
                           class109.field1948 = var6;
                           return true;
                        }

                        var16 = class109.field1950[var18][var19] + 1;
                        if(var18 > 0 && class109.field1949[var18 - 1][var19] == 0 && (var13[var14 - 1][var15] & 19136782) == 0 && (var13[var14 - 1][var15 + var2 - 1] & 19136824) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1953[var20] = var5 - 1;
                                 class109.field1954[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1949[var18 - 1][var19] = 2;
                                 class109.field1950[var18 - 1][var19] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var17 + var15] & 19136830) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && class109.field1949[var18 + 1][var19] == 0 && (var13[var14 + var2][var15] & 19136899) == 0 && (var13[var14 + var2][var15 + var2 - 1] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1953[var20] = var5 + 1;
                                 class109.field1954[var20] = var6;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1949[var18 + 1][var19] = 8;
                                 class109.field1950[1 + var18][var19] = var16;
                                 break;
                              }

                              if((var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 > 0 && class109.field1949[var18][var19 - 1] == 0 && (var13[var14][var15 - 1] & 19136782) == 0 && (var13[var14 + var2 - 1][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1953[var20] = var5;
                                 class109.field1954[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1949[var18][var19 - 1] = 1;
                                 class109.field1950[var18][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var19 < 128 - var2 && class109.field1949[var18][1 + var19] == 0 && (var13[var14][var2 + var15] & 19136824) == 0 && (var13[var14 + var2 - 1][var15 + var2] & 19136992) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2 - 1) {
                                 class109.field1953[var20] = var5;
                                 class109.field1954[var20] = 1 + var6;
                                 var20 = 1 + var20 & 4095;
                                 class109.field1949[var18][1 + var19] = 4;
                                 class109.field1950[var18][1 + var19] = var16;
                                 break;
                              }

                              if((var13[var14 + var17][var2 + var15] & 19137016) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 > 0 && class109.field1949[var18 - 1][var19 - 1] == 0 && (var13[var14 - 1][var15 - 1] & 19136782) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class109.field1953[var20] = var5 - 1;
                                 class109.field1954[var20] = var6 - 1;
                                 var20 = 1 + var20 & 4095;
                                 class109.field1949[var18 - 1][var19 - 1] = 3;
                                 class109.field1950[var18 - 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var14 - 1][var15 - 1 + var17] & 19136830) != 0 || (var13[var17 + (var14 - 1)][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 < 128 - var2 && var19 > 0 && class109.field1949[1 + var18][var19 - 1] == 0 && (var13[var2 + var14][var15 - 1] & 19136899) == 0) {
                           var17 = 1;

                           while(true) {
                              if(var17 >= var2) {
                                 class109.field1953[var20] = var5 + 1;
                                 class109.field1954[var20] = var6 - 1;
                                 var20 = var20 + 1 & 4095;
                                 class109.field1949[1 + var18][var19 - 1] = 9;
                                 class109.field1950[var18 + 1][var19 - 1] = var16;
                                 break;
                              }

                              if((var13[var2 + var14][var17 + (var15 - 1)] & 19136995) != 0 || (var13[var14 + var17][var15 - 1] & 19136911) != 0) {
                                 break;
                              }

                              ++var17;
                           }
                        }

                        if(var18 > 0 && var19 < 128 - var2 && class109.field1949[var18 - 1][var19 + 1] == 0 && (var13[var14 - 1][var2 + var15] & 19136824) == 0) {
                           for(var17 = 1; var17 < var2; ++var17) {
                              if((var13[var14 - 1][var15 + var17] & 19136830) != 0 || (var13[var14 - 1 + var17][var15 + var2] & 19137016) != 0) {
                                 continue label328;
                              }
                           }

                           class109.field1953[var20] = var5 - 1;
                           class109.field1954[var20] = var6 + 1;
                           var20 = var20 + 1 & 4095;
                           class109.field1949[var18 - 1][1 + var19] = 6;
                           class109.field1950[var18 - 1][var19 + 1] = var16;
                        }
                     } while(var18 >= 128 - var2);
                  } while(var19 >= 128 - var2);
               } while(class109.field1949[var18 + 1][1 + var19] != 0);
            } while((var13[var2 + var14][var2 + var15] & 19136992) != 0);

            for(var17 = 1; var17 < var2; ++var17) {
               if((var13[var14 + var17][var2 + var15] & 19137016) != 0 || (var13[var14 + var2][var15 + var17] & 19136995) != 0) {
                  continue label351;
               }
            }

            class109.field1953[var20] = var5 + 1;
            class109.field1954[var20] = 1 + var6;
            var20 = var20 + 1 & 4095;
            class109.field1949[var18 + 1][var19 + 1] = 12;
            class109.field1950[var18 + 1][1 + var19] = var16;
         }
      }
   }
}
