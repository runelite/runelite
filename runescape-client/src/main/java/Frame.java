import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("eu")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("a")
   static int[] field1781;
   @ObfuscatedName("w")
   static int[] field1776;
   @ObfuscatedName("e")
   static int[] field1778;
   @ObfuscatedName("k")
   static int[] field1779;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Leg;"
   )
   @Export("skin")
   FrameMap skin;
   @ObfuscatedName("z")
   int field1780;
   @ObfuscatedName("t")
   int[] field1782;
   @ObfuscatedName("f")
   @Export("translator_x")
   int[] translator_x;
   @ObfuscatedName("g")
   @Export("translator_y")
   int[] translator_y;
   @ObfuscatedName("j")
   @Export("translator_z")
   int[] translator_z;
   @ObfuscatedName("x")
   @Export("showing")
   boolean showing;

   static {
      field1781 = new int[500];
      field1776 = new int[500];
      field1778 = new int[500];
      field1779 = new int[500];
   }

   @ObfuscatedSignature(
      signature = "([BLeg;)V"
   )
   Frame(byte[] var1, FrameMap var2) {
      this.skin = null;
      this.field1780 = -1;
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
                     field1781[var7] = var10;
                     field1776[var7] = 0;
                     field1778[var7] = 0;
                     field1779[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1781[var7] = var8;
            short var11 = 0;
            if(this.skin.types[var8] == 3) {
               var11 = 128;
            }

            if((var9 & 1) != 0) {
               field1776[var7] = var4.readShortSmart();
            } else {
               field1776[var7] = var11;
            }

            if((var9 & 2) != 0) {
               field1778[var7] = var4.readShortSmart();
            } else {
               field1778[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1779[var7] = var4.readShortSmart();
            } else {
               field1779[var7] = var11;
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
         this.field1780 = var7;
         this.field1782 = new int[var7];
         this.translator_x = new int[var7];
         this.translator_y = new int[var7];
         this.translator_z = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1782[var8] = field1781[var8];
            this.translator_x[var8] = field1776[var8];
            this.translator_y[var8] = field1778[var8];
            this.translator_z[var8] = field1779[var8];
         }

      }
   }
}
