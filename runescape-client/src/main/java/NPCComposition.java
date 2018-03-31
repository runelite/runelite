import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jk")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("NpcDefinition_indexCache")
   public static IndexDataBase NpcDefinition_indexCache;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("NpcDefinition_modelIndexCache")
   public static IndexDataBase NpcDefinition_modelIndexCache;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("npcs")
   static NodeCache npcs;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("npcModelCache")
   static NodeCache npcModelCache;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1851650433
   )
   @Export("id")
   public int id;
   @ObfuscatedName("x")
   @Export("name")
   public String name;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 2070135969
   )
   public int field3702;
   @ObfuscatedName("p")
   @Export("models")
   int[] models;
   @ObfuscatedName("w")
   int[] field3704;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1644061519
   )
   public int field3716;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 416280611
   )
   public int field3706;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 370330411
   )
   public int field3721;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 85197765
   )
   public int field3707;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1524691725
   )
   public int field3709;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 272359655
   )
   public int field3710;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 490723163
   )
   public int field3711;
   @ObfuscatedName("b")
   @Export("colors")
   short[] colors;
   @ObfuscatedName("h")
   @Export("modifiedColors")
   short[] modifiedColors;
   @ObfuscatedName("t")
   short[] field3696;
   @ObfuscatedName("v")
   short[] field3725;
   @ObfuscatedName("n")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("u")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1468343159
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 503367255
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 735676559
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("s")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -2040281765
   )
   int field3722;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 140627343
   )
   int field3723;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 554447785
   )
   public int field3724;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -478671207
   )
   public int field3728;
   @ObfuscatedName("ab")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1468818249
   )
   @Export("varpIndex")
   int varpIndex;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 387497477
   )
   @Export("varp32Index")
   int varp32Index;
   @ObfuscatedName("aa")
   public boolean field3729;
   @ObfuscatedName("ah")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("ao")
   public boolean field3731;
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   IterableHashTable field3732;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.field3702 = 1;
      this.field3716 = -1;
      this.field3706 = -1;
      this.field3721 = -1;
      this.field3707 = -1;
      this.field3709 = -1;
      this.field3710 = -1;
      this.field3711 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.isVisible = false;
      this.field3722 = 0;
      this.field3723 = 0;
      this.field3724 = -1;
      this.field3728 = 32;
      this.varpIndex = -1;
      this.varp32Index = -1;
      this.field3729 = true;
      this.isClickable = true;
      this.field3731 = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-77"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "1008043309"
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
      signature = "(Lgp;II)V",
      garbageValue = "-22346527"
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
         this.field3702 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3716 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3707 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3706 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3721 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3707 = var1.readUnsignedShort();
         this.field3709 = var1.readUnsignedShort();
         this.field3710 = var1.readUnsignedShort();
         this.field3711 = var1.readUnsignedShort();
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
         this.field3696 = new short[var3];
         this.field3725 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3696[var4] = (short)var1.readUnsignedShort();
            this.field3725[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3704 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3704[var4] = var1.readUnsignedShort();
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
         this.field3722 = var1.readByte();
      } else if(var2 == 101) {
         this.field3723 = var1.readByte();
      } else if(var2 == 102) {
         this.field3724 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3728 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3729 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3731 = true;
         } else if(var2 == 249) {
            this.field3732 = class245.readStringIntParameters(var1, this.field3732);
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lkn;ILkn;II)Led;",
      garbageValue = "674325363"
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
               if(!NpcDefinition_modelIndexCache.tryLoadRecord(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2583(NpcDefinition_modelIndexCache, this.models[var9], 0);
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

            if(this.field3696 != null) {
               for(var9 = 0; var9 < this.field3696.length; ++var9) {
                  var11.method2660(this.field3696[var9], this.field3725[var9]);
               }
            }

            var5 = var11.light(this.field3722 + 64, this.field3723 * 5 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.applyTransformations(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.transformActorModel(var5, var2);
         } else if(var3 != null) {
            var10 = var3.transformActorModel(var5, var4);
         } else {
            var10 = var5.toSharedModel(true);
         }

         if(this.widthScale != 128 || this.heightScale != 128) {
            var10.scale(this.widthScale, this.heightScale, this.widthScale);
         }

         return var10;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Ldj;",
      garbageValue = "1022801171"
   )
   public final ModelData method5126() {
      if(this.configs != null) {
         NPCComposition var1 = this.transform();
         return var1 == null?null:var1.method5126();
      } else if(this.field3704 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3704.length; ++var2) {
            if(!NpcDefinition_modelIndexCache.tryLoadRecord(this.field3704[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3704.length];

            for(int var3 = 0; var3 < this.field3704.length; ++var3) {
               var6[var3] = ModelData.method2583(NpcDefinition_modelIndexCache, this.field3704[var3], 0);
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

            if(this.field3696 != null) {
               for(var4 = 0; var4 < this.field3696.length; ++var4) {
                  var7.method2660(this.field3696[var4], this.field3725[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Ljk;",
      garbageValue = "1576606985"
   )
   @Export("transform")
   public final NPCComposition transform() {
      int var1 = -1;
      if(this.varpIndex != -1) {
         var1 = class88.getVarbit(this.varpIndex);
      } else if(this.varp32Index != -1) {
         var1 = class237.clientVarps[this.varp32Index];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?ScriptEvent.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1179014291"
   )
   public boolean method5134() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.varpIndex != -1) {
            var1 = class88.getVarbit(this.varpIndex);
         } else if(this.varp32Index != -1) {
            var1 = class237.clientVarps[this.varp32Index];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "709417805"
   )
   public int method5129(int var1, int var2) {
      return class23.method190(this.field3732, var1, var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "2"
   )
   public String method5130(int var1, String var2) {
      return class155.method3172(this.field3732, var1, var2);
   }
}
