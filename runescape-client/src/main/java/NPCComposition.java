import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("NpcDefinition_indexCache")
   public static IndexDataBase NpcDefinition_indexCache;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("NpcDefinition_modelIndexCache")
   public static IndexDataBase NpcDefinition_modelIndexCache;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("npcs")
   static NodeCache npcs;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("npcModelCache")
   static NodeCache npcModelCache;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -168395161
   )
   @Export("id")
   public int id;
   @ObfuscatedName("n")
   @Export("name")
   public String name;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 106071213
   )
   @Export("size")
   public int size;
   @ObfuscatedName("x")
   @Export("models")
   int[] models;
   @ObfuscatedName("j")
   @Export("additionalModels")
   int[] additionalModels;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -864701749
   )
   @Export("standingAnimation")
   public int standingAnimation;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 116335143
   )
   public int field3509;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -359593807
   )
   public int field3499;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1295753849
   )
   @Export("walkingAnimation")
   public int walkingAnimation;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -562700529
   )
   @Export("rotate180Animation")
   public int rotate180Animation;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1082594129
   )
   @Export("rotate90RightAnimation")
   public int rotate90RightAnimation;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -611649737
   )
   @Export("rotate90LeftAnimation")
   public int rotate90LeftAnimation;
   @ObfuscatedName("c")
   @Export("colors")
   short[] colors;
   @ObfuscatedName("e")
   @Export("modifiedColors")
   short[] modifiedColors;
   @ObfuscatedName("t")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("u")
   @Export("textureToReplaceWith")
   short[] textureToReplaceWith;
   @ObfuscatedName("i")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("z")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 108735845
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 2066846285
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1631856349
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("o")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 97689843
   )
   @Export("ambient")
   int ambient;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1705110531
   )
   @Export("contrast")
   int contrast;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1324227797
   )
   @Export("headIcon")
   public int headIcon;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -204190151
   )
   @Export("rotation")
   public int rotation;
   @ObfuscatedName("ay")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 132919095
   )
   @Export("varpIndex")
   int varpIndex;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 517239649
   )
   @Export("varp32Index")
   int varp32Index;
   @ObfuscatedName("aw")
   public boolean field3535;
   @ObfuscatedName("ag")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("ah")
   public boolean field3534;
   @ObfuscatedName("az")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("params")
   IterableHashTable params;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.size = 1;
      this.standingAnimation = -1;
      this.field3509 = -1;
      this.field3499 = -1;
      this.walkingAnimation = -1;
      this.rotate180Animation = -1;
      this.rotate90RightAnimation = -1;
      this.rotate90LeftAnimation = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.isVisible = false;
      this.ambient = 0;
      this.contrast = 0;
      this.headIcon = -1;
      this.rotation = 32;
      this.varpIndex = -1;
      this.varp32Index = -1;
      this.field3535 = true;
      this.isClickable = true;
      this.field3534 = false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "500"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "-9980013"
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-2118823050"
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
         this.size = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.standingAnimation = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.walkingAnimation = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3509 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3499 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.walkingAnimation = var1.readUnsignedShort();
         this.rotate180Animation = var1.readUnsignedShort();
         this.rotate90RightAnimation = var1.readUnsignedShort();
         this.rotate90LeftAnimation = var1.readUnsignedShort();
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
         this.textureToReplace = new short[var3];
         this.textureToReplaceWith = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.textureToReplace[var4] = (short)var1.readUnsignedShort();
            this.textureToReplaceWith[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.additionalModels = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.additionalModels[var4] = var1.readUnsignedShort();
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
         this.ambient = var1.readByte();
      } else if(var2 == 101) {
         this.contrast = var1.readByte();
      } else if(var2 == 102) {
         this.headIcon = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.rotation = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3535 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3534 = true;
         } else if(var2 == 249) {
            this.params = CacheFile.readStringIntParameters(var1, this.params);
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljh;ILjh;IB)Ldk;",
      garbageValue = "-62"
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
               var8[var9] = ModelData.method2619(NpcDefinition_modelIndexCache, this.models[var9], 0);
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

            if(this.textureToReplace != null) {
               for(var9 = 0; var9 < this.textureToReplace.length; ++var9) {
                  var11.method2632(this.textureToReplace[var9], this.textureToReplaceWith[var9]);
               }
            }

            var5 = var11.light(this.ambient + 64, this.contrast * 5 + 850, -30, -50, -30);
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)Ldo;",
      garbageValue = "14"
   )
   public final ModelData method5174() {
      if(this.configs != null) {
         NPCComposition var1 = this.transform();
         return var1 == null?null:var1.method5174();
      } else if(this.additionalModels == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.additionalModels.length; ++var2) {
            if(!NpcDefinition_modelIndexCache.tryLoadRecord(this.additionalModels[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.additionalModels.length];

            for(int var3 = 0; var3 < this.additionalModels.length; ++var3) {
               var6[var3] = ModelData.method2619(NpcDefinition_modelIndexCache, this.additionalModels[var3], 0);
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

            if(this.textureToReplace != null) {
               for(var4 = 0; var4 < this.textureToReplace.length; ++var4) {
                  var7.method2632(this.textureToReplace[var4], this.textureToReplaceWith[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Ljj;",
      garbageValue = "1865410382"
   )
   @Export("transform")
   public final NPCComposition transform() {
      int var1 = -1;
      if(this.varpIndex != -1) {
         var1 = class138.getVarbit(this.varpIndex);
      } else if(this.varp32Index != -1) {
         var1 = class225.clientVarps[this.varp32Index];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class59.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "64"
   )
   public boolean method5194() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.varpIndex != -1) {
            var1 = class138.getVarbit(this.varpIndex);
         } else if(this.varp32Index != -1) {
            var1 = class225.clientVarps[this.varp32Index];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1161234943"
   )
   public int method5196(int var1, int var2) {
      IterableHashTable var4 = this.params;
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-370870861"
   )
   public String method5175(int var1, String var2) {
      return CombatInfoListHolder.method1822(this.params, var1, var2);
   }
}
