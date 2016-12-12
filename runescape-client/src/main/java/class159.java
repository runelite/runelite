import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public final class class159 extends Buffer {
   @ObfuscatedName("v")
   static final int[] field2126 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("w")
   class160 field2128;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -896881959
   )
   int field2130;
   @ObfuscatedName("mg")
   static SpritePixels field2131;

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2112371351"
   )
   public int method2975() {
      return super.payload[++super.offset - 1] - this.field2128.method2997() & 255;
   }

   @ObfuscatedName("hy")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "4"
   )
   public void method2976(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.field2128.method2997());
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class159(int var1) {
      super(var1);
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-9"
   )
   public void method2977() {
      this.field2130 = super.offset * 8;
   }

   @ObfuscatedName("hn")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "596394745"
   )
   public int method2978(int var1) {
      int var2 = this.field2130 >> 3;
      int var3 = 8 - (this.field2130 & 7);
      int var4 = 0;

      for(this.field2130 += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2126[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var1 == var3) {
         var4 += super.payload[var2] & field2126[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2126[var1];
      }

      return var4;
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "105"
   )
   public void method2979(int[] var1) {
      this.field2128 = new class160(var1);
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "13"
   )
   public void method2982() {
      super.offset = (this.field2130 + 7) / 8;
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1767509619"
   )
   public int method2988(int var1) {
      return var1 * 8 - this.field2130;
   }

   @ObfuscatedName("bh")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "2048790192"
   )
   static final void method2992(int var0, int var1, int var2) {
      if(var0 >= 128 && var1 >= 128 && var0 <= 13056 && var1 <= 13056) {
         int var3 = class85.method1686(var0, var1, class171.plane) - var2;
         var0 -= WidgetNode.cameraX;
         var3 -= MessageNode.cameraZ;
         var1 -= class2.cameraY;
         int var4 = class84.field1453[Buffer.cameraPitch];
         int var5 = class84.field1454[Buffer.cameraPitch];
         int var6 = class84.field1453[class39.cameraYaw];
         int var7 = class84.field1454[class39.cameraYaw];
         int var8 = var0 * var7 + var1 * var6 >> 16;
         var1 = var7 * var1 - var0 * var6 >> 16;
         var0 = var8;
         var8 = var5 * var3 - var4 * var1 >> 16;
         var1 = var1 * var5 + var4 * var3 >> 16;
         if(var1 >= 50) {
            Client.field387 = Client.scale * var0 / var1 + Client.camera2 / 2;
            Client.field536 = Client.camera3 / 2 + var8 * Client.scale / var1;
         } else {
            Client.field387 = -1;
            Client.field536 = -1;
         }

      } else {
         Client.field387 = -1;
         Client.field536 = -1;
      }
   }
}
