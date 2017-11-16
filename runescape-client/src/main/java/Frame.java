import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("en")
@Implements("Frame")
public class Frame {
   @ObfuscatedName("b")
   static int[] field1795;
   @ObfuscatedName("s")
   static int[] field1803;
   @ObfuscatedName("r")
   static int[] field1796;
   @ObfuscatedName("g")
   static int[] field1797;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lep;"
   )
   @Export("skin")
   FrameMap skin;
   @ObfuscatedName("f")
   int field1799;
   @ObfuscatedName("u")
   int[] field1800;
   @ObfuscatedName("t")
   @Export("translator_x")
   int[] translator_x;
   @ObfuscatedName("k")
   @Export("translator_y")
   int[] translator_y;
   @ObfuscatedName("n")
   @Export("translator_z")
   int[] translator_z;
   @ObfuscatedName("d")
   @Export("showing")
   boolean showing;

   static {
      field1795 = new int[500];
      field1803 = new int[500];
      field1796 = new int[500];
      field1797 = new int[500];
   }

   @ObfuscatedSignature(
      signature = "([BLep;)V"
   )
   Frame(byte[] var1, FrameMap var2) {
      this.skin = null;
      this.field1799 = -1;
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
                     field1795[var7] = var10;
                     field1803[var7] = 0;
                     field1796[var7] = 0;
                     field1797[var7] = 0;
                     ++var7;
                     break;
                  }
               }
            }

            field1795[var7] = var8;
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
               field1796[var7] = var4.readShortSmart();
            } else {
               field1796[var7] = var11;
            }

            if((var9 & 4) != 0) {
               field1797[var7] = var4.readShortSmart();
            } else {
               field1797[var7] = var11;
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
         this.field1799 = var7;
         this.field1800 = new int[var7];
         this.translator_x = new int[var7];
         this.translator_y = new int[var7];
         this.translator_z = new int[var7];

         for(var8 = 0; var8 < var7; ++var8) {
            this.field1800[var8] = field1795[var8];
            this.translator_x[var8] = field1803[var8];
            this.translator_y[var8] = field1796[var8];
            this.translator_z[var8] = field1797[var8];
         }

      }
   }
}
