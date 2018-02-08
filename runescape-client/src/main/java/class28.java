import java.util.LinkedList;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("aq")
public abstract class class28 {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1407785787
   )
   int field398;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1021091459
   )
   int field389;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1340443107
   )
   int field390;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -111656289
   )
   int field394;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1179071075
   )
   int field391;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1580735955
   )
   int field393;
   @ObfuscatedName("t")
   short[][][] field388;
   @ObfuscatedName("d")
   short[][][] field395;
   @ObfuscatedName("z")
   byte[][][] field396;
   @ObfuscatedName("k")
   byte[][][] field397;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "[[[[Laf;"
   )
   class31[][][][] field392;

   class28() {
      new LinkedList();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IILgy;B)V",
      garbageValue = "90"
   )
   void method214(int var1, int var2, Buffer var3) {
      int var4 = var3.readUnsignedByte();
      if(var4 != 0) {
         if((var4 & 1) != 0) {
            this.method215(var1, var2, var3, var4);
         } else {
            this.method216(var1, var2, var3, var4);
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IILgy;II)V",
      garbageValue = "-2096414432"
   )
   void method215(int var1, int var2, Buffer var3, int var4) {
      boolean var5 = (var4 & 2) != 0;
      if(var5) {
         this.field395[0][var1][var2] = (short)var3.readUnsignedByte();
      }

      this.field388[0][var1][var2] = (short)var3.readUnsignedByte();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IILgy;IB)V",
      garbageValue = "88"
   )
   void method216(int var1, int var2, Buffer var3, int var4) {
      int var5 = ((var4 & 24) >> 3) + 1;
      boolean var6 = (var4 & 2) != 0;
      boolean var7 = (var4 & 4) != 0;
      this.field388[0][var1][var2] = (short)var3.readUnsignedByte();
      int var8;
      int var9;
      int var11;
      if(var6) {
         var8 = var3.readUnsignedByte();

         for(var9 = 0; var9 < var8; ++var9) {
            int var10 = var3.readUnsignedByte();
            if(var10 != 0) {
               this.field395[var9][var1][var2] = (short)var10;
               var11 = var3.readUnsignedByte();
               this.field396[var9][var1][var2] = (byte)(var11 >> 2);
               this.field397[var9][var1][var2] = (byte)(var11 & 3);
            }
         }
      }

      if(var7) {
         for(var8 = 0; var8 < var5; ++var8) {
            var9 = var3.readUnsignedByte();
            if(var9 != 0) {
               class31[] var14 = this.field392[var8][var1][var2] = new class31[var9];

               for(var11 = 0; var11 < var9; ++var11) {
                  int var12 = var3.method3715();
                  int var13 = var3.readUnsignedByte();
                  var14[var11] = new class31(var12, var13 >> 2, var13 & 3);
               }
            }
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-791943184"
   )
   int method217(int var1, int var2) {
      return var1 >= 0 && var2 >= 0?(var1 < 64 && var2 < 64?this.field388[0][var1][var2] - 1:-1):-1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-65"
   )
   int method218() {
      return this.field390;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1203354347"
   )
   int method219() {
      return this.field394;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-602184626"
   )
   static int method239(int var0, int var1) {
      if(var0 == -2) {
         return 12345678;
      } else if(var0 == -1) {
         if(var1 < 0) {
            var1 = 0;
         } else if(var1 > 127) {
            var1 = 127;
         }

         var1 = 127 - var1;
         return var1;
      } else {
         var1 = (var0 & 127) * var1 / 128;
         if(var1 < 2) {
            var1 = 2;
         } else if(var1 > 126) {
            var1 = 126;
         }

         return (var0 & 65408) + var1;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "2105525202"
   )
   public static int method241(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }

   @ObfuscatedName("gs")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "30000"
   )
   static final void method231() {
      Client.myPlayerIndex = 0;
      int var0 = (GroundObject.localPlayer.x >> 7) + ClanMemberManager.baseX;
      int var1 = (GroundObject.localPlayer.y >> 7) + WorldMapData.baseY;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.myPlayerIndex = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.myPlayerIndex = 1;
      }

      if(Client.myPlayerIndex == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.myPlayerIndex = 0;
      }

   }

   @ObfuscatedName("ko")
   @ObfuscatedSignature(
      signature = "(Lhs;B)Ljava/lang/String;",
      garbageValue = "79"
   )
   static String method240(Widget var0) {
      int var2 = WorldComparator.getWidgetConfig(var0);
      int var1 = var2 >> 11 & 63;
      return var1 == 0?null:(var0.selectedAction != null && var0.selectedAction.trim().length() != 0?var0.selectedAction:null);
   }
}
