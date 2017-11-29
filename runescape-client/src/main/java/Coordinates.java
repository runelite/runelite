import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hp")
@Implements("Coordinates")
public class Coordinates {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1062948969
   )
   @Export("plane")
   public int plane;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1494637119
   )
   @Export("worldY")
   public int worldY;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1934740597
   )
   @Export("worldX")
   public int worldX;

   public Coordinates() {
      this.plane = -1;
   }

   @ObfuscatedSignature(
      signature = "(Lhp;)V"
   )
   public Coordinates(Coordinates var1) {
      this.plane = var1.plane;
      this.worldX = var1.worldX;
      this.worldY = var1.worldY;
   }

   public Coordinates(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   public Coordinates(int var1) {
      if(var1 == -1) {
         this.plane = -1;
      } else {
         this.plane = var1 >> 28 & 3;
         this.worldX = var1 >> 14 & 16383;
         this.worldY = var1 & 16383;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIII)V",
      garbageValue = "1983505004"
   )
   @Export("set")
   public void set(int var1, int var2, int var3) {
      this.plane = var1;
      this.worldX = var2;
      this.worldY = var3;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1734210977"
   )
   public int method4109() {
      return this.plane << 28 | this.worldX << 14 | this.worldY;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lhp;I)Z",
      garbageValue = "1157417229"
   )
   boolean method4111(Coordinates var1) {
      return this.plane != var1.plane?false:(this.worldX != var1.worldX?false:this.worldY == var1.worldY);
   }

   public boolean equals(Object var1) {
      return this == var1?true:(!(var1 instanceof Coordinates)?false:this.method4111((Coordinates)var1));
   }

   public String toString() {
      return this.plane + "," + (this.worldX >> 6) + "," + (this.worldY >> 6) + "," + (this.worldX & 63) + "," + (this.worldY & 63);
   }

   public int hashCode() {
      return this.method4109();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lid;I)V",
      garbageValue = "1201983568"
   )
   public static void method4123(IndexDataBase var0) {
      class258.field3454 = var0;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgv;II)V",
      garbageValue = "2067486184"
   )
   @Export("decodeMovement")
   static void decodeMovement(PacketBuffer var0, int var1) {
      boolean var2 = var0.getBits(1) == 1;
      if(var2) {
         class94.field1420[++class94.field1419 - 1] = var1;
      }

      int var3 = var0.getBits(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field836 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class94.Players_regions[var1] = (var4.field853 << 28) + (IndexDataBase.baseX + var4.pathX[0] >> 13 << 14) + (Occluder.baseY + var4.pathY[0] >> 13);
            if(var4.field1174 != -1) {
               class94.Players_orientations[var1] = var4.field1174;
            } else {
               class94.Players_orientations[var1] = var4.orientation;
            }

            class94.Players_targetIndices[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.getBits(1) != 0) {
               class34.decodeRegionHash(var0, var1);
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
               var4.method1156(var6, var7);
               var4.field836 = false;
            } else if(var2) {
               var4.field836 = true;
               var4.field859 = var6;
               var4.field860 = var7;
            } else {
               var4.field836 = false;
               var4.method1165(var6, var7, class94.field1410[var1]);
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
                  var4.field836 = true;
                  var4.field859 = var6;
                  var4.field860 = var7;
               } else {
                  var4.field836 = false;
                  var4.method1165(var6, var7, class94.field1410[var1]);
               }
            } else {
               var4.method1156(var6, var7);
               var4.field836 = false;
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
               if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
                  var4.method1156(var10, var11);
                  var4.field836 = false;
               } else if(var2) {
                  var4.field836 = true;
                  var4.field859 = var10;
                  var4.field860 = var11;
               } else {
                  var4.field836 = false;
                  var4.method1165(var10, var11, class94.field1410[var1]);
               }

               var4.field853 = (byte)(var7 + var4.field853 & 3);
               if(Client.localInteractingIndex == var1) {
                  class233.plane = var4.field853;
               }

            } else {
               var6 = var0.getBits(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + IndexDataBase.baseX + var4.pathX[0] & 16383) - IndexDataBase.baseX;
               var11 = (var9 + Occluder.baseY + var4.pathY[0] & 16383) - Occluder.baseY;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field836 = true;
                     var4.field859 = var10;
                     var4.field860 = var11;
                  } else {
                     var4.field836 = false;
                     var4.method1165(var10, var11, class94.field1410[var1]);
                  }
               } else {
                  var4.method1156(var10, var11);
                  var4.field836 = false;
               }

               var4.field853 = (byte)(var7 + var4.field853 & 3);
               if(Client.localInteractingIndex == var1) {
                  class233.plane = var4.field853;
               }

            }
         }
      }
   }

   @ObfuscatedName("js")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "118273875"
   )
   static final void method4122(String var0) {
      if(!var0.equals("")) {
         PacketNode var1 = class218.method4105(ClientPacket.field2315, Client.field916.field1470);
         var1.packetBuffer.putByte(AbstractSoundSystem.getLength(var0));
         var1.packetBuffer.putString(var0);
         Client.field916.method1925(var1);
      }
   }
}
