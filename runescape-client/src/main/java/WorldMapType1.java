import java.util.Iterator;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
@Implements("WorldMapType1")
public class WorldMapType1 implements WorldMapSectionBase {
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -395794781
   )
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("eu")
   @ObfuscatedGetter(
      intValue = 293081299
   )
   @Export("baseX")
   static int baseX;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 620665245
   )
   int field398;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 41996075
   )
   int field401;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -781698747
   )
   int field397;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1785832665
   )
   int field399;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -493591411
   )
   int field400;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1385649707
   )
   int field403;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1241169547
   )
   int field408;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 730322271
   )
   int field402;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -571174855
   )
   int field404;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1358172753
   )
   int field405;

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lae;I)V",
      garbageValue = "-1518418003"
   )
   public void vmethod701(WorldMapData var1) {
      if(var1.field426 > this.field408) {
         var1.field426 = this.field408;
      }

      if(var1.field433 < this.field404) {
         var1.field433 = this.field404;
      }

      if(var1.field428 > this.field402) {
         var1.field428 = this.field402;
      }

      if(var1.field422 < this.field405) {
         var1.field422 = this.field405;
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "-2038931748"
   )
   public boolean vmethod702(int var1, int var2, int var3) {
      return var1 >= this.field398 && var1 < this.field401 + this.field398?var2 >> 6 >= this.field397 && var2 >> 6 <= this.field400 && var3 >> 6 >= this.field399 && var3 >> 6 <= this.field403:false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "1297520065"
   )
   public boolean vmethod703(int var1, int var2) {
      return var1 >> 6 >= this.field408 && var1 >> 6 <= this.field404 && var2 >> 6 >= this.field402 && var2 >> 6 <= this.field405;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "-336358408"
   )
   public int[] vmethod711(int var1, int var2, int var3) {
      if(!this.vmethod702(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field408 * 64 - this.field397 * 64 + var2, var3 + (this.field402 * 64 - this.field399 * 64)};
         return var4;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(III)Lhn;",
      garbageValue = "1673050917"
   )
   public Coordinates vmethod700(int var1, int var2) {
      if(!this.vmethod703(var1, var2)) {
         return null;
      } else {
         int var3 = this.field397 * 64 - this.field408 * 64 + var1;
         int var4 = this.field399 * 64 - this.field402 * 64 + var2;
         return new Coordinates(this.field398, var3, var4);
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgj;B)V",
      garbageValue = "7"
   )
   public void vmethod706(Buffer var1) {
      this.field398 = var1.readUnsignedByte();
      this.field401 = var1.readUnsignedByte();
      this.field397 = var1.readUnsignedShort();
      this.field399 = var1.readUnsignedShort();
      this.field400 = var1.readUnsignedShort();
      this.field403 = var1.readUnsignedShort();
      this.field408 = var1.readUnsignedShort();
      this.field402 = var1.readUnsignedShort();
      this.field404 = var1.readUnsignedShort();
      this.field405 = var1.readUnsignedShort();
      this.method267();
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-13180713"
   )
   void method267() {
   }

   @ObfuscatedName("hf")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-49"
   )
   static final void method285(int var0) {
      int[] var1 = class29.minimapSprite.pixels;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = (103 - var3) * 2048 + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if((class61.tileSettings[var0][var5][var3] & 24) == 0) {
               class48.region.method2870(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class61.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
               class48.region.method2870(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      class29.minimapSprite.method5527();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class61.tileSettings[var0][var6][var5] & 24) == 0) {
               class41.method550(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class61.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               class41.method550(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field1033 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class48.region.method2840(MessageNode.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = TextureProvider.getObjectDefinition(var7).mapIconId;
               if(var8 >= 0) {
                  Client.mapIcons[Client.field1033] = Area.mapAreaType[var8].getMapIcon(false);
                  Client.field1034[Client.field1033] = var5;
                  Client.field1035[Client.field1033] = var6;
                  ++Client.field1033;
               }
            }
         }
      }

      CombatInfo2.rasterProvider.setRaster();
   }

   @ObfuscatedName("jb")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-76"
   )
   static final void method283(int var0) {
      WorldMapType3.method219();

      for(class79 var1 = (class79)class79.field1208.getFront(); var1 != null; var1 = (class79)class79.field1208.getNext()) {
         if(var1.field1215 != null) {
            var1.method1741();
         }
      }

      VarPlayerType var2 = (VarPlayerType)VarPlayerType.varplayers.get((long)var0);
      VarPlayerType var7;
      if(var2 != null) {
         var7 = var2;
      } else {
         byte[] var3 = class175.varplayer_ref.getConfigData(16, var0);
         var2 = new VarPlayerType();
         if(var3 != null) {
            var2.decode(new Buffer(var3));
         }

         VarPlayerType.varplayers.put(var2, (long)var0);
         var7 = var2;
      }

      int var5 = var7.configType;
      if(var5 != 0) {
         int var6 = class222.widgetSettings[var0];
         if(var5 == 1) {
            if(var6 == 1) {
               Graphics3D.setBrightness(0.9D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.9D);
            }

            if(var6 == 2) {
               Graphics3D.setBrightness(0.8D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.8D);
            }

            if(var6 == 3) {
               Graphics3D.setBrightness(0.7D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.7D);
            }

            if(var6 == 4) {
               Graphics3D.setBrightness(0.6D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.6D);
            }

            ItemComposition.itemSpriteCache.reset();
         }

         if(var5 == 3) {
            short var4 = 0;
            if(var6 == 0) {
               var4 = 255;
            }

            if(var6 == 1) {
               var4 = 192;
            }

            if(var6 == 2) {
               var4 = 128;
            }

            if(var6 == 3) {
               var4 = 64;
            }

            if(var6 == 4) {
               var4 = 0;
            }

            if(var4 != Client.field1040) {
               if(Client.field1040 == 0 && Client.field1041 != -1) {
                  class163.method3202(class148.indexTrack1, Client.field1041, 0, var4, false);
                  Client.field1014 = false;
               } else if(var4 == 0) {
                  class214.field2595.method3962();
                  class214.field2596 = 1;
                  Item.field1369 = null;
                  Client.field1014 = false;
               } else if(class214.field2596 != 0) {
                  class214.field2597 = var4;
               } else {
                  class214.field2595.method3956(var4);
               }

               Client.field1040 = var4;
            }
         }

         if(var5 == 4) {
            if(var6 == 0) {
               Client.field1008 = 127;
            }

            if(var6 == 1) {
               Client.field1008 = 96;
            }

            if(var6 == 2) {
               Client.field1008 = 64;
            }

            if(var6 == 3) {
               Client.field1008 = 32;
            }

            if(var6 == 4) {
               Client.field1008 = 0;
            }
         }

         if(var5 == 5) {
            Client.field1049 = var6;
         }

         if(var5 == 6) {
            Client.field1042 = var6;
         }

         if(var5 == 9) {
            Client.field970 = var6;
         }

         if(var5 == 10) {
            if(var6 == 0) {
               Client.field879 = 127;
            }

            if(var6 == 1) {
               Client.field879 = 96;
            }

            if(var6 == 2) {
               Client.field879 = 64;
            }

            if(var6 == 3) {
               Client.field879 = 32;
            }

            if(var6 == 4) {
               Client.field879 = 0;
            }
         }

         if(var5 == 17) {
            Client.field890 = var6 & 65535;
         }

         if(var5 == 18) {
            Client.playerAttackOption = (AttackOption)ClanMember.forOrdinal(FontName.method5194(), var6);
            if(Client.playerAttackOption == null) {
               Client.playerAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

         if(var5 == 19) {
            if(var6 == -1) {
               Client.field935 = -1;
            } else {
               Client.field935 = var6 & 2047;
            }
         }

         if(var5 == 22) {
            Client.npcAttackOption = (AttackOption)ClanMember.forOrdinal(FontName.method5194(), var6);
            if(Client.npcAttackOption == null) {
               Client.npcAttackOption = AttackOption.AttackOption_dependsOnCombatLevels;
            }
         }

      }
   }

   @ObfuscatedName("kd")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2146407319"
   )
   static final void method284() {
      for(int var0 = 0; var0 < class92.playerIndexesCount; ++var0) {
         Player var1 = Client.cachedPlayers[class92.playerIndices[var0]];
         var1.method1130();
      }

      Iterator var2 = class94.messages.iterator();

      while(var2.hasNext()) {
         MessageNode var3 = (MessageNode)var2.next();
         var3.method1113();
      }

      if(class234.clanMemberManager != null) {
         class234.clanMemberManager.method5166();
      }

   }
}
