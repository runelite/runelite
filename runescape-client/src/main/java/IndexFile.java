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
      synchronized(this.field2292) {
         try {
            Object var4;
            byte[] var10000;
            if(this.field2290.method2237() < (long)(var1 * 6 + 6)) {
               var4 = null;
               var10000 = (byte[])((byte[])var4);
               return var10000;
            } else {
               this.field2290.method2256((long)(var1 * 6));
               this.field2290.method2239(field2291, 0, 6);
               int var5 = (field2291[2] & 255) + ((field2291[1] & 255) << 8) + ((field2291[0] & 255) << 16);
               int var6 = ((field2291[3] & 255) << 16) + ((field2291[4] & 255) << 8) + (field2291[5] & 255);
               if(var5 < 0 || var5 > this.field2288) {
                  var4 = null;
                  var10000 = (byte[])((byte[])var4);
                  return var10000;
               } else if(var6 <= 0 || (long)var6 > this.field2292.method2237() / 520L) {
                  var4 = null;
                  return (byte[])((byte[])var4);
               } else {
                  byte[] var7 = new byte[var5];
                  int var8 = 0;

                  for(int var9 = 0; var8 < var5; ++var9) {
                     if(var6 == 0) {
                        var4 = null;
                        var10000 = (byte[])((byte[])var4);
                        return var10000;
                     }

                     this.field2292.method2256((long)(var6 * 520));
                     int var10 = var5 - var8;
                     if(var10 > 512) {
                        var10 = 512;
                     }

                     this.field2292.method2239(field2291, 0, var10 + 8);
                     int var11 = ((field2291[0] & 255) << 8) + (field2291[1] & 255);
                     int var12 = ((field2291[2] & 255) << 8) + (field2291[3] & 255);
                     int var13 = (field2291[6] & 255) + ((field2291[4] & 255) << 16) + ((field2291[5] & 255) << 8);
                     int var14 = field2291[7] & 255;
                     if(var1 != var11 || var9 != var12 || this.index != var14) {
                        var4 = null;
                        var10000 = (byte[])((byte[])var4);
                        return var10000;
                     }

                     if(var13 < 0 || (long)var13 > this.field2292.method2237() / 520L) {
                        var4 = null;
                        var10000 = (byte[])((byte[])var4);
                        return var10000;
                     }

                     for(int var15 = 0; var15 < var10; ++var15) {
                        var7[var8++] = field2291[var15 + 8];
                     }

                     var6 = var13;
                  }

                  var10000 = var7;
                  return var10000;
               }
            }
         } catch (IOException var17) {
            return null;
         }
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
      synchronized(this.field2292) {
         if(var3 >= 0 && var3 <= this.field2288) {
            boolean var6 = this.method2904(var1, var2, var3, true);
            if(!var6) {
               var6 = this.method2904(var1, var2, var3, false);
            }

            return var6;
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
      synchronized(this.field2292) {
         try {
            int var7;
            boolean var8;
            boolean var10000;
            if(var4) {
               if(this.field2290.method2237() < (long)(var1 * 6 + 6)) {
                  var8 = false;
                  var10000 = var8;
                  return var10000;
               }

               this.field2290.method2256((long)(var1 * 6));
               this.field2290.method2239(field2291, 0, 6);
               var7 = (field2291[5] & 255) + ((field2291[3] & 255) << 16) + ((field2291[4] & 255) << 8);
               if(var7 <= 0 || (long)var7 > this.field2292.method2237() / 520L) {
                  var8 = false;
                  var10000 = var8;
                  return var10000;
               }
            } else {
               var7 = (int)((this.field2292.method2237() + 519L) / 520L);
               if(var7 == 0) {
                  var7 = 1;
               }
            }

            field2291[0] = (byte)(var3 >> 16);
            field2291[1] = (byte)(var3 >> 8);
            field2291[2] = (byte)var3;
            field2291[3] = (byte)(var7 >> 16);
            field2291[4] = (byte)(var7 >> 8);
            field2291[5] = (byte)var7;
            this.field2290.method2256((long)(var1 * 6));
            this.field2290.method2241(field2291, 0, 6);
            int var9 = 0;
            int var10 = 0;

            while(true) {
               if(var9 < var3) {
                  label129: {
                     int var11 = 0;
                     int var12;
                     if(var4) {
                        this.field2292.method2256((long)(var7 * 520));

                        try {
                           this.field2292.method2239(field2291, 0, 8);
                        } catch (EOFException var16) {
                           break label129;
                        }

                        var12 = (field2291[1] & 255) + ((field2291[0] & 255) << 8);
                        int var13 = ((field2291[2] & 255) << 8) + (field2291[3] & 255);
                        var11 = ((field2291[4] & 255) << 16) + ((field2291[5] & 255) << 8) + (field2291[6] & 255);
                        int var14 = field2291[7] & 255;
                        if(var12 != var1 || var13 != var10 || this.index != var14) {
                           var8 = false;
                           var10000 = var8;
                           return var10000;
                        }

                        if(var11 < 0 || (long)var11 > this.field2292.method2237() / 520L) {
                           var8 = false;
                           var10000 = var8;
                           return var10000;
                        }
                     }

                     if(var11 == 0) {
                        var4 = false;
                        var11 = (int)((this.field2292.method2237() + 519L) / 520L);
                        if(var11 == 0) {
                           ++var11;
                        }

                        if(var11 == var7) {
                           ++var11;
                        }
                     }

                     if(var3 - var9 <= 512) {
                        var11 = 0;
                     }

                     field2291[0] = (byte)(var1 >> 8);
                     field2291[1] = (byte)var1;
                     field2291[2] = (byte)(var10 >> 8);
                     field2291[3] = (byte)var10;
                     field2291[4] = (byte)(var11 >> 16);
                     field2291[5] = (byte)(var11 >> 8);
                     field2291[6] = (byte)var11;
                     field2291[7] = (byte)this.index;
                     this.field2292.method2256((long)(var7 * 520));
                     this.field2292.method2241(field2291, 0, 8);
                     var12 = var3 - var9;
                     if(var12 > 512) {
                        var12 = 512;
                     }

                     this.field2292.method2241(var2, var9, var12);
                     var9 += var12;
                     var7 = var11;
                     ++var10;
                     continue;
                  }
               }

               var8 = true;
               var10000 = var8;
               return var10000;
            }
         } catch (IOException var17) {
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
