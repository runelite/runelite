import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ek")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   @Export("widgetIndex")
   public static IndexDataBase widgetIndex;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -402308395
   )
   static int field2042;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 740167325
   )
   @Export("id")
   int id;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1422185657
   )
   @Export("count")
   int count;
   @ObfuscatedName("e")
   @Export("types")
   int[] types;
   @ObfuscatedName("p")
   @Export("list")
   int[][] list;

   FrameMap(int var1, byte[] var2) {
      this.id = var1;
      Buffer var3 = new Buffer(var2);
      this.count = var3.readUnsignedByte();
      this.types = new int[this.count];
      this.list = new int[this.count][];

      int var4;
      for(var4 = 0; var4 < this.count; ++var4) {
         this.types[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         this.list[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         for(int var5 = 0; var5 < this.list[var4].length; ++var5) {
            this.list[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("fj")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "1"
   )
   @Export("setGameState")
   static void setGameState(int var0) {
      if(var0 != Client.gameState) {
         if(Client.gameState == 0) {
            PendingSpawn.clientInstance.method900();
         }

         if(var0 == 20 || var0 == 40 || var0 == 45) {
            Client.loginState = 0;
            Client.field1030 = 0;
            Client.field1138 = 0;
            Client.field929.method4991(var0);
            if(var0 != 20) {
               class204.method3924(false);
            }
         }

         if(var0 != 20 && var0 != 40 && class54.field688 != null) {
            class54.field688.close();
            class54.field688 = null;
         }

         if(Client.gameState == 25) {
            Client.field1031 = 0;
            Client.field982 = 0;
            Client.field979 = 1;
            Client.field980 = 0;
            Client.field1173 = 1;
         }

         if(var0 != 5 && var0 != 10) {
            if(var0 == 20) {
               class51.method792(Client.field1193, class37.indexSprites, true, Client.gameState == 11?4:0);
            } else if(var0 == 11) {
               class51.method792(Client.field1193, class37.indexSprites, false, 4);
            } else {
               PendingSpawn.method1585();
            }
         } else {
            class51.method792(Client.field1193, class37.indexSprites, true, 0);
         }

         Client.gameState = var0;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-543431994"
   )
   public static void method2754() {
      class281.field3766 = new CombatInfoList();
   }
}
