import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dw")
public final class class116 {
   @ObfuscatedName("s")
   static byte[] field1814 = new byte[520];
   @ObfuscatedName("c")
   class72 field1815 = null;
   @ObfuscatedName("u")
   public static short[][] field1816;
   @ObfuscatedName("f")
   class72 field1817 = null;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 820173471
   )
   int field1818 = '\ufde8';
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 860511929
   )
   int field1820;
   @ObfuscatedName("es")
   static SpritePixels[] field1821;

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "1588981239"
   )
   public byte[] method2171(int var1) {
      class72 var2 = this.field1815;
      synchronized(this.field1815) {
         try {
            Object var10000;
            if(this.field1817.method1346() < (long)(6 * var1 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field1817.method1348((long)(var1 * 6));
               this.field1817.method1357(field1814, 0, 6);
               int var3 = ((field1814[0] & 255) << 16) + ((field1814[1] & 255) << 8) + (field1814[2] & 255);
               int var4 = ((field1814[3] & 255) << 16) + ((field1814[4] & 255) << 8) + (field1814[5] & 255);
               if(var3 < 0 || var3 > this.field1818) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field1815.method1346() / 520L) {
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

                     this.field1815.method1348((long)(520 * var4));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field1815.method1357(field1814, 0, 8 + var8);
                     int var9 = ((field1814[0] & 255) << 8) + (field1814[1] & 255);
                     int var10 = ((field1814[2] & 255) << 8) + (field1814[3] & 255);
                     int var11 = (field1814[6] & 255) + ((field1814[5] & 255) << 8) + ((field1814[4] & 255) << 16);
                     int var12 = field1814[7] & 255;
                     if(var9 == var1 && var7 == var10 && this.field1820 == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field1815.method1346() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field1814[var13 + 8];
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I[BII)Z",
      garbageValue = "-1115969836"
   )
   public boolean method2172(int var1, byte[] var2, int var3) {
      class72 var4 = this.field1815;
      synchronized(this.field1815) {
         if(var3 >= 0 && var3 <= this.field1818) {
            boolean var5 = this.method2173(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2173(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "-25537874"
   )
   boolean method2173(int var1, byte[] var2, int var3, boolean var4) {
      class72 var5 = this.field1815;
      synchronized(this.field1815) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field1817.method1346() < (long)(6 * var1 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field1817.method1348((long)(6 * var1));
               this.field1817.method1357(field1814, 0, 6);
               var6 = ((field1814[3] & 255) << 16) + ((field1814[4] & 255) << 8) + (field1814[5] & 255);
               if(var6 <= 0 || (long)var6 > this.field1815.method1346() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field1815.method1346() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field1814[0] = (byte)(var3 >> 16);
            field1814[1] = (byte)(var3 >> 8);
            field1814[2] = (byte)var3;
            field1814[3] = (byte)(var6 >> 16);
            field1814[4] = (byte)(var6 >> 8);
            field1814[5] = (byte)var6;
            this.field1817.method1348((long)(6 * var1));
            this.field1817.method1350(field1814, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label146: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field1815.method1348((long)(520 * var6));

                        try {
                           this.field1815.method1357(field1814, 0, 8);
                        } catch (EOFException var16) {
                           break label146;
                        }

                        var14 = ((field1814[0] & 255) << 8) + (field1814[1] & 255);
                        int var11 = (field1814[3] & 255) + ((field1814[2] & 255) << 8);
                        var9 = ((field1814[5] & 255) << 8) + ((field1814[4] & 255) << 16) + (field1814[6] & 255);
                        int var12 = field1814[7] & 255;
                        if(var1 != var14 || var8 != var11 || this.field1820 != var12) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field1815.method1346() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field1815.method1346() + 519L) / 520L);
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

                     field1814[0] = (byte)(var1 >> 8);
                     field1814[1] = (byte)var1;
                     field1814[2] = (byte)(var8 >> 8);
                     field1814[3] = (byte)var8;
                     field1814[4] = (byte)(var9 >> 16);
                     field1814[5] = (byte)(var9 >> 8);
                     field1814[6] = (byte)var9;
                     field1814[7] = (byte)this.field1820;
                     this.field1815.method1348((long)(var6 * 520));
                     this.field1815.method1350(field1814, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field1815.method1350(var2, var7, var14);
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
      signature = "(ILclass72;Lclass72;I)V",
      garbageValue = "500000"
   )
   public class116(int var1, class72 var2, class72 var3, int var4) {
      this.field1820 = var1;
      this.field1815 = var2;
      this.field1817 = var3;
      this.field1818 = var4;
   }
}
