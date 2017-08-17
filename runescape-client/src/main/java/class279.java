import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ju")
public class class279 {
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 253459961
   )
   public int field3726;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 200627057
   )
   public int field3727;

   class279(int var1, int var2, int var3, int var4) {
      this.method4937(var1, var2);
      this.method4938(var3, var4);
   }

   public class279(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "104"
   )
   void method4937(int var1, int var2) {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1306939251"
   )
   void method4938(int var1, int var2) {
      this.field3726 = var1;
      this.field3727 = var2;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-465514487"
   )
   @Export("decodeSprite")
   static void decodeSprite(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class287.field3780 = var1.readUnsignedShort();
      class287.field3781 = new int[class287.field3780];
      class211.offsetsY = new int[class287.field3780];
      class266.field3647 = new int[class287.field3780];
      class287.field3782 = new int[class287.field3780];
      class274.spritePixels = new byte[class287.field3780][];
      var1.offset = var0.length - 7 - class287.field3780 * 8;
      class287.field3779 = var1.readUnsignedShort();
      ISAACCipher.field2435 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class287.field3780; ++var3) {
         class287.field3781[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class287.field3780; ++var3) {
         class211.offsetsY[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class287.field3780; ++var3) {
         class266.field3647[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class287.field3780; ++var3) {
         class287.field3782[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class287.field3780 * 8 - (var2 - 1) * 3;
      class287.field3783 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class287.field3783[var3] = var1.read24BitInt();
         if(class287.field3783[var3] == 0) {
            class287.field3783[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class287.field3780; ++var3) {
         int var4 = class266.field3647[var3];
         int var5 = class287.field3782[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class274.spritePixels[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var4 * var10] = var1.readByte();
               }
            }
         }
      }

   }
}
