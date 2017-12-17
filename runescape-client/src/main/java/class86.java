import java.math.BigInteger;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ce")
public class class86 {
   @ObfuscatedName("u")
   static final BigInteger field1275;
   @ObfuscatedName("z")
   static final BigInteger field1274;
   @ObfuscatedName("cn")
   @ObfuscatedSignature(
      signature = "Liu;"
   )
   @Export("indexCache4")
   static IndexData indexCache4;
   @ObfuscatedName("ke")
   @ObfuscatedGetter(
      intValue = 1116718349
   )
   static int field1278;

   static {
      field1275 = new BigInteger("80782894952180643741752986186714059433953886149239752893425047584684715842049");
      field1274 = new BigInteger("7237300117305667488707183861728052766358166655052137727439795191253340127955075499635575104901523446809299097934591732635674173519120047404024393881551683");
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lib;Lib;IZI)Lec;",
      garbageValue = "1946738731"
   )
   public static Frames method1658(IndexDataBase var0, IndexDataBase var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.getChilds(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.getChild(var2, var5[var6]);
         if(var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9;
            if(var3) {
               var9 = var1.getChild(0, var8);
            } else {
               var9 = var1.getChild(var8, 0);
            }

            if(var9 == null) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lib;I)V",
      garbageValue = "1856851508"
   )
   public static void method1650(IndexDataBase var0) {
      Enum.EnumDefinition_indexCache = var0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgy;II)Z",
      garbageValue = "2136589804"
   )
   @Export("decodeRegionHash")
   static boolean decodeRegionHash(PacketBuffer var0, int var1) {
      int var2 = var0.getBits(2);
      int var3;
      int var4;
      int var7;
      int var8;
      int var9;
      int var10;
      if(var2 == 0) {
         if(var0.getBits(1) != 0) {
            decodeRegionHash(var0, var1);
         }

         var3 = var0.getBits(13);
         var4 = var0.getBits(13);
         boolean var12 = var0.getBits(1) == 1;
         if(var12) {
            class94.field1391[++class94.field1400 - 1] = var1;
         }

         if(Client.cachedPlayers[var1] != null) {
            throw new RuntimeException();
         } else {
            Player var6 = Client.cachedPlayers[var1] = new Player();
            var6.field810 = var1;
            if(class94.field1392[var1] != null) {
               var6.decodeApperance(class94.field1392[var1]);
            }

            var6.orientation = class94.Players_orientations[var1];
            var6.interacting = class94.Players_targetIndices[var1];
            var7 = class94.Players_regions[var1];
            var8 = var7 >> 28;
            var9 = var7 >> 14 & 255;
            var10 = var7 & 255;
            var6.pathTraversed[0] = class94.field1388[var1];
            var6.field821 = (byte)var8;
            var6.method1082((var9 << 13) + var3 - class46.baseX, (var10 << 13) + var4 - Client.baseY);
            var6.field814 = false;
            return true;
         }
      } else if(var2 == 1) {
         var3 = var0.getBits(2);
         var4 = class94.Players_regions[var1];
         class94.Players_regions[var1] = (((var4 >> 28) + var3 & 3) << 28) + (var4 & 268435455);
         return false;
      } else {
         int var5;
         int var11;
         if(var2 == 2) {
            var3 = var0.getBits(5);
            var4 = var3 >> 3;
            var5 = var3 & 7;
            var11 = class94.Players_regions[var1];
            var7 = (var11 >> 28) + var4 & 3;
            var8 = var11 >> 14 & 255;
            var9 = var11 & 255;
            if(var5 == 0) {
               --var8;
               --var9;
            }

            if(var5 == 1) {
               --var9;
            }

            if(var5 == 2) {
               ++var8;
               --var9;
            }

            if(var5 == 3) {
               --var8;
            }

            if(var5 == 4) {
               ++var8;
            }

            if(var5 == 5) {
               --var8;
               ++var9;
            }

            if(var5 == 6) {
               ++var9;
            }

            if(var5 == 7) {
               ++var8;
               ++var9;
            }

            class94.Players_regions[var1] = (var8 << 14) + var9 + (var7 << 28);
            return false;
         } else {
            var3 = var0.getBits(18);
            var4 = var3 >> 16;
            var5 = var3 >> 8 & 255;
            var11 = var3 & 255;
            var7 = class94.Players_regions[var1];
            var8 = (var7 >> 28) + var4 & 3;
            var9 = var5 + (var7 >> 14) & 255;
            var10 = var7 + var11 & 255;
            class94.Players_regions[var1] = (var9 << 14) + var10 + (var8 << 28);
            return false;
         }
      }
   }

   @ObfuscatedName("eb")
   @ObfuscatedSignature(
      signature = "(I)Lka;",
      garbageValue = "-1950344156"
   )
   static RenderOverview method1655() {
      return class61.renderOverview;
   }
}
