import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("npcModelCache")
   public static NodeCache npcModelCache;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgq;"
   )
   @Export("npcs")
   public static NodeCache npcs;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   static IndexDataBase field3542;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lit;"
   )
   static IndexDataBase field3544;
   @ObfuscatedName("av")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   IterableHashTable field3577;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1165187641
   )
   @Export("varpIndex")
   int varpIndex;
   @ObfuscatedName("ao")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("k")
   @Export("name")
   public String name;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 129368479
   )
   @Export("varp32Index")
   int varp32Index;
   @ObfuscatedName("r")
   int[] field3555;
   @ObfuscatedName("z")
   @Export("models")
   int[] models;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 648323189
   )
   @Export("id")
   public int id;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2035791401
   )
   public int field3547;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1213244413
   )
   public int field3550;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -175653435
   )
   public int field3553;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -2065970151
   )
   public int field3551;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -633537293
   )
   public int field3546;
   @ObfuscatedName("f")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1528030439
   )
   int field3564;
   @ObfuscatedName("m")
   @Export("colors")
   short[] colors;
   @ObfuscatedName("b")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1279014563
   )
   int field3565;
   @ObfuscatedName("t")
   short[] field3549;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -800329109
   )
   public int field3554;
   @ObfuscatedName("a")
   @Export("modifiedColors")
   short[] modifiedColors;
   @ObfuscatedName("p")
   short[] field3560;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 449611369
   )
   public int field3548;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1490659373
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("q")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1370021699
   )
   public int field3556;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1438795315
   )
   int field3567;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -896367393
   )
   int field3568;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1157233047
   )
   public int field3569;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1853017965
   )
   public int field3570;
   @ObfuscatedName("ax")
   public boolean field3574;
   @ObfuscatedName("az")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("aw")
   public boolean field3559;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.field3547 = 1;
      this.field3550 = -1;
      this.field3551 = -1;
      this.field3546 = -1;
      this.field3553 = -1;
      this.field3554 = -1;
      this.field3548 = -1;
      this.field3556 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.field3564 = 128;
      this.field3565 = 128;
      this.isVisible = false;
      this.field3567 = 0;
      this.field3568 = 0;
      this.field3569 = -1;
      this.field3570 = 32;
      this.varpIndex = -1;
      this.varp32Index = -1;
      this.field3574 = true;
      this.isClickable = true;
      this.field3559 = false;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(B)Lin;",
      garbageValue = "-13"
   )
   @Export("transform")
   public final NPCComposition transform() {
      int var1 = -1;
      if(this.varpIndex != -1) {
         var1 = class209.method3887(this.varpIndex);
      } else if(this.varp32Index != -1) {
         var1 = class212.widgetSettings[this.varp32Index];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class19.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lfh;II)V",
      garbageValue = "-1719715052"
   )
   void method4659(Buffer var1, int var2) {
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
         this.field3547 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3550 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3553 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3551 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3546 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3553 = var1.readUnsignedShort();
         this.field3554 = var1.readUnsignedShort();
         this.field3548 = var1.readUnsignedShort();
         this.field3556 = var1.readUnsignedShort();
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
         this.field3549 = new short[var3];
         this.field3560 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3549[var4] = (short)var1.readUnsignedShort();
            this.field3560[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3555 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3555[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3564 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3565 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3567 = var1.readByte();
      } else if(var2 == 101) {
         this.field3568 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3569 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3570 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3574 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3559 = true;
         } else if(var2 == 249) {
            this.field3577 = XItemContainer.method1083(var1, this.field3577);
         }
      } else {
         this.varpIndex = var1.readUnsignedShort();
         if(this.varpIndex == '\uffff') {
            this.varpIndex = -1;
         }

         this.varp32Index = var1.readUnsignedShort();
         if(this.varp32Index == '\uffff') {
            this.varp32Index = -1;
         }

         var3 = -1;
         if(var2 == 118) {
            var3 = var1.readUnsignedShort();
            if(var3 == '\uffff') {
               var3 = -1;
            }
         }

         var4 = var1.readUnsignedByte();
         this.configs = new int[var4 + 2];

         for(int var5 = 0; var5 <= var4; ++var5) {
            this.configs[var5] = var1.readUnsignedShort();
            if(this.configs[var5] == '\uffff') {
               this.configs[var5] = -1;
            }
         }

         this.configs[var4 + 1] = var3;
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Ldn;",
      garbageValue = "119957699"
   )
   public final ModelData method4661() {
      if(this.configs != null) {
         NPCComposition var1 = this.transform();
         return var1 == null?null:var1.method4661();
      } else if(this.field3555 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3555.length; ++var2) {
            if(!field3542.method4116(this.field3555[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3555.length];

            for(int var3 = 0; var3 < this.field3555.length; ++var3) {
               var6[var3] = ModelData.method2434(field3542, this.field3555[var3], 0);
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

            if(this.field3549 != null) {
               for(var4 = 0; var4 < this.field3549.length; ++var4) {
                  var7.method2447(this.field3549[var4], this.field3560[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljd;ILjd;II)Lew;",
      garbageValue = "1331296323"
   )
   public final Model method4660(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.configs != null) {
         NPCComposition var12 = this.transform();
         return var12 == null?null:var12.method4660(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field3542.method4116(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2434(field3542, this.models[var9], 0);
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

            if(this.field3549 != null) {
               for(var9 = 0; var9 < this.field3549.length; ++var9) {
                  var11.method2447(this.field3549[var9], this.field3560[var9]);
               }
            }

            var5 = var11.light(this.field3567 + 64, this.field3568 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method4718(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method4715(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method4715(var5, var4);
         } else {
            var10 = var5.method2608(true);
         }

         if(this.field3564 != 128 || this.field3565 != 128) {
            var10.method2531(this.field3564, this.field3565, this.field3564);
         }

         return var10;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2092100282"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lfh;I)V",
      garbageValue = "-727705043"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4659(var1, var2);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1995093850"
   )
   public boolean method4692() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.varpIndex != -1) {
            var1 = class209.method3887(this.varpIndex);
         } else if(this.varp32Index != -1) {
            var1 = class212.widgetSettings[this.varp32Index];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1852481790"
   )
   public int method4664(int var1, int var2) {
      return class34.method494(this.field3577, var1, var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1882495824"
   )
   public String method4681(int var1, String var2) {
      return class169.method3148(this.field3577, var1, var2);
   }
}
