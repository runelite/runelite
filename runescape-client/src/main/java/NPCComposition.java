import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jg")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljk;"
   )
   @Export("NpcDefinition_modelIndexCache")
   public static IndexDataBase NpcDefinition_modelIndexCache;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   @Export("npcs")
   static NodeCache npcs;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   @Export("npcModelCache")
   static NodeCache npcModelCache;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1601167265
   )
   @Export("id")
   public int id;
   @ObfuscatedName("y")
   @Export("name")
   public String name;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -355028971
   )
   public int field3709;
   @ObfuscatedName("s")
   @Export("models")
   int[] models;
   @ObfuscatedName("p")
   int[] field3711;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -416112657
   )
   public int field3712;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1761047091
   )
   public int field3713;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 2103826109
   )
   public int field3714;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -748946423
   )
   public int field3731;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1562318873
   )
   public int field3728;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 2118908521
   )
   public int field3717;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1647136099
   )
   public int field3734;
   @ObfuscatedName("v")
   @Export("colors")
   short[] colors;
   @ObfuscatedName("f")
   @Export("modifiedColors")
   short[] modifiedColors;
   @ObfuscatedName("b")
   short[] field3704;
   @ObfuscatedName("c")
   short[] field3720;
   @ObfuscatedName("j")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("l")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1484881117
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1403501475
   )
   @Export("widthScale")
   int widthScale;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 639559035
   )
   @Export("heightScale")
   int heightScale;
   @ObfuscatedName("a")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1248885263
   )
   int field3729;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1379362697
   )
   int field3730;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 272773657
   )
   public int field3721;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 21163599
   )
   public int field3722;
   @ObfuscatedName("as")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 915279981
   )
   @Export("varpIndex")
   int varpIndex;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1580892305
   )
   @Export("varp32Index")
   int varp32Index;
   @ObfuscatedName("af")
   public boolean field3718;
   @ObfuscatedName("ai")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("az")
   public boolean field3738;
   @ObfuscatedName("aq")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   IterableHashTable field3732;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.field3709 = 1;
      this.field3712 = -1;
      this.field3713 = -1;
      this.field3714 = -1;
      this.field3731 = -1;
      this.field3728 = -1;
      this.field3717 = -1;
      this.field3734 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.widthScale = 128;
      this.heightScale = 128;
      this.isVisible = false;
      this.field3729 = 0;
      this.field3730 = 0;
      this.field3721 = -1;
      this.field3722 = 32;
      this.varpIndex = -1;
      this.varp32Index = -1;
      this.field3718 = true;
      this.isClickable = true;
      this.field3738 = false;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-95320891"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "805712621"
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lgy;IB)V",
      garbageValue = "-98"
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
         this.field3709 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3712 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3731 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3713 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3714 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3731 = var1.readUnsignedShort();
         this.field3728 = var1.readUnsignedShort();
         this.field3717 = var1.readUnsignedShort();
         this.field3734 = var1.readUnsignedShort();
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
         this.field3704 = new short[var3];
         this.field3720 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3704[var4] = (short)var1.readUnsignedShort();
            this.field3720[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3711 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3711[var4] = var1.readUnsignedShort();
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
         this.field3729 = var1.readByte();
      } else if(var2 == 101) {
         this.field3730 = var1.readByte();
      } else if(var2 == 102) {
         this.field3721 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3722 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3718 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3738 = true;
         } else if(var2 == 249) {
            this.field3732 = class167.readStringIntParameters(var1, this.field3732);
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lki;ILki;II)Lel;",
      garbageValue = "679724154"
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
               var8[var9] = ModelData.method2660(NpcDefinition_modelIndexCache, this.models[var9], 0);
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

            if(this.field3704 != null) {
               for(var9 = 0; var9 < this.field3704.length; ++var9) {
                  var11.method2674(this.field3704[var9], this.field3720[var9]);
               }
            }

            var5 = var11.light(this.field3729 + 64, this.field3730 * 5 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method5288(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method5285(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method5285(var5, var4);
         } else {
            var10 = var5.method2756(true);
         }

         if(this.widthScale != 128 || this.heightScale != 128) {
            var10.scale(this.widthScale, this.heightScale, this.widthScale);
         }

         return var10;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)Ldf;",
      garbageValue = "476490646"
   )
   public final ModelData method5262() {
      if(this.configs != null) {
         NPCComposition var1 = this.transform();
         return var1 == null?null:var1.method5262();
      } else if(this.field3711 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3711.length; ++var2) {
            if(!NpcDefinition_modelIndexCache.tryLoadRecord(this.field3711[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3711.length];

            for(int var3 = 0; var3 < this.field3711.length; ++var3) {
               var6[var3] = ModelData.method2660(NpcDefinition_modelIndexCache, this.field3711[var3], 0);
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

            if(this.field3704 != null) {
               for(var4 = 0; var4 < this.field3704.length; ++var4) {
                  var7.method2674(this.field3704[var4], this.field3720[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)Ljg;",
      garbageValue = "-2111481204"
   )
   @Export("transform")
   public final NPCComposition transform() {
      int var1 = -1;
      if(this.varpIndex != -1) {
         var1 = class57.getVarbit(this.varpIndex);
      } else if(this.varp32Index != -1) {
         var1 = class237.widgetSettings[this.varp32Index];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class255.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-169970831"
   )
   public boolean method5232() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.varpIndex != -1) {
            var1 = class57.getVarbit(this.varpIndex);
         } else if(this.varp32Index != -1) {
            var1 = class237.widgetSettings[this.varp32Index];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-943700399"
   )
   public int method5233(int var1, int var2) {
      return class47.method699(this.field3732, var1, var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "0"
   )
   public String method5234(int var1, String var2) {
      return Huffman.method3512(this.field3732, var1, var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-2029586208"
   )
   public static int method5264() {
      return ++MouseInput.mouseIdleTicks - 1;
   }
}
