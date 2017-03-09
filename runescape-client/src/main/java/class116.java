import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("dd")
public final class class116 {
   @ObfuscatedName("j")
   class72 field1819 = null;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 51656571
   )
   int field1820;
   @ObfuscatedName("x")
   static byte[] field1821 = new byte[520];
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -430473743
   )
   int field1822 = '\ufde8';
   @ObfuscatedName("c")
   class72 field1825 = null;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I[BIZB)Z",
      garbageValue = "-52"
   )
   boolean method2281(int var1, byte[] var2, int var3, boolean var4) {
      class72 var5 = this.field1819;
      synchronized(this.field1819) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field1825.method1458() < (long)(6 + var1 * 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field1825.method1446((long)(var1 * 6));
               this.field1825.method1474(field1821, 0, 6);
               var6 = (field1821[5] & 255) + ((field1821[4] & 255) << 8) + ((field1821[3] & 255) << 16);
               if(var6 <= 0 || (long)var6 > this.field1819.method1458() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field1819.method1458() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field1821[0] = (byte)(var3 >> 16);
            field1821[1] = (byte)(var3 >> 8);
            field1821[2] = (byte)var3;
            field1821[3] = (byte)(var6 >> 16);
            field1821[4] = (byte)(var6 >> 8);
            field1821[5] = (byte)var6;
            this.field1825.method1446((long)(6 * var1));
            this.field1825.method1450(field1821, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label144: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field1819.method1446((long)(520 * var6));

                        try {
                           this.field1819.method1474(field1821, 0, 8);
                        } catch (EOFException var16) {
                           break label144;
                        }

                        var14 = ((field1821[0] & 255) << 8) + (field1821[1] & 255);
                        int var11 = ((field1821[2] & 255) << 8) + (field1821[3] & 255);
                        var9 = ((field1821[5] & 255) << 8) + ((field1821[4] & 255) << 16) + (field1821[6] & 255);
                        int var12 = field1821[7] & 255;
                        if(var14 != var1 || var8 != var11 || var12 != this.field1820) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field1819.method1458() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field1819.method1458() + 519L) / 520L);
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

                     field1821[0] = (byte)(var1 >> 8);
                     field1821[1] = (byte)var1;
                     field1821[2] = (byte)(var8 >> 8);
                     field1821[3] = (byte)var8;
                     field1821[4] = (byte)(var9 >> 16);
                     field1821[5] = (byte)(var9 >> 8);
                     field1821[6] = (byte)var9;
                     field1821[7] = (byte)this.field1820;
                     this.field1819.method1446((long)(520 * var6));
                     this.field1819.method1450(field1821, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field1819.method1450(var2, var7, var14);
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1843659402"
   )
   public byte[] method2282(int var1) {
      class72 var2 = this.field1819;
      synchronized(this.field1819) {
         try {
            Object var10000;
            if(this.field1825.method1458() < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field1825.method1446((long)(6 * var1));
               this.field1825.method1474(field1821, 0, 6);
               int var3 = (field1821[2] & 255) + ((field1821[1] & 255) << 8) + ((field1821[0] & 255) << 16);
               int var4 = ((field1821[4] & 255) << 8) + ((field1821[3] & 255) << 16) + (field1821[5] & 255);
               if(var3 < 0 || var3 > this.field1822) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field1819.method1458() / 520L) {
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

                     this.field1819.method1446((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field1819.method1474(field1821, 0, var8 + 8);
                     int var9 = ((field1821[0] & 255) << 8) + (field1821[1] & 255);
                     int var10 = ((field1821[2] & 255) << 8) + (field1821[3] & 255);
                     int var11 = ((field1821[5] & 255) << 8) + ((field1821[4] & 255) << 16) + (field1821[6] & 255);
                     int var12 = field1821[7] & 255;
                     if(var9 == var1 && var10 == var7 && this.field1820 == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field1819.method1458() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field1821[8 + var13];
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I[BIB)Z",
      garbageValue = "-88"
   )
   public boolean method2283(int var1, byte[] var2, int var3) {
      class72 var4 = this.field1819;
      synchronized(this.field1819) {
         if(var3 >= 0 && var3 <= this.field1822) {
            boolean var5 = this.method2281(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2281(var1, var2, var3, false);
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
      this.field1819 = var2;
      this.field1825 = var3;
      this.field1822 = var4;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "1843924518"
   )
   static String method2288(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }
}
