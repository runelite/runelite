import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jd")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   @Export("NpcDefinition_indexCache")
   static IndexDataBase NpcDefinition_indexCache;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   @Export("NpcDefinition_modelIndexCache")
   static IndexDataBase NpcDefinition_modelIndexCache;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("npcs")
   static NodeCache npcs;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("npcModelCache")
   static NodeCache npcModelCache;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1619985449
   )
   @Export("id")
   public int id;
   @ObfuscatedName("b")
   @Export("name")
   public String name;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1454108389
   )
   public int field3710;
   @ObfuscatedName("x")
   @Export("models")
   int[] models;
   @ObfuscatedName("p")
   int[] field3739;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1703785911
   )
   public int field3714;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1111484803
   )
   public int field3715;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1377684571
   )
   public int field3716;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -289668641
   )
   public int field3717;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -770095869
   )
   public int field3718;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 482965237
   )
   public int field3719;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 664165873
   )
   public int field3740;
   @ObfuscatedName("k")
   @Export("colors")
   short[] colors;
   @ObfuscatedName("z")
   @Export("modifiedColors")
   short[] modifiedColors;
   @ObfuscatedName("w")
   short[] field3723;
   @ObfuscatedName("s")
   short[] field3724;
   @ObfuscatedName("d")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("f")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -780410921
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1613984187
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1940727821
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("m")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 802564477
   )
   int field3731;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 552613297
   )
   int field3706;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1906771863
   )
   public int field3733;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1400194797
   )
   public int field3720;
   @ObfuscatedName("ae")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1065473719
   )
   @Export("varpIndex")
   int varpIndex;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 845633417
   )
   @Export("varp32Index")
   int varp32Index;
   @ObfuscatedName("ap")
   public boolean field3738;
   @ObfuscatedName("ah")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("au")
   public boolean field3732;
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   IterableHashTable field3741;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.field3710 = 1;
      this.field3714 = -1;
      this.field3715 = -1;
      this.field3716 = -1;
      this.field3717 = -1;
      this.field3718 = -1;
      this.field3719 = -1;
      this.field3740 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.isVisible = false;
      this.field3731 = 0;
      this.field3706 = 0;
      this.field3733 = -1;
      this.field3720 = 32;
      this.varpIndex = -1;
      this.varp32Index = -1;
      this.field3738 = true;
      this.isClickable = true;
      this.field3732 = false;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-4"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgb;I)V",
      garbageValue = "1820442930"
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lgb;II)V",
      garbageValue = "1649246065"
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
         this.field3710 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3714 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3717 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3715 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3716 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3717 = var1.readUnsignedShort();
         this.field3718 = var1.readUnsignedShort();
         this.field3719 = var1.readUnsignedShort();
         this.field3740 = var1.readUnsignedShort();
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
         this.field3723 = new short[var3];
         this.field3724 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3723[var4] = (short)var1.readUnsignedShort();
            this.field3724[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3739 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3739[var4] = var1.readUnsignedShort();
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
         this.field3731 = var1.readByte();
      } else if(var2 == 101) {
         this.field3706 = var1.readByte();
      } else if(var2 == 102) {
         this.field3733 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3720 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3738 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3732 = true;
         } else if(var2 == 249) {
            this.field3741 = class2.readStringIntParameters(var1, this.field3741);
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Lkf;ILkf;IB)Lek;",
      garbageValue = "26"
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
               var8[var9] = ModelData.method2594(NpcDefinition_modelIndexCache, this.models[var9], 0);
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

            if(this.field3723 != null) {
               for(var9 = 0; var9 < this.field3723.length; ++var9) {
                  var11.method2609(this.field3723[var9], this.field3724[var9]);
               }
            }

            var5 = var11.light(this.field3731 + 64, this.field3706 * 5 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method5171(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method5168(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method5168(var5, var4);
         } else {
            var10 = var5.method2686(true);
         }

         if(this.widthScale != 128 || this.heightScale != 128) {
            var10.scale(this.widthScale, this.heightScale, this.widthScale);
         }

         return var10;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Ldi;",
      garbageValue = "-2000304710"
   )
   public final ModelData method5113() {
      if(this.configs != null) {
         NPCComposition var1 = this.transform();
         return var1 == null?null:var1.method5113();
      } else if(this.field3739 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3739.length; ++var2) {
            if(!NpcDefinition_modelIndexCache.tryLoadRecord(this.field3739[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3739.length];

            for(int var3 = 0; var3 < this.field3739.length; ++var3) {
               var6[var3] = ModelData.method2594(NpcDefinition_modelIndexCache, this.field3739[var3], 0);
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

            if(this.field3723 != null) {
               for(var4 = 0; var4 < this.field3723.length; ++var4) {
                  var7.method2609(this.field3723[var4], this.field3724[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)Ljd;",
      garbageValue = "-908776876"
   )
   @Export("transform")
   public final NPCComposition transform() {
      int var1 = -1;
      if(this.varpIndex != -1) {
         var1 = World.getVarbit(this.varpIndex);
      } else if(this.varp32Index != -1) {
         var1 = class237.widgetSettings[this.varp32Index];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class233.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-45"
   )
   public boolean method5141() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.varpIndex != -1) {
            var1 = World.getVarbit(this.varpIndex);
         } else if(this.varp32Index != -1) {
            var1 = class237.widgetSettings[this.varp32Index];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "565908699"
   )
   public int method5116(int var1, int var2) {
      return class297.method5284(this.field3741, var1, var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1026510123"
   )
   public String method5117(int var1, String var2) {
      IterableHashTable var4 = this.field3741;
      String var3;
      if(var4 == null) {
         var3 = var2;
      } else {
         ObjectNode var5 = (ObjectNode)var4.get((long)var1);
         if(var5 == null) {
            var3 = var2;
         } else {
            var3 = (String)var5.value;
         }
      }

      return var3;
   }
}
