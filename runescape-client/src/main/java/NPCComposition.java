import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ie")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("d")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("l")
   short[] field3554;
   @ObfuscatedName("m")
   static IndexDataBase field3555;
   @ObfuscatedName("r")
   short[] field3556;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1783599695
   )
   @Export("id")
   public int id;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -762826523
   )
   public int field3558;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -986488077
   )
   public int field3559;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1544402913
   )
   public int field3560;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1460388671
   )
   int field3561;
   @ObfuscatedName("z")
   @Export("name")
   public String name;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 945180297
   )
   public int field3563;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1447484277
   )
   public int field3564;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2074016435
   )
   public int field3565;
   @ObfuscatedName("i")
   @Export("models")
   int[] models;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1273873781
   )
   public int field3567;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -805852043
   )
   public int field3568;
   @ObfuscatedName("s")
   short[] field3569;
   @ObfuscatedName("f")
   int[] field3570;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 658343235
   )
   int field3571;
   @ObfuscatedName("ar")
   public boolean field3572;
   @ObfuscatedName("h")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("k")
   short[] field3574;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1115982751
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -405566391
   )
   int field3576;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -827932849
   )
   int field3577;
   @ObfuscatedName("u")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 2050978431
   )
   int field3579;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -149858895
   )
   int field3580;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 113244675
   )
   public int field3581;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1169075943
   )
   public int field3582;
   @ObfuscatedName("ap")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("p")
   static IndexDataBase field3584;
   @ObfuscatedName("e")
   static NodeCache field3585;
   @ObfuscatedName("ab")
   public boolean field3586;
   @ObfuscatedName("am")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("t")
   @Export("npcModelCache")
   static NodeCache npcModelCache;
   @ObfuscatedName("ao")
   class186 field3589;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1861882951"
   )
   void method4511() {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "488426769"
   )
   void method4513(Buffer var1, int var2) {
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
         this.field3559 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3558 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3565 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3563 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3564 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3565 = var1.readUnsignedShort();
         this.field3560 = var1.readUnsignedShort();
         this.field3567 = var1.readUnsignedShort();
         this.field3568 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readString();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.field3569 = new short[var3];
         this.field3574 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3569[var4] = (short)var1.readUnsignedShort();
            this.field3574[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3556 = new short[var3];
         this.field3554 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3556[var4] = (short)var1.readUnsignedShort();
            this.field3554[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3570 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3570[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3576 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3577 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3579 = var1.readByte();
      } else if(var2 == 101) {
         this.field3580 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3581 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3582 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3586 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3572 = true;
         } else if(var2 == 249) {
            this.field3589 = class172.method3016(var1, this.field3589);
         }
      } else {
         this.field3571 = var1.readUnsignedShort();
         if(this.field3571 == '\uffff') {
            this.field3571 = -1;
         }

         this.field3561 = var1.readUnsignedShort();
         if(this.field3561 == '\uffff') {
            this.field3561 = -1;
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "1972692508"
   )
   public final Model method4514(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.configs != null) {
         NPCComposition var11 = this.method4525();
         return var11 == null?null:var11.method4514(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field3555.method3997(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var12 = new ModelData[this.models.length];

            int var8;
            for(var8 = 0; var8 < this.models.length; ++var8) {
               var12[var8] = ModelData.method2310(field3555, this.models[var8], 0);
            }

            ModelData var9;
            if(var12.length == 1) {
               var9 = var12[0];
            } else {
               var9 = new ModelData(var12, var12.length);
            }

            if(this.field3569 != null) {
               for(var8 = 0; var8 < this.field3569.length; ++var8) {
                  var9.method2322(this.field3569[var8], this.field3574[var8]);
               }
            }

            if(this.field3556 != null) {
               for(var8 = 0; var8 < this.field3556.length; ++var8) {
                  var9.method2320(this.field3556[var8], this.field3554[var8]);
               }
            }

            var5 = var9.light(this.field3579 + 64, this.field3580 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method4585(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method4578(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method4578(var5, var4);
         } else {
            var10 = var5.method2393(true);
         }

         if(this.field3576 != 128 || this.field3577 != 128) {
            var10.method2409(this.field3576, this.field3577, this.field3576);
         }

         return var10;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1987558053"
   )
   public boolean method4517() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.field3571 != -1) {
            var1 = class50.method728(this.field3571);
         } else if(this.field3561 != -1) {
            var1 = class211.widgetSettings[this.field3561];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "84"
   )
   public int method4518(int var1, int var2) {
      return Script.method1758(this.field3589, var1, var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "4"
   )
   public String method4519(int var1, String var2) {
      return class165.method2965(this.field3589, var1, var2);
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "-1473109940"
   )
   public final ModelData method4520() {
      if(this.configs != null) {
         NPCComposition var5 = this.method4525();
         return var5 == null?null:var5.method4520();
      } else if(this.field3570 == null) {
         return null;
      } else {
         boolean var1 = false;

         for(int var2 = 0; var2 < this.field3570.length; ++var2) {
            if(!field3555.method3997(this.field3570[var2], 0)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            ModelData[] var6 = new ModelData[this.field3570.length];

            for(int var3 = 0; var3 < this.field3570.length; ++var3) {
               var6[var3] = ModelData.method2310(field3555, this.field3570[var3], 0);
            }

            ModelData var7;
            if(var6.length == 1) {
               var7 = var6[0];
            } else {
               var7 = new ModelData(var6, var6.length);
            }

            int var4;
            if(this.field3569 != null) {
               for(var4 = 0; var4 < this.field3569.length; ++var4) {
                  var7.method2322(this.field3569[var4], this.field3574[var4]);
               }
            }

            if(this.field3556 != null) {
               for(var4 = 0; var4 < this.field3556.length; ++var4) {
                  var7.method2320(this.field3556[var4], this.field3554[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)LNPCComposition;",
      garbageValue = "-1266911967"
   )
   public final NPCComposition method4525() {
      int var1 = -1;
      if(this.field3571 != -1) {
         var1 = class50.method728(this.field3571);
      } else if(this.field3561 != -1) {
         var1 = class211.widgetSettings[this.field3561];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class158.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "594496052"
   )
   void method4534(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4513(var1, var2);
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-73"
   )
   public static void method4541() {
      Object var0 = class236.field3239;
      Object var1 = class236.field3239;
      Object var2 = class236.field3239;
      synchronized(class236.field3239) {
         if(class236.field3241 != 0) {
            class236.field3241 = 1;

            try {
               class236.field3239.wait();
            } catch (InterruptedException var5) {
               ;
            }
         }

      }
   }

   NPCComposition() {
      this.name = "null";
      this.field3559 = 1;
      this.field3558 = -1;
      this.field3563 = -1;
      this.field3564 = -1;
      this.field3565 = -1;
      this.field3560 = -1;
      this.field3567 = -1;
      this.field3568 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.field3576 = 128;
      this.field3577 = 128;
      this.isVisible = false;
      this.field3579 = 0;
      this.field3580 = 0;
      this.field3581 = -1;
      this.field3582 = 32;
      this.field3571 = -1;
      this.field3561 = -1;
      this.field3586 = true;
      this.isClickable = true;
      this.field3572 = false;
   }

   static {
      field3585 = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }
}
