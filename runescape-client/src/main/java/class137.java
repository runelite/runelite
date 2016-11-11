import java.io.EOFException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
public final class class137 {
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1288527109
   )
   int field2124 = '\ufde8';
   @ObfuscatedName("e")
   class231 field2125 = null;
   @ObfuscatedName("g")
   class231 field2126 = null;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1571162515
   )
   int field2127;
   @ObfuscatedName("ex")
   static SpritePixels[] field2130;
   @ObfuscatedName("h")
   static byte[] field2131 = new byte[520];

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I[BIZB)Z",
      garbageValue = "-121"
   )
   boolean method2897(int var1, byte[] var2, int var3, boolean var4) {
      class231 var5 = this.field2125;
      synchronized(this.field2125) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2126.method4185() < (long)(6 + var1 * 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2126.method4174((long)(6 * var1));
               this.field2126.method4177(field2131, 0, 6);
               var6 = ((field2131[4] & 255) << 8) + ((field2131[3] & 255) << 16) + (field2131[5] & 255);
               if(var6 <= 0 || (long)var6 > this.field2125.method4185() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2125.method4185() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2131[0] = (byte)(var3 >> 16);
            field2131[1] = (byte)(var3 >> 8);
            field2131[2] = (byte)var3;
            field2131[3] = (byte)(var6 >> 16);
            field2131[4] = (byte)(var6 >> 8);
            field2131[5] = (byte)var6;
            this.field2126.method4174((long)(var1 * 6));
            this.field2126.method4179(field2131, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label143: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field2125.method4174((long)(var6 * 520));

                        try {
                           this.field2125.method4177(field2131, 0, 8);
                        } catch (EOFException var16) {
                           break label143;
                        }

                        var14 = ((field2131[0] & 255) << 8) + (field2131[1] & 255);
                        int var11 = (field2131[3] & 255) + ((field2131[2] & 255) << 8);
                        var9 = (field2131[6] & 255) + ((field2131[5] & 255) << 8) + ((field2131[4] & 255) << 16);
                        int var12 = field2131[7] & 255;
                        if(var14 != var1 || var11 != var8 || this.field2127 != var12) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field2125.method4185() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field2125.method4185() + 519L) / 520L);
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

                     field2131[0] = (byte)(var1 >> 8);
                     field2131[1] = (byte)var1;
                     field2131[2] = (byte)(var8 >> 8);
                     field2131[3] = (byte)var8;
                     field2131[4] = (byte)(var9 >> 16);
                     field2131[5] = (byte)(var9 >> 8);
                     field2131[6] = (byte)var9;
                     field2131[7] = (byte)this.field2127;
                     this.field2125.method4174((long)(520 * var6));
                     this.field2125.method4179(field2131, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field2125.method4179(var2, var7, var14);
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
      signature = "(ILclass231;Lclass231;I)V",
      garbageValue = "500000"
   )
   public class137(int var1, class231 var2, class231 var3, int var4) {
      this.field2127 = var1;
      this.field2125 = var2;
      this.field2126 = var3;
      this.field2124 = var4;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "-20421137"
   )
   public byte[] method2899(int var1) {
      class231 var2 = this.field2125;
      synchronized(this.field2125) {
         try {
            Object var10000;
            if(this.field2126.method4185() < (long)(6 + 6 * var1)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field2126.method4174((long)(var1 * 6));
               this.field2126.method4177(field2131, 0, 6);
               int var3 = (field2131[2] & 255) + ((field2131[1] & 255) << 8) + ((field2131[0] & 255) << 16);
               int var4 = (field2131[5] & 255) + ((field2131[4] & 255) << 8) + ((field2131[3] & 255) << 16);
               if(var3 < 0 || var3 > this.field2124) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field2125.method4185() / 520L) {
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

                     this.field2125.method4174((long)(520 * var4));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field2125.method4177(field2131, 0, 8 + var8);
                     int var9 = ((field2131[0] & 255) << 8) + (field2131[1] & 255);
                     int var10 = ((field2131[2] & 255) << 8) + (field2131[3] & 255);
                     int var11 = (field2131[6] & 255) + ((field2131[5] & 255) << 8) + ((field2131[4] & 255) << 16);
                     int var12 = field2131[7] & 255;
                     if(var9 == var1 && var7 == var10 && this.field2127 == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field2125.method4185() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field2131[var13 + 8];
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I[BIB)Z",
      garbageValue = "62"
   )
   public boolean method2901(int var1, byte[] var2, int var3) {
      class231 var4 = this.field2125;
      synchronized(this.field2125) {
         if(var3 >= 0 && var3 <= this.field2124) {
            boolean var5 = this.method2897(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method2897(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "100"
   )
   static boolean method2907(String var0) {
      if(null == var0) {
         return false;
      } else {
         try {
            new URL(var0);
            return true;
         } catch (MalformedURLException var2) {
            return false;
         }
      }
   }

   @ObfuscatedName("dq")
   @ObfuscatedSignature(
      signature = "(LWidget;I)Z",
      garbageValue = "-1191855296"
   )
   static final boolean method2908(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field355 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field574.method3525(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field574.method3514(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field574.method3515(false);
         }

         if(var1 == 325) {
            Client.field574.method3515(true);
         }

         if(var1 == 326) {
            Client.field378.method2801(107);
            Client.field574.method3532(Client.field378);
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Ljava/lang/String;",
      garbageValue = "2051656329"
   )
   static String method2909(int var0) {
      return "<col=" + Integer.toHexString(var0) + ">";
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "669833982"
   )
   static void method2910(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var2 + var3) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(null == var6 || null != var0[var8] && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method2910(var0, var1, var2, var5 - 1);
         method2910(var0, var1, var5 + 1, var3);
      }

   }
}
