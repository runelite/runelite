import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ir")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("npcModelCache")
   public static NodeCache npcModelCache;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("npcs")
   public static NodeCache npcs;
   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   public static IndexDataBase field3547;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lii;"
   )
   public static IndexDataBase field3570;
   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "Lgi;"
   )
   IterableHashTable field3582;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -483134467
   )
   @Export("varpIndex")
   int varpIndex;
   @ObfuscatedName("ad")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("n")
   @Export("name")
   public String name;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1359330985
   )
   @Export("varp32Index")
   int varp32Index;
   @ObfuscatedName("k")
   int[] field3569;
   @ObfuscatedName("b")
   @Export("models")
   int[] models;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -520624873
   )
   @Export("id")
   public int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 406766413
   )
   public int field3574;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -867537461
   )
   public int field3555;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 573289711
   )
   public int field3558;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1322939843
   )
   public int field3557;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1535676849
   )
   public int field3546;
   @ObfuscatedName("m")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1962786009
   )
   int field3556;
   @ObfuscatedName("z")
   @Export("colors")
   short[] colors;
   @ObfuscatedName("x")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -422840255
   )
   int field3572;
   @ObfuscatedName("e")
   short[] field3564;
   @ObfuscatedName("u")
   @Export("modifiedColors")
   short[] modifiedColors;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -721356743
   )
   public int field3559;
   @ObfuscatedName("p")
   short[] field3565;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 475217983
   )
   public int field3560;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -145122939
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("w")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 789282929
   )
   int field3573;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -668947397
   )
   public int field3561;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 399092953
   )
   int field3553;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1515574181
   )
   public int field3548;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1572474273
   )
   public int field3575;
   @ObfuscatedName("aq")
   public boolean field3579;
   @ObfuscatedName("at")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("az")
   public boolean field3581;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.field3574 = 1;
      this.field3555 = -1;
      this.field3557 = -1;
      this.field3546 = -1;
      this.field3558 = -1;
      this.field3559 = -1;
      this.field3560 = -1;
      this.field3561 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.field3556 = 128;
      this.field3572 = 128;
      this.isVisible = false;
      this.field3573 = 0;
      this.field3553 = 0;
      this.field3548 = -1;
      this.field3575 = 32;
      this.varpIndex = -1;
      this.varp32Index = -1;
      this.field3579 = true;
      this.isClickable = true;
      this.field3581 = false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(B)Lir;",
      garbageValue = "0"
   )
   @Export("transform")
   public final NPCComposition transform() {
      int var1 = -1;
      if(this.varpIndex != -1) {
         var1 = WidgetNode.method1121(this.varpIndex);
      } else if(this.varp32Index != -1) {
         var1 = class212.widgetSettings[this.varp32Index];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class171.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfp;II)V",
      garbageValue = "421106727"
   )
   void method4618(Buffer var1, int var2) {
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
         this.field3574 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3555 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3558 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3557 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3546 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3558 = var1.readUnsignedShort();
         this.field3559 = var1.readUnsignedShort();
         this.field3560 = var1.readUnsignedShort();
         this.field3561 = var1.readUnsignedShort();
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
         this.field3564 = new short[var3];
         this.field3565 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3564[var4] = (short)var1.readUnsignedShort();
            this.field3565[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3569 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3569[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3556 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3572 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3573 = var1.readByte();
      } else if(var2 == 101) {
         this.field3553 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3548 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3575 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3579 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3581 = true;
         } else if(var2 == 249) {
            this.field3582 = class34.method516(var1, this.field3582);
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)Lde;",
      garbageValue = "116"
   )
   public final ModelData method4620() {
      if(this.configs != null) {
         NPCComposition var1 = this.transform();
         return var1 == null?null:var1.method4620();
      } else if(this.field3569 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3569.length; ++var2) {
            if(!field3547.method4137(this.field3569[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3569.length];

            for(int var3 = 0; var3 < this.field3569.length; ++var3) {
               var6[var3] = ModelData.method2414(field3547, this.field3569[var3], 0);
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

            if(this.field3564 != null) {
               for(var4 = 0; var4 < this.field3564.length; ++var4) {
                  var7.method2465(this.field3564[var4], this.field3565[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljw;ILjw;II)Lem;",
      garbageValue = "1479801679"
   )
   public final Model method4619(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.configs != null) {
         NPCComposition var12 = this.transform();
         return var12 == null?null:var12.method4619(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field3547.method4137(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2414(field3547, this.models[var9], 0);
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

            if(this.field3564 != null) {
               for(var9 = 0; var9 < this.field3564.length; ++var9) {
                  var11.method2465(this.field3564[var9], this.field3565[var9]);
               }
            }

            var5 = var11.light(this.field3573 + 64, this.field3553 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method4670(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method4667(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method4667(var5, var4);
         } else {
            var10 = var5.method2511(true);
         }

         if(this.field3556 != 128 || this.field3572 != 128) {
            var10.method2550(this.field3556, this.field3572, this.field3556);
         }

         return var10;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1789486516"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lfp;I)V",
      garbageValue = "826944640"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4618(var1, var2);
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1489771440"
   )
   public boolean method4623() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.varpIndex != -1) {
            var1 = WidgetNode.method1121(this.varpIndex);
         } else if(this.varp32Index != -1) {
            var1 = class212.widgetSettings[this.varp32Index];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "2"
   )
   public String method4624(int var1, String var2) {
      return class43.method653(this.field3582, var1, var2);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "262431147"
   )
   public int method4639(int var1, int var2) {
      return class20.method174(this.field3582, var1, var2);
   }
}
