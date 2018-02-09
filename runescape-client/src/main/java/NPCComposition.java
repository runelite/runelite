import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jv")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("NpcDefinition_indexCache")
   static IndexDataBase NpcDefinition_indexCache;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("NpcDefinition_modelIndexCache")
   static IndexDataBase NpcDefinition_modelIndexCache;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("npcs")
   public static NodeCache npcs;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("npcModelCache")
   public static NodeCache npcModelCache;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1050975859
   )
   @Export("id")
   public int id;
   @ObfuscatedName("w")
   @Export("name")
   public String name;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 105422629
   )
   public int field3633;
   @ObfuscatedName("d")
   @Export("models")
   int[] models;
   @ObfuscatedName("z")
   int[] field3635;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1190872175
   )
   public int field3636;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -242627277
   )
   public int field3637;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 909382013
   )
   public int field3639;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -319415687
   )
   public int field3627;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1809592145
   )
   public int field3640;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -427188583
   )
   public int field3645;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1038429365
   )
   public int field3642;
   @ObfuscatedName("x")
   @Export("colors")
   short[] colors;
   @ObfuscatedName("u")
   @Export("modifiedColors")
   short[] modifiedColors;
   @ObfuscatedName("b")
   short[] field3641;
   @ObfuscatedName("p")
   short[] field3646;
   @ObfuscatedName("y")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("n")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1584421077
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 214895831
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1640441761
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("a")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -211140211
   )
   int field3653;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1157901163
   )
   int field3630;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 163351435
   )
   public int field3655;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1287810343
   )
   public int field3634;
   @ObfuscatedName("an")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1411261537
   )
   @Export("varpIndex")
   int varpIndex;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -654061997
   )
   @Export("varp32Index")
   int varp32Index;
   @ObfuscatedName("ax")
   public boolean field3660;
   @ObfuscatedName("ak")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("aw")
   public boolean field3638;
   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   IterableHashTable field3663;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.field3633 = 1;
      this.field3636 = -1;
      this.field3637 = -1;
      this.field3639 = -1;
      this.field3627 = -1;
      this.field3640 = -1;
      this.field3645 = -1;
      this.field3642 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.isVisible = false;
      this.field3653 = 0;
      this.field3630 = 0;
      this.field3655 = -1;
      this.field3634 = 32;
      this.varpIndex = -1;
      this.varp32Index = -1;
      this.field3660 = true;
      this.isClickable = true;
      this.field3638 = false;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-301358075"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgy;B)V",
      garbageValue = "-13"
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "-591835367"
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
         this.field3633 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3636 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3627 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3637 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3639 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3627 = var1.readUnsignedShort();
         this.field3640 = var1.readUnsignedShort();
         this.field3645 = var1.readUnsignedShort();
         this.field3642 = var1.readUnsignedShort();
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
         this.field3641 = new short[var3];
         this.field3646 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3641[var4] = (short)var1.readUnsignedShort();
            this.field3646[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3635 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3635[var4] = var1.readUnsignedShort();
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
         this.field3630 = var1.readByte();
      } else if(var2 == 102) {
         this.field3655 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3634 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3660 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3638 = true;
         } else if(var2 == 249) {
            this.field3663 = class255.readStringIntParameters(var1, this.field3663);
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lje;ILje;II)Les;",
      garbageValue = "171522514"
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
               var8[var9] = ModelData.method2620(NpcDefinition_modelIndexCache, this.models[var9], 0);
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

            if(this.field3641 != null) {
               for(var9 = 0; var9 < this.field3641.length; ++var9) {
                  var11.method2635(this.field3641[var9], this.field3646[var9]);
               }
            }

            var5 = var11.light(this.field3653 + 64, this.field3630 * 5 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method5082(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method5079(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method5079(var5, var4);
         } else {
            var10 = var5.method2737(true);
         }

         if(this.widthScale != 128 || this.heightScale != 128) {
            var10.scale(this.widthScale, this.heightScale, this.widthScale);
         }

         return var10;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(S)Ldw;",
      garbageValue = "24352"
   )
   public final ModelData method5055() {
      if(this.configs != null) {
         NPCComposition var1 = this.transform();
         return var1 == null?null:var1.method5055();
      } else if(this.field3635 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3635.length; ++var2) {
            if(!NpcDefinition_modelIndexCache.tryLoadRecord(this.field3635[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3635.length];

            for(int var3 = 0; var3 < this.field3635.length; ++var3) {
               var6[var3] = ModelData.method2620(NpcDefinition_modelIndexCache, this.field3635[var3], 0);
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

            if(this.field3641 != null) {
               for(var4 = 0; var4 < this.field3641.length; ++var4) {
                  var7.method2635(this.field3641[var4], this.field3646[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)Ljv;",
      garbageValue = "29"
   )
   @Export("transform")
   public final NPCComposition transform() {
      int var1 = -1;
      if(this.varpIndex != -1) {
         var1 = BoundingBox3DDrawMode.getVarbit(this.varpIndex);
      } else if(this.varp32Index != -1) {
         var1 = class222.widgetSettings[this.varp32Index];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?Spotanim.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-907732685"
   )
   public boolean method5026() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.varpIndex != -1) {
            var1 = BoundingBox3DDrawMode.getVarbit(this.varpIndex);
         } else if(this.varp32Index != -1) {
            var1 = class222.widgetSettings[this.varp32Index];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-995975984"
   )
   public int method5037(int var1, int var2) {
      return PendingSpawn.method1591(this.field3663, var1, var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "966600826"
   )
   public String method5028(int var1, String var2) {
      return IndexData.method4604(this.field3663, var1, var2);
   }

   @ObfuscatedName("ii")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;Ljava/lang/String;IIIIB)V",
      garbageValue = "14"
   )
   @Export("addMenuEntry")
   @Hook("addMenuEntry")
   public static final void addMenuEntry(String var0, String var1, int var2, int var3, int var4, int var5) {
      Resampler.method2380(var0, var1, var2, var3, var4, var5, false);
   }
}
