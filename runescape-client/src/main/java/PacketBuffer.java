import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fr")
@Implements("PacketBuffer")
public final class PacketBuffer extends Buffer {
   @ObfuscatedName("k")
   static final int[] field2426;
   @ObfuscatedName("j")
   @Export("cipher")
   ISAACCipher cipher;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1652269775
   )
   @Export("bitPosition")
   int bitPosition;

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1328481773"
   )
   @Export("byteAccess")
   public void byteAccess() {
      super.offset = (this.bitPosition + 7) / 8;
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "([IS)V",
      garbageValue = "-13659"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public PacketBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "28"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1743072488"
   )
   @Export("getBits")
   public int getBits(int var1) {
      int var2 = this.bitPosition >> 3;
      int var3 = 8 - (this.bitPosition & 7);
      int var4 = 0;

      for(this.bitPosition += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2426[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2426[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2426[var1];
      }

      return var4;
   }

   @ObfuscatedName("hr")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "1327121237"
   )
   @Export("bitsAvail")
   public int bitsAvail(int var1) {
      return var1 * 8 - this.bitPosition;
   }

   @ObfuscatedName("hh")
   @ObfuscatedSignature(
      signature = "(IS)V",
      garbageValue = "20061"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(CB)Z",
      garbageValue = "12"
   )
   static final boolean method3402(char var0) {
      return var0 == 160 || var0 == 32 || var0 == 95 || var0 == 45;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LWidget;",
      garbageValue = "-1050787928"
   )
   public static Widget method3403(int var0) {
      int var1 = var0 >> 16;
      int var2 = var0 & '\uffff';
      if(class46.widgets[var1] == null || class46.widgets[var1][var2] == null) {
         boolean var3 = class66.loadWidget(var1);
         if(!var3) {
            return null;
         }
      }

      return class46.widgets[var1][var2];
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "480268066"
   )
   @Export("bitAccess")
   public void bitAccess() {
      this.bitPosition = super.offset * 8;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-274694405"
   )
   public static void method3411(int var0) {
      if(var0 != -1 && class152.validInterfaces[var0]) {
         Widget.widgetIndex.method4127(var0);
         if(class46.widgets[var0] != null) {
            boolean var1 = true;

            for(int var2 = 0; var2 < class46.widgets[var0].length; ++var2) {
               if(class46.widgets[var0][var2] != null) {
                  if(class46.widgets[var0][var2].type != 2) {
                     class46.widgets[var0][var2] = null;
                  } else {
                     var1 = false;
                  }
               }
            }

            if(var1) {
               class46.widgets[var0] = null;
            }

            class152.validInterfaces[var0] = false;
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LIndexData;IIIBZI)V",
      garbageValue = "142233700"
   )
   static void method3413(IndexData var0, int var1, int var2, int var3, byte var4, boolean var5) {
      long var6 = (long)((var1 << 16) + var2);
      FileRequest var8 = (FileRequest)class238.field3260.get(var6);
      if(var8 == null) {
         var8 = (FileRequest)class238.field3275.get(var6);
         if(var8 == null) {
            var8 = (FileRequest)class238.field3268.get(var6);
            if(var8 != null) {
               if(var5) {
                  var8.unlinkDual();
                  class238.field3260.put(var8, var6);
                  --class238.field3269;
                  ++class238.field3266;
               }
            } else {
               if(!var5) {
                  var8 = (FileRequest)class238.field3270.get(var6);
                  if(var8 != null) {
                     return;
                  }
               }

               var8 = new FileRequest();
               var8.index = var0;
               var8.crc = var3;
               var8.padding = var4;
               if(var5) {
                  class238.field3260.put(var8, var6);
                  ++class238.field3266;
               } else {
                  class238.field3267.push(var8);
                  class238.field3268.put(var8, var6);
                  ++class238.field3269;
               }
            }
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "16"
   )
   static int method3414(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = method3403(class83.intStack[--class46.intStackSize]);
      } else {
         var3 = var2?class83.field1364:class60.field766;
      }

      class88.method1714(var3);
      if(var0 != 1200 && var0 != 1205 && var0 != 1212) {
         if(var0 == 1201) {
            var3.modelType = 2;
            var3.modelId = class83.intStack[--class46.intStackSize];
            return 1;
         } else if(var0 == 1202) {
            var3.modelType = 3;
            var3.modelId = XItemContainer.localPlayer.composition.method3938();
            return 1;
         } else {
            return 2;
         }
      } else {
         class46.intStackSize -= 2;
         int var4 = class83.intStack[class46.intStackSize];
         int var5 = class83.intStack[class46.intStackSize + 1];
         var3.itemId = var4;
         var3.itemQuantity = var5;
         ItemComposition var6 = AbstractByteBuffer.getItemDefinition(var4);
         var3.rotationX = var6.xan2d;
         var3.rotationZ = var6.yan2d;
         var3.rotationY = var6.zan2d;
         var3.field2703 = var6.offsetX2d;
         var3.field2704 = var6.offsetY2d;
         var3.modelZoom = var6.zoom2d;
         if(var0 == 1205) {
            var3.field2784 = 0;
         } else if(var0 == 1212 | var6.isStackable == 1) {
            var3.field2784 = 1;
         } else {
            var3.field2784 = 2;
         }

         if(var3.field2709 > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.field2709;
         } else if(var3.originalWidth > 0) {
            var3.modelZoom = var3.modelZoom * 32 / var3.originalWidth;
         }

         return 1;
      }
   }

   static {
      field2426 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   }
}
