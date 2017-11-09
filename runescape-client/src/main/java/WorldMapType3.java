import java.io.File;
import java.io.RandomAccessFile;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("al")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("go")
   @ObfuscatedGetter(
      intValue = 1725565179
   )
   static int field375;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1727549345
   )
   int field367;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 890847337
   )
   int field362;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1204639729
   )
   int field373;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 303975859
   )
   int field364;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1376782195
   )
   int field361;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -178973607
   )
   int field366;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1453315499
   )
   int field365;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 428315115
   )
   int field368;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1370876281
   )
   int field369;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -819057935
   )
   int field370;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1794583889
   )
   int field363;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -811871183
   )
   int field372;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1550448247
   )
   int field371;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1986509691
   )
   int field374;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lap;I)V",
      garbageValue = "-695326084"
   )
   public void vmethod772(WorldMapData var1) {
      if(var1.field430 > this.field361) {
         var1.field430 = this.field361;
      }

      if(var1.field432 < this.field361) {
         var1.field432 = this.field361;
      }

      if(var1.field438 > this.field366) {
         var1.field438 = this.field366;
      }

      if(var1.field439 < this.field366) {
         var1.field439 = this.field366;
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "2104062915"
   )
   public boolean vmethod778(int var1, int var2, int var3) {
      return var1 >= this.field367 && var1 < this.field362 + this.field367?var2 >= (this.field373 << 6) + (this.field365 << 3) && var2 <= (this.field373 << 6) + (this.field369 << 3) + 7 && var3 >= (this.field364 << 6) + (this.field368 << 3) && var3 <= (this.field364 << 6) + (this.field370 << 3) + 7:false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIB)Z",
      garbageValue = "0"
   )
   public boolean vmethod774(int var1, int var2) {
      return var1 >= (this.field361 << 6) + (this.field363 << 3) && var1 <= (this.field361 << 6) + (this.field371 << 3) + 7 && var2 >= (this.field366 << 6) + (this.field372 << 3) && var2 <= (this.field366 << 6) + (this.field374 << 3) + 7;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-579666919"
   )
   public int[] vmethod775(int var1, int var2, int var3) {
      if(!this.vmethod778(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field361 * 64 - this.field373 * 64 + var2 + (this.field363 * 8 - this.field365 * 8), var3 + (this.field366 * 64 - this.field364 * 64) + (this.field372 * 8 - this.field368 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(IIB)Lhq;",
      garbageValue = "1"
   )
   public Coordinates vmethod797(int var1, int var2) {
      if(!this.vmethod774(var1, var2)) {
         return null;
      } else {
         int var3 = this.field373 * 64 - this.field361 * 64 + (this.field365 * 8 - this.field363 * 8) + var1;
         int var4 = this.field364 * 64 - this.field366 * 64 + var2 + (this.field368 * 8 - this.field372 * 8);
         return new Coordinates(this.field367, var3, var4);
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lfv;S)V",
      garbageValue = "256"
   )
   public void vmethod777(Buffer var1) {
      this.field367 = var1.readUnsignedByte();
      this.field362 = var1.readUnsignedByte();
      this.field373 = var1.readUnsignedShort();
      this.field365 = var1.readUnsignedByte();
      this.field369 = var1.readUnsignedByte();
      this.field364 = var1.readUnsignedShort();
      this.field368 = var1.readUnsignedByte();
      this.field370 = var1.readUnsignedByte();
      this.field361 = var1.readUnsignedShort();
      this.field363 = var1.readUnsignedByte();
      this.field371 = var1.readUnsignedByte();
      this.field366 = var1.readUnsignedShort();
      this.field372 = var1.readUnsignedByte();
      this.field374 = var1.readUnsignedByte();
      this.method221();
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1869619529"
   )
   void method221() {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "-2045567461"
   )
   public static boolean method231(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1979387765"
   )
   static int method232(int var0) {
      MessageNode var1 = (MessageNode)class96.field1433.get((long)var0);
      return var1 == null?-1:(var1.next == class96.field1427.field2581?-1:((MessageNode)var1.next).id);
   }

   @ObfuscatedName("ga")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "106"
   )
   static void method220() {
      int var0 = class94.playerIndexesCount;
      int[] var1 = class94.playerIndices;

      for(int var2 = 0; var2 < var0; ++var2) {
         if(var1[var2] != Client.field978 && var1[var2] != Client.localInteractingIndex) {
            class171.method3210(Client.cachedPlayers[var1[var2]], true);
         }
      }

   }
}
