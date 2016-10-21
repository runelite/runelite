import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public final class class137 {
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 605523951
   )
   int field2124 = '\ufde8';
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1843790923
   )
   int field2125;
   @ObfuscatedName("n")
   class231 field2126 = null;
   @ObfuscatedName("f")
   static byte[] field2128 = new byte[520];
   @ObfuscatedName("e")
   class231 field2129 = null;
   @ObfuscatedName("k")
   static int[] field2130;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "1"
   )
   public byte[] method2887(int var1) {
      class231 var2 = this.field2129;
      synchronized(this.field2129) {
         try {
            Object var10000;
            if(this.field2126.method4213() < (long)(6 * var1 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field2126.method4212((long)(var1 * 6));
               this.field2126.method4215(field2128, 0, 6);
               int var3 = ((field2128[0] & 255) << 16) + ((field2128[1] & 255) << 8) + (field2128[2] & 255);
               int var4 = (field2128[5] & 255) + ((field2128[4] & 255) << 8) + ((field2128[3] & 255) << 16);
               if(var3 < 0 || var3 > this.field2124) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field2129.method4213() / 520L) {
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

                     this.field2129.method4212((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field2129.method4215(field2128, 0, var8 + 8);
                     int var9 = ((field2128[0] & 255) << 8) + (field2128[1] & 255);
                     int var10 = (field2128[3] & 255) + ((field2128[2] & 255) << 8);
                     int var11 = ((field2128[4] & 255) << 16) + ((field2128[5] & 255) << 8) + (field2128[6] & 255);
                     int var12 = field2128[7] & 255;
                     if(var9 == var1 && var7 == var10 && var12 == this.field2125) {
                        if(var11 >= 0 && (long)var11 <= this.field2129.method4213() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field2128[var13 + 8];
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I[BIS)Z",
      garbageValue = "-18664"
   )
   public boolean method2888(int var1, byte[] var2, int var3) {
      class231 var4 = this.field2129;
      synchronized(this.field2129) {
         if(var3 >= 0 && var3 <= this.field2124) {
            boolean var5 = this.method2894(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2894(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)[B",
      garbageValue = "1787427266"
   )
   public static byte[] method2889(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 <= 0 || var4 >= 128) && (var4 < 160 || var4 > 255)) {
            if(var4 == 8364) {
               var2[var3] = -128;
            } else if(var4 == 8218) {
               var2[var3] = -126;
            } else if(var4 == 402) {
               var2[var3] = -125;
            } else if(var4 == 8222) {
               var2[var3] = -124;
            } else if(var4 == 8230) {
               var2[var3] = -123;
            } else if(var4 == 8224) {
               var2[var3] = -122;
            } else if(var4 == 8225) {
               var2[var3] = -121;
            } else if(var4 == 710) {
               var2[var3] = -120;
            } else if(var4 == 8240) {
               var2[var3] = -119;
            } else if(var4 == 352) {
               var2[var3] = -118;
            } else if(var4 == 8249) {
               var2[var3] = -117;
            } else if(var4 == 338) {
               var2[var3] = -116;
            } else if(var4 == 381) {
               var2[var3] = -114;
            } else if(var4 == 8216) {
               var2[var3] = -111;
            } else if(var4 == 8217) {
               var2[var3] = -110;
            } else if(var4 == 8220) {
               var2[var3] = -109;
            } else if(var4 == 8221) {
               var2[var3] = -108;
            } else if(var4 == 8226) {
               var2[var3] = -107;
            } else if(var4 == 8211) {
               var2[var3] = -106;
            } else if(var4 == 8212) {
               var2[var3] = -105;
            } else if(var4 == 732) {
               var2[var3] = -104;
            } else if(var4 == 8482) {
               var2[var3] = -103;
            } else if(var4 == 353) {
               var2[var3] = -102;
            } else if(var4 == 8250) {
               var2[var3] = -101;
            } else if(var4 == 339) {
               var2[var3] = -100;
            } else if(var4 == 382) {
               var2[var3] = -98;
            } else if(var4 == 376) {
               var2[var3] = -97;
            } else {
               var2[var3] = 63;
            }
         } else {
            var2[var3] = (byte)var4;
         }
      }

      return var2;
   }

   @ObfuscatedSignature(
      signature = "(ILclass231;Lclass231;I)V",
      garbageValue = "500000"
   )
   public class137(int var1, class231 var2, class231 var3, int var4) {
      this.field2125 = var1;
      this.field2129 = var2;
      this.field2126 = var3;
      this.field2124 = var4;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "-226635804"
   )
   boolean method2894(int var1, byte[] var2, int var3, boolean var4) {
      class231 var5 = this.field2129;
      synchronized(this.field2129) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2126.method4213() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2126.method4212((long)(var1 * 6));
               this.field2126.method4215(field2128, 0, 6);
               var6 = ((field2128[4] & 255) << 8) + ((field2128[3] & 255) << 16) + (field2128[5] & 255);
               if(var6 <= 0 || (long)var6 > this.field2129.method4213() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2129.method4213() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2128[0] = (byte)(var3 >> 16);
            field2128[1] = (byte)(var3 >> 8);
            field2128[2] = (byte)var3;
            field2128[3] = (byte)(var6 >> 16);
            field2128[4] = (byte)(var6 >> 8);
            field2128[5] = (byte)var6;
            this.field2126.method4212((long)(var1 * 6));
            this.field2126.method4222(field2128, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label145: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field2129.method4212((long)(520 * var6));

                        try {
                           this.field2129.method4215(field2128, 0, 8);
                        } catch (EOFException var16) {
                           break label145;
                        }

                        var14 = (field2128[1] & 255) + ((field2128[0] & 255) << 8);
                        int var11 = (field2128[3] & 255) + ((field2128[2] & 255) << 8);
                        var9 = (field2128[6] & 255) + ((field2128[4] & 255) << 16) + ((field2128[5] & 255) << 8);
                        int var12 = field2128[7] & 255;
                        if(var14 != var1 || var8 != var11 || this.field2125 != var12) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field2129.method4213() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field2129.method4213() + 519L) / 520L);
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

                     field2128[0] = (byte)(var1 >> 8);
                     field2128[1] = (byte)var1;
                     field2128[2] = (byte)(var8 >> 8);
                     field2128[3] = (byte)var8;
                     field2128[4] = (byte)(var9 >> 16);
                     field2128[5] = (byte)(var9 >> 8);
                     field2128[6] = (byte)var9;
                     field2128[7] = (byte)this.field2125;
                     this.field2129.method4212((long)(520 * var6));
                     this.field2129.method4222(field2128, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field2129.method4222(var2, var7, var14);
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
}
