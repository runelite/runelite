import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public final class class137 {
   @ObfuscatedName("a")
   static byte[] field2144 = new byte[520];
   @ObfuscatedName("o")
   static int[] field2145;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -812328737
   )
   int field2147;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1671259467
   )
   int field2148 = '\ufde8';
   @ObfuscatedName("i")
   static byte[][][] field2149;
   @ObfuscatedName("d")
   class231 field2150 = null;
   @ObfuscatedName("v")
   class231 field2152 = null;
   @ObfuscatedName("n")
   static SpritePixels field2153;

   @ObfuscatedSignature(
      signature = "(ILclass231;Lclass231;I)V",
      garbageValue = "500000"
   )
   public class137(int var1, class231 var2, class231 var3, int var4) {
      this.field2147 = var1;
      this.field2152 = var2;
      this.field2150 = var3;
      this.field2148 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I[BII)Z",
      garbageValue = "-2021648900"
   )
   public boolean method2901(int var1, byte[] var2, int var3) {
      class231 var4 = this.field2152;
      synchronized(this.field2152) {
         if(var3 >= 0 && var3 <= this.field2148) {
            boolean var5 = this.method2902(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2902(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "408364251"
   )
   boolean method2902(int var1, byte[] var2, int var3, boolean var4) {
      class231 var5 = this.field2152;
      synchronized(this.field2152) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2150.method4201() < (long)(6 + 6 * var1)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2150.method4209((long)(var1 * 6));
               this.field2150.method4203(field2144, 0, 6);
               var6 = ((field2144[3] & 255) << 16) + ((field2144[4] & 255) << 8) + (field2144[5] & 255);
               if(var6 <= 0 || (long)var6 > this.field2152.method4201() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2152.method4201() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2144[0] = (byte)(var3 >> 16);
            field2144[1] = (byte)(var3 >> 8);
            field2144[2] = (byte)var3;
            field2144[3] = (byte)(var6 >> 16);
            field2144[4] = (byte)(var6 >> 8);
            field2144[5] = (byte)var6;
            this.field2150.method4209((long)(var1 * 6));
            this.field2150.method4214(field2144, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label146: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field2152.method4209((long)(520 * var6));

                        try {
                           this.field2152.method4203(field2144, 0, 8);
                        } catch (EOFException var16) {
                           break label146;
                        }

                        var14 = (field2144[1] & 255) + ((field2144[0] & 255) << 8);
                        int var11 = (field2144[3] & 255) + ((field2144[2] & 255) << 8);
                        var9 = (field2144[6] & 255) + ((field2144[4] & 255) << 16) + ((field2144[5] & 255) << 8);
                        int var12 = field2144[7] & 255;
                        if(var1 != var14 || var11 != var8 || this.field2147 != var12) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field2152.method4201() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field2152.method4201() + 519L) / 520L);
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

                     field2144[0] = (byte)(var1 >> 8);
                     field2144[1] = (byte)var1;
                     field2144[2] = (byte)(var8 >> 8);
                     field2144[3] = (byte)var8;
                     field2144[4] = (byte)(var9 >> 16);
                     field2144[5] = (byte)(var9 >> 8);
                     field2144[6] = (byte)var9;
                     field2144[7] = (byte)this.field2147;
                     this.field2152.method4209((long)(520 * var6));
                     this.field2152.method4214(field2144, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field2152.method4214(var2, var7, var14);
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "2065679778"
   )
   public byte[] method2903(int var1) {
      class231 var2 = this.field2152;
      synchronized(this.field2152) {
         try {
            Object var10000;
            if(this.field2150.method4201() < (long)(6 + var1 * 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field2150.method4209((long)(var1 * 6));
               this.field2150.method4203(field2144, 0, 6);
               int var3 = ((field2144[0] & 255) << 16) + ((field2144[1] & 255) << 8) + (field2144[2] & 255);
               int var4 = (field2144[5] & 255) + ((field2144[3] & 255) << 16) + ((field2144[4] & 255) << 8);
               if(var3 < 0 || var3 > this.field2148) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field2152.method4201() / 520L) {
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

                     this.field2152.method4209((long)(520 * var4));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field2152.method4203(field2144, 0, 8 + var8);
                     int var9 = ((field2144[0] & 255) << 8) + (field2144[1] & 255);
                     int var10 = ((field2144[2] & 255) << 8) + (field2144[3] & 255);
                     int var11 = ((field2144[5] & 255) << 8) + ((field2144[4] & 255) << 16) + (field2144[6] & 255);
                     int var12 = field2144[7] & 255;
                     if(var9 == var1 && var10 == var7 && this.field2147 == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field2152.method4201() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field2144[8 + var13];
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "56"
   )
   static final void method2908() {
      if(BufferProvider.field1475 != null) {
         BufferProvider.field1475.method3039();
         BufferProvider.field1475 = null;
      }

      class14.method171();
      class16.region.method2083();

      for(int var0 = 0; var0 < 4; ++var0) {
         Client.collisionMaps[var0].method2417();
      }

      System.gc();
      class186.field3016 = 1;
      class186.field3017 = null;
      class186.field3019 = -1;
      class186.field3022 = -1;
      class177.field2951 = 0;
      class186.field3020 = false;
      class21.field585 = 2;
      Client.field496 = -1;
      Client.field426 = false;

      for(class24 var1 = (class24)class24.field629.method3854(); null != var1; var1 = (class24)class24.field629.method3869()) {
         if(null != var1.field617) {
            GameObject.field1759.method1188(var1.field617);
            var1.field617 = null;
         }

         if(var1.field619 != null) {
            GameObject.field1759.method1188(var1.field619);
            var1.field619 = null;
         }
      }

      class24.field629.method3848();
      XItemContainer.setGameState(10);
   }
}
