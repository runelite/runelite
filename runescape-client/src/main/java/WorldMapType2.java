import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ax")
@Implements("WorldMapType2")
public class WorldMapType2 implements WorldMapSectionBase {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1222124443
   )
   public static int field512;
   @ObfuscatedName("cp")
   static IndexData field502;
   @ObfuscatedName("fr")
   @ObfuscatedGetter(
      intValue = 1833869093
   )
   static int field514;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1909314997
   )
   @Export("intStackSize")
   static int intStackSize;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 695316785
   )
   int field508;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 84102399
   )
   int field506;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1668162209
   )
   int field503;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1233275837
   )
   int field509;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 756866593
   )
   int field504;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1794098943
   )
   int field505;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "-2141582860"
   )
   public boolean vmethod722(int var1, int var2) {
      return var1 >> 6 == this.field506 && var2 >> 6 == this.field509;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-1671303044"
   )
   public boolean vmethod721(int var1, int var2, int var3) {
      return var1 >= this.field508 && var1 < this.field503 + this.field508?var2 >> 6 == this.field504 && var3 >> 6 == this.field505:false;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(LWorldMapData;I)V",
      garbageValue = "-1824757307"
   )
   public void vmethod720(WorldMapData var1) {
      if(var1.field447 > this.field506) {
         var1.field447 = this.field506;
      }

      if(var1.field448 < this.field506) {
         var1.field448 = this.field506;
      }

      if(var1.field441 > this.field509) {
         var1.field441 = this.field509;
      }

      if(var1.field450 < this.field509) {
         var1.field450 = this.field509;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(III)LCoordinates;",
      garbageValue = "665140774"
   )
   public Coordinates vmethod743(int var1, int var2) {
      if(!this.vmethod722(var1, var2)) {
         return null;
      } else {
         int var3 = this.field504 * 64 - this.field506 * 64 + var1;
         int var4 = this.field505 * 64 - this.field509 * 64 + var2;
         return new Coordinates(this.field508, var3, var4);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "13"
   )
   public int[] vmethod731(int var1, int var2, int var3) {
      if(!this.vmethod721(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field506 * 64 - this.field504 * 64 + var2, var3 + (this.field509 * 64 - this.field505 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-9127"
   )
   void method509() {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1909314997"
   )
   public void vmethod746(Buffer var1) {
      this.field508 = var1.readUnsignedByte();
      this.field503 = var1.readUnsignedByte();
      this.field504 = var1.readUnsignedShort();
      this.field505 = var1.readUnsignedShort();
      this.field506 = var1.readUnsignedShort();
      this.field509 = var1.readUnsignedShort();
      this.method509();
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "1852138144"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            class28.clientInstance.method880();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field939 = 0;
            Client.field941 = 0;
         }

         if(var0 != 20 && var0 != 40 && class261.field3623 != null) {
            class261.field3623.close();
            class261.field3623 = null;
         }

         if(Client.gameState == 25) {
            Client.field971 = 0;
            Client.field961 = 0;
            Client.field962 = 1;
            Client.field963 = 0;
            Client.field964 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               IndexFile.method3007(class54.field660, class17.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               IndexFile.method3007(class54.field660, class17.indexSprites, false, 4);
            } else if(class92.field1426) {
               class92.field1419 = null;
               class208.field2595 = null;
               Frames.field2137 = null;
               XItemContainer.field781 = null;
               class8.field245 = null;
               class157.logoSprite = null;
               XClanMember.titlemuteSprite = null;
               ISAACCipher.field2431 = null;
               class228.field3151 = null;
               class92.field1437 = null;
               class92.field1418 = null;
               class175.field2409 = null;
               class10.field263 = null;
               Huffman.field2322 = null;
               class92.field1424 = null;
               class73.field864 = null;
               World.field1287 = null;
               class92.field1445 = null;
               Spotanim.field3339 = null;
               class18.field323 = null;
               class168.field2340 = null;
               class17.field312 = null;
               class203.field2501 = 1;
               class203.field2502 = null;
               class203.field2503 = -1;
               MilliTimer.field2204 = -1;
               class203.field2504 = 0;
               class203.field2505 = false;
               class73.field861 = 2;
               Actor.sendConInfo(true);
               class92.field1426 = false;
            }
         } else {
            IndexFile.method3007(class54.field660, class17.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "573458029"
   )
   static final int method535() {
      if(class23.preferences.hideRoofs) {
         return class45.plane;
      } else {
         int var0 = Actor.getTileHeight(class41.cameraX, class7.cameraY, class45.plane);
         return var0 - XItemContainer.cameraZ < 800 && (class61.tileSettings[class45.plane][class41.cameraX >> 7][class7.cameraY >> 7] & 4) != 0?class45.plane:3;
      }
   }
}
