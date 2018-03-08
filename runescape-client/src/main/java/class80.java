import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cu")
public final class class80 extends Node {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lhf;"
   )
   static Deque field1240;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 1228636255
   )
   static int field1251;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1101768053
   )
   int field1237;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 701432623
   )
   int field1243;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1084120201
   )
   int field1239;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -437896827
   )
   int field1249;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 337616449
   )
   int field1245;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1844923477
   )
   int field1242;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1115368241
   )
   int field1241;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   class115 field1244;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1099481825
   )
   int field1246;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 756540641
   )
   int field1247;
   @ObfuscatedName("o")
   int[] field1236;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -199019415
   )
   int field1248;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Ldy;"
   )
   class115 field1238;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lje;"
   )
   ObjectComposition field1250;

   static {
      field1240 = new Deque();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1825252957"
   )
   void method1794() {
      int var1 = this.field1241;
      ObjectComposition var2 = this.field1250.getImpostor();
      if(var2 != null) {
         this.field1241 = var2.ambientSoundId;
         this.field1242 = var2.int4 * 128;
         this.field1246 = var2.int5;
         this.field1247 = var2.int6;
         this.field1236 = var2.field3642;
      } else {
         this.field1241 = -1;
         this.field1242 = 0;
         this.field1246 = 0;
         this.field1247 = 0;
         this.field1236 = null;
      }

      if(var1 != this.field1241 && this.field1244 != null) {
         FontName.field3884.method2087(this.field1244);
         this.field1244 = null;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;Ljava/lang/String;)Lft;"
   )
   public static RunException method1801(Throwable var0, String var1) {
      RunException var2;
      if(var0 instanceof RunException) {
         var2 = (RunException)var0;
         var2.field2153 = var2.field2153 + ' ' + var1;
      } else {
         var2 = new RunException(var0, var1);
      }

      return var2;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lgb;IIIIIII)V",
      garbageValue = "-1396444610"
   )
   @Export("loadTerrain")
   static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class62.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  int[] var8 = class62.tileHeights[0][var2];
                  int var11 = var2 + var4 + 932731;
                  int var12 = var3 + var5 + 556238;
                  int var13 = class46.getSmoothNoise(var11 + 45365, 91923 + var12, 4) - 128 + (class46.getSmoothNoise(10294 + var11, 37821 + var12, 2) - 128 >> 1) + (class46.getSmoothNoise(var11, var12, 1) - 128 >> 2);
                  var13 = (int)(0.3D * (double)var13) + 35;
                  if(var13 < 10) {
                     var13 = 10;
                  } else if(var13 > 60) {
                     var13 = 60;
                  }

                  var8[var3] = -var13 * 8;
               } else {
                  class62.tileHeights[var1][var2][var3] = class62.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var14 = var0.readUnsignedByte();
               if(var14 == 1) {
                  var14 = 0;
               }

               if(var1 == 0) {
                  class62.tileHeights[0][var2][var3] = -var14 * 8;
               } else {
                  class62.tileHeights[var1][var2][var3] = class62.tileHeights[var1 - 1][var2][var3] - var14 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class62.field707[var1][var2][var3] = var0.readByte();
               class62.field708[var1][var2][var3] = (byte)((var7 - 2) / 4);
               FrameMap.field1952[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class62.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class62.field711[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljc;II)Z",
      garbageValue = "1231543582"
   )
   static boolean method1799(IndexDataBase var0, int var1) {
      byte[] var2 = var0.takeRecordFlat(var1);
      if(var2 == null) {
         return false;
      } else {
         Widget.decodeSprite(var2);
         return true;
      }
   }

   @ObfuscatedName("gb")
   @ObfuscatedSignature(
      signature = "(Lbi;I)Z",
      garbageValue = "1654124536"
   )
   static boolean method1800(Player var0) {
      if(Client.field968 == 0) {
         return false;
      } else {
         boolean var1;
         if(WorldMapData.localPlayer != var0) {
            var1 = (Client.field968 & 4) != 0;
            boolean var2 = var1;
            if(!var1) {
               boolean var3 = (Client.field968 & 1) != 0;
               var2 = var3 && var0.isFriend();
            }

            return var2 || class279.method4933() && var0.isClanMember();
         } else {
            var1 = (Client.field968 & 8) != 0;
            return var1;
         }
      }
   }
}
