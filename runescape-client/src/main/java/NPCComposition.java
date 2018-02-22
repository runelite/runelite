import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jd")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   @Export("NpcDefinition_indexCache")
   static IndexDataBase NpcDefinition_indexCache;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("npcs")
   public static NodeCache npcs;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("npcModelCache")
   public static NodeCache npcModelCache;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 2084779967
   )
   @Export("id")
   public int id;
   @ObfuscatedName("h")
   @Export("name")
   public String name;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 439571437
   )
   public int field3661;
   @ObfuscatedName("y")
   @Export("models")
   int[] models;
   @ObfuscatedName("g")
   int[] field3640;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1848553403
   )
   public int field3636;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 652478615
   )
   public int field3637;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1740851199
   )
   public int field3638;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1485282877
   )
   public int field3648;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -586070085
   )
   public int field3642;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -130226439
   )
   public int field3641;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -801723101
   )
   public int field3639;
   @ObfuscatedName("f")
   @Export("colors")
   short[] colors;
   @ObfuscatedName("m")
   @Export("modifiedColors")
   short[] modifiedColors;
   @ObfuscatedName("x")
   short[] field3645;
   @ObfuscatedName("w")
   short[] field3629;
   @ObfuscatedName("j")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("z")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 436753909
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -596078043
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1620896221
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("i")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 2003927727
   )
   int field3653;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 218322719
   )
   int field3646;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1432210743
   )
   public int field3635;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1134627807
   )
   public int field3628;
   @ObfuscatedName("ah")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1568009343
   )
   @Export("varpIndex")
   int varpIndex;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 638086373
   )
   @Export("varp32Index")
   int varp32Index;
   @ObfuscatedName("aq")
   public boolean field3660;
   @ObfuscatedName("ak")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("al")
   public boolean field3662;
   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   IterableHashTable field3663;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.field3661 = 1;
      this.field3636 = -1;
      this.field3637 = -1;
      this.field3638 = -1;
      this.field3648 = -1;
      this.field3642 = -1;
      this.field3641 = -1;
      this.field3639 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.isVisible = false;
      this.field3653 = 0;
      this.field3646 = 0;
      this.field3635 = -1;
      this.field3628 = 32;
      this.varpIndex = -1;
      this.varp32Index = -1;
      this.field3660 = true;
      this.isClickable = true;
      this.field3662 = false;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2117886077"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lgn;I)V",
      garbageValue = "1195170920"
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgn;II)V",
      garbageValue = "1170580597"
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
         this.field3661 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3636 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3648 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3637 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3638 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3648 = var1.readUnsignedShort();
         this.field3642 = var1.readUnsignedShort();
         this.field3641 = var1.readUnsignedShort();
         this.field3639 = var1.readUnsignedShort();
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
         this.field3645 = new short[var3];
         this.field3629 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3645[var4] = (short)var1.readUnsignedShort();
            this.field3629[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3640 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3640[var4] = var1.readUnsignedShort();
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
         this.field3653 = var1.readByte();
      } else if(var2 == 101) {
         this.field3646 = var1.readByte();
      } else if(var2 == 102) {
         this.field3635 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3628 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3660 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3662 = true;
         } else if(var2 == 249) {
            this.field3663 = Tile.readStringIntParameters(var1, this.field3663);
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljo;ILjo;II)Lee;",
      garbageValue = "-1049755456"
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
               if(!class159.NpcDefinition_modelIndexCache.tryLoadRecord(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2601(class159.NpcDefinition_modelIndexCache, this.models[var9], 0);
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

            if(this.field3645 != null) {
               for(var9 = 0; var9 < this.field3645.length; ++var9) {
                  var11.method2614(this.field3645[var9], this.field3629[var9]);
               }
            }

            var5 = var11.light(this.field3653 + 64, this.field3646 * 5 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method5134(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method5136(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method5136(var5, var4);
         } else {
            var10 = var5.method2703(true);
         }

         if(this.widthScale != 128 || this.heightScale != 128) {
            var10.scale(this.widthScale, this.heightScale, this.widthScale);
         }

         return var10;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Ldy;",
      garbageValue = "1114131120"
   )
   public final ModelData method5073() {
      if(this.configs != null) {
         NPCComposition var1 = this.transform();
         return var1 == null?null:var1.method5073();
      } else if(this.field3640 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3640.length; ++var2) {
            if(!class159.NpcDefinition_modelIndexCache.tryLoadRecord(this.field3640[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3640.length];

            for(int var3 = 0; var3 < this.field3640.length; ++var3) {
               var6[var3] = ModelData.method2601(class159.NpcDefinition_modelIndexCache, this.field3640[var3], 0);
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

            if(this.field3645 != null) {
               for(var4 = 0; var4 < this.field3645.length; ++var4) {
                  var7.method2614(this.field3645[var4], this.field3629[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Ljd;",
      garbageValue = "-1065809100"
   )
   @Export("transform")
   public final NPCComposition transform() {
      int var1 = -1;
      if(this.varpIndex != -1) {
         var1 = class28.getVarbit(this.varpIndex);
      } else if(this.varp32Index != -1) {
         var1 = class231.widgetSettings[this.varp32Index];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?Tile.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1428266920"
   )
   public boolean method5075() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.varpIndex != -1) {
            var1 = class28.getVarbit(this.varpIndex);
         } else if(this.varp32Index != -1) {
            var1 = class231.widgetSettings[this.varp32Index];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1848514004"
   )
   public int method5072(int var1, int var2) {
      IterableHashTable var4 = this.field3663;
      int var3;
      if(var4 == null) {
         var3 = var2;
      } else {
         IntegerNode var5 = (IntegerNode)var4.get((long)var1);
         if(var5 == null) {
            var3 = var2;
         } else {
            var3 = var5.value;
         }
      }

      return var3;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1093428043"
   )
   public String method5099(int var1, String var2) {
      return MouseInput.method1038(this.field3663, var1, var2);
   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(Lby;B)V",
      garbageValue = "115"
   )
   static final void method5107(PendingSpawn var0) {
      int var1 = 0;
      int var2 = -1;
      int var3 = 0;
      int var4 = 0;
      if(var0.type == 0) {
         var1 = GameObject.region.method2941(var0.level, var0.x, var0.y);
      }

      if(var0.type == 1) {
         var1 = GameObject.region.method2910(var0.level, var0.x, var0.y);
      }

      if(var0.type == 2) {
         var1 = GameObject.region.method2911(var0.level, var0.x, var0.y);
      }

      if(var0.type == 3) {
         var1 = GameObject.region.method2912(var0.level, var0.x, var0.y);
      }

      if(var1 != 0) {
         int var5 = GameObject.region.getObjectFlags(var0.level, var0.x, var0.y, var1);
         var2 = var1 >> 14 & 32767;
         var3 = var5 & 31;
         var4 = var5 >> 6 & 3;
      }

      var0.field1090 = var2;
      var0.field1086 = var3;
      var0.field1085 = var4;
   }
}
