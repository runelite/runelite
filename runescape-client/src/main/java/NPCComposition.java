import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jp")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("NpcDefinition_indexCache")
   static IndexDataBase NpcDefinition_indexCache;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   @Export("npcs")
   static NodeCache npcs;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgm;"
   )
   @Export("npcModelCache")
   static NodeCache npcModelCache;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1885146505
   )
   @Export("id")
   public int id;
   @ObfuscatedName("a")
   @Export("name")
   public String name;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 2085715585
   )
   public int field3611;
   @ObfuscatedName("r")
   @Export("models")
   int[] models;
   @ObfuscatedName("m")
   int[] field3613;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1297250299
   )
   public int field3614;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 154064303
   )
   public int field3615;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 641134977
   )
   public int field3616;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 261829985
   )
   public int field3632;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1814310991
   )
   public int field3629;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -973759109
   )
   public int field3606;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1574865517
   )
   public int field3636;
   @ObfuscatedName("d")
   @Export("colors")
   short[] colors;
   @ObfuscatedName("l")
   @Export("modifiedColors")
   short[] modifiedColors;
   @ObfuscatedName("f")
   short[] field3623;
   @ObfuscatedName("k")
   short[] field3624;
   @ObfuscatedName("e")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("u")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1510738583
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1251831027
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1648612689
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("c")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1894413203
   )
   int field3631;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -882004885
   )
   int field3620;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 2096833257
   )
   public int field3633;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1341432275
   )
   public int field3634;
   @ObfuscatedName("ay")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1973642601
   )
   @Export("varpIndex")
   int varpIndex;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -325693283
   )
   @Export("varp32Index")
   int varp32Index;
   @ObfuscatedName("ah")
   public boolean field3630;
   @ObfuscatedName("ai")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("au")
   public boolean field3640;
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   IterableHashTable field3641;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.field3611 = 1;
      this.field3614 = -1;
      this.field3615 = -1;
      this.field3616 = -1;
      this.field3632 = -1;
      this.field3629 = -1;
      this.field3606 = -1;
      this.field3636 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.isVisible = false;
      this.field3631 = 0;
      this.field3620 = 0;
      this.field3633 = -1;
      this.field3634 = 32;
      this.varpIndex = -1;
      this.varp32Index = -1;
      this.field3630 = true;
      this.isClickable = true;
      this.field3640 = false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-735362588"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lgj;B)V",
      garbageValue = "100"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgj;II)V",
      garbageValue = "2100498291"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      int var3;
      int var4;
      if(var2 == 1) {
         var3 = var1.readUnsignedByte();
         this.models = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.models[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 2) {
         this.name = var1.readString();
      } else if(var2 == 12) {
         this.field3611 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3614 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3632 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3615 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3616 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3632 = var1.readUnsignedShort();
         this.field3629 = var1.readUnsignedShort();
         this.field3606 = var1.readUnsignedShort();
         this.field3636 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readString();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.colors = new short[var3];
         this.modifiedColors = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.colors[var4] = (short)var1.readUnsignedShort();
            this.modifiedColors[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3623 = new short[var3];
         this.field3624 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3623[var4] = (short)var1.readUnsignedShort();
            this.field3624[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3613 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3613[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.widthScale = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.heightScale = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3631 = var1.readByte();
      } else if(var2 == 101) {
         this.field3620 = var1.readByte();
      } else if(var2 == 102) {
         this.field3633 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3634 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3630 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3640 = true;
         } else if(var2 == 249) {
            this.field3641 = Widget.readStringIntParameters(var1, this.field3641);
         }
      } else {
         this.varpIndex = var1.readUnsignedShort();
         if(this.varpIndex == 65535) {
            this.varpIndex = -1;
         }

         this.varp32Index = var1.readUnsignedShort();
         if(this.varp32Index == 65535) {
            this.varp32Index = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.readUnsignedShort();
            if(var3 == 65535) {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.configs = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.configs[var5] = var1.readUnsignedShort();
            if(this.configs[var5] == 65535) {
               this.configs[var5] = -1;
            }
         }

         this.configs[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljm;ILjm;II)Len;",
      garbageValue = "-1101875923"
   )
   @Export("getModel")
   public final Model getModel(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.configs != null) {
         NPCComposition var12 = this.transform();
         return var12 == null?null:var12.getModel(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!class3.NpcDefinition_modelIndexCache.tryLoadRecord(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2567(class3.NpcDefinition_modelIndexCache, this.models[var9], 0);
            }

            ModelData var11;
            if(var8.length == 1) {
               var11 = var8[0];
            } else {
               var11 = new ModelData(var8, var8.length);
            }

            if(this.colors != null) {
               for(var9 = 0; var9 < this.colors.length; ++var9) {
                  var11.recolor(this.colors[var9], this.modifiedColors[var9]);
               }
            }

            if(this.field3623 != null) {
               for(var9 = 0; var9 < this.field3623.length; ++var9) {
                  var11.method2579(this.field3623[var9], this.field3624[var9]);
               }
            }

            var5 = var11.light(this.field3631 + 64, this.field3620 * 5 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method4954(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method4958(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method4958(var5, var4);
         } else {
            var10 = var5.method2657(true);
         }

         if(this.widthScale != 128 || this.heightScale != 128) {
            var10.scale(this.widthScale, this.heightScale, this.widthScale);
         }

         return var10;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Ldy;",
      garbageValue = "1853397877"
   )
   public final ModelData method4929() {
      if(this.configs != null) {
         NPCComposition var1 = this.transform();
         return var1 == null?null:var1.method4929();
      } else if(this.field3613 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3613.length; ++var2) {
            if(!class3.NpcDefinition_modelIndexCache.tryLoadRecord(this.field3613[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3613.length];

            for(int var3 = 0; var3 < this.field3613.length; ++var3) {
               var6[var3] = ModelData.method2567(class3.NpcDefinition_modelIndexCache, this.field3613[var3], 0);
            }

            ModelData var7;
            if(var6.length == 1) {
               var7 = var6[0];
            } else {
               var7 = new ModelData(var6, var6.length);
            }

            int var4;
            if(this.colors != null) {
               for(var4 = 0; var4 < this.colors.length; ++var4) {
                  var7.recolor(this.colors[var4], this.modifiedColors[var4]);
               }
            }

            if(this.field3623 != null) {
               for(var4 = 0; var4 < this.field3623.length; ++var4) {
                  var7.method2579(this.field3623[var4], this.field3624[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Ljp;",
      garbageValue = "151855832"
   )
   @Export("transform")
   public final NPCComposition transform() {
      int var1 = -1;
      if(this.varpIndex != -1) {
         var1 = LoginPacket.getVarbit(this.varpIndex);
      } else if(this.varp32Index != -1) {
         var1 = class222.widgetSettings[this.varp32Index];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class230.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1527934897"
   )
   public boolean method4904() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.varpIndex != -1) {
            var1 = LoginPacket.getVarbit(this.varpIndex);
         } else if(this.varp32Index != -1) {
            var1 = class222.widgetSettings[this.varp32Index];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-2066941938"
   )
   public int method4905(int var1, int var2) {
      return CollisionData.method3283(this.field3641, var1, var2);
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "2038705764"
   )
   public String method4915(int var1, String var2) {
      return MessageNode.method1088(this.field3641, var1, var2);
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1151864465"
   )
   static final int method4931() {
      if(class221.preferences.hideRoofs) {
         return MessageNode.plane;
      } else {
         int var0 = GameCanvas.getTileHeight(Actor.cameraX, GameCanvas.cameraY, MessageNode.plane);
         return var0 - class60.cameraZ < 800 && (class61.tileSettings[MessageNode.plane][Actor.cameraX >> 7][GameCanvas.cameraY >> 7] & 4) != 0?MessageNode.plane:3;
      }
   }
}
