import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
@Implements("IndexFile")
public final class IndexFile {
   @ObfuscatedName("t")
   class123 field2287;
   @ObfuscatedName("a")
   class123 field2288;
   @ObfuscatedName("pj")
   @ObfuscatedGetter(
      intValue = 1938425157
   )
   static int field2289;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1810596781
   )
   int field2291;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1878247999
   )
   @Export("index")
   int index;
   @ObfuscatedName("w")
   static byte[] field2293;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1504968457"
   )
   public byte[] method2997(int var1) {
      class123 var2 = this.field2288;
      synchronized(this.field2288) {
         Object var10000;
         try {
            if(this.field2287.method2335() < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            }

            this.field2287.method2338((long)(var1 * 6));
            this.field2287.method2361(field2293, 0, 6);
            int var3 = ((field2293[0] & 255) << 16) + ((field2293[1] & 255) << 8) + (field2293[2] & 255);
            int var4 = ((field2293[4] & 255) << 8) + ((field2293[3] & 255) << 16) + (field2293[5] & 255);
            if(var3 >= 0 && var3 <= this.field2291) {
               if(var4 > 0 && (long)var4 <= this.field2288.method2335() / 520L) {
                  byte[] var5 = new byte[var3];
                  int var6 = 0;
                  int var7 = 0;

                  while(var6 < var3) {
                     if(var4 == 0) {
                        var10000 = null;
                        return (byte[])var10000;
                     }

                     this.field2288.method2338((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field2288.method2361(field2293, 0, var8 + 8);
                     int var9 = ((field2293[0] & 255) << 8) + (field2293[1] & 255);
                     int var10 = (field2293[3] & 255) + ((field2293[2] & 255) << 8);
                     int var11 = (field2293[6] & 255) + ((field2293[5] & 255) << 8) + ((field2293[4] & 255) << 16);
                     int var12 = field2293[7] & 255;
                     if(var9 == var1 && var10 == var7 && this.index == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field2288.method2335() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field2293[var13 + 8];
                           }

                           var4 = var11;
                           ++var7;
                           continue;
                        }

                        var10000 = null;
                        return (byte[])var10000;
                     }

                     var10000 = null;
                     return (byte[])var10000;
                  }

                  byte[] var18 = var5;
                  return var18;
               }

               var10000 = null;
               return (byte[])var10000;
            }

            var10000 = null;
         } catch (IOException var16) {
            return null;
         }

         return (byte[])var10000;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "-1963797605"
   )
   boolean method3000(int var1, byte[] var2, int var3, boolean var4) {
      class123 var5 = this.field2288;
      synchronized(this.field2288) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2287.method2335() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2287.method2338((long)(var1 * 6));
               this.field2287.method2361(field2293, 0, 6);
               var6 = ((field2293[4] & 255) << 8) + ((field2293[3] & 255) << 16) + (field2293[5] & 255);
               if(var6 <= 0 || (long)var6 > this.field2288.method2335() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2288.method2335() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2293[0] = (byte)(var3 >> 16);
            field2293[1] = (byte)(var3 >> 8);
            field2293[2] = (byte)var3;
            field2293[3] = (byte)(var6 >> 16);
            field2293[4] = (byte)(var6 >> 8);
            field2293[5] = (byte)var6;
            this.field2287.method2338((long)(var1 * 6));
            this.field2287.method2339(field2293, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label147: {
                     int var9 = 0;
                     int var10;
                     if(var4) {
                        this.field2288.method2338((long)(var6 * 520));

                        try {
                           this.field2288.method2361(field2293, 0, 8);
                        } catch (EOFException var16) {
                           break label147;
                        }

                        var10 = ((field2293[0] & 255) << 8) + (field2293[1] & 255);
                        int var11 = (field2293[3] & 255) + ((field2293[2] & 255) << 8);
                        var9 = (field2293[6] & 255) + ((field2293[5] & 255) << 8) + ((field2293[4] & 255) << 16);
                        int var12 = field2293[7] & 255;
                        if(var10 != var1 || var11 != var8 || this.index != var12) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field2288.method2335() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field2288.method2335() + 519L) / 520L);
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

                     field2293[0] = (byte)(var1 >> 8);
                     field2293[1] = (byte)var1;
                     field2293[2] = (byte)(var8 >> 8);
                     field2293[3] = (byte)var8;
                     field2293[4] = (byte)(var9 >> 16);
                     field2293[5] = (byte)(var9 >> 8);
                     field2293[6] = (byte)var9;
                     field2293[7] = (byte)this.index;
                     this.field2288.method2338((long)(var6 * 520));
                     this.field2288.method2339(field2293, 0, 8);
                     var10 = var3 - var7;
                     if(var10 > 512) {
                        var10 = 512;
                     }

                     this.field2288.method2339(var2, var7, var10);
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
      field2293 = new byte[520];
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I[BIB)Z",
      garbageValue = "0"
   )
   public boolean method3002(int var1, byte[] var2, int var3) {
      class123 var4 = this.field2288;
      synchronized(this.field2288) {
         if(var3 >= 0 && var3 <= this.field2291) {
            boolean var5 = this.method3000(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method3000(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(ILclass123;Lclass123;I)V",
      garbageValue = "500000"
   )
   public IndexFile(int var1, class123 var2, class123 var3, int var4) {
      this.field2288 = null;
      this.field2287 = null;
      this.field2291 = '\ufde8';
      this.index = var1;
      this.field2288 = var2;
      this.field2287 = var3;
      this.field2291 = var4;
   }
}
