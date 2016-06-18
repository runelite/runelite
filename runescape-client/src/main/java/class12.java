import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("w")
public class class12 extends class85 {
   @ObfuscatedName("r")
   class42 field173;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1833703859
   )
   int field174;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1018443335
   )
   int field175;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 95218007
   )
   int field176;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1288756083
   )
   int field177;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 598860727
   )
   int field178;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1117466447
   )
   int field179;
   @ObfuscatedName("s")
   static class13 field182;
   @ObfuscatedName("v")
   static int[] field184;
   @ObfuscatedName("bz")
   static class168 field186;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 853474687
   )
   int field188;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 865198691
   )
   int field190;
   @ObfuscatedName("hh")
   @ObfuscatedGetter(
      intValue = -1655983313
   )
   @Export("menuY")
   static int field194;

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lclass167;B)V",
      garbageValue = "17"
   )
   public static void method149(class167 var0) {
      class46.field1033 = var0;
   }

   @ObfuscatedName("df")
   @ObfuscatedSignature(
      signature = "(Lclass173;I)Z",
      garbageValue = "138651557"
   )
   static boolean method150(class173 var0) {
      if(client.field336) {
         if(class34.method734(var0) != 0) {
            return false;
         }

         if(var0.field2833 == 0) {
            return false;
         }
      }

      return var0.field2882;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V",
      garbageValue = "-1156211777"
   )
   static void method152(String var0, String var1, String var2) {
      class31.field717 = var0;
      class31.field718 = var1;
      class31.field719 = var2;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "853773613"
   )
   protected final class105 vmethod1913() {
      if(this.field173 != null) {
         int var1 = client.field296 - this.field175;
         if(var1 > 100 && this.field173.field966 > 0) {
            var1 = 100;
         }

         label64: {
            do {
               do {
                  if(var1 <= this.field173.field983[this.field179]) {
                     break label64;
                  }

                  var1 -= this.field173.field983[this.field179];
                  ++this.field179;
               } while(this.field179 < this.field173.field965.length);

               this.field179 -= this.field173.field966;
            } while(this.field179 >= 0 && this.field179 < this.field173.field965.length);

            this.field173 = null;
         }

         this.field175 = client.field296 - var1;
      }

      class40 var12 = class172.method3399(this.field188);
      if(null != var12.field949) {
         var12 = var12.method805();
      }

      if(null == var12) {
         return null;
      } else {
         int var2;
         int var3;
         if(this.field177 != 1 && this.field177 != 3) {
            var2 = var12.field915;
            var3 = var12.field904;
         } else {
            var2 = var12.field904;
            var3 = var12.field915;
         }

         int var4 = (var2 >> 1) + this.field190;
         int var5 = (var2 + 1 >> 1) + this.field190;
         int var6 = this.field178 + (var3 >> 1);
         int var7 = this.field178 + (1 + var3 >> 1);
         int[][] var8 = class5.field83[this.field176];
         int var9 = var8[var4][var7] + var8[var5][var6] + var8[var4][var6] + var8[var5][var7] >> 2;
         int var10 = (this.field190 << 7) + (var2 << 6);
         int var11 = (this.field178 << 7) + (var3 << 6);
         return var12.method807(this.field174, this.field177, var8, var10, var9, var11, this.field173, this.field179);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "1244387092"
   )
   public static boolean method154(int var0) {
      return (var0 >> 20 & 1) != 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILclass167;IIIZI)V",
      garbageValue = "1727055340"
   )
   public static void method155(int var0, class167 var1, int var2, int var3, int var4, boolean var5) {
      class183.field2953 = 1;
      class50.field1075 = var1;
      class177.field2903 = var2;
      class183.field2951 = var3;
      class181.field2929 = var4;
      class183.field2956 = var5;
      class183.field2955 = var0;
   }

   class12(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, class85 var9) {
      this.field188 = var1;
      this.field174 = var2;
      this.field177 = var3;
      this.field176 = var4;
      this.field190 = var5;
      this.field178 = var6;
      if(var7 != -1) {
         this.field173 = class17.method178(var7);
         this.field179 = 0;
         this.field175 = client.field296 - 1;
         if(this.field173.field979 == 0 && var9 != null && var9 instanceof class12) {
            class12 var10 = (class12)var9;
            if(this.field173 == var10.field173) {
               this.field179 = var10.field179;
               this.field175 = var10.field175;
               return;
            }
         }

         if(var8 && this.field173.field966 != -1) {
            this.field179 = (int)(Math.random() * (double)this.field173.field965.length);
            this.field175 -= (int)(Math.random() * (double)this.field173.field983[this.field179]);
         }
      }

   }
}
