import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fm")
@Implements("CipherBuffer")
public final class CipherBuffer extends Buffer {
   @ObfuscatedName("w")
   static final int[] field2142 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("m")
   @Export("cipher")
   ISAACCipher cipher;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2012542299
   )
   int field2147;

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "14"
   )
   public int method3098(int var1) {
      return var1 * 8 - this.field2147;
   }

   @ObfuscatedName("hv")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "16"
   )
   @Export("seed")
   public void seed(int[] var1) {
      this.cipher = new ISAACCipher(var1);
   }

   @ObfuscatedName("he")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1346109006"
   )
   @Export("putOpcode")
   public void putOpcode(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.cipher.nextInt());
   }

   @ObfuscatedName("hp")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1946471158"
   )
   public void method3102() {
      this.field2147 = super.offset * 8;
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1518563149"
   )
   public void method3103() {
      super.offset = (7 + this.field2147) / 8;
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public CipherBuffer(int var1) {
      super(var1);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "65280"
   )
   static int method3104(int var0, Script var1, boolean var2) {
      int var4;
      int var9;
      if(var0 == 100) {
         class30.field713 -= 3;
         var9 = class32.field743[class30.field713];
         var4 = class32.field743[1 + class30.field713];
         int var5 = class32.field743[class30.field713 + 2];
         if(var4 == 0) {
            throw new RuntimeException();
         } else {
            Widget var6 = FaceNormal.method1932(var9);
            if(null == var6.children) {
               var6.children = new Widget[1 + var5];
            }

            if(var6.children.length <= var5) {
               Widget[] var7 = new Widget[var5 + 1];

               for(int var8 = 0; var8 < var6.children.length; ++var8) {
                  var7[var8] = var6.children[var8];
               }

               var6.children = var7;
            }

            if(var5 > 0 && var6.children[var5 - 1] == null) {
               throw new RuntimeException("" + (var5 - 1));
            } else {
               Widget var12 = new Widget();
               var12.type = var4;
               var12.parentId = var12.id = var6.id;
               var12.index = var5;
               var12.hasScript = true;
               var6.children[var5] = var12;
               if(var2) {
                  class154.field2123 = var12;
               } else {
                  class32.field746 = var12;
               }

               class22.method197(var6);
               return 1;
            }
         }
      } else {
         Widget var3;
         if(var0 == 101) {
            var3 = var2?class154.field2123:class32.field746;
            Widget var11 = FaceNormal.method1932(var3.id);
            var11.children[var3.index] = null;
            class22.method197(var11);
            return 1;
         } else if(var0 == 102) {
            var3 = FaceNormal.method1932(class32.field743[--class30.field713]);
            var3.children = null;
            class22.method197(var3);
            return 1;
         } else if(var0 != 200) {
            if(var0 == 201) {
               var3 = FaceNormal.method1932(class32.field743[--class30.field713]);
               if(var3 != null) {
                  class32.field743[++class30.field713 - 1] = 1;
                  if(var2) {
                     class154.field2123 = var3;
                  } else {
                     class32.field746 = var3;
                  }
               } else {
                  class32.field743[++class30.field713 - 1] = 0;
               }

               return 1;
            } else {
               return 2;
            }
         } else {
            class30.field713 -= 2;
            var9 = class32.field743[class30.field713];
            var4 = class32.field743[1 + class30.field713];
            Widget var10 = class118.method2354(var9, var4);
            if(var10 != null && var4 != -1) {
               class32.field743[++class30.field713 - 1] = 1;
               if(var2) {
                  class154.field2123 = var10;
               } else {
                  class32.field746 = var10;
               }
            } else {
               class32.field743[++class30.field713 - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1376233647"
   )
   @Export("readOpcode")
   public int readOpcode() {
      return super.payload[++super.offset - 1] - this.cipher.nextInt() & 255;
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1898128443"
   )
   public int method3111(int var1) {
      int var2 = this.field2147 >> 3;
      int var3 = 8 - (this.field2147 & 7);
      int var4 = 0;

      for(this.field2147 += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2142[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2142[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2142[var1];
      }

      return var4;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1190309711"
   )
   public static void method3122() {
      class227.field3244 = new CombatInfoList();
   }
}
