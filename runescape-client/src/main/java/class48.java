import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ag")
public class class48 implements WorldMapSectionBase {
   @ObfuscatedName("aj")
   static ModIcon[] field651;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1676185101
   )
   int field638;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 430162335
   )
   int field652;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1114599785
   )
   int field646;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -2021947337
   )
   int field639;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1694272987
   )
   int field640;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2094432847
   )
   int field644;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 419699385
   )
   int field641;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1117358061
   )
   int field647;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1082124341
   )
   int field642;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -179538839
   )
   int field645;

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "202348652"
   )
   public boolean vmethod754(int var1, int var2) {
      return var1 >= (this.field652 << 6) + (this.field646 << 3) && var1 <= (this.field652 << 6) + (this.field646 << 3) + 7 && var2 >= (this.field641 << 6) + (this.field647 << 3) && var2 <= (this.field641 << 6) + (this.field647 << 3) + 7;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "998947175"
   )
   public boolean vmethod728(int var1, int var2, int var3) {
      return var1 >= this.field638 && var1 < this.field639 + this.field638?var2 >= (this.field640 << 6) + (this.field644 << 3) && var2 <= (this.field644 << 3) + (this.field640 << 6) + 7 && var3 >= (this.field642 << 6) + (this.field645 << 3) && var3 <= (this.field642 << 6) + (this.field645 << 3) + 7:false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;I)V",
      garbageValue = "98017718"
   )
   public void vmethod753(WorldMapData var1) {
      if(var1.field467 > this.field652) {
         var1.field467 = this.field652;
      }

      if(var1.field468 < this.field652) {
         var1.field468 = this.field652;
      }

      if(var1.field472 > this.field641) {
         var1.field472 = this.field641;
      }

      if(var1.field466 < this.field641) {
         var1.field466 = this.field641;
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)LCoordinates;",
      garbageValue = "-2079571098"
   )
   public Coordinates vmethod731(int var1, int var2) {
      if(!this.vmethod754(var1, var2)) {
         return null;
      } else {
         int var3 = this.field644 * 8 - this.field646 * 8 + this.field640 * 64 - this.field652 * 64 + var1;
         int var4 = this.field645 * 8 - this.field647 * 8 + this.field642 * 64 - this.field641 * 64 + var2;
         return new Coordinates(this.field638, var3, var4);
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1509988890"
   )
   public int[] vmethod730(int var1, int var2, int var3) {
      if(!this.vmethod728(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field646 * 8 - this.field644 * 8 + this.field652 * 64 - this.field640 * 64 + var2, this.field647 * 8 - this.field645 * 8 + var3 + (this.field641 * 64 - this.field642 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "618655756"
   )
   public void vmethod732(Buffer var1) {
      this.field638 = var1.readUnsignedByte();
      this.field639 = var1.readUnsignedByte();
      this.field640 = var1.readUnsignedShort();
      this.field644 = var1.readUnsignedByte();
      this.field642 = var1.readUnsignedShort();
      this.field645 = var1.readUnsignedByte();
      this.field652 = var1.readUnsignedShort();
      this.field646 = var1.readUnsignedByte();
      this.field641 = var1.readUnsignedShort();
      this.field647 = var1.readUnsignedByte();
      this.method733();
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1006647602"
   )
   void method733() {
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-2135132767"
   )
   @Export("getString")
   public static String getString(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class266.field3668[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([BI)LScript;",
      garbageValue = "1119686122"
   )
   static Script method738(byte[] var0) {
      Script var1 = new Script();
      Buffer var2 = new Buffer(var0);
      var2.offset = var2.payload.length - 2;
      int var3 = var2.readUnsignedShort();
      int var4 = var2.payload.length - 2 - var3 - 12;
      var2.offset = var4;
      int var5 = var2.readInt();
      var1.localIntCount = var2.readUnsignedShort();
      var1.localStringCount = var2.readUnsignedShort();
      var1.intStackCount = var2.readUnsignedShort();
      var1.stringStackCount = var2.readUnsignedShort();
      int var6 = var2.readUnsignedByte();
      int var7;
      int var8;
      if(var6 > 0) {
         var1.switches = var1.method1861(var6);

         for(var7 = 0; var7 < var6; ++var7) {
            var8 = var2.readUnsignedShort();
            class186 var9 = new class186(class56.method849(var8));
            var1.switches[var7] = var9;

            while(var8-- > 0) {
               int var10 = var2.readInt();
               int var11 = var2.readInt();
               var9.method3479(new WidgetConfig(var11), (long)var10);
            }
         }
      }

      var2.offset = 0;
      var2.getNullString();
      var1.instructions = new int[var5];
      var1.intOperands = new int[var5];
      var1.stringOperands = new String[var5];

      for(var7 = 0; var2.offset < var4; var1.instructions[var7++] = var8) {
         var8 = var2.readUnsignedShort();
         if(var8 == 3) {
            var1.stringOperands[var7] = var2.readString();
         } else if(var8 < 100 && var8 != 21 && var8 != 38 && var8 != 39) {
            var1.intOperands[var7] = var2.readInt();
         } else {
            var1.intOperands[var7] = var2.readUnsignedByte();
         }
      }

      return var1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)[Lclass91;",
      garbageValue = "13"
   )
   static class91[] method739() {
      return new class91[]{class91.field1440, class91.field1441, class91.field1442, class91.field1439};
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(IIII)I",
      garbageValue = "-1478645957"
   )
   @Export("getSmoothNoise")
   static final int getSmoothNoise(int var0, int var1, int var2) {
      int var3 = var0 / var2;
      int var4 = var0 & var2 - 1;
      int var5 = var1 / var2;
      int var6 = var1 & var2 - 1;
      int var7 = class17.getSmoothNoise2D(var3, var5);
      int var8 = class17.getSmoothNoise2D(var3 + 1, var5);
      int var9 = class17.getSmoothNoise2D(var3, var5 + 1);
      int var10 = class17.getSmoothNoise2D(var3 + 1, var5 + 1);
      int var12 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var11 = ((65536 - var12) * var7 >> 16) + (var8 * var12 >> 16);
      int var14 = 65536 - Graphics3D.COSINE[var4 * 1024 / var2] >> 1;
      int var13 = (var10 * var14 >> 16) + ((65536 - var14) * var9 >> 16);
      int var16 = 65536 - Graphics3D.COSINE[var6 * 1024 / var2] >> 1;
      int var15 = ((65536 - var16) * var11 >> 16) + (var13 * var16 >> 16);
      return var15;
   }
}
