import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("es")
public final class class137 {
   @ObfuscatedName("s")
   static byte[] field2108 = new byte[520];
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1903457247
   )
   int field2109;
   @ObfuscatedName("t")
   class231 field2110 = null;
   @ObfuscatedName("qk")
   @ObfuscatedGetter(
      intValue = 223308371
   )
   protected static int field2111;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 9991863
   )
   int field2112 = '\ufde8';
   @ObfuscatedName("af")
   static ModIcon[] field2114;
   @ObfuscatedName("z")
   class231 field2115 = null;
   @ObfuscatedName("m")
   public static short[] field2121;

   @ObfuscatedSignature(
      signature = "(ILclass231;Lclass231;I)V",
      garbageValue = "500000"
   )
   public class137(int var1, class231 var2, class231 var3, int var4) {
      this.field2109 = var1;
      this.field2115 = var2;
      this.field2110 = var3;
      this.field2112 = var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LWorld;LWorld;IZIZI)I",
      garbageValue = "-520342304"
   )
   static int method2860(World var0, World var1, int var2, boolean var3, int var4, boolean var5) {
      int var6 = class129.method2814(var0, var1, var2, var3);
      if(var6 != 0) {
         return var3?-var6:var6;
      } else if(var4 == -1) {
         return 0;
      } else {
         int var7 = class129.method2814(var0, var1, var4, var5);
         return var5?-var7:var7;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "-1272031471"
   )
   boolean method2861(int var1, byte[] var2, int var3, boolean var4) {
      class231 var5 = this.field2115;
      synchronized(this.field2115) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2110.method4143() < (long)(6 + 6 * var1)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2110.method4142((long)(var1 * 6));
               this.field2110.method4145(field2108, 0, 6);
               var6 = (field2108[5] & 255) + ((field2108[3] & 255) << 16) + ((field2108[4] & 255) << 8);
               if(var6 <= 0 || (long)var6 > this.field2115.method4143() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2115.method4143() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2108[0] = (byte)(var3 >> 16);
            field2108[1] = (byte)(var3 >> 8);
            field2108[2] = (byte)var3;
            field2108[3] = (byte)(var6 >> 16);
            field2108[4] = (byte)(var6 >> 8);
            field2108[5] = (byte)var6;
            this.field2110.method4142((long)(6 * var1));
            this.field2110.method4147(field2108, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label145: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field2115.method4142((long)(var6 * 520));

                        try {
                           this.field2115.method4145(field2108, 0, 8);
                        } catch (EOFException var16) {
                           break label145;
                        }

                        var14 = ((field2108[0] & 255) << 8) + (field2108[1] & 255);
                        int var11 = ((field2108[2] & 255) << 8) + (field2108[3] & 255);
                        var9 = ((field2108[5] & 255) << 8) + ((field2108[4] & 255) << 16) + (field2108[6] & 255);
                        int var12 = field2108[7] & 255;
                        if(var14 != var1 || var11 != var8 || this.field2109 != var12) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field2115.method4143() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field2115.method4143() + 519L) / 520L);
                        if(var9 == 0) {
                           ++var9;
                        }

                        if(var6 == var9) {
                           ++var9;
                        }
                     }

                     if(var3 - var7 <= 512) {
                        var9 = 0;
                     }

                     field2108[0] = (byte)(var1 >> 8);
                     field2108[1] = (byte)var1;
                     field2108[2] = (byte)(var8 >> 8);
                     field2108[3] = (byte)var8;
                     field2108[4] = (byte)(var9 >> 16);
                     field2108[5] = (byte)(var9 >> 8);
                     field2108[6] = (byte)var9;
                     field2108[7] = (byte)this.field2109;
                     this.field2115.method4142((long)(var6 * 520));
                     this.field2115.method4147(field2108, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field2115.method4147(var2, var7, var14);
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I[BII)Z",
      garbageValue = "506422343"
   )
   public boolean method2863(int var1, byte[] var2, int var3) {
      class231 var4 = this.field2115;
      synchronized(this.field2115) {
         if(var3 >= 0 && var3 <= this.field2112) {
            boolean var5 = this.method2861(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2861(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-622516534"
   )
   public byte[] method2868(int var1) {
      class231 var2 = this.field2115;
      synchronized(this.field2115) {
         try {
            Object var10000;
            if(this.field2110.method4143() < (long)(6 + 6 * var1)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field2110.method4142((long)(6 * var1));
               this.field2110.method4145(field2108, 0, 6);
               int var3 = ((field2108[1] & 255) << 8) + ((field2108[0] & 255) << 16) + (field2108[2] & 255);
               int var4 = ((field2108[3] & 255) << 16) + ((field2108[4] & 255) << 8) + (field2108[5] & 255);
               if(var3 < 0 || var3 > this.field2112) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field2115.method4143() / 520L) {
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

                     this.field2115.method4142((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field2115.method4145(field2108, 0, 8 + var8);
                     int var9 = ((field2108[0] & 255) << 8) + (field2108[1] & 255);
                     int var10 = ((field2108[2] & 255) << 8) + (field2108[3] & 255);
                     int var11 = ((field2108[4] & 255) << 16) + ((field2108[5] & 255) << 8) + (field2108[6] & 255);
                     int var12 = field2108[7] & 255;
                     if(var1 == var9 && var7 == var10 && var12 == this.field2109) {
                        if(var11 >= 0 && (long)var11 <= this.field2115.method4143() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field2108[8 + var13];
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
}
