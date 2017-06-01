import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("id")
@Implements("NPCComposition")
public class NPCComposition extends CacheableNode {
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 815031273
   )
   public int field3545;
   @ObfuscatedName("c")
   public static IndexDataBase field3546;
   @ObfuscatedName("e")
   static NodeCache field3547;
   @ObfuscatedName("v")
   @Export("npcModelCache")
   static NodeCache npcModelCache;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 41566641
   )
   @Export("id")
   public int id;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 585010081
   )
   public int field3550;
   @ObfuscatedName("at")
   @Export("configs")
   public int[] configs;
   @ObfuscatedName("x")
   @Export("models")
   int[] models;
   @ObfuscatedName("f")
   int[] field3553;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -2073933291
   )
   int field3554;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1033571697
   )
   public int field3555;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -557132521
   )
   public int field3556;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1965925701
   )
   public int field3557;
   @ObfuscatedName("y")
   @Export("name")
   public String name;
   @ObfuscatedName("aw")
   public boolean field3559;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1292012463
   )
   public int field3560;
   @ObfuscatedName("r")
   short[] field3561;
   @ObfuscatedName("m")
   short[] field3562;
   @ObfuscatedName("d")
   short[] field3563;
   @ObfuscatedName("s")
   short[] field3564;
   @ObfuscatedName("g")
   @Export("actions")
   public String[] actions;
   @ObfuscatedName("w")
   @Export("isMinimapVisible")
   public boolean isMinimapVisible;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 743216505
   )
   @Export("combatLevel")
   public int combatLevel;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -104571301
   )
   int field3568;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -755847823
   )
   int field3569;
   @ObfuscatedName("t")
   @Export("isVisible")
   public boolean isVisible;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1651856515
   )
   int field3571;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 935387439
   )
   int field3572;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1283091181
   )
   public int field3573;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1620810135
   )
   public int field3574;
   @ObfuscatedName("i")
   public static IndexDataBase field3575;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1676775561
   )
   int field3576;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 651123681
   )
   public int field3577;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -150237371
   )
   public int field3578;
   @ObfuscatedName("al")
   @Export("isClickable")
   public boolean isClickable;
   @ObfuscatedName("ab")
   public boolean field3580;
   @ObfuscatedName("aa")
   class186 field3581;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1688328638"
   )
   void method4643() {
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-18"
   )
   void method4645(Buffer var1, int var2) {
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
         this.field3550 = var1.readUnsignedShort();
      } else if(var2 == 14) {
         this.field3557 = var1.readUnsignedShort();
      } else if(var2 == 15) {
         this.field3555 = var1.readUnsignedShort();
      } else if(var2 == 16) {
         this.field3556 = var1.readUnsignedShort();
      } else if(var2 == 17) {
         this.field3557 = var1.readUnsignedShort();
         this.field3578 = var1.readUnsignedShort();
         this.field3560 = var1.readUnsignedShort();
         this.field3545 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.actions[var2 - 30] = var1.readString();
         if(this.actions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.actions[var2 - 30] = null;
         }
      } else if(var2 == 40) {
         var3 = var1.readUnsignedByte();
         this.field3561 = new short[var3];
         this.field3562 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3561[var4] = (short)var1.readUnsignedShort();
            this.field3562[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 41) {
         var3 = var1.readUnsignedByte();
         this.field3563 = new short[var3];
         this.field3564 = new short[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3563[var4] = (short)var1.readUnsignedShort();
            this.field3564[var4] = (short)var1.readUnsignedShort();
         }
      } else if(var2 == 60) {
         var3 = var1.readUnsignedByte();
         this.field3553 = new int[var3];

         for(var4 = 0; var4 < var3; ++var4) {
            this.field3553[var4] = var1.readUnsignedShort();
         }
      } else if(var2 == 93) {
         this.isMinimapVisible = false;
      } else if(var2 == 95) {
         this.combatLevel = var1.readUnsignedShort();
      } else if(var2 == 97) {
         this.field3568 = var1.readUnsignedShort();
      } else if(var2 == 98) {
         this.field3569 = var1.readUnsignedShort();
      } else if(var2 == 99) {
         this.isVisible = true;
      } else if(var2 == 100) {
         this.field3571 = var1.readByte();
      } else if(var2 == 101) {
         this.field3572 = var1.readByte() * 5;
      } else if(var2 == 102) {
         this.field3573 = var1.readUnsignedShort();
      } else if(var2 == 103) {
         this.field3574 = var1.readUnsignedShort();
      } else if(var2 != 106 && var2 != 118) {
         if(var2 == 107) {
            this.field3559 = false;
         } else if(var2 == 109) {
            this.isClickable = false;
         } else if(var2 == 111) {
            this.field3580 = true;
         } else if(var2 == 249) {
            this.field3581 = class116.method2101(var1, this.field3581);
         }
      } else {
         this.field3576 = var1.readUnsignedShort();
         if(this.field3576 == '\uffff') {
            this.field3576 = -1;
         }

         this.field3554 = var1.readUnsignedShort();
         if(this.field3554 == '\uffff') {
            this.field3554 = -1;
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;II)LModel;",
      garbageValue = "-1106414643"
   )
   public final Model method4646(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.configs != null) {
         NPCComposition var12 = this.method4652();
         return var12 == null?null:var12.method4646(var1, var2, var3, var4);
      } else {
         Model var5 = (Model)npcModelCache.get((long)this.id);
         if(var5 == null) {
            boolean var10 = false;

            for(int var7 = 0; var7 < this.models.length; ++var7) {
               if(!field3546.method4111(this.models[var7], 0)) {
                  var10 = true;
               }
            }

            if(var10) {
               return null;
            }

            ModelData[] var8 = new ModelData[this.models.length];

            int var9;
            for(var9 = 0; var9 < this.models.length; ++var9) {
               var8[var9] = ModelData.method2427(field3546, this.models[var9], 0);
            }

            ModelData var11;
            if(var8.length == 1) {
               var11 = var8[0];
            } else {
               var11 = new ModelData(var8, var8.length);
            }

            if(this.field3561 != null) {
               for(var9 = 0; var9 < this.field3561.length; ++var9) {
                  var11.method2409(this.field3561[var9], this.field3562[var9]);
               }
            }

            if(this.field3563 != null) {
               for(var9 = 0; var9 < this.field3563.length; ++var9) {
                  var11.method2450(this.field3563[var9], this.field3564[var9]);
               }
            }

            var5 = var11.method2417(this.field3571 + 64, this.field3572 + 850, -30, -50, -30);
            npcModelCache.put(var5, (long)this.id);
         }

         Model var6;
         if(var1 != null && var3 != null) {
            var6 = var1.method4692(var5, var2, var3, var4);
         } else if(var1 != null) {
            var6 = var1.method4689(var5, var2);
         } else if(var3 != null) {
            var6 = var3.method4689(var5, var4);
         } else {
            var6 = var5.method2541(true);
         }

         if(this.field3568 != 128 || this.field3569 != 128) {
            var6.method2507(this.field3568, this.field3569, this.field3568);
         }

         return var6;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-442447868"
   )
   void method4647(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4645(var1, var2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "-121"
   )
   public final ModelData method4648() {
      if(this.configs != null) {
         NPCComposition var1 = this.method4652();
         return var1 == null?null:var1.method4648();
      } else if(this.field3553 == null) {
         return null;
      } else {
         boolean var5 = false;

         for(int var6 = 0; var6 < this.field3553.length; ++var6) {
            if(!field3546.method4111(this.field3553[var6], 0)) {
               var5 = true;
            }
         }

         if(var5) {
            return null;
         } else {
            ModelData[] var2 = new ModelData[this.field3553.length];

            for(int var3 = 0; var3 < this.field3553.length; ++var3) {
               var2[var3] = ModelData.method2427(field3546, this.field3553[var3], 0);
            }

            ModelData var7;
            if(var2.length == 1) {
               var7 = var2[0];
            } else {
               var7 = new ModelData(var2, var2.length);
            }

            int var4;
            if(this.field3561 != null) {
               for(var4 = 0; var4 < this.field3561.length; ++var4) {
                  var7.method2409(this.field3561[var4], this.field3562[var4]);
               }
            }

            if(this.field3563 != null) {
               for(var4 = 0; var4 < this.field3563.length; ++var4) {
                  var7.method2450(this.field3563[var4], this.field3564[var4]);
               }
            }

            return var7;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "-92"
   )
   public boolean method4649() {
      if(this.configs == null) {
         return true;
      } else {
         int var1 = -1;
         if(this.field3576 != -1) {
            var1 = FileOnDisk.method2363(this.field3576);
         } else if(this.field3554 != -1) {
            var1 = class211.widgetSettings[this.field3554];
         }

         return var1 >= 0 && var1 < this.configs.length?this.configs[var1] != -1:this.configs[this.configs.length - 1] != -1;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-417642234"
   )
   public int method4650(int var1, int var2) {
      return World.method1583(this.field3581, var1, var2);
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "635267630"
   )
   public String method4651(int var1, String var2) {
      return class35.method480(this.field3581, var1, var2);
   }

   static {
      field3547 = new NodeCache(64);
      npcModelCache = new NodeCache(50);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)LNPCComposition;",
      garbageValue = "207578238"
   )
   public final NPCComposition method4652() {
      int var1 = -1;
      if(this.field3576 != -1) {
         var1 = FileOnDisk.method2363(this.field3576);
      } else if(this.field3554 != -1) {
         var1 = class211.widgetSettings[this.field3554];
      }

      int var2;
      if(var1 >= 0 && var1 < this.configs.length - 1) {
         var2 = this.configs[var1];
      } else {
         var2 = this.configs[this.configs.length - 1];
      }

      return var2 != -1?class220.getNpcDefinition(var2):null;
   }

   NPCComposition() {
      this.name = "null";
      this.field3577 = 1;
      this.field3550 = -1;
      this.field3555 = -1;
      this.field3556 = -1;
      this.field3557 = -1;
      this.field3578 = -1;
      this.field3560 = -1;
      this.field3545 = -1;
      this.actions = new String[5];
      this.isMinimapVisible = true;
      this.combatLevel = -1;
      this.field3568 = 128;
      this.field3569 = 128;
      this.isVisible = false;
      this.field3571 = 0;
      this.field3572 = 0;
      this.field3573 = -1;
      this.field3574 = 32;
      this.field3576 = -1;
      this.field3554 = -1;
      this.field3559 = true;
      this.isClickable = true;
      this.field3580 = false;
   }
}
