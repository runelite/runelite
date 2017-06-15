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
      synchronized(this.field2292) {
         Object var10000;
         try {
            if(this.field2290.method2237() < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            }

            this.field2290.method2256((long)(var1 * 6));
            this.field2290.method2239(field2291, 0, 6);
            int var3 = (field2291[2] & 255) + ((field2291[1] & 255) << 8) + ((field2291[0] & 255) << 16);
            int var4 = ((field2291[3] & 255) << 16) + ((field2291[4] & 255) << 8) + (field2291[5] & 255);
            if(var3 < 0 || var3 > this.field2288) {
               var10000 = null;
               return (byte[])var10000;
            }

            if(var4 > 0 && (long)var4 <= this.field2292.method2237() / 520L) {
               byte[] var5 = new byte[var3];
               int var6 = 0;

               for(int var7 = 0; var6 < var3; ++var7) {
                  if(var4 == 0) {
                     var10000 = null;
                     return (byte[])var10000;
                  }

                  this.field2292.method2256((long)(var4 * 520));
                  int var8 = var3 - var6;
                  if(var8 > 512) {
                     var8 = 512;
                  }

                  this.field2292.method2239(field2291, 0, var8 + 8);
                  int var9 = ((field2291[0] & 255) << 8) + (field2291[1] & 255);
                  int var10 = ((field2291[2] & 255) << 8) + (field2291[3] & 255);
                  int var11 = (field2291[6] & 255) + ((field2291[4] & 255) << 16) + ((field2291[5] & 255) << 8);
                  int var12 = field2291[7] & 255;
                  if(var1 != var9 || var7 != var10 || this.index != var12) {
                     var10000 = null;
                     return (byte[])var10000;
                  }

                  if(var11 < 0 || (long)var11 > this.field2292.method2237() / 520L) {
                     var10000 = null;
                     return (byte[])var10000;
                  }

                  for(int var13 = 0; var13 < var8; ++var13) {
                     var5[var6++] = field2291[var13 + 8];
                  }

                  var4 = var11;
               }

               byte[] var18 = var5;
               return var18;
            }

            var10000 = null;
         } catch (IOException var16) {
            return null;
         }

         return (byte[])var10000;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I[BII)Z",
      garbageValue = "-1797887890"
   )
   public boolean method2903(int var1, byte[] var2, int var3) {
      class123 var4 = this.field2292;
      synchronized(this.field2292) {
         if(var3 >= 0 && var3 <= this.field2288) {
            boolean var5 = this.method2904(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2904(var1, var2, var3, false);
            }

            return var5;
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
      synchronized(this.field2292) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2290.method2237() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2290.method2256((long)(var1 * 6));
               this.field2290.method2239(field2291, 0, 6);
               var6 = (field2291[5] & 255) + ((field2291[3] & 255) << 16) + ((field2291[4] & 255) << 8);
               if(var6 <= 0 || (long)var6 > this.field2292.method2237() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2292.method2237() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2291[0] = (byte)(var3 >> 16);
            field2291[1] = (byte)(var3 >> 8);
            field2291[2] = (byte)var3;
            field2291[3] = (byte)(var6 >> 16);
            field2291[4] = (byte)(var6 >> 8);
            field2291[5] = (byte)var6;
            this.field2290.method2256((long)(var1 * 6));
            this.field2290.method2241(field2291, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label140: {
                     int var9 = 0;
                     int var10;
                     if(var4) {
                        this.field2292.method2256((long)(var6 * 520));

                        try {
                           this.field2292.method2239(field2291, 0, 8);
                        } catch (EOFException var16) {
                           break label140;
                        }

                        var10 = (field2291[1] & 255) + ((field2291[0] & 255) << 8);
                        int var11 = ((field2291[2] & 255) << 8) + (field2291[3] & 255);
                        var9 = ((field2291[4] & 255) << 16) + ((field2291[5] & 255) << 8) + (field2291[6] & 255);
                        int var12 = field2291[7] & 255;
                        if(var10 != var1 || var11 != var8 || this.index != var12) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field2292.method2237() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field2292.method2237() + 519L) / 520L);
                        if(var9 == 0) {
                           ++var9;
                        }

                        if(var9 == var6) {
                           ++var9;
                        }
                     }

                     if(var3 - var7 <= 512) {
                        var9 = 0;
                     }

                     field2291[0] = (byte)(var1 >> 8);
                     field2291[1] = (byte)var1;
                     field2291[2] = (byte)(var8 >> 8);
                     field2291[3] = (byte)var8;
                     field2291[4] = (byte)(var9 >> 16);
                     field2291[5] = (byte)(var9 >> 8);
                     field2291[6] = (byte)var9;
                     field2291[7] = (byte)this.index;
                     this.field2292.method2256((long)(var6 * 520));
                     this.field2292.method2241(field2291, 0, 8);
                     var10 = var3 - var7;
                     if(var10 > 512) {
                        var10 = 512;
                     }

                     this.field2292.method2241(var2, var7, var10);
                     var7 += var10;
                     var6 = var9;
                     ++var8;
                     continue;
                  }
               }

               var10000 = true;
               return var10000;
            }
         } catch (IOException var17) {
            return false;
         }
      }
   }

   static {
      field2291 = new byte[520];
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
      return class154.method2843(var0, 10, true);
   }
}
