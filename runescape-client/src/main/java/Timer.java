import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
@Implements("Timer")
public abstract class Timer {
   @ObfuscatedName("lc")
   @ObfuscatedGetter(
      intValue = 1496371171
   )
   static int field2268;
   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   static Widget field2270;

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-980224906"
   )
   public abstract int vmethod3061(int var1, int var2);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-69"
   )
   public abstract void vmethod3058();

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BB)V",
      garbageValue = "-101"
   )
   @Export("decodeSprite")
   static void decodeSprite(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class15.field298 = var1.readUnsignedShort();
      class287.field3807 = new int[class15.field298];
      World.offsetsY = new int[class15.field298];
      class236.field3238 = new int[class15.field298];
      FileSystem.field3207 = new int[class15.field298];
      class208.spritePixels = new byte[class15.field298][];
      var1.offset = var0.length - 7 - class15.field298 * 8;
      class287.field3808 = var1.readUnsignedShort();
      class164.field2325 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class15.field298; ++var3) {
         class287.field3807[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class15.field298; ++var3) {
         World.offsetsY[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class15.field298; ++var3) {
         class236.field3238[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class15.field298; ++var3) {
         FileSystem.field3207[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class15.field298 * 8 - (var2 - 1) * 3;
      class181.field2456 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class181.field2456[var3] = var1.read24BitInt();
         if(class181.field2456[var3] == 0) {
            class181.field2456[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class15.field298; ++var3) {
         int var4 = class236.field3238[var3];
         int var5 = FileSystem.field3207[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class208.spritePixels[var3] = var7;
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
