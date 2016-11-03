import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ex")
public final class class137 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 508451511
   )
   int field2126 = '\ufde8';
   @ObfuscatedName("f")
   class231 field2127 = null;
   @ObfuscatedName("q")
   class231 field2128 = null;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1653389597
   )
   int field2129;
   @ObfuscatedName("k")
   static byte[] field2130 = new byte[520];

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I[BIZB)Z",
      garbageValue = "-63"
   )
   boolean method2901(int var1, byte[] var2, int var3, boolean var4) {
      class231 var5 = this.field2128;
      synchronized(this.field2128) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2127.method4166() < (long)(6 + var1 * 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2127.method4165((long)(var1 * 6));
               this.field2127.method4189(field2130, 0, 6);
               var6 = (field2130[5] & 255) + ((field2130[3] & 255) << 16) + ((field2130[4] & 255) << 8);
               if(var6 <= 0 || (long)var6 > this.field2128.method4166() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2128.method4166() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2130[0] = (byte)(var3 >> 16);
            field2130[1] = (byte)(var3 >> 8);
            field2130[2] = (byte)var3;
            field2130[3] = (byte)(var6 >> 16);
            field2130[4] = (byte)(var6 >> 8);
            field2130[5] = (byte)var6;
            this.field2127.method4165((long)(var1 * 6));
            this.field2127.method4176(field2130, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label140: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field2128.method4165((long)(var6 * 520));

                        try {
                           this.field2128.method4189(field2130, 0, 8);
                        } catch (EOFException var16) {
                           break label140;
                        }

                        var14 = (field2130[1] & 255) + ((field2130[0] & 255) << 8);
                        int var11 = (field2130[3] & 255) + ((field2130[2] & 255) << 8);
                        var9 = ((field2130[4] & 255) << 16) + ((field2130[5] & 255) << 8) + (field2130[6] & 255);
                        int var12 = field2130[7] & 255;
                        if(var1 != var14 || var11 != var8 || this.field2129 != var12) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field2128.method4166() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field2128.method4166() + 519L) / 520L);
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

                     field2130[0] = (byte)(var1 >> 8);
                     field2130[1] = (byte)var1;
                     field2130[2] = (byte)(var8 >> 8);
                     field2130[3] = (byte)var8;
                     field2130[4] = (byte)(var9 >> 16);
                     field2130[5] = (byte)(var9 >> 8);
                     field2130[6] = (byte)var9;
                     field2130[7] = (byte)this.field2129;
                     this.field2128.method4165((long)(var6 * 520));
                     this.field2128.method4176(field2130, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field2128.method4176(var2, var7, var14);
                     var7 += var14;
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

   @ObfuscatedSignature(
      signature = "(ILclass231;Lclass231;I)V",
      garbageValue = "500000"
   )
   public class137(int var1, class231 var2, class231 var3, int var4) {
      this.field2129 = var1;
      this.field2128 = var2;
      this.field2127 = var3;
      this.field2126 = var4;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-222338861"
   )
   public byte[] method2903(int var1) {
      class231 var2 = this.field2128;
      synchronized(this.field2128) {
         try {
            Object var10000;
            if(this.field2127.method4166() < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field2127.method4165((long)(6 * var1));
               this.field2127.method4189(field2130, 0, 6);
               int var3 = (field2130[2] & 255) + ((field2130[0] & 255) << 16) + ((field2130[1] & 255) << 8);
               int var4 = (field2130[5] & 255) + ((field2130[4] & 255) << 8) + ((field2130[3] & 255) << 16);
               if(var3 < 0 || var3 > this.field2126) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field2128.method4166() / 520L) {
                  var10000 = null;
                  return (byte[])var10000;
               } else {
                  byte[] var5 = new byte[var3];
                  int var6 = 0;
                  int var7 = 0;

                  while(var6 < var3) {
                     if(var4 == 0) {
                        var10000 = null;
                        return (byte[])var10000;
                     }

                     this.field2128.method4165((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field2128.method4189(field2130, 0, var8 + 8);
                     int var9 = (field2130[1] & 255) + ((field2130[0] & 255) << 8);
                     int var10 = ((field2130[2] & 255) << 8) + (field2130[3] & 255);
                     int var11 = (field2130[6] & 255) + ((field2130[5] & 255) << 8) + ((field2130[4] & 255) << 16);
                     int var12 = field2130[7] & 255;
                     if(var9 == var1 && var10 == var7 && this.field2129 == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field2128.method4166() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field2130[var13 + 8];
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
            }
         } catch (IOException var16) {
            return null;
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I[BII)Z",
      garbageValue = "1659870769"
   )
   public boolean method2905(int var1, byte[] var2, int var3) {
      class231 var4 = this.field2128;
      synchronized(this.field2128) {
         if(var3 >= 0 && var3 <= this.field2126) {
            boolean var5 = this.method2901(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2901(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }
}
