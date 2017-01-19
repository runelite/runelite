import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
public final class class159 extends Buffer {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1834774937
   )
   int field2134;
   @ObfuscatedName("x")
   static final int[] field2135 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("b")
   class160 field2136;

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(LWidget;IIIB)V",
      garbageValue = "-3"
   )
   static final void method2961(Widget var0, int var1, int var2, int var3) {
      class164 var4 = var0.method3100(false);
      if(null != var4) {
         if(Client.field347 < 3) {
            class72.field1180.method3982(var1, var2, var4.field2164, var4.field2165, 25, 25, Client.mapAngle, 256, var4.field2172, var4.field2166);
         } else {
            Rasterizer2D.method3856(var1, var2, 0, var4.field2172, var4.field2166);
         }

      }
   }

   @ObfuscatedName("hm")
   @ObfuscatedSignature(
      signature = "([IS)V",
      garbageValue = "255"
   )
   public void method2962(int[] var1) {
      this.field2136 = new class160(var1);
   }

   @ObfuscatedName("hk")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-469938197"
   )
   public void method2963(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.field2136.method2983());
   }

   @ObfuscatedName("hj")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "514551199"
   )
   public int method2964() {
      return super.payload[++super.offset - 1] - this.field2136.method2983() & 255;
   }

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1628317567"
   )
   public void method2967() {
      super.offset = (this.field2134 + 7) / 8;
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1872947089"
   )
   public int method2968(int var1) {
      return var1 * 8 - this.field2134;
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1168397568"
   )
   public int method2973(int var1) {
      int var2 = this.field2134 >> 3;
      int var3 = 8 - (this.field2134 & 7);
      int var4 = 0;

      for(this.field2134 += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2135[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2135[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2135[var1];
      }

      return var4;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class159(int var1) {
      super(var1);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "([BIIIIIII[LCollisionData;I)V",
      garbageValue = "-377336460"
   )
   static final void method2981(byte[] var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, CollisionData[] var8) {
      int var10;
      for(int var9 = 0; var9 < 8; ++var9) {
         for(var10 = 0; var10 < 8; ++var10) {
            if(var9 + var2 > 0 && var9 + var2 < 103 && var3 + var10 > 0 && var10 + var3 < 103) {
               var8[var1].flags[var9 + var2][var10 + var3] &= -16777217;
            }
         }
      }

      Buffer var13 = new Buffer(var0);

      for(var10 = 0; var10 < 4; ++var10) {
         for(int var11 = 0; var11 < 64; ++var11) {
            for(int var12 = 0; var12 < 64; ++var12) {
               if(var4 == var10 && var11 >= var5 && var11 < var5 + 8 && var12 >= var6 && var12 < 8 + var6) {
                  class137.method2398(var13, var1, var2 + NPC.method697(var11 & 7, var12 & 7, var7), var3 + class65.method1120(var11 & 7, var12 & 7, var7), 0, 0, var7);
               } else {
                  class137.method2398(var13, 0, -1, -1, 0, 0, 0);
               }
            }
         }
      }

   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "3443"
   )
   public void method2982() {
      this.field2134 = super.offset * 8;
   }
}
