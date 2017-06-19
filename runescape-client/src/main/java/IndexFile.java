import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
@Implements("IndexFile")
public final class IndexFile {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1043977463
   )
   int field2288;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -970145131
   )
   @Export("index")
   int index;
   @ObfuscatedName("e")
   class123 field2290;
   @ObfuscatedName("p")
   static byte[] field2291;
   @ObfuscatedName("m")
   class123 field2292;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "108"
   )
   public byte[] method2902(int var1) {
      class123 var2 = this.field2292;
      class123 var3 = this.field2292;
      class123 var4 = this.field2292;
      synchronized(this.field2292) {
         byte[] var10000;
         try {
            Object var5;
            byte[] var6;
            if(this.field2290.method2237() < (long)(var1 * 6 + 6)) {
               var5 = null;
               var6 = (byte[])((byte[])((byte[])var5));
               var10000 = var6;
               return var10000;
            }

            this.field2290.method2256((long)(var1 * 6));
            this.field2290.method2239(field2291, 0, 6);
            int var7 = ((field2291[0] & 255) << 16) + (field2291[2] & 255) + ((field2291[1] & 255) << 8);
            int var8 = ((field2291[4] & 255) << 8) + ((field2291[3] & 255) << 16) + (field2291[5] & 255);
            if(var7 < 0 || var7 > this.field2288) {
               var5 = null;
               var6 = (byte[])((byte[])((byte[])var5));
               var10000 = var6;
               return var10000;
            }

            if(var8 > 0 && (long)var8 <= this.field2292.method2237() / 520L) {
               byte[] var9 = new byte[var7];
               int var10 = 0;

               for(int var11 = 0; var10 < var7; ++var11) {
                  if(var8 == 0) {
                     var5 = null;
                     var6 = (byte[])((byte[])((byte[])var5));
                     var10000 = var6;
                     return var10000;
                  }

                  this.field2292.method2256((long)(var8 * 520));
                  int var12 = var7 - var10;
                  if(var12 > 512) {
                     var12 = 512;
                  }

                  this.field2292.method2239(field2291, 0, var12 + 8);
                  int var13 = ((field2291[0] & 255) << 8) + (field2291[1] & 255);
                  int var14 = (field2291[3] & 255) + ((field2291[2] & 255) << 8);
                  int var15 = (field2291[6] & 255) + ((field2291[4] & 255) << 16) + ((field2291[5] & 255) << 8);
                  int var16 = field2291[7] & 255;
                  if(var13 != var1 || var11 != var14 || var16 != this.index) {
                     var5 = null;
                     var6 = (byte[])((byte[])((byte[])var5));
                     var10000 = var6;
                     return var10000;
                  }

                  if(var15 < 0 || (long)var15 > this.field2292.method2237() / 520L) {
                     var5 = null;
                     var6 = (byte[])((byte[])((byte[])var5));
                     var10000 = var6;
                     return var10000;
                  }

                  for(int var17 = 0; var17 < var12; ++var17) {
                     var9[var10++] = field2291[var17 + 8];
                  }

                  var8 = var15;
               }

               var10000 = var9;
               return var10000;
            }

            var5 = null;
            var10000 = (byte[])((byte[])((byte[])var5));
         } catch (IOException var19) {
            return null;
         }

         return var10000;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I[BII)Z",
      garbageValue = "-1797887890"
   )
   public boolean method2903(int var1, byte[] var2, int var3) {
      class123 var4 = this.field2292;
      class123 var5 = this.field2292;
      class123 var6 = this.field2292;
      synchronized(this.field2292) {
         if(var3 >= 0 && var3 <= this.field2288) {
            boolean var7 = this.method2904(var1, var2, var3, true);
            if(!var7) {
               var7 = this.method2904(var1, var2, var3, false);
            }

            return var7;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "2121277192"
   )
   boolean method2904(int var1, byte[] var2, int var3, boolean var4) {
      class123 var5 = this.field2292;
      class123 var6 = this.field2292;
      class123 var7 = this.field2292;
      synchronized(this.field2292) {
         try {
            int var8;
            boolean var9;
            boolean var10000;
            if(var4) {
               if(this.field2290.method2237() < (long)(var1 * 6 + 6)) {
                  var9 = false;
                  var10000 = var9;
                  return var10000;
               }

               this.field2290.method2256((long)(var1 * 6));
               this.field2290.method2239(field2291, 0, 6);
               var8 = ((field2291[4] & 255) << 8) + (field2291[5] & 255) + ((field2291[3] & 255) << 16);
               if(var8 <= 0 || (long)var8 > this.field2292.method2237() / 520L) {
                  var9 = false;
                  var10000 = var9;
                  return var10000;
               }
            } else {
               var8 = (int)((this.field2292.method2237() + 519L) / 520L);
               if(var8 == 0) {
                  var8 = 1;
               }
            }

            field2291[0] = (byte)(var3 >> 16);
            field2291[1] = (byte)(var3 >> 8);
            field2291[2] = (byte)var3;
            field2291[3] = (byte)(var8 >> 16);
            field2291[4] = (byte)(var8 >> 8);
            field2291[5] = (byte)var8;
            this.field2290.method2256((long)(var1 * 6));
            this.field2290.method2241(field2291, 0, 6);
            int var11 = 0;
            int var12 = 0;

            while(true) {
               if(var11 < var3) {
                  label129: {
                     int var13 = 0;
                     int var14;
                     if(var4) {
                        this.field2292.method2256((long)(var8 * 520));

                        try {
                           this.field2292.method2239(field2291, 0, 8);
                        } catch (EOFException var18) {
                           break label129;
                        }

                        var14 = ((field2291[0] & 255) << 8) + (field2291[1] & 255);
                        int var15 = (field2291[3] & 255) + ((field2291[2] & 255) << 8);
                        var13 = (field2291[6] & 255) + ((field2291[5] & 255) << 8) + ((field2291[4] & 255) << 16);
                        int var16 = field2291[7] & 255;
                        if(var14 != var1 || var15 != var12 || var16 != this.index) {
                           var9 = false;
                           var10000 = var9;
                           return var10000;
                        }

                        if(var13 < 0 || (long)var13 > this.field2292.method2237() / 520L) {
                           var9 = false;
                           var10000 = var9;
                           return var10000;
                        }
                     }

                     if(var13 == 0) {
                        var4 = false;
                        var13 = (int)((this.field2292.method2237() + 519L) / 520L);
                        if(var13 == 0) {
                           ++var13;
                        }

                        if(var13 == var8) {
                           ++var13;
                        }
                     }

                     if(var3 - var11 <= 512) {
                        var13 = 0;
                     }

                     field2291[0] = (byte)(var1 >> 8);
                     field2291[1] = (byte)var1;
                     field2291[2] = (byte)(var12 >> 8);
                     field2291[3] = (byte)var12;
                     field2291[4] = (byte)(var13 >> 16);
                     field2291[5] = (byte)(var13 >> 8);
                     field2291[6] = (byte)var13;
                     field2291[7] = (byte)this.index;
                     this.field2292.method2256((long)(var8 * 520));
                     this.field2292.method2241(field2291, 0, 8);
                     var14 = var3 - var11;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field2292.method2241(var2, var11, var14);
                     var11 += var14;
                     var8 = var13;
                     ++var12;
                     continue;
                  }
               }

               var9 = true;
               var10000 = var9;
               return var10000;
            }
         } catch (IOException var19) {
            return false;
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(ILclass123;Lclass123;I)V",
      garbageValue = "500000"
   )
   public IndexFile(int var1, class123 var2, class123 var3, int var4) {
      this.field2292 = null;
      this.field2290 = null;
      this.field2288 = '\ufde8';
      this.index = var1;
      this.field2292 = var2;
      this.field2290 = var3;
      this.field2288 = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Z",
      garbageValue = "954316910"
   )
   public static boolean method2910(CharSequence var0) {
      return Signlink.method2843(var0, 10, true);
   }

   static {
      field2291 = new byte[520];
   }
}
