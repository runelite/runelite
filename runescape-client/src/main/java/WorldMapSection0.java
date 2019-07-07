import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
@Implements("WorldMapSection0")
public class WorldMapSection0 implements WorldMapSection {
   @ObfuscatedName("sn")
   @ObfuscatedGetter(
      intValue = -1946112139
   )
   static int field1055;
   @ObfuscatedName("p")
   static int[] field1056;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2011838881
   )
   int field1057;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1299225715
   )
   int field1058;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 82600709
   )
   int field1059;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -477370575
   )
   int field1060;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -671345527
   )
   int field1061;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 529427495
   )
   int field1062;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -150870205
   )
   int field1063;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1009718107
   )
   int field1064;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1022177315
   )
   int field1065;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1397517463
   )
   int field1066;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -799353317
   )
   int field1067;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1388959491
   )
   int field1068;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1657956317
   )
   int field1069;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1345061881
   )
   int field1070;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lag;I)V",
      garbageValue = "1384899025"
   )
   @Export("expandBounds")
   public void expandBounds(WorldMapArea var1) {
      if (var1.minX0 > this.field1061) {
         var1.minX0 = this.field1061;
      }

      if (var1.maxX0 < this.field1061) {
         var1.maxX0 = this.field1061;
      }

      if (var1.minY0 > this.field1062) {
         var1.minY0 = this.field1062;
      }

      if (var1.maxY0 < this.field1062) {
         var1.maxY0 = this.field1062;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "93"
   )
   @Export("containsCoord")
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.field1057 && var1 < this.field1057 + this.field1058 ? var2 >= (this.field1059 << 6) + (this.field1063 << 3) && var2 <= (this.field1059 << 6) + (this.field1065 << 3) + 7 && var3 >= (this.field1060 << 6) + (this.field1064 << 3) && var3 <= (this.field1060 << 6) + (this.field1066 << 3) + 7 : false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "4"
   )
   @Export("containsPosition")
   public boolean containsPosition(int var1, int var2) {
      return var1 >= (this.field1061 << 6) + (this.field1067 << 3) && var1 <= (this.field1061 << 6) + (this.field1069 << 3) + 7 && var2 >= (this.field1062 << 6) + (this.field1068 << 3) && var2 <= (this.field1062 << 6) + (this.field1070 << 3) + 7;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1545934424"
   )
   @Export("position")
   public int[] position(int var1, int var2, int var3) {
      if (!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field1061 * 64 - this.field1059 * 64 + var2 + (this.field1067 * 8 - this.field1063 * 8), var3 + (this.field1062 * 64 - this.field1060 * 64) + (this.field1068 * 8 - this.field1064 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)Lhu;",
      garbageValue = "-1916486802"
   )
   @Export("coord")
   public Coord coord(int var1, int var2) {
      if (!this.containsPosition(var1, var2)) {
         return null;
      } else {
         int var3 = this.field1059 * 64 - this.field1061 * 64 + (this.field1063 * 8 - this.field1067 * 8) + var1;
         int var4 = this.field1060 * 64 - this.field1062 * 64 + var2 + (this.field1064 * 8 - this.field1068 * 8);
         return new Coord(this.field1057, var3, var4);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lgr;B)V",
      garbageValue = "-113"
   )
   @Export("read")
   public void read(Buffer var1) {
      this.field1057 = var1.readUnsignedByte();
      this.field1058 = var1.readUnsignedByte();
      this.field1059 = var1.readUnsignedShort();
      this.field1063 = var1.readUnsignedByte();
      this.field1065 = var1.readUnsignedByte();
      this.field1060 = var1.readUnsignedShort();
      this.field1064 = var1.readUnsignedByte();
      this.field1066 = var1.readUnsignedByte();
      this.field1061 = var1.readUnsignedShort();
      this.field1067 = var1.readUnsignedByte();
      this.field1069 = var1.readUnsignedByte();
      this.field1062 = var1.readUnsignedShort();
      this.field1068 = var1.readUnsignedByte();
      this.field1070 = var1.readUnsignedByte();
      this.method423();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1967186894"
   )
   void method423() {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2102591569"
   )
   @Export("savePreferences")
   static void savePreferences() {
      AccessFile var0 = null;

      try {
         var0 = LoginPacket.getPreferencesFile("", class22.studioGame.name, true);
         Buffer var1 = ReflectionCheck.clientPreferences.toBuffer();
         var0.write(var1.array, 0, var1.index);
      } catch (Exception var3) {
      }

      try {
         if (var0 != null) {
            var0.closeSync(true);
         }
      } catch (Exception var2) {
      }

   }

   @ObfuscatedName("hz")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1886145284"
   )
   static final void method245(int var0) {
      if (var0 >= 0) {
         int var1 = Client.menuArguments1[var0];
         int var2 = Client.menuArguments2[var0];
         int var3 = Client.menuOpcodes[var0];
         int var4 = Client.menuArguments0[var0];
         String var5 = Client.menuActions[var0];
         String var6 = Client.menuTargetNames[var0];
         Actor.menuAction(var1, var2, var3, var4, var5, var6, MouseHandler.MouseHandler_lastPressedX, MouseHandler.MouseHandler_lastPressedY);
      }

   }

   @ObfuscatedName("io")
   @ObfuscatedSignature(
      signature = "(Lho;IIIIIII)V",
      garbageValue = "-1723792771"
   )
   static final void method246(Widget var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      if (Client.field188) {
         Client.field189 = 32;
      } else {
         Client.field189 = 0;
      }

      Client.field188 = false;
      int var7;
      if (MouseHandler.MouseHandler_currentButton == 1 || !AbstractRasterProvider.mouseCam && MouseHandler.MouseHandler_currentButton == 4) {
         if (var5 >= var1 && var5 < var1 + 16 && var6 >= var2 && var6 < var2 + 16) {
            var0.scrollY -= 4;
            class22.method295(var0);
         } else if (var5 >= var1 && var5 < var1 + 16 && var6 >= var3 + var2 - 16 && var6 < var3 + var2) {
            var0.scrollY += 4;
            class22.method295(var0);
         } else if (var5 >= var1 - Client.field189 && var5 < Client.field189 + var1 + 16 && var6 >= var2 + 16 && var6 < var3 + var2 - 16) {
            var7 = var3 * (var3 - 32) / var4;
            if (var7 < 8) {
               var7 = 8;
            }

            int var8 = var6 - var2 - 16 - var7 / 2;
            int var9 = var3 - 32 - var7;
            var0.scrollY = var8 * (var4 - var3) / var9;
            class22.method295(var0);
            Client.field188 = true;
         }
      }

      if (Client.mouseWheelRotation != 0) {
         var7 = var0.width;
         if (var5 >= var1 - var7 && var6 >= var2 && var5 < var1 + 16 && var6 <= var3 + var2) {
            var0.scrollY += Client.mouseWheelRotation * 45;
            class22.method295(var0);
         }
      }

   }
}
