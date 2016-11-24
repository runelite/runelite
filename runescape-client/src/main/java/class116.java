import java.awt.Component;
import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dy")
public final class class116 {
   @ObfuscatedName("d")
   class72 field1817 = null;
   @ObfuscatedName("m")
   class72 field1818 = null;
   @ObfuscatedName("n")
   static byte[] field1819 = new byte[520];
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -786817185
   )
   int field1820;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1869610513
   )
   int field1821 = '\ufde8';
   @ObfuscatedName("p")
   public static short[][] field1823;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I[BII)Z",
      garbageValue = "1660500226"
   )
   public boolean method2294(int var1, byte[] var2, int var3) {
      class72 var4 = this.field1818;
      synchronized(this.field1818) {
         if(var3 >= 0 && var3 <= this.field1821) {
            boolean var5 = this.method2296(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2296(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(ILclass72;Lclass72;I)V",
      garbageValue = "500000"
   )
   public class116(int var1, class72 var2, class72 var3, int var4) {
      this.field1820 = var1;
      this.field1818 = var2;
      this.field1817 = var3;
      this.field1821 = var4;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I[BIZI)Z",
      garbageValue = "2115946887"
   )
   boolean method2296(int var1, byte[] var2, int var3, boolean var4) {
      class72 var5 = this.field1818;
      synchronized(this.field1818) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field1817.method1407() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field1817.method1425((long)(var1 * 6));
               this.field1817.method1409(field1819, 0, 6);
               var6 = (field1819[5] & 255) + ((field1819[3] & 255) << 16) + ((field1819[4] & 255) << 8);
               if(var6 <= 0 || (long)var6 > this.field1818.method1407() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field1818.method1407() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field1819[0] = (byte)(var3 >> 16);
            field1819[1] = (byte)(var3 >> 8);
            field1819[2] = (byte)var3;
            field1819[3] = (byte)(var6 >> 16);
            field1819[4] = (byte)(var6 >> 8);
            field1819[5] = (byte)var6;
            this.field1817.method1425((long)(6 * var1));
            this.field1817.method1419(field1819, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label145: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field1818.method1425((long)(520 * var6));

                        try {
                           this.field1818.method1409(field1819, 0, 8);
                        } catch (EOFException var16) {
                           break label145;
                        }

                        var14 = ((field1819[0] & 255) << 8) + (field1819[1] & 255);
                        int var11 = ((field1819[2] & 255) << 8) + (field1819[3] & 255);
                        var9 = ((field1819[5] & 255) << 8) + ((field1819[4] & 255) << 16) + (field1819[6] & 255);
                        int var12 = field1819[7] & 255;
                        if(var14 != var1 || var8 != var11 || this.field1820 != var12) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field1818.method1407() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field1818.method1407() + 519L) / 520L);
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

                     field1819[0] = (byte)(var1 >> 8);
                     field1819[1] = (byte)var1;
                     field1819[2] = (byte)(var8 >> 8);
                     field1819[3] = (byte)var8;
                     field1819[4] = (byte)(var9 >> 16);
                     field1819[5] = (byte)(var9 >> 8);
                     field1819[6] = (byte)var9;
                     field1819[7] = (byte)this.field1820;
                     this.field1818.method1425((long)(var6 * 520));
                     this.field1818.method1419(field1819, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field1818.method1419(var2, var7, var14);
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "2133784098"
   )
   public byte[] method2297(int var1) {
      class72 var2 = this.field1818;
      synchronized(this.field1818) {
         try {
            Object var10000;
            if(this.field1817.method1407() < (long)(6 + 6 * var1)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field1817.method1425((long)(6 * var1));
               this.field1817.method1409(field1819, 0, 6);
               int var3 = ((field1819[1] & 255) << 8) + ((field1819[0] & 255) << 16) + (field1819[2] & 255);
               int var4 = (field1819[5] & 255) + ((field1819[4] & 255) << 8) + ((field1819[3] & 255) << 16);
               if(var3 < 0 || var3 > this.field1821) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field1818.method1407() / 520L) {
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

                     this.field1818.method1425((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field1818.method1409(field1819, 0, var8 + 8);
                     int var9 = ((field1819[0] & 255) << 8) + (field1819[1] & 255);
                     int var10 = (field1819[3] & 255) + ((field1819[2] & 255) << 8);
                     int var11 = ((field1819[4] & 255) << 16) + ((field1819[5] & 255) << 8) + (field1819[6] & 255);
                     int var12 = field1819[7] & 255;
                     if(var1 == var9 && var10 == var7 && var12 == this.field1820) {
                        if(var11 >= 0 && (long)var11 <= this.field1818.method1407() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field1819[8 + var13];
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
      signature = "(IILjava/awt/Component;I)LBufferProvider;",
      garbageValue = "-1419072451"
   )
   public static BufferProvider method2298(int var0, int var1, Component var2) {
      try {
         MainBufferProvider var3 = new MainBufferProvider();
         var3.init(var0, var1, var2);
         return var3;
      } catch (Throwable var5) {
         SecondaryBufferProvider var4 = new SecondaryBufferProvider();
         var4.init(var0, var1, var2);
         return var4;
      }
   }
}
