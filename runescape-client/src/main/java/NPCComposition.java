import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("NpcDefinition_indexCache")
   static IndexDataBase NpcDefinition_indexCache;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   @Export("NpcDefinition_modelIndexCache")
   static IndexDataBase NpcDefinition_modelIndexCache;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   @Export("npcs")
   public static NodeCache npcs;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lga;"
   )
   @Export("npcModelCache")
   public static NodeCache npcModelCache;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1596908301
   )
   @Export("id")
   public int id;
   @ObfuscatedName("d")
   @Export("name")
   public String name;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1332194361
   )
   public int field3667;
   @ObfuscatedName("b")
   @Export("models")
   int[] models;
   @ObfuscatedName("e")
   int[] field3648;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1081196269
   )
   public int field3642;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1971354437
   )
   public int field3643;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1636628725
   )
   public int field3644;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -241305941
   )
   public int field3659;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -544603431
   )
   public int field3646;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1135353539
   )
   public int field3645;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -924336311
   )
   public int field3657;
   @ObfuscatedName("a")
   @Export("colors")
   short[] colors;
   @ObfuscatedName("i")
   @Export("modifiedColors")
   short[] modifiedColors;
   @ObfuscatedName("m")
   short[] field3647;
   @ObfuscatedName("x")
   short[] field3652;
   @ObfuscatedName("l")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("j")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1202986903
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1911594961
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1568843311
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("q")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1623963557
   )
   int field3640;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1352426493
   )
   int field3660;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -248859975
   )
   public int field3661;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1640740923
   )
   public int field3662;
   @ObfuscatedName("ad")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 1511343147
   )
   @Export("varpIndex")
   int varpIndex;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1997373267
   )
   @Export("varp32Index")
   int varp32Index;
   @ObfuscatedName("ae")
   public boolean field3666;
   @ObfuscatedName("av")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("am")
   public boolean field3668;
   @ObfuscatedName("ax")
   @ObfuscatedSignature(
      signature = "Lgb;"
   )
   IterableHashTable field3669;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.field3667 = 1;
      this.field3642 = -1;
      this.field3643 = -1;
      this.field3644 = -1;
      this.field3659 = -1;
      this.field3646 = -1;
      this.field3645 = -1;
      this.field3657 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.isVisible = false;
      this.field3640 = 0;
      this.field3660 = 0;
      this.field3661 = -1;
      this.field3662 = 32;
      this.varpIndex = -1;
      this.varp32Index = -1;
      this.field3666 = true;
      this.isClickable = true;
      this.field3668 = false;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1968171669"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgv;I)V",
      garbageValue = "431619053"
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgv;II)V",
      garbageValue = "1807911643"
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
         this.field3667 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3642 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3659 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3643 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3644 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3659 = var1.readUnsignedShort();
         this.field3646 = var1.readUnsignedShort();
         this.field3645 = var1.readUnsignedShort();
         this.field3657 = var1.readUnsignedShort();
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
         this.field3647 = new short[var3];
         this.field3652 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3647[var4] = (short)var1.readUnsignedShort();
            this.field3652[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3648 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3648[var4] = var1.readUnsignedShort();
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
         this.field3640 = var1.readByte();
      } else if(var2 == 101) {
         this.field3660 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3661 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3662 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3666 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3668 = true;
         } else if(var2 == 249) {
            this.field3669 = class18.readStringIntParameters(var1, this.field3669);
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Ljs;ILjs;II)Les;",
      garbageValue = "111125188"
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
               var8[var9] = ModelData.method2483(NpcDefinition_modelIndexCache, this.models[var9], 0);
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

            if(this.field3647 != null) {
               for(var9 = 0; var9 < this.field3647.length; ++var9) {
                  var11.method2486(this.field3647[var9], this.field3652[var9]);
               }
            }

            var5 = var11.light(this.field3640 + 64, this.field3660 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method4894(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method4916(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method4916(var5, var4);
         } else {
            var10 = var5.method2584(true);
         }

         if(this.widthScale != 128 || this.heightScale != 128) {
            var10.scale(this.widthScale, this.heightScale, this.widthScale);
         }

         return var10;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)Ldh;",
      garbageValue = "87"
   )
   public final ModelData method4827() {
      if(this.configs != null) {
         NPCComposition var1 = this.transform();
         return var1 == null?null:var1.method4827();
      } else if(this.field3648 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3648.length; ++var2) {
            if(!NpcDefinition_modelIndexCache.tryLoadRecord(this.field3648[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3648.length];

            for(int var3 = 0; var3 < this.field3648.length; ++var3) {
               var6[var3] = ModelData.method2483(NpcDefinition_modelIndexCache, this.field3648[var3], 0);
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

            if(this.field3647 != null) {
               for(var4 = 0; var4 < this.field3647.length; ++var4) {
                  var7.method2486(this.field3647[var4], this.field3652[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Ljh;",
      garbageValue = "0"
   )
   @Export("transform")
   public final NPCComposition transform() {
      int var1 = -1;
      if(this.varpIndex != -1) {
         var1 = PendingSpawn.getVarbit(this.varpIndex);
      } else if(this.varp32Index != -1) {
         var1 = class222.widgetSettings[this.varp32Index];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class45.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1370821649"
   )
   public boolean method4828() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.varpIndex != -1) {
            var1 = PendingSpawn.getVarbit(this.varpIndex);
         } else if(this.varp32Index != -1) {
            var1 = class222.widgetSettings[this.varp32Index];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1329373576"
   )
   public int method4829(int var1, int var2) {
      return GrandExchangeOffer.method113(this.field3669, var1, var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-2127864935"
   )
   public String method4822(int var1, String var2) {
      return class239.method4279(this.field3669, var1, var2);
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Liy;",
      garbageValue = "1648276028"
   )
   @Export("getSpotAnimType")
   public static Spotanim getSpotAnimType(int var0) {
      Spotanim var1 = (Spotanim)Spotanim.spotanims.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Spotanim.SpotAnimationDefinition_indexCache.getConfigData(13, var0);
         var1 = new Spotanim();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         Spotanim.spotanims.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "110"
   )
   public static void method4826() {
      try {
         if(class214.field2631 == 1) {
            int var0 = class214.field2630.method4004();
            if(var0 > 0 && class214.field2630.method3905()) {
               var0 -= FontName.field3711;
               if(var0 < 0) {
                  var0 = 0;
               }

               class214.field2630.method3898(var0);
               return;
            }

            class214.field2630.method3904();
            class214.field2630.method3902();
            if(class214.field2632 != null) {
               class214.field2631 = 2;
            } else {
               class214.field2631 = 0;
            }

            class72.field831 = null;
            UnitPriceComparator.field299 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class214.field2630.method3904();
         class214.field2631 = 0;
         class72.field831 = null;
         UnitPriceComparator.field299 = null;
         class214.field2632 = null;
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1666491581"
   )
   public static void method4863() {
      try {
         class157.dat2File.close();

         for(int var0 = 0; var0 < class157.idxCount; ++var0) {
            class157.idxFiles[var0].close();
         }

         class157.idx255File.close();
         class157.randomDat.close();
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("hg")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "3"
   )
   static void method4864() {
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
   }
}
