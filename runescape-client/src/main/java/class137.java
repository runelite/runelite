import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ei")
public final class class137 {
   @ObfuscatedName("pz")
   static class224 field2125;
   @ObfuscatedName("w")
   class231 field2126 = null;
   @ObfuscatedName("e")
   class231 field2127 = null;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1110053463
   )
   int field2128;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1180389365
   )
   int field2129 = '\ufde8';
   @ObfuscatedName("m")
   static byte[] field2133 = new byte[520];

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)[B",
      garbageValue = "112"
   )
   public byte[] method2914(int var1) {
      class231 var2 = this.field2126;
      synchronized(this.field2126) {
         try {
            Object var10000;
            if(this.field2127.method4228() < (long)(6 + var1 * 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field2127.method4227((long)(var1 * 6));
               this.field2127.method4238(field2133, 0, 6);
               int var3 = (field2133[2] & 255) + ((field2133[0] & 255) << 16) + ((field2133[1] & 255) << 8);
               int var4 = ((field2133[3] & 255) << 16) + ((field2133[4] & 255) << 8) + (field2133[5] & 255);
               if(var3 < 0 || var3 > this.field2129) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field2126.method4228() / 520L) {
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

                     this.field2126.method4227((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field2126.method4238(field2133, 0, var8 + 8);
                     int var9 = (field2133[1] & 255) + ((field2133[0] & 255) << 8);
                     int var10 = ((field2133[2] & 255) << 8) + (field2133[3] & 255);
                     int var11 = ((field2133[4] & 255) << 16) + ((field2133[5] & 255) << 8) + (field2133[6] & 255);
                     int var12 = field2133[7] & 255;
                     if(var1 == var9 && var7 == var10 && var12 == this.field2128) {
                        if(var11 >= 0 && (long)var11 <= this.field2126.method4228() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field2133[var13 + 8];
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I[BII)Z",
      garbageValue = "-1491607057"
   )
   public boolean method2915(int var1, byte[] var2, int var3) {
      class231 var4 = this.field2126;
      synchronized(this.field2126) {
         if(var3 >= 0 && var3 <= this.field2129) {
            boolean var5 = this.method2916(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2916(var1, var2, var3, false);
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
      garbageValue = "65535"
   )
   boolean method2916(int var1, byte[] var2, int var3, boolean var4) {
      class231 var5 = this.field2126;
      synchronized(this.field2126) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2127.method4228() < (long)(6 * var1 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2127.method4227((long)(var1 * 6));
               this.field2127.method4238(field2133, 0, 6);
               var6 = (field2133[5] & 255) + ((field2133[4] & 255) << 8) + ((field2133[3] & 255) << 16);
               if(var6 <= 0 || (long)var6 > this.field2126.method4228() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2126.method4228() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2133[0] = (byte)(var3 >> 16);
            field2133[1] = (byte)(var3 >> 8);
            field2133[2] = (byte)var3;
            field2133[3] = (byte)(var6 >> 16);
            field2133[4] = (byte)(var6 >> 8);
            field2133[5] = (byte)var6;
            this.field2127.method4227((long)(var1 * 6));
            this.field2127.method4241(field2133, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label144: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field2126.method4227((long)(var6 * 520));

                        try {
                           this.field2126.method4238(field2133, 0, 8);
                        } catch (EOFException var16) {
                           break label144;
                        }

                        var14 = ((field2133[0] & 255) << 8) + (field2133[1] & 255);
                        int var11 = ((field2133[2] & 255) << 8) + (field2133[3] & 255);
                        var9 = ((field2133[4] & 255) << 16) + ((field2133[5] & 255) << 8) + (field2133[6] & 255);
                        int var12 = field2133[7] & 255;
                        if(var14 != var1 || var11 != var8 || var12 != this.field2128) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field2126.method4228() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field2126.method4228() + 519L) / 520L);
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

                     field2133[0] = (byte)(var1 >> 8);
                     field2133[1] = (byte)var1;
                     field2133[2] = (byte)(var8 >> 8);
                     field2133[3] = (byte)var8;
                     field2133[4] = (byte)(var9 >> 16);
                     field2133[5] = (byte)(var9 >> 8);
                     field2133[6] = (byte)var9;
                     field2133[7] = (byte)this.field2128;
                     this.field2126.method4227((long)(var6 * 520));
                     this.field2126.method4241(field2133, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field2126.method4241(var2, var7, var14);
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(CI)C",
      garbageValue = "1437083602"
   )
   static char method2920(char var0) {
      switch(var0) {
      case ' ':
      case '-':
      case '_':
      case ' ':
         return '_';
      case '#':
      case '[':
      case ']':
         return var0;
      case 'À':
      case 'Á':
      case 'Â':
      case 'Ã':
      case 'Ä':
      case 'à':
      case 'á':
      case 'â':
      case 'ã':
      case 'ä':
         return 'a';
      case 'Ç':
      case 'ç':
         return 'c';
      case 'È':
      case 'É':
      case 'Ê':
      case 'Ë':
      case 'è':
      case 'é':
      case 'ê':
      case 'ë':
         return 'e';
      case 'Í':
      case 'Î':
      case 'Ï':
      case 'í':
      case 'î':
      case 'ï':
         return 'i';
      case 'Ñ':
      case 'ñ':
         return 'n';
      case 'Ò':
      case 'Ó':
      case 'Ô':
      case 'Õ':
      case 'Ö':
      case 'ò':
      case 'ó':
      case 'ô':
      case 'õ':
      case 'ö':
         return 'o';
      case 'Ù':
      case 'Ú':
      case 'Û':
      case 'Ü':
      case 'ù':
      case 'ú':
      case 'û':
      case 'ü':
         return 'u';
      case 'ß':
         return 'b';
      case 'ÿ':
      case 'Ÿ':
         return 'y';
      default:
         return Character.toLowerCase(var0);
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
      this.field2129 = var4;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lclass83;I)V",
      garbageValue = "-1399470940"
   )
   static final void method2923(class83 var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class33.field739.length; ++var2) {
         class33.field739[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class33.field739[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = (var3 << 7) + var4;
               class96.field1672[var5] = (class33.field739[var5 + 128] + class33.field739[var5 - 128] + class33.field739[1 + var5] + class33.field739[var5 - 1]) / 4;
            }
         }

         int[] var8 = class33.field739;
         class33.field739 = class96.field1672;
         class96.field1672 = var8;
      }

      if(null != var0) {
         var2 = 0;

         for(var3 = 0; var3 < var0.field1497; ++var3) {
            for(var4 = 0; var4 < var0.field1500; ++var4) {
               if(var0.field1494[var2++] != 0) {
                  var5 = 16 + var4 + var0.field1498;
                  int var6 = 16 + var3 + var0.field1499;
                  int var7 = var5 + (var6 << 7);
                  class33.field739[var7] = 0;
               }
            }
         }
      }

   }
}
