import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dm")
public final class class110 implements Runnable {
   @ObfuscatedName("k")
   byte[] field1745;
   @ObfuscatedName("c")
   OutputStream field1746;
   @ObfuscatedName("f")
   Socket field1747;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 177284127
   )
   int field1748 = 0;
   @ObfuscatedName("a")
   class103 field1749;
   @ObfuscatedName("g")
   class102 field1750;
   @ObfuscatedName("s")
   InputStream field1751;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1323263229
   )
   int field1753 = 0;
   @ObfuscatedName("x")
   boolean field1754 = false;
   @ObfuscatedName("ps")
   static class116 field1755;
   @ObfuscatedName("h")
   boolean field1757 = false;

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1482483224"
   )
   public int method2004() throws IOException {
      return this.field1757?0:this.field1751.read();
   }

   protected void finalize() {
      this.method2006();
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "([BIII)V",
      garbageValue = "2106170616"
   )
   public void method2005(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1757) {
         while(var3 > 0) {
            int var4 = this.field1751.read(var1, var2, var3);
            if(var4 <= 0) {
               throw new EOFException();
            }

            var2 += var4;
            var3 -= var4;
         }

      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-16399075"
   )
   public void method2006() {
      if(!this.field1757) {
         synchronized(this) {
            this.field1757 = true;
            this.notifyAll();
         }

         if(null != this.field1750) {
            while(this.field1750.field1663 == 0) {
               Projectile.method757(1L);
            }

            if(this.field1750.field1663 == 1) {
               try {
                  ((Thread)this.field1750.field1666).join();
               } catch (InterruptedException var3) {
                  ;
               }
            }
         }

         this.field1750 = null;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-688161837"
   )
   public int method2007() throws IOException {
      return this.field1757?0:this.field1751.available();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "([BIIB)V",
      garbageValue = "65"
   )
   public void method2015(byte[] var1, int var2, int var3) throws IOException {
      if(!this.field1757) {
         if(this.field1754) {
            this.field1754 = false;
            throw new IOException();
         } else {
            if(null == this.field1745) {
               this.field1745 = new byte[5000];
            }

            synchronized(this) {
               for(int var5 = 0; var5 < var3; ++var5) {
                  this.field1745[this.field1753] = var1[var5 + var2];
                  this.field1753 = (1 + this.field1753) % 5000;
                  if(this.field1753 == (4900 + this.field1748) % 5000) {
                     throw new IOException();
                  }
               }

               if(this.field1750 == null) {
                  this.field1750 = this.field1749.method1912(this, 3);
               }

               this.notifyAll();
            }
         }
      }
   }

   public class110(Socket var1, class103 var2) throws IOException {
      this.field1749 = var2;
      this.field1747 = var1;
      this.field1747.setSoTimeout(30000);
      this.field1747.setTcpNoDelay(true);
      this.field1747.setReceiveBufferSize(16384);
      this.field1747.setSendBufferSize(16384);
      this.field1751 = this.field1747.getInputStream();
      this.field1746 = this.field1747.getOutputStream();
   }

   public void run() {
      try {
         while(true) {
            label84: {
               int var1;
               int var2;
               synchronized(this) {
                  if(this.field1753 == this.field1748) {
                     if(this.field1757) {
                        break label84;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var10) {
                        ;
                     }
                  }

                  var2 = this.field1748;
                  if(this.field1753 >= this.field1748) {
                     var1 = this.field1753 - this.field1748;
                  } else {
                     var1 = 5000 - this.field1748;
                  }
               }

               if(var1 <= 0) {
                  continue;
               }

               try {
                  this.field1746.write(this.field1745, var2, var1);
               } catch (IOException var9) {
                  this.field1754 = true;
               }

               this.field1748 = (this.field1748 + var1) % 5000;

               try {
                  if(this.field1748 == this.field1753) {
                     this.field1746.flush();
                  }
               } catch (IOException var8) {
                  this.field1754 = true;
               }
               continue;
            }

            try {
               if(this.field1751 != null) {
                  this.field1751.close();
               }

               if(this.field1746 != null) {
                  this.field1746.close();
               }

               if(this.field1747 != null) {
                  this.field1747.close();
               }
            } catch (IOException var7) {
               ;
            }

            this.field1745 = null;
            break;
         }
      } catch (Exception var12) {
         NPC.method695((String)null, var12);
      }

   }

   @ObfuscatedName("bi")
   @ObfuscatedSignature(
      signature = "(IIIIIB)V",
      garbageValue = "37"
   )
   static final void method2025(int var0, int var1, int var2, int var3, int var4) {
      int var5 = class0.region.method1684(var0, var1, var2);
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      if(var5 != 0) {
         var6 = class0.region.method1730(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var3;
         if(var5 > 0) {
            var9 = var4;
         }

         int[] var10 = class63.field1094.image;
         var11 = 24624 + 4 * var1 + 2048 * (103 - var2);
         var12 = var5 >> 14 & 32767;
         ObjectComposition var13 = class143.getObjectDefinition(var12);
         if(var13.mapSceneId != -1) {
            ModIcon var14 = class152.field2080[var13.mapSceneId];
            if(null != var14) {
               int var15 = (var13.sizeX * 4 - var14.originalWidth) / 2;
               int var16 = (var13.sizeY * 4 - var14.height) / 2;
               var14.method3919(var1 * 4 + 48 + var15, var16 + (104 - var2 - var13.sizeY) * 4 + 48);
            }
         } else {
            if(var8 == 0 || var8 == 2) {
               if(var7 == 0) {
                  var10[var11] = var9;
                  var10[512 + var11] = var9;
                  var10[1024 + var11] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 1) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[var11 + 2] = var9;
                  var10[3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 3] = var9;
                  var10[3 + var11 + 512] = var9;
                  var10[1024 + var11 + 3] = var9;
                  var10[var11 + 3 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
                  var10[1536 + var11 + 1] = var9;
                  var10[2 + var11 + 1536] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }

            if(var8 == 3) {
               if(var7 == 0) {
                  var10[var11] = var9;
               } else if(var7 == 1) {
                  var10[3 + var11] = var9;
               } else if(var7 == 2) {
                  var10[3 + var11 + 1536] = var9;
               } else if(var7 == 3) {
                  var10[1536 + var11] = var9;
               }
            }

            if(var8 == 2) {
               if(var7 == 3) {
                  var10[var11] = var9;
                  var10[var11 + 512] = var9;
                  var10[var11 + 1024] = var9;
                  var10[var11 + 1536] = var9;
               } else if(var7 == 0) {
                  var10[var11] = var9;
                  var10[1 + var11] = var9;
                  var10[var11 + 2] = var9;
                  var10[var11 + 3] = var9;
               } else if(var7 == 1) {
                  var10[var11 + 3] = var9;
                  var10[512 + var11 + 3] = var9;
                  var10[var11 + 3 + 1024] = var9;
                  var10[3 + var11 + 1536] = var9;
               } else if(var7 == 2) {
                  var10[var11 + 1536] = var9;
                  var10[1 + var11 + 1536] = var9;
                  var10[1536 + var11 + 2] = var9;
                  var10[var11 + 1536 + 3] = var9;
               }
            }
         }
      }

      var5 = class0.region.method1686(var0, var1, var2);
      if(var5 != 0) {
         var6 = class0.region.method1730(var0, var1, var2, var5);
         var7 = var6 >> 6 & 3;
         var8 = var6 & 31;
         var9 = var5 >> 14 & 32767;
         ObjectComposition var23 = class143.getObjectDefinition(var9);
         int var19;
         if(var23.mapSceneId != -1) {
            ModIcon var20 = class152.field2080[var23.mapSceneId];
            if(null != var20) {
               var12 = (var23.sizeX * 4 - var20.originalWidth) / 2;
               var19 = (var23.sizeY * 4 - var20.height) / 2;
               var20.method3919(var12 + 48 + var1 * 4, var19 + 48 + 4 * (104 - var2 - var23.sizeY));
            }
         } else if(var8 == 9) {
            var11 = 15658734;
            if(var5 > 0) {
               var11 = 15597568;
            }

            int[] var18 = class63.field1094.image;
            var19 = 2048 * (103 - var2) + 4 * var1 + 24624;
            if(var7 != 0 && var7 != 2) {
               var18[var19] = var11;
               var18[1 + var19 + 512] = var11;
               var18[var19 + 1024 + 2] = var11;
               var18[3 + 1536 + var19] = var11;
            } else {
               var18[var19 + 1536] = var11;
               var18[var19 + 1024 + 1] = var11;
               var18[2 + var19 + 512] = var11;
               var18[3 + var19] = var11;
            }
         }
      }

      var5 = class0.region.method1668(var0, var1, var2);
      if(var5 != 0) {
         var6 = var5 >> 14 & 32767;
         ObjectComposition var17 = class143.getObjectDefinition(var6);
         if(var17.mapSceneId != -1) {
            ModIcon var21 = class152.field2080[var17.mapSceneId];
            if(var21 != null) {
               var9 = (var17.sizeX * 4 - var21.originalWidth) / 2;
               int var22 = (var17.sizeY * 4 - var21.height) / 2;
               var21.method3919(48 + 4 * var1 + var9, 4 * (104 - var2 - var17.sizeY) + 48 + var22);
            }
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)LVarbit;",
      garbageValue = "1737842348"
   )
   public static Varbit method2026(int var0) {
      Varbit var1 = (Varbit)Varbit.field2852.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Varbit.field2857.method3182(14, var0);
         var1 = new Varbit();
         if(var2 != null) {
            var1.method3439(new Buffer(var2));
         }

         Varbit.field2852.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)LSequence;",
      garbageValue = "-1021083815"
   )
   @Export("getAnimation")
   public static Sequence getAnimation(int var0) {
      Sequence var1 = (Sequence)Sequence.field3059.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Sequence.field3061.method3182(12, var0);
         var1 = new Sequence();
         if(null != var2) {
            var1.method3609(new Buffer(var2));
         }

         var1.method3610();
         Sequence.field3059.put(var1, (long)var0);
         return var1;
      }
   }
}
