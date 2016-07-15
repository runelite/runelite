import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
public final class class137 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 722429333
   )
   int field2125 = '\ufde8';
   @ObfuscatedName("l")
   class231 field2126 = null;
   @ObfuscatedName("c")
   class231 field2127 = null;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1374486685
   )
   int field2128;
   @ObfuscatedName("e")
   static byte[] field2132 = new byte[520];

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-710818115"
   )
   public byte[] method2980(int var1) {
      class231 var2 = this.field2126;
      synchronized(this.field2126) {
         try {
            Object var10000;
            if(this.field2127.method4237() < (long)(6 + var1 * 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field2127.method4252((long)(6 * var1));
               this.field2127.method4233(field2132, 0, 6);
               int var3 = (field2132[2] & 255) + ((field2132[1] & 255) << 8) + ((field2132[0] & 255) << 16);
               int var4 = (field2132[5] & 255) + ((field2132[3] & 255) << 16) + ((field2132[4] & 255) << 8);
               if(var3 < 0 || var3 > this.field2125) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field2126.method4237() / 520L) {
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

                     this.field2126.method4252((long)(520 * var4));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field2126.method4233(field2132, 0, var8 + 8);
                     int var9 = ((field2132[0] & 255) << 8) + (field2132[1] & 255);
                     int var10 = ((field2132[2] & 255) << 8) + (field2132[3] & 255);
                     int var11 = (field2132[6] & 255) + ((field2132[5] & 255) << 8) + ((field2132[4] & 255) << 16);
                     int var12 = field2132[7] & 255;
                     if(var1 == var9 && var7 == var10 && var12 == this.field2128) {
                        if(var11 >= 0 && (long)var11 <= this.field2126.method4237() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field2132[var13 + 8];
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I[BII)Z",
      garbageValue = "-1771600328"
   )
   public boolean method2981(int var1, byte[] var2, int var3) {
      class231 var4 = this.field2126;
      synchronized(this.field2126) {
         if(var3 >= 0 && var3 <= this.field2125) {
            boolean var5 = this.method2982(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2982(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I[BIZB)Z",
      garbageValue = "8"
   )
   boolean method2982(int var1, byte[] var2, int var3, boolean var4) {
      class231 var5 = this.field2126;
      synchronized(this.field2126) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2127.method4237() < (long)(6 * var1 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2127.method4252((long)(var1 * 6));
               this.field2127.method4233(field2132, 0, 6);
               var6 = ((field2132[4] & 255) << 8) + ((field2132[3] & 255) << 16) + (field2132[5] & 255);
               if(var6 <= 0 || (long)var6 > this.field2126.method4237() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2126.method4237() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2132[0] = (byte)(var3 >> 16);
            field2132[1] = (byte)(var3 >> 8);
            field2132[2] = (byte)var3;
            field2132[3] = (byte)(var6 >> 16);
            field2132[4] = (byte)(var6 >> 8);
            field2132[5] = (byte)var6;
            this.field2127.method4252((long)(var1 * 6));
            this.field2127.method4255(field2132, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label145: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field2126.method4252((long)(var6 * 520));

                        try {
                           this.field2126.method4233(field2132, 0, 8);
                        } catch (EOFException var16) {
                           break label145;
                        }

                        var14 = (field2132[1] & 255) + ((field2132[0] & 255) << 8);
                        int var11 = (field2132[3] & 255) + ((field2132[2] & 255) << 8);
                        var9 = (field2132[6] & 255) + ((field2132[4] & 255) << 16) + ((field2132[5] & 255) << 8);
                        int var12 = field2132[7] & 255;
                        if(var14 != var1 || var8 != var11 || var12 != this.field2128) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field2126.method4237() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field2126.method4237() + 519L) / 520L);
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

                     field2132[0] = (byte)(var1 >> 8);
                     field2132[1] = (byte)var1;
                     field2132[2] = (byte)(var8 >> 8);
                     field2132[3] = (byte)var8;
                     field2132[4] = (byte)(var9 >> 16);
                     field2132[5] = (byte)(var9 >> 8);
                     field2132[6] = (byte)var9;
                     field2132[7] = (byte)this.field2128;
                     this.field2126.method4252((long)(var6 * 520));
                     this.field2126.method4255(field2132, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field2126.method4255(var2, var7, var14);
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
      this.field2128 = var1;
      this.field2126 = var2;
      this.field2127 = var3;
      this.field2125 = var4;
   }
}
