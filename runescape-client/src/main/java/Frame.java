import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ee")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("m")
   static int[] field1810;
   @ObfuscatedName("p")
   static int[] field1803;
   @ObfuscatedName("i")
   static int[] field1804;
   @ObfuscatedName("j")
   static int[] field1805;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lej;"
   )
   @Export("skin")
   FrameMap skin;
   @ObfuscatedName("x")
   int field1807;
   @ObfuscatedName("e")
   int[] field1808;
   @ObfuscatedName("l")
   @Export("translator_x")
   int[] translator_x;
   @ObfuscatedName("b")
   @Export("translator_y")
   int[] translator_y;
   @ObfuscatedName("n")
   @Export("translator_z")
   int[] translator_z;
   @ObfuscatedName("c")
   @Export("showing")
   boolean showing;

   static {
      field1810 = new int[500];
      field1803 = new int[500];
      field1804 = new int[500];
      field1805 = new int[500];
   }

   @ObfuscatedSignature(
      signature = "([BLej;)V"
   )
   Frame(byte[] var1, FrameMap var2) {
      this.skin = null;
      this.field1807 = -1;
      this.showing = false;
      this.skin = var2;
      Buffer var3 = new Buffer(var1);
      Buffer var4 = new Buffer(var1);
      var3.offset = 2;
      int var5 = var3.readUnsignedByte();
      int var6 = -1;
      int var7 = 0;
      var4.offset = var5 + var3.offset;

      int var8;
      for(var8 = 0; var8 < var5; ++var8) {
         int var9 = var3.readUnsignedByte();
         if(var9 > 0) {
            if(this.skin.types[var8] != 0) {
               for(int var10 = var8 - 1; var10 > var6; --var10) {
                  if(this.skin.types[var10] == 0) {
                     field1810[var7] = var10;
                     field1803[var7] = 0;
                     field1804[var7] = 0;
                     field1805[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1810[var7] = var8;
            short var11 = 0;
            if(this.skin.types[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1803[var7] = var4.readShortSmart();
            } else {
               field1803[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1804[var7] = var4.readShortSmart();
            } else {
               field1804[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1805[var7] = var4.readShortSmart();
            } else {
               field1805[var7] = var11;
            }

            var6 = var8;
            ++var7;
            if(this.skin.types[var8] == 5) {
               this.showing = true;
            }
         }
      }

      if(var1.length != var4.offset) {
         throw new RuntimeException();
      } else {
         this.field1807 = var7;
         this.field1808 = new int[var7];
         this.translator_x = new int[var7];
         this.translator_y = new int[var7];
         this.translator_z = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1808[var8] = field1810[var8];
            this.translator_x[var8] = field1803[var8];
            this.translator_y[var8] = field1804[var8];
            this.translator_z[var8] = field1805[var8];
         }

      }
   }
}
