import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("h")
final class class3 implements class0 {
   @ObfuscatedName("aj")
   protected static boolean field14;
   @ObfuscatedName("gj")
   @ObfuscatedGetter(
      intValue = 1801528447
   )
   @Export("cameraY")
   static int cameraY;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lir;IIIZI)V",
      garbageValue = "-2047254411"
   )
   public static void method7(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class214.field2617 = 1;
      class214.field2614 = var0;
      class293.field3798 = var1;
      class23.field342 = var2;
      IndexFile.field2192 = var3;
      class33.field446 = var4;
      class214.field2616 = 10000;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-2121601244"
   )
   @Export("decodeSprite")
   static void decodeSprite(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class310.field3909 = var1.readUnsignedShort();
      class219.field2698 = new int[class310.field3909];
      class263.offsetsY = new int[class310.field3909];
      class60.field708 = new int[class310.field3909];
      class310.field3911 = new int[class310.field3909];
      class310.spritePixels = new byte[class310.field3909][];
      var1.offset = var0.length - 7 - class310.field3909 * 8;
      class310.field3908 = var1.readUnsignedShort();
      class310.field3910 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class310.field3909; ++var3) {
         class219.field2698[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class310.field3909; ++var3) {
         class263.offsetsY[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class310.field3909; ++var3) {
         class60.field708[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class310.field3909; ++var3) {
         class310.field3911[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class310.field3909 * 8 - (var2 - 1) * 3;
      class289.field3786 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class289.field3786[var3] = var1.read24BitInt();
         if(class289.field3786[var3] == 0) {
            class289.field3786[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class310.field3909; ++var3) {
         int var4 = class60.field708[var3];
         int var5 = class310.field3911[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class310.spritePixels[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var9 + var10 * var4] = var1.readByte();
               }
            }
         }
      }

   }

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(Lbe;IB)V",
      garbageValue = "-65"
   )
   @Export("characterToScreen")
   static final void characterToScreen(Actor var0, int var1) {
      class111.worldToScreen(var0.x, var0.y, var1);
   }
}
