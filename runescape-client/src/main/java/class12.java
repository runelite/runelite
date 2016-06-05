import java.awt.Component;
import java.io.IOException;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
public class class12 extends class85 {
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1139939821
   )
   int field183;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 886141031
   )
   int field184;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 143426271
   )
   int field185;
   @ObfuscatedName("bf")
   static class80[] field186;
   @ObfuscatedName("f")
   class42 field188;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -791290253
   )
   int field189;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1896344153
   )
   int field190;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1125433487
   )
   int field191;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1362376415
   )
   int field192;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1706971223
   )
   int field194;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass143;ZI)V",
      garbageValue = "0"
   )
   public static void method132(class143 var0, boolean var1) {
      if(null != class43.field1023) {
         try {
            class43.field1023.method2960();
         } catch (Exception var8) {
            ;
         }

         class43.field1023 = null;
      }

      class43.field1023 = var0;
      class119 var2;
      if(class43.field1023 != null) {
         try {
            var2 = new class119(4);
            var2.method2453(3);
            var2.method2455(0);
            class43.field1023.method2964(var2.field2001, 0, 4);
         } catch (IOException var7) {
            try {
               class43.field1023.method2960();
            } catch (Exception var6) {
               ;
            }

            ++class171.field2752;
            class43.field1023 = null;
         }
      }

      class171.field2741.field2000 = 0;
      class171.field2759 = null;
      class141.field2201 = null;
      class171.field2743 = 0;

      while(true) {
         class172 var9 = (class172)class171.field2745.method3751();
         if(null == var9) {
            while(true) {
               var9 = (class172)class171.field2754.method3751();
               if(null == var9) {
                  if(class171.field2757 != 0) {
                     try {
                        var2 = new class119(4);
                        var2.method2453(4);
                        var2.method2453(class171.field2757);
                        var2.method2454(0);
                        class43.field1023.method2964(var2.field2001, 0, 4);
                     } catch (IOException var5) {
                        try {
                           class43.field1023.method2960();
                        } catch (Exception var4) {
                           ;
                        }

                        ++class171.field2752;
                        class43.field1023 = null;
                     }
                  }

                  class171.field2746 = 0;
                  class171.field2742 = class124.method2746();
                  return;
               }

               class171.field2747.method3831(var9);
               class171.field2748.method3749(var9, var9.field3125);
               ++class171.field2749;
               --class171.field2751;
            }
         }

         class171.field2753.method3749(var9, var9.field3125);
         ++class171.field2750;
         --class171.field2744;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "2124236572"
   )
   protected final class105 vmethod1862() {
      if(null != this.field188) {
         int var12 = client.field332 - this.field190;
         if(var12 > 100 && this.field188.field981 > 0) {
            var12 = 100;
         }

         label63: {
            do {
               do {
                  if(var12 <= this.field188.field987[this.field189]) {
                     break label63;
                  }

                  var12 -= this.field188.field987[this.field189];
                  ++this.field189;
               } while(this.field189 < this.field188.field985.length);

               this.field189 -= this.field188.field981;
            } while(this.field189 >= 0 && this.field189 < this.field188.field985.length);

            this.field188 = null;
         }

         this.field190 = client.field332 - var12;
      }

      class40 var1 = class49.method980(this.field194);
      if(null != var1.field955) {
         var1 = var1.method798();
      }

      if(var1 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field192 != 1 && this.field192 != 3) {
            var2 = var1.field954;
            var3 = var1.field923;
         } else {
            var2 = var1.field923;
            var3 = var1.field954;
         }

         int var4 = this.field184 + (var2 >> 1);
         int var5 = (1 + var2 >> 1) + this.field184;
         int var6 = this.field191 + (var3 >> 1);
         int var7 = this.field191 + (var3 + 1 >> 1);
         int[][] var8 = class5.field100[this.field185];
         int var9 = var8[var5][var7] + var8[var4][var7] + var8[var4][var6] + var8[var5][var6] >> 2;
         int var10 = (var2 << 6) + (this.field184 << 7);
         int var11 = (var3 << 6) + (this.field191 << 7);
         return var1.method796(this.field183, this.field192, var8, var10, var9, var11, this.field188, this.field189);
      }
   }

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLclass85;)V",
      garbageValue = "1"
   )
   class12(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, class85 var9) {
      this.field194 = var1;
      this.field183 = var2;
      this.field192 = var3;
      this.field185 = var4;
      this.field184 = var5;
      this.field191 = var6;
      if(var7 != -1) {
         this.field188 = class18.method177(var7);
         this.field189 = 0;
         this.field190 = client.field332 - 1;
         if(this.field188.field986 == 0 && var9 != null && var9 instanceof class12) {
            class12 var10 = (class12)var9;
            if(var10.field188 == this.field188) {
               this.field189 = var10.field189;
               this.field190 = var10.field190;
               return;
            }
         }

         if(this.field188.field981 != -1) {
            this.field189 = (int)(Math.random() * (double)this.field188.field985.length);
            this.field190 -= (int)(Math.random() * (double)this.field188.field987[this.field189]);
         }
      }

   }

   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "(IILjava/awt/Component;I)Lclass77;",
      garbageValue = "629907255"
   )
   public static class77 method138(int var0, int var1, Component var2) {
      try {
         class81 var3 = new class81();
         var3.vmethod1838(var0, var1, var2);
         return var3;
      } catch (Throwable var5) {
         class75 var4 = new class75();
         var4.vmethod1838(var0, var1, var2);
         return var4;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BILjava/lang/CharSequence;I)I",
      garbageValue = "93795765"
   )
   public static int method139(byte[] var0, int var1, CharSequence var2) {
      int var3 = var2.length();
      int var4 = var1;

      for(int var5 = 0; var5 < var3; ++var5) {
         char var6 = var2.charAt(var5);
         if(var6 <= 127) {
            var0[var4++] = (byte)var6;
         } else if(var6 <= 2047) {
            var0[var4++] = (byte)(192 | var6 >> 6);
            var0[var4++] = (byte)(128 | var6 & 63);
         } else {
            var0[var4++] = (byte)(224 | var6 >> 12);
            var0[var4++] = (byte)(128 | var6 >> 6 & 63);
            var0[var4++] = (byte)(128 | var6 & 63);
         }
      }

      return var4 - var1;
   }
}
