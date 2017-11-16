import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cg")
@Implements("World")
public class World {
   @ObfuscatedName("oz")
   @ObfuscatedGetter(
      intValue = 1270752209
   )
   static int field1220;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -194705269
   )
   @Export("worldCount")
   static int worldCount;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -396859493
   )
   static int field1216;
   @ObfuscatedName("t")
   static int[] field1217;
   @ObfuscatedName("k")
   static int[] field1211;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1475165531
   )
   @Export("id")
   int id;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1015149273
   )
   @Export("mask")
   int mask;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1631526595
   )
   @Export("playerCount")
   int playerCount;
   @ObfuscatedName("q")
   @Export("address")
   String address;
   @ObfuscatedName("j")
   @Export("activity")
   String activity;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1543466589
   )
   @Export("location")
   int location;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -299436659
   )
   @Export("index")
   int index;

   static {
      worldCount = 0;
      field1216 = 0;
      field1217 = new int[]{1, 1, 1, 1};
      field1211 = new int[]{0, 1, 2, 3};
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1666681558"
   )
   boolean method1516() {
      return (1 & this.mask) != 0;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1048933916"
   )
   boolean method1517() {
      return (2 & this.mask) != 0;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-118"
   )
   boolean method1519() {
      return (4 & this.mask) != 0;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-17"
   )
   boolean method1549() {
      return (8 & this.mask) != 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1928544668"
   )
   boolean method1520() {
      return (536870912 & this.mask) != 0;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-64"
   )
   boolean method1521() {
      return (33554432 & this.mask) != 0;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IB)Z",
      garbageValue = "4"
   )
   public static boolean method1561(String var0, int var1) {
      return ScriptState.method1000(var0, var1, "openjs");
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgd;II)V",
      garbageValue = "-1067203506"
   )
   @Export("decodeMovement")
   static void decodeMovement(PacketBuffer var0, int var1) {
      boolean var2 = var0.getBits(1) == 1;
      if(var2) {
         class94.field1405[++class94.field1407 - 1] = var1;
      }

      int var3 = var0.getBits(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field818 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class94.field1404[var1] = (var4.field835 << 28) + (ClanMember.baseY + var4.pathY[0] >> 13) + (class13.baseX + var4.pathX[0] >> 13 << 14);
            if(var4.field1172 != -1) {
               class94.field1395[var1] = var4.field1172;
            } else {
               class94.field1395[var1] = var4.orientation;
            }

            class94.field1409[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.getBits(1) != 0) {
               class268.decodeRegionHash(var0, var1);
            }

         }
      } else {
         int var5;
         int var6;
         int var7;
         if(var3 == 1) {
            var5 = var0.getBits(3);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               --var6;
               --var7;
            } else if(var5 == 1) {
               --var7;
            } else if(var5 == 2) {
               ++var6;
               --var7;
            } else if(var5 == 3) {
               --var6;
            } else if(var5 == 4) {
               ++var6;
            } else if(var5 == 5) {
               --var6;
               ++var7;
            } else if(var5 == 6) {
               ++var7;
            } else if(var5 == 7) {
               ++var6;
               ++var7;
            }

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1068(var6, var7);
               var4.field818 = false;
            } else if(var2) {
               var4.field818 = true;
               var4.field838 = var6;
               var4.field833 = var7;
            } else {
               var4.field818 = false;
               var4.method1071(var6, var7, class94.field1398[var1]);
            }

         } else if(var3 == 2) {
            var5 = var0.getBits(4);
            var6 = var4.pathX[0];
            var7 = var4.pathY[0];
            if(var5 == 0) {
               var6 -= 2;
               var7 -= 2;
            } else if(var5 == 1) {
               --var6;
               var7 -= 2;
            } else if(var5 == 2) {
               var7 -= 2;
            } else if(var5 == 3) {
               ++var6;
               var7 -= 2;
            } else if(var5 == 4) {
               var6 += 2;
               var7 -= 2;
            } else if(var5 == 5) {
               var6 -= 2;
               --var7;
            } else if(var5 == 6) {
               var6 += 2;
               --var7;
            } else if(var5 == 7) {
               var6 -= 2;
            } else if(var5 == 8) {
               var6 += 2;
            } else if(var5 == 9) {
               var6 -= 2;
               ++var7;
            } else if(var5 == 10) {
               var6 += 2;
               ++var7;
            } else if(var5 == 11) {
               var6 -= 2;
               var7 += 2;
            } else if(var5 == 12) {
               --var6;
               var7 += 2;
            } else if(var5 == 13) {
               var7 += 2;
            } else if(var5 == 14) {
               ++var6;
               var7 += 2;
            } else if(var5 == 15) {
               var6 += 2;
               var7 += 2;
            }

            if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
               if(var2) {
                  var4.field818 = true;
                  var4.field838 = var6;
                  var4.field833 = var7;
               } else {
                  var4.field818 = false;
                  var4.method1071(var6, var7, class94.field1398[var1]);
               }
            } else {
               var4.method1068(var6, var7);
               var4.field818 = false;
            }

         } else {
            var5 = var0.getBits(1);
            int var8;
            int var9;
            int var10;
            int var11;
            if(var5 == 0) {
               var6 = var0.getBits(12);
               var7 = var6 >> 10;
               var8 = var6 >> 5 & 31;
               if(var8 > 15) {
                  var8 -= 32;
               }

               var9 = var6 & 31;
               if(var9 > 15) {
                  var9 -= 32;
               }

               var10 = var8 + var4.pathX[0];
               var11 = var9 + var4.pathY[0];
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field818 = true;
                     var4.field838 = var10;
                     var4.field833 = var11;
                  } else {
                     var4.field818 = false;
                     var4.method1071(var10, var11, class94.field1398[var1]);
                  }
               } else {
                  var4.method1068(var10, var11);
                  var4.field818 = false;
               }

               var4.field835 = (byte)(var7 + var4.field835 & 3);
               if(Client.localInteractingIndex == var1) {
                  class28.plane = var4.field835;
               }

            } else {
               var6 = var0.getBits(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + class13.baseX + var4.pathX[0] & 16383) - class13.baseX;
               var11 = (var9 + ClanMember.baseY + var4.pathY[0] & 16383) - ClanMember.baseY;
               if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method1068(var10, var11);
                  var4.field818 = false;
               } else if(var2) {
                  var4.field818 = true;
                  var4.field838 = var10;
                  var4.field833 = var11;
               } else {
                  var4.field818 = false;
                  var4.method1071(var10, var11, class94.field1398[var1]);
               }

               var4.field835 = (byte)(var7 + var4.field835 & 3);
               if(Client.localInteractingIndex == var1) {
                  class28.plane = var4.field835;
               }

            }
         }
      }
   }

   @ObfuscatedName("fq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-2121686498"
   )
   static void method1532(int var0) {
      Client.field1016 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      if(PendingSpawn.method1494() == 1) {
         class289.clientInstance.method793(765, 503);
      } else {
         class289.clientInstance.method793(7680, 2160);
      }

      if(Client.gameState >= 25) {
         method1560();
      }

   }

   @ObfuscatedName("fd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-347690496"
   )
   static void method1560() {
      PacketNode var0 = class18.method133(ClientPacket.field2389, Client.field905.field1460);
      var0.packetBuffer.putByte(PendingSpawn.method1494());
      var0.packetBuffer.putShort(class66.canvasWidth);
      var0.packetBuffer.putShort(Item.canvasHeight);
      Client.field905.method1855(var0);
   }

   @ObfuscatedName("jp")
   @ObfuscatedSignature(
      signature = "(IIIILkb;Lhy;B)V",
      garbageValue = "-16"
   )
   static final void method1558(int var0, int var1, int var2, int var3, SpritePixels var4, class217 var5) {
      int var6 = var3 * var3 + var2 * var2;
      if(var6 > 4225 && var6 < 90000) {
         int var7 = Client.mapAngle & 2047;
         int var8 = Graphics3D.SINE[var7];
         int var9 = Graphics3D.COSINE[var7];
         int var10 = var9 * var2 + var3 * var8 >> 16;
         int var11 = var3 * var9 - var8 * var2 >> 16;
         double var12 = Math.atan2((double)var10, (double)var11);
         int var14 = var5.field2673 / 2 - 25;
         int var15 = (int)(Math.sin(var12) * (double)var14);
         int var16 = (int)(Math.cos(var12) * (double)var14);
         byte var17 = 20;
         MouseInput.mapedge.method5120(var15 + (var0 + var5.field2673 / 2 - var17 / 2), var5.field2672 / 2 + var1 - var17 / 2 - var16 - 10, var17, var17, 15, 15, var12, 256);
      } else {
         class3.drawDot(var0, var1, var2, var3, var4, var5);
      }

   }
}
