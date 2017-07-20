import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ap")
@Implements("WorldMapType3")
public class WorldMapType3 implements WorldMapSectionBase {
   @ObfuscatedName("du")
   @ObfuscatedSignature(
      signature = "Lix;"
   )
   @Export("indexTextures")
   static IndexData indexTextures;
   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   static Task field373;
   @ObfuscatedName("gv")
   @ObfuscatedSignature(
      signature = "[Ljj;"
   )
   @Export("mapDots")
   static SpritePixels[] mapDots;
   @ObfuscatedName("nq")
   static byte field372;
   @ObfuscatedName("qy")
   static short[] field361;
   @ObfuscatedName("qs")
   @ObfuscatedGetter(
      intValue = -1742939581
   )
   static int field380;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 86753951
   )
   int field377;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 675035743
   )
   int field363;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1818134659
   )
   int field369;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1087190325
   )
   int field360;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -811544385
   )
   int field371;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1856032255
   )
   int field378;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1311432171
   )
   int field359;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1857633315
   )
   int field364;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -463744973
   )
   int field370;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 197243963
   )
   int field367;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 939750575
   )
   int field374;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1540997849
   )
   int field366;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1107825569
   )
   int field362;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 191115807
   )
   int field368;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIS)Z",
      garbageValue = "-1713"
   )
   public boolean vmethod676(int var1, int var2) {
      return var1 >= (this.field363 << 6) + (this.field369 << 3) && var1 <= (this.field363 << 6) + (this.field371 << 3) + 7 && var2 >= (this.field364 << 6) + (this.field370 << 3) && var2 <= (this.field364 << 6) + (this.field374 << 3) + 7;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-762941504"
   )
   public boolean vmethod675(int var1, int var2, int var3) {
      return var1 >= this.field377 && var1 < this.field377 + this.field360?var2 >= (this.field378 << 6) + (this.field359 << 3) && var2 <= (this.field378 << 6) + (this.field367 << 3) + 7 && var3 >= (this.field362 << 6) + (this.field366 << 3) && var3 <= (this.field362 << 6) + (this.field368 << 3) + 7:false;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lab;S)V",
      garbageValue = "-29128"
   )
   public void vmethod693(WorldMapData var1) {
      if(var1.field443 > this.field363) {
         var1.field443 = this.field363;
      }

      if(var1.field444 < this.field363) {
         var1.field444 = this.field363;
      }

      if(var1.field442 > this.field364) {
         var1.field442 = this.field364;
      }

      if(var1.field435 < this.field364) {
         var1.field435 = this.field364;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Lhs;",
      garbageValue = "861336956"
   )
   public Coordinates vmethod696(int var1, int var2) {
      if(!this.vmethod676(var1, var2)) {
         return null;
      } else {
         int var3 = this.field359 * 8 - this.field369 * 8 + this.field378 * 64 - this.field363 * 64 + var1;
         int var4 = this.field366 * 8 - this.field370 * 8 + this.field362 * 64 - this.field364 * 64 + var2;
         return new Coordinates(this.field377, var3, var4);
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-1119600547"
   )
   public int[] vmethod677(int var1, int var2, int var3) {
      if(!this.vmethod675(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field369 * 8 - this.field359 * 8 + this.field363 * 64 - this.field378 * 64 + var2, this.field370 * 8 - this.field366 * 8 + this.field364 * 64 - this.field362 * 64 + var3};
         return var4;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lfp;B)V",
      garbageValue = "-58"
   )
   public void vmethod678(Buffer var1) {
      this.field377 = var1.readUnsignedByte();
      this.field360 = var1.readUnsignedByte();
      this.field378 = var1.readUnsignedShort();
      this.field359 = var1.readUnsignedByte();
      this.field367 = var1.readUnsignedByte();
      this.field362 = var1.readUnsignedShort();
      this.field366 = var1.readUnsignedByte();
      this.field368 = var1.readUnsignedByte();
      this.field363 = var1.readUnsignedShort();
      this.field369 = var1.readUnsignedByte();
      this.field371 = var1.readUnsignedByte();
      this.field364 = var1.readUnsignedShort();
      this.field370 = var1.readUnsignedByte();
      this.field374 = var1.readUnsignedByte();
      this.method186();
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2127239076"
   )
   void method186() {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(BI)C",
      garbageValue = "-1085663019"
   )
   public static char method206(byte var0) {
      int var1 = var0 & 255;
      if(var1 == 0) {
         throw new IllegalArgumentException("");
      } else {
         if(var1 >= 128 && var1 < 160) {
            char var2 = class266.field3645[var1 - 128];
            if(var2 == 0) {
               var2 = 63;
            }

            var1 = var2;
         }

         return (char)var1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Lib;",
      garbageValue = "1453541701"
   )
   @Export("getNpcDefinition")
   public static NPCComposition getNpcDefinition(int var0) {
      NPCComposition var1 = (NPCComposition)NPCComposition.npcs.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = NPCComposition.field3544.getConfigData(9, var0);
         var1 = new NPCComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         NPCComposition.npcs.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "160984839"
   )
   public static void method179() {
      NPCComposition.npcs.reset();
      NPCComposition.npcModelCache.reset();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1332472505"
   )
   static final int method200() {
      return class134.field1948;
   }

   @ObfuscatedName("ew")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "910957482"
   )
   static void method207(int var0) {
      if(var0 == -1 && !Client.field1141) {
         Client.method1459();
      } else if(var0 != -1 && var0 != Client.field1140 && Client.field1139 != 0 && !Client.field1141) {
         class134.method2519(2, class8.indexTrack1, var0, 0, Client.field1139, false);
      }

      Client.field1140 = var0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ILcv;ZS)I",
      garbageValue = "15367"
   )
   static int method209(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class239.method4167(class83.intStack[--BufferProvider.intStackSize]);
      } else {
         var3 = var2?class48.field614:FaceNormal.field2099;
      }

      String var4 = class83.scriptStringStack[--class83.scriptStringStackSize];
      int[] var5 = null;
      if(var4.length() > 0 && var4.charAt(var4.length() - 1) == 89) {
         int var6 = class83.intStack[--BufferProvider.intStackSize];
         if(var6 > 0) {
            for(var5 = new int[var6]; var6-- > 0; var5[var6] = class83.intStack[--BufferProvider.intStackSize]) {
               ;
            }
         }

         var4 = var4.substring(0, var4.length() - 1);
      }

      Object[] var8 = new Object[var4.length() + 1];

      int var7;
      for(var7 = var8.length - 1; var7 >= 1; --var7) {
         if(var4.charAt(var7 - 1) == 115) {
            var8[var7] = class83.scriptStringStack[--class83.scriptStringStackSize];
         } else {
            var8[var7] = new Integer(class83.intStack[--BufferProvider.intStackSize]);
         }
      }

      var7 = class83.intStack[--BufferProvider.intStackSize];
      if(var7 != -1) {
         var8[0] = new Integer(var7);
      } else {
         var8 = null;
      }

      if(var0 == 1400) {
         var3.field2699 = var8;
      } else if(var0 == 1401) {
         var3.field2702 = var8;
      } else if(var0 == 1402) {
         var3.field2684 = var8;
      } else if(var0 == 1403) {
         var3.mouseEnterListener = var8;
      } else if(var0 == 1404) {
         var3.mouseExitListener = var8;
      } else if(var0 == 1405) {
         var3.field2706 = var8;
      } else if(var0 == 1406) {
         var3.field2695 = var8;
      } else if(var0 == 1407) {
         var3.configListenerArgs = var8;
         var3.configTriggers = var5;
      } else if(var0 == 1408) {
         var3.renderListener = var8;
      } else if(var0 == 1409) {
         var3.field2717 = var8;
      } else if(var0 == 1410) {
         var3.field2651 = var8;
      } else if(var0 == 1411) {
         var3.field2700 = var8;
      } else if(var0 == 1412) {
         var3.mouseHoverListener = var8;
      } else if(var0 == 1414) {
         var3.tableListenerArgs = var8;
         var3.tableModTriggers = var5;
      } else if(var0 == 1415) {
         var3.skillListenerArgs = var8;
         var3.skillTriggers = var5;
      } else if(var0 == 1416) {
         var3.field2747 = var8;
      } else if(var0 == 1417) {
         var3.scrollListener = var8;
      } else if(var0 == 1418) {
         var3.field2719 = var8;
      } else if(var0 == 1419) {
         var3.field2639 = var8;
      } else if(var0 == 1420) {
         var3.field2721 = var8;
      } else if(var0 == 1421) {
         var3.field2722 = var8;
      } else if(var0 == 1422) {
         var3.field2723 = var8;
      } else if(var0 == 1423) {
         var3.field2690 = var8;
      } else if(var0 == 1424) {
         var3.field2694 = var8;
      } else if(var0 == 1425) {
         var3.field2727 = var8;
      } else if(var0 == 1426) {
         var3.field2613 = var8;
      } else {
         if(var0 != 1427) {
            return 2;
         }

         var3.field2672 = var8;
      }

      var3.field2697 = true;
      return 1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(CI)Z",
      garbageValue = "1117376869"
   )
   static final boolean method204(char var0) {
      if(Character.isISOControl(var0)) {
         return false;
      } else if(CombatInfoListHolder.method1630(var0)) {
         return true;
      } else {
         char[] var1 = class267.field3652;

         int var2;
         char var3;
         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if(var0 == var3) {
               return true;
            }
         }

         var1 = class267.field3648;

         for(var2 = 0; var2 < var1.length; ++var2) {
            var3 = var1[var2];
            if(var0 == var3) {
               return true;
            }
         }

         return false;
      }
   }
}
