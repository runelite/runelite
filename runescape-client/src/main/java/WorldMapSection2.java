import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ah")
@Implements("WorldMapSection2")
public class WorldMapSection2 implements WorldMapSection {
   @ObfuscatedName("l")
   @Export("__ah_l")
   static int[] __ah_l;
   @ObfuscatedName("j")
   @Export("cacheDirectoryLocations")
   public static String[] cacheDirectoryLocations;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1561552223
   )
   @Export("__m")
   int __m;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -245382089
   )
   @Export("__f")
   int __f;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1024859679
   )
   @Export("__q")
   int __q;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 40495485
   )
   @Export("__w")
   int __w;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 982234927
   )
   @Export("__o")
   int __o;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1272330125
   )
   @Export("__u")
   int __u;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lag;I)V",
      garbageValue = "1384899025"
   )
   public void expandBounds(WorldMapArea var1) {
      if(var1.minX0 > this.__o) {
         var1.minX0 = this.__o;
      }

      if(var1.maxX0 < this.__o) {
         var1.maxX0 = this.__o;
      }

      if(var1.minY0 > this.__u) {
         var1.minY0 = this.__u;
      }

      if(var1.maxY0 < this.__u) {
         var1.maxY0 = this.__u;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "93"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.__m && var1 < this.__m + this.__f?var2 >> 6 == this.__q && var3 >> 6 == this.__w:false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "4"
   )
   public boolean containsPosition(int var1, int var2) {
      return var1 >> 6 == this.__o && var2 >> 6 == this.__u;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "1545934424"
   )
   public int[] position(int var1, int var2, int var3) {
      if(!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.__o * 64 - this.__q * 64 + var2, var3 + (this.__u * 64 - this.__w * 64)};
         return var4;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)Lhu;",
      garbageValue = "-1916486802"
   )
   public TileLocation coord(int var1, int var2) {
      if(!this.containsPosition(var1, var2)) {
         return null;
      } else {
         int var3 = this.__q * 64 - this.__o * 64 + var1;
         int var4 = this.__w * 64 - this.__u * 64 + var2;
         return new TileLocation(this.__m, var3, var4);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lgr;B)V",
      garbageValue = "-113"
   )
   public void read(Buffer var1) {
      this.__m = var1.readUnsignedByte();
      this.__f = var1.readUnsignedByte();
      this.__q = var1.__ag_302();
      this.__w = var1.__ag_302();
      this.__o = var1.__ag_302();
      this.__u = var1.__ag_302();
      this.__g_65();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1602858772"
   )
   @Export("__g_65")
   void __g_65() {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "409746497"
   )
   @Export("getVarbit")
   public static int getVarbit(int var0) {
      VarbitDefinition var1 = Occluder.method3255(var0);
      int var2 = var1.varp;
      int var3 = var1.lowBit;
      int var4 = var1.highBit;
      int var5 = Varps.Varps_masks[var4 - var3];
      return Varps.Varps_main[var2] >> var3 & var5;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IILfe;Lfy;I)Z",
      garbageValue = "-2025028346"
   )
   static final boolean method593(int var0, int var1, class179 var2, CollisionMap var3) {
      int var4 = var0;
      int var5 = var1;
      byte var6 = 64;
      byte var7 = 64;
      int var8 = var0 - var6;
      int var9 = var1 - var7;
      class178.__fi_q[var6][var7] = 99;
      class178.__fi_w[var6][var7] = 0;
      byte var10 = 0;
      int var11 = 0;
      class178.__fi_l[var10] = var0;
      byte var10001 = var10;
      int var18 = var10 + 1;
      class178.__fi_e[var10001] = var1;
      int[][] var12 = var3.flags;

      while(var18 != var11) {
         var4 = class178.__fi_l[var11];
         var5 = class178.__fi_e[var11];
         var11 = var11 + 1 & 4095;
         int var16 = var4 - var8;
         int var17 = var5 - var9;
         int var13 = var4 - var3.xInset;
         int var14 = var5 - var3.yInset;
         if(var2.vmethod3644(2, var4, var5, var3)) {
            WidgetGroupParent.__bx_o = var4;
            UrlRequester.__eo_u = var5;
            return true;
         }

         int var15 = class178.__fi_w[var16][var17] + 1;
         if(var16 > 0 && class178.__fi_q[var16 - 1][var17] == 0 && (var12[var13 - 1][var14] & 19136782) == 0 && (var12[var13 - 1][var14 + 1] & 19136824) == 0) {
            class178.__fi_l[var18] = var4 - 1;
            class178.__fi_e[var18] = var5;
            var18 = var18 + 1 & 4095;
            class178.__fi_q[var16 - 1][var17] = 2;
            class178.__fi_w[var16 - 1][var17] = var15;
         }

         if(var16 < 126 && class178.__fi_q[var16 + 1][var17] == 0 && (var12[var13 + 2][var14] & 19136899) == 0 && (var12[var13 + 2][var14 + 1] & 19136992) == 0) {
            class178.__fi_l[var18] = var4 + 1;
            class178.__fi_e[var18] = var5;
            var18 = var18 + 1 & 4095;
            class178.__fi_q[var16 + 1][var17] = 8;
            class178.__fi_w[var16 + 1][var17] = var15;
         }

         if(var17 > 0 && class178.__fi_q[var16][var17 - 1] == 0 && (var12[var13][var14 - 1] & 19136782) == 0 && (var12[var13 + 1][var14 - 1] & 19136899) == 0) {
            class178.__fi_l[var18] = var4;
            class178.__fi_e[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class178.__fi_q[var16][var17 - 1] = 1;
            class178.__fi_w[var16][var17 - 1] = var15;
         }

         if(var17 < 126 && class178.__fi_q[var16][var17 + 1] == 0 && (var12[var13][var14 + 2] & 19136824) == 0 && (var12[var13 + 1][var14 + 2] & 19136992) == 0) {
            class178.__fi_l[var18] = var4;
            class178.__fi_e[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class178.__fi_q[var16][var17 + 1] = 4;
            class178.__fi_w[var16][var17 + 1] = var15;
         }

         if(var16 > 0 && var17 > 0 && class178.__fi_q[var16 - 1][var17 - 1] == 0 && (var12[var13 - 1][var14] & 19136830) == 0 && (var12[var13 - 1][var14 - 1] & 19136782) == 0 && (var12[var13][var14 - 1] & 19136911) == 0) {
            class178.__fi_l[var18] = var4 - 1;
            class178.__fi_e[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class178.__fi_q[var16 - 1][var17 - 1] = 3;
            class178.__fi_w[var16 - 1][var17 - 1] = var15;
         }

         if(var16 < 126 && var17 > 0 && class178.__fi_q[var16 + 1][var17 - 1] == 0 && (var12[var13 + 1][var14 - 1] & 19136911) == 0 && (var12[var13 + 2][var14 - 1] & 19136899) == 0 && (var12[var13 + 2][var14] & 19136995) == 0) {
            class178.__fi_l[var18] = var4 + 1;
            class178.__fi_e[var18] = var5 - 1;
            var18 = var18 + 1 & 4095;
            class178.__fi_q[var16 + 1][var17 - 1] = 9;
            class178.__fi_w[var16 + 1][var17 - 1] = var15;
         }

         if(var16 > 0 && var17 < 126 && class178.__fi_q[var16 - 1][var17 + 1] == 0 && (var12[var13 - 1][var14 + 1] & 19136830) == 0 && (var12[var13 - 1][var14 + 2] & 19136824) == 0 && (var12[var13][var14 + 2] & 19137016) == 0) {
            class178.__fi_l[var18] = var4 - 1;
            class178.__fi_e[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class178.__fi_q[var16 - 1][var17 + 1] = 6;
            class178.__fi_w[var16 - 1][var17 + 1] = var15;
         }

         if(var16 < 126 && var17 < 126 && class178.__fi_q[var16 + 1][var17 + 1] == 0 && (var12[var13 + 1][var14 + 2] & 19137016) == 0 && (var12[var13 + 2][var14 + 2] & 19136992) == 0 && (var12[var13 + 2][var14 + 1] & 19136995) == 0) {
            class178.__fi_l[var18] = var4 + 1;
            class178.__fi_e[var18] = var5 + 1;
            var18 = var18 + 1 & 4095;
            class178.__fi_q[var16 + 1][var17 + 1] = 12;
            class178.__fi_w[var16 + 1][var17 + 1] = var15;
         }
      }

      WidgetGroupParent.__bx_o = var4;
      UrlRequester.__eo_u = var5;
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

      for(int var6 = 0; var6 < var2; ++var6) {
         Player var7 = Client.players[var3[var6]];
         if(var7 != null && var7 != Canvas.localPlayer && var7.username != null && var7.username.__equals_466(var5)) {
            PacketBufferNode var8;
            if(var0 == 1) {
               var8 = Interpreter.method1915(ClientPacket.__gs_ao, Client.packetWriter.isaacCipher);
               var8.packetBuffer.writeShort(var3[var6]);
               var8.packetBuffer.__ai_315(0);
               Client.packetWriter.__q_167(var8);
            } else if(var0 == 4) {
               var8 = Interpreter.method1915(ClientPacket.__gs_aq, Client.packetWriter.isaacCipher);
               var8.packetBuffer.__bx_323(var3[var6]);
               var8.packetBuffer.__ai_315(0);
               Client.packetWriter.__q_167(var8);
            } else if(var0 == 6) {
               var8 = Interpreter.method1915(ClientPacket.__gs_cf, Client.packetWriter.isaacCipher);
               var8.packetBuffer.__bo_322(var3[var6]);
               var8.packetBuffer.__ba_316(0);
               Client.packetWriter.__q_167(var8);
            } else if(var0 == 7) {
               var8 = Interpreter.method1915(ClientPacket.__gs_be, Client.packetWriter.isaacCipher);
               var8.packetBuffer.__ba_316(0);
               var8.packetBuffer.writeShortLE(var3[var6]);
               Client.packetWriter.__q_167(var8);
            }

            var4 = true;
            break;
         }
      }

      if(!var4) {
         WorldMapIcon1.method219(4, "", "Unable to find " + var1);
      }

   }
}
