import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ic")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("b")
   short[] field3558;
   @ObfuscatedName("p")
   static IndexDataBase field3559;
   @ObfuscatedName("u")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("j")
   @Export("npcModelCache")
   public static NodeCache npcModelCache;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1633181053
   )
   @Export("id")
   public int id;
   @ObfuscatedName("m")
   @Export("name")
   public String name;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1993272853
   )
   public int field3564;
   @ObfuscatedName("z")
   @Export("models")
   int[] models;
   @ObfuscatedName("h")
   int[] field3566;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1055075985
   )
   int field3567;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1063829373
   )
   public int field3568;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1763574479
   )
   public int field3569;
   @ObfuscatedName("l")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1427753747
   )
   public int field3571;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1143247123
   )
   public int field3572;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1700394763
   )
   public int field3573;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 143549833
   )
   public int field3574;
   @ObfuscatedName("s")
   short[] field3575;
   @ObfuscatedName("v")
   short[] field3576;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1723805423
   )
   public int field3577;
   @ObfuscatedName("w")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1137261125
   )
   public int field3579;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 265531115
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -196947133
   )
   int field3581;
   @ObfuscatedName("ak")
   public boolean field3582;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -232138045
   )
   public int field3583;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 2073304899
   )
   int field3584;
   @ObfuscatedName("n")
   static IndexDataBase field3585;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1251163499
   )
   int field3586;
   @ObfuscatedName("t")
   short[] field3587;
   @ObfuscatedName("aw")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 600646091
   )
   int field3589;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1127483127
   )
   int field3590;
   @ObfuscatedName("at")
   public boolean field3591;
   @ObfuscatedName("au")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("i")
   public static NodeCache field3593;
   @ObfuscatedName("as")
   class186 field3594;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "926942881"
   )
   void method4663(Buffer var1, int var2) {
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
         this.field3577 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3574 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3579 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3568 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3569 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3579 = var1.readUnsignedShort();
         this.field3571 = var1.readUnsignedShort();
         this.field3572 = var1.readUnsignedShort();
         this.field3573 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readString();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.field3558 = new short[var3];
         this.field3575 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3558[var4] = (short)var1.readUnsignedShort();
            this.field3575[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3576 = new short[var3];
         this.field3587 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3576[var4] = (short)var1.readUnsignedShort();
            this.field3587[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3566 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3566[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3581 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3567 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3584 = var1.readByte();
      } else if(var2 == 101) {
         this.field3586 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3583 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3564 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3591 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3582 = true;
         } else if(var2 == 249) {
            this.field3594 = ChatMessages.method1795(var1, this.field3594);
         }
      } else {
         this.field3589 = var1.readUnsignedShort();
         if(this.field3589 == '\uffff') {
            this.field3589 = -1;
         }

         this.field3590 = var1.readUnsignedShort();
         if(this.field3590 == '\uffff') {
            this.field3590 = -1;
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;S)V",
      garbageValue = "6203"
   )
   void method4664(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4663(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "685314990"
   )
   public final Model method4665(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.configs != null) {
         NPCComposition var12 = this.method4685();
         return var12 == null?null:var12.method4665(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(var5 == null) {
            boolean var10 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field3559.method4127(this.models[var7], 0)) {
                  var10 = true;
               }
            }

            if(var10) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2416(field3559, this.models[var9], 0);
            }

            ModelData var11;
            if(var8.length == 1) {
               var11 = var8[0];
            } else {
               var11 = new ModelData(var8, var8.length);
            }

            if(this.field3558 != null) {
               for(var9 = 0; var9 < this.field3558.length; ++var9) {
                  var11.method2490(this.field3558[var9], this.field3575[var9]);
               }
            }

            if(this.field3576 != null) {
               for(var9 = 0; var9 < this.field3576.length; ++var9) {
                  var11.method2430(this.field3576[var9], this.field3587[var9]);
               }
            }

            var5 = var11.method2437(this.field3584 + 64, this.field3586 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var6;
         if(var1 != null && var3 != null) {
            var6 = var1.method4721(var5, var2, var3, var4);
         } else if(var1 != null) {
            var6 = var1.method4718(var5, var2);
         } else if(var3 != null) {
            var6 = var3.method4718(var5, var4);
         } else {
            var6 = var5.method2511(true);
         }

         if(this.field3581 != 128 || this.field3567 != 128) {
            var6.method2527(this.field3581, this.field3567, this.field3581);
         }

         return var6;
      }
   }

   NPCComposition() {
      this.name = "null";
      this.field3577 = 1;
      this.field3574 = -1;
      this.field3568 = -1;
      this.field3569 = -1;
      this.field3579 = -1;
      this.field3571 = -1;
      this.field3572 = -1;
      this.field3573 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.field3581 = 128;
      this.field3567 = 128;
      this.isVisible = false;
      this.field3584 = 0;
      this.field3586 = 0;
      this.field3583 = -1;
      this.field3564 = 32;
      this.field3589 = -1;
      this.field3590 = -1;
      this.field3591 = true;
      this.isClickable = true;
      this.field3582 = false;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)[LModIcon;",
      garbageValue = "-1144263685"
   )
   static ModIcon[] method4666() {
      ModIcon[] var0 = new ModIcon[class286.field3792];

      for(int var1 = 0; var1 < class286.field3792; ++var1) {
         ModIcon var2 = var0[var1] = new ModIcon();
         var2.width = NPC.field1377;
         var2.originalHeight = class286.field3791;
         var2.offsetX = class95.field1493[var1];
         var2.offsetY = class286.field3790[var1];
         var2.originalWidth = class286.field3793[var1];
         var2.height = class241.field3293[var1];
         var2.palette = class174.field2410;
         var2.pixels = class31.field449[var1];
      }

      VertexNormal.method2592();
      return var0;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-52"
   )
   public boolean method4667() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.field3589 != -1) {
            var1 = class205.method3843(this.field3589);
         } else if(this.field3590 != -1) {
            var1 = class211.widgetSettings[this.field3590];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "55"
   )
   public int method4668(int var1, int var2) {
      return class243.method4341(this.field3594, var1, var2);
   }

   static {
      field3593 = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-106996509"
   )
   public final ModelData method4675() {
      if(this.configs != null) {
         NPCComposition var1 = this.method4685();
         return var1 == null?null:var1.method4675();
      } else if(this.field3566 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var2 = 0; var2 < this.field3566.length; ++var2) {
            if(!field3559.method4127(this.field3566[var2], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3566.length];

            for(int var7 = 0; var7 < this.field3566.length; ++var7) {
               var6[var7] = ModelData.method2416(field3559, this.field3566[var7], 0);
            }

            ModelData var3;
            if(var6.length == 1) {
               var3 = var6[0];
            } else {
               var3 = new ModelData(var6, var6.length);
            }

            int var4;
            if(this.field3558 != null) {
               for(var4 = 0; var4 < this.field3558.length; ++var4) {
                  var3.method2490(this.field3558[var4], this.field3575[var4]);
               }
            }

            if(this.field3576 != null) {
               for(var4 = 0; var4 < this.field3576.length; ++var4) {
                  var3.method2430(this.field3576[var4], this.field3587[var4]);
               }
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1735521581"
   )
   void method4678() {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "589522047"
   )
   public String method4682(int var1, String var2) {
      return class204.method3838(this.field3594, var1, var2);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)LNPCComposition;",
      garbageValue = "-1907293126"
   )
   public final NPCComposition method4685() {
      int var1 = -1;
      if(this.field3589 != -1) {
         var1 = class205.method3843(this.field3589);
      } else if(this.field3590 != -1) {
         var1 = class211.widgetSettings[this.field3590];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class217.getNpcDefinition(var2):null;
   }
}
