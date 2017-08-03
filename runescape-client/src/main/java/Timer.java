import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ff")
@Implements("Timer")
public abstract class Timer {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -946889055
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1055561234"
   )
   public abstract int vmethod3006(int var1, int var2);

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "60"
   )
   public abstract void vmethod3003();

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZI)I",
      garbageValue = "2088760314"
   )
   @Export("parseInt")
   public static int parseInt(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == 45) {
                  var3 = true;
                  continue;
               }

               if(var8 == 43) {
                  continue;
               }
            }

            int var10;
            if(var8 >= 48 && var8 <= 57) {
               var10 = var8 - 48;
            } else if(var8 >= 65 && var8 <= 90) {
               var10 = var8 - 55;
            } else {
               if(var8 < 97 || var8 > 122) {
                  throw new NumberFormatException();
               }

               var10 = var8 - 87;
            }

            if(var10 >= var1) {
               throw new NumberFormatException();
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var5 * var1 + var10;
            if(var9 / var1 != var5) {
               throw new NumberFormatException();
            }

            var5 = var9;
            var4 = true;
         }

         if(!var4) {
            throw new NumberFormatException();
         } else {
            return var5;
         }
      } else {
         throw new IllegalArgumentException("");
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1770296583"
   )
   @Export("decodeSprite")
   static void decodeSprite(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class286.field3781 = var1.readUnsignedShort();
      class270.field3666 = new int[class286.field3781];
      class286.offsetsY = new int[class286.field3781];
      class286.field3778 = new int[class286.field3781];
      class286.field3782 = new int[class286.field3781];
      class177.spritePixels = new byte[class286.field3781][];
      var1.offset = var0.length - 7 - class286.field3781 * 8;
      class286.field3779 = var1.readUnsignedShort();
      class286.field3780 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class286.field3781; ++var3) {
         class270.field3666[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3781; ++var3) {
         class286.offsetsY[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3781; ++var3) {
         class286.field3778[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3781; ++var3) {
         class286.field3782[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class286.field3781 * 8 - (var2 - 1) * 3;
      class286.field3783 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class286.field3783[var3] = var1.read24BitInt();
         if(class286.field3783[var3] == 0) {
            class286.field3783[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class286.field3781; ++var3) {
         int var4 = class286.field3778[var3];
         int var5 = class286.field3782[var3];
         int var6 = var5 * var4;
         byte[] var7 = new byte[var6];
         class177.spritePixels[var3] = var7;
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
