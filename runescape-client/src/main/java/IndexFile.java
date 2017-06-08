import java.io.EOFException;
import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
@Implements("IndexFile")
public final class IndexFile {
   @ObfuscatedName("j")
   class123 field2289;
   @ObfuscatedName("p")
   class123 field2290;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1381642865
   )
   @Export("index")
   int index;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1322500801
   )
   int field2293;
   @ObfuscatedName("n")
   static byte[] field2294;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)[B",
      garbageValue = "126952063"
   )
   public byte[] method3008(int var1) {
      class123 var2 = this.field2290;
      synchronized(this.field2290) {
         try {
            Object var10000;
            if(this.field2289.method2338() < (long)(var1 * 6 + 6)) {
               var10000 = null;
               return (byte[])var10000;
            } else {
               this.field2289.method2337((long)(var1 * 6));
               this.field2289.method2340(field2294, 0, 6);
               int var3 = (field2294[2] & 255) + ((field2294[1] & 255) << 8) + ((field2294[0] & 255) << 16);
               int var4 = (field2294[5] & 255) + ((field2294[3] & 255) << 16) + ((field2294[4] & 255) << 8);
               if(var3 < 0 || var3 > this.field2293) {
                  var10000 = null;
                  return (byte[])var10000;
               } else if(var4 <= 0 || (long)var4 > this.field2290.method2338() / 520L) {
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

                     this.field2290.method2337((long)(var4 * 520));
                     int var8 = var3 - var6;
                     if(var8 > 512) {
                        var8 = 512;
                     }

                     this.field2290.method2340(field2294, 0, var8 + 8);
                     int var9 = (field2294[1] & 255) + ((field2294[0] & 255) << 8);
                     int var10 = (field2294[3] & 255) + ((field2294[2] & 255) << 8);
                     int var11 = ((field2294[5] & 255) << 8) + ((field2294[4] & 255) << 16) + (field2294[6] & 255);
                     int var12 = field2294[7] & 255;
                     if(var1 == var9 && var7 == var10 && this.index == var12) {
                        if(var11 >= 0 && (long)var11 <= this.field2290.method2338() / 520L) {
                           for(int var13 = 0; var13 < var8; ++var13) {
                              var5[var6++] = field2294[var13 + 8];
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I[BIB)Z",
      garbageValue = "-35"
   )
   public boolean method3009(int var1, byte[] var2, int var3) {
      class123 var4 = this.field2290;
      synchronized(this.field2290) {
         if(var3 >= 0 && var3 <= this.field2293) {
            boolean var5 = this.method3010(var1, var2, var3, true);
            if(!var5) {
               var5 = this.method3010(var1, var2, var3, false);
            }

            return var5;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I[BIZB)Z",
      garbageValue = "83"
   )
   boolean method3010(int var1, byte[] var2, int var3, boolean var4) {
      class123 var5 = this.field2290;
      synchronized(this.field2290) {
         try {
            int var6;
            boolean var10000;
            if(var4) {
               if(this.field2289.method2338() < (long)(var1 * 6 + 6)) {
                  var10000 = false;
                  return var10000;
               }

               this.field2289.method2337((long)(var1 * 6));
               this.field2289.method2340(field2294, 0, 6);
               var6 = (field2294[5] & 255) + ((field2294[4] & 255) << 8) + ((field2294[3] & 255) << 16);
               if(var6 <= 0 || (long)var6 > this.field2290.method2338() / 520L) {
                  var10000 = false;
                  return var10000;
               }
            } else {
               var6 = (int)((this.field2290.method2338() + 519L) / 520L);
               if(var6 == 0) {
                  var6 = 1;
               }
            }

            field2294[0] = (byte)(var3 >> 16);
            field2294[1] = (byte)(var3 >> 8);
            field2294[2] = (byte)var3;
            field2294[3] = (byte)(var6 >> 16);
            field2294[4] = (byte)(var6 >> 8);
            field2294[5] = (byte)var6;
            this.field2289.method2337((long)(var1 * 6));
            this.field2289.method2341(field2294, 0, 6);
            int var7 = 0;
            int var8 = 0;

            while(true) {
               if(var7 < var3) {
                  label145: {
                     int var9 = 0;
                     int var14;
                     if(var4) {
                        this.field2290.method2337((long)(var6 * 520));

                        try {
                           this.field2290.method2340(field2294, 0, 8);
                        } catch (EOFException var16) {
                           break label145;
                        }

                        var14 = (field2294[1] & 255) + ((field2294[0] & 255) << 8);
                        int var11 = (field2294[3] & 255) + ((field2294[2] & 255) << 8);
                        var9 = ((field2294[4] & 255) << 16) + ((field2294[5] & 255) << 8) + (field2294[6] & 255);
                        int var12 = field2294[7] & 255;
                        if(var1 != var14 || var11 != var8 || var12 != this.index) {
                           var10000 = false;
                           return var10000;
                        }

                        if(var9 < 0 || (long)var9 > this.field2290.method2338() / 520L) {
                           var10000 = false;
                           return var10000;
                        }
                     }

                     if(var9 == 0) {
                        var4 = false;
                        var9 = (int)((this.field2290.method2338() + 519L) / 520L);
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

                     field2294[0] = (byte)(var1 >> 8);
                     field2294[1] = (byte)var1;
                     field2294[2] = (byte)(var8 >> 8);
                     field2294[3] = (byte)var8;
                     field2294[4] = (byte)(var9 >> 16);
                     field2294[5] = (byte)(var9 >> 8);
                     field2294[6] = (byte)var9;
                     field2294[7] = (byte)this.index;
                     this.field2290.method2337((long)(var6 * 520));
                     this.field2290.method2341(field2294, 0, 8);
                     var14 = var3 - var7;
                     if(var14 > 512) {
                        var14 = 512;
                     }

                     this.field2290.method2341(var2, var7, var14);
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

   static {
      field2294 = new byte[520];
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;IZI)LFrames;",
      garbageValue = "1895890597"
   )
   public static Frames method3014(IndexDataBase var0, IndexDataBase var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.method4156(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.method4149(var2, var5[var6]);
         if(var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9 = var1.method4149(var8, 0);
            if(var9 == null) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }

   @ObfuscatedSignature(
      signature = "(ILclass123;Lclass123;I)V",
      garbageValue = "500000"
   )
   public IndexFile(int var1, class123 var2, class123 var3, int var4) {
      this.field2290 = null;
      this.field2289 = null;
      this.field2293 = '\ufde8';
      this.index = var1;
      this.field2290 = var2;
      this.field2289 = var3;
      this.field2293 = var4;
   }
}
