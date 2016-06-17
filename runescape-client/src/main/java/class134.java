import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public final class class134 {
   @ObfuscatedName("g")
   class228 field2053 = null;
   @ObfuscatedName("j")
   class228 field2054 = null;
   @ObfuscatedName("b")
   static byte[] field2055 = new byte[520];
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -676073531
   )
   int field2056 = '\ufde8';
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1969169109
   )
   int field2057;

   @ObfuscatedSignature(
      signature = "(ILclass228;Lclass228;I)V",
      garbageValue = "500000"
   )
   public class134(int var1, class228 var2, class228 var3, int var4) {
      this.field2057 = var1;
      this.field2053 = var2;
      this.field2054 = var3;
      this.field2056 = var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I[BIB)Z",
      garbageValue = "-19"
   )
   public boolean method2898(int var1, byte[] var2, int var3) {
      class228 var4 = this.field2053;
      synchronized(this.field2053) {
         if(var3 >= 0 && var3 <= this.field2056) {
            boolean var5 = this.method2899(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2899(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I[BIZB)Z",
      garbageValue = "69"
   )
   boolean method2899(int var1, byte[] var2, int var3, boolean var4) {
      class228 var5 = this.field2053;
      synchronized(this.field2053) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2054.method4132() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2054.method4146((long)(6 * var1));
               this.field2054.method4135(field2055, 0, 6);
               var6 = (field2055[5] & 255) + ((field2055[4] & 255) << 8) + ((field2055[3] & 255) << 16);
               if(var6 <= 0 || (long)var6 > this.field2053.method4132() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2053.method4132() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2055[0] = (byte)(var3 >> 16);
            field2055[1] = (byte)(var3 >> 8);
            field2055[2] = (byte)var3;
            field2055[3] = (byte)(var6 >> 16);
            field2055[4] = (byte)(var6 >> 8);
            field2055[5] = (byte)var6;
            this.field2054.method4146((long)(var1 * 6));
            this.field2054.method4137(field2055, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label145: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field2053.method4146((long)(var6 * 520));

                        try {
                           this.field2053.method4135(field2055, 0, 8);
                        } catch (EOFException var16) {
                           break label145;
                        }

                        var14 = ((field2055[0] & 255) << 8) + (field2055[1] & 255);
                        int var11 = ((field2055[2] & 255) << 8) + (field2055[3] & 255);
                        var9 = (field2055[6] & 255) + ((field2055[5] & 255) << 8) + ((field2055[4] & 255) << 16);
                        int var12 = field2055[7] & 255;
                        if(var1 != var14 || var11 != var8 || this.field2057 != var12) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field2053.method4132() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field2053.method4132() + 519L) / 520L);
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

                     field2055[0] = (byte)(var1 >> 8);
                     field2055[1] = (byte)var1;
                     field2055[2] = (byte)(var8 >> 8);
                     field2055[3] = (byte)var8;
                     field2055[4] = (byte)(var9 >> 16);
                     field2055[5] = (byte)(var9 >> 8);
                     field2055[6] = (byte)var9;
                     field2055[7] = (byte)this.field2057;
                     this.field2053.method4146((long)(var6 * 520));
                     this.field2053.method4137(field2055, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field2053.method4137(var2, var7, var14);
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-1393191092"
   )
   public byte[] method2902(int var1) {
      class228 var2 = this.field2053;
      synchronized(this.field2053) {
         try {
            Object var10000;
            if(this.field2054.method4132() < (long)(6 + 6 * var1)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field2054.method4146((long)(6 * var1));
               this.field2054.method4135(field2055, 0, 6);
               int var3 = (field2055[2] & 255) + ((field2055[1] & 255) << 8) + ((field2055[0] & 255) << 16);
               int var4 = ((field2055[4] & 255) << 8) + ((field2055[3] & 255) << 16) + (field2055[5] & 255);
               if(var3 < 0 || var3 > this.field2056) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field2053.method4132() / 520L) {
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

                     this.field2053.method4146((long)(520 * var4));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field2053.method4135(field2055, 0, var8 + 8);
                     int var9 = ((field2055[0] & 255) << 8) + (field2055[1] & 255);
                     int var10 = (field2055[3] & 255) + ((field2055[2] & 255) << 8);
                     int var11 = ((field2055[5] & 255) << 8) + ((field2055[4] & 255) << 16) + (field2055[6] & 255);
                     int var12 = field2055[7] & 255;
                     if(var9 == var1 && var10 == var7 && var12 == this.field2057) {
                        if(var11 >= 0 && (long)var11 <= this.field2053.method4132() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field2055[var13 + 8];
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

   @ObfuscatedName("dy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1589314906"
   )
   static void method2905(String var0) {
      client.field563 = var0;

      try {
         String var1 = client.field284.getParameter(class190.field3061.field3064);
         String var2 = client.field284.getParameter(class190.field3049.field3064);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            var3 = var3 + "; Expires=" + class85.method1920(class90.method2090() + 94608000000L) + "; Max-Age=" + 94608000L;
         }

         class132.method2877(client.field284, "document.cookie=\"" + var3 + "\"");
      } catch (Throwable var4) {
         ;
      }

   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "780753941"
   )
   static final void method2906() {
      for(class6 var0 = (class6)client.field422.method3844(); var0 != null; var0 = (class6)client.field422.method3834()) {
         if(var0.field93 == class144.field2193 && client.field296 <= var0.field99) {
            if(client.field296 >= var0.field118) {
               if(var0.field106 > 0) {
                  class34 var1 = client.field326[var0.field106 - 1];
                  if(var1 != null && var1.field813 >= 0 && var1.field813 < 13312 && var1.field791 >= 0 && var1.field791 < 13312) {
                     var0.method81(var1.field813, var1.field791, class108.method2413(var1.field813, var1.field791, var0.field93) - var0.field117, client.field296);
                  }
               }

               if(var0.field106 < 0) {
                  int var2 = -var0.field106 - 1;
                  class2 var3;
                  if(var2 == client.field430) {
                     var3 = class153.field2262;
                  } else {
                     var3 = client.field410[var2];
                  }

                  if(null != var3 && var3.field813 >= 0 && var3.field813 < 13312 && var3.field791 >= 0 && var3.field791 < 13312) {
                     var0.method81(var3.field813, var3.field791, class108.method2413(var3.field813, var3.field791, var0.field93) - var0.field117, client.field296);
                  }
               }

               var0.method82(client.field538);
               class150.field2230.method1936(class144.field2193, (int)var0.field92, (int)var0.field105, (int)var0.field104, 60, var0, var0.field112, -1, false);
            }
         } else {
            var0.method3916();
         }
      }

   }
}
