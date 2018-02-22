import java.util.Iterator;
import java.util.LinkedList;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
@Implements("WorldMapData")
public class WorldMapData {
   @ObfuscatedName("ok")
   @ObfuscatedSignature(
      signature = "Ldw;"
   )
   @Export("soundSystem0")
   static AbstractSoundSystem soundSystem0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1824472251
   )
   @Export("fileId")
   int fileId;
   @ObfuscatedName("q")
   String field418;
   @ObfuscatedName("o")
   String field421;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1428599509
   )
   int field416;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1819022433
   )
   int field414;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   Coordinates field427;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -651401541
   )
   int field419;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1325506107
   )
   int field420;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1872941289
   )
   int field413;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1723806497
   )
   int field422;
   @ObfuscatedName("u")
   boolean field423;
   @ObfuscatedName("r")
   LinkedList field424;

   public WorldMapData() {
      this.fileId = -1;
      this.field416 = -1;
      this.field414 = -1;
      this.field427 = null;
      this.field419 = Integer.MAX_VALUE;
      this.field420 = 0;
      this.field413 = Integer.MAX_VALUE;
      this.field422 = 0;
      this.field423 = false;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lgn;II)V",
      garbageValue = "-1443170391"
   )
   @Export("loadMapData")
   public void loadMapData(Buffer var1, int var2) {
      this.fileId = var2;
      this.field418 = var1.readString();
      this.field421 = var1.readString();
      this.field427 = new Coordinates(var1.readInt());
      this.field416 = var1.readInt();
      var1.readUnsignedByte();
      this.field423 = var1.readUnsignedByte() == 1;
      this.field414 = var1.readUnsignedByte();
      int var3 = var1.readUnsignedByte();
      this.field424 = new LinkedList();

      for(int var4 = 0; var4 < var3; ++var4) {
         this.field424.add(this.method306(var1));
      }

      this.method311();
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgn;B)Lau;",
      garbageValue = "-112"
   )
   WorldMapSectionBase method306(Buffer var1) {
      int var2 = var1.readUnsignedByte();
      class27 var3 = (class27)Tile.forOrdinal(class27.method234(), var2);
      Object var4 = null;
      switch(var3.field368) {
      case 0:
         var4 = new WorldMapType2();
         break;
      case 1:
         var4 = new WorldMapType1();
         break;
      case 2:
         var4 = new class48();
         break;
      case 3:
         var4 = new WorldMapType3();
         break;
      default:
         throw new IllegalStateException("");
      }

      ((WorldMapSectionBase)var4).vmethod741(var1);
      return (WorldMapSectionBase)var4;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIIS)Z",
      garbageValue = "14884"
   )
   public boolean method332(int var1, int var2, int var3) {
      Iterator var4 = this.field424.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return false;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod737(var1, var2, var3));

      return true;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "-73"
   )
   public boolean method328(int var1, int var2) {
      int var3 = var1 / 64;
      int var4 = var2 / 64;
      if(var3 >= this.field419 && var3 <= this.field420) {
         if(var4 >= this.field413 && var4 <= this.field422) {
            Iterator var5 = this.field424.iterator();

            WorldMapSectionBase var6;
            do {
               if(!var5.hasNext()) {
                  return false;
               }

               var6 = (WorldMapSectionBase)var5.next();
            } while(!var6.vmethod745(var1, var2));

            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-633635512"
   )
   public int[] method329(int var1, int var2, int var3) {
      Iterator var4 = this.field424.iterator();

      WorldMapSectionBase var5;
      do {
         if(!var4.hasNext()) {
            return null;
         }

         var5 = (WorldMapSectionBase)var4.next();
      } while(!var5.vmethod737(var1, var2, var3));

      return var5.vmethod738(var1, var2, var3);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)Lhp;",
      garbageValue = "-1131399438"
   )
   public Coordinates method310(int var1, int var2) {
      Iterator var3 = this.field424.iterator();

      WorldMapSectionBase var4;
      do {
         if(!var3.hasNext()) {
            return null;
         }

         var4 = (WorldMapSectionBase)var3.next();
      } while(!var4.vmethod745(var1, var2));

      return var4.vmethod739(var1, var2);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "14"
   )
   void method311() {
      Iterator var1 = this.field424.iterator();

      while(var1.hasNext()) {
         WorldMapSectionBase var2 = (WorldMapSectionBase)var1.next();
         var2.vmethod736(this);
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2070480299"
   )
   public int method312() {
      return this.fileId;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "173872095"
   )
   public boolean method335() {
      return this.field423;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "41"
   )
   public String method314() {
      return this.field418;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "468518428"
   )
   public String method315() {
      return this.field421;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-123"
   )
   int method309() {
      return this.field416;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1350309177"
   )
   public int method317() {
      return this.field414;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-634615496"
   )
   public int method318() {
      return this.field419;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-173895892"
   )
   public int method319() {
      return this.field420;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "8"
   )
   public int method355() {
      return this.field413;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-391969985"
   )
   public int method321() {
      return this.field422;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "108"
   )
   public int method322() {
      return this.field427.worldX;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "5"
   )
   public int method323() {
      return this.field427.plane;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1586882723"
   )
   public int method368() {
      return this.field427.worldY;
   }

   @ObfuscatedName("ao")
   @ObfuscatedSignature(
      signature = "(I)Lhp;",
      garbageValue = "1585056609"
   )
   public Coordinates method320() {
      return new Coordinates(this.field427);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgu;IB)V",
      garbageValue = "2"
   )
   @Export("decodeMovement")
   static void decodeMovement(PacketBuffer var0, int var1) {
      boolean var2 = var0.getBits(1) == 1;
      if(var2) {
         class92.field1370[++class92.field1382 - 1] = var1;
      }

      int var3 = var0.getBits(2);
      Player var4 = Client.cachedPlayers[var1];
      if(var3 == 0) {
         if(var2) {
            var4.field806 = false;
         } else if(Client.localInteractingIndex == var1) {
            throw new RuntimeException();
         } else {
            class92.Players_regions[var1] = (var4.field802 << 28) + (ScriptState.baseX + var4.pathX[0] >> 13 << 14) + (WorldMapType1.baseY + var4.pathY[0] >> 13);
            if(var4.field1122 != -1) {
               class92.Players_orientations[var1] = var4.field1122;
            } else {
               class92.Players_orientations[var1] = var4.orientation;
            }

            class92.Players_targetIndices[var1] = var4.interacting;
            Client.cachedPlayers[var1] = null;
            if(var0.getBits(1) != 0) {
               BoundingBox.decodeRegionHash(var0, var1);
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
               var4.method1191(var6, var7);
               var4.field806 = false;
            } else if(var2) {
               var4.field806 = true;
               var4.field807 = var6;
               var4.field791 = var7;
            } else {
               var4.field806 = false;
               var4.method1190(var6, var7, class92.field1378[var1]);
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

            if(Client.localInteractingIndex == var1 && (var4.x < 1536 || var4.y < 1536 || var4.x >= 11776 || var4.y >= 11776)) {
               var4.method1191(var6, var7);
               var4.field806 = false;
            } else if(var2) {
               var4.field806 = true;
               var4.field807 = var6;
               var4.field791 = var7;
            } else {
               var4.field806 = false;
               var4.method1190(var6, var7, class92.field1378[var1]);
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
                     var4.field806 = true;
                     var4.field807 = var10;
                     var4.field791 = var11;
                  } else {
                     var4.field806 = false;
                     var4.method1190(var10, var11, class92.field1378[var1]);
                  }
               } else {
                  var4.method1191(var10, var11);
                  var4.field806 = false;
               }

               var4.field802 = (byte)(var7 + var4.field802 & 3);
               if(Client.localInteractingIndex == var1) {
                  class230.plane = var4.field802;
               }

            } else {
               var6 = var0.getBits(30);
               var7 = var6 >> 28;
               var8 = var6 >> 14 & 16383;
               var9 = var6 & 16383;
               var10 = (var8 + ScriptState.baseX + var4.pathX[0] & 16383) - ScriptState.baseX;
               var11 = (var9 + WorldMapType1.baseY + var4.pathY[0] & 16383) - WorldMapType1.baseY;
               if(Client.localInteractingIndex != var1 || var4.x >= 1536 && var4.y >= 1536 && var4.x < 11776 && var4.y < 11776) {
                  if(var2) {
                     var4.field806 = true;
                     var4.field807 = var10;
                     var4.field791 = var11;
                  } else {
                     var4.field806 = false;
                     var4.method1190(var10, var11, class92.field1378[var1]);
                  }
               } else {
                  var4.method1191(var10, var11);
                  var4.field806 = false;
               }

               var4.field802 = (byte)(var7 + var4.field802 & 3);
               if(Client.localInteractingIndex == var1) {
                  class230.plane = var4.field802;
               }

            }
         }
      }
   }
}
