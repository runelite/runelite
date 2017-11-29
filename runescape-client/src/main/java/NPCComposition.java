import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jd")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("NpcDefinition_indexCache")
   static IndexDataBase NpcDefinition_indexCache;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lid;"
   )
   @Export("NpcDefinition_modelIndexCache")
   static IndexDataBase NpcDefinition_modelIndexCache;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("npcs")
   static NodeCache npcs;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("npcModelCache")
   static NodeCache npcModelCache;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 588093395
   )
   @Export("id")
   public int id;
   @ObfuscatedName("m")
   @Export("name")
   public String name;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 227059685
   )
   public int field3619;
   @ObfuscatedName("t")
   @Export("models")
   int[] models;
   @ObfuscatedName("p")
   int[] field3626;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1539695511
   )
   public int field3622;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 496604341
   )
   public int field3623;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1493134779
   )
   public int field3624;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1503751053
   )
   public int field3641;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -193532597
   )
   public int field3617;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1580276605
   )
   public int field3640;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -796544783
   )
   public int field3628;
   @ObfuscatedName("f")
   @Export("colors")
   short[] colors;
   @ObfuscatedName("s")
   @Export("modifiedColors")
   short[] modifiedColors;
   @ObfuscatedName("e")
   short[] field3631;
   @ObfuscatedName("q")
   short[] field3632;
   @ObfuscatedName("h")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("i")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1440226261
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 2051306817
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -289619445
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("a")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -561984409
   )
   int field3639;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1475711863
   )
   int field3630;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 2111385797
   )
   public int field3621;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -674257493
   )
   public int field3613;
   @ObfuscatedName("aq")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -969572959
   )
   @Export("varpIndex")
   int varpIndex;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 210283783
   )
   @Export("varp32Index")
   int varp32Index;
   @ObfuscatedName("ae")
   public boolean field3627;
   @ObfuscatedName("aj")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("as")
   public boolean field3648;
   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   IterableHashTable field3618;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.field3619 = 1;
      this.field3622 = -1;
      this.field3623 = -1;
      this.field3624 = -1;
      this.field3641 = -1;
      this.field3617 = -1;
      this.field3640 = -1;
      this.field3628 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.isVisible = false;
      this.field3639 = 0;
      this.field3630 = 0;
      this.field3621 = -1;
      this.field3613 = 32;
      this.varpIndex = -1;
      this.varp32Index = -1;
      this.field3627 = true;
      this.isClickable = true;
      this.field3648 = false;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2123125186"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lfr;I)V",
      garbageValue = "476346768"
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lfr;IB)V",
      garbageValue = "77"
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
         this.field3619 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3622 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3641 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3623 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3624 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3641 = var1.readUnsignedShort();
         this.field3617 = var1.readUnsignedShort();
         this.field3640 = var1.readUnsignedShort();
         this.field3628 = var1.readUnsignedShort();
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
         this.field3631 = new short[var3];
         this.field3632 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3631[var4] = (short)var1.readUnsignedShort();
            this.field3632[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3626 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3626[var4] = var1.readUnsignedShort();
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
         this.field3639 = var1.readByte();
      } else if(var2 == 101) {
         this.field3630 = var1.readByte();
      } else if(var2 == 102) {
         this.field3621 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3613 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3627 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3648 = true;
         } else if(var2 == 249) {
            this.field3618 = CacheFile.readStringIntParameters(var1, this.field3618);
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

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Ljj;ILjj;II)Leh;",
      garbageValue = "1223480572"
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
               var8[var9] = ModelData.method2510(NpcDefinition_modelIndexCache, this.models[var9], 0);
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

            if(this.field3631 != null) {
               for(var9 = 0; var9 < this.field3631.length; ++var9) {
                  var11.method2523(this.field3631[var9], this.field3632[var9]);
               }
            }

            var5 = var11.light(this.field3639 + 64, this.field3630 * 5 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method4880(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method4882(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method4882(var5, var4);
         } else {
            var10 = var5.method2619(true);
         }

         if(this.widthScale != 128 || this.heightScale != 128) {
            var10.scale(this.widthScale, this.heightScale, this.widthScale);
         }

         return var10;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Ldr;",
      garbageValue = "220780624"
   )
   public final ModelData method4842() {
      if(this.configs != null) {
         NPCComposition var1 = this.transform();
         return var1 == null?null:var1.method4842();
      } else if(this.field3626 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3626.length; ++var2) {
            if(!NpcDefinition_modelIndexCache.tryLoadRecord(this.field3626[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3626.length];

            for(int var3 = 0; var3 < this.field3626.length; ++var3) {
               var6[var3] = ModelData.method2510(NpcDefinition_modelIndexCache, this.field3626[var3], 0);
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

            if(this.field3631 != null) {
               for(var4 = 0; var4 < this.field3631.length; ++var4) {
                  var7.method2523(this.field3631[var4], this.field3632[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Ljd;",
      garbageValue = "1784873691"
   )
   @Export("transform")
   public final NPCComposition transform() {
      int var1 = -1;
      if(this.varpIndex != -1) {
         var1 = Friend.getVarbit(this.varpIndex);
      } else if(this.varp32Index != -1) {
         var1 = class218.widgetSettings[this.varp32Index];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class1.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   public boolean method4830() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.varpIndex != -1) {
            var1 = Friend.getVarbit(this.varpIndex);
         } else if(this.varp32Index != -1) {
            var1 = class218.widgetSettings[this.varp32Index];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1222657845"
   )
   public int method4834(int var1, int var2) {
      return IndexData.method4372(this.field3618, var1, var2);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-644872554"
   )
   public String method4855(int var1, String var2) {
      return Occluder.method3016(this.field3618, var1, var2);
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "([Lhx;Lhx;ZB)V",
      garbageValue = "-83"
   )
   static void method4864(Widget[] var0, Widget var1, boolean var2) {
      int var3 = var1.scrollWidth != 0?var1.scrollWidth:var1.width;
      int var4 = var1.scrollHeight != 0?var1.scrollHeight:var1.height;
      class11.method66(var0, var1.id, var3, var4, var2);
      if(var1.children != null) {
         class11.method66(var1.children, var1.id, var3, var4, var2);
      }

      WidgetNode var5 = (WidgetNode)Client.componentTable.get((long)var1.id);
      if(var5 != null) {
         class47.method711(var5.id, var3, var4, var2);
      }

      if(var1.contentType == 1337) {
         ;
      }

   }
}
