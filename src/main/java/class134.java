import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;

@ObfuscatedName("el")
public final class class134 {
   @ObfuscatedName("x")
   class228 field2084 = null;
   @ObfuscatedName("w")
   static byte[] field2085 = new byte[520];
   @ObfuscatedName("t")
   class228 field2086 = null;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1167077905
   )
   int field2087 = '\ufde8';
   @ObfuscatedName("bd")
   static class80[] field2089;
   @ObfuscatedName("s")
   static int[] field2090;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1585732075
   )
   int field2092;

   @ObfuscatedName("x")
   public boolean method2867(int var1, byte[] var2, int var3) {
      class228 var4 = this.field2084;
      synchronized(this.field2084) {
         if(var3 >= 0 && var3 <= this.field2087) {
            boolean var5 = this.method2870(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2870(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("t")
   boolean method2870(int var1, byte[] var2, int var3, boolean var4) {
      class228 var5 = this.field2084;
      synchronized(this.field2084) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2086.method4156() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2086.method4169((long)(var1 * 6));
               this.field2086.method4155(field2085, 0, 6);
               var6 = (field2085[5] & 255) + ((field2085[3] & 255) << 16) + ((field2085[4] & 255) << 8);
               if(var6 <= 0 || (long)var6 > this.field2084.method4156() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2084.method4156() + 519L) / 520L);
               if(0 == var6) {
                  var6 = 1;
               }
            }

            field2085[0] = (byte)(var3 >> 16);
            field2085[1] = (byte)(var3 >> 8);
            field2085[2] = (byte)var3;
            field2085[3] = (byte)(var6 >> 16);
            field2085[4] = (byte)(var6 >> 8);
            field2085[5] = (byte)var6;
            this.field2086.method4169((long)(6 * var1));
            this.field2086.method4157(field2085, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label143: {
                     int var9 = 0;
                     int var10;
                     if(var4) {
                        this.field2084.method4169((long)(var6 * 520));

                        try {
                           this.field2084.method4155(field2085, 0, 8);
                        } catch (EOFException var14) {
                           break label143;
                        }

                        var10 = (field2085[1] & 255) + ((field2085[0] & 255) << 8);
                        int var11 = ((field2085[2] & 255) << 8) + (field2085[3] & 255);
                        var9 = ((field2085[5] & 255) << 8) + ((field2085[4] & 255) << 16) + (field2085[6] & 255);
                        int var12 = field2085[7] & 255;
                        if(var1 != var10 || var8 != var11 || var12 != this.field2092) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field2084.method4156() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field2084.method4156() + 519L) / 520L);
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

                     field2085[0] = (byte)(var1 >> 8);
                     field2085[1] = (byte)var1;
                     field2085[2] = (byte)(var8 >> 8);
                     field2085[3] = (byte)var8;
                     field2085[4] = (byte)(var9 >> 16);
                     field2085[5] = (byte)(var9 >> 8);
                     field2085[6] = (byte)var9;
                     field2085[7] = (byte)this.field2092;
                     this.field2084.method4169((long)(520 * var6));
                     this.field2084.method4157(field2085, 0, 8);
                     var10 = var3 - var7;
                     if(var10 > 512) {
                        var10 = 512;
                     }

                     this.field2084.method4157(var2, var7, var10);
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

   public class134(int var1, class228 var2, class228 var3, int var4) {
      this.field2092 = var1;
      this.field2084 = var2;
      this.field2086 = var3;
      this.field2087 = var4;
   }

   @ObfuscatedName("w")
   public byte[] method2875(int var1) {
      class228 var2 = this.field2084;
      synchronized(this.field2084) {
         try {
            Object var10000;
            if(this.field2086.method4156() < (long)(6 + 6 * var1)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field2086.method4169((long)(6 * var1));
               this.field2086.method4155(field2085, 0, 6);
               int var3 = ((field2085[1] & 255) << 8) + ((field2085[0] & 255) << 16) + (field2085[2] & 255);
               int var4 = ((field2085[4] & 255) << 8) + ((field2085[3] & 255) << 16) + (field2085[5] & 255);
               if(var3 < 0 || var3 > this.field2087) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field2084.method4156() / 520L) {
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

                     this.field2084.method4169((long)(520 * var4));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field2084.method4155(field2085, 0, var8 + 8);
                     int var9 = ((field2085[0] & 255) << 8) + (field2085[1] & 255);
                     int var10 = (field2085[3] & 255) + ((field2085[2] & 255) << 8);
                     int var11 = (field2085[6] & 255) + ((field2085[5] & 255) << 8) + ((field2085[4] & 255) << 16);
                     int var12 = field2085[7] & 255;
                     if(var9 == var1 && var7 == var10 && this.field2092 == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field2084.method4156() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field2085[8 + var13];
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

   @ObfuscatedName("w")
   public static void method2876() {
      class211.field3139 = new class202();
   }

   @ObfuscatedName("cg")
   static void method2877(class173 var0) {
      if(var0.field2899 == client.field498) {
         client.field499[var0.field2769] = true;
      }

   }

   @ObfuscatedName("w")
   static String method2878(int var0) {
      return "<img=" + var0 + ">";
   }
}
