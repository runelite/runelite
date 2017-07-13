import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("r")
   @Export("npcModelCache")
   public static NodeCache npcModelCache;
   @ObfuscatedName("n")
   @Export("npcs")
   public static NodeCache npcs;
   @ObfuscatedName("a")
   public static IndexDataBase field3560;
   @ObfuscatedName("ag")
   class186 field3587;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 318797989
   )
   @Export("varpIndex")
   int varpIndex;
   @ObfuscatedName("ap")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("e")
   @Export("name")
   public String name;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1174762143
   )
   @Export("varp32Index")
   int varp32Index;
   @ObfuscatedName("w")
   int[] field3559;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1138261345
   )
   @Export("id")
   public int id;
   @ObfuscatedName("s")
   @Export("models")
   int[] models;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1284587661
   )
   public int field3557;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 180557999
   )
   public int field3562;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1586539257
   )
   public int field3563;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -233460809
   )
   public int field3561;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1114140747
   )
   public int field3572;
   @ObfuscatedName("z")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1649723739
   )
   int field3569;
   @ObfuscatedName("o")
   @Export("colors")
   short[] colors;
   @ObfuscatedName("i")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -524501765
   )
   int field3575;
   @ObfuscatedName("f")
   short[] field3564;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1547346107
   )
   public int field3576;
   @ObfuscatedName("x")
   @Export("modifiedColors")
   short[] modifiedColors;
   @ObfuscatedName("h")
   short[] field3570;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1369186453
   )
   public int field3565;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -798397791
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("y")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1965516063
   )
   public int field3583;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1680324183
   )
   int field3552;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1450163173
   )
   int field3578;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1868346767
   )
   public int field3579;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -315397467
   )
   public int field3580;
   @ObfuscatedName("aw")
   public boolean field3584;
   @ObfuscatedName("aq")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("aa")
   public boolean field3586;

   static {
      npcs = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.field3557 = 1;
      this.field3562 = -1;
      this.field3561 = -1;
      this.field3572 = -1;
      this.field3563 = -1;
      this.field3576 = -1;
      this.field3565 = -1;
      this.field3583 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.field3569 = 128;
      this.field3575 = 128;
      this.isVisible = false;
      this.field3552 = 0;
      this.field3578 = 0;
      this.field3579 = -1;
      this.field3580 = 32;
      this.varpIndex = -1;
      this.varp32Index = -1;
      this.field3584 = true;
      this.isClickable = true;
      this.field3586 = false;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)LNPCComposition;",
      garbageValue = "2106360692"
   )
   @Export("transform")
   public final NPCComposition transform() {
      int var1 = -1;
      if(this.varpIndex != -1) {
         var1 = class1.method3(this.varpIndex);
      } else if(this.varp32Index != -1) {
         var1 = class211.widgetSettings[this.varp32Index];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class224.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-41435342"
   )
   void method4569(Buffer var1, int var2) {
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
         this.field3557 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3562 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3563 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3561 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3572 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3563 = var1.readUnsignedShort();
         this.field3576 = var1.readUnsignedShort();
         this.field3565 = var1.readUnsignedShort();
         this.field3583 = var1.readUnsignedShort();
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
         this.field3570 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3564[var4] = (short)var1.readUnsignedShort();
            this.field3570[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3559 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3559[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3569 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3575 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3552 = var1.readByte();
      } else if(var2 == 101) {
         this.field3578 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3579 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3580 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3584 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3586 = true;
         } else if(var2 == 249) {
            this.field3587 = World.method1549(var1, this.field3587);
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-1347318813"
   )
   public final ModelData method4571() {
      if(this.configs != null) {
         NPCComposition var1 = this.transform();
         return var1 == null?null:var1.method4571();
      } else if(this.field3559 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3559.length; ++var2) {
            if(!class203.field2512.method4085(this.field3559[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3559.length];

            for(int var3 = 0; var3 < this.field3559.length; ++var3) {
               var6[var3] = ModelData.method2396(class203.field2512, this.field3559[var3], 0);
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
                  var7.method2410(this.field3564[var4], this.field3570[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "-1462771291"
   )
   public final Model method4570(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.configs != null) {
         NPCComposition var12 = this.transform();
         return var12 == null?null:var12.method4570(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!class203.field2512.method4085(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2396(class203.field2512, this.models[var9], 0);
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
                  var11.method2410(this.field3564[var9], this.field3570[var9]);
               }
            }

            var5 = var11.light(this.field3552 + 64, this.field3578 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method4620(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method4617(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method4617(var5, var4);
         } else {
            var10 = var5.method2495(true);
         }

         if(this.field3569 != 128 || this.field3575 != 128) {
            var10.method2524(this.field3569, this.field3575, this.field3569);
         }

         return var10;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "360007586"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "43"
   )
   @Export("decode")
   void decode(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4569(var1, var2);
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-1667064769"
   )
   public boolean method4578() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.varpIndex != -1) {
            var1 = class1.method3(this.varpIndex);
         } else if(this.varp32Index != -1) {
            var1 = class211.widgetSettings[this.varp32Index];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "5"
   )
   public int method4574(int var1, int var2) {
      return Timer.method2973(this.field3587, var1, var2);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "-61"
   )
   public String method4575(int var1, String var2) {
      return IndexFile.method3005(this.field3587, var1, var2);
   }
}
