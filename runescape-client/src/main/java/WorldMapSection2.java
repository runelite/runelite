import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("WorldMapSection2")
public class WorldMapSection2 implements WorldMapSection {
   @ObfuscatedName("l")
   static int[] field1082;
   @ObfuscatedName("j")
   @Export("cacheDirectoryLocations")
   public static String[] cacheDirectoryLocations;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1561552223
   )
   int field1083;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -245382089
   )
   int field1084;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1024859679
   )
   int field1085;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 40495485
   )
   int field1086;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 982234927
   )
   int field1087;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1272330125
   )
   int field1088;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lag;I)V",
      garbageValue = "1384899025"
   )
   @Export("expandBounds")
   public void expandBounds(WorldMapArea var1) {
      if (var1.minX0 > this.field1087) {
         var1.minX0 = this.field1087;
      }

      if (var1.maxX0 < this.field1087) {
         var1.maxX0 = this.field1087;
      }

      if (var1.minY0 > this.field1088) {
         var1.minY0 = this.field1088;
      }

      if (var1.maxY0 < this.field1088) {
         var1.maxY0 = this.field1088;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "93"
   )
   @Export("containsCoord")
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.field1083 && var1 < this.field1083 + this.field1084 ? var2 >> 6 == this.field1085 && var3 >> 6 == this.field1086 : false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "4"
   )
   @Export("containsPosition")
   public boolean containsPosition(int var1, int var2) {
      return var1 >> 6 == this.field1087 && var2 >> 6 == this.field1088;
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
         int[] var4 = new int[]{this.field1087 * 64 - this.field1085 * 64 + var2, var3 + (this.field1088 * 64 - this.field1086 * 64)};
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
         int var3 = this.field1085 * 64 - this.field1087 * 64 + var1;
         int var4 = this.field1086 * 64 - this.field1088 * 64 + var2;
         return new Coord(this.field1083, var3, var4);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lgr;B)V",
      garbageValue = "-113"
   )
   @Export("read")
   public void read(Buffer var1) {
      this.field1083 = var1.readUnsignedByte();
      this.field1084 = var1.readUnsignedByte();
      this.field1085 = var1.readUnsignedShort();
      this.field1086 = var1.readUnsignedShort();
      this.field1087 = var1.readUnsignedShort();
      this.field1088 = var1.readUnsignedShort();
      this.method425();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1602858772"
   )
   void method425() {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "409746497"
   )
   @Export("getVarbit")
   public static int getVarbit(int var0) {
      VarbitDefinition var1 = Occluder.method3255(var0);
      int var2 = var1.baseVar;
      int var3 = var1.startBit;
      int var4 = var1.endBit;
      int var5 = Varps.Varps_masks[var4 - var3];
      return Varps.Varps_main[var2] >> var3 & var5;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IILfe;Lfy;I)Z",
      garbageValue = "-2025028346"
   )
   static final boolean method593(int var0, int var1, RouteStrategy var2, CollisionMap var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class178.directions[var6][var7] = 99;
      class178.distances[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class178.bufferX[var10] = var0;
      int var12 = var10 + 1;
      class178.bufferY[var10] = var1;
      int[][] var13 = var3.flags;

      while (var12 != var11) {
         var4 = class178.bufferX[var11];
         var5 = class178.bufferY[var11];
         var11 = var11 + 1 & 4095;
         int var14 = var4 - var8;
         int var15 = var5 - var9;
         int var16 = var4 - var3.xInset;
         int var17 = var5 - var3.yInset;
         if (var2.vmethod3644(2, var4, var5, var3)) {
            InterfaceParent.field986 = var4;
            UrlRequester.field929 = var5;
            return true;
         }

         int var18 = class178.distances[var14][var15] + 1;
         if (var14 > 0 && class178.directions[var14 - 1][var15] == 0 && (var13[var16 - 1][var17] & 19136782) == 0 && (var13[var16 - 1][var17 + 1] & 19136824) == 0) {
            class178.bufferX[var12] = var4 - 1;
            class178.bufferY[var12] = var5;
            var12 = var12 + 1 & 4095;
            class178.directions[var14 - 1][var15] = 2;
            class178.distances[var14 - 1][var15] = var18;
         }

         if (var14 < 126 && class178.directions[var14 + 1][var15] == 0 && (var13[var16 + 2][var17] & 19136899) == 0 && (var13[var16 + 2][var17 + 1] & 19136992) == 0) {
            class178.bufferX[var12] = var4 + 1;
            class178.bufferY[var12] = var5;
            var12 = var12 + 1 & 4095;
            class178.directions[var14 + 1][var15] = 8;
            class178.distances[var14 + 1][var15] = var18;
         }

         if (var15 > 0 && class178.directions[var14][var15 - 1] == 0 && (var13[var16][var17 - 1] & 19136782) == 0 && (var13[var16 + 1][var17 - 1] & 19136899) == 0) {
            class178.bufferX[var12] = var4;
            class178.bufferY[var12] = var5 - 1;
            var12 = var12 + 1 & 4095;
            class178.directions[var14][var15 - 1] = 1;
            class178.distances[var14][var15 - 1] = var18;
         }

         if (var15 < 126 && class178.directions[var14][var15 + 1] == 0 && (var13[var16][var17 + 2] & 19136824) == 0 && (var13[var16 + 1][var17 + 2] & 19136992) == 0) {
            class178.bufferX[var12] = var4;
            class178.bufferY[var12] = var5 + 1;
            var12 = var12 + 1 & 4095;
            class178.directions[var14][var15 + 1] = 4;
            class178.distances[var14][var15 + 1] = var18;
         }

         if (var14 > 0 && var15 > 0 && class178.directions[var14 - 1][var15 - 1] == 0 && (var13[var16 - 1][var17] & 19136830) == 0 && (var13[var16 - 1][var17 - 1] & 19136782) == 0 && (var13[var16][var17 - 1] & 19136911) == 0) {
            class178.bufferX[var12] = var4 - 1;
            class178.bufferY[var12] = var5 - 1;
            var12 = var12 + 1 & 4095;
            class178.directions[var14 - 1][var15 - 1] = 3;
            class178.distances[var14 - 1][var15 - 1] = var18;
         }

         if (var14 < 126 && var15 > 0 && class178.directions[var14 + 1][var15 - 1] == 0 && (var13[var16 + 1][var17 - 1] & 19136911) == 0 && (var13[var16 + 2][var17 - 1] & 19136899) == 0 && (var13[var16 + 2][var17] & 19136995) == 0) {
            class178.bufferX[var12] = var4 + 1;
            class178.bufferY[var12] = var5 - 1;
            var12 = var12 + 1 & 4095;
            class178.directions[var14 + 1][var15 - 1] = 9;
            class178.distances[var14 + 1][var15 - 1] = var18;
         }

         if (var14 > 0 && var15 < 126 && class178.directions[var14 - 1][var15 + 1] == 0 && (var13[var16 - 1][var17 + 1] & 19136830) == 0 && (var13[var16 - 1][var17 + 2] & 19136824) == 0 && (var13[var16][var17 + 2] & 19137016) == 0) {
            class178.bufferX[var12] = var4 - 1;
            class178.bufferY[var12] = var5 + 1;
            var12 = var12 + 1 & 4095;
            class178.directions[var14 - 1][var15 + 1] = 6;
            class178.distances[var14 - 1][var15 + 1] = var18;
         }

         if (var14 < 126 && var15 < 126 && class178.directions[var14 + 1][var15 + 1] == 0 && (var13[var16 + 1][var17 + 2] & 19137016) == 0 && (var13[var16 + 2][var17 + 2] & 19136992) == 0 && (var13[var16 + 2][var17 + 1] & 19136995) == 0) {
            class178.bufferX[var12] = var4 + 1;
            class178.bufferY[var12] = var5 + 1;
            var12 = var12 + 1 & 4095;
            class178.directions[var14 + 1][var15 + 1] = 12;
            class178.distances[var14 + 1][var15 + 1] = var18;
         }
      }

      InterfaceParent.field986 = var4;
      UrlRequester.field929 = var5;
      return false;
   }

   @ObfuscatedName("hc")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)V",
      garbageValue = "-1850233906"
   )
   static void method583(int var0, String var1) {
      int var2 = Players.Players_count;
      int[] var3 = Players.Players_indices;
      boolean var4 = false;
      Username var5 = new Username(var1, KeyHandler.loginType);

      for (int var6 = 0; var6 < var2; ++var6) {
         Player var7 = Client.players[var3[var6]];
         if (var7 != null && var7 != Canvas.localPlayer && var7.username != null && var7.username.equals(var5)) {
            PacketBufferNode var8;
            if (var0 == 1) {
               var8 = Interpreter.method1915(ClientPacket.field269, Client.packetWriter.isaacCipher);
               var8.packetBuffer.writeShort(var3[var6]);
               var8.packetBuffer.method56(0);
               Client.packetWriter.method241(var8);
            } else if (var0 == 4) {
               var8 = Interpreter.method1915(ClientPacket.field249, Client.packetWriter.isaacCipher);
               var8.packetBuffer.method64(var3[var6]);
               var8.packetBuffer.method56(0);
               Client.packetWriter.method241(var8);
            } else if (var0 == 6) {
               var8 = Interpreter.method1915(ClientPacket.field315, Client.packetWriter.isaacCipher);
               var8.packetBuffer.method63(var3[var6]);
               var8.packetBuffer.method57(0);
               Client.packetWriter.method241(var8);
            } else if (var0 == 7) {
               var8 = Interpreter.method1915(ClientPacket.field297, Client.packetWriter.isaacCipher);
               var8.packetBuffer.method57(0);
               var8.packetBuffer.writeShortLE(var3[var6]);
               Client.packetWriter.method241(var8);
            }

            var4 = true;
            break;
         }
      }

      if (!var4) {
         WorldMapIcon1.addGameMessage(4, "", "Unable to find " + var1);
      }

   }
}
