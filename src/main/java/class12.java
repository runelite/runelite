import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("z")
public class class12 extends class85 {
   @ObfuscatedName("bq")
   static String field191;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2138497759
   )
   int field192;
   @ObfuscatedName("ng")
   @ObfuscatedGetter(
      intValue = 1743709663
   )
   static int field193;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -839117153
   )
   int field195;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1692224895
   )
   int field196;
   @ObfuscatedName("r")
   class42 field197;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2061586067
   )
   int field198;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 161022229
   )
   int field199;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 364860263
   )
   int field200;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -412356083
   )
   int field202;
   @ObfuscatedName("dh")
   static int[] field203;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 909648051
   )
   int field204;

   @ObfuscatedSignature(
      signature = "(IIIIIIIZLclass85;)V",
      garbageValue = "1"
   )
   class12(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, class85 var9) {
      this.field200 = var1;
      this.field192 = var2;
      this.field196 = var3;
      this.field202 = var4;
      this.field195 = var5;
      this.field204 = var6;
      if(var7 != -1) {
         this.field197 = class96.method2279(var7);
         this.field198 = 0;
         this.field199 = client.field306 - 1;
         if(0 == this.field197.field1005 && var9 != null && var9 instanceof class12) {
            class12 var10 = (class12)var9;
            if(this.field197 == var10.field197) {
               this.field198 = var10.field198;
               this.field199 = var10.field199;
               return;
            }
         }

         if(-1 != this.field197.field998) {
            this.field198 = (int)(Math.random() * (double)this.field197.field989.length);
            this.field199 -= (int)(Math.random() * (double)this.field197.field995[this.field198]);
         }
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)Lclass105;",
      garbageValue = "-1720106348"
   )
   protected final class105 vmethod1999() {
      if(null != this.field197) {
         int var1 = client.field306 - this.field199;
         if(var1 > 100 && this.field197.field998 > 0) {
            var1 = 100;
         }

         label63: {
            do {
               do {
                  if(var1 <= this.field197.field995[this.field198]) {
                     break label63;
                  }

                  var1 -= this.field197.field995[this.field198];
                  ++this.field198;
               } while(this.field198 < this.field197.field989.length);

               this.field198 -= this.field197.field998;
            } while(this.field198 >= 0 && this.field198 < this.field197.field989.length);

            this.field197 = null;
         }

         this.field199 = client.field306 - var1;
      }

      class40 var12 = class133.method2969(this.field200);
      if(null != var12.field925) {
         var12 = var12.method894();
      }

      if(var12 == null) {
         return null;
      } else {
         int var2;
         int var3;
         if(1 != this.field196 && this.field196 != 3) {
            var2 = var12.field938;
            var3 = var12.field939;
         } else {
            var2 = var12.field939;
            var3 = var12.field938;
         }

         int var4 = this.field195 + (var2 >> 1);
         int var5 = (1 + var2 >> 1) + this.field195;
         int var6 = this.field204 + (var3 >> 1);
         int var7 = (var3 + 1 >> 1) + this.field204;
         int[][] var8 = class5.field94[this.field202];
         int var9 = var8[var5][var7] + var8[var4][var6] + var8[var5][var6] + var8[var4][var7] >> 2;
         int var10 = (this.field195 << 7) + (var2 << 6);
         int var11 = (this.field204 << 7) + (var3 << 6);
         return var12.method933(this.field192, this.field196, var8, var10, var9, var11, this.field197, this.field198);
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;S)Ljava/lang/Class;",
      garbageValue = "-12875"
   )
   static Class method192(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Class.forName(var0)))))))));
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-25791982"
   )
   static void method193() {
      client.field338.field1992 = 0;
      client.field441.field1992 = 0;
      client.field394 = -1;
      client.field471 = 1;
      client.field576 = -1;
      client.field436 = -1;
      client.field341 = 0;
      client.field371 = 0;
      client.field313 = 0;
      client.field434 = 0;
      client.field433 = false;
      client.field530 = 0;
      client.field528 = 0;

      int var0;
      for(var0 = 0; var0 < 2048; ++var0) {
         client.field550[var0] = null;
      }

      class5.field93 = null;

      for(var0 = 0; var0 < client.field546.length; ++var0) {
         class34 var1 = client.field546[var0];
         if(var1 != null) {
            var1.field842 = -1;
            var1.field843 = false;
         }
      }

      class183.method3675();
      class3.method49(30);

      for(var0 = 0; var0 < 100; ++var0) {
         client.field323[var0] = true;
      }

      class34.method804();
   }
}
