import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eb")
public class class155 implements class115 {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1503939597
   )
   static int field2308;
   @ObfuscatedName("l")
   public static final class155 field2309 = new class155(1, 0, true, true, true);
   @ObfuscatedName("c")
   public static final class155 field2310 = new class155(2, 1, true, true, false);
   @ObfuscatedName("e")
   public static final class155 field2311 = new class155(0, -1, true, false, true);
   @ObfuscatedName("h")
   public static final class155 field2313 = new class155(3, 2, false, false, true);
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2113243461
   )
   public final int field2314;
   @ObfuscatedName("u")
   public final boolean field2315;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2112190601
   )
   final int field2316;
   @ObfuscatedName("r")
   public static final class155 field2320 = new class155(4, 3, false, false, true);
   @ObfuscatedName("o")
   public final boolean field2321;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2010364784"
   )
   public int vmethod3262() {
      return this.field2316;
   }

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class155(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2316 = var1;
      this.field2314 = var2;
      this.field2315 = var4;
      this.field2321 = var5;
   }

   @ObfuscatedName("al")
   @ObfuscatedSignature(
      signature = "(Lclass39;B)V",
      garbageValue = "32"
   )
   static final void method3237(class39 var0) {
      var0.field900 = var0.field854;
      if(var0.field852 == 0) {
         var0.field908 = 0;
      } else {
         if(var0.field890 != -1 && var0.field904 == 0) {
            class44 var10 = class13.method153(var0.field890);
            if(var0.field909 > 0 && var10.field1034 == 0) {
               ++var0.field908;
               return;
            }

            if(var0.field909 <= 0 && var10.field1035 == 0) {
               ++var0.field908;
               return;
            }
         }

         int var1 = var0.field896;
         int var2 = var0.field879;
         int var3 = var0.field851 * 64 + 128 * var0.field885[var0.field852 - 1];
         int var4 = 128 * var0.field906[var0.field852 - 1] + var0.field851 * 64;
         if(var1 < var3) {
            if(var2 < var4) {
               var0.field889 = 1280;
            } else if(var2 > var4) {
               var0.field889 = 1792;
            } else {
               var0.field889 = 1536;
            }
         } else if(var1 > var3) {
            if(var2 < var4) {
               var0.field889 = 768;
            } else if(var2 > var4) {
               var0.field889 = 256;
            } else {
               var0.field889 = 512;
            }
         } else if(var2 < var4) {
            var0.field889 = 1024;
         } else if(var2 > var4) {
            var0.field889 = 0;
         }

         byte var5 = var0.field907[var0.field852 - 1];
         if(var3 - var1 <= 256 && var3 - var1 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.field889 - var0.field905 & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field850;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field858;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field861;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field860;
            }

            if(var7 == -1) {
               var7 = var0.field858;
            }

            var0.field900 = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof class36) {
               var9 = ((class36)var0).field825.field952;
            }

            if(var9) {
               if(var0.field889 != var0.field905 && var0.field876 == -1 && var0.field903 != 0) {
                  var8 = 2;
               }

               if(var0.field852 > 2) {
                  var8 = 6;
               }

               if(var0.field852 > 3) {
                  var8 = 8;
               }

               if(var0.field908 > 0 && var0.field852 > 1) {
                  var8 = 8;
                  --var0.field908;
               }
            } else {
               if(var0.field852 > 1) {
                  var8 = 6;
               }

               if(var0.field852 > 2) {
                  var8 = 8;
               }

               if(var0.field908 > 0 && var0.field852 > 1) {
                  var8 = 8;
                  --var0.field908;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.field900 == var0.field858 && var0.field898 != -1) {
               var0.field900 = var0.field898;
            }

            if(var1 != var3 || var2 != var4) {
               if(var1 < var3) {
                  var0.field896 += var8;
                  if(var0.field896 > var3) {
                     var0.field896 = var3;
                  }
               } else if(var1 > var3) {
                  var0.field896 -= var8;
                  if(var0.field896 < var3) {
                     var0.field896 = var3;
                  }
               }

               if(var2 < var4) {
                  var0.field879 += var8;
                  if(var0.field879 > var4) {
                     var0.field879 = var4;
                  }
               } else if(var2 > var4) {
                  var0.field879 -= var8;
                  if(var0.field879 < var4) {
                     var0.field879 = var4;
                  }
               }
            }

            if(var3 == var0.field896 && var0.field879 == var4) {
               --var0.field852;
               if(var0.field909 > 0) {
                  --var0.field909;
               }
            }

         } else {
            var0.field896 = var3;
            var0.field879 = var4;
            --var0.field852;
            if(var0.field909 > 0) {
               --var0.field909;
            }

         }
      }
   }
}
