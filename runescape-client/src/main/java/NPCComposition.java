import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iv")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("s")
   short[] field3543;
   @ObfuscatedName("u")
   static NodeCache field3544;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 675754989
   )
   public int field3545;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 486171537
   )
   @Export("id")
   public int id;
   @ObfuscatedName("q")
   @Export("npcModelCache")
   static NodeCache npcModelCache;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1557436655
   )
   public int field3548;
   @ObfuscatedName("aq")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("l")
   int[] field3550;
   @ObfuscatedName("h")
   public static IndexDataBase field3551;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 771702591
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -735791559
   )
   public int field3553;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1623046267
   )
   public int field3554;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1707751463
   )
   public int field3555;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1740318705
   )
   public int field3556;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -2063052161
   )
   public int field3557;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -158383713
   )
   int field3558;
   @ObfuscatedName("d")
   short[] field3559;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2019802153
   )
   public int field3560;
   @ObfuscatedName("p")
   @Export("models")
   int[] models;
   @ObfuscatedName("n")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("y")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1933516975
   )
   int field3564;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 52808863
   )
   int field3565;
   @ObfuscatedName("e")
   short[] field3566;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1431272905
   )
   int field3567;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 531546981
   )
   int field3568;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1995103429
   )
   int field3569;
   @ObfuscatedName("z")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1396087777
   )
   public int field3571;
   @ObfuscatedName("v")
   @Export("name")
   public String name;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1681482587
   )
   public int field3573;
   @ObfuscatedName("m")
   short[] field3574;
   @ObfuscatedName("ax")
   public boolean field3575;
   @ObfuscatedName("ad")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("av")
   public boolean field3577;
   @ObfuscatedName("ae")
   class186 field3578;
   @ObfuscatedName("kc")
   static Widget field3579;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1760263201"
   )
   void method4700() {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1071998666"
   )
   void method4701(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4721(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "-116062372"
   )
   public final Model method4703(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.configs != null) {
         NPCComposition var12 = this.method4705();
         return var12 == null?null:var12.method4703(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(var5 == null) {
            boolean var6 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field3551.method4176(this.models[var7], 0)) {
                  var6 = true;
               }
            }

            if(var6) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2443(field3551, this.models[var9], 0);
            }

            ModelData var11;
            if(var8.length == 1) {
               var11 = var8[0];
            } else {
               var11 = new ModelData(var8, var8.length);
            }

            if(this.field3574 != null) {
               for(var9 = 0; var9 < this.field3574.length; ++var9) {
                  var11.method2505(this.field3574[var9], this.field3559[var9]);
               }
            }

            if(this.field3566 != null) {
               for(var9 = 0; var9 < this.field3566.length; ++var9) {
                  var11.method2511(this.field3566[var9], this.field3543[var9]);
               }
            }

            var5 = var11.method2487(this.field3568 + 64, this.field3569 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var10;
         if(var1 != null && var3 != null) {
            var10 = var1.method4758(var5, var2, var3, var4);
         } else if(var1 != null) {
            var10 = var1.method4755(var5, var2);
         } else if(var3 != null) {
            var10 = var3.method4755(var5, var4);
         } else {
            var10 = var5.method2535(true);
         }

         if(this.field3565 != 128 || this.field3564 != 128) {
            var10.method2533(this.field3565, this.field3564, this.field3565);
         }

         return var10;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)LModelData;",
      garbageValue = "196743375"
   )
   public final ModelData method4704() {
      if(this.configs != null) {
         NPCComposition var1 = this.method4705();
         return var1 == null?null:var1.method4704();
      } else if(this.field3550 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var6 = 0; var6 < this.field3550.length; ++var6) {
            if(!field3551.method4176(this.field3550[var6], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var2 = new ModelData[this.field3550.length];

            for(int var7 = 0; var7 < this.field3550.length; ++var7) {
               var2[var7] = ModelData.method2443(field3551, this.field3550[var7], 0);
            }

            ModelData var3;
            if(var2.length == 1) {
               var3 = var2[0];
            } else {
               var3 = new ModelData(var2, var2.length);
            }

            int var4;
            if(this.field3574 != null) {
               for(var4 = 0; var4 < this.field3574.length; ++var4) {
                  var3.method2505(this.field3574[var4], this.field3559[var4]);
               }
            }

            if(this.field3566 != null) {
               for(var4 = 0; var4 < this.field3566.length; ++var4) {
                  var3.method2511(this.field3566[var4], this.field3543[var4]);
               }
            }

            return var3;
         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)LNPCComposition;",
      garbageValue = "-519883102"
   )
   public final NPCComposition method4705() {
      int var1 = -1;
      if(this.field3558 != -1) {
         var1 = Actor.method1539(this.field3558);
      } else if(this.field3567 != -1) {
         var1 = class211.widgetSettings[this.field3567];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class220.getNpcDefinition(var2):null;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-380409048"
   )
   public boolean method4706() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.field3558 != -1) {
            var1 = Actor.method1539(this.field3558);
         } else if(this.field3567 != -1) {
            var1 = class211.widgetSettings[this.field3567];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "2090693615"
   )
   public String method4708(int var1, String var2) {
      return KitDefinition.method4451(this.field3578, var1, var2);
   }

   static {
      field3544 = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   NPCComposition() {
      this.name = "null";
      this.field3548 = 1;
      this.field3560 = -1;
      this.field3573 = -1;
      this.field3553 = -1;
      this.field3554 = -1;
      this.field3555 = -1;
      this.field3556 = -1;
      this.field3545 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.field3565 = 128;
      this.field3564 = 128;
      this.isVisible = false;
      this.field3568 = 0;
      this.field3569 = 0;
      this.field3557 = -1;
      this.field3571 = 32;
      this.field3558 = -1;
      this.field3567 = -1;
      this.field3575 = true;
      this.isClickable = true;
      this.field3577 = false;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1332803133"
   )
   void method4721(Buffer var1, int var2) {
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
         this.field3548 = var1.readUnsignedByte();
      } else if(var2 == 13) {
         this.field3560 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3554 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3573 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3553 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3554 = var1.readUnsignedShort();
         this.field3555 = var1.readUnsignedShort();
         this.field3556 = var1.readUnsignedShort();
         this.field3545 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readString();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.field3574 = new short[var3];
         this.field3559 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3574[var4] = (short)var1.readUnsignedShort();
            this.field3559[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3566 = new short[var3];
         this.field3543 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3566[var4] = (short)var1.readUnsignedShort();
            this.field3543[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3550 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3550[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3565 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3564 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3568 = var1.readByte();
      } else if(var2 == 101) {
         this.field3569 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3557 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3571 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3575 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3577 = true;
         } else if(var2 == 249) {
            this.field3578 = Frames.method2913(var1, this.field3578);
         }
      } else {
         this.field3558 = var1.readUnsignedShort();
         if(this.field3558 == '\uffff') {
            this.field3558 = -1;
         }

         this.field3567 = var1.readUnsignedShort();
         if(this.field3567 == '\uffff') {
            this.field3567 = -1;
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "1563116866"
   )
   public int method4726(int var1, int var2) {
      return class169.method3168(this.field3578, var1, var2);
   }
}
