import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("eg")
public final class class133 {
   @ObfuscatedName("a")
   class227 field2075 = null;
   @ObfuscatedName("l")
   class227 field2076 = null;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2094936039
   )
   int field2077;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 259860957
   )
   int field2078 = '\ufde8';
   @ObfuscatedName("h")
   public static short[][] field2079;
   @ObfuscatedName("j")
   static byte[] field2080 = new byte[520];

   @ObfuscatedName("l")
   public boolean method2792(int var1, byte[] var2, int var3) {
      class227 var4 = this.field2076;
      synchronized(this.field2076) {
         if(var3 >= 0 && var3 <= this.field2078) {
            boolean var5 = this.method2794(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2794(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("j")
   public byte[] method2793(int var1) {
      class227 var2 = this.field2076;
      synchronized(this.field2076) {
         try {
            Object var10000;
            if(this.field2075.method4083() < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field2075.method4084((long)(6 * var1));
               this.field2075.method4085(field2080, 0, 6);
               int var3 = (field2080[2] & 255) + ((field2080[1] & 255) << 8) + ((field2080[0] & 255) << 16);
               int var4 = ((field2080[3] & 255) << 16) + ((field2080[4] & 255) << 8) + (field2080[5] & 255);
               if(var3 < 0 || var3 > this.field2078) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field2076.method4083() / 520L) {
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

                     this.field2076.method4084((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field2076.method4085(field2080, 0, var8 + 8);
                     int var9 = (field2080[1] & 255) + ((field2080[0] & 255) << 8);
                     int var10 = (field2080[3] & 255) + ((field2080[2] & 255) << 8);
                     int var11 = (field2080[6] & 255) + ((field2080[4] & 255) << 16) + ((field2080[5] & 255) << 8);
                     int var12 = field2080[7] & 255;
                     if(var1 == var9 && var7 == var10 && var12 == this.field2077) {
                        if(var11 >= 0 && (long)var11 <= this.field2076.method4083() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field2080[var13 + 8];
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

                  byte[] var17 = var5;
                  return var17;
               }
            }
         } catch (IOException var15) {
            return null;
         }
      }
   }

   public class133(int var1, class227 var2, class227 var3, int var4) {
      this.field2077 = var1;
      this.field2076 = var2;
      this.field2075 = var3;
      this.field2078 = var4;
   }

   @ObfuscatedName("a")
   boolean method2794(int var1, byte[] var2, int var3, boolean var4) {
      class227 var5 = this.field2076;
      synchronized(this.field2076) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2075.method4083() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2075.method4084((long)(6 * var1));
               this.field2075.method4085(field2080, 0, 6);
               var6 = (field2080[5] & 255) + ((field2080[3] & 255) << 16) + ((field2080[4] & 255) << 8);
               if(var6 <= 0 || (long)var6 > this.field2076.method4083() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2076.method4083() + 519L) / 520L);
               if(0 == var6) {
                  var6 = 1;
               }
            }

            field2080[0] = (byte)(var3 >> 16);
            field2080[1] = (byte)(var3 >> 8);
            field2080[2] = (byte)var3;
            field2080[3] = (byte)(var6 >> 16);
            field2080[4] = (byte)(var6 >> 8);
            field2080[5] = (byte)var6;
            this.field2075.method4084((long)(var1 * 6));
            this.field2075.method4087(field2080, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label135: {
                     int var9 = 0;
                     int var10;
                     if(var4) {
                        label154: {
                           this.field2076.method4084((long)(var6 * 520));

                           try {
                              this.field2076.method4085(field2080, 0, 8);
                           } catch (EOFException var14) {
                              break label135;
                           }

                           var10 = (field2080[1] & 255) + ((field2080[0] & 255) << 8);
                           int var11 = ((field2080[2] & 255) << 8) + (field2080[3] & 255);
                           var9 = ((field2080[4] & 255) << 16) + ((field2080[5] & 255) << 8) + (field2080[6] & 255);
                           int var12 = field2080[7] & 255;
                           if(var1 == var10 && var8 == var11 && this.field2077 == var12) {
                              if(var9 >= 0 && (long)var9 <= this.field2076.method4083() / 520L) {
                                 break label154;
                              }

                              var10000 = false;
                              return var10000;
                           }

                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(0 == var9) {
                        var4 = false;
                        var9 = (int)((this.field2076.method4083() + 519L) / 520L);
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

                     field2080[0] = (byte)(var1 >> 8);
                     field2080[1] = (byte)var1;
                     field2080[2] = (byte)(var8 >> 8);
                     field2080[3] = (byte)var8;
                     field2080[4] = (byte)(var9 >> 16);
                     field2080[5] = (byte)(var9 >> 8);
                     field2080[6] = (byte)var9;
                     field2080[7] = (byte)this.field2077;
                     this.field2076.method4084((long)(520 * var6));
                     this.field2076.method4087(field2080, 0, 8);
                     var10 = var3 - var7;
                     if(var10 > 512) {
                        var10 = 512;
                     }

                     this.field2076.method4087(var2, var7, var10);
                     var7 += var10;
                     var6 = var9;
                     ++var8;
                     continue;
                  }
               }

               var10000 = true;
               return var10000;
            }
         } catch (IOException var15) {
            return false;
         }
      }
   }

   @ObfuscatedName("i")
   public static int method2801(int var0) {
      int var1 = 0;
      if(var0 < 0 || var0 >= 65536) {
         var0 >>>= 16;
         var1 += 16;
      }

      if(var0 >= 256) {
         var0 >>>= 8;
         var1 += 8;
      }

      if(var0 >= 16) {
         var0 >>>= 4;
         var1 += 4;
      }

      if(var0 >= 4) {
         var0 >>>= 2;
         var1 += 2;
      }

      if(var0 >= 1) {
         var0 >>>= 1;
         ++var1;
      }

      return var1 + var0;
   }
}
