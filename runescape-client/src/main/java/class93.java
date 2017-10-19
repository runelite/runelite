import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cc")
final class class93 implements Comparator {
   @ObfuscatedName("dw")
   @ObfuscatedGetter(
      intValue = -1045725577
   )
   static int field1482;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   class93(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(La;La;I)I",
      garbageValue = "2081890726"
   )
   int method1797(class14 var1, class14 var2) {
      if(var2.field296 == var1.field296) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(Client.world == var1.field296) {
               return -1;
            }

            if(var2.field296 == Client.world) {
               return 1;
            }
         }

         return var1.field296 < var2.field296?-1:1;
      }
   }

   public int compare(Object var1, Object var2) {
      return this.method1797((class14)var1, (class14)var2);
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1942272906"
   )
   @Export("decodeSprite")
   static void decodeSprite(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class287.field3805 = var1.readUnsignedShort();
      class287.field3808 = new int[class287.field3805];
      class21.offsetsY = new int[class287.field3805];
      class287.field3806 = new int[class287.field3805];
      class56.field700 = new int[class287.field3805];
      class227.spritePixels = new byte[class287.field3805][];
      var1.offset = var0.length - 7 - class287.field3805 * 8;
      class287.field3809 = var1.readUnsignedShort();
      class287.field3807 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class287.field3805; ++var3) {
         class287.field3808[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class287.field3805; ++var3) {
         class21.offsetsY[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class287.field3805; ++var3) {
         class287.field3806[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class287.field3805; ++var3) {
         class56.field700[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class287.field3805 * 8 - (var2 - 1) * 3;
      class114.field1675 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class114.field1675[var3] = var1.read24BitInt();
         if(class114.field1675[var3] == 0) {
            class114.field1675[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class287.field3805; ++var3) {
         int var4 = class287.field3806[var3];
         int var5 = class56.field700[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class227.spritePixels[var3] = var7;
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
}
