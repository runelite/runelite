import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ab")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "Ljn;"
   )
   @Export("indexCache3")
   static IndexData indexCache3;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -396964939
   )
   int field380;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -766333625
   )
   int field381;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1733357229
   )
   int field382;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 384556503
   )
   int field383;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 749456523
   )
   int field392;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -595879897
   )
   int field385;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -338837591
   )
   int field386;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1538014859
   )
   int field387;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 325327927
   )
   int field384;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1030235183
   )
   int field389;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1125359227
   )
   int field390;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -371531355
   )
   int field391;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -806731421
   )
   int field394;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 75694623
   )
   int field393;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lah;I)V",
      garbageValue = "634115433"
   )
   public void vmethod767(WorldMapData var1) {
      if(var1.minX > this.field392) {
         var1.minX = this.field392;
      }

      if(var1.field455 < this.field392) {
         var1.field455 = this.field392;
      }

      if(var1.minY > this.field385) {
         var1.minY = this.field385;
      }

      if(var1.field457 < this.field385) {
         var1.field457 = this.field385;
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIIB)Z",
      garbageValue = "29"
   )
   public boolean containsCoord(int var1, int var2, int var3) {
      return var1 >= this.field380 && var1 < this.field380 + this.field381?var2 >= (this.field382 << 6) + (this.field386 << 3) && var2 <= (this.field382 << 6) + (this.field384 << 3) + 7 && var3 >= (this.field383 << 6) + (this.field387 << 3) && var3 <= (this.field383 << 6) + (this.field389 << 3) + 7:false;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "230864345"
   )
   public boolean vmethod768(int var1, int var2) {
      return var1 >= (this.field392 << 6) + (this.field390 << 3) && var1 <= (this.field392 << 6) + (this.field394 << 3) + 7 && var2 >= (this.field385 << 6) + (this.field391 << 3) && var2 <= (this.field385 << 6) + (this.field393 << 3) + 7;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIIB)[I",
      garbageValue = "40"
   )
   public int[] vmethod753(int var1, int var2, int var3) {
      if(!this.containsCoord(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field392 * 64 - this.field382 * 64 + var2 + (this.field390 * 8 - this.field386 * 8), var3 + (this.field385 * 64 - this.field383 * 64) + (this.field391 * 8 - this.field387 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIB)Lix;",
      garbageValue = "-31"
   )
   public Coordinates vmethod758(int var1, int var2) {
      if(!this.vmethod768(var1, var2)) {
         return null;
      } else {
         int var3 = this.field382 * 64 - this.field392 * 64 + (this.field386 * 8 - this.field390 * 8) + var1;
         int var4 = this.field383 * 64 - this.field385 * 64 + var2 + (this.field387 * 8 - this.field391 * 8);
         return new Coordinates(this.field380, var3, var4);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgc;I)V",
      garbageValue = "-2042290425"
   )
   public void vmethod754(Buffer var1) {
      this.field380 = var1.readUnsignedByte();
      this.field381 = var1.readUnsignedByte();
      this.field382 = var1.readUnsignedShort();
      this.field386 = var1.readUnsignedByte();
      this.field384 = var1.readUnsignedByte();
      this.field383 = var1.readUnsignedShort();
      this.field387 = var1.readUnsignedByte();
      this.field389 = var1.readUnsignedByte();
      this.field392 = var1.readUnsignedShort();
      this.field390 = var1.readUnsignedByte();
      this.field394 = var1.readUnsignedByte();
      this.field385 = var1.readUnsignedShort();
      this.field391 = var1.readUnsignedByte();
      this.field393 = var1.readUnsignedByte();
      this.method215();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1757195203"
   )
   void method215() {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljf;Ljf;I)V",
      garbageValue = "1148440952"
   )
   public static void method210(IndexDataBase var0, IndexDataBase var1) {
      Spotanim.SpotAnimationDefinition_indexCache = var0;
      Spotanim.SpotAnimationDefinition_modelIndexCache = var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILiu;I)Lcr;",
      garbageValue = "-2120261536"
   )
   static Script method233(int var0, class245 var1) {
      Script var2 = (Script)Script.field1459.get((long)(var0 << 16));
      if(var2 != null) {
         return var2;
      } else {
         String var3 = String.valueOf(var0);
         int var4 = class190.indexScripts.getFile(var3);
         if(var4 == -1) {
            return null;
         } else {
            byte[] var5 = class190.indexScripts.takeRecordFlat(var4);
            if(var5 != null) {
               if(var5.length <= 1) {
                  return null;
               }

               var2 = Signlink.newScript(var5);
               if(var2 != null) {
                  Script.field1459.put(var2, (long)(var0 << 16));
                  return var2;
               }
            }

            return null;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-6"
   )
   public static void method237() {
      VarPlayerType.varplayers.reset();
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "56"
   )
   public static int method235() {
      return KeyFocusListener.keyboardIdleTicks;
   }

   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "([BB)[B",
      garbageValue = "51"
   )
   @Export("decodeContainer")
   static final byte[] decodeContainer(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      int var2 = var1.readUnsignedByte();
      int var3 = var1.readInt();
      if(var3 < 0 || IndexDataBase.field3393 != 0 && var3 > IndexDataBase.field3393) {
         throw new RuntimeException();
      } else if(var2 == 0) {
         byte[] var4 = new byte[var3];
         var1.readBytes(var4, 0, var3);
         return var4;
      } else {
         int var6 = var1.readInt();
         if(var6 < 0 || IndexDataBase.field3393 != 0 && var6 > IndexDataBase.field3393) {
            throw new RuntimeException();
         } else {
            byte[] var5 = new byte[var6];
            if(var2 == 1) {
               class188.Bzip2Decompressor_decompress(var5, var6, var0, var3, 9);
            } else {
               IndexDataBase.gzip.decompress(var1, var5);
            }

            return var5;
         }
      }
   }

   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1279795348"
   )
   static final void method232(boolean var0) {
      if(var0) {
         Client.field907 = class90.field1385?class158.field2171:class158.field2173;
      } else {
         Client.field907 = Client.preferences.preferences.containsKey(Integer.valueOf(class228.method4120(class90.username)))?class158.field2177:class158.field2172;
      }

   }

   @ObfuscatedName("fp")
   @ObfuscatedSignature(
      signature = "(Lba;II)V",
      garbageValue = "-582301745"
   )
   static final void method234(Actor var0, int var1) {
      if(var0.field1166 > Client.gameCycle) {
         int var2 = var0.field1166 - Client.gameCycle;
         int var3 = var0.field1203 * 128 + var0.field1172 * 64;
         int var4 = var0.field1199 * 128 + var0.field1172 * 64;
         var0.x += (var3 - var0.x) / var2;
         var0.y += (var4 - var0.y) / var2;
         var0.field1158 = 0;
         var0.orientation = var0.field1171;
      } else if(var0.field1204 >= Client.gameCycle) {
         ObjectComposition.method5018(var0);
      } else {
         GrandExchangeOffer.method125(var0);
      }

      if(var0.x < 128 || var0.y < 128 || var0.x >= 13184 || var0.y >= 13184) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1166 = 0;
         var0.field1204 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1172 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1172 * 64;
         var0.method1655();
      }

      if(SoundTaskDataProvider.localPlayer == var0 && (var0.x < 1536 || var0.y < 1536 || var0.x >= 11776 || var0.y >= 11776)) {
         var0.animation = -1;
         var0.graphic = -1;
         var0.field1166 = 0;
         var0.field1204 = 0;
         var0.x = var0.pathX[0] * 128 + var0.field1172 * 64;
         var0.y = var0.pathY[0] * 128 + var0.field1172 * 64;
         var0.method1655();
      }

      class46.method685(var0);
      BoundingBox.method44(var0);
   }
}
