import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fp")
public final class class159 extends Buffer {
   @ObfuscatedName("ds")
   @Export("region")
   static Region region;
   @ObfuscatedName("u")
   class160 field2137;
   @ObfuscatedName("k")
   static final int[] field2138 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("ev")
   static SpritePixels field2139;
   @ObfuscatedName("ax")
   static class102 field2140;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 411998461
   )
   int field2141;

   @ObfuscatedName("hx")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-103"
   )
   public void method2967(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.field2137.method2994());
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "719825803"
   )
   public int method2968() {
      return super.payload[++super.offset - 1] - this.field2137.method2994() & 255;
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "555824681"
   )
   public void method2969() {
      this.field2141 = super.offset * 8;
   }

   @ObfuscatedName("il")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-65574880"
   )
   public int method2971(int var1) {
      return 8 * var1 - this.field2141;
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "([II)V",
      garbageValue = "-740813415"
   )
   public void method2975(int[] var1) {
      this.field2137 = new class160(var1);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class159(int var1) {
      super(var1);
   }

   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2122040542"
   )
   static final int method2979() {
      if(XGrandExchangeOffer.field35.field699) {
         return class63.plane;
      } else {
         int var0 = ChatLineBuffer.method896(class110.cameraX, class16.cameraY, class63.plane);
         return var0 - class189.cameraZ < 800 && (class10.tileSettings[class63.plane][class110.cameraX >> 7][class16.cameraY >> 7] & 4) != 0?class63.plane:3;
      }
   }

   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;LWidget;B)Ljava/lang/String;",
      garbageValue = "53"
   )
   static String method2980(String var0, Widget var1) {
      if(var0.indexOf("%") != -1) {
         int var2;
         for(var2 = 1; var2 <= 5; ++var2) {
            while(true) {
               int var6 = var0.indexOf("%" + var2);
               if(var6 == -1) {
                  break;
               }

               var0 = var0.substring(0, var6) + class174.method3180(Player.method235(var1, var2 - 1)) + var0.substring(2 + var6);
            }
         }

         while(true) {
            var2 = var0.indexOf("%dns");
            if(var2 == -1) {
               break;
            }

            String var3 = "";
            if(World.field678 != null) {
               int var5 = World.field678.field1656;
               String var4 = (var5 >> 24 & 255) + "." + (var5 >> 16 & 255) + "." + (var5 >> 8 & 255) + "." + (var5 & 255);
               var3 = var4;
               if(World.field678.field1662 != null) {
                  var3 = (String)World.field678.field1662;
               }
            }

            var0 = var0.substring(0, var2) + var3 + var0.substring(var2 + 4);
         }
      }

      return var0;
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-2111034128"
   )
   public int method2986(int var1) {
      int var2 = this.field2141 >> 3;
      int var3 = 8 - (this.field2141 & 7);
      int var4 = 0;

      for(this.field2141 += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2138[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2138[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2138[var1];
      }

      return var4;
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1709290086"
   )
   public void method2992() {
      super.offset = (this.field2141 + 7) / 8;
   }
}
