import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jn")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("NpcDefinition_indexCache")
   static IndexDataBase NpcDefinition_indexCache;
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lib;"
   )
   @Export("NpcDefinition_modelIndexCache")
   static IndexDataBase NpcDefinition_modelIndexCache;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   @Export("npcs")
   public static NodeCache npcs;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   @Export("npcModelCache")
   public static NodeCache npcModelCache;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1273015549
   )
   @Export("id")
   public int id;
   @ObfuscatedName("z")
   @Export("name")
   public String name;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1383073121
   )
   public int field3620;
   @ObfuscatedName("f")
   @Export("models")
   int[] models;
   @ObfuscatedName("g")
   int[] field3627;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1980631439
   )
   public int field3628;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 906944605
   )
   public int field3644;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 144793557
   )
   public int field3630;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 701748137
   )
   public int field3631;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1073676811
   )
   public int field3632;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 118930695
   )
   public int field3633;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -245114077
   )
   public int field3634;
   @ObfuscatedName("r")
   @Export("colors")
   short[] colors;
   @ObfuscatedName("i")
   @Export("modifiedColors")
   short[] modifiedColors;
   @ObfuscatedName("l")
   short[] field3636;
   @ObfuscatedName("m")
   short[] field3625;
   @ObfuscatedName("q")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("b")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -280231869
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1246817025
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2082676849
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("p")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1822590851
   )
   int field3645;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 659861717
   )
   int field3646;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -321409793
   )
   public int field3647;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1219747661
   )
   public int field3648;
   @ObfuscatedName("as")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -2002687013
   )
   @Export("varpIndex")
   int varpIndex;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1839748547
   )
   @Export("varp32Index")
   int varp32Index;
   @ObfuscatedName("at")
   public boolean field3643;
   @ObfuscatedName("ap")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("an")
   public boolean field3654;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   IterableHashTable field3619;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.field3620 = 1;
      this.field3628 = -1;
      this.field3644 = -1;
      this.field3630 = -1;
      this.field3631 = -1;
      this.field3632 = -1;
      this.field3633 = -1;
      this.field3634 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.isVisible = false;
      this.field3645 = 0;
      this.field3646 = 0;
      this.field3647 = -1;
      this.field3648 = 32;
      this.varpIndex = -1;
      this.varp32Index = -1;
      this.field3643 = true;
      this.isClickable = true;
      this.field3654 = false;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgh;B)V",
      garbageValue = "-72"
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Lgh;II)V",
      garbageValue = "617022094"
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
         this.field3620 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3628 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3631 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3644 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3630 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3631 = var1.readUnsignedShort();
         this.field3632 = var1.readUnsignedShort();
         this.field3633 = var1.readUnsignedShort();
         this.field3634 = var1.readUnsignedShort();
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
         this.field3636 = new short[var3];
         this.field3625 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3636[var4] = (short)var1.readUnsignedShort();
            this.field3625[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3627 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3627[var4] = var1.readUnsignedShort();
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
         this.field3645 = var1.readByte();
      } else if(var2 == 101) {
         this.field3646 = var1.readByte();
      } else if(var2 == 102) {
         this.field3647 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3648 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3643 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3654 = true;
         } else if(var2 == 249) {
            this.field3619 = ItemContainer.readStringIntParameters(var1, this.field3619);
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljj;ILjj;IB)Lef;",
      garbageValue = "1"
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
               var8[var9] = ModelData.method2428(NpcDefinition_modelIndexCache, this.models[var9], 0);
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

            if(this.field3636 != null) {
               for(var9 = 0; var9 < this.field3636.length; ++var9) {
                  var11.method2437(this.field3636[var9], this.field3625[var9]);
               }
            }

            var5 = var11.light(this.field3645 + 64, this.field3646 * 5 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method4847(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method4837(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method4837(var5, var4);
         } else {
            var10 = var5.method2509(true);
         }

         if(this.widthScale != 128 || this.heightScale != 128) {
            var10.scale(this.widthScale, this.heightScale, this.widthScale);
         }

         return var10;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)Ldm;",
      garbageValue = "1486517132"
   )
   public final ModelData method4775() {
      if(this.configs != null) {
         NPCComposition var1 = this.transform();
         return var1 == null?null:var1.method4775();
      } else if(this.field3627 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3627.length; ++var2) {
            if(!NpcDefinition_modelIndexCache.tryLoadRecord(this.field3627[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3627.length];

            for(int var3 = 0; var3 < this.field3627.length; ++var3) {
               var6[var3] = ModelData.method2428(NpcDefinition_modelIndexCache, this.field3627[var3], 0);
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

            if(this.field3636 != null) {
               for(var4 = 0; var4 < this.field3636.length; ++var4) {
                  var7.method2437(this.field3636[var4], this.field3625[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)Ljn;",
      garbageValue = "-762984959"
   )
   @Export("transform")
   public final NPCComposition transform() {
      int var1 = -1;
      if(this.varpIndex != -1) {
         var1 = class36.getVarbit(this.varpIndex);
      } else if(this.varp32Index != -1) {
         var1 = class222.widgetSettings[this.varp32Index];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?Client.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "80"
   )
   public boolean method4799() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.varpIndex != -1) {
            var1 = class36.getVarbit(this.varpIndex);
         } else if(this.varp32Index != -1) {
            var1 = class222.widgetSettings[this.varp32Index];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-948029054"
   )
   public int method4778(int var1, int var2) {
      return GraphicsObject.method1615(this.field3619, var1, var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "702806044"
   )
   public String method4779(int var1, String var2) {
      return class192.method3599(this.field3619, var1, var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lib;II)Lho;",
      garbageValue = "950996133"
   )
   static class218 method4770(IndexDataBase var0, int var1) {
      byte[] var2 = var0.takeRecordFlat(var1);
      return var2 == null?null:new class218(var2);
   }
}
